/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;

import db_managment.Direct_Control_BD;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class SellerReg extends javax.swing.JFrame {

    private String _seller;
    
    /**
     * Creates new form SellerReg
     */
    public SellerReg() {
        initComponents();
        setLocationRelativeTo(null);
        _seller = "";
        requestFocus();
        requestFocusInWindow();
        sellerCode.requestFocus();
        sellerCode.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sellerCode = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("  Vendedor");
        jLabel1.setOpaque(true);

        jLabel2.setText("Código");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sellerCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sellerCodeKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sellerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sellerCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        aceptAction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sellerCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sellerCodeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){
            aceptAction();
        }
    }//GEN-LAST:event_sellerCodeKeyPressed

    public void aceptAction(){
        if (loadSeller()){
            JF_Facturacion.getInstance().setSellerName(_seller);
            JF_Facturacion.getInstance().getPanelManager().setEnableTop(true);
            setVisible(false);
            setEnabled(false);
        } else {
            sellerCode.requestFocus();
        }
    }
    
    public String getSeller(){
        return _seller;
    }
    
    public void resetFocus() {
        this.toFront();
        requestFocus();
        requestFocusInWindow();
        sellerCode.requestFocus();
        sellerCode.requestFocusInWindow();
    }
    
    public boolean loadSeller(){
        if (String.valueOf(sellerCode.getPassword()).isEmpty()){
            JOptionPane.showMessageDialog(
                this,
                "Por favor ingrese su numero de pase",
                "¡Atención!",
                JOptionPane.WARNING_MESSAGE);
            return false;
        } else {

            int i = String.valueOf(sellerCode.getPassword()).indexOf(' ');
            int length = String.valueOf(sellerCode.getPassword()).length();

            String seller = String.valueOf(sellerCode.getPassword()).substring(0, i);
            String pass = String.valueOf(sellerCode.getPassword()).substring(i+1, length);

            Direct_Control_BD base = db_managment.Direct_Control_BD.getInstance();
            int authentique = base.verificarUsuario(seller, pass);
            if (authentique == 0){
                JOptionPane.showMessageDialog(
                    this,
                    "No se ha podido ingresar. Por favor revise su código.",
                    "¡Error!",
                    JOptionPane.ERROR_MESSAGE);
                sellerCode.setText("");
                return false;
            } else {
                _seller = seller;
                sellerCode.setText("");
                JF_Facturacion.getInstance().setSellerName(seller);
                return true;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField sellerCode;
    // End of variables declaration//GEN-END:variables

}