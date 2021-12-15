package fm;

import models.Disciplina;
import models.Produto;

public class DisciplinaFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}
