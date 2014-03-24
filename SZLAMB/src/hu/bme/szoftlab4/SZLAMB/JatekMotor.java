package hu.bme.szoftlab4.SZLAMB;

/**
 * Ez az oszt�ly lesz a j�t�k ind�t�s��rt illetve befejez�s��rt felel�s, itt
 * van referencia a j�t�kost reprezent�l� {@link Szaruman} -ra is.
 * 
 * @author Erhard Pfisztner
 *
 */
public class JatekMotor {
	
	static String className;
	/**
	 * J�t�kost reprezent�l� objektum.
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
	 * �j j�t�k ind�t�sa, amennyiben a j�t�k m�r egyszer v�get�rt.
	 */
	public void ujJatek(){
		System.out.println("\t-->"+className+".ujJatek");
		this.szaruman.start();
		System.out.println("\t<--void");
	}
	/**
	 * J�t�k v�ge a j�t�kos veres�g�vel.
	 */
	public static void jatekVegeVeszit(){
		System.out.println("\t-->"+className+".jatekVegeVeszit()");
		System.out.println("\t<--void");
	}
	/**
	 * J�t�k v�ge a j�t�kos gy�zelm�vel.
	 */
	public static void jatekVegeNyert(){
		System.out.println("\t-->"+className+".jatekVegeNyert()");
		System.out.println("\t<--void");
	}
	/**
	 * J�t�k ind�t�sa el�sz�r
	 */
	public void start(){	
		System.out.println("-->"+className+".start()");
		this.szaruman.start();
		System.out.println("<--void");
	}
}
