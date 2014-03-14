/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import db_managment.Direct_Control_BD;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import static joe.Pan_Cred.mensajeNoSeleccion;

/**
 *
 * @author Oscar Montes
 */
public class Pan_Apart extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_Facturacion
     */
    public static String detalleEliminacionApart= "Elimacion Apart";
    public static String clienteGenerico="Cliente Generico";
    public static String mensajeNoSeleccion="No se ha seleccionado ningun apartado";
    public Pan_Apart() {
        initComponents();
        completarTablaApartados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_CrearPago = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_fechaDePago = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton_AceptarPago = new javax.swing.JButton();
        jButton_CancelarPago = new javax.swing.JButton();
        jFormattedTextField_Total = new javax.swing.JFormattedTextField();
        jFormattedTextField_TotalPagado = new javax.swing.JFormattedTextField();
        jFormattedTextField_Saldo = new javax.swing.JFormattedTextField();
        jComboBox_TipodePago = new javax.swing.JComboBox();
        jLabel_numFact = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextField_Abono = new javax.swing.JTextField();
        jDialog_VerPagos = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_VerPagos = new javax.swing.JTable();
        jLabel_numFactVerPagos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextField_saldoPendiente = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField_totalFacturado = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Apartados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jDialog_CrearPago.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jDialog_CrearPago.setMinimumSize(new java.awt.Dimension(342, 352));
        jDialog_CrearPago.setModal(true);
        jDialog_CrearPago.setUndecorated(true);
        jDialog_CrearPago.setResizable(false);
        jDialog_CrearPago.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jDialog_CrearPago.setLocationRelativeTo(null);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(342, 352));
        jPanel2.setPreferredSize(new java.awt.Dimension(342, 352));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Saldo Pendiente");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 25));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Saldo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Abono");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 165, 11));

        jLabel_fechaDePago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_fechaDePago.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_fechaDePago.setText("fecha");
        jPanel2.add(jLabel_fechaDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Pago");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jButton_AceptarPago.setText("Aceptar");
        jButton_AceptarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AceptarPagoActionPerformed(evt);
            }
        });
        jButton_AceptarPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton_AceptarPagoKeyPressed(evt);
            }
        });
        jPanel2.add(jButton_AceptarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        jButton_CancelarPago.setText("Cancelar");
        jButton_CancelarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarPagoActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_CancelarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        jFormattedTextField_Total.setEditable(false);
        jFormattedTextField_Total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_Total.setText("0.00");
        jPanel2.add(jFormattedTextField_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 120, -1));

        jFormattedTextField_TotalPagado.setEditable(false);
        jFormattedTextField_TotalPagado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00;(C#,##0.00)"))));
        jFormattedTextField_TotalPagado.setText("0.00");
        jPanel2.add(jFormattedTextField_TotalPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 120, -1));

        jFormattedTextField_Saldo.setEditable(false);
        jFormattedTextField_Saldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00"))));
        jFormattedTextField_Saldo.setText("0.00");
        jPanel2.add(jFormattedTextField_Saldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 113, -1));

        jComboBox_TipodePago.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Efectivo", "Tarjeta" }));
        jPanel2.add(jComboBox_TipodePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        jLabel_numFact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_numFact.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_numFact.setText("NumFact");
        jPanel2.add(jLabel_numFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 150, 41));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Abono a la factura #");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jFormattedTextField_Abono.setText("0.00");
        jFormattedTextField_Abono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextField_AbonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField_AbonoFocusLost(evt);
            }
        });
        jFormattedTextField_Abono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField_AbonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField_AbonoKeyTyped(evt);
            }
        });
        jPanel2.add(jFormattedTextField_Abono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 120, -1));

        jDialog_CrearPago.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 342, 352));

        jDialog_VerPagos.setMinimumSize(new java.awt.Dimension(330, 390));
        jDialog_VerPagos.setUndecorated(true);
        jDialog_VerPagos.setResizable(false);
        jDialog_VerPagos.setLocationRelativeTo(null);
        jDialog_VerPagos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_VerPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable_VerPagos);

        jDialog_VerPagos.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, 308, 210));

        jLabel_numFactVerPagos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_numFactVerPagos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_numFactVerPagos.setText("705");
        jDialog_VerPagos.getContentPane().add(jLabel_numFactVerPagos, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 11, 120, 22));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Saldo Pendiente");
        jDialog_VerPagos.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 308, -1, -1));

        jFormattedTextField_saldoPendiente.setEditable(false);
        jFormattedTextField_saldoPendiente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00"))));
        jFormattedTextField_saldoPendiente.setText("0.00");
        jDialog_VerPagos.getContentPane().add(jFormattedTextField_saldoPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 308, 126, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Total Facturado");
        jDialog_VerPagos.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 266, 126, -1));

        jFormattedTextField_totalFacturado.setEditable(false);
        jFormattedTextField_totalFacturado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("C#,##0.00"))));
        jFormattedTextField_totalFacturado.setText("0.00");
        jDialog_VerPagos.getContentPane().add(jFormattedTextField_totalFacturado, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 270, 126, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pagos a la factura #");
        jDialog_VerPagos.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDialog_VerPagos.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 348, -1, -1));

        jLabel17.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.setOpaque(true);
        jDialog_VerPagos.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 390));

        setMinimumSize(new java.awt.Dimension(760, 400));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Apartados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable_Apartados);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 350));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/addBtt.png"))); // NOI18N
        jLabel5.setToolTipText("Crear nueva factura");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/editBtt.png"))); // NOI18N
        jLabel11.setToolTipText("Editar factura seleccionada");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/trashBtt.png"))); // NOI18N
        jLabel12.setToolTipText("Borrar factura seleccionada");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/watchBtt.png"))); // NOI18N
        jLabel13.setToolTipText("Ver factura seleccionada");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/bagBtt.png"))); // NOI18N
        jLabel15.setToolTipText("Realizar pago sobre la factura seleccionada");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/listBtt.png"))); // NOI18N
        jLabel16.setToolTipText("Ver pagos sobre la factura seleccionada");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void devolverProductos(int NumFact) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verProductosPorFactura(NumFact);
        Object[][] ProductosdeFactura = AdminBD.getData();
        int numFilas = ProductosdeFactura.length;
        for (int row = 0; row < numFilas; row++) {
            Object[] producto= ProductosdeFactura[row];
            String codArticulo= producto[0].toString();
            BigDecimal precio = this.StringtoBigDecimal(producto[3].toString());
            int idVersion = AdminBD.veridVersionActivaProductoPorCodigo(codArticulo);
            int cantidad= Integer.parseInt(producto[2].toString());
            this.crearMovimiento(detalleEliminacionApart+" "+NumFact,precio,1);
            this.guardaProductoEnMovimiento(codArticulo, idVersion, cantidad, precio);
            
            
            
            }
    }
   
    private void jButton_AceptarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AceptarPagoActionPerformed
         if(this.jFormattedTextField_Abono.getText().equals("")){
            JOptionPane.showMessageDialog(
                          null,
                          "Por favor ingrese un abono",
                          "Alert!", JOptionPane.ERROR_MESSAGE);
            
                this.jFormattedTextField_Abono.requestFocus(true);
                return;
        
        }       
        
        BigDecimal montoDePago = this.StringtoBigDecimal(this.jFormattedTextField_Abono.getText());
        if(montoDePago.compareTo(new BigDecimal("0.00"))>0){
            String tipopago= this.jComboBox_TipodePago.getSelectedItem().toString();
            this.crearPago(Integer.parseInt(this.jLabel_numFact.getText()), montoDePago,tipopago);
            this.jDialog_CrearPago.dispose();
            this.jFormattedTextField_Abono.setText(new BigDecimal("0.00").toString());
            this.jFormattedTextField_Saldo.setValue(new BigDecimal("0.00"));
            this.completarTablaApartados();
        }
        else{
            JOptionPane.showMessageDialog(
                          null,
                          "El abono debe ser mayor que cero",
                          "Alert!", JOptionPane.ERROR_MESSAGE);
            
                this.jFormattedTextField_Abono.requestFocus(true);
        }
        
    }//GEN-LAST:event_jButton_AceptarPagoActionPerformed

    private void jButton_CancelarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarPagoActionPerformed
        this.jDialog_CrearPago.dispose();
        this.jFormattedTextField_Abono.setText(new BigDecimal("0.00").toString());
        this.jFormattedTextField_Saldo.setValue(new BigDecimal("0.00"));
        
    }//GEN-LAST:event_jButton_CancelarPagoActionPerformed

    private void jButton_AceptarPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_AceptarPagoKeyPressed
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            this.jButton_AceptarPago.doClick();
        }
    }//GEN-LAST:event_jButton_AceptarPagoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDialog_VerPagos.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        //****************** INTERFAZ ***************************************

        Pan_NuevaFactura panelNuevaFact = new Pan_NuevaFactura(Pan_NuevaFactura.APARTADO_CALL);

        JF_Facturacion.getInstance().getPanelManager().showPanel(panelNuevaFact, 800, 474, 0, 0);
        JF_Facturacion.getInstance().setEnableTabs(false);

        //*******************************************************************
        
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String factura = Integer.toString(AdminBD.ObtenerUltimoidFact() + 1);
        panelNuevaFact.jLabel_NumerodeFact.setText(factura);
        panelNuevaFact.personalizarTablaFactura();
        panelNuevaFact.agregarListenerRenders();
        panelNuevaFact.jFormattedTextField_Cliente.setText(clienteGenerico);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.modificar(this.jTable_Apartados,Pan_NuevaFactura.MOD_APART_CALL);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.eliminar(this.jTable_Apartados);
        this.completarTablaApartados();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        this.verFacturas(this.jTable_Apartados);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
       int row = this.jTable_Apartados.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(
                    null,
                    mensajeNoSeleccion,
                    "Alert!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BigDecimal saldo = this.StringtoBigDecimal
        (this.jTable_Apartados.getValueAt
        (this.jTable_Apartados.getSelectedRow(),1).toString());
         DocumentFilter onlyNumberFilter = new MyFilter();
            ((AbstractDocument)this.jFormattedTextField_Abono.getDocument())
                    .setDocumentFilter(onlyNumberFilter);
        if (saldo.compareTo(new BigDecimal("0.00")) > 0) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            this.jLabel_fechaDePago.setText(dateFormat.format(date));
            Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();

            int idFact = Integer.parseInt(this.jTable_Apartados.getValueAt(row, 0).toString());
            AdminBD.verInfoFacturaApartado(idFact);
            this.jLabel_numFact.setText(Integer.toString(idFact));
            Object[][] InfoApartados = AdminBD.getData();
            BigDecimal Saldo = this.StringtoBigDecimal(InfoApartados[0][0].toString());
            BigDecimal TotalFacturado = this.StringtoBigDecimal(InfoApartados[0][1].toString());
            this.jFormattedTextField_Total.setValue(TotalFacturado);
            this.jFormattedTextField_TotalPagado.setValue(Saldo);
            this.jFormattedTextField_Saldo.setValue(Saldo);
         
           
                                   
                     
            
            
            this.jDialog_CrearPago.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(
                        null,
                        "Este credito ya esta pago",
                        "Alert!", JOptionPane.ERROR_MESSAGE);
        
        }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int row=this.jTable_Apartados.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(
                        null,
                        mensajeNoSeleccion,
                        "Alert!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idFact = Integer.parseInt
        (this.jTable_Apartados.getValueAt(row,0).toString());
        //Carga los datos a la tabla de ver pagos
        this.cargarVerPagos(idFact);
        // Obtiene la informacion de la factura, total facturado y 
        // el saldo pendiente
        AdminBD.verInfoFacturaApartado(idFact);
        this.jLabel_numFactVerPagos.setText(Integer.toString(idFact));
        Object[][] InfoApartados = AdminBD.getData();
        BigDecimal Saldo = new BigDecimal(InfoApartados[0][0].toString());
        BigDecimal TotalFacturado = new BigDecimal(InfoApartados[0][1].toString());
        this.jFormattedTextField_totalFacturado.setValue(TotalFacturado);
        this.jFormattedTextField_saldoPendiente.setValue(Saldo);
        this.jDialog_VerPagos.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jFormattedTextField_AbonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField_AbonoFocusGained
        this.jFormattedTextField_Abono.selectAll();
    }//GEN-LAST:event_jFormattedTextField_AbonoFocusGained

    private void jFormattedTextField_AbonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField_AbonoFocusLost
        String text = this.jFormattedTextField_Abono.getText();
        if (!text.equals("")) {
            BigDecimal abono = this.StringtoBigDecimal(text);
            BigDecimal total = this.corregirDato(this.jFormattedTextField_TotalPagado.getValue().toString());
            if (abono.compareTo(total) <= 0) {
                this.jFormattedTextField_Saldo.setValue(total.subtract(abono));
            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "El abono debe ser menor o igual que el saldo pendiente",
                    "Alert!", JOptionPane.ERROR_MESSAGE);

                this.jFormattedTextField_Abono.setText(new BigDecimal("0.00").toString());
                this.jFormattedTextField_Saldo.setValue(this.corregirDato(this.jFormattedTextField_TotalPagado.getText()));
                this.jFormattedTextField_Abono.requestFocus(true);
            }

        }
        else{
            this.jFormattedTextField_Saldo.setValue(this.corregirDato(this.jFormattedTextField_TotalPagado.getText()));
        }

    }//GEN-LAST:event_jFormattedTextField_AbonoFocusLost

    private void jFormattedTextField_AbonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_AbonoKeyPressed
        if (evt.isControlDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextField_AbonoKeyPressed

    private void jFormattedTextField_AbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_AbonoKeyTyped
        int tecla = evt.getKeyChar();

        if (tecla == KeyEvent.VK_COMMA) {
            return;
        }
        if (tecla == KeyEvent.VK_PERIOD) {
            return;
        }
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }

        if (KeyEvent.VK_ENTER == evt.getKeyChar()) {
            this.jButton_AceptarPago.requestFocusInWindow();
        }
    }//GEN-LAST:event_jFormattedTextField_AbonoKeyTyped
   
    
     /**
     * Actualiza la tabla que se ve en apartados (Obtiene el total vendido
     * por cada factura y solo muestra las ultimas 100 facturas de apartados)**/
        public void completarTablaApartados() {
         //Realiza la consulta para obtener los apartados
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verApartados();
        String[] columnNames = AdminBD.getColumnNames();
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_Apartados.setModel(new Modelo_Facturacion(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable_Apartados.getColumnModel().getColumn(0).setCellRenderer
                (centerRenderer);
    }
        public void verFacturas(JTable table){
            int row = table.getSelectedRow();
            if (row >= 0) {
                
                //***********************INTERFAZ***************************************
                
                Pan_VerFactura panelVerFact = new Pan_VerFactura();
                JF_Facturacion.getInstance().getPanelManager().showPanel(panelVerFact, 800, 474, 0, 0);
                JF_Facturacion.getInstance().setEnableTabs(false);
                
                //**********************************************************************
                
                panelVerFact.jLabel_NumerodeFact.setText(table.getValueAt(row, 0).toString());
                panelVerFact.personalizarTablaVerFactura();
            } 
            else {
                JOptionPane.showMessageDialog(
                        null,
                        mensajeNoSeleccion,
                        "Alert!", JOptionPane.ERROR_MESSAGE);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton1;
    javax.swing.JButton jButton_AceptarPago;
    javax.swing.JButton jButton_CancelarPago;
    javax.swing.JComboBox jComboBox_TipodePago;
    javax.swing.JDialog jDialog_CrearPago;
    javax.swing.JDialog jDialog_VerPagos;
    javax.swing.JTextField jFormattedTextField_Abono;
    javax.swing.JFormattedTextField jFormattedTextField_Saldo;
    javax.swing.JFormattedTextField jFormattedTextField_Total;
    javax.swing.JFormattedTextField jFormattedTextField_TotalPagado;
    javax.swing.JFormattedTextField jFormattedTextField_saldoPendiente;
    javax.swing.JFormattedTextField jFormattedTextField_totalFacturado;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel15;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel17;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JLabel jLabel_fechaDePago;
    javax.swing.JLabel jLabel_numFact;
    javax.swing.JLabel jLabel_numFactVerPagos;
    javax.swing.JPanel jPanel2;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JTable jTable_Apartados;
    javax.swing.JTable jTable_VerPagos;
    // End of variables declaration//GEN-END:variables

    private void crearPago(int idFactura, BigDecimal montoDePago, String tipopago) {
       
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int idVersionFacturasProducto = AdminBD.verVersionDEFacturaActiva(idFactura);
        AdminBD.insertarPago(montoDePago,idFactura,idVersionFacturasProducto,tipopago);

    }
     /**
     * Este metodo se encarga de llenar la tabla en ver pagos para mostrar los
     * pagos que se le han hecho a la factura selecionada en apartados o creditos
     */
    private void cargarVerPagos(int numFact) {
          //Realiza la consulta para obtener los pagos de apartados o creditos
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verInfoFacturaApartadoPagos(numFact);
        String[] columnNames = {"Fecha de Pago","Monto","Tipo Pago"};
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_VerPagos.setModel(new Modelo_Facturacion(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable_VerPagos.getColumnModel().getColumn(1).setCellRenderer
                (centerRenderer);

    }

    private void crearMovimiento(String detalle, BigDecimal precioProd, int movimiento) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.insertarmovimiento(detalle,movimiento,1,precioProd);
    }
    private void guardaProductoEnMovimiento(String idProducto, int idVersion, int cantidadMov, BigDecimal PrecioVenta) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int idMovimiento= AdminBD.ObtenerUltimoidMovimiento();
        AdminBD.insertarProductoCantidadMovimiento(idProducto,idVersion,idMovimiento,cantidadMov,PrecioVenta);
    }

    private void eliminar(JTable table) {
        int row = table.getSelectedRow();
        if (row <0){

            JOptionPane.showMessageDialog(
                    null,
                    mensajeNoSeleccion,
                    "Alert!", JOptionPane.ERROR_MESSAGE);
            return;

        }
           
        String factura = table.getValueAt(row, 0).toString();
        boolean SiSepuedeEliminar = this.verificarCierreFacts(Integer.parseInt(factura));
        if (SiSepuedeEliminar) {

            Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
            int numFact = Integer.parseInt(table.getValueAt(row, 0).toString());
            this.devolverProductos(numFact);
            int idVersion = AdminBD.verVersionDEFacturaActiva(numFact);
            AdminBD.eliminarFactura(numFact, idVersion);

        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Esta apartado no se puede eliminar porque ya pertence a un cierre de caja",
                    "Alert!", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void modificar(JTable table,int pCallType) {
        
        int row = table.getSelectedRow();
        if (row < 0) {

            JOptionPane.showMessageDialog(
                    null,
                    mensajeNoSeleccion,
                    "Alert!", JOptionPane.ERROR_MESSAGE);
            return;

        }
        String factura = table.getValueAt(row, 0).toString();
        boolean SiSepuedeModificar = this.verificarCierreFacts(Integer.parseInt(factura));
        if (SiSepuedeModificar) {
            
            Pan_NuevaFactura panelModApart = new Pan_NuevaFactura(pCallType);
            
            JF_Facturacion.getInstance().getPanelManager().showPanel(panelModApart, 800, 474, 0, 0);
            JF_Facturacion.getInstance().setEnableTabs(false);
            
            panelModApart.personalizarTablaFactura();
            panelModApart.jLabel_NumerodeFact.setText(factura);
            panelModApart.cargarInfoFact();
            panelModApart.cargarProductosFact((MyTableModel_FACT) panelModApart.jTable_Factura.getModel());
            panelModApart.agregarListenerRenders();


        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Este apartado no se puede modificar porque ya pertence a un cierre de caja",
                    "Alert!", JOptionPane.ERROR_MESSAGE);
        }
    }

   private boolean verificarCierreFacts(int idFact) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int idCierreVigente= AdminBD.obtenerultimoidCierre();
        String fechaInicio = AdminBD.obtenerFechaInicioCierre(idCierreVigente);
        boolean Sisepuede = AdminBD.verificarFacturaCierre(fechaInicio,idFact);
        return Sisepuede;
    }

   
    
}
