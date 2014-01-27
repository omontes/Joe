/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe;


import db_managment.Direct_Control_BD;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author edward
 */
public class JPanel_Inventario extends javax.swing.JPanel {

    /**
     * Creates new form JPanel_Inventario
     */
    
    private static JPanel_Inventario mPanelInventario=null;
    boolean ctrlPressed = false;
    boolean cPressed = false;
        
    private JPanel_Inventario() {
        initComponents();
        colocarInventario();
         
    }
    
    public static JPanel_Inventario getInstance(){
        if(mPanelInventario==null)
        {
            mPanelInventario=new JPanel_Inventario();
        }
        
        return mPanelInventario;
        
        
    }
    
    private void personalizarTablaInventario() {
    /*    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
      //  this.jTextField_Date.setText(dateFormat.format(date))
        String[] columnNames = {"Edward","Uma;a","Relacion","Relacion",
            "Relacion"};
        List<Object[]> data = new ArrayList<Object[]>();
                 
        
        
        //Agrega el modelo a la factura
        MyTableModel_FACT model=new MyTableModel_FACT(columnNames,data);
        //Agrega 5 filas
        model.addRow(11);
       
        this.jTable_Inventario.setModel(model);
        //Gana la atencion en el panel
        jTable_Inventario.requestFocus();
        jTable_Inventario.changeSelection(0,0,false, false);
        //AGREGA EL LISTENER QUE PERMITE HACER TODOS LOS EVENTOS DENTRO DE LA 
        //TABLA DE FACTURA //IMPORTANTE ESTOS EVENTOS ESTAN EN LA CLASE DE
        //MY TABLE MODEL LISTENER EN el metodo: tableChanged(TableModelEvent e)
      /*   this.jTable_Inventario.getModel().addTableModelListener(
                new MyTableModelListener_FACT(jTable_Inventario,"",
                this.jTextField1,this.AdministradorBD));
        //Permite que la primera columna de Codigos se desplace segun lo que
        // haya en la base de datos
     /*   this.AdministradorBD.verCodigos();
        String[] idproductos=this.obtenerFila(this.AdministradorBD.getData());
        this.jTable_Inventario.getColumnModel().getColumn(0).
                setCellEditor(new SeleccionadorEditor(idproductos,jTable_Factura));
        Permite que la segunda columna de Descripciones se desplace segun 
        lo que haya en la base de datos
        BDmanagment.get_DescProductos();
        String[] desc_Productos=this.get_Fila(this.BDmanagment.getData());
        this.jTable_Factura.getColumnModel().getColumn(1).
                setCellEditor(new SeleccionadorEditor(desc_Productos,jTable_Factura));**/
       /* Costumisando Precio y Cantidad (Solo van a permitir numeros)
        this.jTable_Factura.getColumnModel().getColumn(2).
                setCellEditor(new MyCellEditor());
        this.jTable_Factura.getColumnModel().getColumn(3).
                setCellEditor(new MyCellEditor());
        Demasiado importante ******Permite que se pueda editar apenas se 
        //ingresan datos
        this.jTable_Factura.setSurrendersFocusOnKeystroke(true);
        
        */
    }

    public void colocarMovimientos()
    {
        Direct_Control_BD AdministradorBD= Direct_Control_BD.getInstance();
        AdministradorBD.verMovimientos();
        String[] columnNames = AdministradorBD.getColumnNames();
        Object[][] data = AdministradorBD.getData();
       
        this.jTable_Movimientos.setModel(new Modelo_Movimientos(columnNames,data));
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
         centerRenderer.setHorizontalAlignment(JLabel.CENTER );
        this.jTable_Movimientos.getColumnModel().getColumn(0).setCellRenderer
                (centerRenderer);
    }
    
