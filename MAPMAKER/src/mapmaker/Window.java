package mapmaker;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Erhard Pfisztner
 */
public class Window extends JFrame {

    
    protected JLabel label;
    protected Integer[] items;
    protected JComboBox<Integer> mapSizeXInput;
    protected JComboBox<Integer> mapSizeYInput;
    protected JPanel inputPanel;
    protected JPanel mapPanel;
    protected JButton setButton;
    protected JButton exportButton;
    protected JButton newVegzetHegyeButton;
    protected JButton newUtvonalButton;
    protected MapFieldButton[][] mapFields;
    protected JPanel mainPanel;
    protected int xSize;
    protected int ySize;

    public Window() throws HeadlessException {
        super("Map maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        //setMaximumSize(new Dimension(800, 800));
        //setMinimumSize(new Dimension(600, 600));
        setResizable(false);
        init();
    }

    private void init() {
        items = new Integer[11];
        for (int i = 0; i < 11; i++) {
            items[i] = i + 4;
        }
        xSize = 10;
        ySize = 10;
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.add(new JPanel(), BorderLayout.EAST);
        mainPanel.add(new JPanel(), BorderLayout.WEST);
        mainPanel.add(new JPanel(), BorderLayout.SOUTH);
        setButton = new JButton("Pálya méret beállítása");
        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xSize = (int) mapSizeXInput.getSelectedItem();
                ySize = (int) mapSizeYInput.getSelectedItem();
                System.out.println("x: " + xSize + "y: " + ySize);
                setMap();
            }
        });
        label = new JLabel("Add meg a pálya méretét (X,Y): ");
        mapSizeXInput = new JComboBox<Integer>(items);
        mapSizeXInput.setSize(40, 1);
        mapSizeXInput.addKeyListener(null);
        mapSizeYInput = new JComboBox<Integer>(items);
        mapSizeYInput.setSize(40, 1);
        newUtvonalButton = new JButton("Új útvonal");
        newUtvonalButton.setEnabled(false);
        newVegzetHegyeButton = new JButton("Végzet Hegye lerakása");
        newVegzetHegyeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setAllFieldEnabled(true);
                setAllFieldActionListener(new MapFieldAction(null, FieldTypes.UT));
            }
        });
        newVegzetHegyeButton.setEnabled(false);
        inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.add(label);
        inputPanel.add(mapSizeXInput);
        inputPanel.add(mapSizeYInput);
        inputPanel.add(setButton);
        inputPanel.add(newVegzetHegyeButton);
        inputPanel.add(newUtvonalButton);
        inputPanel.add(new JPanel());
        inputPanel.add(new JPanel());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mapPanel = new JPanel(new GridLayout(4, 4));
        mainPanel.add(mapPanel, BorderLayout.CENTER);
        exportButton = new JButton("Térkép exportálása");
        exportButton.setEnabled(false);
        mainPanel.add(exportButton, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);
    }
    
    protected void setAllFieldEnabled(boolean enabled) {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                mapFields[x][y].setEnabled(enabled);
            }
        }
    }
    
    protected void setAllFieldActionListener(MapFieldAction mapFieldAction) {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                mapFields[x][y].addActionListener(mapFieldAction);
            }
        }
    }

    protected void setMap() {
        mapPanel.removeAll();
        mapPanel.setLayout(new GridLayout(xSize, ySize));
        mapFields = new MapFieldButton[xSize][ySize];
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                MapFieldButton button = new MapFieldButton(FieldTypes.URESMEZO);
                button.setEnabled(false);
                mapFields[x][y] = button;
                mapPanel.add(button);
            }
        }
        newVegzetHegyeButton.setEnabled(true);
        this.invalidate();
        this.repaint();
        mapPanel.paintAll(mapPanel.getGraphics());
    }
    
    class MapFieldAction implements ActionListener {

        private MapFieldButton selectedButton;
        private FieldTypes fieldType;

        public MapFieldAction(MapFieldButton selectedButton, FieldTypes fieldType) {
            this.selectedButton = selectedButton;
            this.fieldType = fieldType;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedButton.setFieldType(this.fieldType);
        }
        
    }
}
