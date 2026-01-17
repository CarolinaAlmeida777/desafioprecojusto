package com.precojusto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private Boolean possuiDesconto;

    public Cliente(Object o, String cliente, boolean b) {
    }
}
