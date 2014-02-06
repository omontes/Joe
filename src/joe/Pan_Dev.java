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
public class Pan_Dev extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_Facturacion
     */
    public Pan_Dev() {
        initComponents();
        completarTablaDevoluciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Devoluciones = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(760, 400));
        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Devoluciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTable_Devoluciones);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 350));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel 1/addBtt.png"))); // NOI18N
        jLabel1.setToolTipText("Crear nueva factura");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel 1/editBtt.png"))); // NOI18N
        jLabel2.setToolTipText("Editar factura seleccionada");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel 1/trashBtt.png"))); // NOI18N
        jLabel3.setToolTipText("Borrar factura seleccionada");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel 1/watchBtt.png"))); // NOI18N
        jLabel4.setToolTipText("Ver factura seleccionada");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel 1/printBtt.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void devolverProductos(int NumFact, String detalle) {
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
            this.crearMovimiento(detalle+""+NumFact,precio,1);
            this.guardaProductoEnMovimiento(codArticulo, idVersion, cantidad, precio);
            
            
            
            }
    }
     private void devolverProductosDev(int NumFact, String detalle) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verProductosPorDevolucion(NumFact);
        Object[][] ProductosdeDevolucion = AdminBD.getData();
        int numFilas = ProductosdeDevolucion.length;
        for (int row = 0; row < numFilas; row++) {
            Object[] producto= ProductosdeDevolucion[row];
            String codArticulo= producto[0].toString();
            BigDecimal precio = this.StringtoBigDecimal(producto[3].toString());
            int idVersion = AdminBD.veridVersionActivaProductoPorCodigo(codArticulo);
            int cantidad= Integer.parseInt(producto[2].toString());
            this.crearMovimiento(detalle+""+NumFact,precio,2);
            this.guardaProductoEnMovimiento(codArticulo, idVersion, cantidad, precio);
            
            
            
            }
    }    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //****************** INTERFAZ ***************************************

        Pan_NuevaFactura panelNuevaFact = new Pan_NuevaFactura(Pan_NuevaFactura.DEVOLUCION_CALL);

        JF_Facturacion.getInstance().getPanelManager().showPanel(panelNuevaFact, 800, 474, 0, 0);

        //*******************************************************************
                
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String factura = Integer.toString(AdminBD.ObtenerUltimoidDev() + 1);
        panelNuevaFact.jLabel_NumerodeFact.setText(factura);
        panelNuevaFact.personalizarTablaFactura();
        panelNuevaFact.agregarListenerRenders();
        panelNuevaFact.jFormattedTextField_Cliente.setText("Cliente Generico");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.modificarDev(this.jTable_Devoluciones,"Modifica Devolucion");
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.eliminarDev(this.jTable_Devoluciones,"Eliminacion Devolucion Num ");
        this.completarTablaDevoluciones();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.verDevoluciones(this.jTable_Devoluciones);
    }//GEN-LAST:event_jLabel4MouseClicked
   
    public void verFacturas(JTable table){
        int row = table.getSelectedRow();
        if (row >= 0) {
            VentanaDeInicio mVentana = VentanaDeInicio.getInstance();
            JPanel_VerFactura panelVerFact = new JPanel_VerFactura();
            mVentana.add(panelVerFact);
            panelVerFact.setSize(this.getSize());
            panelVerFact.setLocation(this.getLocation());
            mVentana.remove(this);
            panelVerFact.setVisible(true);
            mVentana.revalidate();
            mVentana.repaint();
            mVentana.setTitle("Ver Factura");
            Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
            panelVerFact.jLabel_NumerodeFact.setText(model.getValueAt(row, 0).toString());
            panelVerFact.personalizarTablaVerFactura();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se selecciono ninguna factura",
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
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JScrollPane jScrollPane5;
    javax.swing.JTable jTable_Devoluciones;
    // End of variables declaration//GEN-END:variables

    private void crearPago(int idFactura, BigDecimal montoDePago, String tipopago) {
       
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int idVersionFacturasProducto = AdminBD.verVersionDEFacturaActiva(idFactura);
        AdminBD.insertarPago(montoDePago,idFactura,idVersionFacturasProducto,tipopago);

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

    private void eliminar(JTable table, String detalle) {
        Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
        int row = table.getSelectedRow();
        String factura = model.getValueAt(row, 0).toString();
        boolean SiSepuedeEliminar = this.verificarCierreFacts(Integer.parseInt(factura));
        if (SiSepuedeEliminar) {
            if (row >= 0) {
                Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
                int numFact = Integer.parseInt(model.getValueAt(row, 0).toString());
                this.devolverProductos(numFact,detalle);
                int idVersion = AdminBD.verVersionDEFacturaActiva(numFact);
                AdminBD.eliminarFactura(numFact, idVersion);

            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna factura",
                        "Alert!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Esta factura no se puede eliminar porque ya pertence a un cierre de caja",
                    "Alert!", JOptionPane.ERROR_MESSAGE);
        }

    }
    private void modificar(JTable table,String tituloVentana) {
        
        int row = table.getSelectedRow();
        Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
        String factura = model.getValueAt(row, 0).toString();
        boolean SiSepuedeModificar = this.verificarCierreFacts(Integer.parseInt(factura));
        if (SiSepuedeModificar) {
            if (row >= 0) {
                VentanaDeInicio mVentana = VentanaDeInicio.getInstance();
                JPanel_CrearFactura panelCreaFact = new JPanel_CrearFactura();
                mVentana.add(panelCreaFact);
                panelCreaFact.setSize(this.getSize());
                panelCreaFact.setLocation(this.getLocation());
                mVentana.remove(this);
                panelCreaFact.setVisible(true);
                mVentana.revalidate();
                mVentana.repaint();
                mVentana.setTitle(tituloVentana);
                panelCreaFact.personalizarTablaFactura();
                panelCreaFact.jLabel_NumerodeFact.setText(factura);
                panelCreaFact.cargarInfoFact();
                panelCreaFact.cargarProductosFact((MyTableModel_FACT) panelCreaFact.jTable_Factura.getModel());
                panelCreaFact.agregarListenerRenders();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna factura",
                        "Alert!", JOptionPane.ERROR_MESSAGE);

            }
        }
        else {
                JOptionPane.showMessageDialog(
                        null,
                        "Esta factura no se puede modificar porque ya pertence a un cierre de caja",
                        "Alert!", JOptionPane.ERROR_MESSAGE);}
    }

    void completarTablaDevoluciones() {
        //Realiza la consulta para obtener los creditos
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verDevoluciones();
        String[] columnNames = AdminBD.getColumnNames();
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_Devoluciones.setModel(new Modelo_Facturacion(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable_Devoluciones.getColumnModel().getColumn(0).setCellRenderer
                (centerRenderer);
    }

    private void verDevoluciones(JTable table) {
         int row = table.getSelectedRow();
            if (row >= 0) {
                //***********************INTERFAZ***************************************
                
                Pan_VerFactura panelVerFact = new Pan_VerFactura();
                JF_Facturacion.getInstance().getPanelManager().showPanel(panelVerFact, 800, 474, 0, 0);
                
                //**********************************************************************
                Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
                panelVerFact.jLabel_NumerodeFact.setText(model.getValueAt(row, 0).toString());
                panelVerFact.personalizarTablaVerDevoluciones();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna devolucion",
                        "Alert!", JOptionPane.ERROR_MESSAGE);
            }
        }

    private void modificarDev(JTable table, String titulo) {
        int row = table.getSelectedRow();
        Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
        String factura = model.getValueAt(row, 0).toString();
        boolean SiSepuedeModificar = this.verificarCierreDevs(Integer.parseInt(factura));
        if (SiSepuedeModificar) {
            if (row >= 0) {
                VentanaDeInicio mVentana = VentanaDeInicio.getInstance();
                JPanel_CrearFactura panelCreaFact = new JPanel_CrearFactura();
                mVentana.add(panelCreaFact);
                panelCreaFact.setSize(this.getSize());
                panelCreaFact.setLocation(this.getLocation());
                mVentana.remove(this);
                panelCreaFact.setVisible(true);
                mVentana.revalidate();
                mVentana.repaint();
                mVentana.setTitle(titulo);
                panelCreaFact.personalizarTablaFactura();
                panelCreaFact.jLabel_NumerodeFact.setText(factura);
                panelCreaFact.cargarInfoDev();
                panelCreaFact.cargarProductosDevolucion();
                panelCreaFact.agregarListenerRenders();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna devolucion",
                        "Alert!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede modificar la devolucion porque ya pertenece a un cierre de caja",
                    "Alert!", JOptionPane.ERROR_MESSAGE);

        }

    }
    
    private void eliminarDev(JTable table, String detalle) {
        int row = table.getSelectedRow();
        Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
        String factura = model.getValueAt(row, 0).toString();
        boolean SiSepuedeModificar = this.verificarCierreDevs(Integer.parseInt(factura));
        if (SiSepuedeModificar) {
            if (row >= 0) {
                Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
                int numFact = Integer.parseInt(model.getValueAt(row, 0).toString());
                this.devolverProductosDev(numFact,detalle);
                int idVersion = AdminBD.verVersionDEDevolucionActiva(numFact);
                AdminBD.eliminarDevolucion(numFact, idVersion);

            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna devolucion",
                        "Alert!", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede eliminar una devolucion que pertence a un cierre de caja",
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

    private boolean verificarCierreDevs(int idDev) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int idCierreVigente= AdminBD.obtenerultimoidCierre();
        String fechaInicio = AdminBD.obtenerFechaInicioCierre(idCierreVigente);
        boolean Sisepuede = AdminBD.verificarDevCierre(fechaInicio,idDev);
        return Sisepuede;
    }
    
}