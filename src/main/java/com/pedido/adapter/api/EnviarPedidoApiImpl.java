package com.pedido.adapter.api;

import com.pedido.application.port.out.EnviarPedidoApi;
import com.pedido.dto.PedidoDto;
import com.pedido.dto.PedidoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class EnviarPedidoApiImpl implements EnviarPedidoApi {

    @Value("${pedido.api.url}")
    private String pedidoApiUrl;

    private final RestTemplate restTemplate;

    @Override
    public PedidoResponseDto enviarPedido(PedidoDto pedido) throws Exception {
        PedidoResponseDto resposta;

        HttpEntity<PedidoDto> request = new HttpEntity<>(pedido);
        resposta = restTemplate.exchange(pedidoApiUrl,
                HttpMethod.POST,
                request,
                PedidoResponseDto.class).getBody();

        if (resposta == null) {
            throw new Exception("Erro ao enviar pedido");
        }

        return resposta;
    }
}
