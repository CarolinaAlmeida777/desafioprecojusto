package com.precojusto.controllers;

import com.precojusto.entity.Venda;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.precojusto.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService service;
    public VendaController(VendaService s){this.service=s;}

    @PostMapping
    public Venda vender(@RequestBody Venda v){return service.vender(v);}
}
