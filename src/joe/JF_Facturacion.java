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
public class JF_Facturacion extends javax.swing.JFrame {
    
    //Varibales que permitirán saber la ubicación del panel, etc
    public static final int FACT_PANEL = 0;
    public static final int APART_PANEL = 1;
    public static final int CRED_PANEL = 2;
    public static final int DEV_PANEL = 3;
    
    private Pan_Fact _panFact;
    private Pan_Cred _panCred;
    private Pan_Dev _panDev;
    private Pan_Apart _panApart;
    
    private int _activePanel;
    private final PanelManager _panelManager;

    private static JF_Facturacion _instance = null;
    
    private void startComponents(){
        
        _panFact = new Pan_Fact();
        _panFact.setSize(760, 400);
        _panFact.setLocation(20, 60);
        _panelManager.showPanel(_panFact);
        
        _panCred = new Pan_Cred();
        _panCred.setSize(760, 400);
        _panCred.setLocation(20, 60);
        _panelManager.addPanelToPane(_panCred);
        
        _panDev = new Pan_Dev();
        _panDev.setSize(760, 400);
        _panDev.setLocation(20, 60);
        _panelManager.addPanelToPane(_panDev);
        
        _panApart = new Pan_Apart();
        _panApart.setSize(760, 400);
        _panApart.setLocation(20, 60);
        _panelManager.addPanelToPane(_panApart);
    }
    
    public void refreshActiveTable(){
        refreshPanelTable(_activePanel);
    }
    
    public void setEnableTabs(boolean pAreEnalble){
        if (pAreEnalble){
            bttFact.setEnabled(true);
            bttDev.setEnabled(true);
            bttCred.setEnabled(true);
            bttApart.setEnabled(true);
            
            bttFact.setVisible(true);
            bttDev.setVisible(true);
            bttCred.setVisible(true);
            bttApart.setVisible(true);
        } else {
            
            bttFact.setVisible(false);
            bttDev.setVisible(false);
            bttCred.setVisible(false);
            bttApart.setVisible(false);
            
            bttFact.setEnabled(false);
            bttDev.setEnabled(false);
            bttCred.setEnabled(false);
            bttApart.setEnabled(false);
        }
    }
    
    public void refreshPanelTable(int pPanel){
        if (pPanel == FACT_PANEL){
            _panFact.completarTablaFacturacion();
        } else if (pPanel == APART_PANEL){
            _panApart.completarTablaApartados();
        } else if (pPanel == DEV_PANEL){
            _panDev.completarTablaDevoluciones();
        } else if (pPanel == CRED_PANEL){
            _panCred.completarTablaCreditos();
        }
    }
    
    public static JF_Facturacion getInstance(){
        return _instance;
    }
    
    public PanelManager getPanelManager(){
        return _panelManager;
    }
    
    public int getActivePanel(){
        return _activePanel;
    }
    
    /**
     * Creates new form JF_Facturacion
     */
    public JF_Facturacion() {
        //this.setUndecorated(true);
        
        _instance = this;
        
        initComponents();
        _panelManager = new PanelManager(jLayeredPane1);
        startComponents();
        labUsuario.setText(ManejoDeArchivos.XMLConfiguracion.getInstance().ObtenerUsuario());
        setLocation(StartWindow.getPosX(), StartWindow.getPosY());
        _activePanel = FACT_PANEL;        
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
        labUsuario = new javax.swing.JLabel();
        bttAtras = new javax.swing.JLabel();
        bttCred = new javax.swing.JLabel();
        bttDev = new javax.swing.JLabel();
        bttApart = new javax.swing.JLabel();
        bttFact = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bkColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nombre de la empresa - Facturación");
        setBackground(new java.awt.Color(51, 255, 102));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labUsuario.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        labUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labUsuario.setText("Nombre de Usuario Aquí - Cargo");
        jLayeredPane1.add(labUsuario);
        labUsuario.setBounds(80, 480, 590, 15);

        bttAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/atras.png"))); // NOI18N
        bttAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttAtrasMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttAtras);
        bttAtras.setBounds(726, 471, 79, 29);

