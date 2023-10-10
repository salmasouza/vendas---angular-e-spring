package io.github.salmasouza.Vendas.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tbl_servico")
public class ServicoPrestado implements Serializable {

    /**
     *
     */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150,name = "servico_descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "servico_valor")
    private BigDecimal valor;

    @Column(name ="servico_data")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;


    public ServicoPrestado() {
    }

    public ServicoPrestado(Long id, String descricao, Cliente cliente, BigDecimal valor, LocalDate data) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.valor = valor;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoPrestado servico = (ServicoPrestado) o;
        return Objects.equals(id, servico.id);
    }

    @Override
    public String toString() {
        return "ServicoPrestado{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", cliente=" + cliente +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
