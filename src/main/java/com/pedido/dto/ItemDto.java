package com.pedido.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemDto {
    @NotBlank(message = "O identificador do produto é obrigatório")
    private String produto;

    @Min(value = 1, message = "A quantidade deve ser pelo menos 1")
    private int quantidade;
}