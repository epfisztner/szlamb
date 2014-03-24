package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

/**
 * Ez az oszt�ly val�s�tja meg mag�t a j�t�kost reprezent�l� objektumot.
 * A j�t�kos var�zsereje itt van nyilv�ntartva.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Szaruman {
	
	/**
	 * A j�t�kban felhaszn�lt j�t�k mez�.
	 */
	public static Palya palya;
	
	/**
	 * A j�t�kos var�zsereje.
	 */
	protected int varazsEro;
	
	public Szaruman() {
		System.out.println("\t-->"+this.getClass().getName()+".constructor()");
		this.varazsEro = 100;
		palya = new Palya();
		System.out.println("\t<--");
	}

	/**
	 * A param�terben kapott {@link Mezo} -re �j {@link Torony} �p�t�se.
	 * 
	 * @param mezo
	 */
	public void epitTorony(Mezo mezo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitTorony("+mezo.getClass()+")");
		mezo.epitmenyRegiszter(new Torony());
		System.out.println("\t<--void");
	}
	
	/**
	 * A param�terben kapott {@link Mezo} -re �j {@link Akadaly} �p�t�se.
	 * 
	 * @param mezo
	 */
	public void epitAkadaly(Mezo mezo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitAkadaly("+mezo.getClass()+")");
		mezo.epitmenyRegiszter(new Akadaly());
		System.out.println("\t<--void");
	}
	
	/**
	 * A param�terben kapott {@link Mezo} objektumon l�v� {@link Epitmeny} objektum 
	 * felruh�z�sa(fejleszt�se) a param�terben adott {@link VarazsKo} -vel.
	 * 
	 * @param mezo
	 * @param varazsKo
	 */
	public void felruhaz(Mezo mezo, VarazsKo varazsKo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitAkadaly("+varazsKo.getClass()+")");
		mezo.epitmenyFelruhazas(varazsKo);
		System.out.println("\t<--void");
	}
	
	/**
	 * Jat�k ind�t�sa
	 */
	public void start() {
		System.out.println("\t-->"+this.getClass().getName()+".start()");
		palya.start();
		System.out.println("\t<--void");
	}

}
