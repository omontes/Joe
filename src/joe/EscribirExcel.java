/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joe;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author Jason
 */
public class EscribirExcel {

    private WritableCellFormat timesReport;
    private WritableCellFormat times10; // formato de la celda
    private WritableCellFormat times14; // formato de la celda
    private WritableCellFormat times11; // formato de la celda
    private WritableCellFormat times12; // formato de la celda(esta encapsula)
    private String nombreArchivoExcel;//nombre del archivo excel

    /**
     * asigna el el nombre del archivoExcel
     *
     * @param nombreArchivoExcel
     */
    public void setNombreArchivoExcel(String nombreArchivoExcel) {
        this.nombreArchivoExcel = nombreArchivoExcel;
    }

    /**
     * establecer nombres de columnas
     *
     * @param colmNomb
     * @param hojaExcel
     * @throws jxl.write.WriteException
     */
    public void establecerNombresDecolumnas(String[] colmNomb,
            WritableSheet hojaExcel) throws WriteException {
        for (int col = 0; col < colmNomb.length; col++) {
            hojaExcel.addCell(new Label(col, 9, colmNomb[col], times12));
            hojaExcel.setColumnView(col, 25);//cambiar el tamano de la celda

        }
    }

    /**
     * Creacion y escritura del archivo excel
     *
     * @param infoEmpresa
     * @param datosFact
     * @param nombresColum
     * @param fechaIni
     * @param fechaFin
     * @param tipoDeReporte
     * @throws IOException
     * @throws WriteException
     */
    public void escribir(String[] infoEmpresa, String[][] datosFact,
            String[] nombresColum, String fechaIni, String fechaFin,
            String tipoDeReporte) throws IOException, WriteException {
        //crear un nuevo excel un el nombreArchivoExcel
        File ArchivoExcel = new File(nombreArchivoExcel);
        //configuracion de el libro de trabajo
        WorkbookSettings wbSettings = new WorkbookSettings();

        wbSettings.setLocale(new Locale("en", "EN"));//Configu default para 
        //generar la hoja de cálculo

        //Crea un libro, con su nombre de Archivo y la respectiva configuracion
        WritableWorkbook workbook = Workbook.createWorkbook(ArchivoExcel,
                wbSettings);
        workbook.createSheet("Pag 1", 0);//***crear una hoja***
        WritableSheet hojaExcel = workbook.getSheet(0);//obtiene la hoja 0

        ///tipos de letra
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        times10pt.setItalic(true);//tipo de letra italic
        WritableFont times14pt = new WritableFont(WritableFont.TIMES, 14);
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
        WritableFont times11pt = new WritableFont(WritableFont.TIMES, 11);
        times14pt.setColour(Colour.BLUE_GREY);
        times11pt.setColour(Colour.BLUE_GREY);

        //asignar el tipo de letra times12pt al formato times12
        times12 = new WritableCellFormat(times12pt);
        //asignar el tipo de letra times10pt al formato times10
        times10 = new WritableCellFormat(times10pt);
        //asignar el tipo de letra times14pt al formato times14
        times14 = new WritableCellFormat(times14pt);
        //asignar el tipo de letra times11pt al formato times11
        times11 = new WritableCellFormat(times11pt);
        timesReport = new WritableCellFormat(times11pt);

        //escribir datos de la empresa
        hojaExcel.addCell(new Label(0, 0, infoEmpresa[0], times14));
        for (int i = 1; i < 4; i++) {//set info de la empresa
            hojaExcel.addCell(new Label(0, i, infoEmpresa[i], times10));
        }
        //escribir el rango de fechas
        hojaExcel.addCell(new Label(2, 5, "Relación de Facturas "
                + "desde " + fechaIni + " hasta " + fechaFin,
                times11));

        //poner fecha actual
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        hojaExcel.addCell(new Label(5, 1, dateFormat.format(date), times11));

        //tipo de reporte 
        timesReport.setIndentation(3);
        hojaExcel.addCell(new Label(2, 6, tipoDeReporte, timesReport));

        //Colocar Nombres de las columnas
        establecerNombresDecolumnas(nombresColum, hojaExcel);
        //cargar datos de las facturas
        cargarDatos(datosFact, hojaExcel);

        //Escribe los datos contenidos en este libro en formato Excel
        workbook.write();
        //cerrar libro liberando memoria
        workbook.close();
    }

    /////**************borrar  a addCaption////////////////////////*****
    /**
     * escribe en la celda
     *
     * @param sheet
     * @param column
     * @param row
     * @param s
     * @throws RowsExceededException
     * @throws WriteException
     */
    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label = new Label(column, row, s);
        sheet.addCell(label);
    }
    //////////////////////////////////////////////////////

    /**
     * cargar datos de las facturas Recortar que la ultima celda contine los
     * totales que se desean mostrar
     *
     * @param datosFact
     * @param hojaExcel
     */
    private void cargarDatos(String[][] datosFact, WritableSheet hojaExcel)
            throws WriteException {
        int fil = 10;//fil en la que se empieza a colocar los datos
        for (int fila = 0; fila < datosFact.length - 1; fila++, fil++) {
            for (int col = 0; col < datosFact[0].length; col++) {
                try {//escribir segun tipo(int o string)
                    hojaExcel.addCell(new Number(col, fil,
                            Integer.parseInt(datosFact[fila][col]), times10));
                } catch (NumberFormatException | WriteException e) {
                    hojaExcel.addCell(new Label(col, fil,
                            datosFact[fila][col], times10));
                }
            }
        }
        //escribir ultima fila(Totales)
        for (int col = 0; col < datosFact[0].length; col++) {
            try {
                hojaExcel.addCell(new Number(col, fil, Integer.parseInt(
                        datosFact[datosFact.length - 1][col]), times14));
            } catch (NumberFormatException | WriteException e) {
                hojaExcel.addCell(new Label(col, fil,
                        datosFact[datosFact.length - 1][col], times14));
            }
        }
    }
}