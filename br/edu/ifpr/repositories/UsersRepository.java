package br.edu.ifpr.repositories;

import java.util.ArrayList;

import br.edu.ifpr.model.User;

public class UsersRepository {
  private ArrayList<User> repository;
  private static UsersRepository INSTANCE;

  private UsersRepository() {
    this.repository = new ArrayList<User>();
  }

  public static UsersRepository getInstance() {
    if (UsersRepository.INSTANCE == null) {
      UsersRepository.INSTANCE = new UsersRepository();
    }

    return UsersRepository.INSTANCE;
  }

  public void create(
    String nome, 
    String email, 
    String senha, 
    int idade, 
    String curso
  ) {
    User user = new User();

    user.setNome(nome);
    user.setEmail(email);
    user.setSenha(senha);
    user.setIdade(idade);
    user.setCurso(curso);

    repository.add(user);
  }

  public void update(
    String nome, 
    String email, 
    String senha, 
    int idade, 
    String curso
  ) {
    User user = this.findByName(nome);

    user.setNome(nome);
    user.setEmail(email);
    user.setSenha(senha);
    user.setIdade(idade);
    user.setCurso(curso);  
  }

  public User[] all() {
    User[] users = this.repository.toArray(new User[this.repository.size()]);

    return users;
  }

  public User findByName(String nome) {
    for (User user: this.repository) {
      if (user.getNome() == nome) {
        return user;
      }
    }

    return null;
  }

  public void delete(User user) {
    this.repository.remove(user);
  }
}
