package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


public abstract class AbstractGyuruSzovetsege implements GyuruSzovetsege {
	
	protected int eletero;
	
	protected int sebesseg;
	
	protected int aktualisMezoIndex;
	
	protected List<Mezo> utvonal;
	
	public AbstractGyuruSzovetsege(List<Mezo> utvonal){
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void indul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUtvonal(List<Mezo> utvonal) {
		this.utvonal = utvonal;
	}

}
