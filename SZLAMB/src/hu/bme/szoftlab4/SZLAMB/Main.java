package hu.bme.szoftlab4.SZLAMB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		Main main = new Main();
		main.start();

	}
	
	private void start() {
		
		while (true) {
			System.out.println("1. Teszteset: ");
			System.out.println("2. Teszteset: ");
			System.out.println("3. Teszteset: ");
			System.out.println("4. Teszteset: ");
			System.out.println("5. Teszteset: ");
			System.out.println("6. Teszteset: ");
			System.out.println("7. Teszteset: ");
			System.out.println("8. Teszteset: ");
			System.out.println("9. Teszteset: ");
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
		}
	}

	private void test1() {

	}

	private void test2() {

	}

	private void test3() {

	}

	private void test4() {

	}

	private void test5() {

	}

	private void test6() {

	}

	private void test7() {

	}

	private void test8() {

	}

	private void test9() {

	}

	private static String input() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			return input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
