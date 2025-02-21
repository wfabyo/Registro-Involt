package com.pedido.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;

@Data
public class RevendaDto {
    @NotBlank(message = "CNPJ é obrigatório")
    private String cnpj;

    @NotBlank(message = "Razão Social é obrigatória")
    private String razaoSocial;

    @NotBlank(message = "Nome Fantasia é obrigatório")
    private String nomeFantasia;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    private List<@NotBlank(message = "Telefone não pode ser vazio") String> telefones;

    @NotBlank(message = "Contato principal é obrigatório")
    private String contatoPrincipal;

    private List<@NotBlank(message = "Endereço não pode ser vazio") String> enderecos;
}
