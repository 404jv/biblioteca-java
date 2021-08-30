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
    Book book = selectBook();

    String titulo = JOptionPane.showInputDialog(
      "O titulo atual está " + book.getTitulo() + ". Qual é o novo?", 
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
