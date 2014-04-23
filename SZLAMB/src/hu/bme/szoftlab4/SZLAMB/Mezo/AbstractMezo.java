package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.ArrayList;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

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
	protected boolean beepitett = false;
	
	protected int x;
	
	protected int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public AbstractMezo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		//System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		//System.out.println("\t\t\t\t<--");
	}
	
	@Override
	public boolean isBeepitett() {
		//System.out.println("\t-->"+this.getClass().getName()+".isBeepitett()");
		//System.out.print("\t\t[?] Beepitett? [igen/nem] :");
		//String input = Main.input();
		//if (input.equalsIgnoreCase("igen")) {
		//	this.beepitett = true;
		//} else {
		//	this.beepitett = false;
		//}
		//System.out.println("\t<--boolean: "+beepitett);
		return this.beepitett;
	}
	
	@Override
	public void setSzomszedok(int szomszedSugar) {
		//System.out.println("\t-->"+this.getClass().getName()+".setSzomszedok("+szomszedSugar+")");
		//System.out.println("\t<--void");	
		szomszedok = new ArrayList<Mezo>();
		int tempX = 0;
		int tempY = 0;
		ciklus:
		for (int x = 0; x < Palya.getMezok().length; x++) {
			for (int y = 0; y < Palya.getMezok().length; y++) {
				if (Palya.getMezok()[x][y].equals(this)){
					tempX = x;
					tempY = y;
					break ciklus;
				}
			}
		}
		for (int x = tempX-szomszedSugar; x <= tempX+szomszedSugar; x++) {
			for (int y = tempY-szomszedSugar; y <= tempY+szomszedSugar; y++) {
				if ( x == tempX && y == tempY){
				} else if( x < 0 || x > Palya.getMezok().length-1 || y < 0 || y > Palya.getMezok().length-1){
				} else {
					this.szomszedok.add(Palya.getMezok()[x][y]);
				}
			}
		}
		
		
	}
	
	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege, boolean szomszedCall) {
		//System.out.println("\t-->"+this.getClass().getName()+".karakterRegiszter("+gyuruSzovetsege.getClass().getName()+")");
		if (this.epitmeny != null) {
			this.epitmeny.reakcio(gyuruSzovetsege);
		} 
		if (!szomszedCall) {
			for (Mezo mezo : this.szomszedok) {
				mezo.karakterRegiszter(gyuruSzovetsege, true);
			}
		}
		//System.out.println("\t<--void");
	}

}
