/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import db_managment.Direct_Control_BD;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Edward Umana Williams
 * Esta clase crea un Listener Personalizado para la Tabla de Factura
 */
public class Listener_Inventario implements TableModelListener {
    JTable table;
    // Contiene el valor antiguo que tiene un celda antes de ser cambiado
    private String oldValue; 
  
    //Es el TextField que va a guardar los datos segun lo que pase en la tabla
    private JTextField total;

  Listener_Inventario(JTable table,String oldValue,JTextField total) {
   
    this.table = table;
    this.oldValue=oldValue;
    this.total=total;
    
  }

  @Override
  /**
   * Este metodo detecta un cambio en la tabla y ejecuta varias condiciones.
   */
  
  public void tableChanged(TableModelEvent e) {
      
      int row = e.getFirstRow();//row
      int lastRow = e.getLastRow();
      int column = e.getColumn();//column
      MyTableModel_FACT model = (MyTableModel_FACT) e.getSource();
      String columnName = model.getColumnName(column);
      Object data = model.getValueAt(row, column);
      if(data==null){
          return;
      }
      String info = data.toString();
      String oldValue=this.getOldValue();
          
      BigDecimal totalFact = new BigDecimal(this.total.getText());
      if (columnName.equals("Sub-Total") & totalFact.toString().equals("0.0")) {
          BigDecimal subtotal = new BigDecimal(info);
          this.total.setText(subtotal.toString());
          
      }
      if (columnName.equals("Sub-Total") &  !totalFact.toString().equals("0.0")) {
          BigDecimal subtotal = new BigDecimal(info);
          BigDecimal subtotal_old= new BigDecimal("0.0");
          if(! oldValue.equals("")){
              subtotal_old=new BigDecimal(oldValue);
          }
          this.total.setText((subtotal.subtract(subtotal_old)).add(totalFact).toString());
          
      }
      //Esta condicion es para hacer que no se inserte un precio sin haber un codigo
      if (columnName.equals("Precio.Unit") & this.getOldValue().equals("") ) {
          String codigo = model.getValueAt(row,column-3).toString();
            //SI NO HAY NINGUN CODIGO PARA QUE BORRE AUTOMATICAMENTE
            if (codigo.equals("")) {
                model.setValueAt(null, row,column);
                return;
            }
          
      }
      //Esta condicion es para cuando se modifica un precio
      if (columnName.equals("Precio.Unit") & !this.getOldValue().equals("") ) {
          BigDecimal cantidad = new BigDecimal (model.getValueAt(row,2).toString());
          model.setValueAt(new BigDecimal(info).multiply(cantidad), row, column + 1);
          
      } 
           
        
      if (columnName.equals("Cod. Articulo")) {
          
          Direct_Control_BD BDmanagment= Direct_Control_BD.getInstance();
              String codigo = data.toString();
              BigDecimal precio = BDmanagment.verPrecio(codigo);
              
              if (precio.toString().equals("0.0") & !info.equals("")) {
                  JOptionPane.showMessageDialog(
                          null,
                          "ESTE PRODUCTO NO ESTA EN EL INVENTARIO",
                          "Alert!", JOptionPane.ERROR_MESSAGE);
                  System.out.println("SOY ROW");
                  System.out.println(row);
                  ((MyTableModel_FACT)model).removeRow(row);
                  return;
              }
              //En caso de que no escriba nada el usuario
              if (!info.equals("")) {
                  String descripcion = BDmanagment.verNombreProductoPorCodigo(codigo);
                  System.out.println(descripcion);
                  model.setValueAt(precio, row, column + 3);///IMPORTANTE ESTE ORDEN
                  model.setValueAt(1, row, column + 2);
                  model.setValueAt(descripcion, row, column + 1);
              }
          
          
         

            
        }
        
        if (columnName.equals("Cantidad") & !info.equals("1")) {
            String codigo = model.getValueAt(row,column-2).toString();
            //SI NO HAY NINGUN CODIGO PARA QUE BORRE AUTOMATICAMENTE
            if (codigo.equals("")) {
                model.setValueAt(null, row,column);
                return;
            }
            //EN CASO DE NO DIGITAR NADA
            if (info.equals("")) {
                return;
                
          }
          BigDecimal cantidad = new BigDecimal(data.toString());
          BigDecimal precio = new BigDecimal(model.getValueAt(row, column + 1).toString());
          model.setValueAt(precio.multiply(cantidad), row, column + 2);
      }

        if (columnName.equals("Cantidad") & info.equals("1")) {
            String codigo = model.getValueAt(row,column-2).toString();
            //SI NO HAY NINGUN CODIGO PARA QUE BORRE AUTOMATICAMENTE
            if(codigo.equals("")){
                model.setValueAt(null, row,column);
                return;
            }
            BigDecimal precio = new BigDecimal(model.getValueAt(row,3).toString());
            model.setValueAt(precio, row, 4);}
       
        
  }

    /**
     * @return the oldValue
     */
    public String getOldValue() {
        return oldValue;
    }

    /**
     * @param oldValue the oldValue to set
     */
    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }
}
