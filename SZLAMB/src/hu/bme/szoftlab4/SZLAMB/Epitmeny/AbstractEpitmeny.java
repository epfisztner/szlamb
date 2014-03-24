package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


public abstract class AbstractEpitmeny implements Epitmeny {
	
	protected List<VarazsKo> varazsKovek;
	
	protected Mezo epitmenyMezo;
	
	@Override
	public List<VarazsKo> getValidKovek() {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("\t<--"+varazsKovek.getClass().getName()+": " + varazsKovek.toString());
		return this.varazsKovek;
	}

}
