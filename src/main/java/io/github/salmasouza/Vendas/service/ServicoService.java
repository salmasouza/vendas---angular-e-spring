package io.github.salmasouza.Vendas.service;

import io.github.salmasouza.Vendas.repository.ClienteRepository;
import io.github.salmasouza.Vendas.repository.ServicoRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    private ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepository =  servicoRepository;
    }



}
