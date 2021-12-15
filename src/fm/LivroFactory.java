package fm;

import models.Livro;
import models.Produto;

public class LivroFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Livro(codigo, nome);
	}

}
