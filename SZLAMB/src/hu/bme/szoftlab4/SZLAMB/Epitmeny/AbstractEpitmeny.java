package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

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
	
	private List<VarazsKo> varazsKovek;
	
	/**
	 * Az {@link Epitmeny} típusú osztály saját referenciája az őt tartalmazó
	 * mezőre.
	 */
	protected Mezo epitmenyMezo;
	
	protected Paintable epitmenyPaintable;
	
	protected int x;
	
	protected int y;
	
	public AbstractEpitmeny() {
		super();
		this.setVarazsKovek(new ArrayList<VarazsKo>());
		this.epitmenyMezo = null;
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
	
	@Override
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public int getX() {
		return x;
	}
	
	@Override
	public void setY(int y) {
		this.y = y;
		
	}
	
	@Override
	public int getY() {
		return y;
	}

	public List<VarazsKo> getVarazsKovek() {
		return varazsKovek;
	}

	public void setVarazsKovek(List<VarazsKo> varazsKovek) {
		this.varazsKovek = varazsKovek;
	}
}
