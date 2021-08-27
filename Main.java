import br.edu.ifpr.controllers.UserController;

public class Main {
  public static void main(String[] args) {

    UserController userController = new UserController();

    userController.create();
    userController.edit();
  }
}
