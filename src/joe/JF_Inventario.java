/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

/**
 *
 * @author Joseph
 */
public class JF_Inventario extends javax.swing.JFrame {
    
    private final int INVENTARIO    = 0;
    private final int ENTRADAS      = 1;
    private final int SALIDAS       = 2;
    private final int BODEGA        = 3;
    private final int MOVIMIENTOS   = 4;
    
    private static JF_Inventario _instance = null;
    
    private int _activeTab;
    private PanelManager _panelManager;
    
    private Pan_Inventario _panInventario;
    private Pan_Entradas _panEntradas;
    private Pan_Salidas _panSalidas;
    private Pan_Bodega _panBodega;
    private Pan_Movimientos _panMovimientos;
            
            
    /**
     * Creates new form JF_Inventario
     */
    public JF_Inventario() {
        _instance = this;       
        
        initComponents();
        setLocation(StartWindow.getPosX(), StartWindow.getPosY());
        _panelManager = new PanelManager(jLayeredPane1);
        
        labUsuario.setText(ManejoDeArchivos.XMLConfiguracion.getInstance().ObtenerUsuario());
        
        startComponents();
        
        _activeTab = 0;
    }
    
    public void refreshActiveTable(){
        if (_activeTab == INVENTARIO){
            _panInventario.personalizarTablaInventario();
        } else if (_activeTab == ENTRADAS){
            _panEntradas.personalizarTablaEntradaMercaderia();
            this.revalidate();
            this.repaint();
        } else if (_activeTab == SALIDAS){
            _panSalidas.personalizarTablaSalidaMercaderia();
        } else if (_activeTab == BODEGA){
            _panBodega.personalizarTablaBodega();
        } else {
            _panMovimientos.personalizarTablaVerMovimientos();
        }
    }
    
    public void setEnableTabs(boolean pAreEnable){
        if (pAreEnable){
            bttSalidas.setEnabled(true);
            bttBodega.setEnabled(true);
            bttInventario.setEnabled(true);
            bttMovimientos.setEnabled(true);
            
            bttSalidas.setVisible(true);
            bttBodega.setVisible(true);
            bttInventario.setVisible(true);
            bttMovimientos.setVisible(true);
            
        } else {
            bttSalidas.setVisible(false);
            bttBodega.setVisible(false);
            bttInventario.setVisible(false);
            bttMovimientos.setVisible(false);
            
            bttSalidas.setEnabled(false);
            bttBodega.setEnabled(false);
            bttInventario.setEnabled(false);
            bttMovimientos.setEnabled(false);
        }
    }
    
    private void startComponents(){
        _panInventario = new Pan_Inventario();
        _panInventario.setSize(760, 400);
        _panInventario.setLocation(20, 60);
        _panelManager.showPanel(_panInventario);
        
        _panSalidas = new Pan_Salidas();
        _panSalidas.setSize(760, 400);
        _panSalidas.setLocation(20, 60);
        _panelManager.addPanelToPane(_panSalidas);
        
        _panEntradas = new Pan_Entradas();
        _panEntradas.setSize(760, 400);
        _panEntradas.setLocation(20, 60);
        _panelManager.addPanelToPane(_panEntradas);
        
        _panBodega = new Pan_Bodega();
        _panBodega.setSize(760, 400);
        _panBodega.setLocation(20, 60);
        _panelManager.addPanelToPane(_panBodega);
        
        _panMovimientos = new Pan_Movimientos();
        _panMovimientos.setSize(760, 400);
        _panMovimientos.setLocation(20, 60);
        _panelManager.addPanelToPane(_panMovimientos);
    }
    
    public static JF_Inventario getInstance(){
        return _instance;
    }
    
    public PanelManager getPanelManager(){
        return _panelManager;
    }
    
