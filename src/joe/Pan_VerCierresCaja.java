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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oscar Montes
 */
public class Pan_VerCierresCaja extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_VerCierresCaja
     */
    public Pan_VerCierresCaja() {
        initComponents();
        completarTablaVerCierres();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Cierres = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 471));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(800, 471));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Cierres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Cierres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CierresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Cierres);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 370));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/watchBtt.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cierres de Caja");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/panelVF.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
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
    private void jTable_CierresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CierresMouseClicked
        if (evt.getClickCount() == 2){
        this.verCierre();}
    }//GEN-LAST:event_jTable_CierresMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.verCierre();
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTable_Cierres;
    // End of variables declaration//GEN-END:variables
    public void completarTablaVerCierres() {
        //Realiza la consulta para obtener las facturas
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verCierres();
        String[] columnNames = AdminBD.getColumnNames();
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_Cierres.setModel(new Modelo_VerCierres(columnNames, data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable_Cierres.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    private void verCierre() {
        int row = this.jTable_Cierres.getSelectedRow();
        if (row >= 0) {
            Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
            Modelo_VerCierres model = (Modelo_VerCierres) this.jTable_Cierres.getModel();
            int idCierre = Integer.parseInt(model.getValueAt(row, 0).toString());
            AdminBD.obtenerInfoCierre(idCierre);
            Object[][] InfoCierre = AdminBD.getData();
            BigDecimal totalcont = this.StringtoBigDecimal(InfoCierre[0][0].toString());
            BigDecimal totaltarj = this.StringtoBigDecimal(InfoCierre[0][1].toString());
            BigDecimal totalvent = this.StringtoBigDecimal(InfoCierre[0][2].toString());
            String fechaFinal = InfoCierre[0][3].toString();
            
            
            Pan_CerrarCaja panelCreaCerrarCaja = new Pan_CerrarCaja(Pan_CerrarCaja.WATCH_CALL);
            
            //**************** Interfaz ************
            JF_Facturacion.getInstance().getPanelManager().showPanel(panelCreaCerrarCaja, 800, 471, 0, 0);
            //*************************************
            
            String fechaInicio = AdminBD.obtenerFechaInicioCierre(idCierre);
            String Cajero = AdminBD.obtenerCajeroCierre(idCierre);
            BigDecimal montoinicio = AdminBD.obtenerMontoInicio(idCierre);
            panelCreaCerrarCaja.jLabel_horaCierre.setText(fechaFinal);
            panelCreaCerrarCaja.personalizarTablaCierre(totalcont, totaltarj, totalvent.add(montoinicio), Cajero, fechaInicio, montoinicio);

        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se selecciono ningun cierre",
                    "Alert!", JOptionPane.ERROR_MESSAGE);
        }
    }
}