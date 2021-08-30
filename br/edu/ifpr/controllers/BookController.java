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
    try {
      String titulo = JOptionPane.showInputDialog("Digite o titulo");

      int paginas = Integer.parseInt(
        JOptionPane.showInputDialog(
          "Quantas páginas o livro " + titulo + " tem?"
        )
      );
  
      String autor = JOptionPane.showInputDialog(
        "Quem escreveu o livro " + titulo + "?"
      );
  
      String genero = JOptionPane.showInputDialog(
        "Qual é o gênero " + titulo + "?"
      );
  
      String editora = JOptionPane.showInputDialog(
        "Qual é a editora do livro " + titulo + "?"
      );
      
      String anoDePublicacao = JOptionPane.showInputDialog(
        "E qual é o ano de publicação do livro " + titulo + "?"
      );
  
      this.booksRepository.create(
        titulo, 
        paginas, 
        autor, 
        genero, 
        editora, 
        anoDePublicacao
      );
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(
        null, 
        "Você precisa digitar um número!",
        "⚠ Error!",
        JOptionPane.ERROR_MESSAGE
      );
    }
  }

  public void show() {
    Book[] books = this.booksRepository.all();

    JOptionPane.showMessageDialog(
      null, 
      books,
      "📚 Livros Cadastrados",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  public void update() {
    Book selectedBook = selectBook();

    System.out.println(" " + selectedBook.getTitulo());
  }

  public Book selectBook() {
    Book[] books = this.booksRepository.all();

    Book book = (Book) JOptionPane.showInputDialog(
      null, 
      "Usuários Cadastrados",
      "Usuários Cadastrados", 
      JOptionPane.ERROR_MESSAGE, 
      null,
      books,
      books[0]
    );

    return book;
  }
}
