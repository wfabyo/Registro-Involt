package com.pedido.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoDto {
    @NotBlank(message = "Identificação do cliente é obrigatória.")
    private String clienteId;

    @NotEmpty(message = "A lista de produtos não pode estar vazia.")
    private List<ItemDto> produtos;
}
