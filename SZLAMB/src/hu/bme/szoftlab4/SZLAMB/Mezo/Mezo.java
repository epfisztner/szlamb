package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

public interface Mezo {
	
	void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege);

	void epitmenyRegiszter(Epitmeny epitmeny);
	
	void epitmenyFelruhazas(VarazsKo varazsKo);
	
	void setSzomszedok(int szomszedSugar);
	
	boolean isBeepitett();
}
