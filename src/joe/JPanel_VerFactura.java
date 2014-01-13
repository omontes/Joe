/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import db_managment.Direct_Control_BD;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oscar Montes
 */
public class JPanel_VerFactura extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_VerFactura
     */
    
    public JPanel_VerFactura() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Factura = new javax.swing.JTable();
        jButton_RegresarFact = new javax.swing.JButton();
        jLabel_NumFacTitle = new javax.swing.JLabel();
        jLabel_FechaFact = new javax.swing.JLabel();
        jFormattedTextField_SubTotal = new javax.swing.JFormattedTextField();
        jLabel_Fecha = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField_desc = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_Detalle = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField_DescuentoTotal = new javax.swing.JFormattedTextField();
        jFormattedTextField_Total = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jFormattedTextField_Cliente = new javax.swing.JFormattedTextField();
        jLabel_NumerodeFact = new javax.swing.JLabel();
        jTextField_tipopago = new javax.swing.JTextField();
        jTextField_Vendedor = new javax.swing.JTextField();

        jTable_Factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Factura.setCellSelectionEnabled(true);
        jTable_Factura.setFillsViewportHeight(true);
        jTable_Factura.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(jTable_Factura);

        jButton_RegresarFact.setText("Regresar");
        jButton_RegresarFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegresarFactActionPerformed(evt);
            }
        });

        jLabel_NumFacTitle.setText("Numero Fact");

        jLabel_FechaFact.setText("Fecha");

        jFormattedTextField_SubTotal.setEditable(false);
        jFormattedTextField_SubTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_SubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_SubTotal.setText("0.00");

        jLabel_Fecha.setText("Aqui va la fecha");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SubTotal");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Desc.");

        jFormattedTextField_desc.setEditable(false);
        jFormattedTextField_desc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField_desc.setText("0.00");

        jLabel8.setText("%");

        jLabel10.setText("Tipo de Pago");

        jTextField_Detalle.setEditable(false);

        jLabel11.setText("Detalle de Factura:");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total");

        jFormattedTextField_DescuentoTotal.setEditable(false);
        jFormattedTextField_DescuentoTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jFormattedTextField_DescuentoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_DescuentoTotal.setText("0.00");

        jFormattedTextField_Total.setEditable(false);
        jFormattedTextField_Total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_Total.setText("0.00");

        jLabel9.setText("Vendedor");

        jLabel16.setText("Cliente");

        jFormattedTextField_Cliente.setEditable(false);
        jFormattedTextField_Cliente.setText("Cliente Anonimo");

        jLabel_NumerodeFact.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel_NumerodeFact.setForeground(new java.awt.Color(0, 51, 51));
        jLabel_NumerodeFact.setText("Num");

        jTextField_tipopago.setEditable(false);
        jTextField_tipopago.setText("Efectivo");

        jTextField_Vendedor.setEditable(false);
        jTextField_Vendedor.setText("Vendedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_NumFacTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel_NumerodeFact)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextField_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextField_DescuentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField_Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_tipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextField_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel_FechaFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 60, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_RegresarFact)
                                .addGap(202, 202, 202)
                                .addComponent(jFormattedTextField_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_NumFacTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_NumerodeFact))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField_tipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel_FechaFact, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextField_SubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_RegresarFact))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField_DescuentoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jFormattedTextField_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jButton_RegresarFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegresarFactActionPerformed
        VentanaDeInicio miVentana= VentanaDeInicio.getInstance();
        JPanel_Facturacion panelFact= new JPanel_Facturacion();
        panelFact.setSize(this.getSize());
        panelFact.setLocation(this.getLocation());
        miVentana.remove(this);
        miVentana.add(panelFact);
        miVentana.setTitle("Facturacion");
        panelFact.setVisible(true);
        panelFact.completarTablaFacturacion();
        miVentana.revalidate();
        miVentana.repaint();
    }//GEN-LAST:event_jButton_RegresarFactActionPerformed
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
                Logger.getLogger(Modelo_Facturacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            return DatoCorregido;
    
    }
      /**
     * Este metodo permite personalizar la tabla de ver Factura
     */
    public void personalizarTablaVerFactura() {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String[] columnNames = {"Cod. Articulo","Articulo",
            "Cantidad","Precio.Unit",
            "Sub-Total"};
        List<Object[]> data = new ArrayList<Object[]>();      
        //Agrega el modelo a la factura
        Modelo_verFacturas model=new Modelo_verFacturas(columnNames,data);
        //Agrega 20 filas
        model.addRow(20);
        this.jTable_Factura.setModel(model);
        //Gana la atencion en el panel
        jTable_Factura.requestFocus();
        jTable_Factura.changeSelection(0,0,false, false);
        
        //Costumisando Precio y Cantidad (Solo van a permitir numeros)
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
              
        this.jTable_Factura.getColumnModel().getColumn(2).
                setCellRenderer(rightRenderer);
        this.jTable_Factura.getColumnModel().getColumn(3).
                setCellRenderer(new CurrencyRender());
        this.jTable_Factura.getColumnModel().getColumn(4).
                setCellRenderer(new CurrencyRender());
         
        
               
        this.cargarInfoFact();
        this.cargarProductosFact();
      
        
    }
