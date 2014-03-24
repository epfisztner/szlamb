package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

public abstract class AbstractMezo implements Mezo {
	
	protected Epitmeny epitmeny;
	
	protected List<GyuruSzovetsege> karakterek;
	
	protected List<Mezo> szomszedok;
	
	protected boolean beepitett;
	
	public AbstractMezo() {
		super();
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		System.out.println("\t\t\t\t<--");
	}

	@Override
	public boolean isBeepitett() {
		System.out.println("\t-->"+this.getClass().getName()+".isBeepitett()");
		System.out.print("[?] Beepitett? [igen/nem] :");
		String input = Main.input();
		if (input.equalsIgnoreCase("igen")) {
			this.beepitett = true;
		} else {
			this.beepitett = false;
		}
		System.out.println("\t<--boolean: "+beepitett);
		return this.beepitett;
	}
	
	@Override
	public void setSzomszedok(int szomszedSugar) {
		System.out.println("\t-->"+this.getClass().getName()+".setSzomszedok("+szomszedSugar+")");
		System.out.println("\t<--void");
	}
	
	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t-->"+this.getClass().getName()+".karakterRegiszter("+gyuruSzovetsege.getClass().getName()+")");
		this.epitmeny.reakcio(gyuruSzovetsege);
		System.out.println("\t<--void");
	}

}
