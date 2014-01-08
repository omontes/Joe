/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;


import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Oscar Montes
 */
public class MyTableModel_FACT extends AbstractTableModel {
    private String[] columnNames;
    public List<Object[]> data;
    public MyTableModel_FACT(String[] columnNames,List<Object[]> data){
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
            /**if (c ==2 | c==3){
            return Integer.class;
             }**/
            
            //System.out.println(getValueAt(0, c).getClass());
            return getValueAt(0, c).getClass();
        }
    @Override
     public void setValueAt(Object value, int row, int col) {
        Object val=this.getValueAt(row, col);
        TableModelListener[] mylistener= this.getTableModelListeners();
        MyTableModelListener_FACT a=(MyTableModelListener_FACT)mylistener[0];
        if (val != null) {
            String oldValue = this.getValueAt(row, col).toString();
            data.get(row)[col] = value;
            a.setOldValue(oldValue);
            fireTableCellUpdated(row, col);
            return;
        }
        a.setOldValue("");
        data.get(row)[col]=value;
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
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 4 | col==1) {
            return false;
        } else {
            return true;
        
    }
        
}
    
}
   
   

 