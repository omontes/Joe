
import ManejoDeArchivos.EscribirExcel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import joe.StartWindow;
import jxl.write.WriteException;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package joe;
//
//
//import db_managment.Direct_Control_BD;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import jxl.write.WriteException;
//import org.xml.sax.SAXException;
//
///**
// *
// * @author Joe
// */z
public class Main {
//
//    /**
//     * @param args the command line arguments
//     * @throws java.io.IOException
//     * @throws jxl.write.WriteException
//     * @throws java.net.URISyntaxException
//     */
    public static void main(String args[])  {
//////        Backupdbtosql();
////        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
////        /* Create and display the form */
////       // Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
////
//////        java.awt.EventQueue.invokeLater(new Runnable() {
//////            @Override
//////            public void run() {
//////                //Centra Main_Window en la pantalla del monitor
//////                //VentanaDeInicio miVentana = VentanaDeInicio.getInstance();
//////                StartWindow miVentana = new StartWindow();
//////                miVentana.setLocationRelativeTo(null);
//////                miVentana.setVisible(true);
//////
//////            }
//////        });
////
        EscribirExcel p = new EscribirExcel();
        try {
            
            p.escribirProforma(null,null);
        } catch (IOException ex) {
            Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//;
}
////Replace your executeCmd with this:
////
////String executeCmd = "mysqldump -u " + dbUserName + " -p" + dbPassword + " "
////+ dbName + " --tables " + tbName + " -r " + path;
////
////And change your path like this: "\"C:/New Folder/table.sql\""
//
