/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import ManejoDeArchivos.XMLConfiguracion;
import db_managment.Direct_Control_BD;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import jzebra.PrintRaw;
import jzebra.PrintServiceMatcher;



/**
 *
 * @author Oscar Montes
 */
public class Pan_VerEntradaSalida extends javax.swing.JPanel {

    public static final int ENTRADA_CALL = 0;
    public static final int SALIDA_CALL = 1;
    
    
    /**
     * Creates new form JPanel_verEntradaSalidaMercaderia
     */
    public Pan_VerEntradaSalida(int pCallType) {
        initComponents();
        setTittle(pCallType);
    }

    private void setTittle(int pCallType){
        if (pCallType == ENTRADA_CALL){
            labDescrip.setText("Entrada");
        } else {
            labDescrip.setText("Salida");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Fecha = new javax.swing.JLabel();
        jLabel_tipoMov = new javax.swing.JLabel();
        jComboBox_LugarDeMov = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jTextField_referencia = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Movimiento = new javax.swing.JTable();
        jLabel_NumerodeMovimiento = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField_Total = new javax.swing.JFormattedTextField();
        bttPrint = new javax.swing.JLabel();
        labDescrip = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 471));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 471));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_Fecha.setText("Aqui va la fecha");
        add(jLabel_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 102, 20));

        jLabel_tipoMov.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_tipoMov.setText("Entrada a:");
        add(jLabel_tipoMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 5, -1, 20));

        jComboBox_LugarDeMov.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inventario General", "Bodega" }));
        add(jComboBox_LugarDeMov, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 5, -1, -1));

        jLabel7.setText("Referencia");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));
        add(jTextField_referencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 306, -1));

        jTable_Movimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Movimiento.setCellSelectionEnabled(true);
        jTable_Movimiento.setFillsViewportHeight(true);
        jTable_Movimiento.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(jTable_Movimiento);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 780, 340));

        jLabel_NumerodeMovimiento.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_NumerodeMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_NumerodeMovimiento.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_NumerodeMovimiento.setText("Num");
        add(jLabel_NumerodeMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 5, 210, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 60, 40));

        jFormattedTextField_Total.setEditable(false);
        jFormattedTextField_Total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFormattedTextField_Total.setText("0.00");
        jFormattedTextField_Total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        add(jFormattedTextField_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 315, 40));

        bttPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/printBtt.png"))); // NOI18N
        bttPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttPrintMouseClicked(evt);
            }
        });
        add(bttPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, -1, -1));

        labDescrip.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDescrip.setForeground(new java.awt.Color(255, 255, 255));
        labDescrip.setText("Descripcion");
        add(labDescrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 130, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/panelVF.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bttPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttPrintMouseClicked
        this.imprimirMovimiento(
                this.jTable_Movimiento,this.jLabel_NumerodeMovimiento.getText(),
                this.jLabel_Fecha.getText(),
                this.jComboBox_LugarDeMov.getSelectedItem().toString(),
                this.jFormattedTextField_Total.getText(),
                this.jTextField_referencia.getText());
    }//GEN-LAST:event_bttPrintMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel bttPrint;
    javax.swing.JComboBox jComboBox_LugarDeMov;
    javax.swing.JFormattedTextField jFormattedTextField_Total;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel_Fecha;
    javax.swing.JLabel jLabel_NumerodeMovimiento;
    javax.swing.JLabel jLabel_tipoMov;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JTable jTable_Movimiento;
    javax.swing.JTextField jTextField_referencia;
    javax.swing.JLabel labDescrip;
    // End of variables declaration//GEN-END:variables

   
    public void personalizarTablaVerMovimiento() {
        String[] columnNames = {"Cod. Articulo", "Articulo",
            "Cantidad", "Precio.Unit",
            "Sub-Total"};
        List<Object[]> data = new ArrayList<Object[]>();
        //Agrega el modelo a la factura
        Modelo_verFacturas model = new Modelo_verFacturas(columnNames, data);
        this.jTable_Movimiento.setModel(model);
        this.jTextField_referencia.setEditable(false);
        //Costumisando Precio y Cantidad
        //(Solo van a permitir numeros y tener el signo colon)
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment( JLabel.RIGHT );
              
        this.jTable_Movimiento.getColumnModel().getColumn(2).
                setCellRenderer(rightRenderer);
        this.jTable_Movimiento.getColumnModel().getColumn(3).
                setCellRenderer(new CurrencyRender());
        this.jTable_Movimiento.getColumnModel().getColumn(4).
                setCellRenderer(new CurrencyRender());
        
        this.cargarInfoTablaVerMovimiento();
        this.cargarProductosMovimiento();
        
         //Agrega 20 filas
        model.addRow(20);
       

    }

    private void cargarInfoTablaVerMovimiento() {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verInfoMovimiento(Integer.parseInt(this.jLabel_NumerodeMovimiento.getText()));
        Object[][] dataInfoMov = AdminBD.getData();
        Object[] datosInfoMovimiento = dataInfoMov[0];
        String fecha = datosInfoMovimiento[0].toString();
        String totalFact = datosInfoMovimiento[1].toString();
        String detalle = datosInfoMovimiento[2].toString();
        String lugarMov= datosInfoMovimiento[3].toString();
        this.jLabel_Fecha.setText(fecha);
        this.jComboBox_LugarDeMov.setSelectedItem(lugarMov);
        this.jTextField_referencia.setText(detalle);
        BigDecimal totalFacturado = this.StringtoBigDecimal(totalFact);
        this.jFormattedTextField_Total.setValue(totalFacturado);
     
    }

    private void cargarProductosMovimiento() {
        Modelo_verFacturas model = (Modelo_verFacturas)this.jTable_Movimiento.getModel();
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verProductosPorMovimiento(Integer.parseInt(this.jLabel_NumerodeMovimiento.getText()));
        Object[][] ProductosdeMovimiento = AdminBD.getData();
        int numFilas = ProductosdeMovimiento.length;
        for (int row = 0; row < numFilas; row++) {
            model.addRow(1);
            Object[] producto= ProductosdeMovimiento[row];
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
    
     /**
     * Este metodo convierte un string que es un decimal a bigdecimal
     *
     * @param numero
     * @return
     */
    private BigDecimal StringtoBigDecimal(String numero) {
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

    private void imprimirMovimiento(JTable table,String numEntrada, String date, String lugarEntrada, String totalEntrada, String referencia) {
        try {
            String rawCmds = "FIRST NAME";
            String printer = "Generic / Text Only (Copy 3)"; // debe tener 
            //el mismo nombre que la impresora 
            PrintService ps = PrintServiceMatcher.findPrinter(printer);
            if (ps != null) {

                PrintRaw p = new PrintRaw(ps, rawCmds);
                p.clear();
                p.append("\u001B\u0040"); //reset printer 
              

                XMLConfiguracion xml = new XMLConfiguracion();
                String[] infoEmpresa = xml.leerInfoEmpresaXML();
                p.append("\u001B" + "\u0061" + "\u0001" + "\r");//*** Centrado
                p.append(infoEmpresa[0]+"\r\n");
                p.append(infoEmpresa[1]+"\r\n");
                p.append("Tel: "+infoEmpresa[4]+"\r\n");
                p.append("Ced Jur: "+infoEmpresa[3]+"\r\n");
                 if(!infoEmpresa[5].equals("")){
                    p.append(infoEmpresa[5]+"\r\n");
                }
                p.append("\u001B" + "\u0064" + "\u0001" + "\r");//*** 1lineas
                p.append(xml.ObtenerSlogan()+"\r\n");
                p.append("\u001B" + "\u0064" + "\u0001" + "\r");//*** 1lineas
                p.append("\u001B" + "\u0061" + "\u0000" + "\r");//Quita Centrado
                
             

                String fecha = " Fecha     :  " + date + "";
                //p.append("----------------------------------------\r\n");
                String fechamov = this.fill(fecha, 17, " ");
                p.append(fechamov + "\r\n");
                p.append(this.fill(" Num Mov   :  " + numEntrada + "", fechamov.length(), " ") + "\r\n");
                p.append(this.fill(" Lugar     :  " + lugarEntrada + "", fechamov.length(), " ") + "\r\n");
                p.append(this.fill(" Referencia:  " + referencia + "", fechamov.length(), " ") + "\r\n");
           
                //Agrega 1 linea vacia
                p.append("\u001B" + "\u0064" + "\u0001" + "\r");
                p.append("CANT. \t DESCRIPCION \t      TOTAL\r\n");
                p.append("----  ----------------       ------\r\n");

                /**
                 * ********************************************************
                 */
                Modelo_verFacturas dtm = (Modelo_verFacturas) table.getModel();
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

             
                p.append("\u001B" + "\u0061" + "\u0002" + "\r");//*** Derecha
                p.append("\u001B" + "\u0064" + "\u0003" + "\r");//*** 1lineas
                String subto = " T O T A L : \t " + totalEntrada + "";
                String subtoCantidad = this.fill(subto, 35, " ");
                p.append(subtoCantidad + "\r\n");
                p.append("\u001B\u0040");//reset printer
                p.append("\u001B" + "\u0064" + "\u0008" + "\r");//*** 10lineas**/
                p.append("\u001D" + "\u0056" + "\u0001" + "\r");//*** CutPaper
                
               p.print();

            } else {
                System.err.println("No encontro ninguna impresora");
                return ;    }

        } catch (Exception e) {
            e.printStackTrace();
            return;
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
    
}
