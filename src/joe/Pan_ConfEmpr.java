/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import ManejoDeArchivos.XMLConfiguracion;
import db_managment.Direct_Control_BD;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jason
 */
public class Pan_ConfEmpr extends javax.swing.JPanel {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Object[][] data;
    Direct_Control_BD AdminBD;
    DateFormat dateF = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form NewJPanel_Configuracion
     */
    public Pan_ConfEmpr() {
        initComponents();
        AdminBD = Direct_Control_BD.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel7 = new javax.swing.JLabel();
        jTextField_ComentarioIni = new javax.swing.JTextField();
        jTextField_ComentarioFin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(760, 400));
        setMinimumSize(new java.awt.Dimension(760, 400));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(760, 400));
        setLayout(null);

        jLabel1.setText("Nombre de la Empresa:");
        add(jLabel1);
        jLabel1.setBounds(150, 20, 111, 23);

        jLabel2.setText("Telefono:");
        add(jLabel2);
        jLabel2.setBounds(150, 130, 111, 23);

        jLabel3.setText("Cedula Juridica:");
        add(jLabel3);
        jLabel3.setBounds(150, 60, 111, 23);

        jLabel4.setText("Direccion:");
        add(jLabel4);
        jLabel4.setBounds(150, 90, 111, 23);

        jLabel5.setText("Correo:");
        add(jLabel5);
        jLabel5.setBounds(150, 170, 111, 23);

        jTextField_nombreEmpresa.setText("Mi Empresa");
        add(jTextField_nombreEmpresa);
        jTextField_nombreEmpresa.setBounds(280, 20, 294, 23);

        jLabel6.setText("Ciudad:");
        add(jLabel6);
        jLabel6.setBounds(150, 210, 111, 23);

        jTextField_Direccion.setText("Canton, Distrito, Barrio");
        add(jTextField_Direccion);
        jTextField_Direccion.setBounds(280, 90, 294, 23);

        jTextField_CedJ.setText("0000000000");
        jTextField_CedJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CedJActionPerformed(evt);
            }
        });
        add(jTextField_CedJ);
        jTextField_CedJ.setBounds(280, 60, 294, 23);

        jTextField_telefono.setText("88888888");
        add(jTextField_telefono);
        jTextField_telefono.setBounds(280, 130, 294, 23);

        jTextField_ciudad.setText("Ciudad");
        add(jTextField_ciudad);
        jTextField_ciudad.setBounds(280, 210, 294, 23);

        jTextField_correo.setText("miempresa@gmail.com");
        add(jTextField_correo);
        jTextField_correo.setBounds(280, 170, 294, 23);

        jButton_aceptar.setText("Guardar Cambios");
        jButton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptarActionPerformed(evt);
            }
        });
        add(jButton_aceptar);
        jButton_aceptar.setBounds(441, 360, 130, 23);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Comentarios en Factura:");
        add(jLabel7);
        jLabel7.setBounds(150, 250, 240, 14);

        jTextField_ComentarioIni.setText("Mi Empresa Le Saluda");
        add(jTextField_ComentarioIni);
        jTextField_ComentarioIni.setBounds(280, 280, 294, 23);

        jTextField_ComentarioFin.setText("Gracias Por Su Compra");
        add(jTextField_ComentarioFin);
        jTextField_ComentarioFin.setBounds(280, 310, 294, 23);

        jLabel8.setText("Inicial:");
        add(jLabel8);
        jLabel8.setBounds(230, 280, 40, 23);

        jLabel11.setText("Final:");
        add(jLabel11);
        jLabel11.setBounds(230, 310, 40, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aceptarActionPerformed
        XMLConfiguracion xml = new XMLConfiguracion();

        xml.crearXML(jTextField_nombreEmpresa.getText(), jTextField_CedJ.
                getText(),
                jTextField_Direccion.getText(), jTextField_telefono.getText(),
                jTextField_ciudad.getText(), jTextField_correo.getText(),
                jTextField_ComentarioIni.getText(), jTextField_ComentarioFin.
                getText(), xml.ObtenerUsuario(), xml.obtenerRutaImagen(),
                xml.obtenerPosXImagen(), xml.obtenerPosYImagen(),
                xml.obtenerPosXNombreEmpresa(), xml.obtenerPosYNombreEmpresa(),
                xml.ObtenerSlogan(),xml.ObtenerTipoUsuario(),xml.obtenerTamanoNombreEmpresa(),
                xml.obtenerTamanoImagen(),
                xml.obtenerColorTextoNombreEmpresa());
    }//GEN-LAST:event_jButton_aceptarActionPerformed

    private void jTextField_CedJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CedJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CedJActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField_CedJ;
    private javax.swing.JTextField jTextField_ComentarioFin;
    private javax.swing.JTextField jTextField_ComentarioIni;
    private javax.swing.JTextField jTextField_Direccion;
    private javax.swing.JTextField jTextField_ciudad;
    private javax.swing.JTextField jTextField_correo;
    private javax.swing.JTextField jTextField_nombreEmpresa;
    private javax.swing.JTextField jTextField_telefono;
    // End of variables declaration//GEN-END:variables

}
