package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {
    private UnidadeRepository unidadeRepository = new UnidadeRepository();

    public void criar(Unidade unidade){
        unidadeRepository.save(unidade);
    }

    public List<Unidade> listar(){
        return unidadeRepository.findAll();
    }

    public void excluir(String nomeFantasia) {
        List<Unidade> lista = listar();
        for (int i = 0; i < lista.size() ; i++) {
            if (lista.get(i).getNomeFantasia().equals(nomeFantasia)){
                lista.remove(i);
            }
        }
    }
}