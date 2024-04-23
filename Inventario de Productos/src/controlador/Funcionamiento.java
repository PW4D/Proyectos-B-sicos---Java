package controlador;

import modelo.Producto;
import modelo.Registros;

import java.util.Scanner;

import static modelo.Validaciones.*;

public class Funcionamiento {
    //Clases instanciadas Producto y Registros, para el uso de sus métodos internos
    private final Producto producto = new Producto();
    private final Registros registros = new Registros();

    //Método registrarProducto, el cual pide los datos por consola/terminal utilizando el método registrar(Producto producto) de la clase Registros
    public void registrarProducto() {
        Scanner scanner = new Scanner(System.in);

        int id_producto;
        String nombre;
        int cantidad;
        double precio;
        String categoria;

        do {
            System.err.println("\nREGISTRAR EL PRODUCTO");
            System.out.println("Introduce el ID del Producto: ");
            id_producto = isInteger();

            System.out.println("Introduce el nombre: ");
            nombre = scanner.nextLine();

            System.out.println("Introduce la cantidad: ");
            cantidad = isInteger();

            System.out.println("Introduce el precio: ");
            precio = isDouble();

            System.out.println("Introduce la categoria: ");
            categoria = scanner.nextLine();
            isString(categoria);

        } while (productExists(id_producto));

        producto.setId_producto(id_producto);
        producto.setNombre_producto(nombre);
        producto.setCantidad(cantidad);
        producto.setPrecio(precio);
        producto.setCategoria(categoria);

        if (registros.registrar(producto)) {
            System.err.println("Se registro el producto éxitosamente");
        } else {
            System.err.println("Falló al registrar el producto");
        }
    }
    /*
    * Método consultarProducto, el cual pide los datos por consola/terminal utilizando el método consultar(Producto producto) de la clase Registros.
    * De acuerdo al tipo de consulta/busquedá que desee el usuario realizar (ID del Producto, Nombre del Producto o Precio del Producto)
    * */
    public void consultarProducto() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int id_producto;
        String nombre;
        double precio;

        do {
            System.err.println("\nBUSQUEDÁ DEL PRODUCTO");
            System.out.print("- Tipo de Busquedá - \n1. ID del Producto \n2. Nombre del Producto \n3. Precio del Producto \n4. Salir del Apartado de Busquedá \nIntroduce una opción: ");
            opcion = isInteger();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Introduce el ID del Producto: ");
                        id_producto = isInteger();

                    } while (productNoExists(id_producto));

                    producto.setId_producto(id_producto);
                    registros.consulta(producto);

                    break;
                case 2:
                    System.out.println("Introduce el nombre: ");
                    nombre = scanner.nextLine();

                    producto.setNombre_producto(nombre);
                    registros.consulta(producto);

                    break;
                case 3:
                    System.out.println("Introduce el precio: ");
                    precio = isDouble();

                    producto.setPrecio(precio);
                    registros.consulta(producto);

                    break;
            }

        } while (opcion != 4);
    }
    //Método eliminarProducto, el cual pide los datos por consola/terminal utilizando el método eliminar(Producto producto) de la clase Registros
    public void eliminarProducto() {
        int id_producto;

        do {
            System.err.println("\nELIMINAR UN PRODUCTO");
            System.out.println("Introduce el ID del Producto: ");
            id_producto = isInteger();

        } while (productNoExists(id_producto));

        producto.setId_producto(id_producto);

        if (registros.eliminar(producto)) {
            System.err.println("Se eliminó el producto satisfactoriamente");
        } else {
            System.err.println("Falló al eliminar el producto");
        }
    }
}