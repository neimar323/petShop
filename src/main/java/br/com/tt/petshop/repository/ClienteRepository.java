package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private List<Cliente> db = new ArrayList<>();

    public Cliente save(Cliente cliente){
        db.add(cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        return db;
    }
}
