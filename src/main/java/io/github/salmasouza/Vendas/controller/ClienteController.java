package io.github.salmasouza.Vendas.controller;

import io.github.salmasouza.Vendas.model.Cliente;
import io.github.salmasouza.Vendas.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository =  clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
   }


}
