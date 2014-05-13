package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Epitmeny.Akadaly;
import hu.bme.szoftlab4.SZLAMB.Epitmeny.Epitmeny;
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
import hu.bme.szoftlab4.SZLAMB.View.EpitmenyPaintable;
import hu.bme.szoftlab4.SZLAMB.View.GyuruSzovetsegePaintable;
import hu.bme.szoftlab4.SZLAMB.View.MezoPaintable;
import hu.bme.szoftlab4.SZLAMB.View.View;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;
import hu.bme.szoftlab4.SZLAMB.XMLHelper.XMLHelper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.Border;

import sun.net.www.content.text.plain;

/**
 * A játék teret reprezentáló osztály, ő felel a {@link GyuruSzovetsege},
 * {@link Mezo} illetve {@link Epitmeny} objektumok létrehozásáért és
 * nyilvántartásáért.
 * 
 * @author Erhard Pfisztner
 * 
 */
public class Palya extends JFrame implements MouseListener {
	/**
	 * Játék mezői (maga a pálya)
	 */
	private static Mezo[][] mezok;

	/**
	 * Még hátra levő ellenségek száma.
	 */
	protected static int ellensegeSzama;

	/**
	 * {@link Epitmeny} prototipusok
	 */
	protected List<Epitmeny> prototipusokEpitmeny;

	/**
	 * {@link GyuruSzovetsege} prototipusok
	 */
	protected List<GyuruSzovetsege> prototipusokGyuru;

	/**
	 * szerkesztve a pálya útvonalainak listályát tárolja lista a listában
	 * jelleggel.
	 */
	protected List<List<Mezo>> utvonalak;

	/**
	 * szerkesztve a játékban még életben lévő karakterek listája
	 */
	private List<GyuruSzovetsege> karakterek;

	private static View view;

	private static String className;

	private JPanel gameStatePanel;

	private JLabel szarumanVarazsEroLabel;

	private JProgressBar szarumanVarazsEroProgress;

	private JLabel ellenfelekSzamaLabel;

	private JProgressBar ellenfelekSzamaProgress;

	private JButton toronyEpitButton;

	private JButton akadalyEpitButton;

	private JButton szunetButton;

	private Szaruman szaruman;

	private Timer timer;

	public Palya(Szaruman szaruman, Mezo[][] mezok, List<List<Mezo>> utvonalak) {
		// System.out.println("\t\t-->"+this.getClass().getName()+".constructor()");
		karakterek = new ArrayList<GyuruSzovetsege>();
		className = this.getClass().getName();
		// this.mezok = mezok;
		ellensegeSzama = karakterek.size();
		this.szaruman = szaruman;
		// palyaEpites(new File(""));
		// createPrototypes();
		// System.out.println("\t\t<--");
		initUI();
		this.mezok = mezok;
		this.utvonalak = utvonalak;
		// this.view.addNewPaintable(new MezoPaintable(ViewType.UT, new
		// Ut(10,10)));
		palyaEpites(mezok, utvonalak);
		createPrototypes();
		start();
	}

