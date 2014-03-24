package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;

/**
 * Ez az osztály implementálja az {@link GyuruSzovetsege} interface által deklarált,
 * minden leszármazott által közösen értelmezett metódusokat.
 * 
 * @author Erhard Pfisztner
 *
 */
public abstract class AbstractGyuruSzovetsege implements GyuruSzovetsege {
	/**
	 * {@link GyuruSzovetsege} objektum életereje
	 */
	protected int eletero;
	
	/**
	 * {@link GyuruSzovetsege} objektum sebessége
	 */
	protected int sebesseg;
	
	/**
	 * Azon indek szám amelyiken {@link Mezo} -n éppen rajta van a karakter az utvonal-ból
	 */
	protected int aktualisMezoIndex;
	/**
	 * Az karakter által megteendõ útvonal
	 */
	protected List<Mezo> utvonal;

	public AbstractGyuruSzovetsege(List<Mezo> utvonal){
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor("+utvonal.toString()+")");
			this.setUtvonal(utvonal);
		System.out.println("\t\t\t\t<--");
	}
	/**
	 * Amennyiben elfogy a karakter életereje a sebzéskor ez a metódus hívódik meg.
	 */
	protected void elpusztul() {
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".elpusztul()");
		System.out.println("\t\t\t\t<--void");
	}

	@Override
	public void indul() {
		System.out.println("\t\t\t-->"+this.getClass().getName()+".indul()");
		System.out.println("\t\t\t<--void");
	}

	@Override
	public void setUtvonal(List<Mezo> utvonal) {
		System.out.println("\t\t\t\t\t-->"+this.getClass().getName()+".setUtvonal("+utvonal.toString()+")");
		System.out.println("\t\t\t\t\t<--void");
	}

}
