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
    String titulo = JOptionPane.showInputDialog(
      null, 
      "Digite o titulo",
      "Cadastro de livro",
      JOptionPane.QUESTION_MESSAGE
    );

    if (titulo == null) return;

    int paginas = 0;

    while (true) {
      String paginasString = JOptionPane.showInputDialog(
        null,
        "Quantas páginas o livro " + titulo + " tem?",
        "Cadastro de livro",
        JOptionPane.QUESTION_MESSAGE
      );

      if (validatePagina(paginasString)) {
        paginas = Integer.parseInt(paginasString);
        break;
      }

      JOptionPane.showMessageDialog(
        null, 
        "⚠ Você precisa digitar o número de páginas valido!",
        "⚠ Error!",
        JOptionPane.ERROR_MESSAGE
      );
    }

    String autor = JOptionPane.showInputDialog(
      null,
      "Quem escreveu o livro " + titulo + "?",
      "Cadastro de livro",
      JOptionPane.QUESTION_MESSAGE
    );

    if (autor == null) return;

    String genero = JOptionPane.showInputDialog(
      null,
      "Qual é o gênero do livro " + titulo + "?",
      "Cadastro de livro",
      JOptionPane.QUESTION_MESSAGE
    );

    if (genero == null) return;

    String editora = JOptionPane.showInputDialog(
      null,
      "Qual é a editora do livro " + titulo + "?",
      "Cadastro de livro",
      JOptionPane.QUESTION_MESSAGE
    );
    
    if (editora == null) return;

    String anoDePublicacao = JOptionPane.showInputDialog(
      null,
      "E qual é o ano de publicação do livro " + titulo + "?",
      "Cadastro de livro",
      JOptionPane.QUESTION_MESSAGE
    );

    if (anoDePublicacao == null) return;

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
      JOptionPane.showMessageDialog(
        null,
        "X_X Não tem livro cadastrado!",
        "⚠ Aviso.",
        JOptionPane.WARNING_MESSAGE
      );

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

    String titulo = JOptionPane.showInputDialog(
      "O título atual está " + book.getTitulo() + ". Qual é o novo?", 
      book.getTitulo()
    );

    int paginas = Integer.parseInt(
      JOptionPane.showInputDialog(
        "A quantidade de páginas atual é " + book.getPaginas() + ". Qual é a quantidade?",
        book.getPaginas()
      )
    );

    String autor = JOptionPane.showInputDialog(
      "O autor atual está " + book.getAutor() + ". Qual é o autor?",
      book.getAutor()
    );

    String genero = JOptionPane.showInputDialog(
      "O gênero atual está " + book.getGenero() + ". Qual é o atualizado?",
      book.getGenero()
    );

    String editora = JOptionPane.showInputDialog(
      "A editora atual é " + book.getEditora() + ". Qual é a atualizada?",
      book.getEditora()
    );
    
    String anoDePublicacao = JOptionPane.showInputDialog(
      "O ano de publicação está " + book.getAnoDePublicacao() + ". Qual é o novo?",
      book.getEditora()
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
      JOptionPane.showMessageDialog(
        null,
        "X_X Não tem livro cadastrado!",
        "⚠ Aviso.",
        JOptionPane.WARNING_MESSAGE
      );

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
