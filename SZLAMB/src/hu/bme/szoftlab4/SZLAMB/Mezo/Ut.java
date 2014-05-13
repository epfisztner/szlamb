package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

/**
 * Ez az osztály a {@link Mezo} egyik implementációja.
 * Ezen a mezőn lehet elhelyezni {@link Akadaly} típusú objetumokat, de
 * csakis azokat.
 * 
 * @author Erhard Pfisztner
 */
public class Ut extends AbstractMezo {

	public Ut(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {
		this.beepitett = true;
		this.epitmeny = epitmeny;
		this.epitmeny.setMezo(this);
		
	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {
		this.epitmeny.felruhaz(varazsKo);
	}

	@Override
	public String toString() {
		return "Ut";
	}
	
	@Override
	public void setKod(boolean vanKod) {
	
	}

	@Override
	public ViewType getType() {
		return ViewType.UT;
	}

	@Override
	public List<GyuruSzovetsege> getKarakterek() {
		return karakterek;
	}

	@Override
	public ViewType getEpitmenyType() {
		return ViewType.AKADALY;
	}
}
