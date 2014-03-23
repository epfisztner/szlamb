package hu.bme.szoftlab4.SZLAMB;

import java.io.File;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

public class Palya {
	
	protected List<Mezo> mezok;
	
	protected int ellensegeSzama;
	
	protected List<GyuruSzovetsege> prototipusokGyuru;
	
	public Palya() {
		
	}
	
	public void start() {
		
	}
	
	public List<GyuruSzovetsege> getPrototipusokGyuru() {
		return prototipusokGyuru;
	}

	public List<Epitmeny> getPrototipusokEpitmeny() {
		return prototipusokEpitmeny;
	}

	public void ellensegCsokkent() {
		this.ellensegeSzama--;
	}

	protected List<Epitmeny> prototipusokEpitmeny;
	
	public void palyaEpites(File file) {
		
	}
	
	private void createPrototypes() {
		
	}
	
	

}
