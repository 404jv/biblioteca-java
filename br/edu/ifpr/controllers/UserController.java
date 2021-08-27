package br.edu.ifpr.controllers;

import javax.swing.JOptionPane;

import br.edu.ifpr.model.User;
import br.edu.ifpr.repositories.UserRepository;

public class UserController {
  UserRepository userRepository;

  public UserController() {
    this.userRepository = UserRepository.getInstance();
  }

  public void create() {
    String nome = JOptionPane.showInputDialog("Digite o nome");

    String email = JOptionPane.showInputDialog("Digite o email, do(a) " + nome);

    String senha = JOptionPane.showInputDialog("Digite uma senha para o(a) " + nome);

    String idade = JOptionPane.showInputDialog("Qual é a idade do(a) " + nome + "?");

    String curso = JOptionPane.showInputDialog("E o curso dele(a)?");

    this.userRepository.create(nome, email, senha, idade, curso);
  }

  public void edit() {
    String[] usersName = this.userRepository.getAllUsersName();

    String userName = JOptionPane.showInputDialog(
      null, 
      "Usuários Cadastrados",
      "Usuários Cadastrados", 
      JOptionPane.ERROR_MESSAGE, 
      null,
      usersName,
      usersName[0]
    ).toString();

    User user = this.userRepository.findByName(userName);

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

    user.setNome(nome);
    user.setEmail(email);
    user.setSenha(senha);
    user.setIdade(idade);
    user.setCurso(curso);    
  }
}
