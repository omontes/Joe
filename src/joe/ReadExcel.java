/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.io.File;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Monicatico
 */
public class ReadExcel {
    /**
     * Obtiene un arreglo de strings del archivo de excel
     * @param file
     * @return 
     */
    public String[][] leerArchivoExcel(File file) {

        try {
            Workbook archivoExcel = Workbook.getWorkbook(file);
            Sheet hoja = archivoExcel.getSheet(0);
            int numColumnas = hoja.getColumns();
            int numFilas = hoja.getRows();
            String lista_inventario[][] = new String[numFilas][numColumnas];
            String data;
            for (int fila = 0; fila < numFilas; fila++) {
                for (int columna = 0; columna < numColumnas; columna++) {
                    data = hoja.getCell(columna, fila).getContents();
                    lista_inventario[fila][columna] = data;
                }
            }
            return lista_inventario;
        } catch (Exception ioe) {
            JOptionPane.showMessageDialog(
                            null,
                            "Debe de ingresar un archivo de excel con un formato adecuado "
                                    + "\nque tenga las columnas especificas de una entrada de mercaderia",
                            "Alert!", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
    
}
