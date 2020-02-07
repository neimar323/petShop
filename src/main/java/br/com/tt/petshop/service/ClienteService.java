package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import br.com.tt.petshop.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private static final Logger LOG = Logger.getLogger(ClienteService.class);

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente) throws NomeInvalidoExceptipn {
        String nome = cliente.getNome();
        String[] nomeSplit = nome.split(" ");

        if(nomeSplit.length < 2){
            throw new NomeInvalidoExceptipn("Nome sem sobrenome");
        }
        for (String umNome: nomeSplit) {
            if(umNome.length() < 2){
                throw new NomeInvalidoExceptipn("Nome ou sobrenome muito pequeno");
            }
        }


        return clienteRepository.save(cliente);
    }

    public void excluir(Cliente cliente){
        clienteRepository.delete(cliente.getId());
    }

    public void excluir(Long id){
        clienteRepository.delete(id);
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente find(Long id){
        return clienteRepository.find(id);
    }

}