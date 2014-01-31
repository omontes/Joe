/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package structures;

import javax.swing.JPanel;

/**
 *
 * @author Joseph
 */
public class PanelStack {
    
    PanelNode _top;
    PanelNode _bottom;
    
    public PanelNode getTop(){
        return _top;
    }
    
    public PanelNode getBottom(){
        return _bottom;
    }
    
    public JPanel pop(){
        PanelNode temp = _top;
        if (_top == _bottom){
            _top = _bottom = null;
        } else {
            _top = _top.getPrevious();
        }
        return temp.getPanel();
    }
    
    public void push(JPanel pPanel){
        PanelNode newNode = new PanelNode(pPanel);
        if (_top == null){
            _top = _bottom = newNode;
        } else {
            newNode.setPrevious(_top);
            _top = newNode;
        }
    }
    
}
