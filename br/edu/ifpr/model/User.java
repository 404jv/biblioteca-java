package br.edu.ifpr.model;

import java.util.UUID;

public class User {
  private String id;
  private String nome;
  private String email;
  private String senha;
  private String idade;
  private String curso;

  public User() {
    this.id = UUID.randomUUID().toString();
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

  public String getIdade() {
    return idade;
  }

  public void setIdade(String idade) {
    this.idade = idade;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }
}
