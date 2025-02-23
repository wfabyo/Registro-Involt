package com.pedido.application.service;

import com.pedido.application.port.out.EnviarPedidoApi;
import com.pedido.application.port.out.PedidoPersistencePort;
import com.pedido.domain.model.Pedido;
import com.pedido.dto.ItemDto;
import com.pedido.dto.PedidoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceImplTest {

    @Mock
    private PedidoPersistencePort pedidoPersistencePort;

    @Mock
    private EnviarPedidoApi enviarPedidoApi;

    @InjectMocks
    private PedidoServiceImpl pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processarPedido_ShouldThrowException_WhenTotalUnidadesIsLessThan1000() {
        PedidoDto pedidoDto = new PedidoDto("cliente1", Arrays.asList(
                new ItemDto("produto1", 500),
                new ItemDto("produto2", 400)
        ));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            pedidoService.processarPedido(pedidoDto);
        });

        assertEquals("Pedido inválido para envio. Total mínimo de 1000 unidades não atingido.", exception.getMessage());
    }

    @Test
    void processarPedido_ShouldProcessAndSavePedido_WhenTotalUnidadesIsGreaterThanOrEqualTo1000() throws Exception {
        PedidoDto pedidoDto = new PedidoDto("cliente1", Arrays.asList(
                new ItemDto("produto1", 600),
                new ItemDto("produto2", 500)
        ));

        when(enviarPedidoApi.enviarPedido(pedidoDto)).thenReturn(any());

        Pedido pedido = pedidoService.processarPedido(pedidoDto);

        assertTrue(pedido.isConfirmado());
        verify(enviarPedidoApi, times(1)).enviarPedido(pedidoDto);
        verify(pedidoPersistencePort, times(1)).save(pedido);
    }
}
