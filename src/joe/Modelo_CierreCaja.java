/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oscar Montes
 */
public class Modelo_CierreCaja extends AbstractTableModel {
    private String[] columnNames;
    public List<Object[]> data;
    public Modelo_CierreCaja(String[] columnNames,List<Object[]> data){
        this.columnNames=columnNames;
        this.data=data;
        
    }
    
    /**
     *
     * @param i
     */
    public void addRow(int i) {
        int current = data.size();
        int end = current + i;
        for (int j = current; j < end; j++) {
            data.add(new Object[]{"", "", "", "", ""});

        }
    }
    public void removeRow(int i){
        data.remove(i);
        
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col) {
            return columnNames[col];
        }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }
    /**
     *
     * @param row
     * @param col
     * @return
     */
    @Override
    /*
     * Les agrega el tipo de clase a cada columna
     */
    public Class getColumnClass(int c) {
                
            //System.out.println(getValueAt(0, c).getClass());
            return getValueAt(0, c).getClass();
        }
    @Override
     public void setValueAt(Object value, int row, int col) {
        data.get(row)[col] = value;
        fireTableCellUpdated(row, col);
    }
    /**
     * 
     * @param row
     * @param column 
     */
    
    @Override  
    public void fireTableCellUpdated(int row, int column) {  
        super.fireTableCellUpdated(row, column);
        
        
        
        
    }
    @Override
    public boolean isCellEditable(int row, int col) {
       
            return false;
        
        
    }
        

    
}