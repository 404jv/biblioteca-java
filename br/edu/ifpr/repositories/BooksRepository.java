package br.edu.ifpr.repositories;

import java.util.ArrayList;

import br.edu.ifpr.model.Book;

public class BooksRepository {
  private ArrayList<Book> books;
  private static BooksRepository INSTANCE;

  private BooksRepository() {
    this.books = new ArrayList<>();
  }

  public static BooksRepository getInstance() {
    if (BooksRepository.INSTANCE == null) {
      BooksRepository.INSTANCE = new BooksRepository();
    }

    return BooksRepository.INSTANCE;
  }

  public void create(
    String titulo, 
    int paginas, 
    String autor,  
    String genero,
    String editora, 
    String anoDePublicacao
  ) {
    Book book = new Book(
      titulo, 
      paginas, 
      autor, 
      genero, 
      editora, 
      anoDePublicacao
    );

    this.books.add(book);
  }

  public Book[] all() {
    Book[] books = this.books.toArray(new Book[this.books.size()]);

    return books;
  }
}
