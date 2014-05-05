package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.ArrayList;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;

public class LovedekImpl implements Lovedek {
	/**
	 * A {@link Lovedek} -el való reakcióját határozzák meg az őt megkapó
	 * {@link GyuruSzovetsege} típusú objektumnak.
	 */
	protected List<VarazsKo> varazsKovek;

	protected Paintable lovedekPaintable;

	public LovedekImpl(List<VarazsKo> varazsKovek) {
		// System.out.println("\t\t\t-->"+this.getClass().getName()+".constructor("+varazsKovek.toString()+")");
		this.varazsKovek = varazsKovek;
		// System.out.println("\t\t\t<--");
	}

	@Override
	public List<VarazsKo> getVarazsKovek() {
		// System.out.println("\t\t\t-->"+this.getClass().getName()+".getVarazsKovek()");
		// System.out.println("\t\t\t<--"+varazsKovek.getClass()+": "+varazsKovek.toString());
		return this.varazsKovek;
	}

	@Override
	public void setPaintable(Paintable paintable) {
		// TODO Auto-generated method stub

	}

	protected void repaint() {

	}

}
