package com.pedido.adapter.persistence;

import com.pedido.adapter.persistence.entity.PedidoEntity;
import com.pedido.adapter.persistence.mapper.PedidoMapper;
import com.pedido.adapter.persistence.repository.PedidoRepository;
import com.pedido.application.port.out.PedidoPersistencePort;
import com.pedido.domain.model.Pedido;
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
