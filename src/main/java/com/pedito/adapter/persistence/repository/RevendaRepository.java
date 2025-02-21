package com.pedito.adapter.persistence.repository;

import com.pedito.adapter.persistence.entity.RevendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevendaRepository extends JpaRepository<RevendaEntity, Long> {
}