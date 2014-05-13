package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.ModelConnetor;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;

/**
 * A játékban lévő ellenségek reprezentációja lesz ezen interface leszármazottja.
 * 
 * @author Erhard Pfisztner
 *
 */
public interface GyuruSzovetsege extends Cloneable, ModelConnetor {

	/**
	 * A játék indulásakor ezen metódus meghívása indítja el a karaktert a
	 * kapott útvonalon
	 */
	public void indul();

	/**
	 * {@link Torony} -al való reakció következményeként ez a metódus hívódik
	 * meg, melyben a karakter életereje a {@link Lovedek} típusának megfelelően
	 * fog csökkenni.
	 * 
	 * @param lovedek
	 */
	public void sebez(Lovedek lovedek);

	/**
	 * {@link Akadaly} -al való reakció következményeként ez a metódus hívódik
	 * meg, melyben a karakter sebessége a {@link Akadaly} típusának megfelelően
	 * fog csökkenni.
	 * 
	 * @param varazsKo
	 */
	public void setSebesseg(List<VarazsKo> varazsKo);

	/**
	 * Beállítja a karakternek a lehetséges útvonalat.
	 * 
	 * @param utvonal
	 */
	public void setUtvonal(List<Mezo> utvonal);
	
	public Object clone() throws CloneNotSupportedException;
	public void lep();

	public int getPositionX();
	public void setPositionX(int positionX);
	
	public int getPositionY();
	public void setPositionY(int positionY);
	
	public int getEletero() ;
	public void setEletero(int eletero);
}
