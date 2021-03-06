package hu.bme.szoftlab4.SZLAMB.XMLHelper;

import hu.bme.szoftlab4.SZLAMB.GyuruSzovetsege.GyuruSzovetsege;
import hu.bme.szoftlab4.SZLAMB.JatekMotor;
import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.UresMezo;
import hu.bme.szoftlab4.SZLAMB.Mezo.Ut;
import hu.bme.szoftlab4.SZLAMB.Mezo.VegzetHegye;
import hu.bme.szoftlab4.SZLAMB.Palya;
import hu.bme.szoftlab4.SZLAMB.VarazsKo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLHelper {
	public static String outPutFileContent = "<teszt>";
	
	public static void setOutPutFileContent(String outPutFileContent) {
		XMLHelper.outPutFileContent += outPutFileContent;
	}

	private String outPutFileName;
	private Mezo[][] map;
	private List<List<Mezo>> utvonalak = new ArrayList<List<Mezo>>();
	private JatekMotor jatekMotor;
	
	
	public void readCommandFile(String fileName) {

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
				int karakterLife = 0;
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
				boolean life = false;
				boolean karakterLepCommand = false;
				boolean simulateCommand = false;
				boolean helpCommand = false;
				boolean exitCommand = false;
				private String varazsKoNeve ="";
				private String randomValue = "";
				

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
					if (qName.equalsIgnoreCase("life")) {
						life = true;
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
					if (qName.equalsIgnoreCase("life")) {
						life = false;
					}

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {
					if (setOutputFileCommand) {
						outPutFileName = new String(ch, start, length);
						if (!outPutFileName.contains(".xml")) {
							outPutFileName.concat(".xml");
						}
						setOutPutFileContent("<setOutputFile>"+outPutFileName+"</setOutputFile>\n");
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
						//loadMap(mapFileName);
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
						epitmenyFelruhaz(varazsKoNeve, xCoord, yCoord);
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
					if (addKarakterCommand && life) {
						if (length ==0) {
							karakterLife = 100;
						} else {
							karakterLife = Integer.parseInt(new String(ch, start, length));
						}
						
					}
					if (addKarakterCommand && !karakterNeve.equals("") && xCoord >= 0 && yCoord >=0 && karakterLife > 0) {
						addKarakter(karakterNeve, xCoord, yCoord, karakterLife);
						karakterNeve = "";
						karakterLife = 0;
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

	protected void loadCommandFile(String commandFileName) {
		setOutPutFileContent("<loadCommandFile>"+commandFileName+"</loadCommandFile>\n<parancs>\n");
		this.readCommandFile(commandFileName);
		setOutPutFileContent("</parancs>");
	}

	public void loadMap() {
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
						setMap(new Mezo[sizeNum][sizeNum]);
					}
					if (mezoSor) {
						if(actualY < 0 || actualY == getMap()[0].length-1) {
							actualX++;
							actualY= -1;
						}
					}
					
					if (mezoSor && UT) {
						actualY++;
						getMap()[actualX][actualY] = new Ut(actualX,actualY);
					}
					if (mezoSor && URESMEZO) {
						actualY++;
						getMap()[actualX][actualY] = new UresMezo(actualX,actualY);
					}
					if (mezoSor && VEGZETHEGYE) {
						actualY++;
						getMap()[actualX][actualY] = new VegzetHegye(actualX,actualY);
					}
					if (mapUtvonalak && utvonal) {
						if (utvonalUjTemp) {
							getUtvonalak().add(new ArrayList<Mezo>());
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
						getUtvonalak().get(getUtvonalak().size()-1).add(getMap()[xCoord][yCoord]);
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
						getUtvonalak().get(getUtvonalak().size()-1).add(getMap()[xCoord][yCoord]);
						xCoord = -1;
						yCoord = -1;
						utvonalUjTemp = true;
					}
				}	
			};
                        URL uri = this.getClass().getClassLoader().getResource("\\Resources\\map.xml");
                        //InputStream stream = XMLHelper.class.getResourceAsStream("\\Resources\\map.xml");
			saxParser.parse(new File(uri.toURI()), topicHandler);
			//setOutPutFileContent("<loadMapFile>sikeres: "+mapFileName+"->"+getMap().length+"x"+getMap().length+"-s palya, "+getUtvonalak().size()+" db utvonal</loadMapFile>\n");
			//initGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeMapToConsole() {
		System.out.println("Palya kirajzolása:");
		System.out.println("x: "+getMap().length+ "y: "+getMap()[0].length);
		for(int x= 0; x < getMap().length; x++) {
			for(int y= 0; y < getMap()[x].length; y++) {
				if (getMap()[x][y].toString().equalsIgnoreCase("UT")) {
					System.out.print(getMap()[x][y].toString()+"\t ");
				} else {
					System.out.print(getMap()[x][y].toString()+" ");
				}
				
			}
			System.out.println();
		}
		System.out.println("utvonalak: ");
		for(int x= 0; x < getUtvonalak().size(); x++) {
			for(int y= 0; y < getUtvonalak().get(x).size(); y++) {
				System.out.print(getUtvonalak().get(x).get(y).toString() +" ----> ");
			}
			System.out.println();
		}
	}
	
	protected void initGame() {
		//jatekMotor = new JatekMotor();
		//jatekMotor.szaruman.getPalya().palyaEpites(getMap(), utvonalak);
	}

	protected void setRandom(String randomValue) {
		setOutPutFileContent("<random>"+randomValue+"</random>\n");
	}

	protected void epitTorony(int xCoord, int yCoord) {
		jatekMotor.szaruman.epitTorony(Palya.getMezok()[xCoord][yCoord]);
		setOutPutFileContent("<epitTorony> Sikeres epites az ["+xCoord+"]["+yCoord+"] mezore</epitTorony>\n");
	}

	protected void epitAkadaly(int xCoord, int yCoord) {
		jatekMotor.szaruman.epitAkadaly(Palya.getMezok()[xCoord][yCoord]);
		setOutPutFileContent("<epitAkadaly> Sikeres epites az ["+xCoord+"]["+yCoord+"] mezore</epitAkadaly>\n");
	}

	protected void epitmenyFelruhaz(String varazsKoNeve, int xCoord,
			int yCoord) {
		VarazsKo varazsKo = VarazsKo.valueOf(varazsKoNeve);
		jatekMotor.szaruman.felruhaz(Palya.getMezok()[xCoord][yCoord], varazsKo);
		setOutPutFileContent("<epitmenyFelruhaz> Sikeres felruhazas az ["+xCoord+"]["+yCoord+"] mezore ["+varazsKoNeve+"]</epitmenyFelruhaz>\n");
	}

	protected void addKarakter(String karakterNeve, int xCoord,
			int yCoord, int karakterLife) {
		
		List<GyuruSzovetsege> karakterek = jatekMotor.szaruman.getPalya().getKarakterek();
		int karakterNum = 0;
		if (karakterNeve.equalsIgnoreCase("ember")){
			karakterNum = 0;
		} else if (karakterNeve.equalsIgnoreCase("hobbit")) {
			karakterNum = 1;
		} else if (karakterNeve.equalsIgnoreCase("torp")) {
			karakterNum = 2;
		} else if (karakterNeve.equalsIgnoreCase("tunde")) {
			karakterNum = 3;
		}
		GyuruSzovetsege karakter = jatekMotor.szaruman.getPalya().getPrototipusokGyuru().get(karakterNum);
		karakter.setUtvonal(getUtvonalak().get(0));
		karakter.setPositionX(xCoord);
		karakter.setPositionY(yCoord);
		
		karakter.setEletero(karakterLife);
		karakterek.add(karakter);
		jatekMotor.szaruman.getPalya().setKarakterek(karakterek);
		setOutPutFileContent("<addKarakter> Sikeres " + karakterNeve +" eletero ["+karakterLife+"] hozzaadasa az ["+xCoord+"]["+yCoord+"] utra</addKarakter>\n");
	}

	protected void simulate() {
		jatekMotor.start();
		setOutPutFileContent("<simulate> Sikeres szimulálás "+""+" mp</simulate>\n");
	}

	protected void help() {
		// TODO Auto-generated method stub
	}

	protected void exit() {
		writeMapToConsole();
		//if (Main.input().equals("yes")) {
			setOutPutFileContent("<exit/>\n</teszt>");
			writeOutPutContentToFile();
		//}
	}
	
	private void writeOutPutContentToFile() {
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(new File(outPutFileName));			
			bw = new BufferedWriter(fw);
			bw.write(outPutFileContent);
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	protected void karakterLep(String karakterNeve) {
		List<GyuruSzovetsege> karakterek = jatekMotor.szaruman.getPalya().getKarakterek();
		int karakterNum = 0;
		if (karakterNeve.equalsIgnoreCase("ember")){
			karakterNum = 0;
		} else if (karakterNeve.equalsIgnoreCase("hobbit")) {
			karakterNum = 1;
		} else if (karakterNeve.equalsIgnoreCase("torp")) {
			karakterNum = 2;
		} else if (karakterNeve.equalsIgnoreCase("tunde")) {
			karakterNum = 3;
		}
		XMLHelper.setOutPutFileContent("<karakterLep>"+karakterNeve);
		jatekMotor.szaruman.getPalya().getKarakterek().get(0).lep();
		XMLHelper.setOutPutFileContent("</karakterLep>");
	}

	public Mezo[][] getMap() {
		return map;
	}

	public void setMap(Mezo[][] map) {
		this.map = map;
	}

	public List<List<Mezo>> getUtvonalak() {
		return utvonalak;
	}

	public void setUtvonalak(List<List<Mezo>> utvonalak) {
		this.utvonalak = utvonalak;
	}

}
