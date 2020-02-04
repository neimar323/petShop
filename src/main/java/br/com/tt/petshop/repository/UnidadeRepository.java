package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public UnidadeRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public Unidade criar(Unidade unidade){
        entityManager.persist(unidade);
        return unidade;
    }

    public Unidade update(Unidade unidade){
        Unidade unidadeSalva = entityManager.merge(unidade);
        return unidadeSalva;
    }

    public List<Unidade> buscaUnidadesPorNome(String nome){
        return entityManager
                .createQuery("select u From Unidade u where u.nome = :nome ")
                .setParameter("nome", nome)
                .getResultList();
    }

    public Unidade buscaUnidadesPorId(String id){
        return (Unidade) entityManager
                .createQuery("select u From Unidade u where u.id = :id ")
                .setParameter("id", id)
                .getSingleResult();
    }

//    private List<Unidade> db = new ArrayList<>();

    public Unidade save(Unidade unidade) {
//        db.add(unidade);

        jdbcTemplate
            .update("insert into unidade (nome, endereco) values (?,?)",
                        unidade.getNome(), unidade.getEndereco());
        return unidade;
    }

    public List<Unidade> findAll() {
        //Aqui cria-se uma nova lista que não pode ser modificada;
//        return Collections.unmodifiableList(db);
        return jdbcTemplate
            .query("select nome, endereco from unidade",
                    new UnidadeRowMapper());
    }

    public void delete(String nome) {
//        List<Unidade> listaAposExclusao = new ArrayList<>();
//
//        Iterator<Unidade> iterator = db.iterator();
//        while (iterator.hasNext()){
//            Unidade unidade = iterator.next();
//            if(!unidade.getNome().equalsIgnoreCase(nome)){
//                listaAposExclusao.add(unidade);
//            }
//        }
//        db = listaAposExclusao;

        jdbcTemplate
            .update("delete from unidade Where nome = ?",
            nome);
    }
}
