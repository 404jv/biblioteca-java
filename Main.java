import br.edu.ifpr.controllers.BookController;
import br.edu.ifpr.controllers.UserController;
import br.edu.ifpr.repositories.BooksRepository;
import br.edu.ifpr.repositories.UsersRepository;

public class Main {
  public static void main(String[] args) {

    // UserController userController = new UserController(UsersRepository.getInstance());

    // userController.create();
    // userController.show();
    // userController.update();
    // userController.show();

    BookController bookController = new BookController(BooksRepository.getInstance());

    bookController.create();
    bookController.update();
    bookController.show();
  }
}
