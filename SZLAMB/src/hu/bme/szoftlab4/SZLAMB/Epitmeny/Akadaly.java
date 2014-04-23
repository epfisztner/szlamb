package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.util.List;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
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
	public List<VarazsKo> getValidKovek(){
		return varazsKovek;}
	
	/**
	 * szerkesztve
	 * üres metódus nem csinál semmit
	 */
	public void setKod(boolean vanKod){}
	
	
	@Override
	public void felruhaz(VarazsKo varazsKo) {
		//System.out.println("\t\t-->"+this.getClass().getName()+".felruhaz("+varazsKo.name()+")");
		//System.out.println("\t\t<--void");
	}

	@Override
	public void reakcio(GyuruSzovetsege gyuruSzovetsege) {
		//System.out.println("\t\t-->"+this.getClass().getName()+".reakcio("+gyuruSzovetsege.getClass().getName()+")");
		gyuruSzovetsege.setSebesseg(this.varazsKovek);
		XMLHelper.setOutPutFileContent(" akadalyra lepett");
		//System.out.println("\t\t<--void");
	}

	@Override
	public void setMezo(Mezo epitmenyMezo) {
		//System.out.println("\t\t-->"+this.getClass().getName()+".setMezo("+epitmenyMezo.getClass().getName()+")");
		//System.out.println("\t\t<--void");
	}

}
