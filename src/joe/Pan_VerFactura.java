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
import javax.print.PrintService;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import jzebra.PrintRaw;
import jzebra.PrintServiceMatcher;

/**
 *
 * @author Oscar Montes
 */
public class Pan_VerFactura extends javax.swing.JPanel {

    private boolean _savePress;
    
    /**
     * Creates new form JPanel_VerFactura
     */
    
    public Pan_VerFactura() {
        initComponents();
        _savePress = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Factura = new javax.swing.JTable();
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
        bttPrint = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jFormattedTextField_Cliente = new javax.swing.JFormattedTextField();
        jLabel_NumerodeFact = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_tipopago = new javax.swing.JTextField();
        jTextField_Vendedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 471));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 780, 320));

        jFormattedTextField_SubTotal.setEditable(false);
        jFormattedTextField_SubTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_SubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_SubTotal.setText("0.00");
        add(jFormattedTextField_SubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 214, -1));

        jLabel_Fecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_Fecha.setText("Aqui va la fecha");
        add(jLabel_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 170, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SubTotal");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 73, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Desc.");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 44, 26));

        jFormattedTextField_desc.setEditable(false);
        jFormattedTextField_desc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextField_desc.setText("0.00");
        add(jFormattedTextField_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 47, -1));

        jLabel8.setText("%");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tipo de Pago");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 5, -1, 20));

        jTextField_Detalle.setEditable(false);
        add(jTextField_Detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 310, 30));

        jLabel11.setText("Detalle de Factura:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 73, 20));

        jFormattedTextField_DescuentoTotal.setEditable(false);
        jFormattedTextField_DescuentoTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jFormattedTextField_DescuentoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_DescuentoTotal.setText("0.00");
        add(jFormattedTextField_DescuentoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 214, -1));

        jFormattedTextField_Total.setEditable(false);
        jFormattedTextField_Total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_Total.setText("0.00");
        add(jFormattedTextField_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 214, -1));

        jLabel9.setText("Vendedor");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 60, 22));

        bttPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/printBtt.png"))); // NOI18N
        bttPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttPrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttPrintMouseExited(evt);
            }
        });
        add(bttPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cliente");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 5, 43, 20));

        jFormattedTextField_Cliente.setEditable(false);
        jFormattedTextField_Cliente.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jFormattedTextField_Cliente.setText("Cliente Anonimo");
        add(jFormattedTextField_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 5, 120, 22));

        jLabel_NumerodeFact.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel_NumerodeFact.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NumerodeFact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_NumerodeFact.setText("Num");
        jLabel_NumerodeFact.setToolTipText("Número de factura");
        add(jLabel_NumerodeFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 5, 250, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver Factura");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jTextField_tipopago.setEditable(false);
        jTextField_tipopago.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_tipopago.setText("Efectivo");
        add(jTextField_tipopago, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 5, 70, 22));

        jTextField_Vendedor.setEditable(false);
        jTextField_Vendedor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField_Vendedor.setText("Vendedor");
        add(jTextField_Vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 250, 22));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/panelVF.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
     /**
     * Imprime la factura.
     *
     * @param numFact //Debe ser Generico.
     * @param date
     * @param totalFact
     * @return
     */
    private boolean imprimir(String numFact, String date, String totalFact, String subtotalFact, String desc, String rebaja, String cliente,
            String vendedor, String venta) {
        try {
            String rawCmds = "FIRST NAME";
            String printer = "Generic / Text Only (Copy 3)"; // debe tener 
            //el mismo nombre que la impresora 
            PrintService ps = PrintServiceMatcher.findPrinter(printer);
            if (ps != null) {

                PrintRaw p = new PrintRaw(ps, rawCmds);
                /**
                 * p.clear(); p.append("N\n"); p.append("^XA\n");
                 * p.append("^FO350,355^A0N,30,30^FD\"" + title + "\"\n");
                 * p.append("^XZ\n");
                p.append("P1,1\n");*
                 */
                p.clear();
                p.append("\u001B\u0040"); //reset printer 
                //p.append("\u001B"+"\u0045"+"\u0001"+"\r");//Negrita
                /**
                 * ********************************************************
                 */

                p.append("\u001B" + "\u0061" + "\u0001" + "\r");//*** Centrado
                p.append("Boutique Francini\r\n");
                p.append("San Jose, Costa Rica\r\n");
                p.append("Tel:228826962,pulgamontes@gmail.com\r\n");
                p.append("Resolucion nro. 234252 del 2003-89\r\n");
                p.append("\u001B" + "\u0064" + "\u0001" + "\r");//*** 3lineas
                /**
                 * *******************************************************
                 */
                //p.append("\u001B"+"\u0045"+"\u0000"+"\r");//QuitalaNegrita
                /**
                 * ********************************************************
                 */

                p.append("\u001B" + "\u0061" + "\u0000" + "\r");//Quita Centrado
                p.append("Fecha   : \t " + date + "\r\n");
                p.append("NoFact  : \t " + numFact + "\r\n");
                p.append("Cliente : \t " + cliente + "\r\n");
                p.append("Vendedor: \t " + vendedor + "\r\n");
                p.append("Venta   : \t " + venta + "\r\n");
                p.append("CANT. \t DESCRIPCION \t      TOTAL\r\n");
                p.append("----  ----------------       ------\r\n");

                /**
                 * ********************************************************
                 */
                Modelo_verFacturas dtm = (Modelo_verFacturas) jTable_Factura.getModel();
                int nRow = dtm.getRowCount();
                for (int i = 0; i < nRow; i++) {
                    String Producto = dtm.getValueAt(i, 1).toString();
                    if (!Producto.equals("")) {
                        String cantidad = dtm.getValueAt(i, 2).toString();
                        String subtotal = dtm.getValueAt(i, 4).toString();
                        p.append("" + Producto + "   \r\n");
                        p.append("" + cantidad + "                           "
                                + "" + subtotal + "   \r\n");
                    }

                }

                //p.append("----  ----------------    -----------   \r\n");
                //p.append("----------------------------------------\r\n"); 
                /*
                 * Importante solo se esta usando la parte hexadecimal
                 * //u00HEX
                 * junto con el archivo ESC-POS-Programming-Guide
                 */
                /*
                 * Para centrado y Derecha se esta usando la descripcion 
                 * que viene en esta pagina donde dice other 
                 * http://www.lprng.com/DISTRIB/RESOURCES/PPD/epson.htm 
                 * (FAVORITOS)
                 */
                p.append("\u001B" + "\u0061" + "\u0002" + "\r");//*** Derecha
                p.append("\u001B" + "\u0064" + "\u0003" + "\r");//*** 1lineas
                String subto = " SUB TOTAL : \t " + subtotalFact + "";
                String subtoCantidad = this.fill(subto, 25, " ");
                p.append(subtoCantidad + "\r\n");
                p.append(this.fill(" DESCTO  % : \t " + desc + "", subtoCantidad.length(), " ") + "\r\n");
                p.append(this.fill(" DESCUENTO : \t " + rebaja + "", subtoCantidad.length(), " ") + "\r\n");
                p.append("---------------------------\r\n");
                p.append(this.fill(" T O T A L : \t " + totalFact + "", subtoCantidad.length(), " ") + "\r\n");
                p.append("\u001B" + "\u0061" + "\u0000" + "\r");//Quita Centrado
                p.append("\u001B" + "\u0061" + "\u0001" + "\r");//*** Centrado
                p.append("\u001B" + "\u0064" + "\u0004" + "\r");//*** 3lineas
                p.append("Muchas Gracias por su compra\r\n");
                p.append("\u001B\u0040");//reset printer
                p.append("\u001B" + "\u0064" + "\u0008" + "\r");//*** 10lineas**/
                p.append("\u001D" + "\u0056" + "\u0001" + "\r");//*** CutPaper
                
                //p.append("-Texto sin negrita-\r\n");
                //p.append("-XXXXXXXXXXXXXX-\r\n");
                return p.print();

            } else {
                System.err.println("No encontro ninguna impresora");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String fill(int length, String with) {
        StringBuilder sb = new StringBuilder(length);
        while (sb.length() < length) {
            sb.append(with);
        }
        return sb.toString();
    }

    public String fill(String value, int length, String with) {

        StringBuilder result = new StringBuilder(length);
        result.append(value);
        result.append(fill(Math.max(0, length - value.length()), with));

        return result.toString();

    }
    private void bttPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttPrintMouseClicked
        if (!_savePress){
            _savePress = true;
            this.imprimir(this.jLabel_NumerodeFact.getText(),this.jLabel_Fecha.getText(),this.jFormattedTextField_Total.getText(),this.jFormattedTextField_SubTotal.getText(),this.jFormattedTextField_desc.getText(),this.jFormattedTextField_DescuentoTotal.getText(),this.jFormattedTextField_Cliente.getText(),
                this.jTextField_Vendedor.getText(),this.jTextField_tipopago.getText());
        } 
        _savePress = false;
            
    }//GEN-LAST:event_bttPrintMouseClicked

    private void bttPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttPrintMouseEntered
        bttPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/printBttOvr.png")));
    }//GEN-LAST:event_bttPrintMouseEntered

    private void bttPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttPrintMouseExited
        bttPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/printBtt.png")));
    }//GEN-LAST:event_bttPrintMouseExited
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
        
        //Agrega 20 filas
        model.addRow(20);
      
        
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
    javax.swing.JLabel bttPrint;
    javax.swing.JFormattedTextField jFormattedTextField_Cliente;
    javax.swing.JFormattedTextField jFormattedTextField_DescuentoTotal;
    javax.swing.JFormattedTextField jFormattedTextField_SubTotal;
    javax.swing.JFormattedTextField jFormattedTextField_Total;
    javax.swing.JFormattedTextField jFormattedTextField_desc;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JLabel jLabel_Fecha;
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
            Logger.getLogger(Pan_VerFactura.class.getName()).log(Level.SEVERE, null, ex);
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
            model.addRow(1);
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

    void personalizarTablaVerDevoluciones() {
        String[] columnNames = {"Cod. Articulo","Articulo",
            "Cantidad","Precio.Unit",
            "Sub-Total"};
        List<Object[]> data = new ArrayList<Object[]>();      
        //Agrega el modelo a la factura
        Modelo_verFacturas model=new Modelo_verFacturas(columnNames,data);
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
        this.cargarInfoDev();
        this.cargarProductosDevolucion();
        //Agrega 20 filas
        model.addRow(20);
    }

    private void cargarInfoDev() {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verInfoDevolucion(Integer.parseInt(this.jLabel_NumerodeFact.getText()));
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

    private void cargarProductosDevolucion() {
        Modelo_verFacturas model = (Modelo_verFacturas)jTable_Factura.getModel();
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verProductosPorDevolucion(Integer.parseInt(this.jLabel_NumerodeFact.getText()));
        Object[][] ProductosdeFactura = AdminBD.getData();
        int numFilas = ProductosdeFactura.length;
        for (int row = 0; row < numFilas; row++) {
            model.addRow(1);
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
