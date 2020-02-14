package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Produto;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoOutDto {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private LocalDate criacao;
    private LocalDate alteracao;

    public ProdutoOutDto(Produto entidade) {
        id = entidade.getId();
        valor = entidade.getValor();
        descricao = entidade.getDescricao();
        criacao = entidade.getCriacao();
        alteracao = entidade.getAlteracao();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDate criacao) {
        this.criacao = criacao;
    }

    public LocalDate getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(LocalDate alteracao) {
        this.alteracao = alteracao;
    }
}
