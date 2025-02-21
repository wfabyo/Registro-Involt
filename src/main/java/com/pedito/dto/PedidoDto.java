package com.pedito.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;

@Data
public class PedidoDto {
    @NotBlank(message = "Identificação do cliente é obrigatória.")
    private String clienteId;

    @NotEmpty(message = "A lista de produtos não pode estar vazia.")
    private List<ItemDto> produtos;
}
