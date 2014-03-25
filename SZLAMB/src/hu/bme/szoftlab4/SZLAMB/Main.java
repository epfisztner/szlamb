package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Torony;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Ember;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Hobbit;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Torp;
import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.Tunde;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.UresMezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
import hu.bme.szoftlab4.SZLAMB.Mezo.VegzetHegye;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A szkeleton lelke ez az osztály,
 * itt soroljuk fel a különböző teszteseteket illetve el is végezzék azokat a felhasználó
 * kérése szerint.
 * 
 * @author Erhard Pfisztner
 *
 */
public class Main {
	
	public JatekMotor jatekMotor = null;

	public static void main(String[] args) {

		Main main = new Main();
		main.start();

	}
	
	private void start() {
		
		while (true) {
			System.out.println("1. Teszteset: Jatek inditas");
			System.out.println("2. Teszteset: Uj jatek");
			System.out.println("3. Teszteset: Torony epites");
			System.out.println("4. Teszteset: Akadaly epites");
			System.out.println("5. Teszteset: Epitmeny felruhazas");
			System.out.println("6. Teszteset: Karakter akadalyra lep");
			System.out.println("7. Teszteset: Karakter torony hatotavba er");
			System.out.println("8. Teszteset: Jatek vege- vesztes");
			System.out.println("9. Teszteset: Jatek vege- nyert");
			System.out.print("Add meg a futtatando teszteset szamat:");
			int testNum = Integer.parseInt(input());
			switch (testNum) {
			case 1:
				test1();
				break;
			case 2:
				test2();
				break;
			case 3:
				test3();
				break;
			case 4:
				test4();
				break;
			case 5:
				test5();
				break;
			case 6:
				test6();
				break;
			case 7:
				test7();
				break;
			case 8:
				test8();
				break;
			case 9:
				test9();
				break;
			default:
				System.out.println("Nem megfelelo bemenet!");
				break;
			}
			System.out.println("A menube visszatereshez nyomj enter-t");
                        input();
			Console console = System.console();
			if (console != null) {
				console.flush();
			}
		}
	}
	/**
	 * Első teszteset:  Jatek inditas
	 */
	private void test1() {
		jatekMotor = new JatekMotor();
	}

