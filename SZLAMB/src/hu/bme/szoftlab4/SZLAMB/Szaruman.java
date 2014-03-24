package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

public class Szaruman {
	
	public static Palya palya;
	
	protected int varazsEro;
	
	public void epitTorony(Mezo mezo) {
		System.out.println("/t-->"+this.getClass().getName()+".epitTorony("+mezo.getClass()+")");
	}
	
	public void epitAkadaly(Mezo mezo) {
		System.out.println("/t-->"+this.getClass().getName()+".epitAkadaly("+mezo.getClass()+")");
	}
	
	public void felruhaz(VarazsKo varazsKo) {
		System.out.println("/t-->"+this.getClass().getName()+".epitAkadaly("+varazsKo.getClass()+")");
	}
	
	public void start() {
		System.out.println("/t-->"+this.getClass().getName()+".start()");
	}

}
