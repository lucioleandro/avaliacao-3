package decorator;

import models.Livro;

public class DigitalDecorator extends CalculadorPrecoLivroDecorator {

	public DigitalDecorator(CalculadorPrecoLivro calculador) {
		super(calculador);
	}

	@Override
	public double calcularPreco(Livro livro) {
		// desconto de 15% do valor referência
		double valor = livro.getPreco() - livro.getPreco() * 0.15;
		livro.setPreco(valor);
		return livro.getPreco();
	}

}
