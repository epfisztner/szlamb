package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Ember;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Hobbit;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Torp;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Tunde;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.UresMezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
import hu.bme.szoftlab4.SZLAMB.Mezo.VegzetHegye;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Palya {
	
	protected List<Mezo> mezok;
	
	protected static int ellensegeSzama;
	
	protected List<Epitmeny> prototipusokEpitmeny;
	
	protected List<GyuruSzovetsege> prototipusokGyuru;

	private static String className;
	
	public Palya() {
		System.out.println("\t\t-->"+this.getClass().getName()+".constructor()");
		className = this.getClass().getName();
		this.mezok = new ArrayList<Mezo>();
		ellensegeSzama = 0;
		this.prototipusokEpitmeny = new ArrayList<Epitmeny>();
		this.prototipusokGyuru = new ArrayList<GyuruSzovetsege>();
		palyaEpites(new File(""));
		createPrototypes();
		System.out.println("\t\t<--");
	}

	public void start() {
		System.out.println("\t\t-->"+this.getClass().getName()+".start()");
		for (GyuruSzovetsege gyuruSzovetsege : prototipusokGyuru) {
			gyuruSzovetsege.indul();
		}
		System.out.println("\t\t<--void");
	}
	
	public List<GyuruSzovetsege> getPrototipusokGyuru() {
		System.out.println("\t-->" + this.getClass().getName() + ".getPrototipusokGyuru()");
		System.out.println("\t<--" + prototipusokGyuru.getClass().getName() + ": " + prototipusokGyuru.toString());
		return prototipusokGyuru;
	}

	public List<Epitmeny> getPrototipusokEpitmeny() {
		System.out.println("\t-->"+this.getClass().getName()+".getPrototipusokEpitmeny()");
		System.out.println("\t<--" + prototipusokEpitmeny.getClass().getName() + ": " + prototipusokEpitmeny.toString());
		return prototipusokEpitmeny;
	}

	public static void ellensegCsokkent() {
		System.out.println("\t-->"+className+".ellensegCsokkent");
		System.out.println("\t\t[?] Ez volt az utolso ellenseg (igen/nem): ");
		String input = Main.input();
		if(input.equalsIgnoreCase("igen")) {
			JatekMotor.jatekVegeNyert();
		}
		System.out.println("\t<--void");
	}
	
	public void palyaEpites(File file) {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".palyaEpites()");
		mezok.add(new Ut());
		mezok.add(new VegzetHegye());
		mezok.add(new UresMezo());
		System.out.println("\t\t\t<--void");
	}
	
	private void createPrototypes() {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".createPrototypes()");
		prototipusokEpitmeny.add(new Torony());
		prototipusokEpitmeny.add(new Akadaly());
		prototipusokGyuru.add(new Ember(new ArrayList<Mezo>()));
		prototipusokGyuru.add(new Hobbit(new ArrayList<Mezo>()));
		prototipusokGyuru.add(new Torp(new ArrayList<Mezo>()));
		prototipusokGyuru.add(new Tunde(new ArrayList<Mezo>()));
		System.out.println("\t\t\t<--void");
	}
	
	

}
