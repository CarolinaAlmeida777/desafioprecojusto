package com.precojusto.repository;

import com.precojusto.entity.Pato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatoRepository extends JpaRepository<Pato,Long> {
    boolean existsByCpf(String cpf);
    boolean existsByMatricula(String matricula);
}


