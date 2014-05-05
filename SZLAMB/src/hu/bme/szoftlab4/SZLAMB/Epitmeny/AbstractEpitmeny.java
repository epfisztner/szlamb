package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;

import java.util.ArrayList;
import java.util.List;

/**
 * Ez az osztály implementálja az {@link Epitmeny} interface által deklarált,
 * minden leszármazott által közösen értelmezett metódusokat.
 * 
 * @author Erhard Pfisztner
 *
 */
public abstract class AbstractEpitmeny implements Epitmeny {
	protected List<VarazsKo> varazsKovek;
	
	/**
	 * Az {@link Epitmeny} típusú osztály saját referenciája az őt tartalmazó
	 * mezőre.
	 */
	protected Mezo epitmenyMezo;
	
	protected Paintable epitmenyPaintable;
	
	public AbstractEpitmeny() {
		super();
		//System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		//System.out.println("\t\t\t\t<--");
		this.varazsKovek = new ArrayList<VarazsKo>();
		this.epitmenyMezo = null;
	}

	@Override
	public List<VarazsKo> getValidKovek() {
		//System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		//System.out.println("\t<--"+varazsKovek.getClass().getName()+": " + varazsKovek.toString());
		return this.varazsKovek;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	@Override
	public void setPaintable(Paintable paintable) {
		this.epitmenyPaintable = paintable;
	}
	
	protected void repaint(){
		
	}

}
