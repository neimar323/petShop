package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UnidadeRepository {
    private JdbcTemplate jdbcTemplate;
    private EntityManager em;

    public UnidadeRepository(JdbcTemplate jdbcTemplate, EntityManager em) {
        this.jdbcTemplate = jdbcTemplate;
        this.em = em;
    }

    public Unidade save(Unidade unidade){
        String sql = "INSERT INTO unidade (nome_fantasia, endereco) VALUES (?, ?)";

        jdbcTemplate.update(sql,unidade.getNomeFantasia(), unidade.getEndereco());

        return unidade;
    }

    public List<Unidade> findAll(){
        return (List<Unidade>) em.createQuery("from Unidade ").getResultList();
    }

    public Unidade findById(Long id) {
        return (Unidade)em.createQuery("from Unidade Where id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Modifying
    @Transactional
    public void deleteById(Long id) {
        em.createQuery(" delete from Unidade where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }




}
