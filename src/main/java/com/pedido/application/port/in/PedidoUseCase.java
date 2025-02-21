package com.pedido.application.port.in;

import com.pedido.dto.PedidoDto;
import com.pedido.dto.PedidoResponseDto;

public interface PedidoUseCase {
    PedidoResponseDto processarPedido(PedidoDto pedidoDTO);
}
