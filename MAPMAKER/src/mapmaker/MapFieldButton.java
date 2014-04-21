/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapmaker;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Erhard Pfisztner
 */
public class MapFieldButton extends JButton{
    private FieldTypes fieldType;

    public MapFieldButton(FieldTypes fieldType) {
        super(fieldType.name());
        this.setFieldType(fieldType);
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        if (b && this.fieldType.equals(FieldTypes.URESMEZO)) {
            this.setBackground(Color.CYAN);
        } else if(!b && this.fieldType.equals(FieldTypes.URESMEZO)){
            this.setBackground(Color.lightGray);
        }
    }

    public FieldTypes getFieldType() {
        return fieldType;
    }

    public final void setFieldType(FieldTypes fieldType) {
        this.fieldType = fieldType;
        super.setText(this.fieldType.name());
        if (this.fieldType.equals(FieldTypes.BELEPO)) {
            this.setBackground(Color.green);
        } else if (this.fieldType.equals(FieldTypes.UT)) {
            this.setBackground(Color.yellow);
        } else if (this.fieldType.equals(FieldTypes.VEGZETHEGYE)) {
            this.setBackground(Color.red);
        } else if (this.fieldType.equals(FieldTypes.URESMEZO)) {
            this.setBackground(Color.lightGray);
        } else if (this.fieldType.equals(FieldTypes.KESZUT)) {
            this.setBackground(Color.WHITE);
        }
    }
}
