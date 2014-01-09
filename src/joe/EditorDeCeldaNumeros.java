/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.EventObject;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
          String TextoSinCorregir= this.tf.getText();
          String textocorregido = TextoSinCorregir.replace("C", "");
          DecimalFormat decimalfC = (DecimalFormat) NumberFormat.getInstance();
          decimalfC.setParseBigDecimal(true);
          BigDecimal valor = null;
          try {
              valor = (BigDecimal) decimalfC.parseObject(textocorregido);
          } catch (ParseException ex) {
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
          }
        Object value = Double.valueOf(valor.doubleValue());
        if ((value != null)) {
            Locale l = new Locale("es", "CR");
            Number numberValue = (Number) value;
            NumberFormat formatter = NumberFormat.getCurrencyInstance(l);
            value = formatter.format(numberValue.doubleValue());
            return value;
       
    }
        return value;
    }

   


    @Override
    public boolean stopCellEditing() {
        if(super.getCellEditorValue().toString().equals("")){
            /**JOptionPane.showMessageDialog(
                          null,
                          "Porfavor ingrese un numero",
                          "Alert!", JOptionPane.ERROR_MESSAGE);**/
            tf.setText("0.0");
            
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
