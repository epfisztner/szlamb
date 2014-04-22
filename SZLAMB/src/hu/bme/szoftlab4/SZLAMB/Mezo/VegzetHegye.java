package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

/**
 * Ez az osztály a {@link Mezo} egyik implementációja.
 * Ezen a mezőn nem lehet elhelyezni semmilyen {@link Epitmeny} típusú objetumot,
 * az erre szolgáló metódusait üresen írjuk felül.
 * 
 * @author Erhard Pfisztner
 */
public class VegzetHegye extends AbstractMezo {
	
	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t-->"+this.getClass().getName()+".karakterRegiszter("+gyuruSzovetsege.getClass().getName()+")");
		JatekMotor.jatekVegeVeszit();
		System.out.println("\t<--void");
	}

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {
		System.out.println("\t-->"+this.getClass().getName()+".epitmenyRegiszter("+epitmeny.getClass().getName()+")");
		System.out.println("\t<--void");
	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitmenyFelruhazas("+varazsKo.name()+")");
		System.out.println("\t<--void");
	}

	@Override
	public String toString() {
		return "VegzetHegye";
	}
}
