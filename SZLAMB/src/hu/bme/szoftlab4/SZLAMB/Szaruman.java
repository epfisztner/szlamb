package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

public class Szaruman {
	
	public static Palya palya;
	
	protected int varazsEro;
	
	public Szaruman() {
		System.out.println("\t-->"+this.getClass().getName()+".constructor()");
		this.varazsEro = 100;
		palya = new Palya();
		System.out.println("\t<--");
	}

	public void epitTorony(Mezo mezo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitTorony("+mezo.getClass()+")");
		mezo.epitmenyRegiszter(new Torony());
		System.out.println("\t<--void");
	}
	
	public void epitAkadaly(Mezo mezo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitAkadaly("+mezo.getClass()+")");
		mezo.epitmenyRegiszter(new Akadaly());
		System.out.println("\t<--void");
	}
	
	public void felruhaz(Mezo mezo, VarazsKo varazsKo) {
		System.out.println("\t-->"+this.getClass().getName()+".epitAkadaly("+varazsKo.getClass()+")");
		mezo.epitmenyFelruhazas(varazsKo);
		System.out.println("\t<--void");
	}
	
	public void start() {
		System.out.println("\t-->"+this.getClass().getName()+".start()");
		palya.start();
		System.out.println("\t<--void");
	}

}
