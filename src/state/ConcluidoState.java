package state;

import java.util.Map;

import composite.Cursavel;
import models.Produto;

public class ConcluidoState extends AbstractCursoState implements CursoState {

	@Override
	public String getNome() {
		return "CONCLUIDO";
	}
	
	
	public String emitirCertificado(String cod, String nome, Map<String, Cursavel> disciplinas) throws OperacaoInvalida{
		String rep = "CERTIFICADO\n";
		rep =  rep + "[Curso] "  + cod + "-" + nome + "\n"; 
			for(Cursavel disciplina : disciplinas.values())
				rep = rep + "\t[" + ((Produto) disciplina).getCodigo() + "] - "+ ((Produto) disciplina).getNome() + "\n";
			return rep;	
	};
	
	

}
