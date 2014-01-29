/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import db_managment.Direct_Control_BD;
import db_managment.Setting_Up_BD;
import java.awt.Toolkit;
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
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oscar Montes
 */
public class VentanaDeInicio extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    boolean inicioCaja = true;
    private static VentanaDeInicio mVentana;

    private VentanaDeInicio() {
        initComponents();
        this.setVisible(true);
        this.setTitle("Joe");

    }

    public static VentanaDeInicio getInstance() {
        if (mVentana == null) {
            mVentana = new VentanaDeInicio();
        }
        return mVentana;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_InicioCaja = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jButton_aceptarInicioCierre = new javax.swing.JButton();
        jButton_CancelarInicioCierre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField_Cajero = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel_fechaInicioCaja = new javax.swing.JLabel();
        jFormattedTextField_MontoInicioCaja = new javax.swing.JFormattedTextField();
        jPanel_VentanaPrincipal = new javax.swing.JPanel();
        jButton_Facturacion = new javax.swing.JButton();
        jButton_Inventario = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton_Configuracion = new javax.swing.JButton();

        jDialog_InicioCaja.setMinimumSize(new java.awt.Dimension(362, 270));

        jButton_aceptarInicioCierre.setText("Aceptar");
        jButton_aceptarInicioCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptarInicioCierreActionPerformed(evt);
            }
        });
        jButton_aceptarInicioCierre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton_aceptarInicioCierreKeyPressed(evt);
            }
        });

        jButton_CancelarInicioCierre.setText("Cancelar");
        jButton_CancelarInicioCierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelarInicioCierreActionPerformed(evt);
            }
        });

        jLabel1.setText("Monto inicial de Caja");

        jLabel2.setText("Cajero");

        jFormattedTextField_Cajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField_CajeroKeyPressed(evt);
            }
        });

        jLabel3.setText("Fecha de Inicio");

        jLabel_fechaInicioCaja.setText("jLabel_fechaInicioCaja");

        jFormattedTextField_MontoInicioCaja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField_MontoInicioCaja.setText("0.00");
        jFormattedTextField_MontoInicioCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField_MontoInicioCajaMouseClicked(evt);
            }
        });
        jFormattedTextField_MontoInicioCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField_MontoInicioCajaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField_MontoInicioCajaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_fechaInicioCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_MontoInicioCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_Cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jButton_aceptarInicioCierre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_CancelarInicioCierre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_Cajero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jFormattedTextField_MontoInicioCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel_fechaInicioCaja))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_CancelarInicioCierre)
                    .addComponent(jButton_aceptarInicioCierre))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout jDialog_InicioCajaLayout = new javax.swing.GroupLayout(jDialog_InicioCaja.getContentPane());
        jDialog_InicioCaja.getContentPane().setLayout(jDialog_InicioCajaLayout);
        jDialog_InicioCajaLayout.setHorizontalGroup(
            jDialog_InicioCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog_InicioCajaLayout.setVerticalGroup(
            jDialog_InicioCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_VentanaPrincipal.setPreferredSize(new java.awt.Dimension(874, 418));

        jButton_Facturacion.setText("Facturacion");
        jButton_Facturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FacturacionActionPerformed(evt);
            }
        });

        jButton_Inventario.setText("Inventario");
        jButton_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InventarioActionPerformed(evt);
            }
        });

        jButton1.setText("Reportes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clientes y Vendedores");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton_Configuracion.setText("Configuración");
        jButton_Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_VentanaPrincipalLayout = new javax.swing.GroupLayout(jPanel_VentanaPrincipal);
        jPanel_VentanaPrincipal.setLayout(jPanel_VentanaPrincipalLayout);
        jPanel_VentanaPrincipalLayout.setHorizontalGroup(
            jPanel_VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VentanaPrincipalLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel_VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Facturacion, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButton_Inventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89)
                .addGroup(jPanel_VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                .addGap(88, 88, 88)
                .addComponent(jButton_Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel_VentanaPrincipalLayout.setVerticalGroup(
            jPanel_VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_VentanaPrincipalLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel_VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel_VentanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Configuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel_VentanaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel_VentanaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_FacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FacturacionActionPerformed
        if (inicioCaja) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String fecha = dateFormat.format(date);
            this.jLabel_fechaInicioCaja.setText(fecha);
            this.jDialog_InicioCaja.setVisible(true);
            return;

        }
        this.verFacturacion();


    }//GEN-LAST:event_jButton_FacturacionActionPerformed

    private void jButton_InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InventarioActionPerformed
        JPanel_Inventario panelInventario = JPanel_Inventario.getInstance();
        this.add(panelInventario);
        panelInventario.setSize(jPanel_VentanaPrincipal.getSize());
        panelInventario.setLocation(jPanel_VentanaPrincipal.getLocation());
        this.jPanel_VentanaPrincipal.setVisible(false);
        panelInventario.setVisible(true);

    }//GEN-LAST:event_jButton_InventarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JPanel_Reportes panelReportes = JPanel_Reportes.getInstance();
        add(panelReportes);
        panelReportes.setSize(jPanel_VentanaPrincipal.getSize());
        panelReportes.setLocation(jPanel_VentanaPrincipal.getLocation());
        jPanel_VentanaPrincipal.setVisible(false);
        panelReportes.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_aceptarInicioCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aceptarInicioCierreActionPerformed
        this.crearCierreCaja();
        this.remove(this.jDialog_InicioCaja);
        this.jDialog_InicioCaja.dispose();
        this.jFormattedTextField_MontoInicioCaja.setValue(new BigDecimal("0.00"));
        this.jFormattedTextField_Cajero.setText("");
        this.verFacturacion();
    }//GEN-LAST:event_jButton_aceptarInicioCierreActionPerformed

    private void jButton_CancelarInicioCierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelarInicioCierreActionPerformed
        this.jDialog_InicioCaja.dispose();
        this.jFormattedTextField_MontoInicioCaja.setValue(new BigDecimal("0.00"));
        this.jFormattedTextField_Cajero.setText("");
    }//GEN-LAST:event_jButton_CancelarInicioCierreActionPerformed

    private void jFormattedTextField_MontoInicioCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField_MontoInicioCajaMouseClicked
        this.jFormattedTextField_MontoInicioCaja.selectAll();
    }//GEN-LAST:event_jFormattedTextField_MontoInicioCajaMouseClicked

    private void jFormattedTextField_MontoInicioCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_MontoInicioCajaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.jFormattedTextField_MontoInicioCaja.transferFocus();

        }
        if (evt.isControlDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextField_MontoInicioCajaKeyPressed

    private void jFormattedTextField_MontoInicioCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_MontoInicioCajaKeyTyped
        int tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_COMMA) {
            return;
        }
        if (tecla == KeyEvent.VK_PERIOD) {
            return;
        };
        if (!Character.isDigit(tecla) & !Character.isISOControl(
                evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextField_MontoInicioCajaKeyTyped

    private void jFormattedTextField_CajeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_CajeroKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.jFormattedTextField_Cajero.transferFocus();
        }
    }//GEN-LAST:event_jFormattedTextField_CajeroKeyPressed

    private void jButton_aceptarInicioCierreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton_aceptarInicioCierreKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.jButton_aceptarInicioCierre.doClick();
        }
    }//GEN-LAST:event_jButton_aceptarInicioCierreKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        NewJPanel_Clientes panelClienteVendedor = new NewJPanel_Clientes();
        add(panelClienteVendedor);
        panelClienteVendedor.setSize(this.getSize());
        jPanel_VentanaPrincipal.setVisible(false);
        panelClienteVendedor.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton_ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConfiguracionActionPerformed
        NewJPanel_Configuracion panelConfiguracion = new NewJPanel_Configuracion();
        add(panelConfiguracion);
        panelConfiguracion.setSize(this.getSize());
        jPanel_VentanaPrincipal.setVisible(false);
        panelConfiguracion.setVisible(true);
    }//GEN-LAST:event_jButton_ConfiguracionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_CancelarInicioCierre;
    private javax.swing.JButton jButton_Configuracion;
    private javax.swing.JButton jButton_Facturacion;
    private javax.swing.JButton jButton_Inventario;
    private javax.swing.JButton jButton_aceptarInicioCierre;
    private javax.swing.JDialog jDialog_InicioCaja;
    private javax.swing.JFormattedTextField jFormattedTextField_Cajero;
    private javax.swing.JFormattedTextField jFormattedTextField_MontoInicioCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_fechaInicioCaja;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel_VentanaPrincipal;
    // End of variables declaration//GEN-END:variables

    private void verFacturacion() {
        JPanel_Facturacion panelFacturacion = new JPanel_Facturacion();
        mVentana.add(panelFacturacion);
        panelFacturacion.setSize(this.jPanel_VentanaPrincipal.getSize());
        panelFacturacion.setLocation(this.jPanel_VentanaPrincipal.getLocation());
        mVentana.remove(this.jPanel_VentanaPrincipal);
        panelFacturacion.setVisible(true);
        mVentana.revalidate();
        mVentana.repaint();
        mVentana.setTitle("Facturacion");
        panelFacturacion.completarTablaFacturacion();
        panelFacturacion.completarTablaApartados();
        panelFacturacion.completarTablaCreditos();
        panelFacturacion.completarTablaDevoluciones();
    }

    private void crearCierreCaja() {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String fecha = this.jLabel_fechaInicioCaja.getText();
        String Cajero = this.jFormattedTextField_Cajero.getText();

        Object montoInicio = this.jFormattedTextField_MontoInicioCaja.getValue();
        BigDecimal reporteInicio = new BigDecimal(montoInicio != null ? montoInicio.toString() : "0");
        AdminBD.insertarCierreDeCaja(fecha, Cajero, reporteInicio);
    }

}
