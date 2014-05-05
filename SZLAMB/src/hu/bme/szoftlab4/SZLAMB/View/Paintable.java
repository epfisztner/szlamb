package hu.bme.szoftlab4.SZLAMB.View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

public abstract class Paintable {
	private ViewType viewType;
	private int positionX;
	private int positionY;
	private Graphics graphics;
	private boolean viewAble;
	private Image image;
	private ActionListener actionListener;

	public Paintable(ViewType viewType) {
		this.viewType = viewType;
	}
	
	public abstract void repaint(Object modelObject);

	public ViewType getViewType() {
		return viewType;
	}

	public void setViewType(ViewType viewType) {
		this.viewType = viewType;
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
	}

	public Graphics getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}

	public boolean isViewAble() {
		return viewAble;
	}

	public void setViewAble(boolean viewAble) {
		this.viewAble = viewAble;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ActionListener getActionListener() {
		return actionListener;
	}

	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
}