/**
     * De vuelve un String[] con toda la informacion de una fila de una tabla
     * @param data  
     * //Viene de un consulta UNICAMENTE de una fila
     * @return 
     */
    private String[] obtenerFila(Object[][] data) {
        //System.out.println("ESTO ES LO QUE QUIERO");
        int numFilas= data.length;
        String[] string= new String[numFilas];
        int numColumnas= data[0].length;
        for(int row =0 ; row < numFilas;row++) {
            for(int column =0; column<numColumnas;column++) {
                string[row]=data[row][column].toString();
               
                
            }
            
        }
        return string;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton_RegresarFact;
    javax.swing.JFormattedTextField jFormattedTextField_Cliente;
    javax.swing.JFormattedTextField jFormattedTextField_DescuentoTotal;
    javax.swing.JFormattedTextField jFormattedTextField_SubTotal;
    javax.swing.JFormattedTextField jFormattedTextField_Total;
    javax.swing.JFormattedTextField jFormattedTextField_desc;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JLabel jLabel_Fecha;
    javax.swing.JLabel jLabel_FechaFact;
    javax.swing.JLabel jLabel_NumFacTitle;
    javax.swing.JLabel jLabel_NumerodeFact;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable_Factura;
    javax.swing.JTextField jTextField_Detalle;
    javax.swing.JTextField jTextField_Vendedor;
    javax.swing.JTextField jTextField_tipopago;
    // End of variables declaration//GEN-END:variables
    /**
     * Este metodo carga la informacion de la factura que se desea ver, esta
     * informacion es: cliente,vendedor,totalfact,descuento,fecha,detalle,
     * tipo de pago etc.
     */
    private void cargarInfoFact() {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verInfoFactura(Integer.parseInt(this.jLabel_NumerodeFact.getText()));
        Object[][] dataInfoFactura = AdminBD.getData();
        Object[] datosInfoFactura = dataInfoFactura[0];
        String fecha = datosInfoFactura[0].toString();
        String cliente = datosInfoFactura[1].toString();
        String vendedor = datosInfoFactura[2].toString();
        String tipopago = datosInfoFactura[3].toString();
        String totalFact = datosInfoFactura[4].toString();
        String detalle = datosInfoFactura[5].toString();
        String descuento = datosInfoFactura[6].toString();
        this.jFormattedTextField_Cliente.setText(cliente);
        this.jLabel_Fecha.setText(fecha);
        this.jTextField_Vendedor.setText(vendedor);
        this.jTextField_tipopago.setText(tipopago);
        this.jTextField_Detalle.setText(detalle);
        BigDecimal totalFacturado = this.StringtoBigDecimal(totalFact);
        BigDecimal descuentoD = this.StringtoBigDecimal(descuento);
        BigDecimal subtotal = totalFacturado.divide(new BigDecimal("1.00").subtract(descuentoD.divide(new BigDecimal("100.00"))));
        this.jFormattedTextField_DescuentoTotal.setValue(totalFacturado.subtract(subtotal));
        this.jFormattedTextField_SubTotal.setValue(subtotal);
        this.jFormattedTextField_Total.setValue(totalFacturado);
        this.jFormattedTextField_desc.setValue(descuentoD);

    }
    /**
     * Este metodo convierte un string que es un decimal a bigdecimal
     * @param numero
     * @return 
     */
    private BigDecimal StringtoBigDecimal(String numero){
        DecimalFormat decimalfC = (DecimalFormat) NumberFormat.getInstance();
        decimalfC.setParseBigDecimal(true);
        BigDecimal numeroCorregido = null;
        try {
            numeroCorregido = (BigDecimal) decimalfC.parseObject(numero);
        } catch (ParseException ex) {
            Logger.getLogger(JPanel_VerFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeroCorregido;
    
    }
    /**
     * Este metodo permite cargas los productos de la factura en la tabla para
     * ver la factura.
     */
    private void cargarProductosFact() {
        Modelo_verFacturas model = (Modelo_verFacturas) jTable_Factura.getModel();
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verProductosPorFactura(Integer.parseInt(this.jLabel_NumerodeFact.getText()));
        Object[][] ProductosdeFactura = AdminBD.getData();
        int numFilas = ProductosdeFactura.length;
        for (int row = 0; row < numFilas; row++) {
            Object[] producto= ProductosdeFactura[row];
            String codArticulo= producto[0].toString();
            String nombre= producto[1].toString();
            BigDecimal cantidad= this.StringtoBigDecimal(producto[2].toString());
            BigDecimal precioVenta= this.StringtoBigDecimal(producto[3].toString());
            model.setValueAt(codArticulo, row, 0);
            model.setValueAt(nombre, row, 1);
            model.setValueAt(cantidad, row, 2);
            model.setValueAt(precioVenta, row, 3);
            model.setValueAt(precioVenta.multiply(cantidad), row, 4);
            
            
            }
    }

        
       


}
