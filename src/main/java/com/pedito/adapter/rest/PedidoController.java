package com.pedito.adapter.rest;

import com.pedito.application.port.in.PedidoUseCase;
import com.pedito.dto.PedidoDto;
import com.pedito.dto.PedidoResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    public PedidoController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> processarPedido(@Valid @RequestBody PedidoDto pedidoDTO) {
        PedidoResponseDto resposta = pedidoUseCase.processarPedido(pedidoDTO);
        return ResponseEntity.ok(resposta);
    }
}
