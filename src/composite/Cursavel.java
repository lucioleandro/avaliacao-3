package composite;

public interface Cursavel {
	
	// Não coloquei apenas o getPreco pois além do cálculo do preço cursaveis tbm tem a caracteristica em comum
	// do cálculo da chCumproda e PctCumprida
	double getPreco();
	double getCHCumprida();
	double getPctCumprido();
}
