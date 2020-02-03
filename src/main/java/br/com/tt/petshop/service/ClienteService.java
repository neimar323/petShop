package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void criar(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public void excluir(Cliente cliente){
        clienteRepository.delete(cliente.getId());
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }



}