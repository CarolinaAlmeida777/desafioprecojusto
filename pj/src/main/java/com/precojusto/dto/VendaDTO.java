package com.precojusto.dto;

import com.precojusto.entity.Cliente;
import com.precojusto.entity.Vendedor;

import java.util.List;

public record VendaDTO(
        Long clienteId,
        Long vendedorId,
        List<Long> patosIds
) {
}
