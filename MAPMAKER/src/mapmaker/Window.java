package mapmaker;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Erhard Pfisztner
 */
public class Window extends JFrame {

    protected List<List<MapFieldButton>> utvonalak;
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
    protected JButton okButton;
    protected JButton cancelButton;
    protected MapFieldButton[][] mapFields;
    protected JPanel mainPanel;
    protected int xSize;
    protected int ySize;

    public Window() throws HeadlessException {
        super("Map maker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        //setMaximumSize(new Dimension(800, 800));
        //setMinimumSize(new Dimension(600, 600));
        setResizable(true);
        init();
    }

    private void init() {
        utvonalak = new ArrayList<List<MapFieldButton>>();
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
        newUtvonalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setAllFieldActionListener(FieldTypes.BELEPO);
                setFieldsEnabled(FieldTypes.URESMEZO, true);
                setFieldsEnabled(FieldTypes.BELEPO, true);
                setFieldsEnabled(FieldTypes.KESZUT, true);
                setFieldsEnabled(FieldTypes.VEGZETHEGYE, false);
                setFieldsEnabled(FieldTypes.UT, false);
                newUtvonalButton.setEnabled(false);
                okButton.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        okButton.setEnabled(false);
                        setAllFieldActionListener(FieldTypes.UT);
                        setFieldsEnabled(FieldTypes.URESMEZO, true);
                        setFieldsEnabled(FieldTypes.BELEPO, false);
                        setFieldsEnabled(FieldTypes.VEGZETHEGYE, false);
                        setFieldsEnabled(FieldTypes.UT, false);
                    }
                });
            }
        });
        newUtvonalButton.setEnabled(false);
        newVegzetHegyeButton = new JButton("Végzet Hegye lerakása");
        newVegzetHegyeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setAllFieldActionListener(FieldTypes.VEGZETHEGYE);
                setFieldsEnabled(FieldTypes.URESMEZO, true);
                setFieldsEnabled(FieldTypes.BELEPO, false);
                setFieldsEnabled(FieldTypes.VEGZETHEGYE, false);
                setFieldsEnabled(FieldTypes.UT, false);
            }
        });
        okButton = new JButton("Oké");
        okButton.setEnabled(false);
        cancelButton = new JButton("Mégse");
        newVegzetHegyeButton.setEnabled(false);
        inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.add(label);
        inputPanel.add(mapSizeXInput);
        inputPanel.add(mapSizeYInput);
        inputPanel.add(setButton);
        inputPanel.add(newVegzetHegyeButton);
        inputPanel.add(newUtvonalButton);
        inputPanel.add(okButton);
        inputPanel.add(cancelButton);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mapPanel = new JPanel(new GridLayout(4, 4));
        mainPanel.add(mapPanel, BorderLayout.CENTER);
        exportButton = new JButton("Térkép exportálása");
        exportButton.setEnabled(false);
        exportButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        generateUtvonalak();
                        XmlGenerator.setFields(mapFields);
                        XmlGenerator.setUtvonalak(utvonalak);
                        XmlGenerator.makeXml();
                    }
                });

            }

        });
        mainPanel.add(exportButton, BorderLayout.SOUTH);
        getContentPane().add(mainPanel);
    }

    protected void setFieldsEnabled(FieldTypes fieldTypes, boolean enabled) {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (mapFields[x][y].getFieldType().equals(fieldTypes)) {
                    mapFields[x][y].setEnabled(enabled);
                }
            }
        }
    }

    protected void setAllFieldEnabled(boolean enabled) {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                mapFields[x][y].setEnabled(enabled);
            }
        }
    }

    protected void setAllFieldActionListener(FieldTypes fieldTypes) {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (mapFields[x][y].getActionListeners().length != 0) {
                    mapFields[x][y].removeActionListener(mapFields[x][y].getActionListeners()[0]);
                }
                mapFields[x][y].addActionListener(new MapFieldAction(mapFields[x][y], fieldTypes));
            }
        }
    }

    protected void setMap() {
        mapPanel.removeAll();
        mapPanel.setLayout(new GridLayout(ySize, xSize));
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

            if (fieldType.equals(FieldTypes.VEGZETHEGYE)) {
                setFieldsEnabled(FieldTypes.URESMEZO, true);
                setFieldsEnabled(FieldTypes.BELEPO, false);

                setFieldsEnabled(FieldTypes.UT, false);
                newVegzetHegyeButton.setEnabled(false);
                newUtvonalButton.setEnabled(true);
                for (int x = 0; x < xSize; x++) {
                    for (int y = 0; y < ySize; y++) {
                        if (mapFields[x][y].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                            mapFields[x][y].setFieldType(FieldTypes.URESMEZO);
                            mapFields[x][y].setEnabled(true);
                        }
                    }
                }
                selectedButton.setFieldType(this.fieldType);
                selectedButton.setText(this.fieldType.name());
                setFieldsEnabled(FieldTypes.VEGZETHEGYE, false);
            } else if (fieldType.equals(FieldTypes.BELEPO)) {
                setFieldsEnabled(FieldTypes.URESMEZO, true);
                setFieldsEnabled(FieldTypes.BELEPO, false);
                setFieldsEnabled(FieldTypes.VEGZETHEGYE, false);
                setFieldsEnabled(FieldTypes.UT, false);
                okButton.setEnabled(true);
                newVegzetHegyeButton.setEnabled(false);
                newUtvonalButton.setEnabled(false);
                for (int x = 0; x < xSize; x++) {
                    for (int y = 0; y < ySize; y++) {
                        if (mapFields[x][y].getFieldType().equals(FieldTypes.BELEPO)) {
                            mapFields[x][y].setFieldType(FieldTypes.URESMEZO);
                            mapFields[x][y].setEnabled(true);
                        }
                    }
                }

                selectedButton.setFieldType(this.fieldType);
                setFieldsEnabled(FieldTypes.BELEPO, false);
                selectedButton.setText(this.fieldType.name());
            } else if (fieldType.equals(FieldTypes.UT)) {
                setFieldsEnabled(FieldTypes.URESMEZO, false);
                setFieldsEnabled(FieldTypes.BELEPO, false);
                setFieldsEnabled(FieldTypes.VEGZETHEGYE, false);
                setFieldsEnabled(FieldTypes.UT, false);
                newVegzetHegyeButton.setEnabled(false);
                newUtvonalButton.setEnabled(false);
                this.selectedButton.setFieldType(this.fieldType);
                this.selectedButton.setText(this.fieldType.name());
                showClickAbleNeighbours(this.selectedButton);
                setFieldsEnabled(FieldTypes.UT, false);
            }
        }
    }

    private void showClickAbleNeighbours(JButton selectedButton) {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (mapFields[x][y].equals(selectedButton)) {
                    System.out.println("x: " + x + " y: " + y);
                    if (x > 0 && x < xSize - 1 && y > 0 && y < ySize - 1) {
                        if (mapFields[x - 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x - 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                        if (mapFields[x + 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x + 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                        if (mapFields[x][y + 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y + 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y + 1)) {
                            return;
                        }
                        if (mapFields[x][y - 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y - 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y - 1)) {
                            return;
                        }
                    } else if (x == 0 && y > 0 && y < ySize - 1) {
                        if (mapFields[x][y + 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y + 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y + 1)) {
                            return;
                        }
                        if (mapFields[x + 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x + 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                        if (mapFields[x][y - 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y - 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y - 1)) {
                            return;
                        }
                    } else if (x == 0 && y == 0) {
                        if (mapFields[x][y + 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y + 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y + 1)) {
                            return;
                        }
                        if (mapFields[x + 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x + 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                    } else if (x == 0 && y == ySize - 1) {
                        if (mapFields[x][y - 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y - 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y - 1)) {
                            return;
                        }
                        if (mapFields[x + 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x + 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                    } else if (x == xSize - 1 && y == 0) {
                        if (mapFields[x][y + 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y + 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y + 1)) {
                            return;
                        }
                        if (mapFields[x - 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x - 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x - 1, y)) {
                            return;
                        }
                    } else if (x == xSize - 1 && y == ySize - 1) {
                        if (mapFields[x][y - 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y - 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y - 1)) {
                            return;
                        }
                        if (mapFields[x - 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x - 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x - 1, y)) {
                            return;
                        }
                    } else if (x == xSize - 1 && y > 0 && y < ySize - 1) {
                        if (mapFields[x][y - 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y - 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y - 1)) {
                            return;
                        }
                        if (mapFields[x - 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x - 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x - 1, y)) {
                            return;
                        }
                        if (mapFields[x][y + 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y + 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y + 1)) {
                            return;
                        }
                    } else if (x > 0 && x < xSize - 1 && y == ySize - 1) {
                        if (mapFields[x][y - 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y - 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y - 1)) {
                            return;
                        }
                        if (mapFields[x + 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x + 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                        if (mapFields[x - 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x - 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x - 1, y)) {
                            return;
                        }
                    } else if (x > 0 && x < xSize - 1 && y == 0) {
                        if (mapFields[x][y + 1].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x][y + 1].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x, y + 1)) {
                            return;
                        }
                        if (mapFields[x + 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x + 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x + 1, y)) {
                            return;
                        }
                        if (mapFields[x - 1][y].getFieldType().equals(FieldTypes.URESMEZO)) {
                            mapFields[x - 1][y].setEnabled(true);
                        }
                        if (checkIfMapIsValid(x - 1, y)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    protected boolean checkIfMapIsValid(int x, int y) {
        if (mapFields[x][y].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
            setAllFieldEnabled(false);
            newUtvonalButton.setEnabled(true);
            okButton.setEnabled(false);
            cancelButton.setEnabled(false);
            exportButton.setEnabled(true);
            pinAllRoad();
            return true;
        }
        return false;
    }

    protected void pinAllRoad() {
        for (int x = 0; x < xSize; x++) {
            for (int y = 0; y < ySize; y++) {
                if (mapFields[x][y].getFieldType().equals(FieldTypes.UT)) {
                    mapFields[x][y].setFieldType(FieldTypes.KESZUT);
                }
            }
        }
    }

    private void generateUtvonalak() {
        int belepoCount = 0;
        utvonalak.add(new ArrayList<MapFieldButton>());
        
        for (int x = 0; x < mapFields.length; x++) {
            for (int y = 0; y < mapFields[x].length; y++) {
                if (mapFields[x][y].getFieldType().equals(FieldTypes.BELEPO)) {
                    mapFields[x][y].setFieldType(FieldTypes.UT);
                    utvonalak.get(0).add(mapFields[x][y]);
                    findWay(0, x, y);
                    System.out.println(utvonalak.get(0).size());
                    return;
                }
            }
        }

    }

    private boolean findWay(int utvonalIndex, int actualXCoord, int actualYCoord) {
        for (int x = 0; x < mapFields.length; x++) {
            for (int y = 0; y < mapFields[x].length; y++) {
                if (mapFields[x][y].getFieldType().equals(FieldTypes.KESZUT)) {
                    mapFields[x][y].setFieldType(FieldTypes.UT);
                }
            }
        }
        ciklus:
        while (actualXCoord < xSize && actualYCoord < ySize && actualXCoord >= 0 && actualYCoord >= 0) {
            System.out.println("export X: "+actualXCoord+"  export Y:"+actualYCoord);
            /*
             * *********
             * *EZT ITT*
             * *EZT ITT*
             * *********
             */
            if (actualXCoord > 0 && actualXCoord < xSize - 1 && actualYCoord > 0 && actualYCoord < ySize - 1) {
                if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord - 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    actualXCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    return true;
                }

                if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord + 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    actualXCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    return true;
                }
                if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord + 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    actualYCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    return true;
                }
                if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord - 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    actualYCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    return true;
                }
            } else if (actualXCoord == 0 && actualYCoord > 0 && actualYCoord < ySize - 1) {
                if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord + 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    actualYCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    return true;
                }
                if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord + 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    actualXCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    return true;
                }
                if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord - 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    actualYCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    return true;
                }
            } else if (actualXCoord == 0 && actualYCoord == 0) {
                if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord + 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    actualYCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    return true;
                }
                if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord + 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    actualXCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    return true;
                }
            } else if (actualXCoord == 0 && actualYCoord == ySize - 1) {
                if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord - 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    actualYCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    return true;
                }
                if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord + 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    actualXCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    return true;
                }
            } else if (actualXCoord == xSize - 1 && actualYCoord == 0) {
                if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord + 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    actualYCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    return true;
                }
                if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord - 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    actualXCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    return true;
                }
            } else if (actualXCoord == xSize - 1 && actualYCoord == ySize - 1) {
                if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord - 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    actualYCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    return true;
                }
                if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord - 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    actualXCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    return true;
                }
            } else if (actualXCoord == xSize - 1 && actualYCoord > 0 && actualYCoord < ySize - 1) {
                if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord - 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    actualYCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    return true;
                }
                if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord - 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    actualXCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    return true;
                }
                if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord + 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    actualYCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    return true;
                }
            } else if (actualXCoord > 0 && actualXCoord < xSize - 1 && actualYCoord == ySize - 1) {
                if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord - 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    actualYCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord - 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord - 1]);
                    return true;
                }
                if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord + 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    actualXCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    return true;
                }
                if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord - 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    actualXCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    return true;
                }
            } else if (actualXCoord > 0 && actualXCoord < xSize - 1 && actualYCoord == 0) {
                if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord][actualYCoord + 1])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    actualYCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord][actualYCoord + 1].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord][actualYCoord + 1]);
                    return true;
                }
                if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord + 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    actualXCoord++;
                    continue ciklus;
                } else if (mapFields[actualXCoord + 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord + 1][actualYCoord]);
                    return true;
                }
                if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.UT) && !utvonalak.get(utvonalIndex).contains(mapFields[actualXCoord - 1][actualYCoord])) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    actualXCoord--;
                    continue ciklus;
                } else if (mapFields[actualXCoord - 1][actualYCoord].getFieldType().equals(FieldTypes.VEGZETHEGYE)) {
                    utvonalak.get(utvonalIndex).add(mapFields[actualXCoord - 1][actualYCoord]);
                    return true;
                }
            }

        }
        return false;
    }
}
