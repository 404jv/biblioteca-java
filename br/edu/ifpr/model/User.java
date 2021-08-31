package br.edu.ifpr.model;

import java.util.UUID;

public class User {
  private String id;
  private String nome;
  private String email;
  private String senha;
  private int idade;
  private String curso;

  public User() {
    this.id = UUID.randomUUID().toString();
  }

  @Override
  public String toString() {
    return this.nome;
  }

  public String getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }
}
