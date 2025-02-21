package com.pedido.adapter.persistence.mapper;

import com.pedido.adapter.persistence.entity.PedidoEntity;
import com.pedido.adapter.persistence.entity.PedidoItemEmbeddable;
import com.pedido.domain.model.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoEntity toEntity(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();
        entity.setId(pedido.getId());
        entity.setClienteId(pedido.getClienteId());
        List<PedidoItemEmbeddable> itens = pedido.getItens().stream()
                .map(item -> new PedidoItemEmbeddable(item.getProduto(), item.getQuantidade()))
                .collect(Collectors.toList());
        entity.setItens(itens);
        entity.setPedidoExternoId(pedido.getPedidoExternoId());
        return entity;
    }

    public static Pedido toDomain(PedidoEntity entity) {
        List<Pedido.Item> itens = entity.getItens().stream()
                .map(item -> new Pedido.Item(item.getProduto(), item.getQuantidade()))
                .collect(Collectors.toList());
        Pedido pedido = new Pedido(entity.getId(), entity.getClienteId(), itens);
        pedido.setPedidoExternoId(entity.getPedidoExternoId());
        return pedido;
    }
}
