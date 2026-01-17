package com.precojusto.repository;

import com.precojusto.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda,Long> {
    List<Venda> findByDataBetwenn(
            LocalDateTime inicio,
            LocalDateTime fim
    );

    List<Venda> findByDataVendaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
}