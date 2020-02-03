package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ClienteRepository {
    private JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente save(Cliente cliente){
        String sql = "INSERT INTO Cliente (nome, cpf, nascimento) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql,cliente.getNome(), cliente.getCpf(), cliente.getNascimento());

        return cliente;
    }

    public List<Cliente> findAll(){
        String sql = "Select id, nome, cpf, nascimento from cliente";

        List<Cliente> listaClientes = jdbcTemplate.query(sql, new ClienteRowMapper());

        return listaClientes;
    }

    public void delete (String nomeFantasia){
        String sql = "Delete From Cliente where nomeFantasia = ?";

        jdbcTemplate.update(sql,nomeFantasia);

    }

    public void delete (long id){
        String sql = "Delete From Cliente where id = ?";

        jdbcTemplate.update(sql,id);

    }

}
