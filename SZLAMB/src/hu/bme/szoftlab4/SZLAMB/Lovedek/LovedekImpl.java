package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;

public class LovedekImpl implements Lovedek {
	
	protected List<VarazsKo> varazsKovek;
	
	LovedekImpl(List<VarazsKo> varazsKovek){
		this.varazsKovek = varazsKovek;
	}

	@Override
	public List<VarazsKo> getVarazsKovek() {
		return this.varazsKovek;
	}

}
