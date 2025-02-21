package com.pedito.application.port.in;

import com.pedito.domain.model.Revenda;
import com.pedito.dto.RevendaDto;

import java.util.List;

public interface RevendaUseCase {
    Revenda cadastrarRevenda(RevendaDto revendaDTO);
    List<Revenda> listarRevendas();
}
