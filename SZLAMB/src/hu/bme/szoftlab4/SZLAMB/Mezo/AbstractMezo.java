package hu.bme.szoftlab4.SZLAMB.Mezo;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

public abstract class AbstractMezo implements Mezo {
	
	protected Epitmeny epitmeny;
	
	protected List<GyuruSzovetsege> karakterek;
	
	protected List<Mezo> szomszedok;
	
	protected boolean beepitett;
	
	@Override
	public boolean isBeepitett() {
		return this.beepitett;
	}
	
	@Override
	public void setSzomszedok(int szomszedSugar) {
		//TODO
	}
	
	@Override
	public void karakterRegiszter(GyuruSzovetsege gyuruSzovetsege) {
		// TODO Auto-generated method stub	
	}

}
