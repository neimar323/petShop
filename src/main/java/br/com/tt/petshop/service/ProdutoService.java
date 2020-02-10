package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listar(BigDecimal valorMaiorQue) {
        if(valorMaiorQue != null){
            return produtoRepository.findAllByValorGreaterThanOrderByDescricao(valorMaiorQue);
        }
        return produtoRepository.findAll();
    }
}
