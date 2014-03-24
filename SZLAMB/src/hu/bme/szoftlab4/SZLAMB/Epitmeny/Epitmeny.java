package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

/**
 * Ez az interface deklarálja a {@link Torony} illetve {@link Akadaly} típusú objektumok
 * publikus metódusait.
 * 
 * @author Erhard Pfisztner
 *
 */
public interface Epitmeny extends Cloneable{
	
	/**
	 * A paraméterben kapott {@link VarazsKo} -vel felruházza az adott építményt.
	 * 
	 * @param varazsKo
	 */
	void felruhaz(VarazsKo varazsKo);
	
	/**
	 * A paraméterben kapott {@link GyuruSzovetsege} karakterre meghívja minden
	 * leszármazott a saját reakció metódusát ami vagy sebzést vagy lassítást eredményez.
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
	 * Beállítja a paraméterben kapott {@link Mezo} -t az epítmény epitmenyMezo-jének,
	 * hogy legyen referenciája rá.
	 * 
	 * @param epitmenyMezo
	 */
	void setMezo(Mezo epitmenyMezo);

}
