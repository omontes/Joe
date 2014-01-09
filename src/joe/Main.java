/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import db_managment.Direct_Control_BD;
import java.io.IOException;
import jxl.write.WriteException;
/**
 *
 * @author Joe
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws jxl.write.WriteException
     */
    public static void main(String args[]) throws IOException, WriteException {
        ///****///pruebas sobre excel borrar///////********///////////////////////////////
//        String[] infoEmpresa = {"Joe S.A ", "Oriente pa dentro", "Cartago,"
//            + " CA 20320", "Telefono:2650-11-36, fax:2655-0203"};
//        String[][] datosFact = {{"01/01/2012", "Jason", "1", "5", "10500", "75", "5000", "10075"},
//        {"02/01/2012", "Oscar", "2", "7", "25300", "35", "300", "25035"},
//        {"01/01/2012", "Jason", "3", "5", "10500", "75", "5000", "10075"},
//        {"02/01/2012", "Oscar", "4", "7", "25300", "35", "300", "25035"},
//        {"", "", "Total de Fact", "24", "253045", "", "", "2522035"}};
//        String[] NombreColumnas = {"Fecha", "Cliente", "Num.Factura",
//            " Total Item", "SubTotal ", "Impuesto",
//            "Descuento", "Total Factura"};
//        EscribirExcel archivoExcel = new EscribirExcel();
//        archivoExcel.setNombreArchivoExcel("ExcelPrueba.xls");
//        archivoExcel.escribir(infoEmpresa, datosFact, NombreColumnas, "01/01/2012", "02/01/2012",
//                "Ventas Por Fechas");
        ///*****///Fin de pruebas sobre excel borrar//////////**********////////////////////////////

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
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDeInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /* Create and display the form */
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //Centra Main_Window en la pantalla del monitor
                VentanaDeInicio miVentana= VentanaDeInicio.getInstance();
                miVentana.setLocationRelativeTo(null);

            }
        });
    }
;
}
