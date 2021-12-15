import decorator.CalculadorPrecoDecorator;
import decorator.CapaDuraDecorator;
import decorator.ColoridoDecorator;
import decorator.DigitalDecorator;
import models.Livro;

public class TestaDecorator {

	public static void main(String[] args) {
		Livro livro = new Livro(null, null, null, 100);

		
		CalculadorPrecoDecorator primeiroCaso = new DigitalDecorator(new ColoridoDecorator(null));
		System.out.println(primeiroCaso.efetuarCalculo(livro));

		livro.setPreco(100);
		
		CalculadorPrecoDecorator segundoCaso = new CapaDuraDecorator(null);
		System.out.println(segundoCaso.efetuarCalculo(livro));
	}
}
