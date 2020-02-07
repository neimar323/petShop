package br.com.tt.petshop.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="valor")
    private BigDecimal valor;

    @Column(name ="descricao")
    private String descricao;

    @Column(name ="criacao")
    @CreatedDate
    private LocalDate criacao;

    public LocalDate getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDate criacao){
        this.criacao = criacao;
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
}
