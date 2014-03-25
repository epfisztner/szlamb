package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Lovedek.LovedekImpl;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.UresMezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;


/**
 * Az {@link Epitmeny} egyik implementációja, melyet csak {@link UresMezo}
 * típusú objektumra tudunk építeni.
 * 
 * @author Erhard Pfisztner
 * 
 */
public class Torony extends AbstractEpitmeny {
	/**
	 * A {@link VarazsKo} -vek hat�s�ra változó érték,
	 * mely megadja a torony hatótávjának mértékét.
	 */
	protected int hatotavSzorzo;
	
	/**
	 * A {@link VarazsKo} -vek hatására változó érték,
	 * mely megadja a torony tüzelési sebességének mértékét.
	 */
	protected int tuzelesSzorzo;

	@Override
	public void felruhaz(VarazsKo varazsKo) {
		System.out.println("\t\t-->"+this.getClass().getName()+"felruhaz("+varazsKo.name()+");");
		System.out.println("\t\t<--void");
	}

	@Override
	public void reakcio(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t\t-->"+this.getClass().getName()+".reakcio("+gyuruSzovetsege.getClass().getName()+")");
		gyuruSzovetsege.sebez(new LovedekImpl(varazsKovek));
		System.out.println("\t\t<--void");
	}

	@Override
	public void setMezo(Mezo epitmenyMezo) {
		System.out.println("\t\t-->"+this.getClass().getName()+".setMezo("+epitmenyMezo.getClass().getName()+")");
		System.out.println("\t\t<--void");
	}

}
