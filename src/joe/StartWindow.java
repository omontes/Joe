/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import ManejoDeArchivos.EscribirExcel;
import ManejoDeArchivos.XMLConfiguracion;
import db_managment.Direct_Control_BD;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jxl.write.WriteException;

/**
 *
 * @author Joseph
 */
public class StartWindow extends javax.swing.JFrame {

    private static StartWindow _instance = null;
    private static int _posX;
    private static int _posY;

    private static final int LOGGED_IN = 0;
    private static final int LOGGED_OUT = 1;
    private static final int BKG_WIDTH = 600;
    private static final int BKG_HEIGHT = 320;
    private static final int WHITE = 1;
    private static final int BLACK = 0;
    private boolean _logged;
    private boolean _otherWindow;

    /**
     * Creates new form StartWindow
     */
    public StartWindow() {
        _instance = this;
        _otherWindow = false;
        _logged = false;

        initComponents();

        //Esto hay que quitarlo:
        bkgImage.setText("");
        bkgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/url.jpg")));

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        this.setSize(screenSize);
        this.setLocation(0, 0);
        bkColor.setSize(screenSize);
        _posX = this.getWidth() / 2 - jLayeredPane1.getWidth() / 2;
        _posY = this.getHeight() / 2 - jLayeredPane1.getHeight() / 2;
        jLayeredPane1.setLocation(_posX, _posY);

        panActiveUsser.setLocation(600, 180);
        panConf.setVisible(false);
        panConf.setEnabled(false);
        activeLoginPanel(LOGGED_OUT);

        sliderYN.setMaximum(BKG_HEIGHT);
        sliderYN.setMinimum(0);

        loadImageConf();
        panConf.setLocation(0, 330);
    }