	private void initUI() {
		getContentPane().setLayout(new BorderLayout());
		this.view = new View(this);
		this.view.setPreferredSize(new Dimension(500, 500));
		getContentPane().add(this.view, BorderLayout.CENTER);
		this.gameStatePanel = new JPanel();
		this.gameStatePanel.setPreferredSize(new Dimension(200, 500));

		// Szauron információs panele
		this.szarumanVarazsEroLabel = new JLabel("Szauron varázsereje:");
		this.szarumanVarazsEroProgress = new JProgressBar(0, 100);
		this.szarumanVarazsEroProgress.setValue(szaruman.getVarazsEro());
		this.szarumanVarazsEroProgress.setStringPainted(true);
		this.gameStatePanel.add(szarumanVarazsEroLabel);
		this.gameStatePanel.add(szarumanVarazsEroProgress);

		// ellenfelek információs panele
		this.ellenfelekSzamaLabel = new JLabel("Szauron varázsereje:");
		this.ellenfelekSzamaProgress = new JProgressBar(0, 50);
		this.ellenfelekSzamaProgress.setString(ellensegeSzama + "db");
		this.ellenfelekSzamaProgress.setStringPainted(true);
		this.ellenfelekSzamaProgress.setValue(ellensegeSzama);
		this.gameStatePanel.add(ellenfelekSzamaLabel);
		this.gameStatePanel.add(ellenfelekSzamaProgress);

		// gombok
		this.toronyEpitButton = new JButton("Torony építése");
		this.toronyEpitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JatekMotor.gameInteractionState = ViewType.TORONY;
			}
		});
		this.akadalyEpitButton = new JButton("Akadály építése");
		this.akadalyEpitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JatekMotor.gameInteractionState = ViewType.AKADALY;
			}
		});
		this.szunetButton = new JButton("Szünet");
		this.szunetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (timer.isRunning()){
					timer.stop();
				} else {
					timer.start();
				}
			}
		});
		this.gameStatePanel.add(toronyEpitButton);
		this.gameStatePanel.add(akadalyEpitButton);
		this.gameStatePanel.add(szunetButton);

		getContentPane().add(gameStatePanel, BorderLayout.EAST);
		setSize(680, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setVisible(true);
	}

	public void setSzarumanProgress(int varazsEro) {
		this.szarumanVarazsEroProgress.setValue(varazsEro);
		// this.szarumanVarazsEroProgress.setString(varazsEro+"%");
	}

	/**
	 * Játék indítása, {@link GyuruSzovetsege} karakterek elindítása az
	 * útvonalon
	 */
	public void start() {
		setVisible(true);
		setAlwaysOnTop(true);
		timer = new Timer(24, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (GyuruSzovetsege gyuruSzovetsege : karakterek) {
					gyuruSzovetsege.lep();
				}
				//if (JatekMotor.isJatekVege()) {
					//stop();
				//}
			}
		});
		timer.setRepeats(true);
