package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AnimalInDto {

    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate nascimento;
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
