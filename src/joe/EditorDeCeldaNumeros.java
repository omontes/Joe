/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Oscar Montes
 */
public class EditorDeCeldaNumeros extends DefaultCellEditor {

    private final JFormattedTextField tf;

    public EditorDeCeldaNumeros() {
        super(new JFormattedTextField());
        tf = (JFormattedTextField) getComponent();
        //Para cuando esta editando para que no acepte letras
        KeyListenerTablaFact listener =new KeyListenerTablaFact();
        listener.KeyListeberTablaFact(tf);
        tf.addKeyListener(listener);
        
        setClickCountToStart(1);
        tf.setBorder(null);
        
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
         Component c = super.getTableCellEditorComponent(table,
                value, isSelected, row, column);
         JFormattedTextField editor = (JFormattedTextField) c;
        ((JComponent) c).setBorder(new LineBorder(Color.black));
        
        if (isSelected) {
            ((JFormattedTextField) c).setText(null);
            
        }
        
        
        
        return editor;
    }
    

    @Override
    
    public Object getCellEditorValue() {
        // get content of textField
        String str = (String) super.getCellEditorValue();
        if (str == null) {
            return null;
        }

        if (str.length() == 0) {
            return null;
        }

        // try to parse a number
        try {
            ParsePosition pos = new ParsePosition(0);
            Number n = NumberFormat.getInstance().parse(str, pos);
            System.out.println(n);
            System.out.println(str);
            if (pos.getIndex() != str.length()) {
                tf.setText("");
                throw new ParseException(
                        "parsing incomplete", pos.getIndex());
            }
            

            // return an instance of column class
            return new Float(n.floatValue());

        } catch (Exception pex) {
            return null;
            
        }
    }

   


    @Override
    public boolean stopCellEditing() {
        if(super.getCellEditorValue().toString().equals("")){
            JOptionPane.showMessageDialog(
                          null,
                          "Porfavor ingrese un numero",
                          "Alert!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
              
        return super.stopCellEditing();
    }
    @Override
    public boolean isCellEditable(EventObject e) {
        if (e instanceof KeyEvent) {
            return startKeyEvent((KeyEvent) e);
        }
        return super.isCellEditable(e);
    }

    private boolean startKeyEvent(KeyEvent e) {
        //Nos dice si el primer digito entrado es un caracter
        
        if (!Character.isDigit(e.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            return false;
            
        }
        return true;
    }
    
}