/*		
		for (GyuruSzovetsege gyuruSzovetsege : prototipusokGyuru) {
			gyuruSzovetsege.indul();
		}*/
	}
	
	private void stop (){
		timer.stop();
	}

	/**
	 * 
	 * @return
	 */
	public List<GyuruSzovetsege> getPrototipusokGyuru() {
		return prototipusokGyuru;
	}

	/**
	 * 
	 * @return
	 */
	public List<Epitmeny> getPrototipusokEpitmeny() {
		return prototipusokEpitmeny;
	}

	/**
	 * Amennyiben elpusztul egy ellenség ez a metódus hívódik meg az ellenség
	 * számának csökkentéséért illetve 0 értékének vizsgálatára.
	 */
	public static void ellensegCsokkent() {
		ellensegeSzama--;
		if (ellensegeSzama < 1) {
			JatekMotor.jatekVegeNyert();
		} else {
		}
	}

	/**
	 * Pálya felépítése a paraméterben kapott file alapján: 0/UresMezo | 1/Ut |
	 * x/VegzetHegye
	 * 
	 * @param file
	 */
	public void palyaEpites(Mezo[][] mezok, List<List<Mezo>> utvonalak) {
		this.utvonalak = utvonalak;
		createPrototypes();
		karakterek = new ArrayList<GyuruSzovetsege>();
		ellensegeSzama = 0;
		for (int x = 0; x < getMezok().length; x++) {
			for (int y = 0; y < getMezok()[x].length; y++) {
				getMezok()[x][y].setSzomszedok(1);
			}
		}
		for (int x = 0; x < mezok.length; x++) {
			for (int y = 0; y < mezok[x].length; y++) {
				mezok[x][y].setX(x * 47);
				mezok[x][y].setY(y * 47);
				view.addNewPaintable(new MezoPaintable(mezok[x][y].getType(),
						mezok[x][y]));
			}
		}
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < 15; i++) {
			
			GyuruSzovetsege karakter = null;
			try {
				karakter = (GyuruSzovetsege) prototipusokGyuru.get(r.nextInt(prototipusokGyuru.size())).clone();
				//karakter.setPositionX(i*47);
				//karakter.setPositionY(i*47);
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.view.addNewPaintable(new GyuruSzovetsegePaintable(karakter.getType(), karakter));
			karakterek.add(karakter);
		}
	}

	/**
	 * Prototípusok létrehozása a játék indításakor.
	 */
	private void createPrototypes() {
		this.prototipusokEpitmeny = new ArrayList<Epitmeny>();
		this.prototipusokGyuru = new ArrayList<GyuruSzovetsege>();
		prototipusokEpitmeny.add(new Torony(1));
		prototipusokEpitmeny.add(new Akadaly());
		prototipusokGyuru.add(new Ember(utvonalak));
		prototipusokGyuru.add(new Hobbit(utvonalak));
		prototipusokGyuru.add(new Torp(utvonalak));
		prototipusokGyuru.add(new Tunde(utvonalak));
	}

	private void kodRandom() {
		boolean vanKod = false;
		Random r = new Random();
		int num = r.nextInt();
		if (num % 11 == 0) {
			vanKod = !vanKod;
		}
		for (int x = 0; x < getMezok().length; x++) {
			for (int y = 0; y < getMezok()[x].length; y++) {
				getMezok()[x][y].setKod(vanKod);
			}
		}
	}

	public List<GyuruSzovetsege> getKarakterek() {
		return karakterek;
	}

	public void setKarakterek(List<GyuruSzovetsege> karakterek) {
		this.karakterek = karakterek;
		ellensegeSzama = this.karakterek.size();
	}

	public static Mezo[][] getMezok() {
		return mezok;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (JatekMotor.gameInteractionState.equals(ViewType.AKADALY)) {
			Akadaly akadaly = null;
			try {
				akadaly = (Akadaly) this.prototipusokEpitmeny.get(1).clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			boolean success = view.mouseClicked(e, akadaly);
			if (!success) {
				JOptionPane.showMessageDialog(this,
						"Ide nem építhetsz akadalyt");
			} else {
				for (int x = 0; x < mezok.length; x++) {
					for (int y = 0; y < mezok[x].length; y++) {
						if (akadaly.getX() == mezok[x][y].getX()
								&& akadaly.getY() == mezok[x][y].getY()) {
							mezok[x][y].epitmenyRegiszter(akadaly);
							System.out.println("Akadaly: x = " + (x + 1)
									+ "  y = " + (y + 1));
						}
					}
				}
			}
		} else if (JatekMotor.gameInteractionState.equals(ViewType.TORONY)) {
			Torony torony = null;
			try {
				torony = (Torony) this.prototipusokEpitmeny.get(0).clone();
			} catch (CloneNotSupportedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			boolean success = view.mouseClicked(e, torony);
			if (!success) {
				JOptionPane
						.showMessageDialog(this, "Ide nem építhetsz tornyot");
			} else {
				for (int x = 0; x < mezok.length; x++) {
					for (int y = 0; y < mezok[x].length; y++) {
						if (torony.getX() == mezok[x][y].getX()
								&& torony.getY() == mezok[x][y].getY()) {
							mezok[x][y].epitmenyRegiszter(torony);
							System.out.println("Torony: x = " + (x + 1)
									+ "  y = " + (y + 1));
						}
					}
				}
			}
		} else if (JatekMotor.gameInteractionState.equals(ViewType.NONE)) {
			VarazsKo varazsKo = (VarazsKo) JOptionPane.showInputDialog(this,
					"Milyen varázskövet akarsz rárakni?", "Varázskő választás",
					JOptionPane.QUESTION_MESSAGE, null, VarazsKo.values(),
					VarazsKo.values()[0]);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
