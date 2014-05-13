package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

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
	}

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {
		this.epitmeny = epitmeny;
		this.epitmeny.setMezo(this);
		System.out.println("építmény bereg: X:"+this.getX()+"   y:"+this.getY()+" - ra");
	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {
		this.epitmeny.felruhaz(varazsKo);
	}
	
	@Override
	public String toString() {
		return "UresMezo";
	}

	@Override
	public void setKod(boolean vanKod) {
		this.epitmeny.setKod(vanKod);
		
	}

	@Override
	public ViewType getType() {
		return ViewType.URESMEZO;
	}

	@Override
	public List<GyuruSzovetsege> getKarakterek() {
		// TODO Auto-generated method stub
		return null;
	}

}
