package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;

/**
 * Ez az oszt�ly implement�lja az {@link GyuruSzovetsege} interface �ltal deklar�lt,
 * minden lesz�rmazott �ltal k�z�sen �rtelmezett met�dusokat.
 * 
 * @author Erhard Pfisztner
 *
 */
public abstract class AbstractGyuruSzovetsege implements GyuruSzovetsege {
	/**
	 * {@link GyuruSzovetsege} objektum �letereje
	 */
	protected int eletero;
	
	/**
	 * {@link GyuruSzovetsege} objektum sebess�ge
	 */
	protected int sebesseg;
	
	/**
	 * Azon indek sz�m amelyiken {@link Mezo} -n �ppen rajta van a karakter az utvonal-b�l
	 */
	protected int aktualisMezoIndex;
	/**
	 * Az karakter �ltal megteend� �tvonal
	 */
	protected List<Mezo> utvonal;

	public AbstractGyuruSzovetsege(List<Mezo> utvonal){
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor("+utvonal.toString()+")");
			this.setUtvonal(utvonal);
		System.out.println("\t\t\t\t<--");
	}
	/**
	 * Amennyiben elfogy a karakter �letereje a sebz�skor ez a met�dus h�v�dik meg.
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
