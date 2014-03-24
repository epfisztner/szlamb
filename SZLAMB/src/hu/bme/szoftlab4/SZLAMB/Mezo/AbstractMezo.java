package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

/**
 * Ez az osztály a {@link Mezo} abstract implementációja, ebben az osztályban
 * implementáljuk az összes leszármazott által közösen értelmezett metódusokat.
 * 
 * @author Erhard Pfisztner
 */
public abstract class AbstractMezo implements Mezo {
	
	/**
	 * {@link Epitmeny} amit az adott mezõre épített a játékos.
	 */
	protected Epitmeny epitmeny;
	
	/**
	 * {@link GyuruSzovetsege} lista, mely az aktuálisan a mezõn( {@link Ut}) 
	 * elhelyezkedõ karaktereket tartja nyilván.
	 */
	protected List<GyuruSzovetsege> karakterek;
	
	/**
	 * {@link Mezo} szomszédos mezõk nyilvántartása, melyet arra használunk,
	 * hogy az aktuális mezõ értesíthesse a hatótávon belül esõ szomszédok tornyait a karakter érkeztérõl.
	 */
	protected List<Mezo> szomszedok;
	
	/**
	 * Amennyiben a mezõre már épített a játékos mezõt úgy ezen érték fogja számunkra nyilvánatartani.
	 */
	protected boolean beepitett;
	
	public AbstractMezo() {
		super();
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		System.out.println("\t\t\t\t<--");
	}

	/**
	 * Visszatér a beepitett mezõ értékével.
	 * @return beepitett
	 */
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
	
	/**
	 * Beállítja a mezõ szomszédait a sugár alapján.
	 */
	@Override
	public void setSzomszedok(int szomszedSugar) {
		System.out.println("\t-->"+this.getClass().getName()+".setSzomszedok("+szomszedSugar+")");
		System.out.println("\t<--void");
	}
	
	/**
	 * Amennyiben karakter lép a mezõre reagáltatja a az építményét.
	 */
	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t-->"+this.getClass().getName()+".karakterRegiszter("+gyuruSzovetsege.getClass().getName()+")");
		this.epitmeny.reakcio(gyuruSzovetsege);
		System.out.println("\t<--void");
	}

}
