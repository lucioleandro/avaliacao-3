package adapter;

import composite.Cursavel;

//ADAPTADOR
public class AdaptadorWebnarToDisciplina implements Cursavel {
	
	// Adaptee
	private WebnarIF webnar;
	
	public AdaptadorWebnarToDisciplina(WebnarIF webnar) {
		this.webnar = webnar;
	}
	
	@Override
	public double getPreco() {
		return this.webnar.getPrice();
	}
	
	// Sobrecarga ao invés de sobrescrita pq o adaptee não precisa de parâmetro nesse caso.
	public void avancar() {
		this.webnar.play();
	}
	
	public int getCHTotal() {
		return Long.valueOf(this.webnar.getMinutes()).intValue();
	}
	
	@Override
	public double getCHCumprida() {
		return this.getCHTotal() * this.getPctCumprido();
	}

	@Override
	public double getPctCumprido() {
		if(this.webnar.wasWatched()) {
			return 100;
		}
		return 0;
	}
	

}
