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
public class MyKeyListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 8) {
            return;
        }
        if (!Character.isDigit(e.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            e.consume();
        }
     
}
}
