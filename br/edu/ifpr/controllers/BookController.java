package br.edu.ifpr.controllers;

import javax.swing.JOptionPane;

import br.edu.ifpr.repositories.BooksRepository;

public class BookController {
  BooksRepository booksRepository;

  public BookController(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  
  public void create() {
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
  }
}