        bttCred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaCreditos.png"))); // NOI18N
        bttCred.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttCred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttCredMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttCred);
        bttCred.setBounds(310, 10, 132, 32);

        bttDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaDevoluciones.png"))); // NOI18N
        bttDev.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttDev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttDevMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttDev);
        bttDev.setBounds(440, 11, 179, 32);

        bttApart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaApartados.png"))); // NOI18N
        bttApart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttApart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttApartMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttApart);
        bttApart.setBounds(165, 11, 147, 31);

        bttFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttActFacturacion.png"))); // NOI18N
        bttFact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttFact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttFactMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttFact);
        bttFact.setBounds(0, 10, 165, 32);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/panelF.png"))); // NOI18N
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        bkColor.setBackground(new java.awt.Color(153, 153, 153));
        bkColor.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        bkColor.setMinimumSize(new java.awt.Dimension(800, 500));
        bkColor.setOpaque(true);
        bkColor.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(bkColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttFactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttFactMouseClicked
        if (_activePanel != FACT_PANEL){
            changeTab(FACT_PANEL);
            _activePanel = FACT_PANEL;
        }
    }//GEN-LAST:event_bttFactMouseClicked

    private void bttApartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttApartMouseClicked
        if (_activePanel != APART_PANEL){
            changeTab(APART_PANEL);
            _activePanel = APART_PANEL;
        }
    }//GEN-LAST:event_bttApartMouseClicked

    private void bttCredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCredMouseClicked
        if (_activePanel != CRED_PANEL){
            changeTab(CRED_PANEL);
            _activePanel = CRED_PANEL;
        }
    }//GEN-LAST:event_bttCredMouseClicked

    private void bttDevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttDevMouseClicked
        if (_activePanel != DEV_PANEL){
            changeTab(DEV_PANEL);
            _activePanel = DEV_PANEL;
        }
    }//GEN-LAST:event_bttDevMouseClicked

    public void backOnWindow(){
        Object newPanel = _panelManager.back();
        if (newPanel == null){
            StartWindow.getInstance().enableMe();
            this.dispose();            
        }
        System.out.println(_panelManager.getPanelCount());
        if (_panelManager.getPanelCount() == 1){
            setEnableTabs(true);
        }
    }
    
    private void bttAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttAtrasMouseClicked
        backOnWindow();
    }//GEN-LAST:event_bttAtrasMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        StartWindow.getInstance().enableMe();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    
    private void changeTab(int pPanel){
        //Quitar pestaña activa
        if (_activePanel == FACT_PANEL){
            bttFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaFacturacion.png")));
        } else if (_activePanel == CRED_PANEL){
            bttCred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaCreditos.png")));
        } else if (_activePanel == APART_PANEL){
            bttApart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaApartados.png")));
        } else {
            bttDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttDaDevoluciones.png")));
        }
        
        //Activar pestaña correcta y cambiar panel
        if (pPanel == FACT_PANEL){
            bttFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttActFacturacion.png")));
            _panelManager.changeStartPanel(_panFact);
        } else if (pPanel == CRED_PANEL){
            bttCred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttActCreditos.png")));
            _panelManager.changeStartPanel(_panCred);
        } else if (pPanel == APART_PANEL){
            bttApart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttActApartados.png")));
            _panelManager.changeStartPanel(_panApart);
        } else {
            bttDev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Panel1/bttActDevoluciones.png")));
            _panelManager.changeStartPanel(_panDev);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bkColor;
    private javax.swing.JLabel bttApart;
    private javax.swing.JLabel bttAtras;
    private javax.swing.JLabel bttCred;
    private javax.swing.JLabel bttDev;
    private javax.swing.JLabel bttFact;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel labUsuario;
    // End of variables declaration//GEN-END:variables
}
