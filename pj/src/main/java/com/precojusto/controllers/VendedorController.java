package com.precojusto.controllers;

import com.precojusto.entity.Vendedor;
import org.springframework.web.bind.annotation.*;
import com.precojusto.repository.VendedorRepository;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    private final VendedorRepository repo;
    public VendedorController(VendedorRepository r){this.repo=r;}

    @PostMapping
    public Vendedor salvar(@RequestBody Vendedor v){return repo.save(v);}
    @GetMapping
    public List<Vendedor> listar(){return repo.findAll();}
}
