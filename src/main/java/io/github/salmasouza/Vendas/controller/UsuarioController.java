package io.github.salmasouza.Vendas.controller;

import io.github.salmasouza.Vendas.model.Usuario;
import io.github.salmasouza.Vendas.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;


    public UsuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
