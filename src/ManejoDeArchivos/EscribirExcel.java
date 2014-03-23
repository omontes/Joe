/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDeArchivos;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import joe.StartWindow;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableFont.FontName;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Jason
 */
public class EscribirExcel {

    public WritableWorkbook workbook;
    File ArchivoExcel;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS0");
    DateFormat dateFormaN = new SimpleDateFormat("dd/MM/yyyy");
    private WritableCellFormat timesReport;
    private WritableCellFormat times10; // formato de la celda
    private WritableCellFormat times14; // formato de la celda
    private WritableCellFormat times11; // formato de la celda
    private WritableCellFormat times12; // formato de la celda(esta encapsula)
    private String nombreArchivoExcel;//nombre del archivo excel
    private static EscribirExcel escribir;
    private WritableCellFormat timesLines;

    /**
     * asigna el el nombre del archivoExcel
     *
     * @param nombreArchivoExcel
     */
    public void setNombreArchivoExcel(String nombreArchivoExcel) {
        this.nombreArchivoExcel = nombreArchivoExcel;
    }

    public String getNombreArchivoExcel() {
        return this.nombreArchivoExcel;
    }

    public static EscribirExcel getInstance() {
        if (escribir == null) {
            EscribirExcel escribir = new EscribirExcel();
        }
        return escribir;
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
     * @param formato
     * @throws IOException
     * @throws WriteException
     */
    public void escribir(String[] infoEmpresa, Object[][] datosFact,
            String[] nombresColum, String fechaIni, String fechaFin,
            String tipoDeReporte, String formato) throws IOException,
            WriteException {
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
        // times10pt.setItalic(true);//tipo de letra italic
        WritableFont times14pt = new WritableFont(WritableFont.TIMES, 14);
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
        WritableFont times11pt = new WritableFont(WritableFont.TIMES, 11);
        times14pt.setColour(Colour.BLUE_GREY);
        times11pt.setColour(Colour.BLUE_GREY);

        // formato para escribir linea separadora
        WritableFont timesLinespt = new WritableFont(WritableFont.TIMES, 14);
        timesLines = new WritableCellFormat(timesLinespt);
        timesLines.setBorder(Border.TOP, BorderLineStyle.SLANTED_DASH_DOT,
                Colour.BLUE_GREY);
        timesLines.setAlignment(Alignment.CENTRE);

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
        for (int i = 1; i <= 4; i++) {//set info de la empresa
            hojaExcel.addCell(new Label(0, i, infoEmpresa[i], times10));
        }

        //escribir el rango de fechas
        if (!"".equals(fechaIni) && tipoDeReporte.
                contains(" de mercadería en ") != true) {
            hojaExcel.addCell(new Label(2, 5, " Rango de Fechas "
                    + "desde " + fechaIni + " hasta " + fechaFin,
                    times11));
        }

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
        int ultimaFila = 10;
        if (datosFact.length != 0) {//verifica que contenga datos
            ultimaFila = cargarDatos(datosFact, hojaExcel);

            //Escribir el total dependiendo el tipo de reporte
            escribirResultado(tipoDeReporte, hojaExcel, ultimaFila);
        } else {// si no hay datos escribe total cero

            hojaExcel.addCell(new Label(1, 11, "Total  0",
                    timesLines));
        }

        //Escribe los datos contenidos en este libro en formato Excel
        workbook.write();

        //cerrar libro liberando memoria
        workbook.close();
        if (formato.equals("Excel")) {
            //mostrar el Excel
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "
                        + nombreArchivoExcel);
            } catch (IOException e) {
                System.out.println("Error al abrir el archivo "
                        + nombreArchivoExcel + "\n" + e.getMessage());
            }
        }
    }

    /**
     * cargar datos de las facturas Recortar que la ultima celda contine los
     * totales que se desean mostrar
     *
     * @param datosFact
     * @param hojaExcel
     */
    private int cargarDatos(Object[][] datosFact, WritableSheet hojaExcel)
            throws WriteException {
        int fil = 10;//fil en la que se empieza a colocar los datos
        for (int fila = 0; fila < datosFact.length; fila++, fil++) {
            for (int col = 0; col < datosFact[0].length; col++) {
                try {//escribir segun tipo(int o string)
                    hojaExcel.addCell(new Number(col, fil,
                            Double.parseDouble(datosFact[fila][col].
                                    toString()), times10));
                } catch (NumberFormatException | WriteException e) {

                    hojaExcel.addCell(new Label(col, fil,
                            datosFact[fila][col].toString(), times10));

                }
            }
        }
        for (int col = 0; col < datosFact[0].length; col++) {
            hojaExcel.addCell(new Label(col, fil + 1, "", timesLines));
        }
        return fil;

    }

    /**
     * Escribe el total de factura dependiendo del tipo de reporte
     *
     * @param tipoDeReporte
     * @param hojaExc
     * @param ultimaFila
     * @throws WriteException
     */
    private void escribirResultado(String tipoDeReporte, WritableSheet hojaExc,
            int ultimaFila) throws WriteException {

        if (tipoDeReporte.startsWith("Ventas Por Fechas")
                || tipoDeReporte.startsWith("Devoluciones")
                || tipoDeReporte.startsWith("Devoluciones")) {
            hojaExc.addCell(new Label(1, ultimaFila + 1,
                    "       Total Facturas", timesLines));
            //total de fact
            hojaExc.addCell(new jxl.write.Formula(2, ultimaFila + 1,
                    "COUNT(C11:C" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(3, ultimaFila + 1,
                    "SUM(D11:D" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(6, ultimaFila + 1,
                    "SUM(G11:G" + ultimaFila + ")", timesLines));

        } else if (tipoDeReporte.startsWith("Ventas Por Cliente:")) {
            hojaExc.addCell(new Label(0, ultimaFila + 1,
                    "       Total Facturas:", timesLines));
            //total de fact
            hojaExc.addCell(new jxl.write.Formula(1, ultimaFila + 1,
                    "COUNT(B11:B" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(3, ultimaFila + 1,
                    "SUM(D11:D" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(4, ultimaFila + 1,
                    "SUM(E11:E" + ultimaFila + ")", timesLines));

        } else if (tipoDeReporte.startsWith("Ventas Por Vendedor:")) {
            if (tipoDeReporte.endsWith("Credito")
                    || tipoDeReporte.endsWith("Apartado")) {
                hojaExc.addCell(new Label(0, ultimaFila + 1,
                        "       Total Facturas:", timesLines));
                //total de fact
                hojaExc.addCell(new jxl.write.Formula(1, ultimaFila + 1,
                        "COUNT(B11:B" + ultimaFila + ")", timesLines));
                hojaExc.addCell(new jxl.write.Formula(3, ultimaFila + 1,
                        "SUM(D11:D" + ultimaFila + ")", timesLines));
                hojaExc.addCell(new jxl.write.Formula(4, ultimaFila + 1,
                        "SUM(E11:E" + ultimaFila + ")", timesLines));
                hojaExc.addCell(new jxl.write.Formula(5, ultimaFila + 1,
                        "SUM(F11:F" + ultimaFila + ")", timesLines));
            } else {
                hojaExc.addCell(new Label(0, ultimaFila + 1,
                        "       Total Facturas:", timesLines));
                //total de fact
                hojaExc.addCell(new jxl.write.Formula(1, ultimaFila + 1,
                        "COUNT(B11:B" + ultimaFila + ")", timesLines));
                hojaExc.addCell(new jxl.write.Formula(3, ultimaFila + 1,
                        "SUM(D11:D" + ultimaFila + ")", timesLines));
                hojaExc.addCell(new jxl.write.Formula(4, ultimaFila + 1,
                        "SUM(E11:E" + ultimaFila + ")", timesLines));
            }

        } else if (tipoDeReporte.startsWith("Ventas De Productos Para el")) {
            hojaExc.addCell(new Label(1, ultimaFila + 1, "        Total:",
                    timesLines));
            hojaExc.addCell(new jxl.write.Formula(2, ultimaFila + 1,
                    "SUM(C11:C" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new Number(3, ultimaFila + 1,
                    multiplicarColmunasYSumarResultado(2, 3,
                            ultimaFila, hojaExc), timesLines));
//            hojaExc.addCell(new jxl.write.Formula(3, ultimaFila + 1,
//                    "SUM(D11:D" + ultimaFila + ")", timesLines));

        } else if (tipoDeReporte.startsWith("Lista De Precio")
                || tipoDeReporte.startsWith("Lista De Costo")) {
            hojaExc.addCell(new Label(1, ultimaFila + 1, "        Total:",
                    timesLines));
            hojaExc.addCell(new jxl.write.Formula(5, ultimaFila + 1,
                    "SUM(F11:F" + ultimaFila + ")", timesLines));

        } else if (tipoDeReporte.startsWith("Productos agotados")) {
            hojaExc.addCell(new Label(0, ultimaFila + 1, "        Total:",
                    timesLines));
            hojaExc.addCell(new jxl.write.Formula(1, ultimaFila + 1,
                    "COUNT(C11:C" + ultimaFila + ")", timesLines));
        } else if (tipoDeReporte.startsWith("Productos En Inventario")) {
            hojaExc.addCell(new Label(0, ultimaFila + 1, "        Total:",
                    timesLines));
            hojaExc.addCell(new jxl.write.Formula(1, ultimaFila + 1,
                    "COUNT(C11:C" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(4, ultimaFila + 1,
                    "SUM(E11:E" + ultimaFila + ")", timesLines));
        } else if (tipoDeReporte.startsWith("Valor del Inventario")) {
            hojaExc.addCell(new Label(1, ultimaFila + 1, "        Total:",
                    timesLines));
            hojaExc.addCell(new jxl.write.Formula(2, ultimaFila + 1,
                    "COUNT(D11:D" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(3, ultimaFila + 1,
                    "SUM(D11:D" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(4, ultimaFila + 1,
                    "SUM(E11:E" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(5, ultimaFila + 1,
                    "SUM(F11:F" + ultimaFila + ")", timesLines));
        } else if (tipoDeReporte.
                contains(" de mercadería en ")) {
            hojaExc.addCell(new Label(0, ultimaFila + 1, "        Total:",
                    timesLines));
            hojaExc.addCell(new jxl.write.Formula(1, ultimaFila + 1,
                    "COUNT(C11:C" + ultimaFila + ")", timesLines));
            hojaExc.addCell(new jxl.write.Formula(2, ultimaFila + 1,
                    "SUM(C11:C" + ultimaFila + ")", timesLines));

        } else if (tipoDeReporte.startsWith("Movimientos del producto ")) {

            hojaExc.addCell(new Number(2, ultimaFila + 7,
                    sumarColumnas(8, ultimaFila, hojaExc), times10));
            hojaExc.addCell(new Label(1, ultimaFila + 7, "Cantidad  Entrada:",
                    times10));

            hojaExc.addCell(new Number(2, ultimaFila + 9,
                    sumarColumnas(9, ultimaFila, hojaExc), times10));
            hojaExc.addCell(new Label(1, ultimaFila + 9, "Cantidad Salida:",
                    times10));

            hojaExc.addCell(new Number(2, ultimaFila + 11,
                    sumarColumnas(8, ultimaFila, hojaExc)
                    + sumarColumnas(9, ultimaFila, hojaExc), times10));
            hojaExc.addCell(new Label(1, ultimaFila + 11, "Cantidad Total:",
                    times10));

            hojaExc.addCell(new Number(5, ultimaFila + 7,
                    sumarColumnas(6, ultimaFila, hojaExc), times10));
//            hojaExc.addCell(new Number(5, ultimaFila + 7,
//                    sumarColumnas(6, ultimaFila, hojaExc), times10));
            hojaExc.addCell(new Label(4, ultimaFila + 7, "Valor de Entrada:",
                    times10));

            hojaExc.addCell(new Number(5, ultimaFila + 9,
                    sumarColumnas(7, ultimaFila, hojaExc), times10));
            hojaExc.addCell(new Label(4, ultimaFila + 9, "Valor de Salida:",
                    times10));

            hojaExc.addCell(new Number(5, ultimaFila + 11,
                    sumarColumnas(6, ultimaFila, hojaExc)
                    + sumarColumnas(7, ultimaFila, hojaExc), times10));
            hojaExc.addCell(new Label(4, ultimaFila + 11, "Valor Total:",
                    times10));

            hojaExc.removeColumn(6);
            hojaExc.removeColumn(6);
            hojaExc.removeColumn(6);
            hojaExc.removeColumn(6);
        } else {
            // En caso de Ventas Por Producto o por categoria de Producto
            hojaExc.addCell(new Label(0, ultimaFila + 1,
                    "       Total Facturas:", timesLines));

//            hojaExc.addCell(new jxl.write.Formula(1,
//                    ultimaFila + 1, //total de fact
//                    "COUNT(B11:B" + ultimaFila + ")", timesLines)); 
            hojaExc.addCell(new Number(1, ultimaFila + 1,
                    contarFacturasDiferentes(
                            ultimaFila, hojaExc), timesLines));
//           
            hojaExc.addCell(new jxl.write.Formula(5, ultimaFila + 1,
                    "SUM(F11:F" + ultimaFila + ")", timesLines));

            hojaExc.addCell(new Number(7, ultimaFila + 1,
                    multiplicarColmunasYSumarResultado(5, 7,
                            ultimaFila, hojaExc), timesLines));
        }
    }

    /**
     * Suma columnas, del una hoja excel WritableSheet.
     *
     * @param columna
     * @param ultimaFila
     * @param hojaExc
     * @return
     */
    public double sumarColumnas(int columna, int ultimaFila, WritableSheet hojaExc) {

        double resultado = 0;
        for (int i = 10; i < ultimaFila; i++) {

            resultado = resultado + Double.parseDouble(hojaExc.
                    getColumn(columna)[i].getContents().toString());
        }

        return resultado;
    }

    /**
     * Multiplica dos columnas y retorna la suma de dicha multiplicacion
     *
     * @param col1
     * @param col2
     * @param ultimaFila
     * @param hojaExc
     * @return
     */
    public double multiplicarColmunasYSumarResultado(
            int col1, int col2, int ultimaFila, WritableSheet hojaExc) {

        double resultado = 0;
        for (int i = 10; i < ultimaFila; i++) {

            resultado = resultado + (Double.parseDouble(hojaExc.
                    getColumn(col1)[i].getContents().toString()) * Double.parseDouble(hojaExc.
                            getColumn(col2)[i].getContents().toString()));
        }

        return resultado;
    }

    public int contarFacturasDiferentes(int ultimaFila, WritableSheet hojaExc) {
        int result = 0;
        ArrayList<Integer> NumFact = new ArrayList<Integer>();
        for (int i = 10; i < ultimaFila; i++) {
            if (NumFact.indexOf(Integer.parseInt(hojaExc.
                    getColumn(1)[i].getContents().toString())) == -1) {
                NumFact.add(Integer.parseInt(hojaExc.
                        getColumn(1)[i].getContents().toString()));
                result++;
            }

        }

        return result;
    }

    /**
     * Permite agregar mas hojas a el archivo de excel existente
     *
     * @param nombreHoja
     * @param pag
     * @param infoEmpresa
     * @param datosFact
     * @param nombresColum
     * @param infoFact
     * @throws IOException
     * @throws WriteException
     */
    public void escribirHojas(String nombreHoja, int pag, String[] infoEmpresa,
            Object[][] datosFact, String[] nombresColum, Object[] infoFact)
            throws IOException, WriteException {
        workbook.createSheet(nombreHoja + pag, pag);//***crear una hoja***
        WritableSheet hojaExcel = workbook.getSheet(pag);//obtiene la pagina pag

        ///tipos de letra
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // times10pt.setItalic(true);//tipo de letra italic
        WritableFont times14pt = new WritableFont(WritableFont.TIMES, 14);
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
        WritableFont times11pt = new WritableFont(WritableFont.TIMES, 11);
        times14pt.setColour(Colour.BLUE_GREY);
        workbook.setColourRGB(Colour.VIOLET, 54, 96, 146);//crear color RGB
        times11pt.setColour(Colour.VIOLET);

        // formato para escribir linea separadora
        WritableFont timesLinespt = new WritableFont(WritableFont.TIMES, 14);
        timesLines = new WritableCellFormat(timesLinespt);
        timesLines.setBorder(Border.TOP, BorderLineStyle.SLANTED_DASH_DOT,
                Colour.BLUE_GREY);
        timesLines.setAlignment(Alignment.CENTRE);

        //asignar el tipo de letra times12pt al formato times12
        times12 = new WritableCellFormat(times12pt);
        //asignar el tipo de letra times10pt al formato times10
        times10 = new WritableCellFormat(times10pt);
        //asignar el tipo de letra times14pt al formato times14
        times14 = new WritableCellFormat(times14pt);
        //asignar el tipo de letra times11pt al formato times11
        times11 = new WritableCellFormat(times11pt);

        workbook.setColourRGB(Colour.VIOLET2, 197, 217, 241);
        times11.setBackground(Colour.VIOLET2);
        timesReport = new WritableCellFormat(times11pt);

        //escribir datos de la empresa
        hojaExcel.addCell(new Label(0, 0, infoEmpresa[0], times14));
        for (int i = 1; i < 4; i++) {//set info de la empresa
            hojaExcel.addCell(new Label(0, i, infoEmpresa[i], times10));
        }

        hojaExcel.mergeCells(3, 1, 4, 1);
        hojaExcel.addCell(new Label(3, 1, nombreHoja + " Modificada " + infoFact[0]
                .toString(), times11));
        hojaExcel.addCell(new Label(0, 6, nombreHoja + "   " + infoFact[1]
                .toString(), times11));
        hojaExcel.addCell(new Label(1, 6, "Vendedor: " + infoFact[4]
                .toString(), times11));
        hojaExcel.addCell(new Label(2, 6, "Cliente: " + infoFact[3]
                .toString(), times11));
        hojaExcel.addCell(new Label(3, 6, "    ", times11));

//        //tipo de reporte 
//        timesReport.setIndentation(3);
//        hojaExcel.addCell(new Label(2, 6, tipoDeReporte, timesReport));
        //Colocar Nombres de las columnas
        establecerNombresDecolumnas(nombresColum, hojaExcel);

        //cargar datos de las facturas
        int ultimaFila = 10;
        if (datosFact.length != 0) {//verifica que contenga datos
            ultimaFila = cargarDatos(datosFact, hojaExcel);

//            //Escribir el total dependiendo el tipo de reporte
//            escribirResultado(tipoDeReporte, hojaExcel, ultimaFila);
        } else {// si no hay datos escribe total cero

            hojaExcel.addCell(new Label(1, 11, "Total  0",
                    timesLines));
        }
        //escribir resultados totales de factura
        hojaExcel.addCell(new Label(2, ultimaFila + 3, "               "
                + "              Sub Total:", times11));
        hojaExcel.addCell(new Number(3, ultimaFila + 3,
                Double.parseDouble(infoFact[6].toString()), times10));

        hojaExcel.addCell(new Label(2, ultimaFila + 4, "               "
                + "         Descuento%:", times11));
        hojaExcel.addCell(new Number(3, ultimaFila + 4,
                Double.parseDouble(infoFact[5].toString()), times10));

        hojaExcel.addCell(new Label(2, ultimaFila + 5, "               "
                + "                   Total: ", times11));
        hojaExcel.addCell(new Number(3, ultimaFila + 5,
                Double.parseDouble(infoFact[7].toString()), times10));

        hojaExcel.addCell(new Label(0, ultimaFila + 8, "Nota: ", times11));

        hojaExcel.addCell(new Label(0, ultimaFila + 9, infoFact[8].toString(),
                times10));

    }

    /**
     * Permite crea un archivo de Excel para luego escribir varias hojas
     *
     * @throws IOException
     */
    public void crearLibro() throws IOException {
        //Poner el nombre al ArchivoExcel
        ArchivoExcel = new File(nombreArchivoExcel);
        //configuracion de el libro de trabajo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("en", "EN"));
        //Configu default para generar la hoja de cálculo
        //Crea un libro, con su nombre de Archivo y la respectiva configuracion
        workbook = Workbook.createWorkbook(ArchivoExcel, wbSettings);
    }

    /**
     * escritura especial para reportes de ingresos Tipo 1 es para conceptos
     * Cancelada,apartado,credito,develuciones. Y recibe
     * ingresos[totalDev,totalCancelada,totalApartado,totalCredito]
     *
     * Tipo 2 es para concepto tarjeta,contado. Y recibe
     * ingresos[efectivo,tarjeta]
     *
     * @param infoEmpresa
     * @param ingresos
     * @param fechaIni
     * @param fechaFin
     * @param formato
     * @throws IOException
     * @throws WriteException
     */
    public void escribirIngresos(String[] infoEmpresa, int[] ingresos,
            String fechaIni, String fechaFin, String formato, int tipo)
            throws IOException, WriteException {

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
        // times10pt.setItalic(true);//tipo de letra italic
        WritableFont times14pt = new WritableFont(WritableFont.TIMES, 14);
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 12);
        WritableFont times11pt = new WritableFont(WritableFont.TIMES, 11);
        times14pt.setColour(Colour.BLUE_GREY);
        workbook.setColourRGB(Colour.VIOLET, 54, 96, 146);//crear color RGB
        times11pt.setColour(Colour.VIOLET);

        // formato para escribir linea separadora
        WritableFont timesLinespt = new WritableFont(WritableFont.TIMES, 14);
        timesLines = new WritableCellFormat(timesLinespt);
        timesLines.setBorder(Border.TOP, BorderLineStyle.SLANTED_DASH_DOT,
                Colour.BLUE_GREY);
        timesLines.setAlignment(Alignment.CENTRE);

        //asignar el tipo de letra times12pt al formato times12
        times12 = new WritableCellFormat(times12pt);
        //asignar el tipo de letra times10pt al formato times10
        times10 = new WritableCellFormat(times10pt);
        //asignar el tipo de letra times14pt al formato times14
        times14 = new WritableCellFormat(times14pt);
        //asignar el tipo de letra times11pt al formato times11
        times11 = new WritableCellFormat(times11pt);

        workbook.setColourRGB(Colour.VIOLET2, 197, 217, 241);
        times11.setBackground(Colour.VIOLET2);
        timesReport = new WritableCellFormat(times11pt);

        //escribir datos de la empresa
        hojaExcel.addCell(new Label(0, 0, infoEmpresa[0], times14));
        for (int i = 1; i <= 4; i++) {//set info de la empresa
            hojaExcel.addCell(new Label(0, i, infoEmpresa[i], times10));
        }
        hojaExcel.mergeCells(0, 8, 1, 8);
        hojaExcel.mergeCells(2, 12, 3, 12);
        hojaExcel.mergeCells(2, 8, 3, 8);
        hojaExcel.mergeCells(2, 9, 3, 9);
        hojaExcel.mergeCells(0, 13, 3, 13);
        hojaExcel.mergeCells(0, 14, 1, 14);
        hojaExcel.mergeCells(2, 14, 3, 14);
        hojaExcel.mergeCells(0, 10, 1, 10);
        hojaExcel.mergeCells(2, 11, 3, 11);
        hojaExcel.mergeCells(2, 10, 3, 10);
        hojaExcel.mergeCells(0, 11, 1, 11);
        hojaExcel.mergeCells(0, 12, 1, 12);
        hojaExcel.mergeCells(0, 15, 3, 15);
        hojaExcel.mergeCells(0, 16, 3, 16);
        hojaExcel.mergeCells(0, 6, 3, 6);
        hojaExcel.mergeCells(0, 7, 3, 7);
        hojaExcel.mergeCells(0, 9, 1, 9);

        hojaExcel.setColumnView(0, 25);

        hojaExcel.addCell(new Label(0, 6,
                "      Ingresos " + "desde el " + fechaIni + " hasta el " + fechaFin,
                times11));

        hojaExcel.addCell(new Label(0, 8, "      Concepto de Factura", times11));
        hojaExcel.addCell(new Label(2, 8, "             Monto", times11));

        if (tipo == 1) {
            hojaExcel.addCell(new Label(0, 9, "                Cancelada", times10));

            hojaExcel.addCell(new Number(2, 9, ingresos[1], times10));

            hojaExcel.addCell(new Label(0, 10, "                Apartados", times10));

            hojaExcel.addCell(new Number(2, 10, ingresos[2], times10));

            hojaExcel.addCell(new Label(0, 11, "                Creditos", times10));

            hojaExcel.addCell(new Number(2, 11, ingresos[3], times10));

            hojaExcel.addCell(new Label(0, 12, "                Devoluciones", times10));

            hojaExcel.addCell(new Number(2, 12, -ingresos[0], times10));
            hojaExcel.addCell(new Number(2, 14,
                    -ingresos[0] + ingresos[1] + ingresos[2] + ingresos[3], times14));

        } else {
            hojaExcel.addCell(new Label(0, 10, "                Efectivo", times10));

            hojaExcel.addCell(new Number(2, 10, ingresos[0], times10));

            hojaExcel.addCell(new Label(0, 11, "                Tarjeta", times10));

            hojaExcel.addCell(new Number(2, 11, ingresos[1], times10));
            hojaExcel.addCell(new Number(2, 14,
                    ingresos[0] + ingresos[1], times14));
        }

        hojaExcel.addCell(new Label(0, 13, "                       ", times11));

        hojaExcel.addCell(new Label(0, 14, "     Total ", times14));

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        hojaExcel.addCell(new Label(0, 16, "Fecha de impresion de reporte: "
                + dateFormat.format(date), times10));

//        //Escribe los datos contenidos en este libro en formato Excel
        workbook.write();
//
//        //cerrar libro liberando memoria
        workbook.close();
        if (formato.equals("Excel")) {
            //mostrar el Excel
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "
                        + nombreArchivoExcel);
            } catch (IOException e) {
                System.out.println("Error al abrir el archivo "
                        + nombreArchivoExcel + "\n" + e.getMessage());
            }
        }
//    
    }

    ////////////*****************************/////////////////////////
    ///Esta parte es exclusivo para la tienda valeska/////////////////
    /**
     * Permite escribir la Proforma
     *
     * @param info
     * @param datos
     * @throws java.io.IOException
     * @throws jxl.write.WriteException
     */
    public void escribirProforma(String[] info, Object[][] datos)
            throws IOException, WriteException {

        //String[]info2={Cliente,Direccion,telefono,Observacion,Lote,Transporte,Numero,Serie}
        String[] info2 = {"00004 - A - COMERCIAL VALESKA IV", "AV 1.CALLES 14 Y 16", "89792102", " ESTA ES UNA CADENA QUE MIDE 80 DE LONGUITUD O QUE ES LO MISMO SU LONGITUD ES 80", "01", "SI¿Transportes?", "005529", "AAA"};
        //Object[][]datos2={{cantida,codigo,descripcion,precioD}}
        Object[][] datos2 = {{"6", "745303846536", "EVOK SPRAY SECADOR DE UÑAS 8,5 OZ", "200.00"}, {"25", "7501906611633", "APPLE MASCARA CACAHUATE", "1200.00"}};

        Date date = new Date();//hora Actual
        String fechaAct = dateFormat.format(date);
        setNombreArchivoExcel("PROFORMA "
                + fechaAct + ".xls");//Nombre del excel "Fisico"
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

        hojaExcel.getSettings().setLeftMargin(0.25);
        hojaExcel.getSettings().setRightMargin(0.1);
        hojaExcel.getSettings().setTopMargin(0.2);

        ///tipos de letra
        FontName fontName = WritableFont.createFont("Calibri");
        WritableFont calibri10font = new WritableFont(fontName, 10,
                WritableFont.NO_BOLD);
        WritableCellFormat calibri10format = new WritableCellFormat(
                calibri10font);
        calibri10format.setVerticalAlignment(VerticalAlignment.TOP);
//        calibri10format.setWrap(true);
//		calibri10format.setAlignment(Alignment.LEFT);
//		calibri16format.setBackground(Colour.BLACK);

        FontName fontName2 = WritableFont.createFont("Calibri");
        WritableFont calibri10font2 = new WritableFont(fontName2, 10,
                WritableFont.NO_BOLD);
        WritableCellFormat calibri10format2 = new WritableCellFormat(
                calibri10font2);
        calibri10format2.setVerticalAlignment(VerticalAlignment.TOP);
        calibri10format2.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
        calibri10format2.setWrap(true);
        calibri10format2.setAlignment(Alignment.CENTRE);
//		calibri16format.setBackground(Colour.BLACK);

        FontName fontName3 = WritableFont.createFont("Calibri");
        WritableFont calibri10font3 = new WritableFont(fontName3, 10,
                WritableFont.NO_BOLD);
        WritableCellFormat calibri10format3 = new WritableCellFormat(
                calibri10font3);
        calibri10format3.setVerticalAlignment(VerticalAlignment.TOP);
        calibri10format3.setBorder(Border.BOTTOM, BorderLineStyle.THIN);
        calibri10format3.setWrap(true);
//        calibri10format3.setAlignment(Alignment.CENTRE);
//		calibri16format.setBackground(Colour.BLACK);

        //asignar el tipo de letra times12pt al formato times12
        WritableFont times12pt = new WritableFont(WritableFont.TIMES, 10);

        times12 = new WritableCellFormat(times12pt);

        times12.setWrap(true);

        hojaExcel.setColumnView(2, 10);
//        hojaExcel.mergeCells(1, 3, 2, 3);
        hojaExcel.addCell(new Label(5, 3, "PROFORMA", calibri10format2));

//        hojaExcel.setColumnView(0, 35);
        hojaExcel.setRowView(6, 240, false);
        hojaExcel.addCell(new Label(0, 6, "Cliente. " + info2[0], calibri10format));
        hojaExcel.setRowView(7, 240, false);
        hojaExcel.addCell(new Label(0, 7, "Dirección. " + info2[1], calibri10format));
        hojaExcel.setRowView(8, 240, false);
        hojaExcel.addCell(new Label(0, 8, "Teléfono. " + info2[2], calibri10format));
//        hojaExcel.setRowView(9, 500, false);
//        int es = espacio(info2[3]);

        int ultimaFila = 9;
        if (info2[3].length() >= 22) {
            hojaExcel.addCell(new Label(0, 9, "Observación. " + info2[3].substring(0, 21), calibri10format));
            System.out.println(info2[3].substring(0, 21));
            info2[3] = info2[3].substring(21);
            boolean a = true;
            while (a) {
                if (info2[3].length() >= 35) {
                    System.out.println(info2[3].substring(0, 34));
                    hojaExcel.addCell(new Label(0, ultimaFila+1,info2[3].substring(0, 34), calibri10format));
                    info2[3] = info2[3].substring(34);
                    
                    
                } else {
                    System.out.println("ULTIMA"+info2[3]);
                    hojaExcel.addCell(new Label(0, ultimaFila+1, info2[3], calibri10format));
                    a =false;
                }
                ultimaFila++;
            }

        } else {
            hojaExcel.addCell(new Label(0, 9, "Observación. " + info2[3], calibri10format));

        }

        hojaExcel.setRowView(ultimaFila + 1, 240, false);
        hojaExcel.addCell(new Label(0, ultimaFila + 1, "Lote. " + info2[4], calibri10format));
        hojaExcel.setRowView(ultimaFila + 1, 240, false);
        hojaExcel.addCell(new Label(0, ultimaFila + 2, "Transporte. " + info2[5], calibri10format));
        hojaExcel.setRowView(ultimaFila + 2, 240, false);
        hojaExcel.setColumnView(5, 20);
        hojaExcel.addCell(new Label(7, 3, "              Fecha. " + fechaAct.substring(0, 10), calibri10format));
        hojaExcel.addCell(new Label(7, 4, "              Número. " + info2[6], calibri10format));
        hojaExcel.addCell(new Label(7, 5, "              Serie. " + info2[7], calibri10format));

        hojaExcel.mergeCells(0, ultimaFila + 2, 8, ultimaFila+2);
        hojaExcel.addCell(new Label(0, ultimaFila + 2, "Cantidad                                                   Código                                                   Descripción                                                   Precio D. ", calibri10format3));
        hojaExcel.mergeCells(0, ultimaFila + 1, 8, ultimaFila + 1);
        hojaExcel.addCell(new Label(0, ultimaFila + 1, "", calibri10format2));

        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // times10pt.setItalic(true);//tipo de letra italic
        WritableFont times14pt = new WritableFont(WritableFont.TIMES, 14);

        WritableFont times11pt = new WritableFont(WritableFont.TIMES, 11);
        times14pt.setColour(Colour.BLUE_GREY);
        workbook.setColourRGB(Colour.VIOLET, 54, 96, 146);//crear color RGB
        times11pt.setColour(Colour.VIOLET);

        // formato para escribir linea separadora
        WritableFont timesLinespt = new WritableFont(WritableFont.TIMES, 14);
        timesLines = new WritableCellFormat(timesLinespt);
        timesLines.setBorder(Border.TOP, BorderLineStyle.SLANTED_DASH_DOT,
                Colour.BLUE_GREY);
        timesLines.setAlignment(Alignment.CENTRE);

        //asignar el tipo de letra times10pt al formato times10
        times10 = new WritableCellFormat(times10pt);
        //asignar el tipo de letra times14pt al formato times14
        times14 = new WritableCellFormat(times14pt);
        //asignar el tipo de letra times11pt al formato times11
        times11 = new WritableCellFormat(times11pt);

        workbook.setColourRGB(Colour.VIOLET2, 197, 217, 241);
        times11.setBackground(Colour.VIOLET2);
        timesReport = new WritableCellFormat(times11pt);

        //escribir datos de la empresa
//        hojaExcel.mergeCells(0, 8, 1, 8);
//        hojaExcel.mergeCells(2, 12, 3, 12);
//        hojaExcel.mergeCells(2, 8, 3, 8);
//        hojaExcel.mergeCells(2, 9, 3, 9);
//        hojaExcel.mergeCells(0, 13, 3, 13);
//        hojaExcel.mergeCells(0, 14, 1, 14);
//        hojaExcel.mergeCells(2, 14, 3, 14);
//        hojaExcel.mergeCells(0, 10, 1, 10);
//        hojaExcel.mergeCells(2, 11, 3, 11);
//        hojaExcel.mergeCells(2, 10, 3, 10);
//        hojaExcel.mergeCells(0, 11, 1, 11);
//        hojaExcel.mergeCells(0, 12, 1, 12);
//        hojaExcel.mergeCells(0, 15, 3, 15);
//        hojaExcel.mergeCells(0, 16, 3, 16);
//        hojaExcel.mergeCells(0, 6, 3, 6);
//        hojaExcel.mergeCells(0, 7, 3, 7);
//        hojaExcel.mergeCells(0, 9, 1, 9);
//
//        hojaExcel.setColumnView(0, 25);
//        hojaExcel.addCell(new Label(0, 6,
//                "      Ingresos " + "desde el " + fechaIni + " hasta el " + fechaFin,
//                times11));
//
//        hojaExcel.addCell(new Label(0, 8, "      Concepto de Factura", times11));
//        hojaExcel.addCell(new Label(2, 8, "             Monto", times11));
//
//        if (tipo == 1) {
//            hojaExcel.addCell(new Label(0, 9, "                Cancelada", times10));
//
//            hojaExcel.addCell(new Number(2, 9, ingresos[1], times10));
//
//            hojaExcel.addCell(new Label(0, 10, "                Apartados", times10));
//
//            hojaExcel.addCell(new Number(2, 10, ingresos[2], times10));
//
//            hojaExcel.addCell(new Label(0, 11, "                Creditos", times10));
//
//            hojaExcel.addCell(new Number(2, 11, ingresos[3], times10));
//
//            hojaExcel.addCell(new Label(0, 12, "                Devoluciones", times10));
//
//            hojaExcel.addCell(new Number(2, 12, -ingresos[0], times10));
//            hojaExcel.addCell(new Number(2, 14,
//                    -ingresos[0] + ingresos[1] + ingresos[2] + ingresos[3], times14));
//
//        } else {
//            hojaExcel.addCell(new Label(0, 10, "                Efectivo", times10));
//
//            hojaExcel.addCell(new Number(2, 10, ingresos[0], times10));
//
//            hojaExcel.addCell(new Label(0, 11, "                Tarjeta", times10));
//
//            hojaExcel.addCell(new Number(2, 11, ingresos[1], times10));
//            hojaExcel.addCell(new Number(2, 14,
//                    ingresos[0] + ingresos[1], times14));
//        }
//        hojaExcel.addCell(new Label(0, 13, "                       ", times11));
//
//        hojaExcel.addCell(new Label(0, 14, "     Total ", times14));
//        //Escribe los datos contenidos en este libro en formato Excel
        workbook.write();
//
//        //cerrar libro liberando memoria
        workbook.close();

//        //mostrar el Excel
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "
                    + nombreArchivoExcel);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo "
                    + nombreArchivoExcel + "\n" + e.getMessage());
        }

    }

    private int espacio(String observacion) {
        int result = 240;
        if (observacion.length() > 24) {
            double division = observacion.length() / 35.0;
            result += 480 * division;

            System.out.println(division);

        }
        System.out.println(result);
        return result;

    }

}
