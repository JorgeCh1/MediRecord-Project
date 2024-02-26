/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorch
 */
public class Conexion {
    private static final String SERVIDOR = ".";
    private static final String USUARIO = "sa ";
    private static final String PW = "1234";
    private static final String NOMBREBD = "RTaller";
    private static final String PUERTO = "1433";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection getConexion() {
        try {
            String connectionUrl = "jdbc:sqlserver://" + SERVIDOR + ": " + PUERTO
                    + "; Databasename= " + NOMBREBD + "; user= " + USUARIO
                    + "; password = " + PW + ";";
            Class.forName(DRIVER);
            return (DriverManager.getConnection(connectionUrl));
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);   
        }
        return null;
    }
    
    public void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    } 
}
