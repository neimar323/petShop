package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente save(Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        return clientes;
    }

}
