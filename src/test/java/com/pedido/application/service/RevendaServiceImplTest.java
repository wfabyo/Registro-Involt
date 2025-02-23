package com.pedido.application.service;

import com.pedido.application.port.out.RevendaPersistencePort;
import com.pedido.domain.model.Revenda;
import com.pedido.dto.RevendaDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RevendaServiceImplTest {

    @Mock
    private RevendaPersistencePort revendaPersistencePort;

    @InjectMocks
    private RevendaServiceImpl revendaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void cadastrarRevenda_ShouldSaveAndReturnRevenda() {
        RevendaDto revendaDto = new RevendaDto(
                "12345678000100",
                "Razao Social",
                "Nome Fantasia",
                "email@example.com",
                Arrays.asList("123456789", "987654321"),
                "Contato Principal",
                Arrays.asList("Endereco 1", "Endereco 2")
        );

        Revenda revenda = new Revenda(
                "12345678000100",
                "Razao Social",
                "Nome Fantasia",
                "email@example.com",
                Arrays.asList("123456789", "987654321"),
                "Contato Principal",
                Arrays.asList("Endereco 1", "Endereco 2")
        );

        when(revendaPersistencePort.save(any(Revenda.class))).thenReturn(revenda);

        Revenda result = revendaService.cadastrarRevenda(revendaDto);

        assertNotNull(result);
        assertEquals("12345678000100", result.getCnpj());
        verify(revendaPersistencePort, times(1)).save(any(Revenda.class));
    }

    @Test
    void listarRevendas_ShouldReturnListOfRevendas() {
        Revenda revenda1 = new Revenda(
                "12345678000100",
                "Razao Social 1",
                "Nome Fantasia 1",
                "email1@example.com",
                Arrays.asList("123456789", "987654321"),
                "Contato Principal 1",
                Arrays.asList("Endereco 1", "Endereco 2")
        );

        Revenda revenda2 = new Revenda(
                "22345678000100",
                "Razao Social 2",
                "Nome Fantasia 2",
                "email2@example.com",
                Arrays.asList("223456789", "287654321"),
                "Contato Principal 2",
                Arrays.asList("Endereco 3", "Endereco 4")
        );

        when(revendaPersistencePort.findAll()).thenReturn(Arrays.asList(revenda1, revenda2));

        List<Revenda> result = revendaService.listarRevendas();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(revendaPersistencePort, times(1)).findAll();
    }
}
