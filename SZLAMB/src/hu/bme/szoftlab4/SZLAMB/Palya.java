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
import hu.bme.szoftlab4.SZLAMB.View.GyuruSzovetsegePaintable;
import hu.bme.szoftlab4.SZLAMB.View.MezoPaintable;
import hu.bme.szoftlab4.SZLAMB.View.View;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * A játék teret reprezentáló osztály, ő felel a {@link GyuruSzovetsege},
 * {@link Mezo} illetve {@link Epitmeny} objektumok létrehozásáért és
 * nyilvántartásáért.
 * 
 * @author Erhard Pfisztner
 * 
 */
public class Palya extends JFrame implements MouseListener {

	private boolean firstRun = true;

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
	private static List<GyuruSzovetsege> karakterek;

	private static View view;

	private static String className;

	private JPanel gameStatePanel;

	private JLabel szarumanVarazsEroLabel;

	private static JProgressBar szarumanVarazsEroProgress;

	private JLabel ellenfelekSzamaLabel;

	private static JProgressBar ellenfelekSzamaProgress;

	private JButton toronyEpitButton;

	private JButton akadalyEpitButton;

	private JButton szunetButton;

	private Szaruman szaruman;

	private static Timer timer;

	private int indulIndex;

	private boolean vanKod = false;

	public Palya(Szaruman szaruman, Mezo[][] mezok, List<List<Mezo>> utvonalak) {
		indulIndex = 0;
		karakterek = new ArrayList<GyuruSzovetsege>();
		className = this.getClass().getName();
		ellensegeSzama = karakterek.size();
		this.szaruman = szaruman;
		initUI();
		setMezok(mezok);
		this.utvonalak = utvonalak;
		palyaEpites(mezok, utvonalak);
		createPrototypes();
		//start();
	}

