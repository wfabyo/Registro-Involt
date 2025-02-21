package com.pedito.adapter.persistence.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "revendas")
public class RevendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String nomeFantasia;

    @Column(nullable = false)
    private String email;

    @ElementCollection
    @CollectionTable(name = "revenda_telefones", joinColumns = @JoinColumn(name = "revenda_id"))
    @Column(name = "telefone")
    private List<String> telefones;

    @Column(nullable = false)
    private String contatoPrincipal;

    @ElementCollection
    @CollectionTable(name = "revenda_enderecos", joinColumns = @JoinColumn(name = "revenda_id"))
    @Column(name = "endereco")
    private List<String> enderecos;

    public RevendaEntity() {
    }

}
