package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;

/**
 * Ez az interface deklarálja a {@link Torony} illetve {@link Akadaly} típusú
 * objektumok publikus met�dusait.
 * 
 * @author Erhard Pfisztner
 * 
 */
public interface Epitmeny extends Cloneable {

	/**
	 * A param�terben kapott {@link VarazsKo} -vel felruházza az adott
	 * építményt.
	 * 
	 * @param varazsKo
	 */
	void felruhaz(VarazsKo varazsKo);

	/**
	 * A paraméterben kapott {@link GyuruSzovetsege} karakterre meghívja minden
	 * leszármazott a saját reakció metódust ami vagy sebzést vagy lassutást
	 * eredményez.
	 * 
	 * @param gyuruSzovetsege
	 */
	void reakcio(GyuruSzovetsege gyuruSzovetsege);

	/**
	 * Visszaadja az építményre rakható {@link VarazsKo} - vek listáját.
	 * 
	 * @return {@link List} {@link VarazsKo}
	 */
	List<VarazsKo> getValidKovek();

	/**
	 * Beállítja a paraméterben kapott {@link Mezo} -t az építmény
	 * epitmenyMezo-jének, hogy legyen referenciája rá.
	 * 
	 * @param epitmenyMezo
	 */
	void setMezo(Mezo epitmenyMezo);

	Object clone()  throws CloneNotSupportedException;

	void setKod(boolean vanKod);

	void setPaintable(Paintable paintable);
}
