package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;


public class VegzetHegye extends AbstractMezo {

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {
		System.out.println("/t<--void");
	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {
		System.out.println("/t<--void");
	}

}
