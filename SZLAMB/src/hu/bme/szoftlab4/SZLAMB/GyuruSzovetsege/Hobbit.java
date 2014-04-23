package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

/**
 * Ez az osztály a {@link GyuruSzovetsege} egyik implementációja.
 * 
 * @author Erhard Pfisztner
 */
public class Hobbit extends AbstractGyuruSzovetsege {

	public Hobbit() {
		super();
	}

	@Override
	public void sebez(Lovedek lovedek) {
		//System.out.println("\t\t\t-->"+this.getClass().getName()+".sebez("+lovedek.getClass()+")");
		//System.out.print("\t\t\t\t[?] Elfogyott az eletereje? [igen/nem] :");
		//String input = Main.input();
		//if (input.equalsIgnoreCase("igen")) {
		int eletero = this.getEletero();
		eletero--;
		this.setEletero(eletero);
		if (this.getEletero()<1) {
			this.elpusztul();
		}
		//System.out.println("\t\t\t<--void");
	}

	@Override
	public void setSebesseg(List<VarazsKo> varazsKo) {
		//System.out.println("\t\t\t-->"+this.getClass().getName()+".setSebesseg("+varazsKo.toString()+")");
		//System.out.println("\t\t\t<--void");
	}

}
