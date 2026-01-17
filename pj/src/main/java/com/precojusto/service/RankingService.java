package com.precojusto.service;

import com.precojusto.entity.ItemVenda;
import com.precojusto.entity.Venda;
import org.springframework.stereotype.Service;
import com.precojusto.repository.VendaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final VendaRepository vendaRepository;

    public RankingService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Map<String, Double> rankingPorValor(
            LocalDateTime dataInicio,
            LocalDateTime dataFim,
            Boolean vendido
    ) {

        List<Venda> vendas = vendaRepository.findByDataVendaBetween(
                dataInicio,
                dataFim
        );

        return vendas.stream()
                .flatMap(venda -> venda.getItens().stream())
                .filter(item -> vendido == null
                        || item.getPato().getVendido().equals(vendido))
                .collect(Collectors.groupingBy(
                        item -> item.getVenda()
                                .getVendedor()
                                .getNome(),
                        Collectors.summingDouble(ItemVenda::getValor)
                ));
    }
}