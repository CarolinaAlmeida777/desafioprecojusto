package com.precojusto.repository;

import com.precojusto.entity.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemVendaRepository extends JpaRepository<ItemVenda,Long> {
    boolean existsByPatoId(Long patoId);

}
