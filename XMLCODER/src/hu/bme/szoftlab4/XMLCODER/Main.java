package hu.bme.szoftlab4.XMLCODER;

import java.io.File;
import java.io.IOException;





public class Main {
	public static void main(String args[]) throws IOException
	{
		XmlIn xmlIn = null;
		/*
		 *A test nevu mappat directory nevu fajlkent beolvassuk
		 *A benne levo tesztesetekből listát csinálunk 
		 */
		File directory = new File("tests");
		File[] tests = directory.listFiles();
		

		/*
		 * vegig iteralunk a teszteseteken es meghivjuk rajtuk a Tesztel fuggvenyt
		 */
		for ( int counter = 0; counter < tests.length; counter++) {
			xmlIn = new XmlIn(tests[counter]);
			xmlIn.Tesztel();
		}
	}
}