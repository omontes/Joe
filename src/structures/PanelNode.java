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
public class PanelNode {
    
    private JPanel _panel;
    private PanelNode _next;
    private PanelNode _previous;
    
    public PanelNode(JPanel pPanel){
        _panel = pPanel;
        _next = _previous = null;
    }
    
    public void setPanel(JPanel pPanel){
        _panel = pPanel;
    }
    
    public JPanel getPanel(){
        return _panel;
    }
    
    public void setNext(PanelNode pNode){
        _next = pNode;
    }
    
    public PanelNode getNext(){
        return _next;
    }
    
    public void setPrevious(PanelNode pNode){
        _previous = pNode;
    }
    
    public PanelNode getPrevious(){
        return _previous;
    }
    
}
