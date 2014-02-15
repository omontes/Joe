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
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oscar Montes
 */
public class Pan_Fact extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_Facturacion
     */
    public static String detalleEliminacionFact= "Elimacion Fact";
    public static String clienteGenerico="Cliente Generico";
    public static String mensajeNoSeleccion="No se ha seleccionado ninguna factura";
    public Pan_Fact() {
        initComponents();
        completarTablaFacturacion();
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
        jTable_Facturacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(760, 400));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(760, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Facturacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable_Facturacion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/addBtt.png"))); // NOI18N
        jLabel1.setToolTipText("Crear nueva factura");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/editBtt.png"))); // NOI18N
        jLabel2.setToolTipText("Editar factura seleccionada");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/trashBtt.png"))); // NOI18N
        jLabel3.setToolTipText("Borrar factura seleccionada");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/watchBtt.png"))); // NOI18N
        jLabel4.setToolTipText("Ver factura seleccionada");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/regBtt.png"))); // NOI18N
        jLabel6.setToolTipText("Realizar cierre de caja");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/listBtt.png"))); // NOI18N
        jLabel7.setToolTipText("Ver cierres de caja");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void devolverProductos(int NumFact) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verProductosPorFactura(NumFact);
        Object[][] ProductosdeFactura = AdminBD.getData();
        int numFilas = ProductosdeFactura.length;
        for (int row = 0; row < numFilas; row++) {
            Object[] producto= ProductosdeFactura[row];
            String codArticulo= producto[0].toString();
            int cantidadTotal = AdminBD.verCantidadInvGeneral(codArticulo);
            int cantidad= Integer.parseInt(producto[2].toString());
            AdminBD.actualizarCantidadInventario(codArticulo,cantidadTotal+cantidad);
            BigDecimal precio = this.StringtoBigDecimal(producto[3].toString());
            int idVersion = AdminBD.veridVersionActivaProductoPorCodigo(codArticulo);
            this.crearMovimiento(detalleEliminacionFact+" "+NumFact,precio,1);
            this.guardaProductoEnMovimiento(codArticulo, idVersion, cantidad, precio);
            
            
            
            }
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
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //****************** INTERFAZ ***************************************

        Pan_NuevaFactura panelNuevaFact = new Pan_NuevaFactura(Pan_NuevaFactura.FACTURACION_CALL);
        JF_Facturacion.getInstance().getPanelManager().showPanel(panelNuevaFact, 800, 474, 0, 0);
        JF_Facturacion.getInstance().setEnableTabs(false);

        //*******************************************************************

        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String factura = Integer.toString(AdminBD.ObtenerUltimoidFact() + 1);
        panelNuevaFact.jLabel_NumerodeFact.setText(factura);
        panelNuevaFact.personalizarTablaFactura();
        panelNuevaFact.agregarListenerRenders();
        panelNuevaFact.jFormattedTextField_Cliente.setText(clienteGenerico);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.modificar(this.jTable_Facturacion, Pan_NuevaFactura.MOD_FACT_CALL);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.eliminar(this.jTable_Facturacion);
        this.completarTablaFacturacion();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.verFacturas(this.jTable_Facturacion);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Dialog_VerCierre vercierre = new Dialog_VerCierre(this);
        vercierre.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        
        Pan_VerCierresCaja panelVerCierres= new Pan_VerCierresCaja();
        
        JF_Facturacion.getInstance().getPanelManager().showPanel(panelVerCierres, 800, 474, 0, 0);
        JF_Facturacion.getInstance().setEnableTabs(false);
        
        panelVerCierres.completarTablaVerCierres();
    }//GEN-LAST:event_jLabel7MouseClicked
   
    
    /**
     * Actualiza la tabla que se ve en facturacion (Obtiene el total vendido
     * por cada factura y solo muestra las ultimas 100 facturas)**/
    public void completarTablaFacturacion() {
        
        //Realiza la consulta para obtener las facturas
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verFacturas();
        String[] columnNames = AdminBD.getColumnNames();
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_Facturacion.setModel(new Modelo_Facturacion(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER );
        this.jTable_Facturacion.getColumnModel().getColumn(0).setCellRenderer
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
                
                Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
                panelVerFact.jLabel_NumerodeFact.setText(model.getValueAt(row, 0).toString());
                panelVerFact.personalizarTablaVerFactura();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        mensajeNoSeleccion,
                        "Alert!", JOptionPane.ERROR_MESSAGE);
            }
        }
        
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTable_Facturacion;
    // End of variables declaration//GEN-END:variables

    
    private void eliminar(JTable table) {
        
        int row = table.getSelectedRow();
        if (row < 0) {

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
        } 
        else {
            JOptionPane.showMessageDialog(
                    null,
                    "Esta factura no se puede eliminar porque "
                            + "ya pertence a un cierre de caja",
                    "Alert!", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    private void modificar(JTable table, int pCallType) {
        
        int row = table.getSelectedRow();
        
        if (row < 0) {
            JOptionPane.showMessageDialog(
                    null,
                    mensajeNoSeleccion,
                    "Alert!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
        String factura = model.getValueAt(row, 0).toString();
        boolean SiSepuedeModificar = this.verificarCierreFacts(Integer.parseInt(factura));
        if (SiSepuedeModificar) {
            
            Pan_NuevaFactura panelModFact = new Pan_NuevaFactura(pCallType);
            
            //**************INTERFAZ******************************
            JF_Facturacion.getInstance().getPanelManager().showPanel(panelModFact, 800, 474, 0, 0);
            JF_Facturacion.getInstance().setEnableTabs(false);
            //*******************************************************
            
            panelModFact.personalizarTablaFactura();
            panelModFact.jLabel_NumerodeFact.setText(factura);
            panelModFact.cargarInfoFact();
            panelModFact.cargarProductosFact((MyTableModel_FACT) panelModFact.jTable_Factura.getModel());
            panelModFact.agregarListenerRenders();
            
        } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Esta factura no se puede modificar porque ya pertence a un cierre de caja",
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
