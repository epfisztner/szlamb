package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;

/**
 * 
 * Ez az interface deklar�lja a {@link Torony} �ltal
 * param�terk�nt �tadott l�ved�g objektumot a c�lbavett karakternek.
 * 
 * @author Erhard Pfisztner
 *
 */
public interface Lovedek {
	
	/**
	 * Visszaadja a l�ved�k tulajdons�gait meghat�roz� {@link VarazsKo} elemek list�j�t
	 * 
	 * @return List<VarazsKo>
	 */
	List<VarazsKo> getVarazsKovek();

}
