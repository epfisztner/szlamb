package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.View.Paintable;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

public interface ModelConnetor {

	public ViewType getType();

	public void setPaintable(Paintable paintable);
}
