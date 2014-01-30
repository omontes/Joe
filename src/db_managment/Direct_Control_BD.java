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
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Monicaticooo
 */
public class Direct_Control_BD {

    private Connection conection;
    private Statement statement;
    public Object[][] infoFact;
    private String[] NombresColumnas;
//    private Object[][] infoFactMod;
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
     */
    public void VerVentasPorCliente(String FechaIni, String FechaFin, String NombreCliente) {
        try {
            String VentasPorCliente = readSql("../Joe/src/"
                    + "sql_files/"
                    + "VerVentasPorCliente.sql");
            PreparedStatement stm = conection.prepareStatement(VentasPorCliente);
            stm.setString(1, NombreCliente);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            ResultSet resultset = stm.executeQuery();
            setColumnNames(Get_Columnas(resultset));
            setData2(ResultSet_Array(resultset));

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
     * ||Tipopagoac
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
     * Muestra todos los apartados (cancelados y pendientes)
     *
     */
    public void verApartados() {
        try {
            String VerApartados = readSql("../Joe/src/"
                    + "sql_files/VerApartados.sql");
            ResultSet resultset = statement.executeQuery(VerApartados);
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al ver apartados");
        }
    }

    /**
     * Muestra todos los creditos(cancelados y pendientes)
     *
     */
    public void verCreditos() {
        try {
            String VerCreditos = readSql("../Joe/src/"
                    + "sql_files/VerCreditos.sql");
            ResultSet resultset = statement.executeQuery(VerCreditos);
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al ver creditos");
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
     * @param concepto
     * @param nota
     */
    public void crearFactura(int idFactura, BigDecimal descuento, String tipoPago, int idCliente,
            int idVendedor, String concepto, String nota, BigDecimal TotalFacturado, String estado) {//Revisado+
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
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
            stm.setString(6, concepto);
            stm.setString(7, nota);
            stm.setString(8, fecha);
            stm.setDouble(9, TotalFacturado.doubleValue());
            stm.setString(10, estado);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("error al crear la factura");

        }

    }

    /**
     * Muetras las Categorias disponibles
     */
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
     * Dado un v muestra los detalles de las Facturas canceladas realizadas por
     * este, en un rango de fechas
     *
     * @param FechaIni
     * @param FechaFin
     * @param NombreVendedor
     */
    public void ventasPorVendedorCancelada(String FechaIni, String FechaFin,
            String NombreVendedor) {
        try {

            String ventasPorVend = this.readSql("../Joe"
                    + "/src/sql_files/VentasPorVendedorCancelada.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ventasPorVend);
            stm.setString(1, NombreVendedor);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener ventas por vendedor canceladas");

        }

    }

    /**
     * Dado un vendedor muestra los detalles de las Facturas por Apartados
     * realizadas por este, en un rango de fechas
     *
     * @param FechaIni
     * @param FechaFin
     * @param NombreVendedor
     */
    public void ventasPorVendedorAparatadoOCredito(String FechaIni, String FechaFin,
            String NombreVendedor, String tipoDeReporte) {
        try {

            String ventasPorVend = this.readSql("../Joe"
                    + "/src/sql_files/VentasPorVendedorAparatadoOCredito.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ventasPorVend);
            stm.setString(1, NombreVendedor);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            stm.setString(4, tipoDeReporte);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener ventas por vendedor canceladas");

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

    /**
     * Inserta un movimiento en la base
     *
     * @param Fecha
     * @param Detalle
     * @param idTipoMovimiento
     * @param idLugarMovimiento
     * @param valormovimiento
     */
    public void insertarmovimiento(String Detalle, int idTipoMovimiento,
            int idLugarMovimiento, BigDecimal valormovimiento) {

        try {
            String devolucion = this.readSql("../Joe/src/sql_files/"
                    + "insertarMovimiento.sql");
            PreparedStatement stm = this.conection.prepareStatement(devolucion);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String fecha = dateFormat.format(date);
            stm.setString(1, fecha);
            stm.setString(2, Detalle);
            stm.setInt(3, idTipoMovimiento);
            stm.setInt(4, idLugarMovimiento);
            stm.setBigDecimal(5, valormovimiento);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar movimiento");
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
    public void insertarFacturasPendientes(int idFactura, BigDecimal saldo, String fechaVencimiento, int idVersionFactPendientes) {
        try {
            String insertarFacturasPendientes = this.readSql("../Joe/src/sql_files/"
                    + "insertarFacturasPendientes.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarFacturasPendientes);
            stm.setInt(1, idFactura);
            stm.setDouble(2, saldo.doubleValue());
            stm.setString(3, fechaVencimiento);
            stm.setInt(4, idVersionFactPendientes);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar una Factura Pendiente");

        }
    }

    /**
     * Permite insertar un pago en una factura pendiente.
     *
     * @param fecha
     * @param montoDePago
     * @param idFacturaPendiente
     * @param idFacturaVersionPagosPend
     */
    public void insertarPago(BigDecimal montoDePago, int idFacturaPendiente, int idFacturaVersionPagosPend, String tipopago) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String fecha = dateFormat.format(date);
            String insertarPago = this.readSql("../Joe/src/sql_files/"
                    + "insertarPago.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarPago);
            stm.setString(1, fecha);
            stm.setDouble(2, montoDePago.doubleValue());
            stm.setInt(3, idFacturaPendiente);
            stm.setInt(4, idFacturaVersionPagosPend);
            stm.setString(5, tipopago);
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

    /**
     * Obtiene la informacion de las ultimos 100 apartados.
     */
    public void verApartadosParaTabla() {
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
                    + "consultarInventario.sql");
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
    public int verCantidadInvGeneral(String idProducto) {
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
     * Obtiene el numero de idversion de un producto segun el codigo y solo
     * permite obtener la idversion con estado A
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

    public void VerFacturasPorConeptoPorRangoDeFecha(String FechaIni,
            String FechaFin, String concepto) {
        try {
            String Fact = this.readSql("../Joe"
                    + "/src/sql_files/VerFacturasPorConceptoPorRangoDeFecha.sql");
            PreparedStatement stm = this.conection.prepareStatement(Fact);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            stm.setString(3, concepto);
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
    public void insertarProductoCantidadFact(String idProducto, int idVersion, int Cantidad, int idFactura, BigDecimal PrecioVenta, int idVersionFacturasProducto) {
        try {
            String insertarProductoCantFact = this.readSql("../Joe/src/sql_files/"
                    + "insertarProductoCantidadFact.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarProductoCantFact);
            stm.setString(1, idProducto);
            stm.setInt(2, idVersion);
            stm.setInt(3, Cantidad);
            stm.setInt(4, idFactura);
            stm.setDouble(5, PrecioVenta.doubleValue());
            stm.setInt(6, idVersionFacturasProducto);
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

    /**
     * Obtiene los nombres de los vendedores de la base de datos
     */
    public void verVendedores() {
        try {
            String consultarVendedores = this.readSql("../Joe"
                    + "/src/sql_files/consultarVendedores.sql");
            ResultSet rs = statement.executeQuery(consultarVendedores);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener todos los vendedores");
        }
    }

    /**
     * Obtener informacion de Clientes
     */
    public void consultarClientes() {
        try {
            String clientes = this.readSql("../Joe/src/"
                    + "sql_files/consultarClientes.sql");
            PreparedStatement stm = this.conection.prepareStatement(clientes);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al consultar clientes");
        }
    }

    /**
     * Retorna informacion de una persona, dado un nombre
     *
     * @param nombre
     */
    public void consultarPersona(String nombre) {
        try {
            String infoPersona = this.readSql("../Joe/src/"
                    + "sql_files/consultarPersona.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(infoPersona);
            stm.setString(1, nombre);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al consultar informacion de persona");
        }
    }

    /**
     * Obtener informacion de los vendedores
     */
    public void consultarVendedores() {
        try {
            String categorias = this.readSql("../Joe/src/"
                    + "sql_files/consultarInfoVendedores.sql");
            PreparedStatement stm = this.conection.prepareStatement(categorias);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al consultar Vendedores");
        }
    }

    /**
     * Devuelve el idVendedor del nombre del vendedor dado.
     *
     * @param vendedor
     * @return
     */
    public int veridVendedor(String vendedor) {
        try {
            String verIdVendedor = this.readSql("../Joe"
                    + "/src/sql_files/verIdVendedor.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verIdVendedor);
            stm.setString(1, vendedor);
            ResultSet rs = stm.executeQuery();
            int idvendedor = 0;
            while (rs.next()) {
                idvendedor = rs.getInt("idPersona");
            }
            return idvendedor;
        } catch (Exception e) {
            System.out.println(vendedor);
            System.out.println("Error al obtener el vendedor");
            return 0;
        }

    }

    public boolean verSiExisteCliente(String nombre) {
        try {
            String verCliente = this.readSql("../Joe"
                    + "/src/sql_files/verSiExisteCliente.sql");
            PreparedStatement stm = this.conection.prepareStatement(verCliente);
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("No existe ese cliente");
            return false;
        }
    }

    /**
     * Permite crear un cliente en la base de datos.
     *
     * @param nombre
     * @param direccion
     * @param idTipoPersona
     * @param telefono
     * @param FechaCumpleanos
     */
    public void insertarCliente(String nombre, String direccion, String telefono, String FechaCumpleanos) {
        try {
            String crearCliente = this.readSql("../Joe/src/sql_files/"
                    + "crearCliente.sql");
            PreparedStatement stm = this.conection.prepareStatement(crearCliente);
            stm.setString(1, nombre);
            stm.setString(2, direccion);
            stm.setString(3, telefono);
            stm.setString(4, FechaCumpleanos);
            stm.executeUpdate();
            int idCliente = this.veridCliente(nombre);
            this.insertarIdCliente(idCliente);

        } catch (Exception e) {
            System.out.println("Error al crear cliente");
        }
    }

    /**
     * Devuelve el idCliente del nombre del cliente dado.
     *
     * @param vendedor
     * @return
     */
    public int veridCliente(String cliente) {
        try {
            String verIdCliente = this.readSql("../Joe"
                    + "/src/sql_files/verIdCliente.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verIdCliente);
            stm.setString(1, cliente);
            ResultSet rs = stm.executeQuery();
            int idvcliente = 0;
            while (rs.next()) {
                idvcliente = rs.getInt("idPersona");
            }
            return idvcliente;
        } catch (Exception e) {
            System.out.println(cliente);
            System.out.println("Error al obtener el cliente");
            return 0;
        }

    }

    /**
     * Devuelve toda la informacion(Cliente,Vendedor,Total etc) del num de
     * factura ingresado.
     */
    public void verInfoFactura(int NumFact) {
        try {
            String verInfoFactura = this.readSql("../Joe/src/"
                    + "sql_files/cargarFactura.sql");
            PreparedStatement stm = this.conection.prepareStatement(verInfoFactura);
            stm.setInt(1, NumFact);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumFact);
            System.out.println("Error al obtener la informacion de la factura");
        }
    }

    /**
     * Consultar Facturas Pendientes, en un rango de fechas
     *
     * @param FechaIni
     * @param FechaFin
     */
    public void CosultarFacturasPendientes(String FechaIni, String FechaFin) {
        try {
            String cosultarFacturasPendientes = this.readSql("../Joe"
                    + "/src/sql_files/CosultarFacturasPendientes.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(cosultarFacturasPendientes);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            ResultSet rs = stm.executeQuery();

        } catch (Exception e) {

            System.out.println("Error al Cosultar Facturas Pendientes");

        }
    }

    /**
     * Retorna las ventas por hechas en un lapso, por tipo de pago, ya sea
     * Efectivo o Tarjeta
     *
     * @param FechaIni
     * @param FechaFin
     * @param termino
     */
    public void FacturasPorTerminoPorFecha(String FechaIni, String FechaFin,
            String termino) {
        try {
            String cosultarFacturasPorTermino = readSql("../Joe"
                    + "/src/sql_files/FacturasPorTerminoPorFecha.sql");
            PreparedStatement stm
                    = conection.prepareStatement(cosultarFacturasPorTermino);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            stm.setString(3, termino);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));

        } catch (Exception e) {

            System.out.println("Error al Cosultar Facturas Por "
                    + "Termino Por Fecha");

        }
    }

    /**
     * Devuelve todos los productos de una factura determinada.
     */
    public void verProductosPorFactura(int NumFact) {
        try {
            String verProductosPorFactura = this.readSql("../Joe/src/"
                    + "sql_files/verProductosPorFactura.sql");
            PreparedStatement stm = this.conection.prepareStatement(verProductosPorFactura);
            stm.setInt(1, NumFact);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumFact);
            System.out.println("Error al obtener los productos de la factura");
        }
    }

    /**
     * 'Elimina'(Cambia de estado a eliminada) el numero de factura seleccionado
     *
     * @param NumFact
     */
    public void eliminarFactura(int NumFact, int idVersionFact) {
        try {
            String eliminar = this.readSql("../Joe/src/sql_files/"
                    + "eliminarFactura.sql");
            PreparedStatement stm = this.conection.prepareStatement(eliminar);
            stm.setInt(1, NumFact);
            stm.setInt(2, idVersionFact);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la factura");
        }
    }

    /**
     * Detalla el las ventas que ha hecho un vendedor para cada producdo
     *
     * @param FechaIni
     * @param FechaFin
     * @param Vendedor
     */
    public void VentasDeProductosPorVendedor(String FechaIni, String FechaFin,
            String Vendedor) {
        try {
            String ventasDeProductosPorVendedor = readSql("../Joe"
                    + "/src/sql_files/VentasDeProductosPorVendedor.sql");
            PreparedStatement stm
                    = conection.prepareStatement(ventasDeProductosPorVendedor);
            stm.setString(1, Vendedor);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));

        } catch (Exception e) {

            System.out.println("Error al Cosultar Ventas De Productos"
                    + " Por Vendedor");

        }
    }

    /**
     * Detalla el las ventas de producto por cliente
     *
     * @param FechaIni
     * @param FechaFin
     * @param Cliente
     */
    public void VentasDeProductosPorCliente(String FechaIni, String FechaFin,
            String Cliente) {
        System.out.println(FechaIni);
        System.out.println(FechaFin);
        System.out.println(Cliente);
        try {
            String ventasDeProductosPorCliente = readSql("../Joe"
                    + "/src/sql_files/VentasDeProductosPorCliente.sql");
            PreparedStatement stm
                    = conection.prepareStatement(ventasDeProductosPorCliente);
            stm.setString(1, Cliente);
            stm.setString(2, FechaIni);
            stm.setString(3, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));

        } catch (Exception e) {

            System.out.println("Error al Cosultar Ventas De Productos"
                    + " Por Cliente");

        }
    }

    /**
     * Esta consulta permite saber cual es el idversion de la factura que se
     * esta creando en facturacion es decir la activa('A').
     *
     * @param idFactura
     * @return
     */
    public int verVersionDEFacturaActiva(int idFactura) {
        try {
            String verVersionDEFacturaNueva = this.readSql("../Joe"
                    + "/src/sql_files/verVersionFacturaNueva.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verVersionDEFacturaNueva);
            stm.setInt(1, idFactura);
            ResultSet rs = stm.executeQuery();
            int idversion = 0;
            while (rs.next()) {
                idversion = rs.getInt("idVersionFactura");
            }
            return idversion;
        } catch (Exception e) {
            System.out.println("Error al obtener la version de la factura");
            return 0;
        }
    }

    /**
     * Elimina la factura que se modifico(la vuelve inactiva para poder luego
     * ver cuales fueron las modificaciones que se le hicieron a la factura)
     *
     * @param NumFact
     */
    public void eliminarFacturaPorModificacion(int NumFact) {
        try {
            String eliminarFacturaPorModf = this.readSql("../Joe/src/sql_files/"
                    + "eliminarFacturaPorModf.sql");
            PreparedStatement stm = this.conection.prepareStatement(eliminarFacturaPorModf);
            stm.setInt(1, NumFact);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la factura por modificacion");
        }
    }

    public void actualizarCantidadInventario(String codArticulo, int cantidad) {
        try {
            String actualizarCantidadInv = this.readSql("../Joe"
                    + "/src/sql_files/actualizarCantidadInventario.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(actualizarCantidadInv);
            stm.setInt(1, cantidad);
            stm.setString(2, codArticulo);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Actualizar la cantidad de un producto"
                    + " en el inventario por modificacion");
        }

    }

    /**
     * permite obtener las facturas que fueron eliminadas
     *
     * @param FechaIni
     * @param FechaFin
     */
    public void VerFacturasEliminadas(String FechaIni, String FechaFin) {
        try {
            String Fact = this.readSql("../Joe"
                    + "/src/sql_files/VerFacturasEliminadas.sql");
            PreparedStatement stm = this.conection.prepareStatement(Fact);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al Ver Facturas Eliminadas");

        }
    }

//    /**
//     * permite obtener el idFatura de todas las facturas que hayan sufrido una
//     * modificacion
//     */
//    public void ObtenerIdFactModificadas() {
//        try {
//            String idFacturas = this.readSql("../Joe"
//                    + "/src/sql_files/ObtenerIdFactModificadas.sql");
//            PreparedStatement stm = this.conection.prepareStatement(idFacturas);
//            ResultSet rs = stm.executeQuery();
//            setColumnNames(Get_Columnas(rs));
//            setData(ResultSet_Array(rs));
//        } catch (Exception e) {
//
//            System.out.println("Error al  Obtener Id Fact Modificadas");
//
//        }
//    }
    /**
     * Obtiene Facturas Modificadas Y Sus Versiones
     *
     * @param idFactura
     */
    public void ObtenerFacturaModificadaYSusVersiones(String idFactura) {
        try {
            String Facturas = this.readSql("../Joe"
                    + "/src/sql_files/ObtenerFacturasModificadas.sql");
            PreparedStatement stm = this.conection.prepareStatement(Facturas);
            stm.setString(1, idFactura);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al  Obtener  informacion de "
                    + "Fact Modificada y sus versiones");

        }
    }

    /**
     * Obtiene Devoluciones Modificadas Y Sus Versiones
     *
     * @param idDev
     */
    public void ObtenerDevolucionesModificadaYSusVersiones(String idDev) {
        try {
            String Facturas = this.readSql("../Joe"
                    + "/src/sql_files/"
                    + "ObtenerDevolucionesModificadaYSusVersiones.sql");
            PreparedStatement stm = this.conection.prepareStatement(Facturas);
            stm.setString(1, idDev);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al  Obtener Dev Modificadas"
                    + " y sus versiones");

        }
    }

    /**
     * Obtiene los productos de una factura dado su idVersion e idFactura
     *
     * @param idFact
     * @param version
     */
    public void verProductosPorFacturaYVersionDeFactura(String idFact,
            int version) {
        try {
            String verProductosPorFacturaYVersion = this.readSql("../Joe/src/"
                    + "sql_files/ProductosPorIdFacturaYIdVersionFactura.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(verProductosPorFacturaYVersion);
            stm.setString(1, idFact);
            stm.setInt(2, version);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener los productos de la factura");
        }
    }

    /**
     * Obtiene los productos de una factura dado su idVersion e idFactura
     *
     * @param idFact
     * @param version
     */
    public void verProductosPorDevolucionYVersionDeDev(String idFact,
            int version) {
        try {
            String verProductosPorFacturaYVersion = this.readSql("../Joe/src/"
                    + "sql_files/ProductosPorIdDevolucionYIdVersionDev.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(verProductosPorFacturaYVersion);
            stm.setString(1, idFact);
            stm.setInt(2, version);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener los productos de la Dev");
        }
    }

    /**
     * Permite Ver Productos Por Rango Codigo
     *
     * @param Inic
     * @param hasta
     */
    public void VerProductosPorRangoCodigo(String Inic,
            String hasta) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosPorRangoCodigo.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener los productos "
                    + "por rango de codigo");
        }
    }

    /**
     * Obtener informacion de productos dado un nombre
     *
     * @param Inic
     * @param hasta
     */
    public void VerProductosPorNombre(String Inic,
            String hasta) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosPorRangoNombre.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener los productos por "
                    + "rango descripcion");
        }
    }

    /**
     * Obtener informacion de productos dado una categoria
     *
     * @param categoria
     */
    public void VerProductosPorCategoria(String categoria) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosPorCateg.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, categoria);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener los productos por categoria");
        }

    }

    /**
     * Permite Ver Costo y Precio de Productos,Por Rango de Codigo
     *
     * @param Inic
     * @param hasta
     */
    public void VerCostoPrecioProductosPorRangoCodigo(String Inic,
            String hasta) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerCostoPrecioProductosPorRangoCodigo.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener costos productos por "
                    + "rango de codigo");
        }
    }

    /**
     * Permite obtener una factura modificada y sus versiones
     *
     * @param idFact
     */
    public void ObtenerFactModificada(String idFact) {
        try {

            String verProductosPorFacturaYVersion = this.readSql("../Joe/src/"
                    + "sql_files/ObtenerFactModificada.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(verProductosPorFacturaYVersion);
            stm.setString(1, idFact);
            ResultSet resultset = stm.executeQuery();
            this.setData(this.ResultSet_Array(resultset));
            this.setColumnNames(this.Get_Columnas(resultset));

        } catch (Exception e) {
            System.out.println("Error al Obtener Fact Modificada");
        }
    }

    /**
     * Devuelve el total facturado y el saldo de un apartado
     *
     * @param NumFact
     */
    public void verInfoFacturaApartado(int NumFact) {
        try {
            String verInfoFacturaApartado = this.readSql("../Joe/src/"
                    + "sql_files/verPago.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(verInfoFacturaApartado);
            stm.setInt(1, NumFact);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumFact);
            System.out.println("Error al obtener la informacion del apartado");
        }
    }

    /**
     * Permite Ver Costo y Precio de Productos,Por Rango de Nombre
     *
     * @param Inic
     * @param hasta
     */
    public void VerCostoPrecioProductosPorNombre(String Inic, String hasta) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerCostoPrecioProductosPorRangoNombre.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener costos productos por "
                    + "rango de nombre");
        }
    }

    /**
     * Permite Ver Costo y Precio de Productos,Por Categoria
     *
     * @param categoria
     */
    public void VerCostoPrecioProductosPorCategoria(String categoria) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerCostoPrecioProductosPorCateg.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, categoria);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener los Precios Costos de "
                    + "productos por categoria");
        }
    }

    /**
     * Permite obtener las facturas que tengan alguna modificacion
     */
    public void ObtenerFactModificadaOriginales() {
        try {
            String verInfoFacturaApartadoPagos = this.readSql("../Joe/src/"
                    + "sql_files/VerFacturasOriginalesModf.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(verInfoFacturaApartadoPagos);

            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {

            System.out.println("Error al obtener facturas que tengan "
                    + "alguna modificacion");
        }

    }

    /**
     * Permite obtener las devoluciones que tengan alguna modificacion
     */
    public void ObtenerDevModificadasOriginales() {
        try {
            String verInfoFacturaApartadoPagos = this.readSql("../Joe/src/"
                    + "sql_files/VerModificadasOriginalesModf.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(verInfoFacturaApartadoPagos);

            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {

            System.out.println("Error al obtener Devoluciones"
                    + " Modificadas Originales");
        }

    }

    /**
     * Permite Ver Productos Agotados Por Rango de Codigo
     *
     * @param Inic
     * @param hasta
     * @param ubicacion
     */
    public void VerProductosAgotadosPorRangoCodigo(String Inic, String hasta,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosAgotadosPorRangoCodigo.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            stm.setString(3, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener costos productos "
                    + "por rango de codigo");
        }
    }

    /**
     * Permite Ver Productos Agotados Por Rango de Nombre
     *
     * @param Inic
     * @param hasta
     * @param ubicacion
     */
    public void VerProductosAgotadosPorNombre(String Inic, String hasta,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosAgotadosPorRangoNombre.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            stm.setString(3, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener costos productos por "
                    + "rango de Nombre");
        }
    }

    /**
     * Permite Ver Productos Agotados Por Categoria
     *
     * @param Inic
     * @param ubicacion
     */
    public void VerProductosAgotadosPorCategoria(String Inic,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosAgotadosPorCategoria.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener  productos"
                    + " agotados por categoria");
        }
    }

    /**
     * Permite Ver Productos en inventario Por Rango de Codigo
     *
     * @param Inic
     * @param hasta
     * @param ubicacion
     */
    public void VerProductosEnInvPorRangoCodigo(String Inic, String hasta,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosEnInvPorRangoCodigo.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            stm.setString(3, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener lista productos en inv"
                    + " por rango de codigo");
        }

    }

    /**
     * Permite Ver Productos en inventario Por Rango de Nombre
     *
     * @param Inic
     * @param hasta
     * @param ubicacion
     */
    public void VerProductosEnInvPorNombre(String Inic, String hasta,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosEnInvPorRangoNombre.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            stm.setString(3, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener lista productos en inv "
                    + "por rango de nombre");
        }
    }

    /**
     * Permite Ver Productos en inventario Por Categoria
     *
     * @param categoria
     * @param ubicacion
     */
    public void VerProductosEnInvPorCategoria(String categoria,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/VerProductosEnInvPorCategoria.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, categoria);
            stm.setString(2, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener lista productos en"
                    + " inv por categoria");
        }
    }

    /**
     * Permite Obtener el Valor Del Inventario Por Rango de Codigo
     *
     * @param Inic
     * @param hasta
     * @param ubicacion
     */
    public void ValorDeInvPorRangoCodigo(String Inic, String hasta,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/ValorDeInvPorRangoCodigo.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            stm.setString(3, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener Valor De Inv Por "
                    + "Rango Codigo");
        }
    }

    /**
     * Permite Obtener el Valor Del Inventario Por Rango de Nombre de Producto
     *
     * @param Inic
     * @param hasta
     * @param ubicacion
     */
    public void ValorDeInvPorNombreProd(String Inic, String hasta,
            String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/ValorDeInvPorNombreProd.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, Inic);
            stm.setString(2, hasta);
            stm.setString(3, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener Valor De Inv Por "
                    + "Rango Nombre Producto");
        }

    }

    /**
     * Permite Obtener el Valor Del Inventario Por Categoria del Producto
     *
     * @param categoria
     * @param ubicacion
     */
    public void ValorDeInvPorCategoriaProd(String categoria, String ubicacion) {
        try {
            String Productos = this.readSql("../Joe/src/"
                    + "sql_files/ValorDeInvPorCategoriaProd.sql");
            PreparedStatement stm = this.conection.prepareStatement(Productos);
            stm.setString(1, categoria);
            stm.setString(2, ubicacion);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(Get_Columnas(resultset));
            this.setData2(ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al obtener Valor De Inv Por Categoria del producto");
        }

    }

    /**
     * Devuelve la fecha y el monto de pago que se le han hecho a la factura con
     * el NumFact ingresado
     */
    public void verInfoFacturaApartadoPagos(int NumFact) {
        try {
            String verInfoFacturaApartadoPagos = this.readSql("../Joe/src/"
                    + "sql_files/verPagoFactPendientes.sql");
            PreparedStatement stm = this.conection.prepareStatement(verInfoFacturaApartadoPagos);
            stm.setInt(1, NumFact);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumFact);
            System.out.println("Error al obtener la informacion de los pagos del apartado");
        }
    }

    /**
     * Devuelve el total facturado y el saldo de un credito
     */
    public void verInfoFacturaCredito(int NumFact) {

        try {
            String verInfoFacturaCredito = this.readSql("../Joe/src/"
                    + "sql_files/verPagoCredito.sql");
            PreparedStatement stm = this.conection.prepareStatement(verInfoFacturaCredito);
            stm.setInt(1, NumFact);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumFact);
            System.out.println("Error al obtener la informacion del credito");
        }

    }

    public void verDevoluciones() {
        try {
            String verDevs = this.readSql("../Joe/src/sql_files/"
                    + "VerDevoluciones.sql");
            ResultSet rs = statement.executeQuery(verDevs);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener las devoluciones");
        }
    }

    public void crearDevolucion(int idFactura, BigDecimal descuento, String tipoPago, int idCliente, int idVendedor, String concepto, String detalle, BigDecimal totalFact, String estado) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha = dateFormat.format(date);

        try {
            String CrearDevolucion = this.readSql("../Joe/src/"
                    + "sql_files/CrearDevolucion.sql");
            PreparedStatement stm = conection.prepareStatement(CrearDevolucion, statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, idFactura);
            stm.setDouble(2, descuento.doubleValue());
            stm.setString(3, tipoPago);
            stm.setInt(4, idCliente);
            stm.setInt(5, idVendedor);
            stm.setString(6, concepto);
            stm.setString(7, detalle);
            stm.setString(8, fecha);
            stm.setDouble(9, totalFact.doubleValue());
            stm.setString(10, estado);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("error al crear la devolucion");

        }
    }

    public void insertarProductoCantidadDev(String idProducto, int idVersion, int cantidad, int idFactura, BigDecimal PrecioVenta, int idVersionFacturasProducto) {
        try {
            String insertarProductoCantDev = this.readSql("../Joe/src/sql_files/"
                    + "insertarProductoCantidadDev.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarProductoCantDev);
            stm.setString(1, idProducto);
            stm.setInt(2, idVersion);
            stm.setInt(3, cantidad);
            stm.setInt(4, idFactura);
            stm.setDouble(5, PrecioVenta.doubleValue());
            stm.setInt(6, idVersionFacturasProducto);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar producto cantidad dev");
        }
    }

    /**
     * Esta consulta permite saber cual es el idversion de la devolucion que se
     * esta creando en facturacion es decir la activa('A').
     *
     * @param idDev
     * @return
     */
    public int verVersionDEDevolucionActiva(int idDev) {
        try {
            String verVersionDEDevNueva = this.readSql("../Joe"
                    + "/src/sql_files/verVersionDevNueva.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(verVersionDEDevNueva);
            stm.setInt(1, idDev);
            ResultSet rs = stm.executeQuery();
            int idversion = 0;
            while (rs.next()) {
                idversion = rs.getInt("idVersionDev");
            }
            return idversion;
        } catch (Exception e) {
            System.out.println("Error al obtener la version de la devolucion");
            return 0;
        }
    }

    /**
     * Devuelve todos los productos de una devolucion determinada.
     */
    public void verProductosPorDevolucion(int NumFact) {
        try {
            String verProductosPorDevolucion = this.readSql("../Joe/src/"
                    + "sql_files/verProductosPorDevolucion.sql");
            PreparedStatement stm = this.conection.prepareStatement(verProductosPorDevolucion);
            stm.setInt(1, NumFact);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumFact);
            System.out.println("Error al obtener los productos de la devolucion");
        }
    }

    public int ObtenerUltimoidDev() {
        int result = 0;
        try {
            String ultimoIdDev = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerUltimoidDev.sql");
            PreparedStatement stm = this.conection.prepareStatement(ultimoIdDev);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                result = resultset.getInt(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener el ultimo idDevolucion");
        }
        return result;

    }

    public void verInfoDevolucion(int NumDev) {
        try {
            String verInfoDev = this.readSql("../Joe/src/"
                    + "sql_files/cargarDevolucion.sql");
            PreparedStatement stm = this.conection.prepareStatement(verInfoDev);
            stm.setInt(1, NumDev);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumDev);
            System.out.println("Error al obtener la informacion de la devolucion");
        }
    }

    /**
     * Elimina la devolucion que se modifico(la vuelve inactiva para poder luego
     * ver cuales fueron las modificaciones que se le hicieron a la devolucion)
     *
     * @param NumDev
     */
    public void eliminarDevolucionPorModificacion(int NumDev) {
        try {
            String eliminarDevPorModf = this.readSql("../Joe/src/sql_files/"
                    + "eliminarDevolucionPorModf.sql");
            PreparedStatement stm = this.conection.prepareStatement(eliminarDevPorModf);
            stm.setInt(1, NumDev);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la dev por modificacion");
        }
    }

    /**
     * 'Elimina'(Cambia de estado a eliminada) el numero de devolucion
     * seleccionado
     *
     * @param NumDev
     */
    public void eliminarDevolucion(int NumDev, int idVersionFact) {
        try {
            String eliminar = this.readSql("../Joe/src/sql_files/"
                    + "eliminarDevolucion.sql");
            PreparedStatement stm = this.conection.prepareStatement(eliminar);
            stm.setInt(1, NumDev);
            stm.setInt(2, idVersionFact);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la factura");
        }
    }

    public void VerDevolucionesPorRangoDeFecha(String FechaIni, String FechaFin) {
        try {
            String Dev = this.readSql("../Joe"
                    + "/src/sql_files/VerDevolucionesPorRangoDeFecha.sql");
            PreparedStatement stm = this.conection.prepareStatement(Dev);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al Ver devoluciones Por Rango De Fecha");

        }
    }

    public void VerDevolucionesEliminadas(String FechaIni, String FechaFin) {
        try {
            String Fact = this.readSql("../Joe"
                    + "/src/sql_files/VerDevolucionesEliminadas.sql");
            PreparedStatement stm = this.conection.prepareStatement(Fact);
            stm.setString(1, FechaIni);
            stm.setString(2, FechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));
        } catch (Exception e) {

            System.out.println("Error al Ver Facturas Eliminadas");

        }
    }

    public void insertarCierreDeCaja(String HoraInicio, String Cajero, BigDecimal ReporteInicio) {
        try {
            String insertarProductoCantDev = this.readSql("../Joe/src/sql_files/"
                    + "insertarCierreCaja.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarProductoCantDev);
            stm.setString(1, HoraInicio);
            stm.setString(2, Cajero);
            stm.setDouble(3, ReporteInicio.doubleValue());
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar producto cantidad dev");
        }
    }

    public void verCierreFacturasContado(String fechaInicio, String fechaFinal) {
        try {
            String verFactContadoParaCierre = this.readSql("../Joe/src/"
                    + "sql_files/verCierreFacturasContado.sql");
            PreparedStatement stm = this.conection.prepareStatement(verFactContadoParaCierre);
            stm.setString(1, fechaInicio);
            stm.setString(2, fechaFinal);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener la informacion de las facturas de contado para el cierre");
        }
    }

    public int obtenerultimoidCierre() {
        int result = 0;
        try {
            String ultimoIDCierre = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerUltimoidCierre.sql");
            PreparedStatement stm = this.conection.prepareStatement(ultimoIDCierre);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                result = resultset.getInt(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener el ultimo idCierre");
        }
        return result;

    }

    public String obtenerFechaInicioCierre(int idCierreVigente) {
        String result = "";
        try {
            String HoraInicioCierre = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerHoraInicioCierre.sql");
            PreparedStatement stm = this.conection.prepareStatement(HoraInicioCierre);
            stm.setInt(1, idCierreVigente);
            ResultSet resultset = stm.executeQuery();

            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                result = resultset.getString(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener la hora de inicio del cierre");
        }
        return result;
    }

    public void verCierreApartadosCreditos(String fechaInicio, String fechaFinal) {
        try {
            String verCierreApartadosCreditos = this.readSql("../Joe/src/"
                    + "sql_files/verCierreApartadosCreditos.sql");
            PreparedStatement stm = this.conection.prepareStatement(verCierreApartadosCreditos);
            stm.setString(1, fechaInicio);
            stm.setString(2, fechaFinal);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener la informacion de los creditos y apartados para el cierre");
        }
    }

    public void verCierreDevoluciones(String fechaInicio, String fechaFinal) {
        try {
            String verCierreDevoluciones = this.readSql("../Joe/src/"
                    + "sql_files/verCierreDevoluciones.sql");
            PreparedStatement stm = this.conection.prepareStatement(verCierreDevoluciones);
            stm.setString(1, fechaInicio);
            stm.setString(2, fechaFinal);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al obtener la informacion de las devoluciones para el cierre");
        }
    }

    /**
     * Modifica datos de una persona, nombre es el nombre anterior
     *
     * @param NuevoNombre
     * @param direccion
     * @param tipoPersona
     * @param telefono
     * @param fechaCumple
     * @param cedula
     * @param nombre
     */
    public void modificarPersona(String NuevoNombre, String direccion,
            String telefono, String fechaCumple, String cedula,
            String nombre) {

        try {
            String modif = this.readSql("../Joe/src/"
                    + "sql_files/actualizarInfoPersona.sql");
            PreparedStatement stm = this.conection.prepareStatement(modif);
            stm.setString(1, NuevoNombre);
            stm.setString(2, direccion);
            stm.setString(3, cedula);
            stm.setString(4, telefono);
            stm.setString(5, fechaCumple);
            stm.setString(6, nombre);
            stm.executeUpdate();
        } catch (IOException | SQLException e) {
            System.out.println("Error al actualizar la informacion de persona");
        }

    }

    /**
     * Modifica datos de una persona nombre, menos a fechaCumple
     *
     * @param NuevoNombre
     * @param direccion
     * @param tipoPersona
     * @param telefono
     * @param cedula
     * @param nombre
     */
    public void modificarPersona(String NuevoNombre, String direccion,
            String telefono, String cedula,
            String nombre) {

        try {
            String modif = this.readSql("../Joe/src/"
                    + "sql_files/actualizarInfoFechaPersona.sql");
            PreparedStatement stm = this.conection.prepareStatement(modif);
            stm.setString(1, NuevoNombre);
            stm.setString(2, direccion);
            stm.setString(3, cedula);
            stm.setString(4, telefono);
            stm.setString(5, nombre);
            stm.executeUpdate();
        } catch (IOException | SQLException e) {
            System.out.println("Error al actualizar la informacion de persona");
        }

    }

    public String obtenerCajeroCierre(int idCierreVigente) {
        String result = "";
        try {
            String Cajero = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerCajeroCierre.sql");
            PreparedStatement stm = this.conection.prepareStatement(Cajero);
            stm.setInt(1, idCierreVigente);
            ResultSet resultset = stm.executeQuery();

            while (resultset.next()) {
                result = resultset.getString(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener el cajero del cierre");
        }
        return result;
    }

    public BigDecimal obtenerMontoInicio(int idCierreVigente) {
        BigDecimal result = null;
        try {
            String MontoInicio = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerMontoInicioCierre.sql");
            PreparedStatement stm = this.conection.prepareStatement(MontoInicio);
            stm.setInt(1, idCierreVigente);
            ResultSet resultset = stm.executeQuery();

            while (resultset.next()) {
                result = resultset.getBigDecimal(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener el monto inicial del cierre");
        }
        return result;
    }

    public void actualizarCierreDeCaja(String HoraCierre,
            BigDecimal totalVendido, String observaciones, BigDecimal reportefinal, BigDecimal totalCont, BigDecimal totalTarj,
            BigDecimal totalContReportado, BigDecimal totalTarjReportado,
            int idCierreCaja) {//esta bien
        try {
            String ActualizarCierreCaja = this.readSql("../Joe"
                    + "/src/sql_files/actualizarCierreCaja.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(ActualizarCierreCaja);
            stm.setString(1, HoraCierre);
            stm.setBigDecimal(2, totalVendido);
            stm.setString(3, observaciones);
            stm.setBigDecimal(4, reportefinal);
            stm.setBigDecimal(5, totalCont);
            stm.setBigDecimal(6, totalTarj);
            stm.setBigDecimal(7, totalContReportado);
            stm.setBigDecimal(8, totalTarjReportado);
            stm.setInt(9, idCierreCaja);

            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Actualizar el cierre de caja");
        }
    }

    public void verCierres() {
        try {
            String verCierres = this.readSql("../Joe/src/sql_files/"
                    + "verCierres.sql");
            ResultSet rs = statement.executeQuery(verCierres);
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));
        } catch (Exception e) {
            System.out.println("Error al obtener los cierres");
        }
    }

    public void obtenerInfoCierre(int idCierre) {

        try {
            String ObtenerInfoCierre = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerInfoCierre.sql");
            PreparedStatement stm = this.conection.prepareStatement(ObtenerInfoCierre);
            stm.setInt(1, idCierre);
            ResultSet rs = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(rs));
            this.setData(this.ResultSet_Array(rs));

        } catch (Exception e) {
            System.out.println("Error al obtener la info del cierre");
        }

    }

    public boolean verificarFacturaCierre(String fechaInicio, int idFact) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha = dateFormat.format(date);
        try {
            String verSiModEliminaFactura = this.readSql("../Joe"
                    + "/src/sql_files/verSiModElimFactura.sql");
            PreparedStatement stm = this.conection.prepareStatement(verSiModEliminaFactura);
            stm.setInt(1, idFact);
            stm.setString(2, fechaInicio);
            stm.setString(3, fecha);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("No pertenece al cierre actual esa factura");
            return false;
        }
    }

    public boolean verificarDevCierre(String fechaInicio, int idDev) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha = dateFormat.format(date);
        try {
            String verSiModEliminaDev = this.readSql("../Joe"
                    + "/src/sql_files/verSiModElimDevolucion.sql");
            PreparedStatement stm = this.conection.prepareStatement(verSiModEliminaDev);
            stm.setInt(1, idDev);
            stm.setString(2, fechaInicio);
            stm.setString(3, fecha);
            ResultSet rs = stm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("No pertenece al cierre actual esa devolucion");
            return false;
        }
    }

    public void consultarAdministradores() {
        try {
            String administradores = this.readSql("../Joe/src/"
                    + "sql_files/ConsultarAdministradores.sql");
            PreparedStatement stm = this.conection.prepareStatement(administradores);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("Error al Consultar Administradores");
        }

    }

    public int ObtenerUltimoidMovimiento() {
        int result = 0;
        try {
            String verUltimoIdMov = this.readSql("../Joe/"
                    + "src/sql_files/ObtenerUltimoidMovimiento.sql");
            PreparedStatement stm = this.conection.prepareStatement(verUltimoIdMov);
            ResultSet resultset = stm.executeQuery();
            //Imprime el resultado obtenido del valor del inventario
            while (resultset.next()) {
                result = resultset.getInt(1);

            }

        } catch (Exception e) {
            System.out.println("Error al obtener el ultimo idMovimientos");
        }
        return result;
    }

    /**
     * Este metodo permite crear un cliente
     *
     * @param idCliente
     */
    public void insertarIdCliente(int idCliente) {
        try {
            String insertarIdCliente = this.readSql("../Joe"
                    + "/src/sql_files/crearIdCliente.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarIdCliente);
            stm.setInt(1, idCliente);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("No se pudo insertar el cliente");

        }
    }

    public void insertarProductoCantidadMovimiento(String idProducto, int idVersion, int idMovimiento, int cantidad, BigDecimal PrecioVenta) {
        try {
            String insertarProductoCantFact = this.readSql("../Joe/src/sql_files/"
                    + "insertarProductoCantidadMov.sql");
            PreparedStatement stm = this.conection.prepareStatement(insertarProductoCantFact);
            stm.setString(1, idProducto);
            stm.setInt(2, idVersion);
            stm.setInt(3, idMovimiento);
            stm.setInt(4, cantidad);
            stm.setBigDecimal(5, PrecioVenta);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar producto cantidad movimiento");
        }
    }

    public int verCantidadBodega(String idProducto) {
        int cantidad = 0;
        try {
            String verCantidad = this.readSql("../Joe"
                    + "/src/sql_files/verCantidadPorCod_Bodega.sql");
            PreparedStatement stm = this.conection.prepareStatement(verCantidad);
            stm.setString(1, idProducto);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt("Cantidad");
            }
            return cantidad;
        } catch (Exception e) {
            System.out.println(cantidad);
            System.out.println("Error al obtener la cantidad del producto en bodega");
            return 0;
        }
    }

    public void verEntradasMercaderia() {
        try {
            String VerEntradasMercaderia = readSql("../Joe/src/"
                    + "sql_files/verEntradasMercaderia.sql");
            ResultSet resultset = statement.executeQuery(VerEntradasMercaderia);
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));

        } catch (Exception e) {
            System.out.println("Error al ver entradas de mercaderia");
        }
    }

    public void eliminarUsuario(String usuario, String tipoUsuario) {
        try {
            String Usuario = this.readSql("../Joe"
                    + "/src/sql_files/eliminarUsuario.sql");
            PreparedStatement stm = this.conection.prepareStatement(Usuario);
            stm.setString(1, usuario);
            stm.setString(2, tipoUsuario);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("No se pudo eliminar el usuario");

        }
    }

    public boolean insertarPersona(String nombre, String direccion,
            String telefono, String fechaCumpleanos) {
        try {
            String PersonaUsuario = this.readSql("../Joe"
                    + "/src/sql_files/CrearPersona.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(PersonaUsuario);
            stm.setString(1, nombre);
            stm.setString(2, direccion);
            stm.setString(3, telefono);
            stm.setString(4, fechaCumpleanos);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al crear Usuario");

        }
        return false;
    }

    public void modificarUsuario(String nombre, String direccion,
            String telefono, String fechaCumpleanos, String clave,
            String tipoUsuario, String nombreNuevo) {
        try {
            String PersonaUsuario = this.readSql("../Joe"
                    + "/src/sql_files/modificarUsuario.sql");
            PreparedStatement stm = this.conection.
                    prepareStatement(PersonaUsuario);
            stm.setString(1, clave);
            stm.setString(2, direccion);
            stm.setString(3, telefono);
            stm.setString(4, fechaCumpleanos);
            stm.setString(5, nombreNuevo);
            stm.setString(6, nombre);
            stm.setString(7, tipoUsuario);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar el Usuario");

        }

    }

    public void insertarUsuario(String tipoUsuario, String clave) {
        try {
            String Usuario = this.readSql("../Joe"
                    + "/src/sql_files/InsertarUsuario.sql");
            PreparedStatement stm = this.conection.prepareStatement(Usuario);
            stm.setString(1, tipoUsuario);
            stm.setString(2, clave);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar Usuario");

        }
    }

    /**
     * Obtener la contrasena de un usuario
     *
     * @param usuario
     * @param tipoUsuario
     */
    public void ConsultarContrasena(String usuario, String tipoUsuario) {
        try {
            String Usuario = this.readSql("../Joe"
                    + "/src/sql_files/ConsultarUsuario.sql");
            PreparedStatement stm = this.conection.prepareStatement(Usuario);
            stm.setString(1, tipoUsuario);
            stm.setString(2, usuario);
            ResultSet resultset = stm.executeQuery();
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println("No se pudo cosultar la contrasena del usuario");

        }
    }

    public void actualizarPrecioProducto(String idProducto, BigDecimal precio) {
        try {
            String actualizarPrecio = this.readSql("../Joe"
                    + "/src/sql_files/actualizarPrecioProductoInventario.sql");
            PreparedStatement stm
                    = this.conection.prepareStatement(actualizarPrecio);
            stm.setBigDecimal(1, precio);
            stm.setString(2, idProducto);
            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al Actualizar el precio de un producto en el inventario");
        }
    }

    public void eliminarProductosQueNoTienenInventario() {
        try {
            String eliminaProductos = this.readSql("../Joe"
                    + "/src/sql_files/eliminaProductosSinINV.sql");
            statement.executeUpdate(eliminaProductos);
        } catch (Exception e) {
            System.out.println("Error al eliminar los productos que no tienen ningun inventario");
        }
    }

    public void verProductosPorMovimiento(int NumMov) {
        try {
            String verProductosPorFactura = this.readSql("../Joe/src/"
                    + "sql_files/verProductosPorMovimiento.sql");
            PreparedStatement stm = this.conection.prepareStatement(verProductosPorFactura);
            stm.setInt(1, NumMov);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (Exception e) {
            System.out.println(NumMov);
            System.out.println("Error al obtener los productos del movimiento");
        }
    }

    public void verInfoMovimiento(int NumMovimiento) {
        try {
            String verInfoMovimiento = this.readSql("../Joe/src/"
                    + "sql_files/cargarMovimiento.sql");
            PreparedStatement stm = this.conection.prepareStatement(verInfoMovimiento);
            stm.setInt(1, NumMovimiento);
            ResultSet resultset = stm.executeQuery();
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));
        } catch (IOException | SQLException e) {
            System.out.println(NumMovimiento);
            System.out.println("Error al obtener la informacion del movimiento");
        }
    }

    public void verSalidasMercaderia() {
        try {
            String verSalidasMercaderia = readSql("../Joe/src/"
                    + "sql_files/verSalidasMercaderia.sql");
            ResultSet resultset = statement.executeQuery(verSalidasMercaderia);
            this.setColumnNames(this.Get_Columnas(resultset));
            this.setData(this.ResultSet_Array(resultset));

        } catch (IOException | SQLException e) {
            System.out.println("Error al ver salidas de mercaderia");
        }
    }

    public void VerMovimientosPorFechaYLugar(String tipo, String lugar, String fechaIni, String fechaFin) {
        try {
            System.out.println("tipo "+tipo+" lugar "+lugar);
            String movimientos = readSql("../Joe/"
                    + "src/sql_files/VerMovimientosPorFechaYLugar.sql");
            PreparedStatement stm = conection.prepareStatement(movimientos);
            stm.setString(1, tipo);
            stm.setString(2, lugar);
            stm.setString(3, fechaIni);
            stm.setString(4, fechaFin);
            ResultSet rs = stm.executeQuery();
            setColumnNames(Get_Columnas(rs));
            setData2(ResultSet_Array(rs));

        } catch (IOException | SQLException e) {
            System.out.println("Error al Ver Movimientos Por Fecha Y Lugar");
        }
    }

}
