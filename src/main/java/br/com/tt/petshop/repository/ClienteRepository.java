package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClienteRepository {
    private JdbcTemplate jdbcTemplate;
    private EntityManager em;

    public ClienteRepository(JdbcTemplate jdbcTemplate, EntityManager em) {
        this.jdbcTemplate = jdbcTemplate;
        this.em = em;
    }

    public Cliente saveJdbc(Cliente cliente){
        String sql = "INSERT INTO Cliente (nome, cpf, nascimento) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql,cliente.getNome(), cliente.getCpf(), cliente.getNascimento());

        return cliente;
    }

    @Modifying
    @Transactional
    public Cliente save(Cliente cliente){
        em.persist(cliente);
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

    public Cliente find(Long id) {
        Query query = em.createQuery("from Cliente where id=:id");
        query = query.setParameter("id", id);
        return (Cliente)query.getSingleResult();

//        return (Cliente)em.createQuery("from Cliente Where id = :id")
//                .setParameter("id", id)
//                .getSingleResult();
    }
}
