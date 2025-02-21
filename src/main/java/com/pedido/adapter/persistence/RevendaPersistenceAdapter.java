package com.pedido.adapter.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pedido.adapter.persistence.entity.RevendaEntity;
import com.pedido.adapter.persistence.mapper.RevendaMapper;
import com.pedido.adapter.persistence.repository.RevendaRepository;
import com.pedido.application.port.out.RevendaPersistencePort;
import com.pedido.domain.model.Revenda;
import org.springframework.stereotype.Component;

@Component
public class RevendaPersistenceAdapter implements RevendaPersistencePort {

    private final RevendaRepository revendaRepository;

    public RevendaPersistenceAdapter(RevendaRepository revendaRepository) {
        this.revendaRepository = revendaRepository;
    }

    @Override
    public Revenda save(Revenda revenda) {
        RevendaEntity entity = RevendaMapper.toEntity(revenda);
        RevendaEntity savedEntity = revendaRepository.save(entity);
        return RevendaMapper.toDomain(savedEntity);
    }

    @Override
    public List<Revenda> findAll() {
        List<RevendaEntity> entities = revendaRepository.findAll();
        return entities.stream()
                .map(RevendaMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Revenda> findById(Long id) {
        return revendaRepository.findById(id)
                .map(RevendaMapper::toDomain);
    }
}
