package com.pedido.application.port.out;

import com.pedido.domain.model.Pedido;

public interface PedidoPersistencePort {
    Pedido save(Pedido pedido);
}
