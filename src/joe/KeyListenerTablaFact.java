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
        System.out.println(dot);
        if (dot > 0) {
            if(tecla==KeyEvent.VK_PERIOD){
                System.out.println("no mas puntos");
                e.consume();
            };

            if (texto.getCaretPosition() > dot && dot + 2 < unitCost.length()) {
                e.consume();
            }
        }
        if(tecla==KeyEvent.VK_PERIOD){
            return;
            
        }

        if (!Character.isDigit(tecla)) {
            Toolkit.getDefaultToolkit().beep();
            e.consume();
        }

    }
}
