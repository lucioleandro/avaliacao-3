package fm;

import models.Curso;
import models.Produto;

public class CursoFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Curso(codigo, nome);
	}

}
