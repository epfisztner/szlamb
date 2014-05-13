package hu.bme.szoftlab4.SZLAMB.Epitmeny;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Lovedek.Lovedek;
import hu.bme.szoftlab4.SZLAMB.Lovedek.LovedekImpl;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.UresMezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

/**
 * Az {@link Epitmeny} egyik implementációja, melyet csak {@link UresMezo}
 * típusú objektumra tudunk építeni.
 * 
 * @author Erhard Pfisztner
 * 
 */
public class Torony extends AbstractEpitmeny {

	boolean kod = false;
	/**
	 * A {@link VarazsKo} -vek hat�s�ra változó érték, mely megadja a torony
	 * hatótávjának mértékét.
	 */
	protected int hatotavSzorzo;

	/**
	 * A {@link VarazsKo} -vek hatására változó érték, mely megadja a torony
	 * tüzelési sebességének mértékét.
	 */
	protected int tuzelesSzorzo;
	private Timer timer;

	public Torony(int tuzelesSzorzo) {
		super();
		this.tuzelesSzorzo = tuzelesSzorzo;

	}

	/**
	 * szerkesztve csak az adott épületre rakható kövek listáját adja vissza
	 */
	@Override
	public List<VarazsKo> getValidKovek() {
		return varazsKovek;
	}

	/**
	 * szerkesztve üres metódus nem csinál semmit
	 */
	public void setKod(boolean vanKod) {
		this.kod = true;
	}

	public boolean isKod() {
		return this.kod;
	}

	@Override
	public void felruhaz(VarazsKo varazsKo) {
		// System.out.println("\t\t-->"+this.getClass().getName()+"felruhaz("+varazsKo.name()+");");
		// System.out.println("\t\t<--void");
		if (!this.varazsKovek.contains(varazsKo)) {
			this.varazsKovek.add(varazsKo);
		}
	}

	@Override
	public void reakcio(GyuruSzovetsege gyuruSzovetsege) {
		System.out.println("\t\t-->" + this.getClass().getName() + ".reakcio("
				+ gyuruSzovetsege.getClass().getName() + ")");
		gyuruSzovetsege.sebez(new LovedekImpl(varazsKovek));
		timer.start();
	}

	@Override
	public void setMezo(final Mezo epitmenyMezo) {
		this.epitmenyMezo = epitmenyMezo;
		timer = new Timer(tuzelesSzorzo * 10, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (epitmenyMezo.getKarakterek() != null) {
					for (GyuruSzovetsege gyuruSzovetsege : epitmenyMezo
							.getKarakterek()) {
						reakcio(gyuruSzovetsege);
					}
				}
			}
		});
		
	}

	@Override
	public ViewType getType() {
		return ViewType.TORONY;
	}
}
