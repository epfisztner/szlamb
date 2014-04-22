package hu.bme.szoftlab4.SZLAMB.XMLHelper;

import hu.bme.szoftlab4.SZLAMB.Main;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.UresMezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
import hu.bme.szoftlab4.SZLAMB.Mezo.VegzetHegye;

import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
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

public class XMLHelper {
	private static String outPutFileContent = "";
	
	public static void setOutPutFileContent(String outPutFileContent) {
		XMLHelper.outPutFileContent.concat(outPutFileContent);
	}

	private static String outPutFileName;
	private static Mezo[][] map;
	private static List<List<Mezo>> utvonalak = new ArrayList<List<Mezo>>();
	
	public static void readCommandFile(String fileName) {

		try {
			/*
			 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser
			 * /-ról néztem
			 */
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			factory.setFeature("http://xml.org/sax/features/validation", false);
			factory.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-dtd-grammar",
					false);
			factory.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-external-dtd",
					false);
			factory.setFeature(
					"http://xml.org/sax/features/external-general-entities",
					false);
			factory.setFeature(
					"http://xml.org/sax/features/external-parameter-entities",
					false);

			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler topicHandler = new DefaultHandler() {
				String karakterNeve = "";
				int xCoord = -1;
				int yCoord = -1;				
				boolean x = false;
				boolean y = false;
				boolean varazsKo = false;
				boolean karakterName = false;
				boolean rootNode = false;
				boolean randomCommand = false;
				boolean loadCommandFileCommand = false;
				boolean loadMapFileCommand = false;
				boolean setOutputFileCommand = false;
				boolean epitToronyCommand = false;
				boolean epitAkadalyCommand = false;
				boolean epitmenyFelruhazCommand = false;
				boolean addKarakterCommand = false;
				boolean karakterLepCommand = false;
				boolean simulateCommand = false;
				boolean helpCommand = false;
				boolean exitCommand = false;
				private String varazsKoNeve;
				private String randomValue;
				

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equalsIgnoreCase("x")) {
						x = true;
					}
					if (qName.equalsIgnoreCase("y")) {
						y = true;
					}
					if (qName.equalsIgnoreCase("karakterName")) {
						karakterName = true;
					}
					if (qName.equalsIgnoreCase("varazsKo")) {
						varazsKo = true;
					}
					if (qName.equalsIgnoreCase("parancs")) {
						rootNode = true;
					}
					if (qName.equalsIgnoreCase("random")) {
						randomCommand = true;
					}
					if (qName.equalsIgnoreCase("loadCommandFile")) {
						loadCommandFileCommand = true;
					}
					if (qName.equalsIgnoreCase("loadMapFile")) {
						loadMapFileCommand = true;
					}
					if (qName.equalsIgnoreCase("setOutputFile")) {
						setOutputFileCommand = true;
					}
					if (qName.equalsIgnoreCase("epitTorony")) {
						epitToronyCommand = true;
					}
					if (qName.equalsIgnoreCase("epitAkadaly")) {
						epitAkadalyCommand = true;
					}
					if (qName.equalsIgnoreCase("epitmenyFelruhaz")) {
						epitmenyFelruhazCommand = true;
					}
					if (qName.equalsIgnoreCase("addKarakter")) {
						addKarakterCommand = true;
					}
					if (qName.equalsIgnoreCase("karakterLep")) {
						karakterLepCommand = true;
					}
					if (qName.equalsIgnoreCase("simulate")) {
						simulateCommand = true;
					}
					if (qName.equalsIgnoreCase("help")) {
						helpCommand = true;
					}
					if (qName.equalsIgnoreCase("exit")) {
						exitCommand = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					if (qName.equalsIgnoreCase("x")) {
						x = false;
					}
					if (qName.equalsIgnoreCase("y")) {
						y = false;
					}
					if (qName.equalsIgnoreCase("karakterName")) {
						karakterName = false;
					}
					if (qName.equalsIgnoreCase("varazsKo")) {
						varazsKo = false;
					}
					if (qName.equalsIgnoreCase("parancs")) {
						rootNode = false;
					}
					if (qName.equalsIgnoreCase("random")) {
						randomCommand = false;
					}
					if (qName.equalsIgnoreCase("loadCommandFile")) {
						loadCommandFileCommand = false;
					}
					if (qName.equalsIgnoreCase("loadMapFile")) {
						loadMapFileCommand = false;
					}
					if (qName.equalsIgnoreCase("setOutputFile")) {
						setOutputFileCommand = false;
					}
					if (qName.equalsIgnoreCase("epitTorony")) {
						epitToronyCommand = false;
					}
					if (qName.equalsIgnoreCase("epitAkadaly")) {
						epitAkadalyCommand = false;
					}
					if (qName.equalsIgnoreCase("epitmenyFelruhaz")) {
						epitmenyFelruhazCommand = false;
					}
					if (qName.equalsIgnoreCase("addKarakter")) {
						addKarakterCommand = false;
					}
					if (qName.equalsIgnoreCase("karakterLep")) {
						karakterLepCommand = false;
					}
					if (qName.equalsIgnoreCase("simulate")) {
						simulateCommand = false;
					}
					if (qName.equalsIgnoreCase("help")) {
						helpCommand = false;
					}
					if (qName.equalsIgnoreCase("exit")) {
						exitCommand = false;
					}

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					if (setOutputFileCommand) {
						outPutFileName = new String(ch, start, length);
						if (!outPutFileName.contains(".xml")) {
							outPutFileName.concat(".xml");
						}
					}
					if (loadCommandFileCommand) {
						String commandFileName = new String(ch, start, length);
						if (!commandFileName.contains(".xml")) {
							commandFileName.concat(".xml");
						}
						loadCommandFile(commandFileName);
					}
					if (loadMapFileCommand) {
						String mapFileName = new String(ch, start, length);
						if (!mapFileName.contains(".xml")) {
							mapFileName.concat(".xml");
						}
						loadMap(mapFileName);
					}
					if (randomCommand) {
						randomValue = new String(ch, start, length);
						setRandom(randomValue);
					}
					if (epitToronyCommand && x) {
						xCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (epitToronyCommand && y) {
						yCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (epitToronyCommand && xCoord >= 0 && yCoord >=0) {
						epitTorony(xCoord, yCoord);
						xCoord = -1;
						yCoord = -1;
					}
					if (epitAkadalyCommand && x) {
						xCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (epitAkadalyCommand && y) {
						yCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (epitAkadalyCommand && xCoord >= 0 && yCoord >=0) {
						epitAkadaly(xCoord, yCoord);
						xCoord = -1;
						yCoord = -1;
					}
					if (epitmenyFelruhazCommand && varazsKo) {
						varazsKoNeve = new String(ch, start, length);
					}
					if (epitmenyFelruhazCommand && x) {
						xCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (epitmenyFelruhazCommand && y) {
						yCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (epitmenyFelruhazCommand && !varazsKoNeve.equals("") && xCoord >= 0 && yCoord >=0) {
						epitmenyFelruhaz(karakterNeve, xCoord, yCoord);
						varazsKoNeve = "";
						xCoord = -1;
						yCoord = -1;
					}
					if (addKarakterCommand && karakterName) {
						karakterNeve = new String(ch, start, length);
					}
					if (addKarakterCommand && x) {
						xCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (addKarakterCommand && y) {
						yCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (addKarakterCommand && !karakterNeve.equals("") && xCoord >= 0 && yCoord >=0) {
						addKarakter(karakterNeve, xCoord, yCoord);
						karakterNeve = "";
						xCoord = -1;
						yCoord = -1;
					}
					if (karakterLepCommand && karakterName) {
						karakterLep(new String(ch,start, length));
					}
					if (simulateCommand) {
						simulate();
					}
					if (helpCommand) {
						help();
					}
					if (exitCommand) {
						exit();
					}
				}

				
			};
			saxParser.parse(new File(fileName).getAbsolutePath(), topicHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void loadCommandFile(String commandFileName) {
		// TODO Auto-generated method stub
		
	}

	public static void loadMap(String mapFileName) {
		try {
			/*
			 * http://www.mkyong.com/java/how-to-read-xml-file-in-java-sax-parser
			 * /-ról néztem
			 */
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			factory.setFeature("http://xml.org/sax/features/validation", false);
			factory.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-dtd-grammar",
					false);
			factory.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-external-dtd",
					false);
			factory.setFeature(
					"http://xml.org/sax/features/external-general-entities",
					false);
			factory.setFeature(
					"http://xml.org/sax/features/external-parameter-entities",
					false);

			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler topicHandler = new DefaultHandler() {
				int xCoord = -1;
				int yCoord = -1;	
				boolean utvonalUjTemp = true;
				boolean x = false;
				boolean y = false;
				boolean mapSize = false;
				boolean mapMezok = false;
				boolean mezoSor = false;
				boolean URESMEZO = false;
				boolean UT = false;
				boolean VEGZETHEGYE = false;
				boolean mapUtvonalak = false;
				boolean utvonal = false;
				int actualX = -1;
				int actualY = -1;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					if (qName.equalsIgnoreCase("x")) {
						x = true;
					}
					if (qName.equalsIgnoreCase("y")) {
						y = true;
					}
					if (qName.equalsIgnoreCase("mapSize")) {
						mapSize = true;
					}
					if (qName.equalsIgnoreCase("mapMezok")) {
						mapMezok = true;
					}
					if (qName.equalsIgnoreCase("mezoSor")) {
						mezoSor = true;
					}
					if (qName.equalsIgnoreCase("URESMEZO")) {
						URESMEZO = true;
					}
					if (qName.equalsIgnoreCase("UT")) {
						UT = true;
					}
					if (qName.equalsIgnoreCase("VEGZETHEGYE")) {
						VEGZETHEGYE = true;
					}
					if (qName.equalsIgnoreCase("mapUtvonalak")) {
						mapUtvonalak = true;
					}
					if (qName.equalsIgnoreCase("utvonal")) {
						utvonal = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equalsIgnoreCase("x")) {
						x = false;
					}
					if (qName.equalsIgnoreCase("y")) {
						y = false;
					}
					if (qName.equalsIgnoreCase("mapSize")) {
						mapSize = false;
					}
					if (qName.equalsIgnoreCase("mapMezok")) {
						mapMezok = false;
					}
					if (qName.equalsIgnoreCase("mezoSor")) {
						mezoSor = false;
					}
					if (qName.equalsIgnoreCase("URESMEZO")) {
						URESMEZO = false;
					}
					if (qName.equalsIgnoreCase("UT")) {
						UT = false;
					}
					if (qName.equalsIgnoreCase("VEGZETHEGYE")) {
						VEGZETHEGYE = false;
					}
					if (qName.equalsIgnoreCase("mapUtvonalak")) {
						mapUtvonalak = false;
					}
					if (qName.equalsIgnoreCase("utvonal")) {
						utvonal = false;
					}
				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					if (mapSize) {
						int sizeNum = Integer.parseInt(new String(ch, start, length));
						map = new Mezo[sizeNum][sizeNum];
					}
					if (mezoSor) {
						if(actualY < 0 || actualY == map[0].length-1) {
							actualX++;
							actualY= -1;
						}
					}
					
					if (mezoSor && UT) {
						actualY++;
						map[actualX][actualY] = new Ut();
					}
					if (mezoSor && URESMEZO) {
						actualY++;
						map[actualX][actualY] = new UresMezo();
					}
					if (mezoSor && VEGZETHEGYE) {
						actualY++;
						map[actualX][actualY] = new VegzetHegye();
					}
					if (mapUtvonalak && utvonal) {
						if (utvonalUjTemp) {
							utvonalak.add(new ArrayList<Mezo>());
							utvonalUjTemp = false;
						}
					}
					if (mapUtvonalak && utvonal && UT && x) {
						xCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (mapUtvonalak && utvonal && UT && y) {
						yCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (mapUtvonalak && utvonal && xCoord >= 0 && yCoord >= 0) {
						utvonalak.get(utvonalak.size()-1).add(map[xCoord][yCoord]);
						xCoord = -1;
						yCoord = -1;
					}
					if (mapUtvonalak && utvonal && VEGZETHEGYE && x) {
						xCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (mapUtvonalak && utvonal && VEGZETHEGYE && y) {
						yCoord = Integer.parseInt(new String(ch, start, length));
					}
					if (mapUtvonalak && utvonal && xCoord >= 0 && yCoord >= 0 && VEGZETHEGYE) {
						utvonalak.get(utvonalak.size()-1).add(map[xCoord][yCoord]);
						xCoord = -1;
						yCoord = -1;
						utvonalUjTemp = true;
					}
				}

				
			};
			saxParser.parse(new File(mapFileName).getAbsolutePath(), topicHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void writeMapToConsole() {
		System.out.println("x: "+map.length+ "y: "+map[0].length);
		for(int x= 0; x < map.length; x++) {
			for(int y= 0; y < map[x].length; y++) {
				System.out.print(map[x][y].toString());
			}
			System.out.println();
		}
		System.out.println("utvonalak: ");
		for(int x= 0; x < utvonalak.size(); x++) {
			for(int y= 0; y < utvonalak.get(x).size(); y++) {
				System.out.print(utvonalak.get(x).get(y).toString() +" ----> ");
			}
			System.out.println();
		}
	}

	protected static void setRandom(String randomValue) {
		// TODO Auto-generated method stub
		
	}

	protected static void epitTorony(int xCoord, int yCoord) {
		// TODO Auto-generated method stub
		
	}

	protected static void epitAkadaly(int xCoord, int yCoord) {
		// TODO Auto-generated method stub
		
	}

	protected static void epitmenyFelruhaz(String karakterNeve, int xCoord,
			int yCoord) {
		// TODO Auto-generated method stub
		
	}

	protected static void addKarakter(String karakterNeve, int xCoord,
			int yCoord) {
		// TODO Auto-generated method stub
		
	}

	protected static void simulate() {
		// TODO Auto-generated method stub
		
	}

	protected static void help() {
		// TODO Auto-generated method stub
		
	}

	protected static void exit() {
		writeMapToConsole();
		if (Main.input().equals("yes")) {
			
			writeOutPutContentToFile();
			System.exit(0);
		}
	}
	
	private static void writeOutPutContentToFile() {
		// TODO Auto-generated method stub
		
	}

	protected static void karakterLep(String string) {
		// TODO Auto-generated method stub
		
	}

}
