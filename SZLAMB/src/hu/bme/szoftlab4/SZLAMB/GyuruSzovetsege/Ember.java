package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


public class Ember extends AbstractGyuruSzovetsege {

	public Ember(List<Mezo> utvonal) {
		super(utvonal);
	}

	@Override
	public void sebez(Lovedek lovedek) {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
		
	}

	@Override
	public void setSebesseg(VarazsKo varazsKo) {
		System.out.println("/t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}


}
