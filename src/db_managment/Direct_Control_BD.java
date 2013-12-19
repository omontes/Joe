/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_managment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Monicaticooo
 */
public class Direct_Control_BD {

    private Connection conection;
    private Statement statement;
    private String[] columnNames;
    private Object[][] data;

    public Direct_Control_BD(Connection conection, Statement statement) {
        this.conection = conection;
        this.statement = statement;

    }

    /**
     * Obtiene el valor del inventario segun el nombre del inventario La
     * consulta devuelve los siguientes atributos: idProducto,Nombre,Precio,
     * Cantidad,ValordeVenta
     *
     * @param nombreInv
     */
    public void valorInventario(String UbicacionInv) {// esta bien
        try {
            String valorInventario = this.readSql("../monicaticoo/"
                    + "src/sql_files/ValorInventario.sql");
            PreparedStatement stm = this.conection.prepareStatement(valorInventario);
            stm.setString(1, UbicacionInv);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3)
                        + "||" + resultset.getInt(4) + "||"
                        + resultset.getInt(5));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el valor del inventario");
        }

    }

    /**
     * Obtiene todos los productos que estan agotados en el lugar del inventario
     * elegido
     */
    public void verProductosAgotados(String UbicacionInv) {//esta bien
        try {
            String verProductosAgotados = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "verProductosAgotados.sql");
            PreparedStatement stm = this.conection.prepareStatement(verProductosAgotados);
            stm.setString(1, UbicacionInv);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los productos agotados");
        }

    }

    /**
     * @param idCLiente Este metodo da como resultados todas las ventas hechas a
     * un determinado cliente
     *
     * El resultado es el sig: Fecha, Descripcion , Monto
     */
    public void consultarVentasXCliente(int idCliente) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarVentasXCliente.sql");
            PreparedStatement stm = this.conection.prepareStatement(dato);
            stm.setInt(1, idCliente);
            stm.setInt(2, idCliente);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas de un cliente");
        }

    }

    /**
     * @param idVendedor Este metodo da como resultados todas las ventas hechas
     * a por determinado vendedor
     *
     * El resultado es el sig: Fecha, Descripcion , Monto
     */
    public void consultarVentasXVendedor(int idVendedor) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarVentasxVendedor.sql");
            PreparedStatement stm = conection.prepareStatement(dato);
            stm.setInt(1, idVendedor);
            stm.setInt(2, idVendedor);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas de un vendedor");
        }

    }

    /**
     *
     * @param idProducto
     *
     * Consulta todas las ventas que se le han hecho a un producto
     *
     */
    public void consultarVentasXProducto(String idProducto) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarVentasXProducto.sql");
            PreparedStatement stm = conection.prepareStatement(dato);
            stm.setString(1, idProducto);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getInt(2) + "||"
                        + resultset.getInt(3) + "||" + resultset.getInt(4));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas de un producto");
        }

    }

    /**
     *
     * @param idCliente
     */
    public void consultarPagosCliente(int idCliente) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarPagosCliente.sql");
            PreparedStatement stm = conection.prepareStatement(dato);
            stm.setInt(1, idCliente);

            ResultSet resultset = stm.executeQuery(dato);
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener los pagos de un cliente");
        }

    }

    /**
     * Da todas las ventas de un tipo de pago
     *
     * @param TipoDePago Devuelve Fecha,Factura,Cantidad,Precio
     */
    public void consultarVentasXTipoPago(String TipoDePago) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarVentasXTipoPago.sql");
            PreparedStatement stm = conection.prepareStatement(dato);
            stm.setString(1, TipoDePago);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getInt(2) + "||"
                        + resultset.getInt(3) + "||" + resultset.getInt(4));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener lod pagos de un cliente");
        }

    }

    /**
     *
     * @param idVendedor
     *
     *
     */
    public void consultarVentasXVendedorYCliente(int idVendedor) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarVentasXVendedorYCliente.sql");
            PreparedStatement stm = conection.prepareStatement(dato);
            stm.setInt(1, idVendedor);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3) + "||" + resultset.getString(4)
                        + "||" + resultset.getString(5));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas x vendedor y cliente");
        }

    }

    /**
     *
     * @param idProducto
     */
    public void consultarMovimientosProductos(String idProducto) {
        try {
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "consultarMovimientosProductos.sql");
            PreparedStatement stm = conection.prepareStatement(dato);
            stm.setString(1, idProducto);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getString(3) + "||" + resultset.getString(4)
                        + "||" + resultset.getInt(5)
                        + "||" + resultset.getInt(6)
                        + "||" + resultset.getString(7));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas a un cliente");
        }

    }

    public ResultSet cierreDeVentasXFecha(String FechaInicio, String FechaFinal) {
        try {
           
            String dato = this.readSql("../monicaticoo/src/"
                    + "sql_files/"
                    + "CierreDeVentasxFecha.sql");
            PreparedStatement stm = this.conection.prepareStatement(dato);
            stm.setString(1, FechaInicio);
            stm.setString(2, FechaFinal);
            stm.setString(3, FechaInicio);
             stm.setString(4, FechaFinal);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            while (resultset.next()) {
              
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getString(2) + "||"
                        + resultset.getInt(3));
                
            }
          return resultset;

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas x fechha");
            return null;
        }
        
        

    }

    /**
     * Recibe un arreglo con todos los atributos necesarios para ingresar un
     * producto que pertenece a un inventario especifico La fecha que esta por
     * default es la del dia
     *
     * @param Producto
     */
    public void insertProductoPorCategoria(String[] Producto,
            int idUbicacionProducto, int idCategoria) {
        String idProducto = Producto[0];
        String nombre = Producto[1];
        int Cantidad = Integer.parseInt(Producto[2]);
        int Precio = Integer.parseInt(Producto[3]);
        int Costo = Integer.parseInt(Producto[4]);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String fecha = dateFormat.format(date);

        //crear el producto
        crearProducto(idProducto, nombre, Precio, Costo, fecha, "A",
                "AlgunaDescripcion", idCategoria);
        //insertar los productos creados al inventario
        insertarEnInventario(idProducto, idUbicacionProducto, Cantidad);
    }

    /**
     * Crea un nuevo Producto
     *
     * @param idProducto
     * @param nombre
     * @param precio
     * @param costo
     * @param fechaCreacion
     * @param estado
     * @param Descripcion
     * @param idCategoria
     */
    public void crearProducto(String idProducto, String nombre, int precio,
            int costo, String fechaCreacion, String estado, String Descripcion,
            int idCategoria) {//revisado +
        try {
            String CrearProducto = this.readSql("../monicaticoo/src/"
                    + "sql_files/CrearProducto.sql");
            PreparedStatement stm = conection.prepareStatement(CrearProducto);
            stm.setString(1, idProducto);
            stm.setString(2, nombre);
            stm.setInt(3, precio);
            stm.setInt(4, costo);
            stm.setString(5, fechaCreacion);
            stm.setString(6, estado);
            stm.setString(7, Descripcion);
            stm.setInt(8, idCategoria);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al Error al crear producto");

        }
    }

    /**
     * Insertar productos en el inventario
     *
     * @param idProducto
     * @param idUbicacionProducto
     * @param cantidad
     */
    public void insertarEnInventario(String idProducto, int idUbicacionProducto,
            int cantidad) {// revisado+
        try {
            String insertarProductoEnInventario = this.readSql("../monicaticoo/src/"
                    + "sql_files/InsertarProductoEnInventario.sql");
            PreparedStatement stm = conection.prepareStatement(insertarProductoEnInventario);
            stm.setString(1, idProducto);
            stm.setInt(2, idUbicacionProducto);
            stm.setInt(3, cantidad);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar producto al inventario");

        }
    }

    /**
     * Muestra las Facturas pendientes(tanto credito como apartados)
     * Detalles:idFactura||Saldo||FechaVencimiento||TotalFacturado||Nombre
     * ||Tipopago
     */
    public void verFacturasPendientes() {//Bueno+
        try {
            String VerFacturasPendientes = readSql("../monicaticoo/src/"
                    + "sql_files/VerFacturasPendientes.sql");
            ResultSet rs = statement.executeQuery(VerFacturasPendientes);
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getInt(2) + "||" + rs.getString(3) + "||"
                        + rs.getInt(4) + "||" + rs.getString(5) + "||"
                        + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al ver facturas pendientes");
        }
    }

    /**
     * Muestra todos los apartados(Cerrados y Abiertos)
     * Detalles:idFactura||Saldo||FechaVencimiento||TotalFacturado||Nombre
     * ||Tipopago
     */
    public void verApartados() {//Bueno+
        try {
            String VerApartados = readSql("../monicaticoo/src/"
                    + "sql_files/VerApartados.sql");
            ResultSet rs = statement.executeQuery(VerApartados);
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getInt(2) + "||" + rs.getString(3) + "||"
                        + rs.getInt(4) + "||" + rs.getString(5) + "||"
                        + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al ver apartados");
        }
    }

    /**
     * Muestra los apartados pendientes
     * Detalles:idFactura||Saldo||FechaVencimiento||TotalFacturado||Nombre
     * ||Tipopago
     */
    public void verApartadosPendientes() {//Bueno+
        try {
            String VerApartadosPen = readSql("../monicaticoo/src/"
                    + "sql_files/VerApartadosPendientes.sql");
            ResultSet rs = statement.executeQuery(VerApartadosPen);
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getInt(2) + "||" + rs.getString(3) + "||"
                        + rs.getInt(4) + "||" + rs.getString(5) + "||"
                        + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al ver apartados pendientes");
        }
    }

    /**
     * Muestra todos los creditos(Cerrados y Abiertos)
     * Detalles:idFactura||Saldo||FechaVencimiento||TotalFacturado||Nombre
     * ||Tipopago
     */
    public void verCreditos() {//Bueno+
        try {
            String VerCreditos = readSql("../monicaticoo/src/"
                    + "sql_files/VerCreditos.sql");
            ResultSet rs = statement.executeQuery(VerCreditos);
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getInt(2) + "||" + rs.getString(3) + "||"
                        + rs.getInt(4) + "||" + rs.getString(5) + "||"
                        + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al ver creditos");
        }
    }

    /**
     * Muestra todos los creditos pendientes(Abiertos)
     * Detalles:idFactura||Saldo||FechaVencimiento||TotalFacturado||Nombre
     * ||Tipopago
     */
    public void verCreditosPendientes() {//Bueno+
        try {
            String VerCreditosPendientes = readSql("../monicaticoo/src/"
                    + "sql_files/VerCreditosPendientes.sql");
            ResultSet rs = statement.executeQuery(VerCreditosPendientes);
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getInt(2) + "||" + rs.getString(3) + "||"
                        + rs.getInt(4) + "||" + rs.getString(5) + "||"
                        + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Error al ver creditos Pendientes");
        }
    }

    /**
     * Muestra la venta de los productos pertenecientes a una categoria en un
     * rango de fechas
     *
     * @param categoria
     * @param fechaInicial
     * @param fechaFinal
     */
    public void VentasProductoPorCategoriaFecha(int categoria,
            String fechaInicial, String fechaFinal) {//Revisado++
        try {
            String ventasProductoPorCategoria = this.readSql("../monicaticoo/src/"
                    + "sql_files/VentasProductoPorCategoriaYFecha.sql");
            PreparedStatement stm = conection.prepareStatement(ventasProductoPorCategoria);
            stm.setInt(1, categoria);
            stm.setString(2, fechaInicial);
            stm.setString(3, fechaFinal);
            ResultSet resultset = stm.executeQuery();

            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getInt(2) + "||"
                        + resultset.getString(3) + "||" + resultset.getString(4)
                        + "||" + resultset.getInt(5));
            }

        } catch (Exception e) {
            System.out.println("Error al ver Ventas Producto Por Categoria");
        }
    }

    /**
     * Crear una factura y llama al metodo cantidad factura
     *
     * @param descuento
     * @param tipoPago
     * @param idCliente
     * @param idVendedor
     * @param estado
     * @param nota
     */
    public void crearFactura(int descuento, String tipoPago, int idCliente,
            int idVendedor, String estado, String nota,
            int TotalFacturado) {//Revisado+
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String fecha = dateFormat.format(date);

        try {
            String CrearFactura = this.readSql("../monicaticoo/src/"
                    + "sql_files/CrearFactura.sql");
            PreparedStatement stm = conection.prepareStatement
        (CrearFactura,statement.RETURN_GENERATED_KEYS);
           
            stm.setInt(1, descuento);
            stm.setString(2, tipoPago);
            stm.setInt(3, idCliente);
            stm.setInt(4, idVendedor);
            stm.setString(5, estado);
            stm.setString(6, nota);
            stm.setString(7, fecha);
            stm.setInt(8, TotalFacturado);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while(rs.next()){
                System.out.println(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void consultarProducto(String idProducto) {//esta bien
        try {
            String valorInventario = this.readSql("../monicaticoo/src/"
                    + "sql_files/consultarProducto.sql");
            PreparedStatement stm = this.conection.prepareStatement(valorInventario);
            stm.setString(1, idProducto);
            ResultSet resultset = stm.executeQuery();

            while (resultset.next()) {
                System.out.println(resultset.getString(1)
                        + "||" + resultset.getInt(2) + "||" + resultset.
                        getInt(3)
                        + "||" + resultset.getString(4));
            }

        } catch (Exception e) {
            System.out.println("Error al obtener el producto");
        }

    }

    private String readSql(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }

    public void insertarMovimientos(String Fecha, String Detalle, String Tipo) {
        try {
            String movimientos = this.readSql("../monicaticoo/src/sql_files/"
                    + "InsertarMovimientos.sql");
            PreparedStatement stm = this.conection.prepareStatement(movimientos);
            stm.setString(1, Fecha);
            stm.setString(2, Detalle);
            stm.setString(3, Tipo);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar movimiento");
        }
    }

    public void cantidadDeProductos() {//esta bien
        try {
            String CantidadProductos = this.readSql("../monicaticoo/"
                    + "src/sql_files/CantidadDeProductos.sql");

            ResultSet rs = statement.executeQuery(CantidadProductos);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta de "
                    + "cantidadDeProducto");

        }
    }

    /**
     * Esta consulta retorna la lista de precios del inventario seleccionado
     * (Bodega o General) Ordenados por Categoria
     *
     * @param ubicaciondelInv
     */
    public void verListaDePrecioDelInventario(int ubicaciondelInv) {
//esta bien
        try {

            String listaDePrecios = this.readSql("../monicaticoo/src/sql_files/"
                    + "ListaDePreciosDelInventario.sql");

            PreparedStatement stm = this.conection.prepareStatement(listaDePrecios);
            stm.setInt(1, ubicaciondelInv);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getString(2) + "||" + rs.getInt(3)
                        + rs.getInt(4) + "||" + rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de precios");

        }

    }

    /**
     * Esta consulta permite ver los productos de una categoria en especifico y
     * de una ubicacion del inventario(Bodega o General)
     *
     * @param categoria
     * @param descripcionDeUnInv
     */
    public void verProductosPorCategoriaDeUnInv(String categoria,
            String LugarInventario) {//esta bien
        try {

            String productosPorCategoria = this.readSql("../monicaticoo/"
                    + "src/sql_files/ProductosPorCategoriaDeUnInventario.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(productosPorCategoria);
            stm.setString(1, categoria);
            stm.setString(2, LugarInventario);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getString(2) + "||" + rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los Productos por categoria");

        }

    }

    /**
     * Esta consulta obtiene todos los productos del inventario seleccionado
     * (Bodega o General) que no pertenecen a ninguna categoria.
     *
     * @param descripcionDeUnInv
     */
    public void verProductosSinCategoriaDeUnInv(String lugarDeUnInv) {//estabien
        try {

            String productosSinCategoria = this.readSql("../monicaticoo/"
                    + "src/sql_files/ProductosSinCategoria.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(productosSinCategoria);
            stm.setString(1, lugarDeUnInv);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getString(2) + "||" + rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los Productos sin categoria");

        }

    }

    /**
     * Esta Consulta Obtiene el movimiento de un producto por el termino de
     * facturacion. Se le debe proporcionar el lugar del inventario (Bodega o
     * General) y la fecha de rango de busqueda.
     *
     * @param lugarDeUnInv
     * @param fechaInicio
     * @param fechaFinal
     */
    public void verMovProductosFacturados(String lugarDeUnInv, String fechaInicio, String fechaFinal) {//esta bien
        try {

            String verMovProductosFacturados = this.readSql("../monicaticoo/"
                    + "src/sql_files/MovProductoFacturado.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verMovProductosFacturados);
            stm.setString(1, lugarDeUnInv);
            stm.setString(2, fechaInicio);
            stm.setString(3, fechaFinal);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getString(2) + "||" + rs.getInt(3) + "||"
                        + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los movimientos de los"
                    + " productos facturados");

        }

    }

    /**
     * Esta consulta muestra todos los movimientos de los productos ordenados
     * por fecha producto y el concepto del movimiento
     *
     * @param lugarDeUnInv
     * @param fechaInicio
     * @param fechaFinal
     */
    public void verMovProductosOrdenadosPorTipo(String lugarDeUnInv, String fechaInicio, String fechaFinal) {//esta bien
        try {

            String verMovProductosFacturadosPorTipo = this.readSql("../monicaticoo/"
                    + "src/sql_files/MovProductosPorTipo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verMovProductosFacturadosPorTipo);
            stm.setString(1, lugarDeUnInv);
            stm.setString(2, fechaInicio);
            stm.setString(3, fechaFinal);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getString(2) + "||" + rs.getString(3) + "||"
                        + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener los movimientos de los"
                    + " productos");

        }

    }

    /**
     * Esta consulta devuelve el movimiento de un producto en especifico
     *
     * @param idProducto
     * @param lugarDeUnInv
     * @param fechaInicio
     * @param fechaFinal
     */
    public void verMovProductoOrdenadoPorTipo(String idProducto,
            String lugarDeUnInv, String fechaInicio, String fechaFinal) {//esta bien
        try {

            String verMovProductoOrdenadoPorTipo = this.readSql("../monicaticoo/"
                    + "src/sql_files/MovProductoPorTipo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verMovProductoOrdenadoPorTipo);
            stm.setString(1, idProducto);
            stm.setString(2, lugarDeUnInv);
            stm.setString(3, fechaInicio);
            stm.setString(4, fechaFinal);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)
                        + "||" + rs.getString(2) + "||" + rs.getString(3) + "||"
                        + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el movimiento");

        }

    }

    public void modificarProducto(String idProducto, String nombre,
            int precio, int idCategoria) {//esta bien
        try {
            String ModificarProducto = this.readSql("../monicaticoo"
                    + "/src/sql_files/ModificarProducto.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ModificarProducto);
            stm.setString(1, nombre);
            stm.setInt(2, precio);
            stm.setInt(3, idCategoria);
            stm.setString(4, idProducto);

            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Modificar Producto");
        }
    }

    public void BuscarCategoriaPorDescripcion(String descripcionDeCategoria) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../monic"
                    + "aticoo/src/sql_files/BuscarCategoriaPorDescripcion.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(BuscarCategoriaPorDescripcion);
            stm.setString(1, descripcionDeCategoria);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener Categoria Por Descripcion");

        }

    }

    /**
     * Dado un idVendedor muestra los detalles de las ventas realizadas por este
     * en rango de fechas
     */
    public void ventasPorVendedor(int idVendedor) {//falta hacerla por fecha
        try {

            String ventasPorVend = this.readSql("../monic"
                    + "aticoo/src/sql_files/VentasPorVendedor.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ventasPorVend);
            stm.setInt(1, idVendedor);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "||" + rs.getString(2) + "||"
                        + rs.getString(3) + "||" + rs.getInt(4) + "||"
                        + rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener ventas por vendedor");

        }

    }
   /**
    * 
    * @param Fecha
    * @param TipoPago
    * @param TotalFacturado
    * @param idCliente
    * @param idVendedor
    * @param Nota 
    * 
    * INSERT INTO devolucion (Fecha, TipoPago, 
TotalFacturado, idClienteDev, idVendedorDev, Nota) 
VALUES (?, ?, ?, ?, ?, ?);
    */
    public int insertarDevoluciones(String Fecha, String TipoPago, int TotalFacturado,int idCliente
    ,int idVendedor, String Nota) {
        try {
            String devolucion = this.readSql("../monicaticoo/src/sql_files/"
                    + "insertarDevolucion.sql");
            PreparedStatement stm = this.conection.prepareStatement(devolucion, statement.RETURN_GENERATED_KEYS);
            stm.setString(1, Fecha);
            stm.setString(2, TipoPago);
            stm.setInt(3, TotalFacturado);
            stm.setInt(4, idCliente);
            stm.setInt(5, idVendedor);
            stm.setString(6, Nota);
            stm.executeUpdate();
            
            ResultSet rs = stm.getGeneratedKeys();

            rs.next();

            int idDevolucion = rs.getInt(1);
            return idDevolucion;

        } catch (Exception e) {
            System.out.println("Error al insertar Devoluciones");
            return 0;
        }
    }
    /**
     * 
     * @param idProductoDev
     * @param Cantidad
     * @param idDevolucion
     * @param idCliente
     * @param PrecioDev 
     * 
     * idProductoDev, Cantidad, idDevolucion, idVersionDev, PrecioDev
     */
    public void insertarproductocantidaddev(String idProductoDev, int Cantidad, int idDevolucion,int idCliente
    ,int PrecioDev) {
        try {
            String devolucion = this.readSql("../monicaticoo/src/sql_files/"
                    + "insertarProductoCantidadDev.sql");
            PreparedStatement stm = this.conection.prepareStatement(devolucion);
            stm.setString(1, idProductoDev);
            stm.setInt(2, Cantidad);
            stm.setInt(3, idDevolucion);
            stm.setInt(4, idCliente);
            stm.setInt(5, PrecioDev);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar producto cantidad dev");
        }
    }
    
    //Fecha, Detalle, idTipoMovimiento, CantidadMovida, Balance, idProductoMovimiento,
    //idLugarMovimiento
    
    public void insertarmovimiento(String Fecha, String Detalle, int idTipoMovimiento,
    int CantidadMovida, int Balance, String idProductoMovimiento,int idLugarMovimiento) {
        try {
            String devolucion = this.readSql("../monicaticoo/src/sql_files/"
                    + "insertarMovimiento.sql");
            PreparedStatement stm = this.conection.prepareStatement(devolucion);
            stm.setString(1, Fecha);
            stm.setString(2, Detalle);
            stm.setInt(3, idTipoMovimiento);
            stm.setInt(4, CantidadMovida);
            stm.setInt(5, Balance);
            stm.setString(6, idProductoMovimiento);
            stm.setInt(7, idLugarMovimiento);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar Devoluciones");
        }
    }
    
    public void crearCierreDeCaja(String FechaInicio, String FechaFinal,int Cajero,String NombreCaja
    , String Observacines)
    {
        ResultSet resultset = cierreDeVentasXFecha(FechaInicio,FechaFinal);
        try {
            while (resultset.next()) {
                String datos1=resultset.getString(1);
                String datos2=resultset.getString(2);
                int datos3=resultset.getInt(3);

                
            }
        } catch (SQLException ex) {
            System.out.println("Error al recorrer los cierre de ventas");
        }
    }
}
   
