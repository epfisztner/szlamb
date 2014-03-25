package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

/**
 * Ez az interface deklarálja a játékban a pályát felépítő elemek publikus
 * metódusait
 * 
 * @author Erhard Pfisztner
 * 
 */
public interface Mezo {

	/**
	 * Amennyiben karakter lép a mezőre reagáltatja az építményét.
	 * 
	 * @param gyuruSzovetsege
	 */
	void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege);

	/**
	 * A paraméterben kapott {@link Epitmeny} típusú objektumot beállítja a mező
	 * építményeként(kivéve ha a leszármazott {@link VegzetHegye} típus)
	 * 
	 * @param epitmeny
	 */
	void epitmenyRegiszter(Epitmeny epitmeny);

	/**
	 * A paraméterben kapott {@link VarazsKo} típusú objektummal felruházza a
	 * mezőn lévő {@link Epitmeny} típusú objektumot, amennyiben van rajta.
	 * 
	 * @param varazsKo
	 */
	void epitmenyFelruhazas(VarazsKo varazsKo);

	/**
	 * Beállítja a mező szomszédait a sugár alapján.
	 * 
	 * @param szomszedSugar
	 */
	void setSzomszedok(int szomszedSugar);

	/**
	 * Visszatér a beepitett mező értékével.
	 * 
	 * @return beepitett
	 */
	boolean isBeepitett();
}
