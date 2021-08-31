package br.edu.ifpr.controllers;

import javax.swing.JOptionPane;

import br.edu.ifpr.model.User;
import br.edu.ifpr.repositories.UsersRepository;

public class UserController {
  UsersRepository usersRepository;

  public UserController(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public void create() {
    String nome = JOptionPane.showInputDialog("Digite o nome");
    
    if (nome == null) return;

    String email = JOptionPane.showInputDialog("Digite o email, do(a) " + nome);

    if (email == null) return;

    String senha = JOptionPane.showInputDialog(
      "Digite uma senha para o(a) " + nome
    );

    if (senha == null) return;

    int idade = 0;

    while (true) {
      String idadeString = JOptionPane.showInputDialog(
        "Qual é a idade do(a) " + nome + "?"
      );

      if (idadeString == null) return;

      boolean isValidIdade = validateIdade(idadeString);

      if (isValidIdade) {
        idade = Integer.parseInt(idadeString);
        break;
      }

      JOptionPane.showMessageDialog(
        null, 
        "❌ Esta idade não é valida! Tente outra.",
        "⚠ Error!",
        JOptionPane.ERROR_MESSAGE
      );
    }

    String curso = JOptionPane.showInputDialog("E o curso dele(a)?");

    if (curso == null) return;

    this.usersRepository.create(nome, email, senha, idade, curso);
  }

  public void update() {
    User user = selectUser();

    String nome = JOptionPane.showInputDialog(
      "O nome atual está " + user.getNome() + ". Qual é o novo?", 
      user.getNome()
    );

    if (nome == null) return;

    String email = JOptionPane.showInputDialog(
      "O E-mail atual é " + user.getEmail() + ". Qual vai ser o nove?",
      user.getEmail()
    );

    if (email == null) return;

    String senha = JOptionPane.showInputDialog("Digite a nova senha.");

    if (senha == null) return;

    int idade = 0;

    while (true) {
      String idadeString = JOptionPane.showInputDialog(
        "A idade atual é " + user.getIdade() + ". Qual é a nova?"
      );

      if (idadeString == null) return;

      boolean isValidIdade = validateIdade(idadeString);

      if (isValidIdade) {
        idade = Integer.parseInt(idadeString);
        break;
      }

      JOptionPane.showMessageDialog(
        null, 
        "❌ Esta idade não é valida! Tente outra.",
        "⚠ Error!",
        JOptionPane.ERROR_MESSAGE
      );
    }

    String curso = JOptionPane.showInputDialog(
      "O curso atual é " + user.getCurso() + ". Qual vai ser o novo?",
      user.getCurso()
    );

    if (curso == null) return;
    
    this.usersRepository.update(nome, email, senha, idade, curso);
  }

  public void delete() {
    User user = selectUser();
    
    if (user == null) return;

    String[] options = { "Sim", "Não", "Cancelar" };

    int isConfirmed = JOptionPane.showOptionDialog(
      null, 
      "Deseja realmente excluir o usuário " + user + "?", 
      "⚠ Aviso!", 
      JOptionPane.DEFAULT_OPTION, 
      JOptionPane.WARNING_MESSAGE, 
      null, 
      options, 
      options[0]
    );

    if (isConfirmed != 0) return;

    this.usersRepository.delete(user);
  }
  
  public void show() {
    User[] users = this.usersRepository.all();

    JOptionPane.showMessageDialog(
      null, 
      users, 
      "👥 Usuários Cadastrados", 
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  public boolean validateIdade(String idadeString) {
    try {
      int idade = Integer.parseInt(idadeString);

      if (idade < 0) return false;

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public User selectUser() {
    User[] users = this.usersRepository.all();

    User user = (User) JOptionPane.showInputDialog(
      null, 
      "Usuários Cadastrados",
      "Usuários Cadastrados", 
      JOptionPane.ERROR_MESSAGE, 
      null,
      users,
      users[0]
    );

    return user;
  }
}
