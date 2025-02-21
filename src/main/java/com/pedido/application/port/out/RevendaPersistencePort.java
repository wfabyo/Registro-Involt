package com.pedido.application.port.out;

import com.pedido.domain.model.Revenda;

import java.util.List;
import java.util.Optional;

public interface RevendaPersistencePort {
    Revenda save(Revenda revenda);
    List<Revenda> findAll();
    Optional<Revenda> findById(Long id);
}
