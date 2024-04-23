package modelo;

import java.sql.*;

public class Conexion {
    //Método para conectar a la Base de datos
    public static Connection getConnection() {

        Connection conexion;
        String host = "jdbc:mysql://localhost:3306/";
        String database = "inventario";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(host + database, user, pass);
            System.err.println("Conexión establecida...\n");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conexion;
    }
}