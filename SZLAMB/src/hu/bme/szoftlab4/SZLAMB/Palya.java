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

/**
 * A j�t�k teret reprezent�l� oszt�ly,
 *  � felel a {@link GyuruSzovetsege}, {@link Mezo} illetve {@link Epitmeny} objektumok l�trehoz�s��rt �s nyilv�ntart��s��rt.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Palya {
	/**
	 * J�t�k mez�i (maga a p�lya)
	 */
	protected List<Mezo> mezok;
	
	/**
	 * M�g h�tra lev� ellens�gek sz�ma.
	 */
	protected static int ellensegeSzama;
	
	/**
	 * {@link Epitmeny} prototipusok
	 */
	protected List<Epitmeny> prototipusokEpitmeny;
	
	/**
	 * {@link GyuruSzovetsege} prototipusok
	 */
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
	/**
	 * J�t�k ind�t�sa, {@link GyuruSzovetsege} karakterek elind�t�sa az �tvonalon
	 */
	public void start() {
		System.out.println("\t\t-->"+this.getClass().getName()+".start()");
		for (GyuruSzovetsege gyuruSzovetsege : prototipusokGyuru) {
			gyuruSzovetsege.indul();
		}
		System.out.println("\t\t<--void");
	}
	
	/**
	 * 
	 * @return
	 */
	public List<GyuruSzovetsege> getPrototipusokGyuru() {
		System.out.println("\t-->" + this.getClass().getName() + ".getPrototipusokGyuru()");
		System.out.println("\t<--" + prototipusokGyuru.getClass().getName() + ": " + prototipusokGyuru.toString());
		return prototipusokGyuru;
	}

	/**
	 * 
	 * @return
	 */
	public List<Epitmeny> getPrototipusokEpitmeny() {
		System.out.println("\t-->"+this.getClass().getName()+".getPrototipusokEpitmeny()");
		System.out.println("\t<--" + prototipusokEpitmeny.getClass().getName() + ": " + prototipusokEpitmeny.toString());
		return prototipusokEpitmeny;
	}

	/**
	 * Amennyiben elpusztul egy ellens�g ez a met�dus h�v�dik meg 
	 * az ellens�g sz�m�nak cs�kkent�s��rt illetve 0 �rt�k�nek vizsg�lat�ra.
	 */
	public static void ellensegCsokkent() {
		System.out.println("\t-->"+className+".ellensegCsokkent");
		System.out.println("\t\t[?] Ez volt az utolso ellenseg (igen/nem): ");
		String input = Main.input();
		if(input.equalsIgnoreCase("igen")) {
			JatekMotor.jatekVegeNyert();
		}
		System.out.println("\t<--void");
	}
	/**
	 * P�lya fel�p�t�se a param�terben kapott file alapj�n:
	 * 0/UresMezo | 1/Ut | x/VegzetHegye
	 * 
	 * @param file
	 */
	public void palyaEpites(File file) {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".palyaEpites()");
		mezok.add(new Ut());
		mezok.add(new VegzetHegye());
		mezok.add(new UresMezo());
		System.out.println("\t\t\t<--void");
	}
	
	/**
	 * Protot�pusok l�trehoz�sa a j�t�k ind�t�sakor.
	 */
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
