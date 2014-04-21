package hu.bme.szoftlab4.XMLCODER;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XmlIn {

	//XML beolvasasa
    DocumentBuilderFactory docF = null;
    DocumentBuilder docB = null;
    Document doc = null;
    
    //doc element letrehozasa
    public XmlIn(File file) {
    try {
            docF = DocumentBuilderFactory.newInstance();
            
            //dtd figyelmen kivul hagyasa
            docF.setValidating(false);
            docF.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            docB = docF.newDocumentBuilder();
            doc = docB.parse(file);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
    /*
     * Itt kivalasztjuka teszt tipusnak megfelelo futast
     * 
     */
    public void Tesztel(){
    	/*
    	 * doc nevu elementet hasznaljuk, ez reprezentalja az aktualis teszt dokumentumot
    	 * switch case
    	 */
    	
    }
}
