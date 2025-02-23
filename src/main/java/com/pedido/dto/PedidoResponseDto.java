package com.pedido.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoResponseDto {
    private String pedidoId;
    private List<ItemDto> itens;
}
