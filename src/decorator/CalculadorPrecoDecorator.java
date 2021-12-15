package decorator;

import models.Livro;

// Base decorator
public abstract class CalculadorPrecoDecorator {
	
	// wrapee
	protected CalculadorPrecoDecorator calculador;
	
	public CalculadorPrecoDecorator(CalculadorPrecoDecorator calculador) {
		this.calculador = calculador;
	}
	
	public double efetuarCalculo(Livro livro) {
		this.calcularPreco(livro);
		
		if(calculador != null) {
			calculador.calcularPreco(livro);
		}
		return livro.getPreco();
	}
	
	public abstract void calcularPreco(Livro livro);
}
