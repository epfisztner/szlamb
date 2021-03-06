package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;
import java.util.Random;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

/**
 * Ez az osztály a {@link GyuruSzovetsege} egyik implementációja.
 * 
 * @author Erhard Pfisztner
 */
public class Tunde extends AbstractGyuruSzovetsege {

	public Tunde(List<List<Mezo>>utvonalak) {
		super(utvonalak);
		this.setEletero(20);
		this.sebesseg = 5;
	}

	@Override
	public void sebez(Lovedek lovedek) {
		int eletero = this.getEletero();
		if (lovedek.getVarazsKovek().contains(VarazsKo.TUNDE)) {
			eletero-= 4;
		} else {
			eletero--;
		}
		this.setEletero(eletero);
		if (this.getEletero()<1) {
			this.elpusztul();
		}
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		super.clone();
		return new Tunde(this.getUtvonalak());
	}

	@Override
	public void setSebesseg(List<VarazsKo> varazsKo) {
		if (varazsKo.contains(VarazsKo.TUNDE)) {
			this.sebesseg=1;
		} else {
			this.sebesseg=5;
		}
	}
	

	@Override
	public ViewType getType() {
		return ViewType.TUNDE;
	}

	@Override
	public void setDefaultSebesseg() {
		this.sebesseg = 5;
	}

}
