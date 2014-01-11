package db_managment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
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
    public Object[][] infoFact;
    private String[] NombresColumnas;
    private Object[][] Informacion;
    private static Direct_Control_BD AdminBD;

    public Direct_Control_BD(Connection conection, Statement statement) {
        this.conection = conection;
        this.statement = statement;

    }

    public static Direct_Control_BD getInstance() {
        if (AdminBD == null) {
            Setting_Up_BD setting = new Setting_Up_BD();
            AdminBD = new Direct_Control_BD(setting.getConection(), setting.getStatement());
        }
        return AdminBD;
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

            String valorInventario = this.readSql("../Joe/"
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
            String verProductosAgotados = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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
            String dato = this.readSql("../Joe/src/"
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

    public int cierreDeVentasXFecha(String FechaInicio, String FechaFinal) {
        try {

            String dato = this.readSql("../Joe/src/"
                    + "sql_files/"
                    + "CierreDeVentasxFecha.sql");
            PreparedStatement stm = this.conection.prepareStatement(dato);
            stm.setString(1, FechaInicio);
            stm.setString(2, FechaFinal);
            stm.setString(3, FechaInicio);
            stm.setString(4, FechaFinal);

            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido de ver productos agotados
            int totalVendido = 0;
            while (resultset.next()) {
                totalVendido += resultset.getInt(3);
                // resultset.getInt(3);
                // System.out.println(resultset.getString(1)
                //       + "||" + resultset.getString(2) + "||"
                //      + resultset.getInt(3));
                // System.out.println(totalVendido);
            }

            return totalVendido;

        } catch (Exception e) {
            System.out.println("Error al obtener las ventas x fechha");
            return 0;
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
        BigDecimal Precio = new BigDecimal(Producto[3]);
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
    public void crearProducto(String idProducto, String nombre, BigDecimal precio,
            int costo, String fechaCreacion, String estado, String Descripcion,
            int idCategoria) {//revisado +
        try {
            String CrearProducto = this.readSql("../Joe/src/"
                    + "sql_files/CrearProducto.sql");
            PreparedStatement stm = conection.prepareStatement(CrearProducto);
            stm.setString(1, idProducto);
            stm.setString(2, nombre);
            stm.setDouble(3, precio.doubleValue());
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
            String insertarProductoEnInventario = this.readSql("../Joe/src/"
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
            String VerFacturasPendientes = readSql("../Joe/src/"
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
            String VerApartados = readSql("../Joe/src/"
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
            String VerApartadosPen = readSql("../Joe/src/"
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
            String VerCreditos = readSql("../Joe/src/"
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
            String VerCreditosPendientes = readSql("../Joe/src/"
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
            String ventasProductoPorCategoria = this.readSql("../Joe/src/"
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
    public void crearFactura(int idFactura,BigDecimal descuento, String tipoPago, int idCliente,
            int idVendedor, String estado, String nota,BigDecimal TotalFacturado) {//Revisado+
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String fecha = dateFormat.format(date);

        try {
            String CrearFactura = this.readSql("../Joe/src/"
                    + "sql_files/CrearFactura.sql");
            PreparedStatement stm = conection.prepareStatement(CrearFactura, statement.RETURN_GENERATED_KEYS);

            stm.setInt(1, idFactura);
            stm.setDouble(2, descuento.doubleValue());
            stm.setString(3, tipoPago);
            stm.setInt(4, idCliente);
            stm.setInt(5, idVendedor);
            stm.setString(6, estado);
            stm.setString(7, nota);
            stm.setString(8, fecha);
            stm.setDouble(9, TotalFacturado.doubleValue());
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void consultarCategorias() {
        try {
            String categorias = this.readSql("../Joe/src/"
                    + "sql_files/consultarCategorias.sql");
            PreparedStatement stm = this.conection.prepareStatement(categorias);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener el categoria");
        }
    }

    public void consultarProducto(String idProducto) {//esta bien
        try {
            String valorInventario = this.readSql("../Joe/src/"
                    + "sql_files/consultarProducto.sql");
            PreparedStatement stm = this.conection.prepareStatement(valorInventario);
            stm.setString(1, idProducto);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));

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

    public void cantidadDeProductos() {//esta bien
        try {
            String CantidadProductos = this.readSql("../Joe/"
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

            String productosPorCategoria = this.readSql("../Joe/"
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

            String productosSinCategoria = this.readSql("../Joe/"
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

            String verMovProductosFacturados = this.readSql("../Joe/"
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

            String verMovProductosFacturadosPorTipo = this.readSql("../Joe/"
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

    public void verMovimientos() {//esta bien
        try {

            String verMovProductoOrdenadoPorTipo = this.readSql("../Joe/"
                    + "src/sql_files/verMovimientos.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verMovProductoOrdenadoPorTipo);

            ResultSet rs = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener el movimiento");

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

            String verMovProductoOrdenadoPorTipo = this.readSql("../Joe/"
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

    public void actualizarCantidadProductoInventario(int CantidadNueva, String idProducto, int idLugarMovimiento) {//esta bien
        try {
            String ModificarProducto = this.readSql("../Joe"
                    + "/src/sql_files/actualizarCantidadProductoInventario.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ModificarProducto);
            stm.setInt(1, CantidadNueva);
            stm.setString(2, idProducto);
            stm.setInt(3, idLugarMovimiento);

            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Actualizar la cantidad de un producto en el inventario");
        }
    }

    public void modificarProducto(String idProducto, String nombre,
            int precio, int idCategoria) {//esta bien
        try {
            String ModificarProducto = this.readSql("../Joe"
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

    public void modificarProducto(String idProducto, String nombre,
            BigDecimal precio, int idCategoria, int costo, String Descripcion) {//esta bien
        try {
            String ModificarProducto = this.readSql("../Joe"
                    + "/src/sql_files/ModificarProducto2.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ModificarProducto);
            stm.setString(1, nombre);
            stm.setBigDecimal(2, precio);
            stm.setInt(3, idCategoria);
            stm.setInt(4, costo);
            stm.setString(5, Descripcion);
            stm.setString(6, idProducto);

            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Modificar Producto");
        }
    }

    public void BuscarCategoriaPorDescripcion(String descripcionDeCategoria) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/BuscarCategoriaPorDescripcion.sql");
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

            String ventasPorVend = this.readSql("../Joe"
                    + "/src/sql_files/VentasPorVendedor.sql");
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
     * INSERT INTO devolucion (Fecha, TipoPago, TotalFacturado, idClienteDev,
     * idVendedorDev, Nota) VALUES (?, ?, ?, ?, ?, ?);
     */
    public int insertarDevoluciones(String Fecha, String TipoPago, int TotalFacturado, int idCliente, int idVendedor, String Nota) {
        try {
            String devolucion = this.readSql("../Joe/src/sql_files/"
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
    public void insertarproductocantidaddev(String idProductoDev, int Cantidad, int idDevolucion, int idCliente, int PrecioDev) {
        try {
            String devolucion = this.readSql("../Joe/src/sql_files/"
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
            int CantidadMovida, int Balance, String idProductoMovimiento, int idLugarMovimiento) {
        try {
            String devolucion = this.readSql("../Joe/src/sql_files/"
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

    public void eliminarProducto(String idProducto) {
        try {
            String eliminar = this.readSql("../Joe/src/sql_files/"
                    + "EliminarProducto.sql");
            PreparedStatement stm = this.conection.prepareStatement(eliminar);
            stm.setString(1, idProducto);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar producto");
        }
    }

    public void crearCierreDeCaja(String FechaInicio, String FechaFinal, int Cajero, String NombreCaja, String Observaciones, int ReporteInicial) {
        int totalVendido = cierreDeVentasXFecha(FechaInicio, FechaFinal);
        try {
            String devolucion;
            try {
                devolucion = this.readSql("../Joe/src/sql_files/"
                        + "crearCierreDeVentas.sql");
                PreparedStatement stm = this.conection.prepareStatement(devolucion);
                int consultarVentasXTipoPagoYFecha = consultarVentasXTipoPagoYFecha(FechaInicio, FechaFinal, "Contado");
                int consultarVentasXTipoPagoYFecha1 = consultarVentasXTipoPagoYFecha(FechaInicio, FechaFinal, "Tarjeta");
                stm.setString(1, FechaInicio);
                stm.setString(2, FechaFinal);
                stm.setInt(3, totalVendido);
                stm.setInt(4, Cajero);
                stm.setString(5, NombreCaja);
                stm.setString(6, Observaciones);
                stm.setInt(7, ReporteInicial);
                stm.setInt(8, ReporteInicial + totalVendido);
                stm.setInt(9, consultarVentasXTipoPagoYFecha);
                stm.setInt(10, consultarVentasXTipoPagoYFecha1);
                stm.executeUpdate();

            } catch (IOException ex) {
                Logger.getLogger(Direct_Control_BD.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            System.out.println("Error al recorrer los cierre de ventas");
        }

    }

    public String consultarNombreCategoriaXid(int idCategoria) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/consultarNombreCategoriaXId.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(BuscarCategoriaPorDescripcion);
            stm.setInt(1, idCategoria);
            ResultSet rs = stm.executeQuery();
            String Nombre = "";
            rs.next();
            Nombre = rs.getString("Descripcion");

            return Nombre;
        } catch (Exception e) {
            System.out.println("Error al consultar categoria por idCategoria");
            return "";
        }

    }

    public int consultarIdCategoriaXNombre(String Nombre) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/consultarIdCategoriaXNombre.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(BuscarCategoriaPorDescripcion);
            stm.setString(1, Nombre);
            ResultSet rs = stm.executeQuery();
            int idCategoria = 0;
            rs.next();
            idCategoria = rs.getInt("idCategoria");

            return idCategoria;
        } catch (Exception e) {
            System.out.println("Error al consultar categoria por nombre");
            return -1;
        }

    }

    public int consultarCantidadDeunProducto(String idProducto) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/consultarCantidadDeunProducto.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(BuscarCategoriaPorDescripcion);
            stm.setString(1, idProducto);
            ResultSet rs = stm.executeQuery();
            int ventas = 0;
            rs.next();
            ventas = rs.getInt("Cantidad");

            return ventas;
        } catch (Exception e) {
            System.out.println("Error al obtener cantidad de un producto");
            return 0;
        }

    }

    public int consultarIdLugarXNombre(String nombreLugar) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/consultarIdLugarXNombre.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(BuscarCategoriaPorDescripcion);
            stm.setString(1, nombreLugar);
            ResultSet rs = stm.executeQuery();
            int ventas = 0;
            rs.next();
            ventas = rs.getInt("idUbicacionProducto");
            return ventas;
        } catch (Exception e) {
            System.out.println("error consultar idLugar x nombre");
            return 0;
        }

    }

    public int consultarVentasXTipoPagoYFecha(String FechaInicio, String FechaFinal, String TipoPago) {
        try {

            String BuscarCategoriaPorDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/consultarVentasXTipoDePagoXFecha.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(BuscarCategoriaPorDescripcion);
            stm.setString(1, TipoPago);
            stm.setString(2, FechaInicio);
            stm.setString(3, FechaFinal);
            ResultSet rs = stm.executeQuery();
            int ventas = 0;
            rs.next();
            ventas = rs.getInt("Precio");

            return ventas;
        } catch (Exception e) {
            System.out.println("Error al obtener precio categoria x tipo de fecha y pago");
            return 0;
        }

    }

    /**
     * Permite insertar una factura pendiente.
     *
     * @param idFactura
     * @param saldo
     * @param fechaVencimiento
     */
    public void insertarFacturasPendientes(int idFactura, int saldo, String fechaVencimiento) {
        try {
            String insertarFacturasPendientes = this.readSql("../Joe/src/sql_files/"
                    + "insertarFacturasPendientes.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarFacturasPendientes);
            stm.setInt(1, idFactura);
            stm.setInt(2, saldo);
            stm.setString(3, fechaVencimiento);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar una Factura Pendiente");

        }
    }

    /**
     * Permite insertar un pago en una factura pendiente.
     *
     * @param fecha
     * @param idFacturaPendiente
     * @param montoDePago
     */
    public void insertarPago(String fecha, int montoDePago, int idFacturaPendiente) {
        try {
            String insertarPago = this.readSql("../Joe/src/sql_files/"
                    + "insertarPago.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarPago);
            stm.setString(1, fecha);
            stm.setInt(2, montoDePago);
            stm.setInt(3, idFacturaPendiente);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar un Pago a una Factura Pendiente");

        }
    }

    /**
     * Obtiene la informacion de las ultimas 100 facturas.
     */
    public void verFacturas() {
        try {
            String verFacts = this.readSql("../Joe/src/sql_files/"
                    + "VerFacturas.sql");
            ResultSet rs = statement.executeQuery(verFacts);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener las facturas");
        }

    }

    public void verInventario() {
        try {
            String verInventario = this.readSql("../Joe/src/sql_files/"
                    + "consultarInventarioxSucursal.sql");
            ResultSet rs = statement.executeQuery(verInventario);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener el inventario");
        }
    }

    /**
     * @return the NombresColumnas
     */
    public String[] getColumnNames() {
        return NombresColumnas;
    }

    /**
     * @param columnNames the NombresColumnas to set
     */
    public void setColumnNames(String[] columnNames) {
        this.NombresColumnas = columnNames;
    }

    /**
     * @return the Informacion
     */
    public Object[][] getData() {
        return Informacion;
    }

    /**
     * @param data the Informacion to set
     */
    public void setData(Object[][] data) {
        this.Informacion = data;
    }

    /**
     * Obtiene las columnas de la consulta
     *
     * @param rs
     * @return
     */
    private String[] Get_Columnas(ResultSet rs) {
        String[] etiquetas = null;
        try {
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();
            etiquetas = new String[numeroColumnas];
            for (int i = 0; i < numeroColumnas; i++) {
                etiquetas[i] = metaDatos.getColumnLabel(i + 1);
            }
        } catch (Exception e) {
            System.out.println("No se pudo obtener las columnas");

        }
        return etiquetas;
    }

    /**
     * Convierte en un arreglo la tabla consultada
     *
     * @param rs
     * @return
     */
    private Object[][] ResultSet_Array(ResultSet rs) {
        Object[][] lista_datos = null;
        try {
            rs.last();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            int numFils = rs.getRow();
            lista_datos = new Object[numFils][numCols];
            int j = 0;
            rs.beforeFirst();
            while (rs.next()) {
                for (int i = 0; i < numCols; i++) {
                    lista_datos[j][i] = rs.getObject(i + 1);
                }
                j++;

            }
        } catch (Exception e) {
            System.out.println("No se pudo convertir en arreglo");

        }
        return lista_datos;
    }

    /**
     * Obtiene la descripcion de un producto segun el codigo
     */
    public String verDescripcion(String codigo) {
        try {
            String verDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/verDescripcionPorCodigo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verDescripcion);
            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            String descripcion = "";
            while (rs.next()) {
                descripcion = rs.getString("Nombre");
            }
            return descripcion;
        } catch (Exception e) {
            System.out.println(codigo);
            System.out.println("Error al obtener la descricpcion");
            return "";
        }
    }

    /**
     * Obtiene el precio de un producto segun el codigo
     */
    public BigDecimal verPrecio(String codigo) {
        BigDecimal precio = new BigDecimal("0");

        try {
            String verDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/verPrecioPorCodigo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verDescripcion);
            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                precio = rs.getBigDecimal("Precio");
            }
            return precio;
        } catch (Exception e) {
            System.out.println(codigo);
            System.out.println("Error al obtener el precio");
            return null;
        }
    }

    /**
     * Obtiene los codigos de los productos
     */
    public void verCodigos() {
        try {
            String verCodigos = this.readSql("../Joe"
                    + "/src/sql_files/verCodigos.sql");
            ResultSet rs = statement.executeQuery(verCodigos);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener todos los codigos");
        }

    }

    public void verLugares() {
        try {
            String verCodigos = this.readSql("../Joe"
                    + "/src/sql_files/consultarLugares.sql");
            ResultSet rs = statement.executeQuery(verCodigos);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener todos los lugares");
        }

    }

    /**
     * Obtiene la ultima factura realizada
     *
     * @return
     */
    public int ObtenerUltimoidFact() {
        int result = 0;
        try {
            String valorInventario = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerUltimoidFact.sql");
            PreparedStatement stm = this.conection.prepareStatement(valorInventario);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                result = resultset.getInt(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener el ultimo idFactura");
        }
        return result;

    }

    /**
     * Obtiene el nombre de un producto segun el codigo
     */
    public String verNombre(String codigo) {
        try {
            String verNombre = this.readSql("../Joe"
                    + "/src/sql_files/verNombrePorCodigo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verNombre);
            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            String descripcion = "";
            while (rs.next()) {
                descripcion = rs.getString("Nombre");
            }
            return descripcion;
        } catch (Exception e) {
            System.out.println(codigo);
            System.out.println("Error al obtener el nombre");
            return "";
        }
    }

    public void insertarCategoria(String Nombre) {
        try {
            String categoria = this.readSql("../Joe/src/sql_files/"
                    + "crearCategoria.sql");
            PreparedStatement stm = this.conection.prepareStatement(categoria);
            stm.setString(1, Nombre);

            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al crear categoria");
        }
    }

    public String verDetalle(String codigo) {
        try {
            String verNombre = this.readSql("../Joe"
                    + "/src/sql_files/verNombrePorCodigo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verNombre);
            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            String descripcion = "";
            while (rs.next()) {
                descripcion = rs.getString("Descripcion");
            }
            return descripcion;
        } catch (Exception e) {
            System.out.println(codigo);
            System.out.println("Error al obtener el detalle(Descripcion)");
            return "";
        }
    }

    /**
     * Esta consulta da la cantidad del invetario(General) de un producto
     * seleccionado
     *
     * @param idProducto
     * @return
     */
    public int verCantidad(String idProducto) {
        int cantidad = 0;
        try {
            String verCantidad = this.readSql("../Joe"
                    + "/src/sql_files/verCantidadPorCodigo.sql");
            PreparedStatement stm = this.conection.prepareStatement(verCantidad);
            stm.setString(1, idProducto);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt("Cantidad");
            }
            return cantidad;
        } catch (Exception e) {
            System.out.println(cantidad);
            System.out.println("Error al obtener la cantidad del producto");
            return 0;
        }
    }

    public boolean verSiExisteCod(String idProducto) {
        try {
            String verCantidad = this.readSql("../Joe"
                    + "/src/sql_files/verSiExisteCod.sql");
            PreparedStatement stm = this.conection.prepareStatement(verCantidad);
            stm.setString(1, idProducto);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("No existe ese codigo");
            return false;
        }
    }

    /**
     * Obtiene el nombre de un producto segun el codigo y solo permite obtener
     * el nombre de productos con estado A
     */
    public String verNombreProductoPorCodigo(String codigo) {
        try {
            String verDescripcion = this.readSql("../Joe"
                    + "/src/sql_files/verDescripcionPorCodigo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verDescripcion);
            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            String descripcion = "";
            while (rs.next()) {
                descripcion = rs.getString("Nombre");
            }
            return descripcion;
        } catch (Exception e) {
            System.out.println(codigo);
            System.out.println("Error al obtener la descricpcion");
            return "";
        }
    }

    /**
     * Obtiene el numero de version de un producto segun el codigo y solo
     * permite obtener la version con estado A
     */
    public int veridVersionActivaProductoPorCodigo(String codigo) {
        try {
            String verVersion = this.readSql("../Joe"
                    + "/src/sql_files/verVersionPorCodigo.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verVersion);
            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();
            int version = 0;
            while (rs.next()) {
                version = rs.getInt("idVersion");
            }
            return version;
        } catch (Exception e) {
            System.out.println(codigo);
            System.out.println("Error al obtener la version");
            return 0;
        }
    }

    public Object[][] getInfoFact() {
        return infoFact;
    }

    public String[] getNombresColumnas() {
        return NombresColumnas;
    }

    public void setData2(Object[][] data) {
        infoFact = data;
    }

    public void VerFacturasPorRangoDeFecha(String FechaIni, String FechaFin) {
        try {
            String Fact = this.readSql("../Joe"
                    + "/src/sql_files/VerFacturasPorRangoDeFecha.sql");
            PreparedStatement stm = this.conection.prepareStatement(Fact);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al Ver Facturas Por Rango De Fecha");

        }
    }

    /**
     * Permite la insercion de un producto en la factura.
     *
     * @param idProducto
     * @param idVersion
     * @param Cantidad
     * @param idFactura
     * @param PrecioVenta
     */
    public void insertarProductoCantidadFact(String idProducto, int idVersion, int Cantidad, int idFactura, BigDecimal PrecioVenta) {
        try {
            String insertarProductoCantFact = this.readSql("../Joe/src/sql_files/"
                    + "insertarProductoCantidadFact.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarProductoCantFact);
            stm.setString(1, idProducto);
            stm.setInt(2, idVersion);
            stm.setInt(3, Cantidad);
            stm.setInt(4, idFactura);
            stm.setDouble(5, PrecioVenta.doubleValue());
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar producto cantidad fact");
        }
    }

    public void VerFacturasPoridProducto(String FechaIni, String FechaFin, String idProducto) {
        try {
            String Fact = this.readSql("../Joe"
                    + "/src/sql_files/VentasPorRangoFechYidProd.sql");// hacer consulta por prod
            PreparedStatement stm = this.conection.prepareStatement(Fact);
            stm.setString(1, idProducto);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al Ver Facturas Por idProducto");

        }
    }

    public void FacturasPorCategoriaDeProd(String FechaIni, String FechaFin, String categoria) {
        try {
            
            String Fact = readSql("../Joe"
                    + "/src/sql_files/FacturasPorCategoriaDeProd.sql");// hacer consulta por prod
            PreparedStatement stm = this.conection.prepareStatement(Fact);
            stm.setString(1, categoria);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al Ver Facturas FacturasPorCategoriaDeProd");

        }
    }

}
