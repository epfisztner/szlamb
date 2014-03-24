package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;

public class LovedekImpl implements Lovedek {
	
	protected List<VarazsKo> varazsKovek;
	
	public LovedekImpl(List<VarazsKo> varazsKovek){
		this.varazsKovek = varazsKovek;
	}

	@Override
	public List<VarazsKo> getVarazsKovek() {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--"+varazsKovek.getClass()+": "+varazsKovek.toString());
		return this.varazsKovek;
	}

}
