package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.List;


/**
 * Ez az osztály a {@link GyuruSzovetsege} egyik implementációja.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Ember extends AbstractGyuruSzovetsege {

	public Ember(List<Mezo> utvonal) {
		super(utvonal);
	}

	@Override
	public void sebez(Lovedek lovedek) {
		System.out.println("\t-->"+this.getClass().getName()+".sebez("+lovedek.getClass()+")");
		System.out.print("[?] Elfogyott az eletereje? [igen/nem] :");
		String input = Main.input();
		if (input.equalsIgnoreCase("igen")) {
			this.elpusztul();
			Palya.ellensegCsokkent();
		}
		System.out.println("\n\t<--void");
	}

	@Override
	public void setSebesseg(List<VarazsKo> varazsKo) {
		System.out.println("\t-->"+this.getClass().getName()+".setSebesseg("+varazsKo.toString()+")");
		System.out.println("\t<--void");
	}


}
