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
    String nome = inputStringValue("Digite o nome", "Cadastro de Usuário", "");
    
    if (nome == null) return;

    String email = inputStringValue(
      "Digite o email, do(a) " + nome, 
      "Cadastro de Usuário",
      ""
    );
    
    if (email == null) return;
    
    String senha = inputStringValue(
      "Digite uma senha para o(a) " + nome, 
      "Cadastro de Usuário",
      ""
    );

    if (senha == null) return;

    int idade = 0;

    while (true) {
      String idadeString = inputStringValue(
        "Qual é a idade do(a) " + nome + "?",
        "Cadastro de Usuário",
        ""
      );

      if (idadeString == null) return;

      boolean isValidIdade = validateIdade(idadeString);

      if (isValidIdade) {
        idade = Integer.parseInt(idadeString);
        break;
      }

      showError("❌ Esta idade não é valida! Tente outra.", "⚠ Error!");
    }

    String curso = inputStringValue("E o curso dele(a)?", "Cadastro de Usuário", "");

    if (curso == null) return;

    this.usersRepository.create(nome, email, senha, idade, curso);
  }

  public void update() {
    User user = selectUser();

    if (user == null) return;

    String nome = inputStringValue(
      "O nome atual está " + user.getNome() + ". Qual é o novo?",
      "✂ Alterar Usuário",
      user.getNome()
    );

    if (nome == null) return;

    String email = inputStringValue(
      "O E-mail atual é " + user.getEmail() + ". Qual vai ser o nove?",
      "✂ Alterar Usuário",
      user.getEmail()
    );

    if (email == null) return;

    String senha = inputStringValue(
      "Digite a nova senha.", 
      "✂ Alterar Usuário",
      user.getSenha()
    );
    
    if (senha == null) return;

    int idade = 0;

    while (true) {
      String idadeString = inputStringValue(
        "A idade atual é " + user.getIdade() + ". Qual é a nova?",
        "✂ Alterar Usuário",
        "" + user.getIdade()
      );

      if (idadeString == null) return;

      boolean isValidIdade = validateIdade(idadeString);

      if (isValidIdade) {
        idade = Integer.parseInt(idadeString);
        break;
      }

      showError("❌ Esta idade não é valida! Tente outra.", "⚠ Error!");
    }

    String curso = inputStringValue(
      "O curso atual é " + user.getCurso() + ". Qual vai ser o novo?",
      "✂ Alterar Usuário",
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

    if (users.length == 0) {
      showError("X_X Não tem usuário cadastrado!", "⚠ Aviso.");

      return;
    }

    JOptionPane.showMessageDialog(
      null, 
      users, 
      "👥 Usuários Cadastrados", 
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  private String inputStringValue(
    String inputMessage, 
    String inputTitle, 
    String defaultValue
  ) {
    while (true) {
      String value = (String) JOptionPane.showInputDialog(
        null,
        inputMessage,
        inputTitle,
        JOptionPane.QUESTION_MESSAGE,
        null,
        null,
        defaultValue
      );

      if (value == null) return null;

      if (!value.isEmpty()) return value;

      showError("⚠ Esse campo é obrigatório! Digite um valor correto.", "⚠ Error!");
    }
  }

  private void showError(String errorMessage, String errorTitle) {
    JOptionPane.showMessageDialog(
      null, 
      errorMessage,
      errorTitle,
      JOptionPane.ERROR_MESSAGE
    );
  }

  private boolean validateIdade(String idadeString) {
    try {
      int idade = Integer.parseInt(idadeString);

      if (idade < 0) return false;

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private User selectUser() {
    User[] users = this.usersRepository.all();

    if (users.length == 0) {
      showError("X_X Não tem usuário cadastrado!", "⚠ Aviso.");

      return null;
    }

    User user = (User) JOptionPane.showInputDialog(
      null, 
      "👥 Usuários Cadastrados",
      "👥 Usuários Cadastrados", 
      JOptionPane.ERROR_MESSAGE, 
      null,
      users,
      users[0]
    );

    return user;
  }
}
