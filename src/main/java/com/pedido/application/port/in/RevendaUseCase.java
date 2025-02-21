package com.pedido.application.port.in;

import com.pedido.domain.model.Revenda;
import com.pedido.dto.RevendaDto;

import java.util.List;

public interface RevendaUseCase {
    Revenda cadastrarRevenda(RevendaDto revendaDTO);
    List<Revenda> listarRevendas();
}
