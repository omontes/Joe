/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

/**
 *
 * @author Oscar Montes
 */
public class EditorDeCeldaNumeros extends DefaultCellEditor {

    private final JTextField tf;

    public EditorDeCeldaNumeros() {
        super(new JTextField());
        tf = (JTextField) getComponent();
        //Para cuando esta editando para que no acepte letras
        tf.addKeyListener(new KeyListenerTablaFact());
        setClickCountToStart(1);
        tf.setBorder(null);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
         Component c = super.getTableCellEditorComponent(table,
                value, isSelected, row, column);
        ((JComponent) c).setBorder(new LineBorder(Color.black));
        if (isSelected) {
            ((JTextField) c).setText(null);
            
        }
        
        
        
        return c;
    }

    @Override
    public Object getCellEditorValue() {
        return tf.getText();
    }
    @Override
    public boolean stopCellEditing() {
              
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
        //Nos dice si el digito entrado es un caracter
        if (!Character.isDigit(e.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            return false;
            
        }
        return true;
    }
    
}
