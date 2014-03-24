package hu.bme.szoftlab4.SZLAMB;

/**
 * Ez az osztály lesz a játék indításáért illetve befejezéséért felelõs, itt
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
	protected Szaruman szaruman;
	
	public JatekMotor() {
		super();
		System.out.println(""+this.getClass().getName()+".constructor()");
		className = this.getClass().getName();
		this.szaruman = new Szaruman();
		System.out.println("<--");
	}

	/**
	 * Új játék indítása, amennyiben a játék már egyszer végetért.
	 */
	public void ujJatek(){
		System.out.println("\t-->"+className+".ujJatek");
		this.szaruman.start();
		System.out.println("\t<--void");
	}
	/**
	 * Játék vége a játékos vereségével.
	 */
	public static void jatekVegeVeszit(){
		System.out.println("\t-->"+className+".jatekVegeVeszit()");
		System.out.println("\t<--void");
	}
	/**
	 * Játék vége a játékos gyõzelmével.
	 */
	public static void jatekVegeNyert(){
		System.out.println("\t-->"+className+".jatekVegeNyert()");
		System.out.println("\t<--void");
	}
	/**
	 * Játék indítása elõször
	 */
	public void start(){	
		System.out.println("-->"+className+".start()");
		this.szaruman.start();
		System.out.println("<--void");
	}
}
