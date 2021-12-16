package decorator;

import models.Livro;

// Base decorator
public abstract class CalculadorPrecoLivroDecorator implements CalculadorPrecoLivro {
	
	// wrapee
	protected CalculadorPrecoLivro calculador;
	
	public CalculadorPrecoLivroDecorator(CalculadorPrecoLivro calculador) {
		this.calculador = calculador;
	}
	
	public double efetuarCalculo(Livro livro) {
		this.calcularPreco(livro);
		
		if(calculador != null) {
			calculador.calcularPreco(livro);
		}
		return livro.getPreco();
	}
	
	public abstract double calcularPreco(Livro livro);
}
