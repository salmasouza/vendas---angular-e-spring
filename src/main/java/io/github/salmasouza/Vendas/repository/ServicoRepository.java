package io.github.salmasouza.Vendas.repository;

import io.github.salmasouza.Vendas.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
