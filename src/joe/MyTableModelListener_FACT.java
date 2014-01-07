/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import db_managment.Direct_Control_BD;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Oscar Montes
 * Esta clase crea un Listener Personalizado para la Tabla de Factura
 */
public class MyTableModelListener_FACT implements TableModelListener {
    JTable table;
    // Contiene el valor antiguo que tiene un celda antes de ser cambiado
    private String oldValue; 
    private Direct_Control_BD BDmanagment;
    //Es el TextField que va a guardar los datos segun lo que pase en la tabla
    private JTextField total;

  MyTableModelListener_FACT(JTable table,String oldValue,JTextField total,
          Direct_Control_BD BDmanagment) {
    this.table = table;
    this.oldValue=oldValue;
    this.BDmanagment=BDmanagment;
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
          
      double totalFact = Double.parseDouble(this.total.getText());
      System.out.println(totalFact);
      if (columnName.equals("Sub-Total") & totalFact == 0) {
          double subtotal = Double.parseDouble(info);
          //this.total.setText(Double.toString(subtotal));
          
      }
      if (columnName.equals("Sub-Total") & totalFact != 0) {
          double subtotal = Double.parseDouble(info);
          double subtotal_old=0.0;
          if(! oldValue.equals("")){
              subtotal_old=Double.parseDouble(oldValue);
          }
          //this.total.setText(Double.toString((subtotal-subtotal_old) +
              //    totalFact));
          
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
          double cantidad = Double.parseDouble(model.getValueAt(row,2).toString());
          model.setValueAt(Double.parseDouble(info)*cantidad, row, column + 1);
          
      } 
           
        
      if (columnName.equals("Cod. Articulo")) {
          
          
              String codigo = data.toString();
              double precio = this.BDmanagment.verPrecio(codigo).doubleValue();
              System.out.println(precio);
              if (precio == 0 & !info.equals("")) {
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
                  String descripcion = this.BDmanagment.verNombreProductoPorCodigo(codigo);
                  System.out.println(descripcion);
                  model.setValueAt(precio, row, column + 3);///IMPORTANTE ESTE ORDEN
                  model.setValueAt(1.0, row, column + 2);
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
          double cantidad = Double.parseDouble(data.toString());
          double precio = Double.parseDouble(model.getValueAt(row, column + 1).toString());
          model.setValueAt(precio * cantidad, row, column + 2);
      }

        if (columnName.equals("Cantidad") & info.equals("1")) {
            String codigo = model.getValueAt(row,column-2).toString();
            //SI NO HAY NINGUN CODIGO PARA QUE BORRE AUTOMATICAMENTE
            if(codigo.equals("")){
                model.setValueAt(null, row,column);
                return;
            }
            double precio = Double.parseDouble(model.getValueAt(row,3).toString());
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
