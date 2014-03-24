package hu.bme.szoftlab4.SZLAMB.Lovedek;

import java.util.ArrayList;
import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;

public class LovedekImpl implements Lovedek {
	
	protected List<VarazsKo> varazsKovek;
	
	public LovedekImpl() {
		super();
		varazsKovek = new ArrayList<VarazsKo>();
		System.out.println("\t-->"+this.getClass().getName()+".constructor()");
		System.out.println("\t<--");
	}

	public LovedekImpl(List<VarazsKo> varazsKovek){
		System.out.println("\t-->"+this.getClass().getName()+".constructor("+varazsKovek.toString()+")");
		this.varazsKovek = varazsKovek;
	}

	@Override
	public List<VarazsKo> getVarazsKovek() {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("\t<--"+varazsKovek.getClass()+": "+varazsKovek.toString());
		return this.varazsKovek;
	}

}
