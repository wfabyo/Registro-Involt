package com.pedido.adapter.persistence.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PedidoItemEmbeddable {

    private String produto;
    private int quantidade;

    public PedidoItemEmbeddable(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

}
