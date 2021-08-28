package br.edu.ifpr.repositories;

import java.util.ArrayList;

import br.edu.ifpr.model.User;

public class UsersRepository {
  private ArrayList<User> users;
  private static UsersRepository INSTANCE;

  private UsersRepository() {
    this.users = new ArrayList<User>();
  }

  public static UsersRepository getInstance() {
    if (UsersRepository.INSTANCE == null) {
      UsersRepository.INSTANCE = new UsersRepository();
    }

    return UsersRepository.INSTANCE;
  }

  public void create(String nome, String email, String senha, String idade, String curso) {
    User user = new User();

    user.setNome(nome);
    user.setEmail(email);
    user.setSenha(senha);
    user.setIdade(idade);
    user.setCurso(curso);

    users.add(user);
  }

  public void update(String id, String nome, String email, String senha, String idade, String curso) {
    User user = this.findById(id);

    if (nome != null) {
      user.setNome(nome);
    }

    if (email != null) {
      user.setEmail(email);
    }

    if (senha != null) {
      user.setSenha(senha);
    }

    if (idade != null) {
      user.setIdade(idade);
    }

    if (curso != null) {
      user.setCurso(curso);  
    }
  }

  public String[] getAllUsersName() {
    ArrayList<String> usersName = new ArrayList<>();
  
    for (User user: this.users) {
      usersName.add(user.getNome());
    } 

    return usersName.toArray(new String[usersName.size()]);
  }

  public void getAll() {
    for (User user: this.users) {
      System.out.println(" " +  user.getNome() +
      " " + user.getEmail() +
      " " + user.getSenha() +
      " " + user.getIdade() +
      " " + user.getCurso());
    } 
  }
  
  public User findById(String id) {
    for (User user: this.users) {
      if (user.getId() == id) {
        return user;
      }
    }

    return null;
  }

  public User findByName(String nome) {
    for (User user: this.users) {
      if (user.getNome() == nome) {
        return user;
      }
    }

    return null;
  }

  public void remove(User user) {
    this.users.remove(user);
  }
}
