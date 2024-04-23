package modelo;

//Modelo de tabla de la base de datos, representado en una clase
public class Producto {
    private int id_producto;
    private String nombre_producto;
    private int cantidad;
    private double precio;
    private String categoria;

    public Producto() {}

    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int idProducto) {
        this.id_producto = idProducto;
    }
    public String getNombre_producto() {
        return nombre_producto;
    }
    public void setNombre_producto(String nombreProducto) {
        this.nombre_producto = nombreProducto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}