/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Oscar Montes
 */
public class KeyListenerTablaFact implements KeyListener {
    JFormattedTextField texto;
    public void KeyListeberTablaFact(JFormattedTextField texto){
        this.texto=texto;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown()){System.out.println("presiono control");
        e.consume();}
        
        /**if (e.isControlDown() && e.getKeyChar() == KeyEvent.VK_C) {
             System.out.println("entro");
               e.consume();
        } else if (e.isControlDown() && e.getKeyChar() == KeyEvent.VK_X) {
               e.consume();
        } else if (e.isControlDown() && e.getKeyChar() == KeyEvent.VK_V) {
               e.consume();
        }**/
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
       

        char tecla= e.getKeyChar();
         
        //System.out.println(tecla);
        if (tecla== 8) {
            return;
        }
        
         
        String unitCost = texto.getText().trim();
        int dot = unitCost.indexOf('.');
        if (dot > 0) {
            if(tecla==KeyEvent.VK_PERIOD){
                e.consume();
            };

            if (texto.getCaretPosition() > dot && dot + 2 < unitCost.length()) {
                e.consume();
            }
        }
        if(tecla==KeyEvent.VK_PERIOD){
            return;
            
        }

        if (!Character.isDigit(tecla) & !Character.isISOControl(e.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            e.consume();
        }

    }
}
