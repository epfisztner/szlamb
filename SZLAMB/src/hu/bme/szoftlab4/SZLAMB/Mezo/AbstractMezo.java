package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

/**
 * Ez az oszt�ly a {@link Mezo} abstract implement�ci�ja, ebben az oszt�lyban
 * implement�ljuk az �sszes lesz�rmazott �ltal k�z�sen �rtelmezett met�dusokat.
 * 
 * @author Erhard Pfisztner
 */
public abstract class AbstractMezo implements Mezo {
	
	/**
	 * {@link Epitmeny} amit az adott mez�re �p�tett a j�t�kos.
	 */
	protected Epitmeny epitmeny;
	
	/**
	 * {@link GyuruSzovetsege} lista, mely az aktu�lisan a mez�n( {@link Ut}) 
	 * elhelyezked� karaktereket tartja nyilv�n.
	 */
	protected List<GyuruSzovetsege> karakterek;
	
	/**
	 * {@link Mezo} szomsz�dos mez�k nyilv�ntart�sa, melyet arra haszn�lunk,
	 * hogy az aktu�lis mez� �rtes�thesse a hat�t�von bel�l es� szomsz�dok tornyait a karakter �rkezt�r�l.
	 */
	protected List<Mezo> szomszedok;
	
	/**
	 * Amennyiben a mez�re m�r �p�tett a j�t�kos mez�t �gy ezen �rt�k fogja sz�munkra nyilv�natartani.
	 */
	protected boolean beepitett;
	
	public AbstractMezo() {
		super();
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		System.out.println("\t\t\t\t<--");
	}

	/**
	 * Visszat�r a beepitett mez� �rt�k�vel.
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
	 * Be�ll�tja a mez� szomsz�dait a sug�r alapj�n.
	 */
	@Override
	public void setSzomszedok(int szomszedSugar) {
		System.out.println("\t-->"+this.getClass().getName()+".setSzomszedok("+szomszedSugar+")");
		System.out.println("\t<--void");
	}
	
	/**
	 * Amennyiben karakter l�p a mez�re reag�ltatja a az �p�tm�ny�t.
	 */
	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t-->"+this.getClass().getName()+".karakterRegiszter("+gyuruSzovetsege.getClass().getName()+")");
		this.epitmeny.reakcio(gyuruSzovetsege);
		System.out.println("\t<--void");
	}

}
