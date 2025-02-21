package com.pedito.application.port.in;

import com.pedito.dto.PedidoDto;
import com.pedito.dto.PedidoResponseDto;

public interface PedidoUseCase {
    PedidoResponseDto processarPedido(PedidoDto pedidoDTO);
}
