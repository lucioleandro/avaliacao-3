import decorator.CalculadorPrecoLivroDecorator;
import decorator.CapaDuraDecorator;
import decorator.ColoridoDecorator;
import decorator.DigitalDecorator;
import models.Livro;

public class TestaDecorator {

	public static void main(String[] args) {
		Livro livro = new Livro(null, null, null, 100);

		
		CalculadorPrecoLivroDecorator primeiroCaso = new DigitalDecorator(new ColoridoDecorator(new Livro(livro)));
		System.out.println(primeiroCaso.efetuarCalculo(livro));

		livro.setPreco(100);
		
		CalculadorPrecoLivroDecorator segundoCaso = new CapaDuraDecorator(new Livro(livro));
		System.out.println(segundoCaso.efetuarCalculo(livro));
	}
}
