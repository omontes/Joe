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
 * @author edward
 */
public final class Pan_Entradas extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_Inventario
     */
    
    private static Pan_Entradas mPanelInventario=null;
    boolean ctrlPressed = false;
    boolean cPressed = false;
        
    public Pan_Entradas() {
        initComponents();
        
        personalizarTablaEntradaMercaderia();
         
    }
    
    public static Pan_Entradas getInstance(){
        if(mPanelInventario==null)
        {
            mPanelInventario=new Pan_Entradas();
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_EntradasMercaderia = new javax.swing.JTable();
        bttAdd = new javax.swing.JLabel();
        bttWatch = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(760, 400));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(760, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_EntradasMercaderia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_EntradasMercaderia.setFillsViewportHeight(true);
        jScrollPane3.setViewportView(jTable_EntradasMercaderia);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 350));

        bttAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/addBtt.png"))); // NOI18N
        bttAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttAddMouseClicked(evt);
            }
        });
        add(bttAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        bttWatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/watchBtt.png"))); // NOI18N
        bttWatch.setToolTipText("");
        bttWatch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttWatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttWatchMouseClicked(evt);
            }
        });
        add(bttWatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
               
public void personalizarTablaEntradaMercaderia(){
     //Realiza la consulta para obtener los creditos
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        AdminBD.verEntradasMercaderia();
        String[] columnNames = AdminBD.getColumnNames();
        Object[][] data = AdminBD.getData();
        //Crea la tabla generica para Facturas
        this.jTable_EntradasMercaderia.setModel(new Modelo_Facturacion(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        this.jTable_EntradasMercaderia.getColumnModel().getColumn(0).setCellRenderer
                (centerRenderer);
        
    }
    private void bttAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttAddMouseClicked
        
        
        Pan_CrearEntradaSalida panelCreaEntradaMerca = new Pan_CrearEntradaSalida(Pan_CrearEntradaSalida.ENTRADA);
        
        //--------------- INTERFAZ ----------------------------------
        
        JF_Inventario.getInstance().getPanelManager().showPanel(panelCreaEntradaMerca, 800, 474, 0, 0);
        
        //-----------------------------------------------------------
        
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String numDoc = Integer.toString(AdminBD.ObtenerUltimoidMovimiento() + 1);
        panelCreaEntradaMerca.jLabel_NumerodeMovimiento.setText(numDoc);
        panelCreaEntradaMerca.personalizarTablaMovimiento();
        panelCreaEntradaMerca.agregarListenerRenders();
        panelCreaEntradaMerca.cargarSeleccionadorProductos();
    }//GEN-LAST:event_bttAddMouseClicked

    private void bttWatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttWatchMouseClicked
        this.verEntrada(this.jTable_EntradasMercaderia);
    }//GEN-LAST:event_bttWatchMouseClicked

//String idProducto, String nombre, int precio,
            //int costo, String fechaCreacion, String estado, String Descripcion,
            //int idCategoria

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bttAdd;
    private javax.swing.JLabel bttWatch;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_EntradasMercaderia;
    // End of variables declaration//GEN-END:variables

    private void verEntrada(JTable table) {
          int row = table.getSelectedRow();
            if (row >= 0) {
                
                Pan_VerEntradaSalida panelVerMovimientoEntradaSalida = 
                        new Pan_VerEntradaSalida(Pan_VerEntradaSalida.ENTRADA_CALL);
                
                //-----------------INTERFAZ----------------------
                JF_Inventario.getInstance().getPanelManager().showPanel(
                        panelVerMovimientoEntradaSalida, 800, 471, 0, 0);
                //-----------------------------------------------------
                
                Modelo_Facturacion model = (Modelo_Facturacion) table.getModel();
                panelVerMovimientoEntradaSalida.jLabel_NumerodeMovimiento.setText(model.getValueAt(row, 0).toString());
                panelVerMovimientoEntradaSalida.personalizarTablaVerMovimiento();
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "No se selecciono ninguna entrada de mercaderia",
                        "Alert!", JOptionPane.ERROR_MESSAGE);
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
    
}
