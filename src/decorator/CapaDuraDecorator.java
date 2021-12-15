package decorator;

import models.Livro;

public class CapaDuraDecorator extends CalculadorPrecoDecorator {

	public CapaDuraDecorator(CalculadorPrecoDecorator calculador) {
		super(calculador);
	}

	@Override
	public void calcularPreco(Livro livro) {
		// acréscimo de 20% do valor referência
		double valor = livro.getPreco() + livro.getPreco() * 0.2;
		livro.setPreco(valor);
	}

}
