package decorator;

import models.Livro;

public class DigitalDecorator extends CalculadorPrecoDecorator {

	public DigitalDecorator(CalculadorPrecoDecorator calculador) {
		super(calculador);
	}

	@Override
	public void calcularPreco(Livro livro) {
		// desconto de 15% do valor referência
		double valor = livro.getPreco() - livro.getPreco() * 0.15;
		livro.setPreco(valor);
	}

}
