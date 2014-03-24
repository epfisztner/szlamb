package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


public abstract class AbstractGyuruSzovetsege implements GyuruSzovetsege {
	
	protected int eletero;
	
	protected int sebesseg;
	
	protected int aktualisMezoIndex;
	
	protected List<Mezo> utvonal;
	
	public AbstractGyuruSzovetsege(List<Mezo> utvonal){
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
	}

	@Override
	public void indul() {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
	}

	@Override
	public void setUtvonal(List<Mezo> utvonal) {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		this.utvonal = utvonal;
	}

}
