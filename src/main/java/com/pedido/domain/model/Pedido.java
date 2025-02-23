package com.pedido.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Pedido {
    private Long id;
    private String clienteId;
    private List<Item> itens;
    private String pedidoExternoId;
    private Boolean confirmado = false;

    public Pedido(Long id, String clienteId, List<Item> itens) {
        this.id = id;
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public Pedido(String clienteId, List<Item> itens) {
        this(null, clienteId, itens);
    }

    public int totalUnidades() {
        return itens.stream().mapToInt(Item::getQuantidade).sum();
    }

    public void confirmar() {
        this.confirmado = true;
    }

    public Boolean isConfirmado() {
        return this.confirmado;
    }

    @Setter
    @Getter
    public static class Item {
        private String produto;
        private int quantidade;

        public Item(String produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

    }
}
