package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

/**
 * Ez az osztály valósítja meg magát a játékost reprezentáló objektumot.
 * A játékos varázsereje itt van nyilvántartva.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Szaruman {
	
	/**
	 * A játékban felhasznált játék mező.
	 */
	public static Palya palya;
	
	/**
	 * A játékos varázsereje.
	 */
	protected int varazsEro;
	
	public Szaruman() {
		System.out.println("\t-->"+this.getClass().getName()+".constructor()");
		this.varazsEro = 100;
		palya = new Palya();
		System.out.println("\t<--");
	}

	/**
	 * A paraméterben kapott {@link Mezo} -re új {@link Torony} építése.
	 * 
	 * @param mezo
	 */
	public void epitTorony(Mezo mezo) {
		System.out.println("-->"+this.getClass().getName()+".epitTorony("+mezo.getClass()+")");
		try {
			mezo.epitmenyRegiszter((Torony) this.palya.getPrototipusokEpitmeny().get(0).clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<--void");
	}
	
	/**
	 * A paraméterben kapott {@link Mezo} -re új {@link Akadaly} építése.
	 * 
	 * @param mezo
	 */
	public void epitAkadaly(Mezo mezo) {
		System.out.println("-->"+this.getClass().getName()+".epitAkadaly("+mezo.getClass()+")");
		try {
			mezo.epitmenyRegiszter((Akadaly)this.palya.getPrototipusokEpitmeny().get(1).clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("<--void");
	}
	
	/**
	 * A paraméterben kapott {@link Mezo} objektumon lévő {@link Epitmeny} objektum 
	 * felruházása(fejlesztése) a paraméterben adott {@link VarazsKo} -vel.
	 * 
	 * @param mezo
	 * @param varazsKo
	 */
	public void felruhaz(Mezo mezo, VarazsKo varazsKo) {
		System.out.println("-->"+this.getClass().getName()+".epitAkadaly("+varazsKo.getClass()+")");
		mezo.epitmenyFelruhazas(varazsKo);
		System.out.println("<--void");
	}
	
	/**
	 * Játék indítása
	 */
	public void start() {
		System.out.println("\t-->"+this.getClass().getName()+".start()");
		palya.start();
		System.out.println("\t<--void");
	}

}
