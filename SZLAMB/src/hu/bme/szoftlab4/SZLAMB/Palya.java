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
import java.util.Random;

/**
 * A játék teret reprezentáló osztály,
 *  ő felel a {@link GyuruSzovetsege}, {@link Mezo} illetve {@link Epitmeny} objektumok létrehozásáért és nyilvántartásáért.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Palya {
	/**
	 * Játék mezői (maga a pálya)
	 */
	protected Mezo[][] mezok;
	
	/**
	 * Még hátra levő ellenségek száma.
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
	
	/**
	 * szerkesztve
	 * a pálya útvonalainak listályát tárolja lista a listában jelleggel.
	 */
	protected List<List<Mezo>> utvonalak;
	
	/**
	 * szerkesztve
	 * a játékban még életben lévő karakterek listája
	 */
	protected List<GyuruSzovetsege> karakterek;
	
	private static String className;
	
	public Palya() {
		System.out.println("\t\t-->"+this.getClass().getName()+".constructor()");
		className = this.getClass().getName();
		this.mezok = new Mezo[5][5];
		ellensegeSzama = 0;
		this.prototipusokEpitmeny = new ArrayList<Epitmeny>();
		this.prototipusokGyuru = new ArrayList<GyuruSzovetsege>();
		palyaEpites(new File(""));
		createPrototypes();
		System.out.println("\t\t<--");
	}
	/**
	 * Játék indítása, {@link GyuruSzovetsege} karakterek elindítása az útvonalon
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
	 * Amennyiben elpusztul egy ellenség ez a metódus hívódik meg 
	 * az ellenség számának csökkentéséért illetve 0 értékének vizsgálatára.
	 */
	public static void ellensegCsokkent() {
		System.out.println("\t\t\t\t\t-->"+className+".ellensegCsokkent");
		System.out.print("\t\t\t\t\t\t[?] Ez volt az utolso ellenseg (igen/nem): ");
		String input = Main.input();
		if(input.equalsIgnoreCase("igen")) {
			JatekMotor.jatekVegeNyert();
		}
		System.out.println("\t\t\t\t\t<--void");
	}
	/**
	 * Pálya felépítése a paraméterben kapott file alapján:
	 * 0/UresMezo | 1/Ut | x/VegzetHegye
	 * 
	 * @param file
	 */
	public void palyaEpites(File file) {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".palyaEpites()");
		mezok[0][0] = new Ut();
		mezok[0][1] = new UresMezo();
        mezok[0][2] = new VegzetHegye();
		System.out.println("\t\t\t<--void");
	}
	
	/**
	 * Prototípusok létrehozása a játék indításakor.
	 */
	private void createPrototypes() {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".createPrototypes()");
		prototipusokEpitmeny.add(new Torony());
		prototipusokEpitmeny.add(new Akadaly());
		prototipusokGyuru.add(new Ember(utvonalak.get(0)));
		prototipusokGyuru.add(new Hobbit(utvonalak.get(0)));
		prototipusokGyuru.add(new Torp(utvonalak.get(0)));
		prototipusokGyuru.add(new Tunde(utvonalak.get(0)));
		System.out.println("\t\t\t<--void");
	}
	
	private void kodRandom() {
		boolean vanKod = false;
		Random r = new Random();
		int num = r.nextInt();
		if (num%11==0) {
			
		}
		for (int x = 0; x < mezok.length; x++) {
			for (int y = 0; y < mezok[x].length; y++) {
				mezok[x][y].setKod(vanKod);
			}
		}
	}
	
	

}
