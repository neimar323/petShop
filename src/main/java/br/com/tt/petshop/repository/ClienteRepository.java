package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClienteRepository {
//    private List<Cliente> db = new ArrayList<>();

//    @PersistenceContext //Outra forma de injetar o EntityManager
//    private EntityManager entityManager;

    private EntityManager entityManager;
    private JdbcTemplate jdbcTemplate;

    public ClienteRepository(EntityManager entityManager, JdbcTemplate jdbcTemplate) {
        this.entityManager = entityManager;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente save(Cliente cliente){
//        db.add(cliente);

        final String sql = "insert into cliente (nome, cpf, nascimento) values (?, ?, ?)";
        jdbcTemplate.update(sql,
                cliente.getNome(), cliente.getCpf(),
                cliente.getNascimento());
        return cliente;
    }

    public List<Cliente> findAll(){

        return jdbcTemplate.query("select id, nome, cpf, nascimento from cliente",
                new ClienteRowMapper());
//        return db;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from cliente where id = ?", id);
    }

    public Cliente findById(Long id) {
        return (Cliente) entityManager
                .createQuery("from Cliente Where id = :idCliente ")
                .setParameter("idCliente", id)
                .getSingleResult();
    }
}
