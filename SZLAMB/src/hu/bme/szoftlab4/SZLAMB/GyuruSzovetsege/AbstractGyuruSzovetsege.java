package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

import java.util.List;

/**
 * Ez az osztály implementálja az {@link GyuruSzovetsege} interface által
 * deklarált, minden leszármazott által közösen értelmezett metódusokat.
 * 
 * @author Erhard Pfisztner
 * 
 */
public abstract class AbstractGyuruSzovetsege implements GyuruSzovetsege {
	/**
	 * {@link GyuruSzovetsege} objektum életereje
	 */
	private int eletero;

	/**
	 * {@link GyuruSzovetsege} objektum sebessége
	 */
	protected int sebesseg;

	/**
	 * Azon index sám amelyiken {@link Mezo} -n éppen rajta van a karakter az
	 * utvonal-ból
	 */
	protected int aktualisMezoIndex;
	/**
	 * Az karakter által megteendő útvonal
	 */
	protected List<Mezo> utvonal;

	/**
	 * szerkesztve X-beli koordinata
	 */
	private int positionX;

	/**
	 * szerkesztve Y-beli koordinata
	 */
	private int positionY;

	protected Paintable gyuruSzovetsegePaintable;

	public AbstractGyuruSzovetsege() {
		// System.out.println("\t\t\t\t-->"+this.getClass().getName()+".constructor("+utvonal.toString()+")");
		this.setUtvonal(utvonal);
		// System.out.println("\t\t\t\t<--");
	}

	@Override
	public void setPaintable(Paintable paintable) {
		this.gyuruSzovetsegePaintable = paintable;
	}

	/**
	 * Amennyiben elfogy a karakter életereje a sebzéskor ez a metódus hívódik
	 * meg.
	 */
	protected void elpusztul() {
		// System.out.println("\t\t\t\t-->"+this.getClass().getName()+".elpusztul()");
		Palya.ellensegCsokkent();
		// System.out.println("\t\t\t\t<--void");
	}

	@Override
	public void indul() {
		// System.out.println("\t\t\t-->"+this.getClass().getName()+".indul()");
		// System.out.println("\t\t\t<--void");
	}

	@Override
	public void setUtvonal(List<Mezo> utvonal) {
		// System.out.println("\t\t\t\t\t-->"+this.getClass().getName()+".setUtvonal("+utvonal.toString()+")");
		// System.out.println("\t\t\t\t\t<--void");
		this.utvonal = utvonal;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;

		for (int x = 0; x < utvonal.size(); x++) {
			if (utvonal.get(x).getX() == this.positionY
					&& utvonal.get(x).getY() == this.positionX) {
				this.aktualisMezoIndex = x;
				break;
			}

		}
	}

	public void lep() {
		this.aktualisMezoIndex++;
		for (int x = 0; x < utvonal.size(); x++) {
			if (x == aktualisMezoIndex) {
				positionX = utvonal.get(x).getX();
				positionY = utvonal.get(x).getY();
			}
		}
		XMLHelper.setOutPutFileContent("leptetes az [" + positionX + "]["
				+ positionY + "] utra");
		this.utvonal.get(aktualisMezoIndex).karakterRegiszter(this, false);
		if (getEletero() <= 0) {
			XMLHelper.setOutPutFileContent(" elpusztult");
			elpusztul();
		} else if (this.utvonal.get(aktualisMezoIndex).toString()
				.equalsIgnoreCase("vegzetHegye")) {
		} else {
			if (XMLHelper.outPutFileContent.contains("</karakterLep>")) {
				// XMLHelper.setOutPutFileContent("</karakterLep>");
			}
		}
	}

	public int getEletero() {
		return eletero;
	}

	public void setEletero(int eletero) {
		this.eletero = eletero;
	}

	protected void repaint() {

	}

}
