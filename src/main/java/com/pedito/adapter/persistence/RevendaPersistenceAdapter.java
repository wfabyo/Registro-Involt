package com.pedito.adapter.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pedito.adapter.persistence.entity.RevendaEntity;
import com.pedito.adapter.persistence.mapper.RevendaMapper;
import com.pedito.adapter.persistence.repository.RevendaRepository;
import com.pedito.application.port.out.RevendaPersistencePort;
import com.pedito.domain.model.Revenda;
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
