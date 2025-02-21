package com.pedito.application.port.out;

import com.pedito.domain.model.Pedido;

public interface PedidoPersistencePort {
    Pedido save(Pedido pedido);
}
