package io.github.salmasouza.Vendas.controller;

import io.github.salmasouza.Vendas.controller.dto.ServicoPrestadoDTO;
import io.github.salmasouza.Vendas.model.Cliente;
import io.github.salmasouza.Vendas.model.ServicoPrestado;
import io.github.salmasouza.Vendas.repository.ClienteRepository;
import io.github.salmasouza.Vendas.repository.ServicoPrestadoRepository;
import io.github.salmasouza.Vendas.util.BigDecimalConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private ClienteRepository clienteRepository;
    private ServicoPrestadoRepository servicoPrestadoRepository;

    private BigDecimalConverter bigDecimalConverter;

    public ServicoPrestadoController(ServicoPrestadoRepository servicoPrestadoRepository, ClienteRepository clienteRepository, BigDecimalConverter bigDecimalConverter){
        this.servicoPrestadoRepository = servicoPrestadoRepository;
        this.clienteRepository = clienteRepository;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Long idCliente = dto.getIdCliente();

        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        Cliente cliente = clienteOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return servicoPrestadoRepository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
            ){
        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
}
