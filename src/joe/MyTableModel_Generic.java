/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;


import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Oscar Montes
 */
public class MyTableModel_Generic extends AbstractTableModel {
    private String[] columnNames;
    public Object[][] data;
    public MyTableModel_Generic(String[] columnNames,Object[][] data){
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
