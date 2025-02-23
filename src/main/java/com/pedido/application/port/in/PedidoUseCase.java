package com.pedido.application.port.in;

import com.pedido.domain.model.Pedido;
import com.pedido.dto.PedidoDto;

public interface PedidoUseCase {
    Pedido processarPedido(PedidoDto pedidoDTO);
}
