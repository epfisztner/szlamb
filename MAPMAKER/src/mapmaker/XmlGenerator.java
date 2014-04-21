/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapmaker;

import java.io.File;
import java.util.List;
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

    private static MapFieldButton[][] fields = new MapFieldButton[3][2];

    private static List<List<MapFieldButton>> utvonalak;

    public static void setFields(MapFieldButton[][] map) {
        fields = map;
    }

    public static void setUtvonalak(List<List<MapFieldButton>> utvonalak) {
        XmlGenerator.utvonalak = utvonalak;
    }

    public static void makeXml() {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootMapElement = doc.createElement("map");
            doc.appendChild(rootMapElement);

            // mapSize element
            Element mapSize = doc.createElement("mapSize");
            rootMapElement.appendChild(mapSize);

            //horizontal size
            Element horizontalSize = doc.createElement("horizontalSize");
            horizontalSize.appendChild(doc.createTextNode(Integer.toString(fields.length)));
            mapSize.appendChild(horizontalSize);

            //vertical size
            Element verticalSize = doc.createElement("verticalSize");
            verticalSize.appendChild(doc.createTextNode(Integer.toString(fields[0].length)));
            mapSize.appendChild(verticalSize);

            Element mapMezok = doc.createElement("mapMezok");
            rootMapElement.appendChild(mapMezok);
            for (int x = 0; x < fields.length; x++) {
                Element mezoSor = doc.createElement("mezoSor");
                mapMezok.appendChild(mezoSor);
                for (int y = 0; y < fields[0].length; y++) {
                    Element mezo = doc.createElement(fields[x][y].getFieldType().name());
                    mezoSor.appendChild(mezo);
                }
            }

            Element mapUtvonalak = doc.createElement("mapUtvonalak");
            rootMapElement.appendChild(mapUtvonalak);
            for (int firstIndex = 0; firstIndex < utvonalak.size(); firstIndex++) {
                Element utvonal = doc.createElement("utvonal");
                mapUtvonalak.appendChild(utvonal);
                for (int secondIndex = 0; secondIndex < utvonalak.get(firstIndex).size(); secondIndex++) {
                    int firstCoord = -1;
                    int nextCoord = -1;
                    for (int x = 0; x < fields.length && firstCoord < 0 ; x++) {
                        for (int y = 0; y < fields[0].length && firstCoord < 0 ; y++) {
                            if (fields[x][y].equals(utvonalak.get(firstIndex).get(secondIndex))){
                                firstCoord = x;
                                nextCoord = y;
                            }
                        }
                    }
                    if (firstCoord>=0 && nextCoord>=0) {
                        String utString = "";
                        if (secondIndex == utvonalak.get(firstIndex).size()-1) {
                            utString = "vegzetHegye";
                        } else {
                            utString = "ut";
                        }
                        Element ut = doc.createElement(utString);
                        utvonal.appendChild(ut);
                        Element xCoord = doc.createElement("x");
                        xCoord.appendChild(doc.createTextNode(Integer.toString(firstCoord)));
                        ut.appendChild(xCoord);
                        Element yCoord = doc.createElement("y");
                        yCoord.appendChild(doc.createTextNode(Integer.toString(nextCoord)));
                        ut.appendChild(yCoord);
                    }
                }
            }

//		// set attribute to staff element
//		Attr attr = doc.createAttribute("id");
//		attr.setValue("1");
//		mapSize.setAttributeNode(attr);
// 
//		// shorten way
//		// staff.setAttribute("id", "1");
// 
//		// firstname elements
//		Element firstname = doc.createElement("firstname");
//		firstname.appendChild(doc.createTextNode("yong"));
//		mapSize.appendChild(firstname);
// 
//		// lastname elements
//		Element lastname = doc.createElement("lastname");
//		lastname.appendChild(doc.createTextNode("mook kim"));
//		mapSize.appendChild(lastname);
// 
//		// nickname elements
//		Element nickname = doc.createElement("nickname");
//		nickname.appendChild(doc.createTextNode("mkyong"));
//		mapSize.appendChild(nickname);
// 
//		// salary elements
//		Element salary = doc.createElement("salary");
//		salary.appendChild(doc.createTextNode("100000"));
//		mapSize.appendChild(salary);
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("map.xml"));

            // Output to console for testing
            //StreamResult result = new StreamResult(System.out);
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
