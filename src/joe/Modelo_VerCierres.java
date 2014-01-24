/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oscar Montes
 */
public class Modelo_VerCierres extends AbstractTableModel {
    
    private String[] columnNames;
    public Object[][] data;
    public Modelo_VerCierres(String[] columnNames,Object[][] data){
        this.columnNames=columnNames;
        this.data=data;
        
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public String getColumnName(int col) {
        /**if(col==0){
            return "Numero de Fact";
        
        }**/
            return columnNames[col];
        }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
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
            if(c==1 || c==2){
                return String.class;
            }
            return getValueAt(0, c).getClass();
        }
    @Override
     public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
    @Override
    public boolean isCellEditable(int row, int col) {
               return false;
        
    }
   
   
    
}
