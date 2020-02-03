package br.com.tt.petshop.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente{
    private long id;
    private String nome;
    private String cpf;
    private LocalDate nascimento;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String nascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.nascimento = LocalDate.parse(nascimento, formatter);

        this.nome = nome;
        this.cpf = cpf;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}