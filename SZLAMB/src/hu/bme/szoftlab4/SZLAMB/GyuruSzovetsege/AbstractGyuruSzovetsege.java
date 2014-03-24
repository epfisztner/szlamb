package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


public abstract class AbstractGyuruSzovetsege implements GyuruSzovetsege {
	
	protected int eletero;
	
	protected int sebesseg;
	
	protected int aktualisMezoIndex;
	
	protected List<Mezo> utvonal;

	public AbstractGyuruSzovetsege(List<Mezo> utvonal){
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor("+utvonal.toString()+")");
			this.setUtvonal(utvonal);
		System.out.println("\t\t\t\t<--");
	}
	
	protected void elpusztul() {
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".elpusztul()");
		System.out.println("\t\t\t\t<--void");
	}

	@Override
	public void indul() {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".indul()");
		System.out.println("\t\t\t<--void");
	}

	@Override
	public void setUtvonal(List<Mezo> utvonal) {
		System.out.println("\t\t\t\t\t-->"+this.getClass().getName()+".setUtvonal("+utvonal.toString()+")");
		System.out.println("\t\t\t\t\t<--void");
	}

}
