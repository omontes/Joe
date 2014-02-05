/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etiquetas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author Jason
 */
public class DYMOLabelPrintConnector implements Printable {

    public static final String PRINTERNAME = "DYMO LabelWriter 450 Turbo";
    String[][] etiquetas;
    // indica si se debe mostrar el menu de impresion
    public static final boolean PRINTMENU = false;
    private String codigo;
    private String nombreProducto;
    private String precio;
    private String nombreEmpresa;
    private String telefono;
    private int totalEtiquetas;
    int PosMatr = 0;//corresponde la posicion sobre las matriz de etiquetas

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCantidad(int cantidad) {
        this.totalEtiquetas = cantidad;

    }

    public int getCantidad() {

        return totalEtiquetas;
    }

    /**
     * Imprime una matriz de etiquetas
     *
     * @param MEtiquetas
     * @return
     */
    public int imprimir(String MEtiquetas[][]) {
        etiquetas = MEtiquetas;
//        setCantidad(Integer.parseInt(etiquetas[0][5]));
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        Paper paper = new Paper();

        final double widthPaper = (1.75 * 72);// Dimension del ancho de la 
        // etiqueta en pulgadas 1/72 por pulgada
        final double heightPaper = (2.75 * 72); //Dimension del largo de la 
        // etiqueta en pulgadas 1/72 por pulgada

        paper.setSize(widthPaper, heightPaper);
        paper.setImageableArea(0, 0, widthPaper, heightPaper);

        pageFormat.setPaper(paper);
        pageFormat.setOrientation(PageFormat.LANDSCAPE);

        if (PRINTMENU) {//en caso de ser verdadero llama al menu de impresion
            if (printerJob.printDialog()) {
                printerJob.setPrintable(this, pageFormat);

                try {
                    printerJob.print();
                } catch (PrinterException e) {
                    e.printStackTrace();
                }
            }
            //Si no se quiere ver el menu se puede configurar con el printername
        } else {
            PrintService[] printService = PrinterJob.lookupPrintServices();

            for (int i = 0; i < printService.length; i++) {
                
                if (printService[i].getName().compareTo(PRINTERNAME) == 0) {
                    try {
                        printerJob.setPrintService(printService[i]);
                        printerJob.setPrintable(this, pageFormat);
                        printerJob.print();
                    } catch (PrinterException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return 1;
//        System.exit(0);

    }

    /**
     * Metodo recursivo continua cuando retorna PAGE_EXISTS, se detiene cuando
     * retorna NO_SUCH_PAGE
     *
     * @param graphics
     * @param pageFormat
     * @param pageIndex// etiqueta actual
     * @return
     * @throws PrinterException
     */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
            throws PrinterException {

        if (PosMatr < etiquetas.length) {
            Graphics2D g = (Graphics2D) graphics;
            if (pageIndex < getCantidad()) {

                //define la posicion inicial donde se va a escribir
                g.translate(5, 5);

                g.setFont(new Font(g.getFont().getFontName(), g.getFont().
                        getStyle(), 10));

                g.drawString(nombreProducto, 20 + ((176 - (nombreProducto.
                        length() * 5)) / 2), 55);

                g.drawString("¢"+precio, 20 + ((176 - (precio.
                        length() * 5)) / 2), 66);

                Barcode barcode = null;
                try {
                    barcode = BarcodeFactory.createCode128(codigo);
                } catch (BarcodeException ex) {
                    Logger.getLogger(DYMOLabelPrintConnector.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                barcode.setDrawingText(false);
                barcode.setBarHeight(32);
                barcode.setBarWidth(1);

                int posX = 0;
                try {
                    //posicion en la que se va a escribir el codigo de barras
                    posX = ((176 - BarcodeImageHandler.getImage(barcode).
                            getWidth()) / 2) + 20;
                    g.drawImage(BarcodeImageHandler.getImage(barcode), posX,
                            75, Color.black, barcode);
                } catch (OutputException ex) {
                    Logger.getLogger(DYMOLabelPrintConnector.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                int posCod = posX;
                try {
                    posCod = ((BarcodeImageHandler.getImage(barcode).
                            getWidth() - (codigo.length() * 5)) / 2) + posX;
                } catch (OutputException ex) {
                    Logger.getLogger(DYMOLabelPrintConnector.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                g.drawString(codigo, posCod, 115);
                g.setFont(new Font(g.getFont().getFontName(), g.getFont().
                        getStyle(), 30));
                AffineTransform at = new AffineTransform();
                at.setToRotation(Math.PI / 180.0);
                g.setTransform(at);
                posX = 25 + ((250 - (nombreEmpresa.length() * 15)) / 2);
                posCod = 25 + ((250 - (telefono.length() * 15)) / 2);

                g.drawString(nombreEmpresa, posX, 20);
                g.drawString(telefono, posCod, 45);

                return PAGE_EXISTS;
            } else {

//                g = null;
                PosMatr = PosMatr + 1;
                System.out.println(etiquetas.length);
                if (PosMatr < etiquetas.length) {
                    setCodigo(etiquetas[PosMatr][0]);
//                    setNombreEmpresa(etiquetas[PosMatr][1]);
                    setNombreProducto(etiquetas[PosMatr][1]);
                    setPrecio(etiquetas[PosMatr][3]);
//                    setTelefono(etiquetas[PosMatr][4]);

                    setCantidad(Integer.parseInt(etiquetas[PosMatr][2])
                            + pageIndex);
                    return PAGE_EXISTS;
                }

            }

        }
        return NO_SUCH_PAGE;
    }
}
