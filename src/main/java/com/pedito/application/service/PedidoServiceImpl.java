package com.pedito.application.service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.pedito.application.port.in.PedidoUseCase;
import com.pedito.application.port.out.PedidoPersistencePort;
import com.pedito.domain.model.Pedido;
import com.pedito.dto.PedidoDto;
import com.pedito.dto.PedidoResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PedidoServiceImpl implements PedidoUseCase {

    private final PedidoPersistencePort pedidoPersistencePort;
    private final RestTemplate restTemplate;

    @Value("${pedido.api.url}")
    private String pedidoApiUrl;

    public PedidoServiceImpl(PedidoPersistencePort pedidoPersistencePort) {
        this.pedidoPersistencePort = pedidoPersistencePort;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public PedidoResponseDto processarPedido(PedidoDto pedidoDto) {
        List<Pedido.Item> itens = pedidoDto.getProdutos().stream()
                .map(dto -> new Pedido.Item(dto.getProduto(), dto.getQuantidade()))
                .collect(Collectors.toList());
        Pedido pedido = new Pedido(pedidoDto.getClienteId(), itens);

        if (pedido.totalUnidades() < 1000) {
            throw new IllegalArgumentException("Pedido inválido para envio. Total mínimo de 1000 unidades não atingido.");
        }

        PedidoResponseDto resposta = enviarPedido(pedidoDto);

        // Persistir o pedido (mesmo em caso de fallback, para reprocessamento futuro)
        pedidoPersistencePort.save(pedido);

        return resposta;
    }

    //Implementada a chamada externa para a API nesta classe por falta de tempo para extrair para outra classe.
    private PedidoResponseDto enviarPedido(PedidoDto pedidoDto) {
        // Chamada externa para a API
        PedidoResponseDto resposta;
        try {
            HttpEntity<PedidoDto> request = new HttpEntity<>(pedidoDto);
            resposta = restTemplate.exchange(pedidoApiUrl,
                    HttpMethod.POST,
                    request,
                    PedidoResponseDto.class).getBody();

            if (resposta == null) {
                resposta = realizarFallback(pedidoDto);
            }
        } catch (Exception ex) {
            resposta = realizarFallback(pedidoDto);
        }
        return resposta;
    }

    private PedidoResponseDto realizarFallback(PedidoDto pedidoDto) {
        PedidoResponseDto fallback = new PedidoResponseDto();
        fallback.setPedidoId(UUID.randomUUID().toString());
        fallback.setItens(pedidoDto.getProdutos());
        return fallback;
    }
}