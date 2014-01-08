/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import db_managment.Direct_Control_BD;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
          String CantidadSinCorregir= model.getValueAt(row, 2).toString();
          DecimalFormat decimalfC = (DecimalFormat) NumberFormat.getInstance();
          decimalfC.setParseBigDecimal(true);
          BigDecimal cantidad = null;
          try {
              cantidad = (BigDecimal) decimalfC.parseObject(CantidadSinCorregir);
          } catch (ParseException ex) {
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
          }
          String price = info.replace("C", "");
          DecimalFormat decimalf = (DecimalFormat) NumberFormat.getInstance();
          decimalf.setParseBigDecimal(true);
          BigDecimal bd = null;
          try {
              bd = (BigDecimal) decimalf.parseObject(price);
          } catch (ParseException ex) {
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
          }
          model.setValueAt(bd.multiply(cantidad), row, column + 1);
          
      } 
           
        
      if (columnName.equals("Cod. Articulo")) {
          
          
              String codigo = data.toString();
              BigDecimal precio = this.BDmanagment.verPrecio(codigo);
              
              if (precio.toString().equals("0") & !info.equals("")) {
                  JOptionPane.showMessageDialog(
                          null,
                          "El producto con el cod  "+
                          info+
                          "  no esta disponible en el invetario"+
                          "  puede crearlo si presiona la tecla F5",
                          "El producto no existe", JOptionPane.ERROR_MESSAGE);
                  model.removeRow(row);
                  table.clearSelection();
                  table.changeSelection(row, column,false,false);
                  table.requestFocus();
                  return;
              }
              //En caso de que no escriba nada el usuario
              if (!info.equals("")) {
                  String descripcion = this.BDmanagment.verNombreProductoPorCodigo(codigo);
                  model.setValueAt(precio, row, column + 3);///IMPORTANTE ESTE ORDEN
                  model.setValueAt(1, row, column + 2);
                  model.setValueAt(descripcion, row, column + 1);
                  //table.revalidate();
                  //table.repaint();
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
          String CantidadSinCorregir= data.toString();
          DecimalFormat decimalfC = (DecimalFormat) NumberFormat.getInstance();
          decimalfC.setParseBigDecimal(true);
          BigDecimal cantidad = null;
          try {
              cantidad = (BigDecimal) decimalfC.parseObject(CantidadSinCorregir);
          } catch (ParseException ex) {
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
          }
          String PrecioConCurrency= model.getValueAt(row, column + 1).toString();
          String PrecioCorregido = PrecioConCurrency.replace("C", "");
          DecimalFormat decimalf = (DecimalFormat) NumberFormat.getInstance();
          decimalf.setParseBigDecimal(true);
          BigDecimal bd = null;
          try {
              bd = (BigDecimal) decimalf.parseObject(PrecioCorregido);
          } catch (ParseException ex) {
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
          }
          model.setValueAt(bd.multiply(cantidad), row, column + 2);
      }

        if (columnName.equals("Cantidad") & info.equals("1")) {
            String codigo = model.getValueAt(row,column-2).toString();
            //SI NO HAY NINGUN CODIGO PARA QUE BORRE AUTOMATICAMENTE
            if(codigo.equals("")){
                model.setValueAt(null, row,column);
                return;
            }
          String PrecioConCurrency = model.getValueAt(row, 3).toString();
          String PrecioCorregido = PrecioConCurrency.replace("C", "");
          DecimalFormat decimalf = (DecimalFormat) NumberFormat.getInstance();
          decimalf.setParseBigDecimal(true);
          BigDecimal bd = null;
          try {
              bd = (BigDecimal) decimalf.parseObject(PrecioCorregido);
          } catch (ParseException ex) {
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
          }

          model.setValueAt(bd, row, 4);
      }

        
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
