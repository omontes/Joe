/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import db_managment.Direct_Control_BD;
import java.util.Vector;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jason
 */
public class NewJPanel_Configuracion extends javax.swing.JPanel {
    private Direct_Control_BD AdminBD;
    private Object[][] data;

    /**
     * Creates new form NewJPanel_Configuracion
     */
    public NewJPanel_Configuracion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_empresaUsuario = new javax.swing.JDialog();
        jPanel_infoEmpresa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_nombreEmpresa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Direccion = new javax.swing.JTextField();
        jTextField_CedJ = new javax.swing.JTextField();
        jTextField_telefono = new javax.swing.JTextField();
        jTextField_ciudad = new javax.swing.JTextField();
        jTextField_correo = new javax.swing.JTextField();
        jButton_aceptar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jTabbedPane_crearUsuario = new javax.swing.JTabbedPane();
        jPanel_administrador = new javax.swing.JPanel();
        TextField_BuscadorAdm = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Generica_Administrador = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jPanel_Vendedor = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Generica = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        TextField_Buscador = new javax.swing.JTextField();
        jButton_informacionEmpresa = new javax.swing.JButton();
        jButton_usuarios = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jDialog_empresaUsuario.setLocationByPlatform(true);
        jDialog_empresaUsuario.setMaximumSize(new java.awt.Dimension(540, 560));
        jDialog_empresaUsuario.setMinimumSize(new java.awt.Dimension(540, 560));
        jDialog_empresaUsuario.setPreferredSize(new java.awt.Dimension(540, 560));
        jDialog_empresaUsuario.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                jDialog_empresaUsuarioWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jDialog_empresaUsuarioLayout = new javax.swing.GroupLayout(jDialog_empresaUsuario.getContentPane());
        jDialog_empresaUsuario.getContentPane().setLayout(jDialog_empresaUsuarioLayout);
        jDialog_empresaUsuarioLayout.setHorizontalGroup(
            jDialog_empresaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        jDialog_empresaUsuarioLayout.setVerticalGroup(
            jDialog_empresaUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jPanel_infoEmpresa.setMaximumSize(new java.awt.Dimension(540, 500));
        jPanel_infoEmpresa.setMinimumSize(new java.awt.Dimension(540, 500));
        jPanel_infoEmpresa.setPreferredSize(new java.awt.Dimension(540, 500));

        jLabel1.setText("Nombre de la Empresa:");

        jLabel2.setText("Telefono:");

        jLabel3.setText("Cedula Juridica:");

        jLabel4.setText("Direccion:");

        jLabel5.setText("Correo:");

        jLabel6.setText("Ciudad");

        jButton_aceptar.setText("Aceptar");

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_infoEmpresaLayout = new javax.swing.GroupLayout(jPanel_infoEmpresa);
        jPanel_infoEmpresa.setLayout(jPanel_infoEmpresaLayout);
        jPanel_infoEmpresaLayout.setHorizontalGroup(
            jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_CedJ, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(99, Short.MAX_VALUE))
                    .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                        .addComponent(jButton_aceptar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_cancelar)
                        .addGap(58, 58, 58))))
        );

        jPanel_infoEmpresaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jPanel_infoEmpresaLayout.setVerticalGroup(
            jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_infoEmpresaLayout.createSequentialGroup()
                        .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_nombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_CedJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel4))
                    .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel_infoEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_aceptar)
                    .addComponent(jButton_cancelar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel_infoEmpresaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6});

        jTabbedPane_crearUsuario.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane_crearUsuario.setMaximumSize(new java.awt.Dimension(540, 500));
        jTabbedPane_crearUsuario.setMinimumSize(new java.awt.Dimension(540, 500));

        jPanel_administrador.setMaximumSize(new java.awt.Dimension(540, 500));
        jPanel_administrador.setMinimumSize(new java.awt.Dimension(540, 500));
        jPanel_administrador.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel_administradorComponentShown(evt);
            }
        });

        jButton10.setText("Ver");

        jLabel9.setText("Buscar");

        jButton13.setText("Eliminar");

        jTable_Generica_Administrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Generica_Administrador.setFillsViewportHeight(true);
        jTable_Generica_Administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Generica_AdministradorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_Generica_Administrador);

        jButton14.setText("Hecho");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Modificar");

        jButton16.setText("Crear");

        javax.swing.GroupLayout jPanel_administradorLayout = new javax.swing.GroupLayout(jPanel_administrador);
        jPanel_administrador.setLayout(jPanel_administradorLayout);
        jPanel_administradorLayout.setHorizontalGroup(
            jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_administradorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton14)
                .addGap(52, 52, 52))
            .addGroup(jPanel_administradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel_administradorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_administradorLayout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_administradorLayout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_BuscadorAdm, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel_administradorLayout.setVerticalGroup(
            jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_administradorLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_administradorLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_administradorLayout.createSequentialGroup()
                        .addGroup(jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_BuscadorAdm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addGroup(jPanel_administradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jButton14)
                .addGap(59, 59, 59))
        );

        jTabbedPane_crearUsuario.addTab("                            Administrador                       ", jPanel_administrador);

        jPanel_Vendedor.setMaximumSize(new java.awt.Dimension(540, 500));
        jPanel_Vendedor.setMinimumSize(new java.awt.Dimension(540, 500));

        jButton6.setText("Ver");

        jButton7.setText("Eliminar");

        jButton8.setText("Crear");

        jButton9.setText("Modificar");

        jButton11.setText("Hecho");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTable_Generica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Generica.setFillsViewportHeight(true);
        jTable_Generica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_GenericaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Generica);

        jLabel8.setText("Buscar");

        javax.swing.GroupLayout jPanel_VendedorLayout = new javax.swing.GroupLayout(jPanel_Vendedor);
        jPanel_Vendedor.setLayout(jPanel_VendedorLayout);
        jPanel_VendedorLayout.setHorizontalGroup(
            jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_VendedorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(52, 52, 52))
            .addGroup(jPanel_VendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel_VendedorLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_VendedorLayout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_VendedorLayout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel_VendedorLayout.setVerticalGroup(
            jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_VendedorLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_VendedorLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_VendedorLayout.createSequentialGroup()
                        .addGroup(jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)))
                .addGroup(jPanel_VendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jButton11)
                .addGap(59, 59, 59))
        );

        jTabbedPane_crearUsuario.addTab("                  Vendedor                                             ", jPanel_Vendedor);

        setMaximumSize(new java.awt.Dimension(897, 477));
        setMinimumSize(new java.awt.Dimension(897, 477));

        jButton_informacionEmpresa.setText("Informacion de Empresa");
        jButton_informacionEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_informacionEmpresaActionPerformed(evt);
            }
        });

        jButton_usuarios.setText("Usuarios");
        jButton_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_usuariosActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jButton_informacionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_informacionEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addComponent(jButton1)
                .addContainerGap(100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_informacionEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_informacionEmpresaActionPerformed
        jDialog_empresaUsuario.setTitle("Informacion de la Empresa");
        jPanel_infoEmpresa.setVisible(true);
        jDialog_empresaUsuario.setLocation(getLocationOnScreen());
        jPanel_infoEmpresa.setSize(jDialog_empresaUsuario.getSize());
        jDialog_empresaUsuario.add(jPanel_infoEmpresa);
        jDialog_empresaUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_informacionEmpresaActionPerformed

    private void jDialog_empresaUsuarioWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jDialog_empresaUsuarioWindowClosing
        jTabbedPane_crearUsuario.setVisible(false);
        jPanel_infoEmpresa.setVisible(false);
    }//GEN-LAST:event_jDialog_empresaUsuarioWindowClosing

    private void jButton_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_usuariosActionPerformed
        jTabbedPane_crearUsuario.setVisible(true);
        jDialog_empresaUsuario.setLocation(getLocationOnScreen());
        jTabbedPane_crearUsuario.setSize(jDialog_empresaUsuario.getSize());
        jDialog_empresaUsuario.add(jTabbedPane_crearUsuario);
        jDialog_empresaUsuario.setTitle("Crear Usuario");
        jDialog_empresaUsuario.setVisible(true);
    }//GEN-LAST:event_jButton_usuariosActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        jDialog_empresaUsuario.remove(jPanel_infoEmpresa);
        jDialog_empresaUsuario.setVisible(false);
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaDeInicio panelReportes = VentanaDeInicio.getInstance();
        setVisible(false);
        panelReportes.jPanel_VentanaPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jTabbedPane_crearUsuario.setVisible(false);
        jDialog_empresaUsuario.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTable_GenericaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_GenericaMouseClicked
        if (evt.getClickCount() == 2) {
            //            this.jButton_AceptarBusqueda.doClick();
        }
    }//GEN-LAST:event_jTable_GenericaMouseClicked

    private void jTable_Generica_AdministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Generica_AdministradorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_Generica_AdministradorMouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jDialog_empresaUsuario.remove(jTabbedPane_crearUsuario);
        jDialog_empresaUsuario.setVisible(false);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jPanel_administradorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel_administradorComponentShown
       actualizaTablaParaAdministradores();
    }//GEN-LAST:event_jPanel_administradorComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextField_Buscador;
    private javax.swing.JTextField TextField_BuscadorAdm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_informacionEmpresa;
    private javax.swing.JButton jButton_usuarios;
    private javax.swing.JDialog jDialog_empresaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel_Vendedor;
    private javax.swing.JPanel jPanel_administrador;
    private javax.swing.JPanel jPanel_infoEmpresa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane_crearUsuario;
    private javax.swing.JTable jTable_Generica;
    private javax.swing.JTable jTable_Generica_Administrador;
    private javax.swing.JTextField jTextField_CedJ;
    private javax.swing.JTextField jTextField_Direccion;
    private javax.swing.JTextField jTextField_ciudad;
    private javax.swing.JTextField jTextField_correo;
    private javax.swing.JTextField jTextField_nombreEmpresa;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables

public void actualizaTablaParaAdministradores() {
    System.out.println("aquiaquiaquiaqui");
        //AdminBD.consultarAdministradores();
//        data = AdminBD.getData();
//        String[] columnNames = AdminBD.getColumnNames();

//        this.jTable_Generica_Administrador.setModel(new MyTableModel_Generic(columnNames, data));
//        //Crea el ordenador para la tabla generica
//        TableRowSorter<TableModel> ordenador = new TableRowSorter<TableModel>(this.jTable_Generica_Administrador.getModel());
//        this.jTable_Generica_Administrador.setRowSorter(ordenador);
//        Vector<RowSorter.SortKey> qq = new Vector<RowSorter.SortKey>();
//        qq.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//        ordenador.setSortKeys(qq);
//        jTable_Generica_Administrador.requestFocus();
//       jTable_Generica_Administrador.changeSelection(0, 0, false, false);
//        /**
//         * Agrega el listener al JtextField del buscador *
//         */
//        this.TextField_BuscadorAdm.getDocument().addDocumentListener(new ListenerBuscador(this.TextField_BuscadorAdm, ordenador));

    }

}

