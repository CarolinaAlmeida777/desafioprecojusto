package com.precojusto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pato {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Integer quantidadeFilhos;
    private Double preco;
    private Boolean vendido = false;

    @ManyToOne
    private Pato mae;

    public Pato(Object o, String pato, int i, double v, boolean b, Object o1) {
    }

    @PrePersist
    void calcularPreco() {
        if (quantidadeFilhos == null || quantidadeFilhos == 0) preco = 70.0;
        else if (quantidadeFilhos == 1) preco = 50.0;
        else preco = 25.0;
    }
}
