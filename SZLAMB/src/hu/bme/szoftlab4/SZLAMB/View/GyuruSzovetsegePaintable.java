package hu.bme.szoftlab4.SZLAMB.View;

import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

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
		if (((GyuruSzovetsege)this.getModelObject()).isMegy()) {
			
			gg.drawImage(this.getImage(), this.getPositionX(), this.getPositionY(), 60, 60, null);
			Random r = new Random(System.currentTimeMillis());
			gg.setColor(Color.white);
			gg.drawString(((GyuruSzovetsege)this.getModelObject()).getEletero()+" hp", this.getPositionX()-60, this.getPositionY());
		}
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
