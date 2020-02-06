package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteService.class);

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente){
        int quantidadePartes = cliente.getNome().split(" ").length;

        if(quantidadePartes < 1){
            LOG.debug("Nome incompleto: {}", cliente.getNome());
            throw new NomeInvalidoException("Preencha seu nome completo");
        }

        String[] partes = cliente.getNome().split(" ");
        for (String parte :partes) {
            if(parte.length() <= 2){
                System.out.println("Nome menor");
            }
        }

        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        return this.clienteRepository.findAll();
    }

    public void excluir(Long id) {
        this.clienteRepository.deleteById(id);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
}
