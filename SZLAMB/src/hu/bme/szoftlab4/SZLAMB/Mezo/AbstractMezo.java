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
	 * {@link Epitmeny} amit az adott mezőre épített a játékos.
	 */
	protected Epitmeny epitmeny;
	
	/**
	 * {@link GyuruSzovetsege} lista, mely az aktuálisan a mezőn( {@link Ut}) 
	 * elhelyezkedő karaktereket tartja nyilván.
	 */
	protected List<GyuruSzovetsege> karakterek;
	
	/**
	 * {@link Mezo} szomszédos mezők nyilvántartása, melyet arra használunk,
	 * hogy az aktuális mező értesíthesse a hatótávon belül eső szomszédok tornyait a karakter érkeztéről.
	 */
	protected List<Mezo> szomszedok;
	
	/**
	 * Amennyiben a mezőre már épített a játékos egy mezőt, ezen érték fogja számunkra nyilvántartani.
	 */
	protected boolean beepitett;
	
	public AbstractMezo() {
		super();
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		System.out.println("\t\t\t\t<--");
	}

	
	/**
	 * szerkesztve
	 * üres metódus nem csinál semmit
	 */
	public void setKod(boolean vanKod){}
	
	@Override
	public boolean isBeepitett() {
		System.out.println("\t-->"+this.getClass().getName()+".isBeepitett()");
		System.out.print("\t\t[?] Beepitett? [igen/nem] :");
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
