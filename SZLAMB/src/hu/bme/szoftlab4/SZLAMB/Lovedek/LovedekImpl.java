package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.ArrayList;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

public class LovedekImpl implements Lovedek {
	/**
	 * A {@link Lovedek} -el való reakcióját határozzák meg az őt megkapó
	 * {@link GyuruSzovetsege} típusú objektumnak.
	 */
	protected List<VarazsKo> varazsKovek;

	protected Paintable lovedekPaintable;

	public LovedekImpl(List<VarazsKo> varazsKovek) {
		this.varazsKovek = varazsKovek;
	}

	@Override
	public List<VarazsKo> getVarazsKovek() {
		return this.varazsKovek;
	}

	@Override
	public void setPaintable(Paintable paintable) {
		// TODO Auto-generated method stub

	}

	protected void repaint() {

	}

	@Override
	public ViewType getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
