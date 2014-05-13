package hu.bme.szoftlab4.SZLAMB.View;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class MezoPaintable extends Paintable {

	public MezoPaintable(ViewType viewType, Object modelObject) {
		super(viewType, modelObject);
		this.setPositionX(((Mezo)this.getModelObject()).getX());
		this.setPositionY(((Mezo)this.getModelObject()).getY());
	}

	

	@Override
	public void paint(Graphics graphics) {
		Graphics2D gg = (Graphics2D) graphics;
		//gg.clearRect(this.getPositionX(), this.getPositionY(), 47, 47);
		if (this.getViewType().equals(ViewType.VEGZETHEGYE)){
			gg.drawImage(new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\ut.png")).getImage(), this.getPositionX(), this.getPositionY(), 47, 47, null);
		}
		gg.drawImage(this.getImage(), this.getPositionX(), this.getPositionY(), 47, 47, null);
	}



	@Override
	public void repaint(Object modelObject, Graphics graphics) {
		Graphics2D gg = (Graphics2D) graphics;
		this.setModelObject(modelObject);
		this.setPositionX(((Mezo)this.getModelObject()).getX());
		this.setPositionY(((Mezo)this.getModelObject()).getY());
		gg.drawImage(this.getImage(), this.getPositionX(), this.getPositionY(), null);
	}



	@Override
	public ViewType handleUserInterction() {
		//System.out.println("Reakció");
		return this.getViewType();
	}

}
