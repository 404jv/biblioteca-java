package br.edu.ifpr.repositories;

import java.util.ArrayList;

import br.edu.ifpr.model.Book;

public class BooksRepository {
  private ArrayList<Book> repository;
  private static BooksRepository INSTANCE;

  private BooksRepository() {
    this.repository = new ArrayList<>();
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
    int anoDePublicacao
  ) {
    Book book = new Book(
      titulo, 
      paginas, 
      autor, 
      genero, 
      editora, 
      anoDePublicacao
    );

    this.repository.add(book);
  }

  public Book[] all() {
    Book[] books = this.repository.toArray(new Book[this.repository.size()]);

    return books;
  }

  public void update(
    Book book,
    String titulo, 
    int paginas, 
    String autor,  
    String genero,
    String editora, 
    int anoDePublicacao
  ) {
    book.setTitulo(titulo);
    book.setPaginas(paginas);
    book.setAutor(autor);
    book.setGenero(genero);
    book.setEditora(editora);
    book.setAnoDePublicacao(anoDePublicacao);
  }

  public void delete(Book book) {
    this.repository.remove(book);
  }
}
