package hu.bme.szoftlab4.SZLAMB.Mezo;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;

/**
 * Ez az osztály a {@link Mezo} egyik implementációja.
 * Ezen a mezőn lehet elhelyezni {@link Akadaly} típusú objetumokat, de
 * csakis azokat.
 * 
 * @author Erhard Pfisztner
 */
public class Ut extends AbstractMezo {

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

	@Override
	public String toString() {
		return "Ut";
	}
	
	@Override
	public void setKod(boolean vanKod) {
		// TODO Auto-generated method stub
		
	}
}
