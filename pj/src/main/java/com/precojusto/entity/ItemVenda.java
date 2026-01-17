package com.precojusto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemVenda {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Pato pato;

    private Double valor;
}
