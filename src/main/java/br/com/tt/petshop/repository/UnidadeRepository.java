package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UnidadeRepository {
    private List<Unidade> unidades = new ArrayList<>();

    public Unidade save(Unidade unidade){
        unidades.add(unidade);
        return unidade;
    }

    public List<Unidade> findAll(){
        return unidades;
    }

}
