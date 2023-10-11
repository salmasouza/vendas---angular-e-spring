package io.github.salmasouza.Vendas.controller.dto;

import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ServicoPrestadoDTO {


    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;
    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String preco;
    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String data;

    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Long idCliente;

    public ServicoPrestadoDTO() {
    }

    public ServicoPrestadoDTO(String descricao, String preco, String data, Long idCliente) {
        this.descricao = descricao;
        this.preco = preco;
        this.data = data;
        this.idCliente = idCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicoPrestadoDTO that = (ServicoPrestadoDTO) o;
        return Objects.equals(descricao, that.descricao) && Objects.equals(preco, that.preco) && Objects.equals(data, that.data) && Objects.equals(idCliente, that.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, preco, data, idCliente);
    }

    @Override
    public String toString() {
        return "ServicoPrestadoDTO{" +
                "descricao='" + descricao + '\'' +
                ", preco='" + preco + '\'' +
                ", data='" + data + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}