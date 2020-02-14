package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@Sql(value = "classpath:/popula_produtos.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "classpath:/delete_produto.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ProdutoRepositoryTest {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void deveriaRetornarValorMaiorQue50(){
        BigDecimal vl = BigDecimal.valueOf(50);

        List<Produto> resultado = produtoRepository.findAllByValorGreaterThanOrderByDescricao(vl);
        assertEquals(1, resultado.size());
        assertEquals("Banho e Tosa", resultado.get(0).getDescricao() );
        assertEquals(BigDecimal.valueOf(75).setScale(2), resultado.get(0).getValor() );

    }
}