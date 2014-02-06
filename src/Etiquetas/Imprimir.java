/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Etiquetas;

/**
 *
 * @author Jason
 */
public class Imprimir {

    DYMOLabelPrintConnector C = new DYMOLabelPrintConnector();

    /**
     * Envia a imprimir una matriz de etiquetas Orden de etiqueta:
     * Codigo,NombreProducto,CantidadEtiquetas,Precio. Orden infoEmpresa:
     * NombreEmpresa,telefono
     *
     * @param etiquetas
     * @param infoEmpresa
     */
    public void imprimirListaEtiquetas(String[][] etiquetas, String[] infoEmpresa) {
        establecerLosValoresEtiqueta(etiquetas[0][0], etiquetas[0][1], Integer.parseInt(etiquetas[0][2]),
                etiquetas[0][3], infoEmpresa[0], infoEmpresa[1]);

        C.imprimir(etiquetas);

    }

    /**
     * estblece los valores de la primer etiqueta a imprimir
     *
     * @param codigo
     * @param nombreProducto
     * @param precio
     * @param nombreEmpresa
     * @param telefono
     * @param cantidad
     */
    private void establecerLosValoresEtiqueta(String codigo,
            String nombreProducto, int cantidad, String precio, String nombreEmpresa,
            String telefono) {
        C.setCodigo(codigo);
        C.setNombreEmpresa(nombreEmpresa);
        C.setNombreProducto(nombreProducto);
        C.setPrecio(precio);
        C.setTelefono(telefono);
        C.setCantidad(cantidad);

    }

}
