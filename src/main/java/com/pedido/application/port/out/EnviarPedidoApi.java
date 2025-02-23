package com.pedido.application.port.out;

import com.pedido.dto.PedidoDto;
import com.pedido.dto.PedidoResponseDto;

public interface EnviarPedidoApi {
    PedidoResponseDto enviarPedido(PedidoDto pedido) throws Exception;
}
