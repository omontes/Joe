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
import javax.swing.JFormattedTextField;
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
    private JFormattedTextField total;

  MyTableModelListener_FACT(JTable table,String oldValue,JFormattedTextField total,
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
      String totalFacturaSinCorregir = this.total.getText();
      BigDecimal totalFact = this.corregirDato(totalFacturaSinCorregir);          
      if (columnName.equals("Sub-Total") & totalFact.toString().equals("0.0")) {
          BigDecimal subtotal = new BigDecimal(info);
          this.total.setValue(subtotal);          
      }
      if (columnName.equals("Sub-Total") &  !totalFact.toString().equals("0.0")) {
          BigDecimal subtotal = new BigDecimal(info);
          BigDecimal subtotal_old= new BigDecimal("0.0");
          if(! oldValue.equals("")){
              subtotal_old=new BigDecimal(oldValue);
          }
          this.total.setValue((subtotal.subtract(subtotal_old)).add(totalFact));          
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
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).
                      log(Level.SEVERE, null, ex);
          }
          BigDecimal bd = this.corregirDato(info);
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
                          "  no esta disponible en el invetario\n"+
                          "puede crearlo en las opciones de la izquierda",
                          "El producto no existe", JOptionPane.ERROR_MESSAGE);
                  model.removeRow(row);
                  table.clearSelection();
                  table.changeSelection(row, column,false,false);
                  table.requestFocus();
                  return;
              }
              //si ingresa un codigo el usuario
              if (!info.equals("")) {
                  String descripcion = this.BDmanagment.verNombreProductoPorCodigo(codigo);
                  model.setValueAt(precio, row, column + 3);///IMPORTANTE ESTE ORDEN
                  model.setValueAt(1, row, column + 2);
                  model.setValueAt(descripcion, row, column + 1);
              }
              // Por si el usuario no deja nada en la celda y ya tenia un cod
              // de un articulo entonces hace que se mantega el que ya estaba
              if(info.equals("") & !oldValue.equals("")){
                   model.setValueAt(oldValue, row,0);
                   return;
                  
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
              Logger.getLogger(MyTableModelListener_FACT.class.getName()).
                      log(Level.SEVERE, null, ex);
          }
          String PrecioConCurrency= model.getValueAt(row, column + 1).toString();
          BigDecimal bd = this.corregirDato(PrecioConCurrency);
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
          BigDecimal bd = this.corregirDato(PrecioConCurrency);
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
    /**
     * Este metodo permite corregir el dato que tiene el signo de C y ademas
     * que puede tener comas ya que el tipo Decimal en la base solo
     * puede tener puntos y no comas.
     * @param Dato
     * @return 
     */
     private BigDecimal corregirDato(String Dato){
            String datoAcorregir = Dato.replace("C", "");
            DecimalFormat decimalformat = (DecimalFormat) NumberFormat.getInstance();
            decimalformat.setParseBigDecimal(true);
            BigDecimal DatoCorregido = null;
            try {
                DatoCorregido = (BigDecimal) decimalformat.parseObject(datoAcorregir);
            } catch (ParseException ex) {
                Logger.getLogger(MyTableModelListener_FACT.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DatoCorregido;
    
    }
}
