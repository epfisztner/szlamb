package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

import java.util.List;

/**
 * Ez az osztály lesz a játék indításáért illetve befejezéséért felelős, itt
 * van referencia a játékost reprezentáló {@link Szaruman} -ra is.
 * 
 * @author Erhard Pfisztner
 *
 */
public class JatekMotor {
	
	static String className;
	/**
	 * Játékost reprezentáló objektum.
	 */
	public Szaruman szaruman;
	
	public JatekMotor() {
		//System.out.println("-->"+this.getClass().getName()+".constructor()");
		className = this.getClass().getName();
		this.szaruman = new Szaruman();
		//System.out.println("<--");
	}

	/**
	 * új játék indítása, amennyiben a játék már egyszer végetért.
	 */
	public void ujJatek(){
		//System.out.println("\t-->"+className+".ujJatek");
		this.szaruman.start();
		//System.out.println("\t<--void");
	}
	/**
	 * Játék vége a játékos vereségével.
	 */
	public static void jatekVegeVeszit(){
		//System.out.println("\t\t-->"+className+".jatekVegeVeszit()");
		//System.out.println("\t\t<--void");
		XMLHelper.setOutPutFileContent(" vegzet hegye jatekos veszitett");
	}
	/**
	 * Játék vége a játékos győzelmével.
	 */
	public static void jatekVegeNyert(){
		//System.out.println("\t\t\t\t\t\t-->"+className+".jatekVegeNyert()");
		//System.out.println("\t\t\t\t\t\t<--void");
		XMLHelper.setOutPutFileContent(" jatekos nyert");
	}
	/**
	 * Játék indítása először
	 */
	public void start(){	
		//System.out.println("-->"+className+".start()");
		this.szaruman.start();
		//System.out.println("<--void");
	}
}
