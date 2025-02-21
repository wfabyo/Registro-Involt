package com.pedido.dto;

import java.util.List;
import lombok.Data;

@Data
public class PedidoResponseDto {
    private String pedidoId;
    private List<ItemDto> itens;
}
