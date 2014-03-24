package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

/**
 * A j�t�kban l�v� ellens�gek reprezent�ci�ja lesz ezen interface lesz�rmazottja.
 * 
 * @author Erhard Pfisztner
 *
 */
public interface GyuruSzovetsege extends Cloneable {
	
	/**
	 * A j�t�k indul�sakor ezen met�dus megh�v�sa ind�tja el a karaktert a kapott �tvonalon
	 */
	public void indul();
	
	/**
	 * {@link Torony} -al val� reakci� k�vetkezm�nyek�nt ez a met�dus h�v�dik meg, 
	 * melyben a karakter �letereje a {@link Lovedek} t�pus�nak megfelel�en fog cs�kkenni.
	 * 
	 * @param lovedek
	 */
	public void sebez(Lovedek lovedek);
	
	/**
	 * {@link Akadaly} -al val� reakci� k�vetkezm�nyek�nt ez a met�dus h�v�dik meg, 
	 * melyben a karakter sebess�ge a {@link Akadaly} t�pus�nak megfelel�en fog cs�kkenni.
	 * 
	 * @param varazsKo
	 */
	public void setSebesseg(List<VarazsKo> varazsKo);
	
	/**
	 * Be�ll�tja a karakternek a lehets�ges �tvonalat.
	 * 
	 * @param utvonal
	 */
	public void setUtvonal(List<Mezo> utvonal);
	
}
