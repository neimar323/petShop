package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class AnimalInDto {

    @NotBlank(message = "N nome deve ser preenchido!")
    private String nome;

    @NotNull(message="Informe a data de nascimento")
    @Past(message="O nascimento não pode ser futuro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;

    @NotNull(message="id cliente nao deve ser null")
    private Long clienteId;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

//    public Animal toEntity() {
//        Animal animal = new Animal();
//        animal.setNascimento(this.getNascimento());
//        animal.setNome(this.getNome());
//        return animal;
//    }
}
