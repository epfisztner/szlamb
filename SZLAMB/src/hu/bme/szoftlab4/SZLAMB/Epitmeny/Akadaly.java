package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

/**
 * Az {@link Epitmeny} egyik implementációja, melyet csak {@link Ut} típusú objektumra tudunk építeni.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Akadaly extends AbstractEpitmeny {

	/**
	 * szerkesztve
	 * csak az adott épületre rakható kövek listáját adja vissza
	 */
	@Override
	public VarazsKo[] getValidKovek(){
		return new VarazsKo[]{VarazsKo.EMBER, VarazsKo.HOBBIT, VarazsKo.TORP,VarazsKo.TUNDE};
	}
	
	/**
	 * szerkesztve
	 * üres metódus nem csinál semmit
	 */
	public void setKod(boolean vanKod){}
	
	
	@Override
	public void felruhaz(VarazsKo varazsKo) {
		this.getVarazsKovek().add(varazsKo);
	}

	@Override
	public void reakcio(GyuruSzovetsege gyuruSzovetsege) {
		gyuruSzovetsege.setSebesseg(this.getVarazsKovek());
	}

	@Override
	public void setMezo(Mezo epitmenyMezo) {
		this.epitmenyMezo = epitmenyMezo;
	}

	@Override
	public ViewType getType() {
		return ViewType.AKADALY;
	}
	

}
