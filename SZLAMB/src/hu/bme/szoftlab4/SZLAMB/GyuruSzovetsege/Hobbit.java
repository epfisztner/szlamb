package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;

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
public class Hobbit extends AbstractGyuruSzovetsege {

	public Hobbit(List<List<Mezo>>utvonalak) {
		super(utvonalak);
		this.setEletero(50);
		this.sebesseg = 3;
	}

	@Override
	public void sebez(Lovedek lovedek) {
		int eletero = this.getEletero();
		if (lovedek.getVarazsKovek().contains(VarazsKo.HOBBIT)) {
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
	public void setSebesseg(List<VarazsKo> varazsKo) {
		if (varazsKo.contains(VarazsKo.HOBBIT)) {
			this.sebesseg=1;
		} else {
			this.sebesseg=3;
		}
	}

	@Override
	public ViewType getType() {
		return ViewType.HOBBIT;
	}

	@Override
	public void setDefaultSebesseg() {
		this.sebesseg = 3;
	}

}
