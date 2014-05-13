package hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.Paintable;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

import java.util.List;
import java.util.Random;

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

	private List<List<Mezo>> utvonalak;

	public AbstractGyuruSzovetsege(List<List<Mezo>> utvonalak) {
		this.setUtvonalak(utvonalak);
		this.aktualisMezoIndex = 0;
		Random r = new Random(System.currentTimeMillis());
		this.setUtvonal(getUtvonalak().get(r.nextInt(getUtvonalak().size())));
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
		Palya.ellensegCsokkent();
	}

	@Override
	public void indul() {
	}

	@Override
	public void setUtvonal(List<Mezo> utvonal) {
		this.utvonal = utvonal;
		this.positionX = this.utvonal.get(aktualisMezoIndex).getX();
		this.positionY = this.utvonal.get(aktualisMezoIndex).getY();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		System.out.println("Lemásolva: " + this.toString());
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

		/*
		 * for (int x = 0; x < utvonal.size(); x++) { if (utvonal.get(x).getX()
		 * == this.positionY && utvonal.get(x).getY() == this.positionX) {
		 * this.aktualisMezoIndex = x; break; }
		 * 
		 * }
		 */
	}

	public void lep() {
		// this.aktualisMezoIndex++;
		
			if (positionX > utvonal.get(aktualisMezoIndex).getX()) {
				positionX-=this.sebesseg;

			} else if (positionX < utvonal.get(aktualisMezoIndex).getX()) {
				positionX+=this.sebesseg;
			}
			if (positionY > utvonal.get(aktualisMezoIndex).getY()) {
				positionY-=this.sebesseg;

			} else if (positionY < utvonal.get(aktualisMezoIndex).getY()) {
				positionY+=this.sebesseg;
			}
			//if (!JatekMotor.isJatekVege()) {
				
			if (utvonal.get(aktualisMezoIndex).getX() <= positionX
						&& utvonal.get(aktualisMezoIndex).getX() + 47 > positionX
						&& utvonal.get(aktualisMezoIndex).getY() <= positionY
						&& utvonal.get(aktualisMezoIndex).getY() + 47 > positionY) {
				if (this.utvonal.size()-1>this.aktualisMezoIndex){
					this.aktualisMezoIndex++;
	
					this.utvonal.get(this.aktualisMezoIndex).karakterRegiszter(
							this, false);
				}
			}

			if (getEletero() <= 0) {

				elpusztul();
			} else if (this.utvonal.get(aktualisMezoIndex).toString()
					.equalsIgnoreCase("vegzetHegye")) {
				JatekMotor.jatekVegeVeszit();
			} else {

			}
		//}
	}

	public int getEletero() {
		return eletero;
	}

	public void setEletero(int eletero) {
		this.eletero = eletero;
	}

	protected void repaint() {

	}

	public List<List<Mezo>> getUtvonalak() {
		return utvonalak;
	}

	public void setUtvonalak(List<List<Mezo>> utvonalak) {
		this.utvonalak = utvonalak;
	}
}
