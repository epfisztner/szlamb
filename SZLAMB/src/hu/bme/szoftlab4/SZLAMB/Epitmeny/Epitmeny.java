package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

public interface Epitmeny extends Cloneable{
	
	void felruhaz(VarazsKo varazsKo);
	
	void reakcio(GyuruSzovetsege gyuruSzovetsege);
	
	List<VarazsKo> getValidKovek();
	
	void setMezo(Mezo epitmenyMezo);

}
