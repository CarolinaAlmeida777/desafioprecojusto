package com.precojusto.controllers;

import com.precojusto.entity.Cliente;
import org.springframework.web.bind.annotation.*;
import com.precojusto.repository.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository repo;
    public ClienteController(ClienteRepository r){this.repo=r;}
    @PostMapping
    public Cliente salvar(@RequestBody Cliente c){return repo.save(c);}
    @GetMapping
    public List<Cliente> listar(){return repo.findAll();}
}
