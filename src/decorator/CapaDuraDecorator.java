package decorator;

import models.Livro;

public class CapaDuraDecorator extends CalculadorPrecoLivroDecorator {

	public CapaDuraDecorator(CalculadorPrecoLivro calculador) {
		super(calculador);
	}

	@Override
	public double calcularPreco(Livro livro) {
		// acréscimo de 20% do valor referência
		double valor = livro.getPreco() + livro.getPreco() * 0.2;
		livro.setPreco(valor);
		return livro.getPreco();
	}

}
