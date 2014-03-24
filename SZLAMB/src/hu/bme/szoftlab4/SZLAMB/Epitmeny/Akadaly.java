package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;


public class Akadaly extends AbstractEpitmeny {

	@Override
	public void felruhaz(VarazsKo varazsKo) {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}

	@Override
	public void reakcio(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}

	@Override
	public void setMezo(Mezo epitmenyMezo) {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}

}
