package hu.bme.szoftlab4.SZLAMB.View;

import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class GyuruSzovetsegePaintable extends Paintable {

	

	public GyuruSzovetsegePaintable(ViewType viewType, Object modelObject) {
		super(viewType, modelObject);
		this.setPositionX(((GyuruSzovetsege)this.getModelObject()).getPositionX());
		this.setPositionY(((GyuruSzovetsege)this.getModelObject()).getPositionY());
	}


	@Override
	public void paint(Graphics graphics) {
		Graphics2D gg = (Graphics2D) graphics;
		this.setPositionX(((GyuruSzovetsege)this.getModelObject()).getPositionX());
		this.setPositionY(((GyuruSzovetsege)this.getModelObject()).getPositionY());
		gg.drawImage(this.getImage(), this.getPositionX(), this.getPositionY(), 47, 47, null);
	}


	@Override
	public void repaint(Object modelObject, Graphics graphics) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ViewType handleUserInterction() {
		return this.getViewType();
	}

}
