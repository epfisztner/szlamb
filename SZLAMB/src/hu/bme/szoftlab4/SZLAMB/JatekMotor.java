package hu.bme.szoftlab4.SZLAMB;


public class JatekMotor {
	
	static String className;
	
	protected Szaruman szaruman;
	
	public JatekMotor() {
		super();
		System.out.println(""+this.getClass().getName()+".constructor()");
		className = this.getClass().getName();
		this.szaruman = new Szaruman();
		System.out.println("<--");
	}

	public void ujJatek(){
		System.out.println("\t-->"+className+".ujJatek");
		this.szaruman.start();
		System.out.println("\t<--void");
	}
	
	public static void jatekVegeVeszit(){
		System.out.println("\t-->"+className+".jatekVegeVeszit()");
		System.out.println("\t<--void");
	}
	
	public static void jatekVegeNyert(){
		System.out.println("\t-->"+className+".jatekVegeNyert()");
		System.out.println("\t<--void");
	}
	
	public void start(){	
		System.out.println("-->"+className+".start()");
		this.szaruman.start();
		System.out.println("<--void");
	}
}
