/*

 */
package modelo;

/**
 *
 * @author miria
 */
public class ModeloProductos {
    private int idProductos;
    private String nombre;
    private String marca;
    private float precioUnitario;
    private int stock;
    private String categoria;
    //Cosntructor vacio
    public ModeloProductos() {
    }
    //Constructor con todos los campos
    public ModeloProductos(int idProductos, String nombre, String marca, float precioUnitario, int stock, String categoria) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.categoria = categoria;
    }

    //Getters y Setters


    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
