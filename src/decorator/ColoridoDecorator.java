package decorator;

import models.Livro;

public class ColoridoDecorator extends CalculadorPrecoDecorator {

	public ColoridoDecorator(CalculadorPrecoDecorator calculador) {
		super(calculador);
	}

	@Override
	public void calcularPreco(Livro livro) {
		// acréscimo de 5% do valor referência
		double valor = livro.getPreco() + livro.getPreco() * 0.05;
		livro.setPreco(valor);
	}

}
