package hu.bme.szoftlab4.SZLAMB;

import java.util.List;

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
	private static Palya palya;
	
	/**
	 * A játékos varázsereje.
	 */
	private int varazsEro;
	
	public Szaruman(Mezo[][] mezo, List<List<Mezo>> utvonalak) {
		//System.out.println("\t-->"+this.getClass().getName()+".constructor()");
		this.varazsEro = 100;
		palya = new Palya(this,mezo, utvonalak);
		//System.out.println("\t<--");
	}

	/**
	 * A paraméterben kapott {@link Mezo} -re új {@link Torony} építése.
	 * 
	 * @param mezo
	 */
	public void epitTorony(Mezo mezo) {
		//System.out.println("-->"+this.getClass().getName()+".epitTorony("+mezo.getClass()+")");
		try {
			mezo.epitmenyRegiszter((Torony) this.getPalya().getPrototipusokEpitmeny().get(0).clone());
			this.incVarazsEro(this.getVarazsEro() - 10);
			this.palya.setSzarumanProgress(this.getVarazsEro());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("<--void");
	}
	
	/**
	 * A paraméterben kapott {@link Mezo} -re új {@link Akadaly} építése.
	 * 
	 * @param mezo
	 */
	public void epitAkadaly(Mezo mezo) {
		//System.out.println("-->"+this.getClass().getName()+".epitAkadaly("+mezo.getClass()+")");
		try {
			mezo.epitmenyRegiszter((Akadaly)this.getPalya().getPrototipusokEpitmeny().get(1).clone());
			this.incVarazsEro(this.getVarazsEro() - 5);
			palya.setSzarumanProgress(varazsEro);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("<--void");
	}
	
	/**
	 * A paraméterben kapott {@link Mezo} objektumon lévő {@link Epitmeny} objektum 
	 * felruházása(fejlesztése) a paraméterben adott {@link VarazsKo} -vel.
	 * 
	 * @param mezo
	 * @param varazsKo
	 */
	public void felruhaz(Mezo mezo, VarazsKo varazsKo) {
		//System.out.println("-->"+this.getClass().getName()+".epitAkadaly("+varazsKo.getClass()+")");
		mezo.epitmenyFelruhazas(varazsKo);
		this.incVarazsEro(this.getVarazsEro() - 10);
		this.palya.setSzarumanProgress(this.getVarazsEro());
		//System.out.println("<--void");
	}
	
	/**
	 * Játék indítása
	 */
	public void start() {
		//System.out.println("\t-->"+this.getClass().getName()+".start()");
		//getPalya().start();
		palya.start();
		//System.out.println("\t<--void");
	}

	public static Palya getPalya() {
		return palya;
	}

	public static void setPalya(Palya palya) {
		Szaruman.palya = palya;
	}

	public int getVarazsEro() {
		return varazsEro;
	}

	public void incVarazsEro(int varazsEro) {
		this.varazsEro += varazsEro;
	}
	
	public  void decVarazsEro(int varazsEro) {
		this.varazsEro -= varazsEro;
	}

}
