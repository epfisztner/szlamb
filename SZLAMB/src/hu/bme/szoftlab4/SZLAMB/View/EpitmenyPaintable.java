package hu.bme.szoftlab4.SZLAMB.View;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class EpitmenyPaintable extends Paintable {

	public EpitmenyPaintable(ViewType viewType, Object modelObject) {
		super(viewType, modelObject);
		this.setPositionX(((Epitmeny)this.getModelObject()).getX());
		this.setPositionY(((Epitmeny)this.getModelObject()).getY());
	}

	@Override
	public void paint(Graphics graphics) {
		Graphics2D gg = (Graphics2D) graphics;
		gg.drawImage(this.getImage(), this.getPositionX(), this.getPositionY(), 60, 60, null);
		if (this.getViewType().equals(ViewType.TORONY) && ((Torony)this.getModelObject()).isKod()) {
			gg.drawImage(new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\fog.png")).getImage(), this.getPositionX(), this.getPositionY(), 60, 60, null);
		}
		
	}

	@Override
	public void repaint(Object modelObject, Graphics graphics) {
		
	}

	@Override
	public ViewType handleUserInterction() {
		return this.getViewType();
	}

}
