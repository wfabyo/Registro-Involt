package com.pedito.adapter.persistence;

import com.pedito.adapter.persistence.entity.PedidoEntity;
import com.pedito.adapter.persistence.mapper.PedidoMapper;
import com.pedito.adapter.persistence.repository.PedidoRepository;
import com.pedito.application.port.out.PedidoPersistencePort;
import com.pedito.domain.model.Pedido;
import org.springframework.stereotype.Component;


@Component
public class PedidoPersistenceAdapter implements PedidoPersistencePort {
    private final PedidoRepository pedidoRepository;

    public PedidoPersistenceAdapter(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity entity = PedidoMapper.toEntity(pedido);
        PedidoEntity savedEntity = pedidoRepository.save(entity);
        return PedidoMapper.toDomain(savedEntity);
    }
}
