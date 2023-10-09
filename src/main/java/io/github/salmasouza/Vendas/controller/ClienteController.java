package io.github.salmasouza.Vendas.controller;

import io.github.salmasouza.Vendas.model.Cliente;
import io.github.salmasouza.Vendas.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository =  clienteRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
   }


    @GetMapping
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();

    }
   @GetMapping("/{id}")
    public Optional<Cliente> acharPorId(@PathVariable Long id){
        return clienteRepository.findById(id);

   }

   @DeleteMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        clienteRepository
                .findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
   }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@RequestBody @Valid  Cliente clienteAtualizado, @PathVariable Long id){
       clienteRepository
               .findById(id)
               .map(cliente -> {

                   //cliente.setNome(clienteAtualizado.getNome());
                   //cliente.setCpf(clienteAtualizado.getCpf());
                   clienteAtualizado.setId(cliente.getId());
                   return clienteRepository.save(clienteAtualizado);
               })
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
   }


}
