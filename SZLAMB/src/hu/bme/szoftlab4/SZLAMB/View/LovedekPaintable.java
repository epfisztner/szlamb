package hu.bme.szoftlab4.SZLAMB.View;

import java.awt.Graphics;

public class LovedekPaintable extends Paintable {

	

	public LovedekPaintable(ViewType viewType, Object modelObject) {
		super(viewType, modelObject);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void paint(Graphics graphics) {
		// TODO Auto-generated method stub
		
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
