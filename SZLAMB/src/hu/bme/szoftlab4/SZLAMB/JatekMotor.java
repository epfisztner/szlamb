package hu.bme.szoftlab4.SZLAMB;

import hu.bme.szoftlab4.SZLAMB.Mezo.Mezo;
import hu.bme.szoftlab4.SZLAMB.View.ViewType;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Ez az osztály lesz a játék indításáért illetve befejezéséért felelős, itt
 * van referencia a játékost reprezentáló {@link Szaruman} -ra is.
 * 
 * @author Erhard Pfisztner
 *
 */
public class JatekMotor extends JFrame{
	
	static String className;
	/**
	 * Játékost reprezentáló objektum.
	 */
	public Szaruman szaruman;
	private static boolean jatekVege = false;
	public static ViewType gameInteractionState = ViewType.NONE;
	protected JPanel menuPanel;
	protected JPanel palyaPanel;
	private JButton startGameButton;
	private JButton exitButton;
	public static boolean win =false;
        public static boolean menu = true;
	
	public JatekMotor(Mezo[][]mezo, List<List<Mezo>>utvonalak) {		
		szaruman = new Szaruman(mezo, utvonalak);
		this.setSize(400, 400);
		initMenuUI();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
                Timer timer;
                timer = new Timer(100,new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (menu){
                            jatekVege = false;
                            setVisible(true);
                        } else {
                            setVisible(false);
                        }
                    }
                });
                timer.start();
	}
	
	private void initMenuUI(){
		this.menuPanel = new JPanel();
		this.menuPanel.setLayout(new GridLayout(3, 3,5,10));
		startGameButton = new JButton("Játék indítása");
		startGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				szaruman.start();
				menu = false;
			}
		});
		exitButton = new JButton("Kilépés");
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.menuPanel.add(new JPanel());
		this.menuPanel.add(new JLabel("A Két Torony"));
		this.menuPanel.add(new JPanel());
		this.menuPanel.add(new JPanel());
		this.menuPanel.add(startGameButton);
		this.menuPanel.add(new JPanel());
		this.menuPanel.add(new JPanel());
		this.menuPanel.add(exitButton);
		this.menuPanel.add(new JPanel());
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(this.menuPanel, BorderLayout.CENTER);
		this.getContentPane().add(new JPanel(), BorderLayout.NORTH);
		this.getContentPane().add(new JPanel(), BorderLayout.SOUTH);
		this.getContentPane().add(new JPanel(), BorderLayout.WEST);
		this.getContentPane().add(new JPanel(), BorderLayout.EAST);
		
		
	}


	/**
	 * új játék indítása, amennyiben a játék már egyszer végetért.
	 */
	public void ujJatek(){
		//System.out.println("\t-->"+className+".ujJatek");
		szaruman.start();
		//System.out.println("\t<--void");
	}
	/**
	 * Játék vége a játékos vereségével.
	 */
	public static void jatekVegeVeszit(){
		win = false;
		setJatekVege(true);
		
		System.out.println("Vesztes");
	}
	/**
	 * Játék vége a játékos győzelmével.
	 */
	public static void jatekVegeNyert(){
		//System.out.println("\t\t\t\t\t\t-->"+className+".jatekVegeNyert()");
		//System.out.println("\t\t\t\t\t\t<--void");
		win = true;
		setJatekVege(true);
	}
	/**
	 * Játék indítása először
	 */
	public void start(){	
		//System.out.println("-->"+className+".start()");
		szaruman.start();
		//System.out.println("<--void");
	}

	public static boolean isJatekVege() {
		return jatekVege;
	}

	public static void setJatekVege(boolean jatekVege) {
		JatekMotor.jatekVege = jatekVege;
	}

	public Boolean getWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}
}
