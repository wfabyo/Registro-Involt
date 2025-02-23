package com.pedido.application.service;


import java.util.List;
import java.util.stream.Collectors;

import com.pedido.application.port.in.PedidoUseCase;
import com.pedido.application.port.out.EnviarPedidoApi;
import com.pedido.application.port.out.PedidoPersistencePort;
import com.pedido.domain.model.Pedido;
import com.pedido.dto.PedidoDto;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoUseCase {

    private final PedidoPersistencePort pedidoPersistencePort;
    private final EnviarPedidoApi enviarPedidoApi;

    public PedidoServiceImpl(PedidoPersistencePort pedidoPersistencePort, EnviarPedidoApi enviarPedidoApi) {
        this.pedidoPersistencePort = pedidoPersistencePort;
        this.enviarPedidoApi = enviarPedidoApi;
    }

    @Override
    public Pedido processarPedido(PedidoDto pedidoDto) {
        List<Pedido.Item> itens = pedidoDto.getProdutos().stream()
                .map(dto -> new Pedido.Item(dto.getProduto(), dto.getQuantidade()))
                .collect(Collectors.toList());
        Pedido pedido = new Pedido(pedidoDto.getClienteId(), itens);

        if (pedido.totalUnidades() < 1000) {
            throw new IllegalArgumentException("Pedido inválido para envio. Total mínimo de 1000 unidades não atingido.");
        }

        try {
            enviarPedidoApi.enviarPedido(pedidoDto);
            pedido.confirmar();
        } catch (Exception e) {
            //TODO: Implementar fallback
        } finally {
            // Persistir o pedido (mesmo em caso de fallback, para reprocessamento futuro)
            pedidoPersistencePort.save(pedido);
        }

        return pedido;
    }
}