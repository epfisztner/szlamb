package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

import java.util.List;

/**
 * Ez az osztály a {@link GyuruSzovetsege} egyik implementációja.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Ember extends AbstractGyuruSzovetsege {

	public Ember(List<List<Mezo>>utvonalak) {
		super(utvonalak);
		this.sebesseg = 3;
	}

	@Override
	public void sebez(Lovedek lovedek) {
		int eletero = this.getEletero();
		eletero--;
		this.setEletero(eletero);
		
		if (this.getEletero()<1) {
			this.elpusztul();
		}
	}

	@Override
	public void setSebesseg(List<VarazsKo> varazsKo) {
	}

	@Override
	public ViewType getType() {
		return ViewType.EMBER;
	}


}
