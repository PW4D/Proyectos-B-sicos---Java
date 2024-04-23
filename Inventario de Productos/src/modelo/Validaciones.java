package modelo;

import java.sql.*;
import java.util.Scanner;

import static modelo.Registros.connection;

public class Validaciones {
    //Método productExist que pasa por parametro un Entero id_producto, el cual ejecuta una query SQL que devuelve si el producto existe
    public static boolean productExists(int id_producto) {

        String sql = "SELECT * FROM productos WHERE id_producto=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        boolean validacion = false;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_producto);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int registro = resultSet.getInt(1);
                if (registro > 0) {
                    System.err.println("El ID del Producto ya esta registrado, inténtelo de nuevo");
                    validacion = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return validacion;
    }
    //Método productNoExist que pasa por parametro un Entero id_producto, el cual ejecuta una query SQL que devuelve si el producto no existe
    public static boolean productNoExists(int id_producto) {

        String sql = "SELECT * FROM productos WHERE id_producto=?";
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        boolean validacion = false;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_producto);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int registro = resultSet.getInt(1);
                if (registro <= 0) {
                    System.err.println("El ID del Producto no esta registrado, inténtelo de nuevo");
                    validacion = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return validacion;
    }
    //Método isInteger, el cual verifica si el dato introducido es numérico
    public static int isInteger() {
        Scanner scanner = new Scanner(System.in);
        int num;

        while (!scanner.hasNextInt()) {
            System.err.println("El dato o caracter introducido no es numérico, vuelva a intentarlo");
            System.out.print(": ");
            scanner.nextLine();
        }

        num = scanner.nextInt();
        return num;
    }
    //Método isDouble, el cual verifica si el dato introducido es numérico o de tipo Double
    public static double isDouble() {
        Scanner scanner = new Scanner(System.in);
        double num;

        while (!scanner.hasNextDouble()) {
            System.err.println("El dato o caracter introducido no es numérico, vuelva a intentarlo");
            System.out.print(": ");
            scanner.nextLine();
        }

        num = scanner.nextDouble();
        return num;
    }
    //Método isString, el cual verifica si el dato introducido es cadena de texto
    public static boolean isString(String string) {
        boolean resultado = false;

        for (int i = 0; i < string.length(); i++) {
            char caracter = string.charAt(i);

            if ((caracter >= 'a' && caracter <= 'z') || (caracter >= 'A' && caracter <= 'Z')) {
                resultado = true;
            } else if ((caracter == 'á') || (caracter == 'é') || (caracter == 'í') || (caracter == 'ó') || (caracter== 'ú')) {
                resultado = true;
            } else if ((caracter == 'Á') || (caracter == 'É') || (caracter == 'Í') || (caracter == 'Ó') || (caracter== 'Ú')) {
                resultado = true;
            } else if (caracter == ' ') {
                resultado = true;
            } else if ((caracter == 'ñ') || (caracter == 'Ñ')) {
                resultado = true;
            } else {
                resultado = false;
                System.err.println("El dato introducido no coincide con el formato que se pide, vuelve a intentarlo");
            }
        }
        return resultado;
    }
}
