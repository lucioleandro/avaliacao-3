package models;

import decorator.CalculadorPrecoLivro;
import prototype.Prototipavel;

public class Livro extends Produto implements CalculadorPrecoLivro {
	
	private String isbn;
	private double preco;
	
	public Livro(Livro livro) {
		super(livro);
		this.isbn = livro.isbn;
		this.preco = livro.preco;
	}	
	
	public Livro(String codigo, String nome) {
		super(codigo, nome);
	}
	
	public Livro(String codigo, String nome, String isbn,
				double preco) {
		super(codigo, nome);
		this.isbn = isbn;
		this.preco = preco;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return this.preco;
	}
	
	public String toString() {
		return "#Livro#" + super.toString();
	}

	@Override
	public Prototipavel prototipar() {
		return new Livro(this);
	}

	@Override
	public double calcularPreco(Livro livro) {
		return this.preco;
	}
	
	

}
