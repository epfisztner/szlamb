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
import hu.bme.szoftlab4.SZLAMB.View.View;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

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
	private static Mezo[][] mezok;
	
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
	private List<GyuruSzovetsege> karakterek;
	
	protected View view;
	
	private static String className;
	
	public Palya() {
		//System.out.println("\t\t-->"+this.getClass().getName()+".constructor()");
		className = this.getClass().getName();
		//this.mezok = mezok;
		ellensegeSzama = 0;
		
		//palyaEpites(new File(""));
		//createPrototypes();
		//System.out.println("\t\t<--");
	}
	/**
	 * Játék indítása, {@link GyuruSzovetsege} karakterek elindítása az útvonalon
	 */
	public void start() {
		//System.out.println("\t\t-->"+this.getClass().getName()+".start()");
		for (GyuruSzovetsege gyuruSzovetsege : prototipusokGyuru) {
			gyuruSzovetsege.indul();
		}
		//System.out.println("\t\t<--void");
	}
	
	/**
	 * 
	 * @return
	 */
	public List<GyuruSzovetsege> getPrototipusokGyuru() {
		//System.out.println("\t-->" + this.getClass().getName() + ".getPrototipusokGyuru()");
		//System.out.println("\t<--" + prototipusokGyuru.getClass().getName() + ": " + prototipusokGyuru.toString());
		return prototipusokGyuru;
	}

	/**
	 * 
	 * @return
	 */
	public List<Epitmeny> getPrototipusokEpitmeny() {
		//System.out.println("\t-->"+this.getClass().getName()+".getPrototipusokEpitmeny()");
		//System.out.println("\t<--" + prototipusokEpitmeny.getClass().getName() + ": " + prototipusokEpitmeny.toString());
		return prototipusokEpitmeny;
	}

	/**
	 * Amennyiben elpusztul egy ellenség ez a metódus hívódik meg 
	 * az ellenség számának csökkentéséért illetve 0 értékének vizsgálatára.
	 */
	public static void ellensegCsokkent() {
		//System.out.println("\t\t\t\t\t-->"+className+".ellensegCsokkent");
		//System.out.print("\t\t\t\t\t\t[?] Ez volt az utolso ellenseg (igen/nem): ");
		//String input = Main.input();
		//if(input.equalsIgnoreCase("igen")) {
		ellensegeSzama--;
		if (ellensegeSzama<1) {
			JatekMotor.jatekVegeNyert();
		} else {
			//XMLHelper.setOutPutFileContent("</karakterLep>");
		}
		//System.out.println("\t\t\t\t\t<--void");
	}
	/**
	 * Pálya felépítése a paraméterben kapott file alapján:
	 * 0/UresMezo | 1/Ut | x/VegzetHegye
	 * 
	 * @param file
	 */
	public void palyaEpites(Mezo[][] mezok, List<List<Mezo>> utvonalak) {
		//System.out.println("\t\t\t-->"+this.getClass().getName()+".palyaEpites()");
		setMezok(mezok);
		this.utvonalak = utvonalak;
		createPrototypes();
		karakterek = new ArrayList<GyuruSzovetsege>();
		ellensegeSzama = 0;
		for (int x = 0; x < getMezok().length; x++) {
			for (int y = 0; y < getMezok()[x].length; y++) {
				getMezok()[x][y].setSzomszedok(1);
			}
		}
		//System.out.println("\t\t\t<--void");
	}
	
	/**
	 * Prototípusok létrehozása a játék indításakor.
	 */
	private void createPrototypes() {
		//System.out.println("\t\t\t-->"+this.getClass().getName()+".createPrototypes()");
		this.prototipusokEpitmeny = new ArrayList<Epitmeny>();
		this.prototipusokGyuru = new ArrayList<GyuruSzovetsege>();
		prototipusokEpitmeny.add(new Torony());
		prototipusokEpitmeny.add(new Akadaly());
		prototipusokGyuru.add(new Ember());
		prototipusokGyuru.add(new Hobbit());
		prototipusokGyuru.add(new Torp());
		prototipusokGyuru.add(new Tunde());
		//System.out.println("\t\t\t<--void");
	}
	
	private void kodRandom() {
		boolean vanKod = false;
		Random r = new Random();
		int num = r.nextInt();
		if (num%11==0) {
			vanKod = !vanKod;
		}
		for (int x = 0; x < getMezok().length; x++) {
			for (int y = 0; y < getMezok()[x].length; y++) {
				getMezok()[x][y].setKod(vanKod);
			}
		}
	}
	public List<GyuruSzovetsege> getKarakterek() {
		return karakterek;
	}
	public void setKarakterek(List<GyuruSzovetsege> karakterek) {
		this.karakterek = karakterek;
		ellensegeSzama = this.karakterek.size();
	}
	public static Mezo[][] getMezok() {
		return mezok;
	}
	public static void setMezok(Mezo[][] mezokInput) {
		mezok = mezokInput;
	}
	
	

}
