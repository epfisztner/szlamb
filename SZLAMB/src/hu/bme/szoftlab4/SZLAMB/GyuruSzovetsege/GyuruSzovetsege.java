package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

public interface GyuruSzovetsege extends Cloneable {
	
	public void indul();
	
	public void sebez(Lovedek lovedek);
	
	public void setSebesseg(List<VarazsKo> varazsKo);
	
	public void setUtvonal(List<Mezo> utvonal);
	
}
