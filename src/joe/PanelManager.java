/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import structures.PanelStack;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Joseph
 */
public class PanelManager {
    
    private final PanelStack _stack;
    private final JLayeredPane _layeredPane;
    
    public PanelManager(JLayeredPane pLayeredPane){
        _stack = new PanelStack();
        _layeredPane = pLayeredPane;
    }
    
    public JLayeredPane getLayeredPane(){
        return _layeredPane;
    }
    
    public void showPanel(JPanel pPanel){
        if (_stack.getTop() != null){
            _stack.getTop().getPanel().setVisible(false);
            _stack.getTop().getPanel().setEnabled(false);
        }
        _stack.push(pPanel);
        _layeredPane.add(pPanel, 0);
        pPanel.setVisible(true);
    }
    
    public void showPanel(JPanel pPanel, int pWidth, int pHeight, int pPosX, int pPosY){
        pPanel.setSize(pWidth, pHeight);
        pPanel.setLocation(pPosX, pPosY);
        showPanel(pPanel);
    }
    
    public void addPanelToPane(JPanel pPanel){
        _layeredPane.add(pPanel, 1);
        pPanel.setVisible(false);
    }
    
    public void changeStartPanel(JPanel pPanel){
        _stack.pop().setVisible(false);
        _stack.push(pPanel);
        pPanel.setVisible(true);
    }
    
    public Object back(){
        JPanel lastPanel = _stack.pop();
        lastPanel.setVisible(false);
        _layeredPane.remove(lastPanel);
        if (_stack.getTop() != null) {
            _stack.getTop().getPanel().setVisible(true);
            _stack.getTop().getPanel().setEnabled(true);
        }
        return _stack.getTop();
    }
}
