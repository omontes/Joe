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
public class JF_Conf extends javax.swing.JFrame {

    private static final int EMPR_CONF = 0;
    private static final int USSER_CONF = 1;
    
    private Pan_ConfEmpr _panEmpr;
    private Pan_ConfUsser _panUsser;
    
    private int _activePanel;
    
    /**
     * Creates new form JF_Conf
     */
    public JF_Conf() {
        initComponents();
        startComponents();
        setLocation(StartWindow.getPosX(), StartWindow.getPosY());
        labUsuario.setText(ManejoDeArchivos.XMLConfiguracion.getInstance().ObtenerUsuario());
        _activePanel = EMPR_CONF;
    }

    private void startComponents(){
        _panEmpr = new Pan_ConfEmpr();
        _panEmpr.setSize(760, 400);
        _panEmpr.setLocation(20, 60);
        jLayeredPane1.add(_panEmpr, 0);
        _panEmpr.setVisible(true);
        _panEmpr.setEnabled(true);
        
        _panUsser = new Pan_ConfUsser();
        _panUsser.setSize(760, 400);
        _panUsser.setLocation(20, 60);
        jLayeredPane1.add(_panUsser, 0);
        _panUsser.setVisible(false);
        _panUsser.setEnabled(false);
    }
    
    private void changeTab(){
        if (_activePanel == EMPR_CONF){
            bttEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/empresaBttDct.png")));
            bttUsser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/PanelConfAct.png")));
            
            _panEmpr.setVisible(false);
            _panEmpr.setEnabled(false);
            
            _panUsser.setEnabled(true);
            _panUsser.setVisible(true);
            
            _activePanel = USSER_CONF;
            
        } else {
            bttEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/empresaBttAct.png")));
            bttUsser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/PanelConfDct.png")));
            
            _panEmpr.setVisible(true);
            _panEmpr.setEnabled(true);
            
            _panUsser.setEnabled(false);
            _panUsser.setVisible(false);
            
            _activePanel = EMPR_CONF;
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
        bttUsser = new javax.swing.JLabel();
        labUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bttEmpresa = new javax.swing.JLabel();
        bkg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(800, 500));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(800, 500));

        bttUsser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/PanelConfDct.png"))); // NOI18N
        bttUsser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttUsserMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttUsser);
        bttUsser.setBounds(130, 10, 142, 33);

        labUsuario.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        labUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labUsuario.setText("Nombre de Usuario Aquí - Cargo");
        jLayeredPane1.add(labUsuario);
        labUsuario.setBounds(80, 480, 540, 17);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/atras.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(725, 471, 65, 29);

        bttEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/empresaBttAct.png"))); // NOI18N
        bttEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttEmpresaMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttEmpresa);
        bttEmpresa.setBounds(0, 10, 142, 33);

        bkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelConf/bkg.png"))); // NOI18N
        jLayeredPane1.add(bkg);
        bkg.setBounds(0, 0, 800, 500);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        StartWindow.getInstance().enableMe();
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void bttEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttEmpresaMouseClicked
        if (_activePanel != EMPR_CONF){
            changeTab();
        }
    }//GEN-LAST:event_bttEmpresaMouseClicked

    private void bttUsserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttUsserMouseClicked
        if (_activePanel != USSER_CONF){
            changeTab();
        }
    }//GEN-LAST:event_bttUsserMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bkg;
    private javax.swing.JLabel bttEmpresa;
    private javax.swing.JLabel bttUsser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel labUsuario;
    // End of variables declaration//GEN-END:variables
}
