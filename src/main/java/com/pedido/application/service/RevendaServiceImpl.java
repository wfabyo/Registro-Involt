package com.pedido.application.service;

import java.util.List;

import com.pedido.application.port.in.RevendaUseCase;
import com.pedido.application.port.out.RevendaPersistencePort;
import com.pedido.domain.model.Revenda;
import com.pedido.dto.RevendaDto;
import org.springframework.stereotype.Service;

@Service
public class RevendaServiceImpl implements RevendaUseCase {

    private final RevendaPersistencePort revendaPersistencePort;

    public RevendaServiceImpl(RevendaPersistencePort revendaPersistencePort) {
        this.revendaPersistencePort = revendaPersistencePort;
    }

    @Override
    public Revenda cadastrarRevenda(RevendaDto revendaDTO) {
        Revenda revenda = new Revenda(
                revendaDTO.getCnpj(),
                revendaDTO.getRazaoSocial(),
                revendaDTO.getNomeFantasia(),
                revendaDTO.getEmail(),
                revendaDTO.getTelefones(),
                revendaDTO.getContatoPrincipal(),
                revendaDTO.getEnderecos()
        );
        return revendaPersistencePort.save(revenda);
    }

    @Override
    public List<Revenda> listarRevendas() {
        return revendaPersistencePort.findAll();
    }
}