	private void initUI() {

		getContentPane().setLayout(new BorderLayout());
		this.view = new View(this);
		this.view.setPreferredSize(new Dimension(600, 600));
		getContentPane().add(this.view, BorderLayout.CENTER);
		this.gameStatePanel = new JPanel();
		this.gameStatePanel.setPreferredSize(new Dimension(200, 600));

		// Szauron információs panele
		this.szarumanVarazsEroLabel = new JLabel("Szauron varázsereje:");
		this.szarumanVarazsEroProgress = new JProgressBar(0, 100);
		this.szarumanVarazsEroProgress.setValue(szaruman.getVarazsEro());
		this.szarumanVarazsEroProgress.setStringPainted(true);
		this.gameStatePanel.add(szarumanVarazsEroLabel);
		this.gameStatePanel.add(szarumanVarazsEroProgress);

		// ellenfelek információs panele
		this.ellenfelekSzamaLabel = new JLabel("Ellenségek száma:");
		this.ellenfelekSzamaProgress = new JProgressBar(0, 60);
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
		this.szunetButton = new JButton("Indítás");
		this.szunetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (timer.isRunning()) {
					timer.stop();
                                        szunetButton.setText("Indítás");
				} else {
                                        szunetButton.setText("Szünet");
					timer.start();
				}
			}
		});
		this.gameStatePanel.add(toronyEpitButton);
		this.gameStatePanel.add(akadalyEpitButton);
		this.gameStatePanel.add(szunetButton);

		getContentPane().add(gameStatePanel, BorderLayout.EAST);
		setSize(780, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setSzarumanProgress(int varazsEro) {
		this.szarumanVarazsEroProgress.setValue(varazsEro);
	}
        
        private void restart(){
                indulIndex = 0;
		karakterek = new ArrayList<GyuruSzovetsege>();
		className = this.getClass().getName();
		ellensegeSzama = karakterek.size();
		initUI();
		setMezok(mezok);
		this.utvonalak = utvonalak;
		palyaEpites(mezok, utvonalak);
		createPrototypes();
        }

	/**
	 * Játék indítása, {@link GyuruSzovetsege} karakterek elindítása az
	 * útvonalon
	 */
	public void start() {
                restart();
		setVisible(true);
		setAlwaysOnTop(true);
		kodRandom();
		timer = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				szarumanVarazsEroProgress.setValue(Szaruman.varazsEro);
				Random r = new Random(System.currentTimeMillis());
				
				if (JatekMotor.isJatekVege()) {
					stop();
					String message =  (JatekMotor.win)? "Gratulálunk nyertél :)" : " Sajnáljuk vesztettél! :(";
					JOptionPane.showMessageDialog(getContentPane(), "A játéknak vége! "+message);
					stop();
                                        JatekMotor.menu = true;
                                        setVisible(false);
				}
				int y = r.nextInt(karakterek.size());
				if (karakterek.size() > y) {
					if (!karakterek.get(y).isMegy()) {
						karakterek.get(y).indul();
						indulIndex++;
					}
				}
				for (int x = 0; x < karakterek.size(); x++) {
					if (karakterek.get(x).isMegy()) {
						karakterek.get(x).lep();
					}
				}
				firstRun = false;
				
			}
		});
		timer.setRepeats(true);
	}

	private static void stop() {
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
	public static void ellensegCsokkent(GyuruSzovetsege gyuruSzovetsege) {
		karakterek.remove(gyuruSzovetsege);
		gyuruSzovetsege.setMegy(false);
		Szaruman.incVarazsEro(5);
		ellenfelekSzamaProgress.setValue(karakterek.size());
		ellenfelekSzamaProgress.setString(karakterek.size()+" db");
		if (karakterek.size() < 1) {
			
			JatekMotor.jatekVegeNyert();
			
		}
	}

	/**
	 * Pálya felépítése a paraméterben kapott file alapján: UresMezo | Ut |
	 * VegzetHegye
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
				mezok[x][y].setX(x * 60);
				mezok[x][y].setY(y * 60);
				view.addNewPaintable(new MezoPaintable(mezok[x][y].getType(),
						mezok[x][y]));
			}
		}
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < 60; i++) {

			GyuruSzovetsege karakter = null;
			if (r.nextInt(4) == 3) {
				karakter = new Ember(utvonalak);
			} else if (r.nextInt(4) == 3) {
				karakter = new Torp(utvonalak);
			} else if (r.nextInt(4) == 3) {
				karakter = new Hobbit(utvonalak);
			} else {
				karakter = new Tunde(utvonalak);
			}

			this.view.addNewPaintable(new GyuruSzovetsegePaintable(karakter
					.getType(), karakter));
			karakterek.add(karakter);
		}
		Collections.shuffle(karakterek, r);
		ellenfelekSzamaProgress.setValue(karakterek.size());
		ellenfelekSzamaProgress.setString(karakterek.size()+" db");
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
		Timer t = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Random r = new Random(System.currentTimeMillis());
				int num = r.nextInt(10);
				if (num % 10 == 0) {
					vanKod = true;
				} else {
					vanKod = false;
				}
				for (int x = 0; x < mezok.length; x++) {
					for (int y = 0; y < mezok[x].length; y++) {
						if (r.nextInt(mezok.length) % 13 == 0)
							mezok[x][y].setKod(vanKod);
					}
				}
			}
		});
		t.setRepeats(true);
		t.start();
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
		if (Szaruman.varazsEro > 0) {
			if (JatekMotor.gameInteractionState.equals(ViewType.AKADALY)  && Szaruman.varazsEro > 7) {
				Akadaly akadaly = null;
				akadaly = new Akadaly();
				boolean success = view.mouseClicked(e, akadaly);
				if (!success) {
					JOptionPane.showMessageDialog(this,
							"Ide nem építhetsz akadalyt");
				} else {
					szaruman.decVarazsEro(8);
					for (int x = 0; x < getMezok().length; x++) {
						for (int y = 0; y < getMezok()[x].length; y++) {
							if (akadaly.getX() == getMezok()[x][y].getX()
									&& akadaly.getY() == getMezok()[x][y].getY()) {
								getMezok()[x][y].epitmenyRegiszter(akadaly);
								System.out.println("Akadaly: x = " + (x + 1)
										+ "  y = " + (y + 1));
							}
						}
					}
				}
			} else if (JatekMotor.gameInteractionState.equals(ViewType.TORONY)  && Szaruman.varazsEro > 9) {
				Torony torony = null;
				torony = new Torony(1);
				boolean success = view.mouseClicked(e, torony);
				if (!success) {
					JOptionPane
							.showMessageDialog(this, "Ide nem építhetsz tornyot");
				} else {
					szaruman.decVarazsEro(10);
					for (int x = 0; x < getMezok().length; x++) {
						for (int y = 0; y < getMezok()[x].length; y++) {
							if (torony.getX() == getMezok()[x][y].getX()
									&& torony.getY() == getMezok()[x][y].getY()) {
								getMezok()[x][y].epitmenyRegiszter(torony);
								System.out.println("Torony: x = " + (x + 1)
										+ "  y = " + (y + 1));
							}
						}
					}
				}
			} else if (JatekMotor.gameInteractionState.equals(ViewType.NONE) && Szaruman.varazsEro > 24) {
				Epitmeny epitmeny = view.getEpitmeny(e);
				if (epitmeny != null) {
					szaruman.decVarazsEro(25);
					VarazsKo[] varazsKovek = (VarazsKo[]) epitmeny.getValidKovek();
					VarazsKo varazsKo = (VarazsKo) JOptionPane.showInputDialog(this,
							"Milyen varázskövet akarsz rárakni?", "Varázskő választás",
							JOptionPane.QUESTION_MESSAGE, null, varazsKovek,
							varazsKovek[0]);
					epitmeny.felruhaz(varazsKo);
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Nincs elég varázs erőd!");
		}
		repaint();
		view.repaint();
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

	public static void setMezok(Mezo[][] mezok) {
		Palya.mezok = mezok;
	}

	public static void addEllenseg(GyuruSzovetsege karakter) {
		karakterek.add(karakter);
		View.addNewPaintable(new GyuruSzovetsegePaintable(karakter.getType(),
				karakter));
	}
}
