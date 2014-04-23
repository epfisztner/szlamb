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
import mapmaker.MapFieldButton;
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
            mapSize.appendChild(doc.createTextNode(Integer.toString(fields.length)));
            rootMapElement.appendChild(mapSize);

            //horizontal size
            //Element horizontalSize = doc.createElement("horizontalSize");
           // horizontalSize.appendChild(doc.createTextNode(Integer.toString(fields.length)));
            //mapSize.appendChild(horizontalSize);

            //vertical size
           // Element verticalSize = doc.createElement("verticalSize");
           // verticalSize.appendChild(doc.createTextNode(Integer.toString(fields[0].length)));
           // mapSize.appendChild(verticalSize);

            Element mapMezok = doc.createElement("mapMezok");
            rootMapElement.appendChild(mapMezok);
            for (int x = 0; x < fields.length; x++) {
                Element mezoSor = doc.createElement("mezoSor");
                mapMezok.appendChild(mezoSor);
                for (int y = 0; y < fields[0].length; y++) {
                    Element mezo = doc.createElement(fields[x][y].getFieldType().name());
                    mezo.appendChild(doc.createTextNode(" "));
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
                            utString = "VEGZETHEGYE";
                        } else {
                            utString = "UT";
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

    
}
