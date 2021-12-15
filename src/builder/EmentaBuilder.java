package builder;

import models.Ementa;

public class EmentaBuilder extends AbstractCursoBuilder<Ementa>{
	
	public static EmentaBuilder factory() {
		return new EmentaBuilder();
	}
	
	public Ementa build() {
		return new Ementa(this.codigo, this.nome, this.disciplinas, this.livros);
	}

}
