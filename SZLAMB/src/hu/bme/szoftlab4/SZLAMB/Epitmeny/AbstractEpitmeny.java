package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.util.ArrayList;
import java.util.List;

/**
 * Ez az oszt�ly implement�lja az {@link Epitmeny} interface �ltal deklar�lt,
 * minden lesz�rmazott �ltal k�z�sen �rtelmezett met�dusokat.
 * 
 * @author Erhard Pfisztner
 *
 */
public abstract class AbstractEpitmeny implements Epitmeny {
	
	/**
	 * {@link VarazsKo} -vek list�ja, melyeket a felruh�z�ssal
	 * lehet b�v�teni.
	 */
	protected List<VarazsKo> varazsKovek;
	
	/**
	 * Az {@link Epitmeny} t�pus� oszt�ly saj�t referenci�ja az �t tartalmaz�
	 * mez�re.
	 */
	protected Mezo epitmenyMezo;
	
	public AbstractEpitmeny() {
		super();
		System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor()");
		System.out.println("\t\t\t\t<--");
		this.varazsKovek = new ArrayList<VarazsKo>();
		this.epitmenyMezo = null;
	}

	@Override
	public List<VarazsKo> getValidKovek() {
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("\t<--"+varazsKovek.getClass().getName()+": " + varazsKovek.toString());
		return this.varazsKovek;
	}

}
