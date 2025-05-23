package com.pedido.adapter.rest;

import java.util.List;

import com.pedido.application.port.in.RevendaUseCase;
import com.pedido.domain.model.Revenda;
import com.pedido.dto.RevendaDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/revendas")
public class RevendaController {

    private final RevendaUseCase revendaUseCase;

    public RevendaController(RevendaUseCase revendaUseCase) {
        this.revendaUseCase = revendaUseCase;
    }

    @PostMapping
    public ResponseEntity<Revenda> cadastrarRevenda(@Valid @RequestBody RevendaDto revendaDTO) {
        Revenda revenda = revendaUseCase.cadastrarRevenda(revendaDTO);
        return ResponseEntity.ok(revenda);
    }

    @GetMapping
    public ResponseEntity<List<Revenda>> listarRevendas() {
        List<Revenda> revendas = revendaUseCase.listarRevendas();
        return ResponseEntity.ok(revendas);
    }
}
