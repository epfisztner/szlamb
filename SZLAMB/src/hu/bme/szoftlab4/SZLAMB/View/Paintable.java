package hu.bme.szoftlab4.SZLAMB.View;

import hu.bme.szoftlab4.SZLAMB.ModelConnetor;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public abstract class Paintable {
	private ViewType viewType;
	private int positionX;
	private int positionY;
	private Object modelObject;
	private boolean viewAble;
	private Image image;
	private ActionListener actionListener;

	public Paintable(ViewType viewType, Object modelObject) {
		this.viewType = viewType;
		this.setModelObject(modelObject);
		((ModelConnetor)this.modelObject).setPaintable(this);
		this.viewAble = true;
		switch (this.viewType) {
		case UT:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\ut.png")).getImage();
			break;
		case TORONY:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\torony.png")).getImage();
			break;
		case VEGZETHEGYE:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\vegzet_hegye.png")).getImage();
			break;
		case AKADALY:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\akadaly.png")).getImage();
			break;
		case EMBER:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\ember.png")).getImage();
			break;
		case URESMEZO:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\ures_mezo.png")).getImage();
			break;
		case HOBBIT:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\hobbit.png")).getImage();
			break;
		case TORP:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\torp.png")).getImage();
			break;
		case TUNDE:
			image = new ImageIcon(getClass().getClassLoader().getResource("\\Resources\\tunde.png")).getImage();
			break;
		default:
			break;
		}
	}
	
	public abstract ViewType handleUserInterction();

	public abstract void paint(Graphics graphics);
	
	public abstract void repaint(Object modelObject,Graphics graphics);

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

	public Object getModelObject() {
		return modelObject;
	}

	public void setModelObject(Object modelObject) {
		this.modelObject = modelObject;
	}
}
