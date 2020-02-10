package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByValorGreaterThanOrderByDescricao(BigDecimal valorMaiorQue);

    @Query("from Produto Where id = :id and descricao is not null")
    List<Produto> findByIdComDescricao(@Param("id") Long id);
}
