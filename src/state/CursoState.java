package state;

import java.util.List;
import java.util.Map;

import composite.Cursavel;
import models.Curso;
import models.Curso.Situacao;
import observer.CheckpointListener;

public interface CursoState {

	public void avancar(Map<String, Cursavel> disciplinas, String cdDisciplina, double pct) throws OperacaoInvalida;
	public Situacao checkpoint(Curso curso, Map<String, Cursavel> disciplinas, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public String emitirCertificado(String cod, String nome, Map<String, Cursavel> disciplinas) throws OperacaoInvalida;
	public CursoState continuar();
	public CursoState suspender();
	public CursoState concluir(Map<String, Cursavel> disciplinas);
	public CursoState cancelar();

}