    private void loadImageConf() {

        String nombre = ManejoDeArchivos.XMLConfiguracion.getInstance().ObtenerSlogan();
        int posYT = Integer.valueOf(ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerPosYNombreEmpresa());
        int sizeT = Integer.valueOf(ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerTamanoNombreEmpresa());
        int colorXML = Integer.valueOf(ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerColorTextoNombreEmpresa());
        txtNombreEmpresa.setText(nombre);
        sliderYN.setValue(posYT);
        jSpinner1.setValue(sizeT);

        lbCompanyName.setText(nombre);
        changeFontSize(lbCompanyName, sizeT);
        lbCompanyName.setLocation(lbCompanyName.getX(), posYT);

        if (colorXML == BLACK) {
            lbCompanyName.setForeground(Color.black);
        } else {
            lbCompanyName.setForeground(Color.white);
        }

        String imagePath = ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerRutaImagen();
        File file = new File(imagePath);
        if (file.exists()) {
            int posXI = Integer.valueOf(ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerPosXImagen());
            int posYI = Integer.valueOf(ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerPosYImagen());
            int sizeI = Integer.valueOf(ManejoDeArchivos.XMLConfiguracion.getInstance().obtenerTamanoImagen());

            txtImageDir.setText(imagePath);

            sliderSize.setValue(sizeI);
            sliderXI.setValue(posXI);
            sliderYI.setValue(posYI);

            try {
                BufferedImage img = getBkImageAndSize(imagePath, sizeI);
                bkgImage.setIcon(new ImageIcon(img));
                bkgImage.setBounds(-posXI, -posYI, img.getWidth(), img.getHeight());
                sliderXI.setMaximum(img.getWidth() - BKG_WIDTH);
                sliderYI.setMaximum(img.getHeight() - BKG_HEIGHT);
            } catch (IOException ex) {
                Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void activeLoginPanel(int pPanel) {
        if (pPanel == LOGGED_IN) {
            panActiveUsser.setVisible(true);
            panActiveUsser.setEnabled(true);
            panLoggedoutUsser.setVisible(false);
            panLoggedoutUsser.setEnabled(false);
        } else {
            panActiveUsser.setVisible(false);
            panActiveUsser.setEnabled(false);
            panLoggedoutUsser.setVisible(true);
            panLoggedoutUsser.setEnabled(true);
        }
    }

    public static int getPosX() {
        return _posX;
    }

    public static int getPosY() {
        return _posY;
    }

    public void enableMe() {
        this.setEnabled(true);
        _otherWindow = false;
    }

    public static StartWindow getInstance() {
        return _instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inicioCaja = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField_MontoInicioCaja = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        labFecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        bttConfAp = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panConf = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtImageDir = new javax.swing.JTextField();
        sliderSize = new javax.swing.JSlider();
        bttSearchDir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        sliderYI = new javax.swing.JSlider();
        sliderYN = new javax.swing.JSlider();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        sliderXI = new javax.swing.JSlider();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nameBlack = new javax.swing.JLabel();
        nameWhite = new javax.swing.JLabel();
        bkConfPan = new javax.swing.JLabel();
        panActiveUsser = new javax.swing.JPanel();
        labActiveName = new javax.swing.JLabel();
        bttLogout = new javax.swing.JLabel();
        panLoggedoutUsser = new javax.swing.JPanel();
        fieldUsser = new javax.swing.JTextField();
        fieldPassword = new javax.swing.JPasswordField();
        bttLogin = new javax.swing.JLabel();
        bttConf = new javax.swing.JLabel();
        bttClient = new javax.swing.JLabel();
        bttRep = new javax.swing.JLabel();
        bttExit = new javax.swing.JLabel();
        bttFact = new javax.swing.JLabel();
        bttInv = new javax.swing.JLabel();
        bkgBase = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbCompanyName = new javax.swing.JLabel();
        bkgImage = new javax.swing.JLabel();
        bkColor = new javax.swing.JLabel();

        inicioCaja.setAlwaysOnTop(true);
        inicioCaja.setUndecorated(true);
        inicioCaja.setResizable(false);
        inicioCaja.getContentPane().setLayout(null);
        inicioCaja.setSize(350, 180);
        inicioCaja.setLocationRelativeTo(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 180));
        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 153, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Inicio de caja");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1, 1, 348, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Monto inicial:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 60, 90, 20);

        jFormattedTextField_MontoInicioCaja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField_MontoInicioCaja.setText("0.00");
        jFormattedTextField_MontoInicioCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField_MontoInicioCajaMouseClicked(evt);
            }
        });
        jFormattedTextField_MontoInicioCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField_MontoInicioCajaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField_MontoInicioCajaKeyTyped(evt);
            }
        });
        jPanel1.add(jFormattedTextField_MontoInicioCaja);
        jFormattedTextField_MontoInicioCaja.setBounds(110, 60, 220, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 110, 50, 15);

        labFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labFecha.setForeground(new java.awt.Color(255, 255, 255));
        labFecha.setText("...");
        jPanel1.add(labFecha);
        labFecha.setBounds(110, 110, 220, 15);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(250, 140, 80, 23);

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(170, 140, 71, 23);

        inicioCaja.getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 350, 180);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(800, 500));

        bttConfAp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/confLittl.png"))); // NOI18N
        bttConfAp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttConfAp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttConfApMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttConfAp);
        bttConfAp.setBounds(480, 310, 20, 20);
        jLayeredPane1.setLayer(bttConfAp, javax.swing.JLayeredPane.PALETTE_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/logOutImg.jpg"))); // NOI18N
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(625, 40, 131, 135);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.PALETTE_LAYER);

        panConf.setOpaque(false);
        panConf.setLayout(null);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre de la empresa");
        panConf.add(jLabel5);
        jLabel5.setBounds(30, 50, 130, 20);

        txtImageDir.setEditable(false);
        txtImageDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImageDirActionPerformed(evt);
            }
        });
        panConf.add(txtImageDir);
        txtImageDir.setBounds(160, 90, 470, 23);

        sliderSize.setValue(0);
        sliderSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderSizeStateChanged(evt);
            }
        });
        panConf.add(sliderSize);
        sliderSize.setBounds(170, 130, 200, 23);

        bttSearchDir.setText("Buscar");
        bttSearchDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSearchDirActionPerformed(evt);
            }
        });
        panConf.add(bttSearchDir);
        bttSearchDir.setBounds(640, 90, 80, 23);

        jLabel7.setForeground(new java.awt.Color(51, 204, 255));
        jLabel7.setText("Posición");
        panConf.add(jLabel7);
        jLabel7.setBounds(580, 50, 50, 20);

        txtNombreEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreEmpresaFocusLost(evt);
            }
        });
        txtNombreEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreEmpresaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreEmpresaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEmpresaKeyTyped(evt);
            }
        });
        panConf.add(txtNombreEmpresa);
        txtNombreEmpresa.setBounds(160, 50, 290, 23);

        jLabel8.setForeground(new java.awt.Color(51, 204, 255));
        jLabel8.setText("Tamaño");
        panConf.add(jLabel8);
        jLabel8.setBounds(460, 50, 50, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Imágen de fondo");
        panConf.add(jLabel6);
        jLabel6.setBounds(30, 90, 110, 20);

        sliderYI.setValue(0);
        sliderYI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderYIStateChanged(evt);
            }
        });
        panConf.add(sliderYI);
        sliderYI.setBounds(560, 130, 80, 23);

        sliderYN.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderYNStateChanged(evt);
            }
        });
        panConf.add(sliderYN);
        sliderYN.setBounds(640, 50, 80, 23);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Apariencia");
        panConf.add(jLabel10);
        jLabel10.setBounds(10, 20, 96, 22);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("-");
        panConf.add(jLabel9);
        jLabel9.setBounds(540, 130, 20, 20);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/Buttons/bttSaveWht.png"))); // NOI18N
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        panConf.add(jLabel11);
        jLabel11.setBounds(750, 120, 40, 40);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(2, 2, 64, 1));
        jSpinner1.setOpaque(false);
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        panConf.add(jSpinner1);
        jSpinner1.setBounds(510, 50, 50, 23);

        sliderXI.setValue(0);
        sliderXI.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderXIStateChanged(evt);
            }
        });
        panConf.add(sliderXI);
        sliderXI.setBounds(460, 130, 80, 23);

        jLabel12.setForeground(new java.awt.Color(51, 204, 255));
        jLabel12.setText("Tamaño");
        panConf.add(jLabel12);
        jLabel12.setBounds(110, 130, 50, 20);

        jLabel13.setForeground(new java.awt.Color(51, 204, 255));
        jLabel13.setText("Posición");
        panConf.add(jLabel13);
        jLabel13.setBounds(400, 130, 50, 20);

        nameBlack.setBackground(java.awt.Color.black);
        nameBlack.setOpaque(true);
        nameBlack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameBlackMousePressed(evt);
            }
        });
        panConf.add(nameBlack);
        nameBlack.setBounds(750, 56, 10, 10);

        nameWhite.setBackground(java.awt.Color.white);
        nameWhite.setOpaque(true);
        nameWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameWhiteMousePressed(evt);
            }
        });
        panConf.add(nameWhite);
        nameWhite.setBounds(730, 56, 10, 10);

        bkConfPan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/confInterfaz.png"))); // NOI18N
        panConf.add(bkConfPan);
        bkConfPan.setBounds(0, 9, 800, 161);

        jLayeredPane1.add(panConf);
        panConf.setBounds(0, 100, 800, 170);
        jLayeredPane1.setLayer(panConf, javax.swing.JLayeredPane.PALETTE_LAYER);

        panActiveUsser.setBackground(new java.awt.Color(236, 233, 233));
        panActiveUsser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labActiveName.setFont(new java.awt.Font("Monotype Corsiva", 1, 20)); // NOI18N
        labActiveName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labActiveName.setText("Nombre activo");
        panActiveUsser.add(labActiveName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        bttLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttLogout.png"))); // NOI18N
        bttLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttLogoutMouseClicked(evt);
            }
        });
        panActiveUsser.add(bttLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLayeredPane1.add(panActiveUsser);
        panActiveUsser.setBounds(220, 150, 190, 150);
        jLayeredPane1.setLayer(panActiveUsser, javax.swing.JLayeredPane.PALETTE_LAYER);

        panLoggedoutUsser.setOpaque(false);
        panLoggedoutUsser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fieldUsser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldUsserKeyPressed(evt);
            }
        });
        panLoggedoutUsser.add(fieldUsser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 30));

        fieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldPasswordKeyPressed(evt);
            }
        });
        panLoggedoutUsser.add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 30));

        bttLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/loginBtt.png"))); // NOI18N
        bttLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttLoginMouseClicked(evt);
            }
        });
        panLoggedoutUsser.add(bttLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));

        jLayeredPane1.add(panLoggedoutUsser);
        panLoggedoutUsser.setBounds(600, 180, 190, 150);
        jLayeredPane1.setLayer(panLoggedoutUsser, javax.swing.JLayeredPane.PALETTE_LAYER);

        bttConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttConfUnt.png"))); // NOI18N
        bttConf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttConf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttConfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttConfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttConfMouseExited(evt);
            }
        });
        jLayeredPane1.add(bttConf);
        bttConf.setBounds(746, 366, 42, 56);
        jLayeredPane1.setLayer(bttConf, javax.swing.JLayeredPane.PALETTE_LAYER);

        bttClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttClientes.png"))); // NOI18N
        bttClient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttClientMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttClient);
        bttClient.setBounds(198, 362, 150, 124);
        jLayeredPane1.setLayer(bttClient, javax.swing.JLayeredPane.PALETTE_LAYER);

        bttRep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttReportes.png"))); // NOI18N
        bttRep.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttRep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttRepMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttRep);
        bttRep.setBounds(572, 362, 150, 124);
        jLayeredPane1.setLayer(bttRep, javax.swing.JLayeredPane.PALETTE_LAYER);

        bttExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttExitUnt.png"))); // NOI18N
        bttExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttExitMouseExited(evt);
            }
        });
        jLayeredPane1.add(bttExit);
        bttExit.setBounds(746, 434, 41, 53);
        jLayeredPane1.setLayer(bttExit, javax.swing.JLayeredPane.PALETTE_LAYER);

        bttFact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttFact.png"))); // NOI18N
        bttFact.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttFact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttFactMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttFact);
        bttFact.setBounds(11, 362, 150, 124);
        jLayeredPane1.setLayer(bttFact, javax.swing.JLayeredPane.PALETTE_LAYER);

        bttInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttInventario.png"))); // NOI18N
        bttInv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bttInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttInvMouseClicked(evt);
            }
        });
        jLayeredPane1.add(bttInv);
        bttInv.setBounds(385, 362, 150, 124);
        jLayeredPane1.setLayer(bttInv, javax.swing.JLayeredPane.PALETTE_LAYER);

        bkgBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/panelInicio.png"))); // NOI18N
        jLayeredPane1.add(bkgBase);
        bkgBase.setBounds(0, 0, 800, 500);
        jLayeredPane1.setLayer(bkgBase, javax.swing.JLayeredPane.PALETTE_LAYER);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setLayout(null);

        lbCompanyName.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        lbCompanyName.setText("NOMBRE DE LA EMPRESA AQUI");
        lbCompanyName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(lbCompanyName);
        lbCompanyName.setBounds(10, 64, 510, 60);

        bkgImage.setText("ImagenDeFondo");
        jPanel2.add(bkgImage);
        bkgImage.setBounds(0, 0, 600, 320);

        jLayeredPane1.add(jPanel2);
        jPanel2.setBounds(0, 31, 580, 310);

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 800, 500);

        bkColor.setBackground(new java.awt.Color(153, 153, 153));
        bkColor.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        bkColor.setMinimumSize(new java.awt.Dimension(800, 500));
        bkColor.setOpaque(true);
        bkColor.setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().add(bkColor);
        bkColor.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean valUsser(boolean pNeedAdmin) {
        if (!_logged) {
            JOptionPane.showMessageDialog(
                    jLayeredPane1,
                    "Debes iniciar sesión antes de continuar",
                    "¡Atención!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else if (pNeedAdmin && !isAdmin()) {
            JOptionPane.showMessageDialog(
                    jLayeredPane1,
                    "Necesitas permisos de administrador para poder continuar",
                    "¡Error!",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @return
     */
    private boolean isAdmin() {
        String usser = ManejoDeArchivos.XMLConfiguracion.getInstance().ObtenerUsuario();
        return db_managment.Direct_Control_BD.getInstance().obtenerTipoUsuario(usser).equalsIgnoreCase("Administrador");
    }

    private void bttExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttExitMouseClicked
        
        this.dispose();
        System.exit(1);
    }//GEN-LAST:event_bttExitMouseClicked

    private void bttFactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttFactMouseClicked
        if (valUsser(false) && _otherWindow == false) {
            _otherWindow = true;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String fecha = dateFormat.format(date);
            this.labFecha.setText(fecha);
            Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
            if (AdminBD.verSiExisteCierreTerminado(AdminBD.obtenerultimoidCierre())) {
                this.inicioCaja.setVisible(true);
                inicioCaja.requestFocusInWindow();
                jFormattedTextField_MontoInicioCaja.requestFocusInWindow();
                return;
            }
            this.verFacturacion();

        }
    }//GEN-LAST:event_bttFactMouseClicked

    private void bttExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttExitMouseEntered
        bttExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttExitTch.png")));
    }//GEN-LAST:event_bttExitMouseEntered

    private void bttExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttExitMouseExited
        bttExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttExitUnt.png")));
    }//GEN-LAST:event_bttExitMouseExited

    private void bttInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttInvMouseClicked
        if (valUsser(true) && _otherWindow == false) {
            _otherWindow = true;
            new JF_Inventario().setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_bttInvMouseClicked

    private void bttLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttLoginMouseClicked
        login();
    }//GEN-LAST:event_bttLoginMouseClicked

    private void bttRepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttRepMouseClicked
        if (valUsser(true) && _otherWindow == false) {
            _otherWindow = true;
            new JF_Reportes().setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_bttRepMouseClicked

    private void bttClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttClientMouseClicked
        if (valUsser(true) && _otherWindow == false) {
            _otherWindow = true;
            new JF_Usuario().setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_bttClientMouseClicked

    private void bttConfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttConfMouseEntered
        bttConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttConfTch.png")));
    }//GEN-LAST:event_bttConfMouseEntered

    private void bttConfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttConfMouseExited
        bttConf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/System/Images/PanelInicio/bttConfUnt.png")));
    }//GEN-LAST:event_bttConfMouseExited

    private void bttLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttLogoutMouseClicked
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerUsuario("");
        _logged = false;

        panActiveUsser.setVisible(false);
        panActiveUsser.setEnabled(false);

        panLoggedoutUsser.setEnabled(true);
        panLoggedoutUsser.setVisible(true);
    }//GEN-LAST:event_bttLogoutMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerUsuario("");
    }//GEN-LAST:event_formWindowClosing

    private void bttConfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttConfMouseClicked
        if (valUsser(true) && _otherWindow == false) {
            _otherWindow = true;
            new JF_Conf().setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_bttConfMouseClicked

    private void jFormattedTextField_MontoInicioCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField_MontoInicioCajaMouseClicked
        this.jFormattedTextField_MontoInicioCaja.selectAll();
    }//GEN-LAST:event_jFormattedTextField_MontoInicioCajaMouseClicked

    private void jFormattedTextField_MontoInicioCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_MontoInicioCajaKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            this.jFormattedTextField_MontoInicioCaja.transferFocus();

        }
        if (evt.isControlDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextField_MontoInicioCajaKeyPressed

    private void jFormattedTextField_MontoInicioCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_MontoInicioCajaKeyTyped
        int tecla = evt.getKeyChar();
        if (tecla == KeyEvent.VK_COMMA) {
            return;
        }
        if (tecla == KeyEvent.VK_PERIOD) {
            return;
        };
        if (!Character.isDigit(tecla) & !Character.isISOControl(
                evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextField_MontoInicioCajaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        enableMe();
        inicioCaja.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.crearCierreCaja();
        this.inicioCaja.dispose();
        this.jFormattedTextField_MontoInicioCaja.setValue(new BigDecimal("0.00"));
        this.verFacturacion();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fieldUsserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldUsserKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            fieldUsser.transferFocus();
        }
    }//GEN-LAST:event_fieldUsserKeyPressed

    private void fieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPasswordKeyPressed
        if (evt.getKeyCode() == 10) {
            login();
        }
    }//GEN-LAST:event_fieldPasswordKeyPressed

    private void bttConfApMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttConfApMouseClicked
        panConf.setEnabled(true);
        panConf.setVisible(true);
    }//GEN-LAST:event_bttConfApMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        panConf.setVisible(false);
        panConf.setEnabled(false);
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerPosXImagen(String.valueOf(sliderXI.getValue()));
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerPosYImagen(String.valueOf(sliderYI.getValue()));
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerPosYNombreEmpresa(String.valueOf(sliderYN.getValue()));
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerTamanoNombreEmpresa(jSpinner1.getValue().toString());
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerSlogan(txtNombreEmpresa.getText());
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerTamanoImagen(String.valueOf(sliderSize.getValue()));
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txtImageDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImageDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImageDirActionPerformed

    private void bttSearchDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSearchDirActionPerformed
        JFileChooser dialog = new JFileChooser();
        dialog.setFileFilter(Utils.getFileFilter());
        dialog.setAcceptAllFileFilterUsed(false);
        int op = dialog.showOpenDialog(this);
        if (op == JFileChooser.APPROVE_OPTION) {
            if (dialog.getSelectedFile().exists() && Utils.isExtValid(dialog.getSelectedFile())) {
                try {
                    ManejoDeArchivos.XMLConfiguracion.getInstance().establecerRutaImagen(dialog.getSelectedFile().getAbsolutePath());
                    txtImageDir.setText(dialog.getSelectedFile().getAbsolutePath());
                    BufferedImage img = getBkImageAndSize(dialog.getSelectedFile().getAbsolutePath(), 0);
                    bkgImage.setIcon(new javax.swing.ImageIcon(img));
                    bkgImage.setSize(img.getWidth(), img.getHeight());
                } catch (IOException ex) {
                    Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bttSearchDirActionPerformed

    private void txtNombreEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEmpresaKeyTyped

    }//GEN-LAST:event_txtNombreEmpresaKeyTyped

    private void txtNombreEmpresaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEmpresaKeyPressed

    }//GEN-LAST:event_txtNombreEmpresaKeyPressed

    private void txtNombreEmpresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEmpresaKeyReleased
        lbCompanyName.setText(txtNombreEmpresa.getText());
    }//GEN-LAST:event_txtNombreEmpresaKeyReleased

    private void nameWhiteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameWhiteMousePressed
        lbCompanyName.setForeground(Color.white);
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerColorTextoNombreEmpresa(String.valueOf(WHITE));
    }//GEN-LAST:event_nameWhiteMousePressed

    private void nameBlackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameBlackMousePressed
        lbCompanyName.setForeground(Color.black);
        ManejoDeArchivos.XMLConfiguracion.getInstance().establecerColorTextoNombreEmpresa(String.valueOf(BLACK));
    }//GEN-LAST:event_nameBlackMousePressed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        String sValue = jSpinner1.getValue().toString();
        int size = Integer.valueOf(sValue);
        changeFontSize(lbCompanyName, size);
    }//GEN-LAST:event_jSpinner1StateChanged

    private void sliderSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderSizeStateChanged
        try {
            BufferedImage img = getBkImageAndSize(txtImageDir.getText(), sliderSize.getValue());
            bkgImage.setIcon(new ImageIcon(img));
            bkgImage.setSize(img.getWidth(), img.getHeight());
        } catch (IOException ex) {
            Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sliderSizeStateChanged

    private void sliderXIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderXIStateChanged
        bkgImage.setLocation(-sliderXI.getValue(), bkgImage.getY());
    }//GEN-LAST:event_sliderXIStateChanged

    private void sliderYIStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderYIStateChanged
        bkgImage.setLocation(bkgImage.getX(), -sliderYI.getValue());
    }//GEN-LAST:event_sliderYIStateChanged

    private void sliderYNStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderYNStateChanged
        lbCompanyName.setLocation(lbCompanyName.getX(), sliderYN.getValue());
    }//GEN-LAST:event_sliderYNStateChanged

    private void txtNombreEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreEmpresaFocusLost

    }//GEN-LAST:event_txtNombreEmpresaFocusLost

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        if(evt.getKeyChar()== KeyEvent.VK_ENTER){
            this.jButton2.doClick();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void changeFontSize(JLabel pLabel, int pValue) {
        String name = pLabel.getFont().getName();
        int style = pLabel.getFont().getStyle();
        pLabel.setFont(new Font(name, style, pValue));
    }

    private BufferedImage getBkImageAndSize(String pPath, int pPercent) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(pPath));
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        int newWidth, newHeight;
        if (originalImage.getWidth() >= originalImage.getHeight()) {
            newHeight = BKG_HEIGHT + BKG_HEIGHT * pPercent / 100;
            newWidth = originalImage.getWidth() + newHeight - originalImage.getHeight();
        } else {
            newWidth = BKG_WIDTH + BKG_WIDTH * pPercent / 100;
            newHeight = originalImage.getHeight() + newWidth - originalImage.getWidth();
        }

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        return resizedImage;
    }

    private void verFacturacion() {
        new JF_Facturacion().setVisible(true);
        this.setEnabled(false);
    }

    private void crearCierreCaja() {
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        String fecha = this.labFecha.getText();
        String Cajero = ManejoDeArchivos.XMLConfiguracion.getInstance().ObtenerUsuario();

        Object montoInicio = this.jFormattedTextField_MontoInicioCaja.getValue();
        BigDecimal reporteInicio = new BigDecimal(montoInicio != null ? montoInicio.toString() : "0");
        AdminBD.insertarCierreDeCaja(fecha, Cajero, reporteInicio);
    }

    private void login() {
        String usser = fieldUsser.getText();
        String pass = new String(fieldPassword.getPassword());

        if (usser.isEmpty()) {
            JOptionPane.showMessageDialog(
                    jLayeredPane1,
                    "Por favor digite su usuario",
                    "¡Atención!",
                    JOptionPane.WARNING_MESSAGE);
        } else if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(
                    jLayeredPane1,
                    "Por favor digite su contraseña",
                    "¡Atención!",
                    JOptionPane.WARNING_MESSAGE);
        } else {

            Direct_Control_BD base = db_managment.Direct_Control_BD.getInstance();
            int authentique = base.verificarUsuario(usser, pass);
            if (authentique == 0) {
                JOptionPane.showMessageDialog(
                        jLayeredPane1,
                        "No se ha podido ingresar. Por favor revise su usuario y contraseña",
                        "¡Error!",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                _logged = true;
                JOptionPane.showMessageDialog(
                        jLayeredPane1,
                        "Bienvenido " + usser,
                        "¡Hola!",
                        JOptionPane.INFORMATION_MESSAGE);
                XMLConfiguracion xml = ManejoDeArchivos.XMLConfiguracion.getInstance();
                xml.establecerUsuario(usser);
                activeLoginPanel(LOGGED_IN);
                labActiveName.setText(usser);
                if (authentique == 1) {
                    // ES ADMIN
                } else {
                    //ES VENDEDOR
                }

                fieldUsser.setText("");
                fieldPassword.setText("");

            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, WriteException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartWindow().setVisible(true);
            }
        });
     
      
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bkColor;
    private javax.swing.JLabel bkConfPan;
    private javax.swing.JLabel bkgBase;
    private javax.swing.JLabel bkgImage;
    private javax.swing.JLabel bttClient;
    private javax.swing.JLabel bttConf;
    private javax.swing.JLabel bttConfAp;
    private javax.swing.JLabel bttExit;
    private javax.swing.JLabel bttFact;
    private javax.swing.JLabel bttInv;
    private javax.swing.JLabel bttLogin;
    private javax.swing.JLabel bttLogout;
    private javax.swing.JLabel bttRep;
    private javax.swing.JButton bttSearchDir;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldUsser;
    private javax.swing.JDialog inicioCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextField_MontoInicioCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labActiveName;
    private javax.swing.JLabel labFecha;
    private javax.swing.JLabel lbCompanyName;
    private javax.swing.JLabel nameBlack;
    private javax.swing.JLabel nameWhite;
    private javax.swing.JPanel panActiveUsser;
    private javax.swing.JPanel panConf;
    private javax.swing.JPanel panLoggedoutUsser;
    private javax.swing.JSlider sliderSize;
    private javax.swing.JSlider sliderXI;
    private javax.swing.JSlider sliderYI;
    private javax.swing.JSlider sliderYN;
    private javax.swing.JTextField txtImageDir;
    private javax.swing.JTextField txtNombreEmpresa;
    // End of variables declaration//GEN-END:variables

}
