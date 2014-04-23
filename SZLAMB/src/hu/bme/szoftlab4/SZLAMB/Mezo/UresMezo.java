package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

/**
 * Ez az osztály a {@link Mezo} egyik implementációja.
 * Ezen a mezőn lehet elhelyezni {@link Torony} típusú objetumokat, de
 * csakis azokat.
 * 
 * @author Erhard Pfisztner
 */
public class UresMezo extends AbstractMezo {

	public UresMezo(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {
		//System.out.println("\t-->"+this.getClass().getName()+".epitmenyRegiszter("+epitmeny.getClass().getName()+")");
		this.epitmeny = epitmeny;
		this.epitmeny.setMezo(this);
		//System.out.println("\t<--void");
	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {
		//System.out.println("\t-->"+this.getClass().getName()+".epitmenyFelruhazas("+varazsKo.name()+")");
		this.epitmeny.felruhaz(varazsKo);
		//System.out.println("\t<--void");
	}
	
	@Override
	public String toString() {
		return "UresMezo";
	}

	@Override
	public void setKod(boolean vanKod) {
		this.epitmeny.setKod(vanKod);
		
	}

}
