package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.ArrayList;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;

public class LovedekImpl implements Lovedek {
	/**
	 * A {@link Lovedek} -el való reakcióját határozzák meg az õt megkapo {@link GyuruSzovetsege}
	 * típusú objektumnak.
	 */
	protected List<VarazsKo> varazsKovek;

	public LovedekImpl(List<VarazsKo> varazsKovek){
		System.out.println("\t-->"+this.getClass().getName()+".constructor("+varazsKovek.toString()+")");
		this.varazsKovek = varazsKovek;
		System.out.println("\t<--");
	}

	@Override
	public List<VarazsKo> getVarazsKovek() {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("\t<--"+varazsKovek.getClass()+": "+varazsKovek.toString());
		return this.varazsKovek;
	}

}
