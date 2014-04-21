/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapmaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Erhard Pfisztner
 */
public class MapFieldButton extends JButton{
    private FieldTypes fieldType;

    public MapFieldButton(FieldTypes fieldType) {
        super(fieldType.name());
        this.fieldType = fieldType;
    }

    public FieldTypes getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldTypes fieldType) {
        this.fieldType = fieldType;
        super.setText(this.fieldType.name());
        if (this.fieldType.equals(FieldTypes.BELEPO)) {
            this.setBackground(Color.green);
        } else if (this.fieldType.equals(FieldTypes.UT)) {
            this.setBackground(Color.yellow);
        } else if (this.fieldType.equals(FieldTypes.VEGZETHEGYE)) {
            this.setBackground(Color.red);
        }
        
    }
}
