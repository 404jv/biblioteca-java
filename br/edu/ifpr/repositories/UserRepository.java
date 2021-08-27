package br.edu.ifpr.repositories;

import java.util.ArrayList;
import br.edu.ifpr.model.User;

public class UserRepository {
  private ArrayList<User> users;
  private static UserRepository INSTANCE;

  private UserRepository() {
    this.users = new ArrayList<User>();
  }

  public static UserRepository getInstance() {
    if (UserRepository.INSTANCE == null) {
      UserRepository.INSTANCE = new UserRepository();
    }

    return UserRepository.INSTANCE;
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

  public String[] getAllUsersName() {
    ArrayList<String> usersName = new ArrayList<>();
  
    for (User user: this.users) {
      usersName.add(user.getNome());
    } 

    return usersName.toArray(new String[usersName.size()]);
  }
  
  public void edit(String name, User user) {

  }

  public User findById(String id) {
    for (User user: users) {
      if (user.getId() == id) {
        return user;
      }
    }

    return null;
  }

}
