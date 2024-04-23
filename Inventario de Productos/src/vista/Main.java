package vista;

import controlador.Funcionamiento;
import modelo.Registros;

import static modelo.Validaciones.isInteger;

public class Main {
    public static void main(String[] args) {
        Funcionamiento productos = new Funcionamiento();
        Registros registros = new Registros();
        int opcion;

        //Vista de los datos pedidos desde la consola/terminal, el cual utiliza los métodos de la clase Funcionamiento
        do {
            System.out.println("\nSISTEMA DE INVENTARIO DE PRODUCTOS");

            System.out.print("1. Registro de Producto \n2. Busquedá de Producto \n3. Resumen de inventario actual \n4. Eliminar un Producto \n5. Salir \nIntroduce una opción: \n");
            opcion = isInteger();

            switch (opcion) {
                case 1:
                    productos.registrarProducto();
                    break;
                case 2:
                    productos.consultarProducto();
                    break;
                case 3:
                    registros.ordenar();
                    break;
                case 4:
                    productos.eliminarProducto();
                    break;
            }

        } while (opcion != 5);

    }
}
