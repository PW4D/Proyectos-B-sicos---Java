package modelo;

import java.sql.*;

public class Registros extends Conexion {
    //Variable final static de tipo Connection para la reutilización en futuras clases, el cual no cambie su valor
    public final static Connection connection = getConnection();

    //Método registrar que pasa por paramétro un objeto Producto, el cual ejecuta una query SQL para insertar los datos en la base de datos
    public boolean registrar(Producto producto) {

        String sql = "INSERT INTO productos(id_producto, nombre, cantidad, precio, categoria) VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, producto.getId_producto());
            preparedStatement.setString(2, producto.getNombre_producto());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setString(5, producto.getCategoria());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //Método consulta que pasa por paramétro un objeto Producto, el cual ejecuta una query SQL para buscar/consultar datos en la base de datos
    public boolean consulta(Producto producto) {

        String sql = "SELECT * FROM productos WHERE id_producto=? OR nombre=? OR precio=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        boolean busqueda = false;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, producto.getId_producto());
            preparedStatement.setString(2, producto.getNombre_producto());
            preparedStatement.setDouble(3, producto.getPrecio());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_producto = resultSet.getInt("id_producto");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");

                System.err.println("\nID Producto: " + id_producto + " \nNombre: " + nombre + " \nPrecio: " + precio + "\n");

                busqueda = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return busqueda;
    }
    //Método ordenar, el cual ejecuta una query SQL para ordenar por categoria los productos en la base de datos
    public boolean ordenar() {

        String sql = "SELECT * FROM productos ORDER BY categoria";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        boolean producto = false;

        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String categoria = resultSet.getString("categoria");
                int id_producto = resultSet.getInt("id_producto");
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                double precio = resultSet.getDouble("precio");

                System.err.println("\nCategoria: " + categoria + " \nID Producto: " + id_producto + " \nNombre: " + nombre + " \nCantidad: " + cantidad + " \nPrecio: " + precio + "\n");

                producto = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }
    //Método eliminar que pasa por paramétro un objeto Producto, el cual ejecuta una query SQL para eliminar datos en la base de datos
    public boolean eliminar(Producto producto) {

        String sql = "DELETE FROM productos WHERE id_producto=?";
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, producto.getId_producto());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}