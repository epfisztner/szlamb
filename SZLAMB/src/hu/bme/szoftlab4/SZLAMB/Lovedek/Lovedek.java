package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;

/**
 * 
 * Ez az interface deklarálja a {@link Torony} által
 * paraméterként átadott lövedék objektumot a célbavett karakternek.
 * 
 * @author Erhard Pfisztner
 *
 */
public interface Lovedek {
	
	/**
	 * Visszaadja a lövedék tulajdonságait meghatározó {@link VarazsKo} elemek listáját
	 * 
	 * @return List<VarazsKo>
	 */
	List<VarazsKo> getVarazsKovek();
	
	void setPaintable(Paintable paintable);

}
