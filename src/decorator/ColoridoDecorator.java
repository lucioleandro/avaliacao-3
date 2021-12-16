package decorator;

import models.Livro;

public class ColoridoDecorator extends CalculadorPrecoLivroDecorator {

	public ColoridoDecorator(CalculadorPrecoLivro calculador) {
		super(calculador);
	}

	@Override
	public double calcularPreco(Livro livro) {
		// acréscimo de 5% do valor referência
		double valor = livro.getPreco() + livro.getPreco() * 0.05;
		livro.setPreco(valor);
		return livro.getPreco();
	}

}
