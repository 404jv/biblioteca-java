package br.edu.ifpr.controllers;

import javax.swing.JOptionPane;

import br.edu.ifpr.model.Book;
import br.edu.ifpr.repositories.BooksRepository;

public class BookController {
  BooksRepository booksRepository;

  public BookController(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }
  
  public void create() {
    String titulo = inputStringValue(
      "Digite o titulo",
      "Cadastro de livro",
      ""
    );

    if (titulo == null) return;

    int paginas = 0;
    while (true) {
      String paginasString = inputStringValue(
        "Quantas páginas o livro " + titulo + " tem?",
        "Cadastro de livro",
        ""
      );

      if (paginasString == null) return;

      boolean isValidPagina = validatePagina(paginasString);

      if (isValidPagina) {
        paginas = Integer.parseInt(paginasString);
        break;
      }

      showError("⚠ Você precisa digitar o número de páginas valido!", "⚠ Error!");
    }

    String autor = inputStringValue(
      "Quem escreveu o livro " + titulo + "?",
      "Cadastro de livro",
      ""
    );

    if (autor == null) return;

    String genero = inputStringValue(
      "Qual é o gênero do livro " + titulo + "?",
      "Cadastro de livro",
      ""
    );

    if (genero == null) return;

    String editora = inputStringValue(
      "Qual é a editora do livro " + titulo + "?",
      "Cadastro de livro",
      ""
    );
    
    if (editora == null) return;

    int anoDePublicacao = Integer.parseInt(
      inputStringValue(
        "E qual é o ano de publicação do livro " + titulo + "?",
        "Cadastro de livro",
        ""
      )
    );

    this.booksRepository.create(
      titulo, 
      paginas, 
      autor, 
      genero, 
      editora, 
      anoDePublicacao
    );
  } 

  public void show() {
    Book[] books = this.booksRepository.all();

    if (books.length == 0) {
      showError("X_X Não tem livro cadastrado!", "⚠ Aviso.");
      return;
    }

    JOptionPane.showMessageDialog(
      null, 
      books,
      "📚 Livros Cadastrados",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  public void update() {
    Book book = selectBook();

    if (book == null) return;

    String titulo = inputStringValue(
      "O título atual está " + book.getTitulo() + ". Qual é o novo?",
      "✂ Alterar Livro",
      book.getTitulo()
    );

    int paginas = 0;

    while (true) {
      String paginasString = inputStringValue(
        "A quantidade de páginas atual está " + book.getPaginas() + ". Qual é a nova?",
        "✂ Alterar Livro",
        "" + book.getPaginas()
      );

      if (paginasString == null) return;

      if (validatePagina(paginasString)) {
        paginas = Integer.parseInt(paginasString);
        break;
      }

      showError("⚠ Você precisa digitar o número de páginas valido!", "⚠ Error!");
    }

    String autor = inputStringValue(
      "O autor atual está " + book.getAutor() + ". Qual é o autor?",
      "✂ Alterar Livro",
      book.getAutor()
    );

    if (autor == null) return;

    String genero = inputStringValue(
      "O gênero atual está " + book.getGenero() + ". Qual é o atualizado?",
      "✂ Alterar Livro",
      book.getGenero()
    );

    if (genero == null) return;

    String editora = inputStringValue(
      "A editora atual é " + book.getEditora() + ". Qual é a atualizada?",
      "✂ Alterar Livro",
      book.getEditora()
    );

    if (editora == null) return;
    
    int anoDePublicacao = Integer.parseInt(
      inputStringValue(
        "O ano de publicação está " + book.getAnoDePublicacao() + ". Qual é o novo?",
        "✂ Alterar Livro",
        book.getEditora()
      )
    );

    this.booksRepository.update(
      book,
      titulo, 
      paginas, 
      autor,
      genero, 
      editora, 
      anoDePublicacao
    );
  }

  public void delete() {
    Book book = selectBook();

    if (book == null) return;

    String[] options = { "Sim", "Não", "Cancelar" };

    int isConfirmed = JOptionPane.showOptionDialog(
      null, 
      "Deseja realmente excluir o livro " + book + "?", 
      "⚠ Aviso!", 
      JOptionPane.DEFAULT_OPTION, 
      JOptionPane.WARNING_MESSAGE, 
      null, 
      options, 
      options[0]
    );

    if (isConfirmed != 0) return;

    this.booksRepository.delete(book);
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

  public boolean validatePagina(String paginasString) {
    try {
      int paginas = Integer.parseInt(paginasString);

      if (paginas <= 0) return false;

      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Book selectBook() {
    Book[] books = this.booksRepository.all();

    if (books.length == 0) {
      showError("X_X Não tem livro cadastrado!", "⚠ Aviso.");
      return null;
    }

    Book book = (Book) JOptionPane.showInputDialog(
      null, 
      "📚 Livros Cadastrados",
      "📚 Livros Cadastrados", 
      JOptionPane.ERROR_MESSAGE, 
      null,
      books,
      books[0]
    );

    return book;
  }
}
