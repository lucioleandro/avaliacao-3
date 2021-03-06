package builder;

import models.Disciplina;
import models.Livro;

public interface CursoBuilderIF<T> {
	public CursoBuilderIF<T> reset();
	public CursoBuilderIF<T> setNome(String nome);
	public CursoBuilderIF<T> setCodigo(String codigo);
	public CursoBuilderIF<T> addDisciplina(Disciplina disciplina);
	public CursoBuilderIF<T> addLivro(Livro livro);
	public T build();
}
