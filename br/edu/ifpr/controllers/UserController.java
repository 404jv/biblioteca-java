package br.edu.ifpr.controllers;

import javax.swing.JOptionPane;

import br.edu.ifpr.model.User;
import br.edu.ifpr.repositories.UserRepository;

public class UserController {
  UserRepository usersRepository;

  public UserController() {
    this.usersRepository = UserRepository.getInstance();
  }

  public void create() {
    String nome = JOptionPane.showInputDialog("Digite o nome");

    String email = JOptionPane.showInputDialog("Digite o email, do(a) " + nome);

    String senha = JOptionPane.showInputDialog("Digite uma senha para o(a) " + nome);

    String idade = JOptionPane.showInputDialog("Qual é a idade do(a) " + nome + "?");

    String curso = JOptionPane.showInputDialog("E o curso dele(a)?");

    this.usersRepository.create(nome, email, senha, idade, curso);
  }

  public void update() {
    String selectedUserName = selectUser();

    User user = this.usersRepository.findByName(selectedUserName);

    String nome = JOptionPane.showInputDialog(
      "O nome atual está " + user.getNome() + ". Qual é o novo?", 
      user.getNome()
    );

    String email = JOptionPane.showInputDialog(
      "O E-mail atual é " + user.getEmail() + ". Qual vai ser o nove?",
      user.getEmail()
    );

    String senha = JOptionPane.showInputDialog("Digite a nova senha.");

    String idade = JOptionPane.showInputDialog(
      "A idade atual está " + user.getIdade() + ". Qual vai ser a nova?",
      user.getIdade()
    );

    String curso = JOptionPane.showInputDialog(
      "O curso atual é " + user.getCurso() + ". Qual vai ser o novo?",
      user.getCurso()
    );
    
    this.usersRepository.update(user.getId(), nome, email, senha, idade, curso);
  }

  public void remove() {
    String selectedUserName = selectUser();
    
    String[] options = { "Sim", "Não", "Cancelar" };

    int isConfirmed = JOptionPane.showOptionDialog(
      null, 
      "Deseja realmente excluir o usuário " + selectedUserName + "?", 
      "⚠ Aviso!", 
      JOptionPane.DEFAULT_OPTION, 
      JOptionPane.WARNING_MESSAGE, 
      null, 
      options, 
      options[0]
    );

    if (isConfirmed != 0) return;

    User user = this.usersRepository.findByName(selectedUserName);

    this.usersRepository.remove(user);
  }
  
  public void show() {
    String[] usersName = this.usersRepository.getAllUsersName();

    JOptionPane.showMessageDialog(
      null, 
      usersName, 
      "Usuários Cadastrados", 
      JOptionPane.INFORMATION_MESSAGE
    );


  }


  public String selectUser() {
    String[] usersName = this.usersRepository.getAllUsersName();

    String userName = JOptionPane.showInputDialog(
      null, 
      "Usuários Cadastrados",
      "Usuários Cadastrados", 
      JOptionPane.ERROR_MESSAGE, 
      null,
      usersName,
      usersName[0]
    ).toString();

    return userName;
  }

}
