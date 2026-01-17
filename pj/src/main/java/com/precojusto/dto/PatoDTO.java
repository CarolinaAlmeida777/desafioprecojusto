package com.precojusto.dto;

public record PatoDTO(
        Long id,
        String nome,
        Integer quantidadeFilhos,
        Boolean vendido,
        Long maeId
) {}

