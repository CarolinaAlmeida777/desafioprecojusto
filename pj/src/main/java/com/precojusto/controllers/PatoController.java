package com.precojusto.controllers;

import com.precojusto.entity.Pato;
import org.springframework.web.bind.annotation.*;
import com.precojusto.repository.PatoRepository;

import java.util.List;

@RestController
@RequestMapping("/patos")
public class PatoController {
    private final PatoRepository repo;
    public PatoController(PatoRepository r){this.repo=r;}
    @PostMapping
    public Pato salvar(@RequestBody Pato p){return repo.save(p);}
    @GetMapping
    public List<Pato> listar(){return repo.findAll();}
}
