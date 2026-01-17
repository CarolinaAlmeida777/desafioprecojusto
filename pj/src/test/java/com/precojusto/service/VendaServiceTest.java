package com.precojusto.service;



import com.precojusto.dto.VendaDTO;
import com.precojusto.entity.Cliente;
import com.precojusto.entity.Pato;
import com.precojusto.entity.Venda;
import com.precojusto.entity.Vendedor;
import com.precojusto.repository.ClienteRepository;
import com.precojusto.repository.PatoRepository;
import com.precojusto.repository.VendaRepository;
import com.precojusto.repository.VendedorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class VendaServiceTest {

    @Autowired
    private VendaService vendaService;

    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private VendedorRepository vendedorRepository;

    @MockBean
    private PatoRepository patoRepository;

    @MockBean
    private VendaRepository vendaRepository;

    @Test
    void deveAplicarDesconto() {

        Cliente cliente = new Cliente(1L, "Cliente", true);
        Vendedor vendedor = new Vendedor(1L, "Vendedor", "123", "MAT1");
        Pato pato = new Pato(1L, "Pato", 0, 70.0, false, null);
        pato.setId(1L);
        pato.setPreco(56.0);

        when(clienteRepository.findById(1L))
                .thenReturn(Optional.of(cliente));

        when(vendedorRepository.findById(1L))
                .thenReturn(Optional.of(vendedor));

        when(patoRepository.findById(1L))
                .thenReturn(Optional.of(pato));

        when(vendaRepository.save(any(Venda.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        VendaDTO dto = new VendaDTO(1L, 1L, List.of(1L));

        Venda venda = vendaService.realizarVenda(dto);

        assertEquals(56.0, venda.getValorTotal());
    }
}
