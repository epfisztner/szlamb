package hu.bme.szoftlab4.SZLAMB.View;

import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.corba.se.impl.interceptors.PINoOpHandlerImpl;

public class View extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image x;
	protected List<Paintable> paintables;
	protected Graphics graphics;
	private int xd;
	private int y;

	public View(MouseListener mouseListener) {
		super();
		this.paintables = new ArrayList<Paintable>();
		this.xd = 10;
		this.y = 10;
		this.setSize(600, 400);
		this.addMouseListener(mouseListener);
		Timer t = new Timer(60, this);
		t.start();
	}

	public void addNewPaintable(Paintable paintable) {
		this.paintables.add(paintable);
	}

	@Override
	public void paint(final Graphics arg1) {
		super.paint(arg1);
		this.graphics = arg1;

		// this.graphics.drawOval(300, 300, 100, 30);
		this.graphics.drawString(this.getWidth() + " : " + this.getHeight(),
				xd + 300, 10);
		// this.graphics.drawOval(11, 12, 100, 30);
		Graphics2D gg = (Graphics2D) arg1;
		ImageIcon ii = new ImageIcon(
				"C:\\Users\\pfisz_000\\Desktop\\questions\\brad_pitt\\Brad_Pitt_index.png");
		x = new ImageIcon(getClass().getClassLoader().getResource(
				"\\Resources\\ember.png")).getImage();
		gg.drawImage(x, xd + 100, y + 100, this);
		gg.drawImage(x, xd, y, null);

		paintAll(arg1);
		Toolkit.getDefaultToolkit().sync();

		gg.dispose();
	}

	private void pp(Graphics arg0) {
		this.graphics.drawOval(100, 100, 100, 30);
	}

	public void paintAll(Graphics graphics) {
		for (int x = 0; x < paintables.size(); x++) {
			paintables.get(x).paint(graphics);
		}
		// paintables.get(0).paint(graphics,xd,y);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		xd += 1;
		y += 1;

		if (y > 400) {

			y = 10;
			xd = 10;
		}

		repaint();
	}

	public Epitmeny getEpitmeny(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < paintables.size(); i++) {
			if (paintables.get(i).getPositionX() <= x
					&& paintables.get(i).getPositionX() + 60 > x
					&& paintables.get(i).getPositionY() <= y
					&& paintables.get(i).getPositionY() + 60 > y) {
				if (paintables.get(i).handleUserInterction()
						.equals(ViewType.TORONY)) {
					return (Epitmeny) paintables.get(i).getModelObject();
				} else if (paintables.get(i).handleUserInterction()
						.equals(ViewType.AKADALY)) {
					return (Epitmeny) paintables.get(i).getModelObject();
				}
			}

		}
		return null;
	}

	public Epitmeny getClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < paintables.size(); i++) {
			if (paintables.get(i).getPositionX() <= x
					&& paintables.get(i).getPositionX() + 60 > x
					&& paintables.get(i).getPositionY() <= y
					&& paintables.get(i).getPositionY() + 60 > y) {
				if (paintables.get(i).handleUserInterction()
						.equals(ViewType.TORONY)) {
					return (Epitmeny) paintables.get(i).getModelObject();
				} else if (paintables.get(i).handleUserInterction()
						.equals(ViewType.AKADALY)) {
					return (Epitmeny) paintables.get(i).getModelObject();
				}

			}
		}
		return null;
	}

	public boolean mouseClicked(MouseEvent e, Epitmeny epitmeny) {
		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < paintables.size(); i++) {
			if (paintables.get(i).getPositionX() <= x
					&& paintables.get(i).getPositionX() + 60 > x
					&& paintables.get(i).getPositionY() <= y
					&& paintables.get(i).getPositionY() + 60 > y) {
				if (paintables.get(i).handleUserInterction()
						.equals(ViewType.URESMEZO)
						&& JatekMotor.gameInteractionState
								.equals(ViewType.TORONY)) {
					Torony torony = (Torony) epitmeny;
					torony.setX(paintables.get(i).getPositionX());
					torony.setY(paintables.get(i).getPositionY());
					this.addNewPaintable(new EpitmenyPaintable(ViewType.TORONY,
							torony));
					this.invalidate();
					JatekMotor.gameInteractionState = ViewType.NONE;
					return true;
				} else if (paintables.get(i).handleUserInterction()
						.equals(ViewType.UT)
						&& JatekMotor.gameInteractionState
								.equals(ViewType.AKADALY)) {
					Akadaly akadaly = (Akadaly) epitmeny;
					akadaly.setX(paintables.get(i).getPositionX());
					akadaly.setY(paintables.get(i).getPositionY());
					this.addNewPaintable(new EpitmenyPaintable(
							ViewType.AKADALY, akadaly));
					this.invalidate();
					JatekMotor.gameInteractionState = ViewType.NONE;
					return true;
				} else {
					return false;
				}
			}

		}
		return false;
	}
}
