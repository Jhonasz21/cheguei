package com.br.simonsen.cheguei.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private Long id;

    @DateTimeFormat(style = "yyyy-MM-dd HH:mm")
    private LocalDateTime criacao;
    private String nome;

    private String cpf;
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate nascimento;
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_login", referencedColumnName = "id")
    private Login login;

    public Cliente(Endereco endereco, Login login) {
        this.criacao = LocalDateTime.now();
        this.endereco = endereco;
        this.login = login;
    }

    public Cliente(){
        this.criacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
