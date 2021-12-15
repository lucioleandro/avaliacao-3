package state;

import java.util.List;
import java.util.Map;

import models.Curso;
import models.Disciplina;
import models.Curso.Situacao;
import observer.CheckpointListener;

public class SuspensoState extends AbstractCursoState implements CursoState {


	@Override
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas,
			List<CheckpointListener> checkpointListeners) throws OperacaoInvalida {
		this.notifyCheckpointEvent(disciplinas, checkpointListeners);
		return  curso.new Situacao(curso, disciplinas);
	}

	@Override
	public CursoState continuar() {
		return new EmAndamentoState();
	}

	@Override
	public CursoState cancelar() {
		return new CanceladoState();
	}

	@Override
	public String getNome() {
		return "SUSPENSO";
	}

}
