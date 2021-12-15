package models;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import composite.Cursavel;
import observer.CheckpointListener;
import prototype.Prototipavel;
import state.CursoState;
import state.EmAndamentoState;
import state.OperacaoInvalida;

public class Curso extends Produto implements Cursavel {
	
	public class Situacao {
		
		private Curso curso;
		private Map<String, Cursavel> disciplinas;
		
		public Situacao(Curso curso, Map<String, Cursavel> disciplinas) {
			this.curso = curso;
			this.disciplinas = new HashMap<String, Cursavel>();
			for(String codigo : disciplinas.keySet())
				this.disciplinas.put(codigo, 
									 (Cursavel) ((Disciplina) disciplinas.get(codigo)).prototipar());
		}
		
		public void restore() {
			this.curso.disciplinas = this.disciplinas;
		}
		
		public Map<String, Cursavel> getDisciplinas() {
			return this.disciplinas;
		}
		
	}
	
	
	private Map<String, Cursavel> disciplinas;
	private List<Livro> livros;
	private CursoState cursoState;
	private List<CheckpointListener> checkpointListeners;
	
	
	private Curso(Curso curso) {
		super(curso);
		this.disciplinas = new HashMap<String, Cursavel>();
		for(String codigo : curso.disciplinas.keySet())
			this.disciplinas.put(codigo, 
								 (Cursavel) ((Disciplina) curso.disciplinas.get(codigo)).prototipar());
		this.livros = new LinkedList<Livro>();
		for(Livro l : curso.livros)
			this.livros.add((Livro)l.prototipar());
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		for(CheckpointListener listener : curso.checkpointListeners)
			this.checkpointListeners.add(listener);
		this.cursoState = curso.cursoState;
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.disciplinas = new HashMap<String, Cursavel>();
		this.livros = new LinkedList<Livro>();
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		this.cursoState = new EmAndamentoState();
	}
	
	public Curso(String codigo, String nome, 
				 List<Disciplina> disciplinas,
				 List<Livro> livros) {
		super(codigo, nome);
		this.disciplinas = new HashMap<String, Cursavel>();
		for(Disciplina d : disciplinas)
			this.disciplinas.put(d.getCodigo(), d);
		this.livros = new LinkedList<Livro>(livros);
		this.checkpointListeners = new LinkedList<CheckpointListener>();	
		this.cursoState = new EmAndamentoState();
	}	
	
	@Override
	public double getPreco() {
		double precoTotalCursaveis = 0.0;
		double precoTotalLivros = 0.0;
		
		for(Cursavel cursavel: this.disciplinas.values()) {
			precoTotalLivros += cursavel.getPreco();
		}
		precoTotalCursaveis -= precoTotalCursaveis * 0.2; // Aplicação do desconto de 20%
		
		for(Livro livro: this.livros) {
			precoTotalLivros += livro.getPreco();
		}
		precoTotalLivros -= precoTotalLivros * 0.1; // Aplicação do desconto de 10%
		
		return precoTotalCursaveis + precoTotalLivros;
	}
	
	@Override
	public double getCHCumprida() {
		double chCumprida = 0.0;
		
		for(Cursavel cursavel: this.disciplinas.values()) {
			chCumprida += cursavel.getCHCumprida();
		}
		
		return chCumprida;
	}
	
	@Override
	public double getPctCumprido() {
		double pctCumprido = 0.0;
		for(Cursavel cursavel: this.disciplinas.values()) {
			pctCumprido += cursavel.getPctCumprido();
		}
		return pctCumprido;
	}
	
	public String toString() {
		String rep =  "[Curso] "  + this.getCodigo() + "-" + this.getNome() + "\n"; 
		for(Cursavel disciplina : this.disciplinas.values())
			rep = rep + disciplina + "\n";
		return rep;
	}
	
	public String emitirCertificado()  throws OperacaoInvalida{
		return this.cursoState.emitirCertificado(this.getCodigo(), this.getNome(), this.disciplinas);
	}

	@Override
	public Prototipavel prototipar() {
		return new Curso(this);
	}	
	
	public void avancar(String cdDisciplina, double pct) throws OperacaoInvalida {
		this.cursoState.avancar(this.disciplinas, cdDisciplina,  pct);

	}
	
	public Situacao checkpoint() throws OperacaoInvalida {
		return this.cursoState.checkpoint(this, this.disciplinas, this.checkpointListeners);
	}

	public void restore(Situacao situacao) throws OperacaoInvalida {
		 this.cursoState.restore(situacao, this.checkpointListeners);
	}		
	
	public void addCheckpointListener(CheckpointListener listener) {
		this.checkpointListeners.add(listener);
	}
	
	public void removeCheckpointListener(CheckpointListener listener) {
		this.checkpointListeners.remove(listener);
	}

	public void continuar() {
		this.cursoState = this.cursoState.continuar();
	}

	public void suspender() {
		this.cursoState = this.cursoState.suspender();
	}

	public void concluir() {
		this.cursoState =  this.cursoState.concluir(this.disciplinas);
	}

	public void cancelar() {
		this.cursoState =  this.cursoState.cancelar();	
	}

}
