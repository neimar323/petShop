package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadeRepository {
    private JdbcTemplate jdbcTemplate;

    public UnidadeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Unidade save(Unidade unidade){
        String sql = "INSERT INTO unidade (nomeFantasia, endereco) VALUES (?, ?)";

        jdbcTemplate.update(sql,unidade.getNomeFantasia(), unidade.getEndereco());

        return unidade;
    }

    public List<Unidade> findAll(){
        String sql = "Select nomeFantasia, endereco from unidade";

        List<Unidade> listaUnidades = jdbcTemplate.query(sql, new UnidadeRowMapper());

        return listaUnidades;
    }

    public void delete (String nomeFantasia){
        String sql = "Delete From unidade where nomeFantasia = ?";

        jdbcTemplate.update(sql,nomeFantasia);

    }

}
