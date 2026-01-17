package com.precojusto.repository;

import com.precojusto.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    boolean existsByCpf(String cpf);
    boolean existsByMatricula(String matricula);

}

