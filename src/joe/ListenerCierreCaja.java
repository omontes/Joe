/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Oscar Montes
 */
class ListenerCierreCaja implements TableModelListener {
    JTable table;
    private Direct_Control_BD BDmanagment;
    //Es el TextField que va a guardar los datos segun lo que pase en la tabla
    private JFormattedTextField totalTarjeta;
    //Es el TextField que va a guardar los datos segun lo que pase en la tabla
    private JFormattedTextField totalContado;

  ListenerCierreCaja(JTable table,JFormattedTextField totalTarjeta,
          Direct_Control_BD BDmanagment,JFormattedTextField totalContado) {
    this.table = table;
    this.BDmanagment=BDmanagment;
    this.totalTarjeta=totalTarjeta;
    this.totalContado=totalContado;
    
  }

  @Override
  /**
   * Este metodo detecta un cambio en la tabla y ejecuta varias condiciones.
   */
    public void tableChanged(TableModelEvent e) {
        
        int row = e.getFirstRow();//row
        int column = e.getColumn();//column
        Modelo_CierreCaja model = (Modelo_CierreCaja) e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        if (data == null) {
            return;
        }
        String info = data.toString();
        String totalContadoSinCorregir = this.totalContado.getText();
        BigDecimal totalContado = this.corregirDato(totalContadoSinCorregir);
        String totalTarjetaSinCorregir = this.totalTarjeta.getText();
        BigDecimal totalTarjeta = this.corregirDato(totalTarjetaSinCorregir);
        //Esta condicion es para hacer que no se inserte un precio sin haber un codigo
        if (columnName.equals("Monto")) {
            String tipopago = model.getValueAt(row, column - 1).toString();
            String MontoConCurrency =info;
            BigDecimal MontoCorregido = this.corregirDato(MontoConCurrency);
            if (tipopago.equals("Efectivo")) {
                this.totalContado.setValue(MontoCorregido.add(totalContado));
                return;
                
            }
            if (tipopago.equals("Tarjeta")) {
                this.totalTarjeta.setValue(MontoCorregido.add(totalTarjeta));
                return;
                
            }
            
        }
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
