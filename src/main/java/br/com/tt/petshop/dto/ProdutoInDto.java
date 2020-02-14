package br.com.tt.petshop.dto;


import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProdutoInDto {

    @NotNull(message="Valor não pode ser nulo")
    @Min(message = "Valor não pode ser < 0", value = 0)
    private BigDecimal valor;

    @NotNull(message="Descricao não pode ser nulo")
    private String descricao;

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
