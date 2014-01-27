/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_managment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Monicaticooo
 */
/**
 * Establece la conexion con la base de datos
 */
public final class Setting_Up_BD {

    /**
     * Parametros de conexion
     */
    private String driver = "com.mysql.jdbc.Driver";
    private String database = "jdbc:mysql://localhost:3306/monicatico";
    private String user = "root";
    private String pass = "123456";
    private Connection conection;
    private Statement statement;
    DateFormat dateFormat = new SimpleDateFormat("EEEE");//formato fecha act

    /**
     * Intenta la conexion a la Base de Datos
     */
    public Setting_Up_BD() {
        try {
            Class.forName(driver);
            this.setConection(DriverManager.getConnection(database, user, pass));
            this.setStatement(conection.createStatement());
        } catch (Exception e) {
            System.out.println("Error al recuperar conexion "
                    + e.toString());
            JOptionPane.showMessageDialog(null,
                    "No se pudo conectar a la base de datos.");

        }
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the conection
     */
    public Connection getConection() {
        return conection;
    }

    /**
     * @param conection the conection to set
     */
    public void setConection(Connection conection) {
        this.conection = conection;
    }

    /**
     * Generar un respaldo de la base
     */
    void generarRespaldoMySQL() {
        try {
            Date date = new Date();
            String fechaAct = dateFormat.format(date);
            Runtime runtime = Runtime.getRuntime();
            //Nombre y lugar donde se guarda el respaldo
            File backupFile = new File(String.valueOf("C:/Users/Jason/Desktop/"
                    + fechaAct) + ".sql");
            FileWriter fw = new FileWriter(backupFile);
            //Cargar informacion de la base
            Process child = runtime.exec("C:\\Archivos de programa\\MySQL\\MySQL "
                    + "Server 5.6\\bin\\mysqldump --opt --password=123456"
                    + " --user=root "
                    + "--databases monicatico -R");
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);

            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error no se genero el archivo "
                    + "por el siguiente motivo:" + e.getMessage(), "Verificar",
                    JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Archivogenerado", "Verificar",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
