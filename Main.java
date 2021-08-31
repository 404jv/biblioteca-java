import javax.swing.JOptionPane;

import br.edu.ifpr.controllers.BookController;
import br.edu.ifpr.controllers.UserController;
import br.edu.ifpr.repositories.BooksRepository;
import br.edu.ifpr.repositories.UsersRepository;

public class Main {
  static BookController bookController = new BookController(
    BooksRepository.getInstance()
  );

  static UserController userController = new UserController(
    UsersRepository.getInstance()
  );
  public static void main(String[] args) {

    while(true) {
      int selectedOption = selectOption();

      if (selectedOption == -1) break;

      routes(selectedOption);
    }
  }

  public static int selectOption() {
    String[] options = { 
      "Cadastrar Livro", 
      "Cadastrar Usuário", 
      "Listar Livros",
      "Listar Usuários",
      "Remover Livro",
      "Remover Usuário",
      "Alterar Livro",
      "Alterar Usuário",
    };

    int selectedOption = (int) JOptionPane.showOptionDialog(
      null,
      "🤠 Selecione uma opção",
      "Opções", 
      JOptionPane.DEFAULT_OPTION, 
      JOptionPane.QUESTION_MESSAGE, 
      null, 
      options, 
      options[0]
    );

    return selectedOption;
  }

  public static void routes(int option) {
    if (option == 0) {
      bookController.create();
      return;
    }
    
    if (option == 1) {
      userController.create();
      return;
    }

    if (option == 2) {
      bookController.show();
      return;
    }

    if (option == 3) {
      userController.show();
      return;
    }

    if (option == 4) {
      bookController.delete();
      return;
    }

    if (option == 5) {
      userController.delete();
      return;
    }

    if (option == 6) {
      bookController.update();
      return;
    }

    if (option == 7) {
      userController.update();
      return;
    }
  }
}
