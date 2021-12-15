package state;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Curso;
import models.Disciplina;
import models.Curso.Situacao;
import observer.CheckpointData;
import observer.CheckpointListener;

public abstract class AbstractCursoState implements CursoState{
	
	
	private Map<String, Double> getPctConclusaoDisciplinas(Map<String, Disciplina> disciplinas){
		Map<String, Double> pctConclusao = new HashMap<String, Double>();
		for(Disciplina disciplina : disciplinas.values())
			pctConclusao.put(disciplina.getCodigo(), disciplina.getCHCumprida());
		return pctConclusao;
	}	
	
	
	protected boolean disciplinasConcluidas(Map<String, Disciplina> disciplinas){
		for(Disciplina disciplina : disciplinas.values())
			if (disciplina.getPctCumprido() < 1)
				return false;
		return true;
	}		
	
	public void notifyCheckpointEvent(Map<String, Disciplina> disciplinas, List<CheckpointListener> checkpointListeners) {
		CheckpointData data = new CheckpointData(this.getPctConclusaoDisciplinas(disciplinas));
		for(CheckpointListener listener : checkpointListeners)
			listener.notifyCheckpointEvent(data);
	}
	
	public void notifyRestoreEvent(Map<String, Disciplina> disciplinas, List<CheckpointListener> checkpointListeners) {
		CheckpointData data = new CheckpointData(this.getPctConclusaoDisciplinas(disciplinas));
		for(CheckpointListener listener : checkpointListeners)
			listener.notifyRestoreEvent(data);
	}	

	@Override
	public void avancar(Map<String, Disciplina> disciplinas, String cdDisciplina, double pct) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " n�o suporta a opera��o avan�ar");
	}

	@Override
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " n�o suporta a opera��o checkpoint");
	}

	@Override
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " n�o suporta a opera��o restore");
	}
	
	@Override
	public String emitirCertificado(String cod, String nome, Map<String, Disciplina> disciplinas) throws OperacaoInvalida{
		throw new OperacaoInvalida("O Estado " + this.getNome() + " n�o suporta a opera��o emitir certificado");
	};

	@Override
	public CursoState continuar() {
		return this;
	}

	@Override
	public CursoState suspender() {
		return this;
	}

	@Override
	public CursoState concluir(Map<String, Disciplina> disciplinas) {
		return this;
	}

	@Override
	public CursoState cancelar() {
		return this;
	}
	
	public abstract String getNome();
	
	
}
