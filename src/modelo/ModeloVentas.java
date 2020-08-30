/*
Constructos, getters y setters 
 */
package modelo;


public class ModeloVentas {
    private int IdVentas;
    private String Fecha;
    private int cantidad;
    private float precio;
    private float total;
    private int IdProducto;
    //constructor vacio

    public ModeloVentas() {
    }
    //contructor con campos necesarios
    public ModeloVentas(int IdVentas, String Fecha, int cantidad, float precio, float total, int IdProducto) {
        this.IdVentas = IdVentas;
        this.Fecha = Fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
        this.IdProducto = IdProducto;
    }
    //getters y setters 

    public int getIdVentas() {

        return IdVentas;
    }

    public void setIdVentas(int IdVentas) {

        this.IdVentas = IdVentas;
    }

    public String getFecha() {

        return Fecha;
    }

    public void setFecha(String Fecha) {

        this.Fecha = Fecha;
    }

    public int getCantidad() {

        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {

        return precio;
    }

    public void setPrecio(float precio) {

        this.precio = precio;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {

        this.total = total;
    }

    public int getIdProducto() {

        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {

        this.IdProducto = IdProducto;
    }
    

    
}