    public void colocarInventario(){
      Direct_Control_BD AdministradorBD= Direct_Control_BD.getInstance();
        AdministradorBD.verInventario();
        String[] columnNames = AdministradorBD.getColumnNames();
        Object[][] data = AdministradorBD.getData();
        //Crea la tabla generica para Facturas
        
        this.jTable_Inventario.setModel(new Modelo_Inventario(columnNames,data));
        //Alinea la primer columna de esta tabla hacia el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer
                ();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER );
        this.jTable_Inventario.getColumnModel().getColumn(0).setCellRenderer
                (centerRenderer);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_CrearProducto = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jTextField_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Precio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Cantidad = new javax.swing.JTextField();
        jButton_CrearProducto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_CategoriaCrearProducto = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_DescripcionCrearProducto = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jTextField_CostoCrearProducto = new javax.swing.JTextField();
        jDialog_EliminarProducto = new javax.swing.JDialog();
        jButton_EliminarProducto = new javax.swing.JButton();
        jTextField_IdProducto = new javax.swing.JTextField();
        jDialog_ModificarProducto = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jTextField_CodigoProducto = new javax.swing.JTextField();
        jLabel_Codigo = new javax.swing.JLabel();
        jLabel_Nombre = new javax.swing.JLabel();
        jTextField_nombre1 = new javax.swing.JTextField();
        jLabel_Precio = new javax.swing.JLabel();
        jTextField_Precio1 = new javax.swing.JTextField();
        jTextField_Costo = new javax.swing.JTextField();
        jButton_CrearProducto1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel_Costo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Categorias = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_CrearCategoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField_Descripcion = new javax.swing.JTextArea();
        jDialog_ConfirmacionModificacionProducto = new javax.swing.JDialog();
        jTextField_IdProductoModificar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jDialog_CrearCategoria = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField_NombreCategoria = new javax.swing.JTextField();
        jDialog_VerProducto = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jTextField_CodigoVerProducto = new javax.swing.JTextField();
        jLabel_Codigo2 = new javax.swing.JLabel();
        jLabel_Nombre2 = new javax.swing.JLabel();
        jTextField_nombreVerProducto = new javax.swing.JTextField();
        jLabel_Precio2 = new javax.swing.JLabel();
        jTextField_PrecioVerProducto = new javax.swing.JTextField();
        jTextField_CostoVerProducto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel_Costo2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField_DescripcionVerProducto = new javax.swing.JTextField();
        jTextField_CategoriaVerProducto = new javax.swing.JTextField();
        jDialog_ConfirmacionVerProducto = new javax.swing.JDialog();
        jTextField_IdProductoModificar1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel_Movimientos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Movimientos = new javax.swing.JTable();
        jButton_RecibirMovimientos = new javax.swing.JButton();
        jButton_RetirarMovimientos = new javax.swing.JButton();
        jButton_ModificarMovimientos = new javax.swing.JButton();
        jButton_RegresarMovimientos = new javax.swing.JButton();
        jDialog_RecibirProductoMovimientos = new javax.swing.JDialog();
        jLabel13 = new javax.swing.JLabel();
        jTextField_CodigoProductoMovimiento = new javax.swing.JTextField();
        jTextField_CantidadMovimientos = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField_DetalleMovimientos = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboBox_LugarMovimientos = new javax.swing.JComboBox();
        jButton_CrearMovimiento = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDialog_RetirarProductoMovimientos = new javax.swing.JDialog();
        jLabel21 = new javax.swing.JLabel();
        jTextField_CodigoProductoMovimiento1 = new javax.swing.JTextField();
        jTextField_CantidadMovimientos1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField_DetalleMovimientos1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jComboBox_LugarMovimientos1 = new javax.swing.JComboBox();
        jButton_CrearMovimiento1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonRegresarInventario = new javax.swing.JButton();
        jButton_CrearProductoInventario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Inventario = new javax.swing.JTable();
        jButton_EliminarProductoInventario = new javax.swing.JButton();
        jButton_ModificarProducto = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButtonEntrarMovimientos = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jTextField_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_codigoKeyTyped(evt);
            }
        });

        jLabel1.setText("Codigo del Producto");

        jLabel2.setText("Nombre del Producto");

        jTextField_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_nombreKeyTyped(evt);
            }
        });

        jLabel3.setText("Precio del Producto");

        jTextField_Precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_PrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_PrecioKeyTyped(evt);
            }
        });

        jLabel4.setText("Cantidad del Producto");

        jTextField_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_CantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CantidadKeyTyped(evt);
            }
        });

        jButton_CrearProducto.setText("Aceptar");
        jButton_CrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearProductoActionPerformed(evt);
            }
        });

        jLabel10.setText("Categoria");

        jComboBox_CategoriaCrearProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_CategoriaCrearProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox_CategoriaCrearProductoFocusGained(evt);
            }
        });
        jComboBox_CategoriaCrearProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox_CategoriaCrearProductoKeyTyped(evt);
            }
        });

        jLabel11.setText("Descripcion");

        jTextArea_DescripcionCrearProducto.setColumns(20);
        jTextArea_DescripcionCrearProducto.setRows(5);
        jTextArea_DescripcionCrearProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea_DescripcionCrearProductoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea_DescripcionCrearProducto);

        jLabel12.setText("Costo");

        jTextField_CostoCrearProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_CostoCrearProductoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CostoCrearProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_CategoriaCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Precio)
                                    .addComponent(jTextField_Cantidad)
                                    .addComponent(jTextField_codigo)
                                    .addComponent(jTextField_nombre))
                                .addGap(75, 75, 75))
                            .addComponent(jTextField_CostoCrearProducto)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_CrearProducto))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)))
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_CategoriaCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_CostoCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jButton_CrearProducto)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jDialog_CrearProductoLayout = new javax.swing.GroupLayout(jDialog_CrearProducto.getContentPane());
        jDialog_CrearProducto.getContentPane().setLayout(jDialog_CrearProductoLayout);
        jDialog_CrearProductoLayout.setHorizontalGroup(
            jDialog_CrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_CrearProductoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_CrearProductoLayout.setVerticalGroup(
            jDialog_CrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_CrearProductoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton_EliminarProducto.setText("Eliminar");
        jButton_EliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarProductoActionPerformed(evt);
            }
        });

        jTextField_IdProducto.setText("idProducto");
        jTextField_IdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog_EliminarProductoLayout = new javax.swing.GroupLayout(jDialog_EliminarProducto.getContentPane());
        jDialog_EliminarProducto.getContentPane().setLayout(jDialog_EliminarProductoLayout);
        jDialog_EliminarProductoLayout.setHorizontalGroup(
            jDialog_EliminarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_EliminarProductoLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(jDialog_EliminarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_EliminarProductoLayout.createSequentialGroup()
                        .addComponent(jButton_EliminarProducto)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_EliminarProductoLayout.createSequentialGroup()
                        .addComponent(jTextField_IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))))
        );
        jDialog_EliminarProductoLayout.setVerticalGroup(
            jDialog_EliminarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_EliminarProductoLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jTextField_IdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton_EliminarProducto)
                .addGap(23, 23, 23))
        );

        jDialog_ModificarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDialog_ModificarProductoKeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jTextField_CodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoProductoKeyTyped(evt);
            }
        });

        jLabel_Codigo.setText("Codigo");

        jLabel_Nombre.setText("Nombre");

        jTextField_nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_nombre1KeyTyped(evt);
            }
        });

        jLabel_Precio.setText("Precio");

        jTextField_Precio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_Precio1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Precio1KeyTyped(evt);
            }
        });

        jTextField_Costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_CostoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CostoKeyTyped(evt);
            }
        });

        jButton_CrearProducto1.setText("Aceptar");
        jButton_CrearProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearProducto1ActionPerformed(evt);
            }
        });

        jLabel_Costo.setText("Costo");

        jLabel5.setText("Categoria");

        jComboBox_Categorias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Categorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox_CategoriasKeyTyped(evt);
            }
        });

        jLabel7.setText("Descripcion");

        jButton_CrearCategoria.setText("Nueva");
        jButton_CrearCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearCategoriaActionPerformed(evt);
            }
        });
        jButton_CrearCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton_CrearCategoriaFocusGained(evt);
            }
        });

        jTextField_Descripcion.setColumns(20);
        jTextField_Descripcion.setRows(5);
        jTextField_Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_DescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DescripcionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextField_Descripcion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel_Nombre)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Costo))
                                .addComponent(jLabel_Codigo, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_CrearCategoria)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Precio1)
                                    .addComponent(jTextField_Costo)
                                    .addComponent(jTextField_CodigoProducto)
                                    .addComponent(jTextField_nombre1))
                                .addGap(75, 75, 75))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(jLabel6)))
                        .addGap(0, 12, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_CrearProducto1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Precio)
                    .addComponent(jTextField_Precio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Costo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox_Categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_CrearCategoria))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_CrearProducto1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog_ModificarProductoLayout = new javax.swing.GroupLayout(jDialog_ModificarProducto.getContentPane());
        jDialog_ModificarProducto.getContentPane().setLayout(jDialog_ModificarProductoLayout);
        jDialog_ModificarProductoLayout.setHorizontalGroup(
            jDialog_ModificarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_ModificarProductoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDialog_ModificarProductoLayout.setVerticalGroup(
            jDialog_ModificarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_ModificarProductoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField_IdProductoModificar.setText("idProducto");
        jTextField_IdProductoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdProductoModificarActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog_ConfirmacionModificacionProductoLayout = new javax.swing.GroupLayout(jDialog_ConfirmacionModificacionProducto.getContentPane());
        jDialog_ConfirmacionModificacionProducto.getContentPane().setLayout(jDialog_ConfirmacionModificacionProductoLayout);
        jDialog_ConfirmacionModificacionProductoLayout.setHorizontalGroup(
            jDialog_ConfirmacionModificacionProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_ConfirmacionModificacionProductoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_ConfirmacionModificacionProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_IdProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jDialog_ConfirmacionModificacionProductoLayout.setVerticalGroup(
            jDialog_ConfirmacionModificacionProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_ConfirmacionModificacionProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_IdProductoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel8.setText("Nombre");

        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog_CrearCategoriaLayout = new javax.swing.GroupLayout(jDialog_CrearCategoria.getContentPane());
        jDialog_CrearCategoria.getContentPane().setLayout(jDialog_CrearCategoriaLayout);
        jDialog_CrearCategoriaLayout.setHorizontalGroup(
            jDialog_CrearCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_CrearCategoriaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jDialog_CrearCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jTextField_NombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jDialog_CrearCategoriaLayout.setVerticalGroup(
            jDialog_CrearCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_CrearCategoriaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jDialog_CrearCategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_NombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel_Codigo2.setText("Codigo");

        jLabel_Nombre2.setText("Nombre");

        jLabel_Precio2.setText("Precio");

        jLabel_Costo2.setText("Costo");

        jLabel15.setText("Categoria");

        jLabel17.setText("Descripcion");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel_Nombre2)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Precio2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Costo2))
                                .addComponent(jLabel_Codigo2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_PrecioVerProducto)
                            .addComponent(jTextField_CostoVerProducto)
                            .addComponent(jTextField_CodigoVerProducto)
                            .addComponent(jTextField_nombreVerProducto)
                            .addComponent(jTextField_CategoriaVerProducto))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jTextField_DescripcionVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CodigoVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Codigo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_nombreVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Nombre2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Precio2)
                    .addComponent(jTextField_PrecioVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CostoVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Costo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField_CategoriaVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel17))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jTextField_DescripcionVerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDialog_VerProductoLayout = new javax.swing.GroupLayout(jDialog_VerProducto.getContentPane());
        jDialog_VerProducto.getContentPane().setLayout(jDialog_VerProductoLayout);
        jDialog_VerProductoLayout.setHorizontalGroup(
            jDialog_VerProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_VerProductoLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jDialog_VerProductoLayout.setVerticalGroup(
            jDialog_VerProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTextField_IdProductoModificar1.setText("idProducto");
        jTextField_IdProductoModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_IdProductoModificar1ActionPerformed(evt);
            }
        });

        jButton3.setText("Aceptar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog_ConfirmacionVerProductoLayout = new javax.swing.GroupLayout(jDialog_ConfirmacionVerProducto.getContentPane());
        jDialog_ConfirmacionVerProducto.getContentPane().setLayout(jDialog_ConfirmacionVerProductoLayout);
        jDialog_ConfirmacionVerProductoLayout.setHorizontalGroup(
            jDialog_ConfirmacionVerProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_ConfirmacionVerProductoLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_ConfirmacionVerProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_IdProductoModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jDialog_ConfirmacionVerProductoLayout.setVerticalGroup(
            jDialog_ConfirmacionVerProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_ConfirmacionVerProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField_IdProductoModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable_Movimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable_Movimientos);

        jButton_RecibirMovimientos.setText("Recibir");
        jButton_RecibirMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RecibirMovimientosActionPerformed(evt);
            }
        });

        jButton_RetirarMovimientos.setText("Retirar");
        jButton_RetirarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RetirarMovimientosActionPerformed(evt);
            }
        });

        jButton_ModificarMovimientos.setText("Modificar");

        jButton_RegresarMovimientos.setText("Regresar");
        jButton_RegresarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegresarMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_MovimientosLayout = new javax.swing.GroupLayout(jPanel_Movimientos);
        jPanel_Movimientos.setLayout(jPanel_MovimientosLayout);
        jPanel_MovimientosLayout.setHorizontalGroup(
            jPanel_MovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MovimientosLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel_MovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_MovimientosLayout.createSequentialGroup()
                        .addComponent(jButton_RecibirMovimientos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_RetirarMovimientos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_ModificarMovimientos))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MovimientosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_RegresarMovimientos)
                .addGap(22, 22, 22))
        );
        jPanel_MovimientosLayout.setVerticalGroup(
            jPanel_MovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_MovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_RecibirMovimientos)
                    .addComponent(jButton_RetirarMovimientos)
                    .addComponent(jButton_ModificarMovimientos))
                .addGap(18, 18, 18)
                .addComponent(jButton_RegresarMovimientos)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel13.setText("Codigo");

        jTextField_CodigoProductoMovimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoProductoMovimientoKeyTyped(evt);
            }
        });

        jTextField_CantidadMovimientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_CantidadMovimientosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CantidadMovimientosKeyTyped(evt);
            }
        });

        jLabel18.setText("Cantidad");

        jLabel19.setText("Detalle");

        jTextField_DetalleMovimientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DetalleMovimientosKeyTyped(evt);
            }
        });

        jLabel20.setText("Lugar");

        jComboBox_LugarMovimientos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_LugarMovimientos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox_LugarMovimientosKeyTyped(evt);
            }
        });

        jButton_CrearMovimiento.setText("Crear");
        jButton_CrearMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearMovimientoActionPerformed(evt);
            }
        });

        jButton4.setText("Buscar");
        jButton4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton4FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jDialog_RecibirProductoMovimientosLayout = new javax.swing.GroupLayout(jDialog_RecibirProductoMovimientos.getContentPane());
        jDialog_RecibirProductoMovimientos.getContentPane().setLayout(jDialog_RecibirProductoMovimientosLayout);
        jDialog_RecibirProductoMovimientosLayout.setHorizontalGroup(
            jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_RecibirProductoMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18)
                    .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog_RecibirProductoMovimientosLayout.createSequentialGroup()
                        .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField_CantidadMovimientos, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(jTextField_CodigoProductoMovimiento))
                            .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_CrearMovimiento)
                                .addComponent(jComboBox_LugarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addComponent(jTextField_DetalleMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jDialog_RecibirProductoMovimientosLayout.setVerticalGroup(
            jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_RecibirProductoMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField_CodigoProductoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CantidadMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField_DetalleMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog_RecibirProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox_LugarMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_CrearMovimiento)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel21.setText("Codigo");

        jTextField_CodigoProductoMovimiento1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoProductoMovimiento1KeyTyped(evt);
            }
        });

        jTextField_CantidadMovimientos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_CantidadMovimientos1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CantidadMovimientos1KeyTyped(evt);
            }
        });

        jLabel22.setText("Cantidad");

        jLabel23.setText("Detalle");

        jTextField_DetalleMovimientos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DetalleMovimientos1KeyTyped(evt);
            }
        });

        jLabel24.setText("Lugar");

        jComboBox_LugarMovimientos1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_LugarMovimientos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboBox_LugarMovimientos1KeyTyped(evt);
            }
        });

        jButton_CrearMovimiento1.setText("Crear");
        jButton_CrearMovimiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearMovimiento1ActionPerformed(evt);
            }
        });

        jButton5.setText("Buscar");
        jButton5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton5FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jDialog_RetirarProductoMovimientosLayout = new javax.swing.GroupLayout(jDialog_RetirarProductoMovimientos.getContentPane());
        jDialog_RetirarProductoMovimientos.getContentPane().setLayout(jDialog_RetirarProductoMovimientosLayout);
        jDialog_RetirarProductoMovimientosLayout.setHorizontalGroup(
            jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_RetirarProductoMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog_RetirarProductoMovimientosLayout.createSequentialGroup()
                        .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField_CantidadMovimientos1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(jTextField_CodigoProductoMovimiento1))
                            .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton_CrearMovimiento1)
                                .addComponent(jComboBox_LugarMovimientos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addComponent(jTextField_DetalleMovimientos1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jDialog_RetirarProductoMovimientosLayout.setVerticalGroup(
            jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_RetirarProductoMovimientosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField_CodigoProductoMovimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_CantidadMovimientos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField_DetalleMovimientos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog_RetirarProductoMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox_LugarMovimientos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_CrearMovimiento1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jButtonRegresarInventario.setText("Regresar");
        jButtonRegresarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarInventarioActionPerformed(evt);
            }
        });

        jButton_CrearProductoInventario.setText("Crear Producto");
        jButton_CrearProductoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CrearProductoInventarioActionPerformed(evt);
            }
        });

        jTable_Inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable_Inventario);

        jButton_EliminarProductoInventario.setText("Eliminar");
        jButton_EliminarProductoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EliminarProductoInventarioActionPerformed(evt);
            }
        });

        jButton_ModificarProducto.setText("Modificar");
        jButton_ModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ModificarProductoActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Ver Producto");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButtonEntrarMovimientos.setText("Movimientos");
        jButtonEntrarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(jButtonEntrarMovimientos))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_CrearProductoInventario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_EliminarProductoInventario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_ModificarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jToggleButton1))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRegresarInventario)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButtonEntrarMovimientos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_CrearProductoInventario)
                    .addComponent(jButton_EliminarProductoInventario)
                    .addComponent(jButton_ModificarProducto)
                    .addComponent(jToggleButton1))
                .addGap(50, 50, 50)
                .addComponent(jButtonRegresarInventario)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarInventarioActionPerformed
        VentanaDeInicio mVentana= VentanaDeInicio.getInstance();
        mVentana.remove(this);
        mVentana.revalidate();
        mVentana.repaint();
        mVentana.setTitle("Joe ");
        mVentana.add(mVentana.jPanel_VentanaPrincipal);
        mVentana.jPanel_VentanaPrincipal.setVisible(true);
        mVentana.jPanel_VentanaPrincipal.setSize(this.getSize());
        mVentana.jPanel_VentanaPrincipal.setLocation(this.getLocation());
        
        
     
    }//GEN-LAST:event_jButtonRegresarInventarioActionPerformed

    private void jButton_CrearProductoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearProductoInventarioActionPerformed
      this.jDialog_CrearProducto.setSize(510,500);
        this.jDialog_CrearProducto.setVisible(true);  
        
        Direct_Control_BD mBD= Direct_Control_BD.getInstance();
        mBD.consultarCategorias();
       String[] columnNames = mBD.getColumnNames();
       Object[][] data = mBD.getData();
       
       columnNames = mBD.getColumnNames();
       data = mBD.getData();
       
       this.jComboBox_CategoriaCrearProducto.removeAllItems();
       for(int i=0; i<data.length; i++){
             this.jComboBox_CategoriaCrearProducto.addItem(data[i][1]);
       }
       
       this.jComboBox_CategoriaCrearProducto.setSelectedItem("Sin Categoria");
        
    }//GEN-LAST:event_jButton_CrearProductoInventarioActionPerformed
