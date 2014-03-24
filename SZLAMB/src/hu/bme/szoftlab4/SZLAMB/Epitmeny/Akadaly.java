package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;


public class Akadaly extends AbstractEpitmeny {

	@Override
	public void felruhaz(VarazsKo varazsKo) {
		System.out.println("\t-->"+this.getClass().getName()+".felruhaz("+varazsKo.name()+")");
		System.out.println("\t<--void");
	}

	@Override
	public void reakcio(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t-->"+this.getClass().getName()+".reakcio("+gyuruSzovetsege.getClass().getName()+")");
		gyuruSzovetsege.setSebesseg(this.varazsKovek);
		System.out.println("\t<--void");
	}

	@Override
	public void setMezo(Mezo epitmenyMezo) {
		System.out.println("\t-->"+this.getClass().getName()+".setMezo("+epitmenyMezo.getClass().getName()+")");
		System.out.println("\t<--void");
	}

}
