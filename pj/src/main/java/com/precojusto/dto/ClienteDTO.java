package com.precojusto.dto;

public record ClienteDTO(
        Long id,
        String nome,
        Boolean possuiDesconto
) {}
