package br.edu.ifpr.model;

public class Book {
  private String titulo;
  private int paginas;
  private String autor;
  private String genero;
  private String editora;
  private String anoDePublicacao;

  public Book(
    String titulo, 
    int paginas, 
    String autor, 
    String genero, 
    String editora, 
    String anoDePublicacao
  ) {
    this.titulo = titulo;
    this.paginas = paginas;
    this.autor = autor;
    this.genero = genero;
    this.editora = editora;
    this.anoDePublicacao = anoDePublicacao;
  }
  
  @Override
  public String toString() {
    return this.titulo;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getPaginas() {
    return paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getEditora() {
    return editora;
  }

  public void setEditora(String editora) {
    this.editora = editora;
  }

  public String getAnoDePublicacao() {
    return anoDePublicacao;
  }

  public void setAnoDePublicacao(String anoDePublicacao) {
    this.anoDePublicacao = anoDePublicacao;
  }
}
