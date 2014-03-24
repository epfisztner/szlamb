package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;


public class Tunde extends AbstractGyuruSzovetsege {

	public Tunde(List<Mezo> utvonal) {
		super(utvonal);
	}

	@Override
	public void sebez(Lovedek lovedek) {
		System.out.println("/t-->"+this.getClass().getName()+".sebez("+lovedek.getClass()+")");
		System.out.println("/t<--void");
	}

	@Override
	public void setSebesseg(VarazsKo varazsKo) {
		System.out.println("/t-->"+this.getClass().getName()+".setSebesseg("+varazsKo.name()+")");
		System.out.println("/t<--void");
	}

}
