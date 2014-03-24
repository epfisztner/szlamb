package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

/**
 * Ez az interface deklar�lja a {@link Torony} illetve {@link Akadaly} t�pus� objektumok
 * publikus met�dusait.
 * 
 * @author Erhard Pfisztner
 *
 */
public interface Epitmeny extends Cloneable{
	
	/**
	 * A param�terben kapott {@link VarazsKo} -vel felruh�zza az adott �p�tm�nyt.
	 * 
	 * @param varazsKo
	 */
	void felruhaz(VarazsKo varazsKo);
	
	/**
	 * A param�terben kapott {@link GyuruSzovetsege} karakterre megh�vja minden
	 * lesz�rmazott a saj�t reakci� met�dus�t ami vagy sebz�st vagy lass�t�st eredm�nyez.
	 * 
	 * @param gyuruSzovetsege
	 */
	void reakcio(GyuruSzovetsege gyuruSzovetsege);
	
	/**
	 * Visszaadja az �p�tm�nyre rakhat� {@link VarazsKo} - vek list�j�t.
	 * 
	 * @return {@link List} {@link VarazsKo}
	 */
	List<VarazsKo> getValidKovek();
	
	/**
	 * Be�ll�tja a param�terben kapott {@link Mezo} -t az ep�tm�ny epitmenyMezo-j�nek,
	 * hogy legyen referenci�ja r�.
	 * 
	 * @param epitmenyMezo
	 */
	void setMezo(Mezo epitmenyMezo);

}
