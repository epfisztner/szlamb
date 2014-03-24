package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;


public class UresMezo extends AbstractMezo {

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {
		System.out.println("\t-->"+this.getClass().getName()+".epitmenyRegiszter("+epitmeny.getClass().getName()+")");
		this.epitmeny = epitmeny;
		this.epitmeny.setMezo(this);
		System.out.println("\t<--void");
	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitmenyFelruhazas("+varazsKo.name()+")");
		this.epitmeny.felruhaz(varazsKo);
		System.out.println("\t<--void");
	}

}
