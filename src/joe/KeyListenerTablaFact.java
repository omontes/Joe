/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Oscar Montes
 */
public class KeyListenerTablaFact implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
       

        char tecla= e.getKeyChar();
        if (tecla== 8) {
            return;
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
