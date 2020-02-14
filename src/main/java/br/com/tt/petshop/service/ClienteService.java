package br.com.tt.petshop.service;

import br.com.tt.petshop.client.ApiCreditoClient;
import br.com.tt.petshop.client.dto.SituacaoCreditoDto;
import br.com.tt.petshop.exception.NomeInvalidoException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private static final Logger LOG = LoggerFactory.getLogger(ClienteService.class);
    private static final int TAMANHO_MINIMO_PARTES = 2;
    private static final int QUANTIDADE_MINIMA_PARTES = 2;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ApiCreditoClient apiCreditoclient;

    public Cliente criar(Cliente cliente) throws NomeInvalidoException {
        validarNomeCliente(cliente);
        SituacaoCreditoDto situacaoCreditoDto = apiCreditoclient.verificaSituacao(cliente.getCpf());
        if(situacaoCreditoDto.getSituacao().equals("NEGATIVADO")){
            throw new IllegalArgumentException("Cliente negativado");
        }
        return this.clienteRepository.save(cliente);
    }

    private void validarNomeCliente(Cliente cliente) throws NomeInvalidoException {
        String[] partes = cliente.getNome().split(" ");

        int quantidadePartes = partes.length;

        if(quantidadePartes < QUANTIDADE_MINIMA_PARTES){
            LOG.debug("Nome incompleto: {}", cliente.getNome());
            throw new NomeInvalidoException("Preencha seu nome completo");
        }

        for (String parte :partes) {
            if(parte.length() <= TAMANHO_MINIMO_PARTES){
                LOG.debug("Parte do nome menor que {}: {}",
                        TAMANHO_MINIMO_PARTES,
                        parte);
                throw new NomeInvalidoException("Informe seu nome sem abreviações");
            }
        }
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
