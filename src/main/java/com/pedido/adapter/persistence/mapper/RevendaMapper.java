package com.pedido.adapter.persistence.mapper;

import com.pedido.adapter.persistence.entity.RevendaEntity;
import com.pedido.domain.model.Revenda;

public class RevendaMapper {

    public static RevendaEntity toEntity(Revenda revenda) {
        RevendaEntity entity = new RevendaEntity();
        entity.setId(revenda.getId());
        entity.setCnpj(revenda.getCnpj());
        entity.setRazaoSocial(revenda.getRazaoSocial());
        entity.setNomeFantasia(revenda.getNomeFantasia());
        entity.setEmail(revenda.getEmail());
        entity.setTelefones(revenda.getTelefones());
        entity.setContatoPrincipal(revenda.getContatoPrincipal());
        entity.setEnderecos(revenda.getEnderecos());
        return entity;
    }

    public static Revenda toDomain(RevendaEntity entity) {
        return new Revenda(
                entity.getId(),
                entity.getCnpj(),
                entity.getRazaoSocial(),
                entity.getNomeFantasia(),
                entity.getEmail(),
                entity.getTelefones(),
                entity.getContatoPrincipal(),
                entity.getEnderecos()
        );
    }
}
