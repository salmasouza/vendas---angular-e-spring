package io.github.salmasouza.Vendas.controller;

import io.github.salmasouza.Vendas.repository.ClienteRepository;
import io.github.salmasouza.Vendas.service.ServicoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vendas")
public class ServicoController {

    private ServicoService servicoService;

    public ServicoController( ServicoService servicoService){
        this.servicoService =  servicoService;
    }
}
