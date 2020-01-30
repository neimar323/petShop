package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Repository
public class UnidadeRepository {

    private List<Unidade> db = new ArrayList<>();

    public Unidade save(Unidade unidade) {
        db.add(unidade);
        return unidade;
    }

    public List<Unidade> findAll() {
        //Aqui cria-se uma nova lista que não pode ser modificada;
        return Collections.unmodifiableList(db);
    }

    public void delete(String nome) {

        List<Unidade> listaAposExclusao = new ArrayList<>();

        Iterator<Unidade> iterator = db.iterator();
        while (iterator.hasNext()){
            Unidade unidade = iterator.next();
            if(!unidade.getNome().equalsIgnoreCase(nome)){
                listaAposExclusao.add(unidade);
            }
        }

        db = listaAposExclusao;
    }
}
