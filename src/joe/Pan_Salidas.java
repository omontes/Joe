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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author edward
 */
public final class Pan_Salidas extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_Inventario
     */
    
    private static Pan_Salidas mPanelInventario=null;
    boolean ctrlPressed = false;
    boolean cPressed = false;
        
    public Pan_Salidas() {
        initComponents();
        personalizarTablaSalidaMercaderia();
         
    }
    
    public static Pan_Salidas getInstance(){
        if(mPanelInventario==null)
        {
            mPanelInventario=new Pan_Salidas();
        }
        
        return mPanelInventario;
        
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_SalidasMercaderia = new javax.swing.JTable();
        bttAdd = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(760, 400));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(760, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_SalidasMercaderia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_SalidasMercaderia.setFillsViewportHeight(true);
        jScrollPane4.setViewportView(jTable_SalidasMercaderia);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 350));

        bttAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/addBtt.png"))); // NOI18N
        bttAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttAddMouseClicked(evt);
            }
        });
        add(bttAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/watchBtt.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
           
    private void bttAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttAddMouseClicked

        Pan_CrearEntradaSalida panelCreaSalidaMerca = new Pan_CrearEntradaSalida(Pan_CrearEntradaSalida.SALIDA);
        
        //--------------- INTERFAZ ----------------------------------
        JF_Inventario.getInstance().getPanelManager().showPanel(panelCreaSalidaMerca, 800, 474, 0, 0);
        JF_Inventario.getInstance().setEnableTabs(false);
        
        //-----------------------------------------------------------
        
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String numDoc = Integer.toString(AdminBD.ObtenerUltimoidMovimiento() + 1);
        panelCreaSalidaMerca.jLabel_NumerodeMovimiento.setText(numDoc);
        panelCreaSalidaMerca.jLabel_tipoMovimiento.setText("Salida de:");
        panelCreaSalidaMerca.personalizarTablaMovimiento();
        panelCreaSalidaMerca.agregarListenerRenders();
        panelCreaSalidaMerca.cargarSeleccionadorProductos();
    }//GEN-LAST:event_bttAddMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        this.verSalida(this.jTable_SalidasMercaderia);
    }//GEN-LAST:event_jLabel13MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bttAdd;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_SalidasMercaderia;
    // End of variables declaration//GEN-END:variables

    private void verSalida(JTable table) {
          int row = table.getSelectedRow();
            if (row >= 0) {
                Pan_VerEntradaSalida panelVerMovimientoEntradaSalida = 
                        new Pan_VerEntradaSalida(Pan_VerEntradaSalida.SALIDA_CALL);
                
                //-----------------INTERFAZ----------------------
                JF_Inventario.getInstance().getPanelManager().showPanel(
                        panelVerMovimientoEntradaSalida, 800, 471, 0, 0);
                JF_Inventario.getInstance().setEnableTabs(false);
                //-----------------------------------------------------
                
                
                Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
                panelVerMovimientoEntradaSalida.jLabel_NumerodeMovimiento.setText(model.getValueAt(row, 0).toString());
                panelVerMovimientoEntradaSalida.personalizarTablaVerMovimiento();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna salida de mercaderia",
                        "Alert!", JOptionPane.ERROR_MESSAGE);
            }
    }

    public void personalizarTablaSalidaMercaderia() {
        //Realiza la consulta para obtener los creditos
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verSalidasMercaderia();
        String[] columnNames = AdminBD.getColumnNames();
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_SalidasMercaderia.setModel(new Modelo_Facturacion(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable_SalidasMercaderia.getColumnModel().getColumn(0).setCellRenderer
                (centerRenderer);
    }

    private void agregarBuscador(JTable table, JTextField textfield, int columna) {
         //Crea el ordenador para la tabla generica
        TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>
                (table.getModel());
        table.setRowSorter(ordenador);
        Vector<RowSorter.SortKey> qq = new Vector<RowSorter.SortKey>();
        qq.add(new RowSorter.SortKey(0,SortOrder.ASCENDING));
        ordenador.setSortKeys(qq);
        /**Agrega el listener al JtextField del buscador **/
        textfield.getDocument().addDocumentListener(new
                ListenerBuscador(textfield,ordenador,columna));
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
    
    private void crearMovimiento(String detalle, BigDecimal precioProd, int movimiento) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.insertarmovimiento(detalle,movimiento,1,precioProd);
    }
    
    private void guardaProductoEnMovimiento(String idProducto, int idVersion, int cantidadMov, BigDecimal PrecioVenta) {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        int idMovimiento= AdminBD.ObtenerUltimoidMovimiento();
        AdminBD.insertarProductoCantidadMovimiento(idProducto,idVersion,idMovimiento,cantidadMov,PrecioVenta);
    }


    
}
