package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

/**
 * Ez az osztály a {@link Mezo} egyik implementációja.
 * Ezen a mezőn nem lehet elhelyezni semmilyen {@link Epitmeny} típusú objetumot,
 * az erre szolgáló metódusait üresen írjuk felül.
 * 
 * @author Erhard Pfisztner
 */
public class VegzetHegye extends AbstractMezo {
	
	public VegzetHegye(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege, boolean szomszedCall) {
		if (!szomszedCall) {
			JatekMotor.jatekVegeVeszit();
		}
	}

	@Override
	public void epitmenyRegiszter(Epitmeny epitmeny) {

	}

	@Override
	public void epitmenyFelruhazas(VarazsKo varazsKo) {

	}

	@Override
	public String toString() {
		return "VegzetHegye";
	}

	@Override
	public void setKod(boolean vanKod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViewType getType() {
		return ViewType.VEGZETHEGYE;
	}

	@Override
	public List<GyuruSzovetsege> getKarakterek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ViewType getEpitmenyType() {
		return ViewType.NONE;
	}
}
