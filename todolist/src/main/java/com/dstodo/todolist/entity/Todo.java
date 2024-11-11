package com.dstodo.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todoList")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank //Valida que o tipo abaixo não pode estar em branco
    private String nome;

    @NotBlank //Valida que o tipo abaixo não pode estar em branco
    private String descricao;
    private Boolean realizado;
    private int prioridade;

    public Todo() {
    }

    // Cria um modelo pré definido de requisição
    public Todo(String nome, String descricao, Boolean realizado, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Boolean getRealizado() {
        return realizado;
    }
    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    
}
