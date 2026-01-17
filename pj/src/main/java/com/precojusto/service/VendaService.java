package com.precojusto.service;


import com.precojusto.dto.VendaDTO;
import com.precojusto.entity.*;
import com.precojusto.exception.RegraNegocioException;
import com.precojusto.repository.ClienteRepository;
import com.precojusto.repository.PatoRepository;
import com.precojusto.repository.VendaRepository;
import com.precojusto.repository.VendedorRepository;
import org.springframework.stereotype.Service;

@Service
public class VendaService {


    private final VendaRepository vendaRepo;
    private final PatoRepository patoRepo;
    private final ClienteRepository clienteRepo;
    private final VendedorRepository vendedorRepo;

    public VendaService(
            VendaRepository vendaRepo,
            PatoRepository patoRepo,
            ClienteRepository clienteRepo,
            VendedorRepository vendedorRepo
    ) {
        this.vendaRepo = vendaRepo;
        this.patoRepo = patoRepo;
        this.clienteRepo = clienteRepo;
        this.vendedorRepo = vendedorRepo;
    }

    public Venda realizarVenda(VendaDTO dto) {

        Cliente cliente = clienteRepo.findById(dto.clienteId())
                .orElseThrow(() -> new RegraNegocioException("Cliente não encontrado"));

        Vendedor vendedor = vendedorRepo.findById(dto.vendedorId())
                .orElseThrow(() -> new RegraNegocioException("Vendedor não encontrado"));

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setVendedor(vendedor);

        double somaPrecos = 0.0;

        for (Long id : dto.patosIds()) {
            Pato pato = patoRepo.findById(id)
                    .orElseThrow(() -> new RegraNegocioException("Pato não encontrado"));

            ItemVenda item = new ItemVenda();
            item.setPato(pato);
            item.setVenda(venda);
            venda.getItens().add(item);

            somaPrecos += pato.getPreco();
        }


        venda.setValorTotal(somaPrecos);

        return vender(venda);
    }

    public Venda vender(Venda venda) {
        return vendaRepo.save(venda);
    }
}