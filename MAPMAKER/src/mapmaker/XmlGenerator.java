/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapmaker;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Erhard Pfisztner
 */
public class XmlGenerator {
    
    
    /*
    private Element insertMapMezoSor(Element rootElement, ) {
        
        return null;
    }
    */
    public void makeX(){
        try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootMapElement = doc.createElement("map");
		doc.appendChild(rootMapElement);
 
		// mapSize elements
		Element mapSize = doc.createElement("mapSize");
		rootMapElement.appendChild(mapSize);
 
		// set attribute to staff element
		Attr attr = doc.createAttribute("id");
		attr.setValue("1");
		mapSize.setAttributeNode(attr);
 
		// shorten way
		// staff.setAttribute("id", "1");
 
		// firstname elements
		Element firstname = doc.createElement("firstname");
		firstname.appendChild(doc.createTextNode("yong"));
		mapSize.appendChild(firstname);
 
		// lastname elements
		Element lastname = doc.createElement("lastname");
		lastname.appendChild(doc.createTextNode("mook kim"));
		mapSize.appendChild(lastname);
 
		// nickname elements
		Element nickname = doc.createElement("nickname");
		nickname.appendChild(doc.createTextNode("mkyong"));
		mapSize.appendChild(nickname);
 
		// salary elements
		Element salary = doc.createElement("salary");
		salary.appendChild(doc.createTextNode("100000"));
		mapSize.appendChild(salary);
 
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("C:\\file.xml"));
 
		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
//    
//    public static void searchInFile(int fileIndex) {
//
//        try {
//            /*
//             * http://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser/-ról néztem
//             */
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            factory.setValidating(false);
//            factory.setFeature("http://xml.org/sax/features/validation", false);
//            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
//            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
//            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
//            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//
//            SAXParser saxParser = factory.newSAXParser();
//            DefaultHandler topicHandler = new DefaultHandler() {
//
//                boolean docno = false;
//                boolean title = false;
//                boolean lead = false;
//                boolean text = false;
//
//                public void startElement(String uri, String localName, String qName,
//                        Attributes attributes) throws SAXException {
//                    if (qName.equalsIgnoreCase("DOCNO")) {
//                        docno = true;
//                    }
//                    if (qName.equalsIgnoreCase("TEXT")) {
//                        text = true;
//                    }
//                    if (qName.equalsIgnoreCase("LEAD")) {
//                        lead = true;
//                    }
//                    if (qName.equalsIgnoreCase("TITLE")) {
//                        title = true;
//                    }
//
//                }
//
//                public void endElement(String uri, String localName,
//                        String qName) throws SAXException {
//                    if (qName.equalsIgnoreCase("DOCNO")) {
//                        docno = false;
//                    }
//                    if (qName.equalsIgnoreCase("TEXT")) {
//                        text = false;
//                    }
//                    if (qName.equalsIgnoreCase("LEAD")) {
//                        text = false;
//                    }
//                    if (qName.equalsIgnoreCase("TITLE")) {
//                        title = false;
//                    }
//                }
//
//                public void characters(char ch[], int start, int length) throws SAXException {
//                    if (docno) {
//                        aktualisDocno = new String(ch, start, length);
//                        //kulcsSzavakSzama.put(aktualisDocno, 0);
//                    }
//
//                    String forrasSzoveg = new String(new String(ch, start, length));
//
//                    forrasSzoveg = forrasSzoveg.replaceAll("[.,!?:()-]", " ");
//
//                    forrasSzoveg = forrasSzoveg.replaceAll("[0-9]", "");
//
//                    forrasSzoveg = forrasSzoveg.replaceAll("[ ]{2}+", " ");
//                    for (int index = 0; index < keresoSzavak.size(); index++) {
//                        Pattern pattern = Pattern.compile(keresoSzavak.get(index));
//                        Matcher matcher = pattern.matcher(forrasSzoveg);
//                        while (matcher.find()) {
//                            aktualisKeresoSzo = keresoSzavak.get(index);
//                            HashMap<String, Integer> tar = kulcsSzavakSzama.get(aktualisKeresoSzo);
//                            Integer szamlalo = 0;
//                            if (tar != null) {
//                                if(tar.get(aktualisDocno) != null) {
//                                    szamlalo = tar.get(aktualisDocno);
//                                }
//                            } else {
//                                tar = new HashMap<String, Integer>();
//                            }
//                            szamlalo++;
//                            tar.put(aktualisDocno, szamlalo);
//                            kulcsSzavakSzama.put(aktualisKeresoSzo, tar);
//                        }
//                    }
//                }
//            };
//            saxParser.parse(fajlok.get(fileIndex).getAbsolutePath(), topicHandler);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    
    
    
}
