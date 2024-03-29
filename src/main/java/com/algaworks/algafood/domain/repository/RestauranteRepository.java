package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.algaworks.algafood.domain.model.Restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>,
        RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {


          @Query("from Restaurante r join r.cozinha left  join fetch r.formasPagamento")
          List<Restaurante> findAll();  
  // List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long
  // cozinha);

  // @Query("from Restaurante where nome like %:nome% and cozinha.id =:id")
  List<Restaurante> ConsultarPorNome(String nome, @Param("id") Long cozinha);

  List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

  // passando flag first
  Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);

  List<Restaurante> findTop2ByNomeContaining(String nome);

  int countByCozinhaId(Long cozinhaId);

}
