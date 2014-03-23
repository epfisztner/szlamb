package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


public abstract class AbstractEpitmeny implements Epitmeny {
	
	protected List<VarazsKo> varazsKovek;
	
	protected Mezo epitmenyMezo;
	
	@Override
	public List<VarazsKo> getValidKovek() {
		return this.varazsKovek;
	}

}
