package com.precojusto.repository;

import com.precojusto.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
    boolean existsByCpf(String cpf);
    boolean existsByMatricula(String matricula);
}
