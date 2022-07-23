package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {
  // List<Cozinha> consultarPorNome(String nome);
  List<Cozinha> findByNomeContaining(String nome);

  boolean existsByNome(String nome);
}
