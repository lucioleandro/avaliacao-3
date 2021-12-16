package adapter;

import composite.Cursavel;

//ADAPTADOR
public class AdaptadorWebnarToCursavel implements Cursavel {
	
	// Adaptee
	private WebnarIF webnar;
	
	public AdaptadorWebnarToCursavel(WebnarIF webnar) {
		this.webnar = webnar;
	}
	
	@Override
	public double getPreco() {
		return this.webnar.getPrice();
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
	
	public void avancar() {
		this.webnar.play();
	}

}
