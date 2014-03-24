package hu.bme.szoftlab4.SZLAMB;

import java.io.File;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

public class Palya {
	
	protected List<Mezo> mezok;
	
	protected int ellensegeSzama;
	
	protected List<Epitmeny> prototipusokEpitmeny;
	
	protected List<GyuruSzovetsege> prototipusokGyuru;
	
	public Palya() {
		
	}
	
	public void start() {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
	}
	
	public List<GyuruSzovetsege> getPrototipusokGyuru() {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		return prototipusokGyuru;
	}

	public List<Epitmeny> getPrototipusokEpitmeny() {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		return prototipusokEpitmeny;
	}

	public void ellensegCsokkent() {
		this.ellensegeSzama--;
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
	}
	
	public void palyaEpites(File file) {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
	}
	
	private void createPrototypes() {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
	}
	
	

}
