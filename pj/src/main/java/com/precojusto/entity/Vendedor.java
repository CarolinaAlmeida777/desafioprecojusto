package com.precojusto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "cpf"),
        @UniqueConstraint(columnNames = "matricula")
})
public class Vendedor {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String cpf;
    private String matricula;

    public Vendedor(Object o, String vendedor, String number, String mat2) {
    }
}