	/**
	 * 2. Teszteset: Uj jatek");
	 */
	private void test2() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		jatekMotor.start();
	}

	/**
	 * 3. Teszteset: Torony epites");
	 */
	private void test3() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		jatekMotor.szaruman.epitTorony(jatekMotor.szaruman.palya.mezok.get(1));
	}

	/**
	 * 4. Teszteset: Akadaly epites");
	 */
	private void test4() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		jatekMotor.szaruman.epitAkadaly(jatekMotor.szaruman.palya.mezok.get(0));
	}

	/**
	 * 5. Teszteset: Epitmeny felruhazas");
	 */
	private void test5() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		System.out.print("[?] Trony vagy akadaly (torony/akadaly):");
		String epitmenyInput = input();
		if(epitmenyInput.equalsIgnoreCase("torony")) {
			System.out.print("[?] Milyen varazsKovet akarsz rarakni (TUNDE, TORP,	HOBBIT,	EMBER, HATOTAV,	TUZELES): ");
			String varKo = input();
			Mezo uresMezo = jatekMotor.szaruman.palya.mezok.get(1);
			uresMezo.epitmenyRegiszter(jatekMotor.szaruman.palya.getPrototipusokEpitmeny().get(0));
			jatekMotor.szaruman.felruhaz(uresMezo, VarazsKo.valueOf(varKo));
		} else if(epitmenyInput.equalsIgnoreCase("akadaly")) {
			System.out.print("[?] Milyen varazsKovet akarsz rarakni (TUNDE, TORP,	HOBBIT,	EMBER): ");
			String varKo = input();
			Mezo ut = jatekMotor.szaruman.palya.mezok.get(0);
			try {
				ut.epitmenyRegiszter((Akadaly)jatekMotor.szaruman.palya.prototipusokEpitmeny.get(1).clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jatekMotor.szaruman.felruhaz(ut, VarazsKo.valueOf(varKo));
		}
	}

	/**
	 * 6. Teszteset: Karakter akadalyra lep");
	 */
	private void test6() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		GyuruSzovetsege karakter = null;
		
		Mezo ut = jatekMotor.szaruman.palya.mezok.get(0);
		try {
			ut.epitmenyRegiszter((Akadaly)jatekMotor.szaruman.palya.prototipusokEpitmeny.get(1).clone());
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.print("[?] Milyen ellenseg (tunde/torp/ember/hobbit):");
		String karakterInput = input();
		
		try {
			if (karakterInput.equalsIgnoreCase("tunde")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(3).clone();	
			} else if (karakterInput.equalsIgnoreCase("torp")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(2).clone();
			} else if (karakterInput.equalsIgnoreCase("ember")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(0).clone();
			} else if (karakterInput.equalsIgnoreCase("hobbit")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(1).clone();
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jatekMotor.szaruman.palya.mezok.get(0).karakterRegiszter(karakter);
	}

	/**
	 * 7. Teszteset: Karakter torony hatotavba er");
	 */
	private void test7() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		GyuruSzovetsege karakter = null;
		
		Mezo ut = jatekMotor.szaruman.palya.mezok.get(1);
		try {
			ut.epitmenyRegiszter((Torony)jatekMotor.szaruman.palya.prototipusokEpitmeny.get(0).clone());
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.print("[?] Milyen ellenseg (tunde/torp/ember/hobbit):");
		String karakterInput = input();
		
		try {
			if (karakterInput.equalsIgnoreCase("tunde")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(3).clone();	
			} else if (karakterInput.equalsIgnoreCase("torp")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(2).clone();
			} else if (karakterInput.equalsIgnoreCase("ember")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(0).clone();
			} else if (karakterInput.equalsIgnoreCase("hobbit")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(1).clone();
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ut.karakterRegiszter(karakter);
	}

	/**
	 * 	8. Teszteset: Jatek vege- vesztes");
	 */
	private void test8() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		GyuruSzovetsege karakter = null;
		
		System.out.print("[?] Milyen ellenseg (tunde/torp/ember/hobbit):");
		String karakterInput = input();
		
		try {
			if (karakterInput.equalsIgnoreCase("tunde")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(3).clone();	
			} else if (karakterInput.equalsIgnoreCase("torp")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(2).clone();
			} else if (karakterInput.equalsIgnoreCase("ember")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(0).clone();
			} else if (karakterInput.equalsIgnoreCase("hobbit")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(1).clone();
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jatekMotor.szaruman.palya.mezok.get(2).karakterRegiszter(karakter);
	}

	/**
	 * 9. Teszteset: Jatek vege- nyert");
	 */
	private void test9() {
		if(jatekMotor == null)
			jatekMotor = new JatekMotor();
		GyuruSzovetsege karakter = null;
		
		System.out.print("[?] Milyen ellenseg (tunde/torp/ember/hobbit):");
		String karakterInput = input();
		try {
			if (karakterInput.equalsIgnoreCase("tunde")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(3).clone();	
			} else if (karakterInput.equalsIgnoreCase("torp")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(2).clone();
			} else if (karakterInput.equalsIgnoreCase("ember")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(0).clone();
			} else if (karakterInput.equalsIgnoreCase("hobbit")) {
				karakter = (GyuruSzovetsege) jatekMotor.szaruman.palya.getPrototipusokGyuru().get(1).clone();
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mezo uresMezo = jatekMotor.szaruman.palya.mezok.get(1);
		if(!uresMezo.isBeepitett())
			try {
				uresMezo.epitmenyRegiszter((Torony)jatekMotor.szaruman.palya.getPrototipusokEpitmeny().get(0).clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		uresMezo.karakterRegiszter(karakter);
	}

	/**
	 *  A felhasználói inputokat ezen a metóduson keresztűl kérjük be a program minden részén,
	 *  ezért statikus.
	 * @return {@link String}
	 */
	public static String input() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			return input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