//String idProducto, String nombre, int precio,
            //int costo, String fechaCreacion, String estado, String Descripcion,
            //int idCategoria
    private void jButton_CrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearProductoActionPerformed
        VentanaDeInicio miVentana= VentanaDeInicio.getInstance();
        Direct_Control_BD AdminBD = Direct_Control_BD.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        BigDecimal bd= new BigDecimal("0.0");
        String codigo=this.jTextField_codigo.getText();
      try
      {
          try{
            bd = new BigDecimal(this.jTextField_Precio.getText().toString());
          }
          catch (NumberFormatException exc) 
         { 
             JOptionPane.showOptionDialog(this, "El precio no es valido", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar");
         }
          
      int idCategoria = AdminBD.consultarIdCategoriaXNombre(this.jComboBox_CategoriaCrearProducto.getSelectedItem().toString());
      String Descripcion=this.jTextArea_DescripcionCrearProducto.getText();
      String Nombre=this.jTextField_nombre.getText();
      int Costo= Integer.parseInt(this.jTextField_CostoCrearProducto.getText());
      AdminBD.crearProducto(codigo,Nombre,bd,Costo
                ,dateFormat.format(date),"A",Descripcion
                ,idCategoria);
        AdminBD.insertarEnInventario(this.jTextField_codigo.getText
            (),1,Integer.parseInt(this.jTextField_Cantidad.getText()));
        this.jTextField_Cantidad.setText("");
        this.jTextField_Precio.setText("");
        this.jTextField_codigo.setText("");
        this.jTextField_nombre.setText("");
        this.jDialog_CrearProducto.dispose();
         colocarInventario();
         
      } 
         catch (NumberFormatException exc) 
         { 
             JOptionPane.showOptionDialog(this, "Faltan datos necesarios", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar");
         }
      
      
        /*
        MyTableModel_FACT model = (MyTableModel_FACT) jTable_Inventario.getModel();
        model.setValueAt(codigo,jTable_Inventario.getSelectedRow(),0);
        jTable_Inventario.revalidate();
        jTable_Inventario.repaint();
        jTable_Inventario.changeSelection( jTable_Inventario.getSelectedRow()+1, jTable_Inventario.getSelectedColumn(), false, false );
        jTable_Inventario.requestFocus();*/
    }//GEN-LAST:event_jButton_CrearProductoActionPerformed

    private void jButton_EliminarProductoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarProductoInventarioActionPerformed
        this.jDialog_EliminarProducto.setSize(200,200);
       JPanel_Inventario mPanel= JPanel_Inventario.getInstance();
       this.jDialog_EliminarProducto.setLocation(mPanel.getLocation());
       this.jDialog_EliminarProducto.setVisible(true); 
       
    }//GEN-LAST:event_jButton_EliminarProductoInventarioActionPerformed

    private void jButton_EliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EliminarProductoActionPerformed
       Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       
       mBD.consultarProducto(this.jTextField_IdProducto.getText());
       
       Object[][] data = mBD.getData();
       if(data.length==0)
       {
           JOptionPane.showOptionDialog(this, "El producto no existe", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar"); 
       }
       else{
  
       mBD.eliminarProducto(this.jTextField_IdProducto.getText());
       this.jTextField_IdProducto.setText("          ");
       this.jDialog_EliminarProducto.dispose();
       colocarInventario();
       }
       
       
    }//GEN-LAST:event_jButton_EliminarProductoActionPerformed

    private void jTextField_IdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IdProductoActionPerformed

   // String idProducto, String nombre,
     //       int precio, int idCategoria, int costo, String Descripcion
                    
    private void jButton_CrearProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearProducto1ActionPerformed
        
       //Nombre=?,Precio=?, idCategoriaProd=?, Costo=?, Descripcion=?
       try{
       Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       BigDecimal Precio= new BigDecimal( this.jTextField_Precio1.getText());
        int IdCategoria = mBD.consultarIdCategoriaXNombre(this.jComboBox_Categorias.getSelectedItem().toString());
         mBD.modificarProducto(this.jTextField_CodigoProducto.getText(),
                 this.jTextField_nombre1.getText(),Precio
                ,
               IdCategoria
               ,Integer.parseInt(this.jTextField_Costo.getText()),
               this.jTextField_Descripcion.getText());
         
         this.jDialog_ModificarProducto.dispose();
         colocarInventario();
       }
       catch (NumberFormatException exc) 
         { 
             JOptionPane.showOptionDialog(this, "El precio no es valido", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar");
         }
    }//GEN-LAST:event_jButton_CrearProducto1ActionPerformed

    private void jButton_ModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ModificarProductoActionPerformed
       
        this.jDialog_ConfirmacionModificacionProducto.setSize(200,100);
       JPanel_Inventario mPanel= JPanel_Inventario.getInstance();
       this.jDialog_ConfirmacionModificacionProducto.setLocation(mPanel.getLocation());
       this.jDialog_ConfirmacionModificacionProducto.setVisible(true); 
    }//GEN-LAST:event_jButton_ModificarProductoActionPerformed

    private void jTextField_IdProductoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdProductoModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IdProductoModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jDialog_ConfirmacionModificacionProducto.dispose();

        Direct_Control_BD mBD = Direct_Control_BD.getInstance();
        mBD.consultarProducto(this.jTextField_IdProductoModificar.getText());
        String[] columnNames = mBD.getColumnNames();
        Object[][] data = mBD.getData();
       //Nombre,Precio,Costo,idCategoriaProd,Descripcion

        if (data.length == 0) {
            JOptionPane.showOptionDialog(this, "El producto no existe", "Error Producto",
                    JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "}, "Cancelar");
        } else {
            this.jDialog_ModificarProducto.setSize(430, 400);
            JPanel_Inventario mPanel = JPanel_Inventario.getInstance();
            this.jDialog_ModificarProducto.setLocation(mPanel.getLocation());
            this.jDialog_ModificarProducto.setVisible(true);
            this.jTextField_nombre1.setText(data[0][0].toString());
            this.jTextField_Precio1.setText(data[0][1].toString());
            this.jTextField_Costo.setText(data[0][2].toString());
            String NombreCategoria = mBD.consultarNombreCategoriaXid(Integer.parseInt(data[0][3].toString()));
            if (data[0][4] != null) {
                this.jTextField_Descripcion.setText(data[0][4].toString());
            }
            this.jTextField_Descripcion.setText("No tiene descripcion");
            this.jTextField_CodigoProducto.setText(data[0][5].toString());
            this.jTextField_CodigoProducto.disable();

            mBD.consultarCategorias();

            columnNames = mBD.getColumnNames();
            data = mBD.getData();

            this.jComboBox_Categorias.removeAllItems();
            for (int i = 0; i < data.length; i++) {
                this.jComboBox_Categorias.addItem(data[i][1]);
            }

            this.jComboBox_Categorias.setSelectedItem(NombreCategoria);
    }//GEN-LAST:event_jButton1ActionPerformed
    }
    private void jButton_CrearCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearCategoriaActionPerformed
       this.jDialog_CrearCategoria.setSize(220,120);
       this.jDialog_CrearCategoria.setTitle("Crear Categoria");
       this.jDialog_CrearCategoria.setVisible(true);
       
       
       
    }//GEN-LAST:event_jButton_CrearCategoriaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Direct_Control_BD mBD= Direct_Control_BD.getInstance();
        mBD.insertarCategoria(this.jTextField_NombreCategoria.getText());
        this.jDialog_CrearCategoria.dispose();
        
      
       mBD.consultarCategorias();
       
       String[] columnNames = mBD.getColumnNames();
       Object[][] data = mBD.getData();
       
      
       
       this.jComboBox_Categorias.removeAllItems();
       for(int i=0; i<data.length; i++){
             this.jComboBox_Categorias.addItem(data[i][1]);
       }
       this.jComboBox_Categorias.setSelectedItem(this.jTextField_NombreCategoria.getText());
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       this.jDialog_ConfirmacionVerProducto.setSize(200,100);
       JPanel_Inventario mPanel= JPanel_Inventario.getInstance();
       this.jDialog_ConfirmacionVerProducto.setLocation(mPanel.getLocation());
       this.jDialog_ConfirmacionVerProducto.setVisible(true); 
       
       
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jTextField_IdProductoModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_IdProductoModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_IdProductoModificar1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        
        this.jDialog_ConfirmacionVerProducto.dispose();
        
       
       Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       mBD.consultarProducto(this.jTextField_IdProductoModificar1.getText());
       String[] columnNames = mBD.getColumnNames();
       Object[][] data = mBD.getData();
       
       if(data.length==0){
           JOptionPane.showOptionDialog(this, "El producto no existe", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar"); 
       }
       else{
           
       this.jDialog_VerProducto.setSize(430,400);
       JPanel_Inventario mPanel= JPanel_Inventario.getInstance();
       this.jDialog_VerProducto.setLocation(mPanel.getLocation());
       this.jDialog_VerProducto.setVisible(true); 
       
       this.jTextField_nombreVerProducto.setText(data[0][0].toString());
       this.jTextField_nombreVerProducto.disable();
       this.jTextField_PrecioVerProducto.setText(data[0][1].toString());
       this.jTextField_PrecioVerProducto.disable();
       this.jTextField_CostoVerProducto.setText(data[0][2].toString());
       this.jTextField_CostoVerProducto.disable();
       
       String NombreCategoria = mBD.consultarNombreCategoriaXid(Integer.parseInt(data[0][3].toString()));
       this.jTextField_DescripcionVerProducto.setText(data[0][4].toString());
       this.jTextField_DescripcionVerProducto.disable();
       this.jTextField_CodigoVerProducto.setText(data[0][5].toString());
       this.jTextField_CodigoVerProducto.disable();
       
       this.jTextField_CategoriaVerProducto.setText(NombreCategoria);
       this.jTextField_CategoriaVerProducto.disable();
       
       
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonEntrarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarMovimientosActionPerformed
        
        VentanaDeInicio mVentana= VentanaDeInicio.getInstance();
        
        mVentana.setTitle("Movimientos");
        mVentana.add(this.jPanel_Movimientos);
        this.jPanel_Movimientos.setVisible(true);
        this.jPanel_Movimientos.setSize(this.getSize());
        this.jPanel_Movimientos.setLocation(this.getLocation());
        mVentana.remove(this);
        mVentana.revalidate();
        mVentana.repaint();
        colocarMovimientos();
        
    }//GEN-LAST:event_jButtonEntrarMovimientosActionPerformed

    private void jButton_RegresarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegresarMovimientosActionPerformed
      
        
    }//GEN-LAST:event_jButton_RegresarMovimientosActionPerformed

    private void jButton_RecibirMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RecibirMovimientosActionPerformed

       this.jDialog_RecibirProductoMovimientos.setVisible(true);
       this.jDialog_RecibirProductoMovimientos.setSize(265,230);
       this.jDialog_RecibirProductoMovimientos.setLocation(this.getLocation());
       Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       mBD.verLugares();
       
       String[] columnNames = mBD.getColumnNames();
       Object[][] data = mBD.getData();
       
       if(data.length==0)
       {
           
       }
       else{
       this.jComboBox_LugarMovimientos.removeAllItems();
       for(int i=0; i<data.length; i++)
       {
             this.jComboBox_LugarMovimientos.addItem(data[i][0]);
       }
       
       }
    }//GEN-LAST:event_jButton_RecibirMovimientosActionPerformed

    private void jButton_CrearMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearMovimientoActionPerformed
        Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       try{
        String CodigoProducto=this.jTextField_CodigoProductoMovimiento.getText();
        int Cantidad=Integer.parseInt(this.jTextField_CantidadMovimientos.getText());
        String Detalle= this.jTextField_DetalleMovimientos.getText();
        String Lugar= this.jComboBox_LugarMovimientos.getSelectedItem().toString();
        Date mDate= new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        mBD.consultarProducto(CodigoProducto);
        
        Object[][] data = mBD.getData();
         
         if(data.length==0)
         {
             JOptionPane.showOptionDialog(this, "El producto no existe", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar"); 
         }
         else
         {
        int CantidadEnInventario = mBD.consultarCantidadDeunProducto(CodigoProducto);
        int idLugarMovimiento= mBD.consultarIdLugarXNombre(Lugar);
        //(String Fecha, String Detalle, int idTipoMovimiento,
        //int CantidadMovida, int Balance, 
        //String idProductoMovimiento,int idLugarMovimiento)
        
        mBD.insertarmovimiento(dateFormat.format(mDate), Detalle,
                2, Cantidad,Cantidad+CantidadEnInventario , 
               CodigoProducto,idLugarMovimiento );
        mBD.actualizarCantidadProductoInventario(Cantidad+CantidadEnInventario, CodigoProducto, idLugarMovimiento);
        
        this.jDialog_RecibirProductoMovimientos.dispose();
        colocarMovimientos();
         }
       }
       catch (NumberFormatException exc) 
         { 
             JOptionPane.showOptionDialog(this, "Verificar datos", "Error Movimiento", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar");
         }
    }//GEN-LAST:event_jButton_CrearMovimientoActionPerformed

    private void jButton_CrearMovimiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CrearMovimiento1ActionPerformed
        Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       try{
        String CodigoProducto=this.jTextField_CodigoProductoMovimiento1.getText();
        int Cantidad=Integer.parseInt(this.jTextField_CantidadMovimientos1.getText());
        String Detalle= this.jTextField_DetalleMovimientos1.getText();
        String Lugar= this.jComboBox_LugarMovimientos1.getSelectedItem().toString();
        Date mDate= new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        mBD.consultarProducto(CodigoProducto);
        
        Object[][] data = mBD.getData();
         
         if(data.length==0)
         {
             JOptionPane.showOptionDialog(this, "El producto no existe", "Error Producto", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar"); 
         }
         else
         {
        int CantidadEnInventario = mBD.consultarCantidadDeunProducto(CodigoProducto);
        int idLugarMovimiento= mBD.consultarIdLugarXNombre(Lugar);
        //(String Fecha, String Detalle, int idTipoMovimiento,
        //int CantidadMovida, int Balance, 
        //String idProductoMovimiento,int idLugarMovimiento)
        
        mBD.insertarmovimiento(dateFormat.format(mDate), Detalle,
                1, Cantidad,CantidadEnInventario-Cantidad , 
               CodigoProducto,idLugarMovimiento );
        mBD.actualizarCantidadProductoInventario(CantidadEnInventario-Cantidad, CodigoProducto, idLugarMovimiento);
        this.jDialog_RetirarProductoMovimientos.dispose();
        colocarMovimientos();
         }
       }
       catch (NumberFormatException exc) 
         { 
             JOptionPane.showOptionDialog(this, "Verificar datos", "Error Movimiento", 
           JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE, null, new Object[]{" Cancelar "},"Cancelar");
         }
    }//GEN-LAST:event_jButton_CrearMovimiento1ActionPerformed

    private void jButton_RetirarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RetirarMovimientosActionPerformed
       this.jDialog_RetirarProductoMovimientos.setVisible(true);
       this.jDialog_RetirarProductoMovimientos.setSize(265,230);
       this.jDialog_RetirarProductoMovimientos.setLocation(this.getLocation());
       Direct_Control_BD mBD= Direct_Control_BD.getInstance();
       mBD.verLugares();
       
       String[] columnNames = mBD.getColumnNames();
       Object[][] data = mBD.getData();
       
       if(data.length==0)
       {
           
       }
       else{
       this.jComboBox_LugarMovimientos1.removeAllItems();
       for(int i=0; i<data.length; i++)
       {
             this.jComboBox_LugarMovimientos1.addItem(data[i][0]);
       }
       
       }
    }//GEN-LAST:event_jButton_RetirarMovimientosActionPerformed

    private void jTextField_PrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PrecioKeyTyped
        int tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_COMMA){
            return;
        }
        if(tecla==KeyEvent.VK_PERIOD){
            return;
        }
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
      int limite=13;
      if (jTextField_Precio.getText().length()== limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_Precio.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_PrecioKeyTyped

    private void jTextField_CostoCrearProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CostoCrearProductoKeyTyped
        int tecla= evt.getKeyChar();
        
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
        
        int limite=9;
      if (jTextField_CostoCrearProducto.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_CostoCrearProducto.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_CostoCrearProductoKeyTyped

    private void jTextField_CantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadKeyTyped
        int tecla= evt.getKeyChar();
        
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
        
        int limite=9;
      if (jTextField_Cantidad.getText().length()== limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_Cantidad.transferFocus();
            
        
        }
       
        
    }//GEN-LAST:event_jTextField_CantidadKeyTyped

    private void jTextField_PrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_PrecioKeyPressed
        if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_PrecioKeyPressed

    private void jTextField_CantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadKeyPressed
        if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_CantidadKeyPressed

    private void jTextField_CostoCrearProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CostoCrearProductoKeyPressed
        if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_CostoCrearProductoKeyPressed

    private void jTextField_Precio1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Precio1KeyPressed
       if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_Precio1KeyPressed

    private void jDialog_ModificarProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDialog_ModificarProductoKeyPressed
        
    }//GEN-LAST:event_jDialog_ModificarProductoKeyPressed

    private void jTextField_CostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CostoKeyTyped
        int tecla= evt.getKeyChar();
        
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
        int limite=9;
      if (jTextField_Costo.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_Costo.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_CostoKeyTyped

    private void jTextField_Precio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Precio1KeyTyped
        int tecla= evt.getKeyChar();
        if(tecla==KeyEvent.VK_COMMA){
            return;
        }
        if(tecla==KeyEvent.VK_PERIOD){
            return;
        }
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
        int limite=9;
      if (jTextField_Precio1.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_Precio1.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_Precio1KeyTyped

    private void jTextField_CostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CostoKeyPressed
        if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_CostoKeyPressed

    private void jTextField_CantidadMovimientos1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadMovimientos1KeyPressed
       if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_CantidadMovimientos1KeyPressed

    private void jTextField_CantidadMovimientos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadMovimientos1KeyTyped
        int tecla= evt.getKeyChar();
        
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
        
        if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_CantidadMovimientos1.transferFocus();
            
        
        }
        
        
    }//GEN-LAST:event_jTextField_CantidadMovimientos1KeyTyped

    private void jTextField_CantidadMovimientosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadMovimientosKeyPressed
       if(evt.isControlDown()){
        evt.consume();}
    }//GEN-LAST:event_jTextField_CantidadMovimientosKeyPressed

    private void jTextField_CantidadMovimientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CantidadMovimientosKeyTyped
        int tecla= evt.getKeyChar();
       
        if (!Character.isDigit(tecla) & !Character.isISOControl(evt.getKeyChar())) {
            Toolkit.getDefaultToolkit().beep();
            evt.consume();

        }
        if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_CantidadMovimientos.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_CantidadMovimientosKeyTyped

    private void jTextField_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_codigoKeyTyped
       int limite=30;
           if (jTextField_codigo.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
     
               
           }
       if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_codigo.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_codigoKeyTyped

    private void jTextField_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nombreKeyTyped
        int limite=30;
           if (jTextField_nombre.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
               
           }
           if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_nombre.transferFocus();
            
        
        }
           
    }//GEN-LAST:event_jTextField_nombreKeyTyped

    private void jTextArea_DescripcionCrearProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_DescripcionCrearProductoKeyTyped
        int limite=30;
        System.out.println(jTextArea_DescripcionCrearProducto.getText().length());
      if (jTextArea_DescripcionCrearProducto.getText().length()>=limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextArea_DescripcionCrearProducto.transferFocus();
            
        
        }
      
    }//GEN-LAST:event_jTextArea_DescripcionCrearProductoKeyTyped

    private void jTextField_CodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoProductoKeyTyped
       int limite=30;
        
      if (jTextField_CodigoProducto.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_CodigoProducto.transferFocus();
            
        
        }
      
    }//GEN-LAST:event_jTextField_CodigoProductoKeyTyped

    private void jTextField_nombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nombre1KeyTyped
        int limite=30;
      if (jTextField_nombre1.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_nombre1.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_nombre1KeyTyped

    private void jTextField_DescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescripcionKeyTyped
        int limite=30;
      if (jTextField_Descripcion.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
      if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jTextField_Descripcion.transferFocus();
            
        
        }
    }//GEN-LAST:event_jTextField_DescripcionKeyTyped

    private void jTextField_DescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescripcionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DescripcionKeyPressed

    private void jComboBox_CategoriaCrearProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox_CategoriaCrearProductoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_CategoriaCrearProductoFocusGained

    private void jComboBox_CategoriaCrearProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_CategoriaCrearProductoKeyTyped
       if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jComboBox_CategoriaCrearProducto.transferFocus();
            
        
        }
    }//GEN-LAST:event_jComboBox_CategoriaCrearProductoKeyTyped

    private void jComboBox_CategoriasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_CategoriasKeyTyped
        if(KeyEvent.VK_ENTER==evt.getKeyChar()){
            this.jComboBox_Categorias.transferFocus();
            
        
        }
    }//GEN-LAST:event_jComboBox_CategoriasKeyTyped

    private void jButton_CrearCategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton_CrearCategoriaFocusGained
     
            this.jButton_CrearCategoria.transferFocus();
            
        
        
    }//GEN-LAST:event_jButton_CrearCategoriaFocusGained

    private void jTextField_CodigoProductoMovimiento1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoProductoMovimiento1KeyTyped
        if(KeyEvent.VK_ENTER==evt.getKeyChar())
        {
            this.jTextField_CodigoProductoMovimiento1.transferFocus();
        }
      int limite=30;
      if (jTextField_CodigoProductoMovimiento1.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
    }//GEN-LAST:event_jTextField_CodigoProductoMovimiento1KeyTyped

    private void jButton5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton5FocusGained
     
            this.jButton5.transferFocus();
            
        
        
    }//GEN-LAST:event_jButton5FocusGained

    private void jTextField_DetalleMovimientos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DetalleMovimientos1KeyTyped
       if(KeyEvent.VK_ENTER==evt.getKeyChar())
       {
            this.jTextField_DetalleMovimientos1.transferFocus();
        }
       int limite=30;
      if (jTextField_DetalleMovimientos1.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
    }//GEN-LAST:event_jTextField_DetalleMovimientos1KeyTyped

    private void jComboBox_LugarMovimientos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_LugarMovimientos1KeyTyped
        if(KeyEvent.VK_ENTER==evt.getKeyChar())
       {
            this.jComboBox_LugarMovimientos1.transferFocus();
        }
    }//GEN-LAST:event_jComboBox_LugarMovimientos1KeyTyped

    private void jTextField_CodigoProductoMovimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoProductoMovimientoKeyTyped
        if(KeyEvent.VK_ENTER==evt.getKeyChar())
        {
            this.jTextField_CodigoProductoMovimiento.transferFocus();
        }
      int limite=30;
      if (jTextField_CodigoProductoMovimiento.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
    }//GEN-LAST:event_jTextField_CodigoProductoMovimientoKeyTyped

    private void jButton4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusGained
       this.jButton4.transferFocus();
    }//GEN-LAST:event_jButton4FocusGained

    private void jTextField_DetalleMovimientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DetalleMovimientosKeyTyped
      if(KeyEvent.VK_ENTER==evt.getKeyChar())
       {
            this.jTextField_DetalleMovimientos.transferFocus();
        }
       int limite=30;
      if (jTextField_DetalleMovimientos.getText().length()>= limite)
           {
     evt.consume();
     Toolkit.getDefaultToolkit().beep();
           }
    }//GEN-LAST:event_jTextField_DetalleMovimientosKeyTyped

    private void jComboBox_LugarMovimientosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox_LugarMovimientosKeyTyped
        if(KeyEvent.VK_ENTER==evt.getKeyChar())
       {
            this.jComboBox_LugarMovimientos.transferFocus();
        }
    }//GEN-LAST:event_jComboBox_LugarMovimientosKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonEntrarMovimientos;
    private javax.swing.JButton jButtonRegresarInventario;
    private javax.swing.JButton jButton_CrearCategoria;
    private javax.swing.JButton jButton_CrearMovimiento;
    private javax.swing.JButton jButton_CrearMovimiento1;
    private javax.swing.JButton jButton_CrearProducto;
    private javax.swing.JButton jButton_CrearProducto1;
    private javax.swing.JButton jButton_CrearProductoInventario;
    private javax.swing.JButton jButton_EliminarProducto;
    private javax.swing.JButton jButton_EliminarProductoInventario;
    private javax.swing.JButton jButton_ModificarMovimientos;
    private javax.swing.JButton jButton_ModificarProducto;
    private javax.swing.JButton jButton_RecibirMovimientos;
    private javax.swing.JButton jButton_RegresarMovimientos;
    private javax.swing.JButton jButton_RetirarMovimientos;
    private javax.swing.JComboBox jComboBox_CategoriaCrearProducto;
    private javax.swing.JComboBox jComboBox_Categorias;
    private javax.swing.JComboBox jComboBox_LugarMovimientos;
    private javax.swing.JComboBox jComboBox_LugarMovimientos1;
    private javax.swing.JDialog jDialog_ConfirmacionModificacionProducto;
    private javax.swing.JDialog jDialog_ConfirmacionVerProducto;
    private javax.swing.JDialog jDialog_CrearCategoria;
    private javax.swing.JDialog jDialog_CrearProducto;
    private javax.swing.JDialog jDialog_EliminarProducto;
    private javax.swing.JDialog jDialog_ModificarProducto;
    private javax.swing.JDialog jDialog_RecibirProductoMovimientos;
    private javax.swing.JDialog jDialog_RetirarProductoMovimientos;
    private javax.swing.JDialog jDialog_VerProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Codigo;
    private javax.swing.JLabel jLabel_Codigo2;
    private javax.swing.JLabel jLabel_Costo;
    private javax.swing.JLabel jLabel_Costo2;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Nombre2;
    private javax.swing.JLabel jLabel_Precio;
    private javax.swing.JLabel jLabel_Precio2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel_Movimientos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable_Inventario;
    private javax.swing.JTable jTable_Movimientos;
    private javax.swing.JTextArea jTextArea_DescripcionCrearProducto;
    private javax.swing.JTextField jTextField_Cantidad;
    private javax.swing.JTextField jTextField_CantidadMovimientos;
    private javax.swing.JTextField jTextField_CantidadMovimientos1;
    private javax.swing.JTextField jTextField_CategoriaVerProducto;
    private javax.swing.JTextField jTextField_CodigoProducto;
    private javax.swing.JTextField jTextField_CodigoProductoMovimiento;
    private javax.swing.JTextField jTextField_CodigoProductoMovimiento1;
    private javax.swing.JTextField jTextField_CodigoVerProducto;
    private javax.swing.JTextField jTextField_Costo;
    private javax.swing.JTextField jTextField_CostoCrearProducto;
    private javax.swing.JTextField jTextField_CostoVerProducto;
    private javax.swing.JTextArea jTextField_Descripcion;
    private javax.swing.JTextField jTextField_DescripcionVerProducto;
    private javax.swing.JTextField jTextField_DetalleMovimientos;
    private javax.swing.JTextField jTextField_DetalleMovimientos1;
    private javax.swing.JTextField jTextField_IdProducto;
    private javax.swing.JTextField jTextField_IdProductoModificar;
    private javax.swing.JTextField jTextField_IdProductoModificar1;
    private javax.swing.JTextField jTextField_NombreCategoria;
    private javax.swing.JTextField jTextField_Precio;
    private javax.swing.JTextField jTextField_Precio1;
    private javax.swing.JTextField jTextField_PrecioVerProducto;
    private javax.swing.JTextField jTextField_codigo;
    private javax.swing.JTextField jTextField_nombre;
    private javax.swing.JTextField jTextField_nombre1;
    private javax.swing.JTextField jTextField_nombreVerProducto;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
