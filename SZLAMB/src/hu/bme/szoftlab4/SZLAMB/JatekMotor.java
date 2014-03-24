package hu.bme.szoftlab4.SZLAMB;


public class JatekMotor {
	
	protected Szaruman szaruman;
	
	public JatekMotor() {
		super();	
	}

	public void ujJatek(){
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}
	
	public void jatekVegeVeszit(){
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}
	
	public void jatekVegeNyert(){
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}
	
	public void start(){	
		System.out.println("\t-->"+this.getClass().getName()+".getVarazsKovek()");
		System.out.println("/t<--void");
	}
}
