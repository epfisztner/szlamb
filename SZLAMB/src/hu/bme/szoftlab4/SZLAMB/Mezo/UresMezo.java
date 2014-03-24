package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

/**
 * Ez az oszt�ly a {@link Mezo} egyik implement�ci�ja.
 * Ezen a mez�n lehet elhelyezni {@link Torony} t�pus� objetumokat, de
 * csakis azokat.
 * 
 * @author Erhard Pfisztner
 */
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
