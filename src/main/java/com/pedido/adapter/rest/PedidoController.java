package com.pedido.adapter.rest;

import com.pedido.application.port.in.PedidoUseCase;
import com.pedido.domain.model.Pedido;
import com.pedido.dto.PedidoDto;
import com.pedido.dto.PedidoResponseDto;
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
    public ResponseEntity<Pedido> processarPedido(@Valid @RequestBody PedidoDto pedidoDTO) {
        Pedido pedido = pedidoUseCase.processarPedido(pedidoDTO);
        return ResponseEntity.ok(pedido);
    }
}
