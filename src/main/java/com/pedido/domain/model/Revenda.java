package com.pedido.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Revenda {
    private Long id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String email;
    private List<String> telefones;
    private String contatoPrincipal;
    private List<String> enderecos;

    public Revenda(Long id, String cnpj, String razaoSocial, String nomeFantasia, String email,
                   List<String> telefones, String contatoPrincipal, List<String> enderecos) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.email = email;
        this.telefones = telefones;
        this.contatoPrincipal = contatoPrincipal;
        this.enderecos = enderecos;
    }

    public Revenda(String cnpj, String razaoSocial, String nomeFantasia, String email,
                   List<String> telefones, String contatoPrincipal, List<String> enderecos) {
        this(null, cnpj, razaoSocial, nomeFantasia, email, telefones, contatoPrincipal, enderecos);
    }

}