    private void changeTab(int pTab){
        //Ocultar pestaña activa
        if (_activeTab == INVENTARIO){
            bttInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/inventarioBttDct.png")));
        } else if (_activeTab == ENTRADAS){
            bttEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/entradasBttDct.png")));
        } else if (_activeTab == SALIDAS){
            bttSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/salidasBttDct.png")));
        } else if (_activeTab == BODEGA){
            bttBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/bodegaBttDct.png")));
        } else if (_activeTab == MOVIMIENTOS){
            bttMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/movimientosBttDct.png")));
        }
        
        //Activar pestaña
        if (pTab == INVENTARIO){
            bttInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/inventarioBttAct.png")));
            _panelManager.changeStartPanel(_panInventario);
        } else if (pTab == ENTRADAS){
            bttEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/entradasBttAct.png")));
            _panelManager.changeStartPanel(_panEntradas);
        } else if (pTab == SALIDAS){
            bttSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/salidasBttAct.png")));
            _panelManager.changeStartPanel(_panSalidas);
        } else if (pTab == BODEGA){
            bttBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/bodegaBttAct.png")));
            _panelManager.changeStartPanel(_panBodega);
        } else if (pTab == MOVIMIENTOS){
            bttMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/movimientosBttAct.png")));
            _panelManager.changeStartPanel(_panMovimientos);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        bttInventario = new javax.swing.JLabel();
        bttEntradas = new javax.swing.JLabel();
        bttSalidas = new javax.swing.JLabel();
        bttBodega = new javax.swing.JLabel();
        bttMovimientos = new javax.swing.JLabel();
        labUsuario = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        bk = new javax.swing.JLabel();
        bkColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bttInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/inventarioBttAct.png"))); // NOI18N
        bttInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttInventarioMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttInventario);
        bttInventario.setBounds(0, 11, 143, 31);

        bttEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/entradasBttDct.png"))); // NOI18N
        bttEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttEntradasMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttEntradas);
        bttEntradas.setBounds(144, 11, 130, 31);

        bttSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/salidasBttDct.png"))); // NOI18N
        bttSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttSalidasMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttSalidas);
        bttSalidas.setBounds(270, 11, 123, 31);

        bttBodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/bodegaBttDct.png"))); // NOI18N
        bttBodega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttBodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttBodegaMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttBodega);
        bttBodega.setBounds(392, 11, 120, 31);

        bttMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/movimientosBttDct.png"))); // NOI18N
        bttMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttMovimientosMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttMovimientos);
        bttMovimientos.setBounds(512, 11, 172, 31);

        labUsuario.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        labUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labUsuario.setText("Nombre de Usuario Aquí - Cargo");
        jLayeredPane1.add(labUsuario);
        labUsuario.setBounds(80, 480, 630, 17);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/atras.png"))); // NOI18N
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        jLayeredPane1.add(back);
        back.setBounds(725, 471, 65, 29);

        bk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel2/panel2.png"))); // NOI18N
        jLayeredPane1.add(bk);
        bk.setBounds(0, 0, 800, 500);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        bkColor.setBackground(new java.awt.Color(153, 153, 153));
        bkColor.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        bkColor.setMinimumSize(new java.awt.Dimension(800, 500));
        bkColor.setOpaque(true);
        bkColor.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(bkColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttInventarioMouseClicked
        if (_activeTab != INVENTARIO){
            changeTab(INVENTARIO);
            _activeTab = INVENTARIO;
        }
    }//GEN-LAST:event_bttInventarioMouseClicked

    private void bttEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttEntradasMouseClicked
        if (_activeTab != ENTRADAS){
            changeTab(ENTRADAS);
            _activeTab = ENTRADAS;
        }
    }//GEN-LAST:event_bttEntradasMouseClicked

    private void bttSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttSalidasMouseClicked
        if (_activeTab != SALIDAS){
            changeTab(SALIDAS);
            _activeTab = SALIDAS;
        }
    }//GEN-LAST:event_bttSalidasMouseClicked

    private void bttBodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttBodegaMouseClicked
        if (_activeTab != BODEGA){
            changeTab(BODEGA);
            _activeTab = BODEGA;
        }
    }//GEN-LAST:event_bttBodegaMouseClicked

    private void bttMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttMovimientosMouseClicked
        if (_activeTab != MOVIMIENTOS){
            changeTab(MOVIMIENTOS);
            _activeTab = MOVIMIENTOS;
        }
    }//GEN-LAST:event_bttMovimientosMouseClicked

    public void backOnWindow(){
        Object newPanel = _panelManager.back();
        if (newPanel == null){
            StartWindow.getInstance().enableMe();
            this.dispose();            
        }
        if (_panelManager.getPanelCount() == 1){
            setEnableTabs(true);
        }
}
    
    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        backOnWindow();
    }//GEN-LAST:event_backMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        StartWindow.getInstance().enableMe();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JLabel bk;
    private javax.swing.JLabel bkColor;
    private javax.swing.JLabel bttBodega;
    private javax.swing.JLabel bttEntradas;
    private javax.swing.JLabel bttInventario;
    private javax.swing.JLabel bttMovimientos;
    private javax.swing.JLabel bttSalidas;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel labUsuario;
    // End of variables declaration//GEN-END:variables
}
