package br.com.tt.petshop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Table
@Entity
public class Cliente{

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome")
    private String nome;
    @Column(name="cpf")
    private String cpf;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
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
        if(null != nome){
            this.nome = nome
                    .trim()
                    .replaceAll("[ ]+", " ")
                    .replaceAll("[^ a-zA-Z0-9 ]+", " ");
        }
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