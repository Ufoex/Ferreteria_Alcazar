/*
Constructos, getters y setters 
 */
package modelo;

/**
 *
 * @author Partida Castañeda
 */
public class ModeloVentas {
      public int idcodigo;
    public String Fecha;
    public  int cantidad;
    public float precio;
    public float total;
    //constructor vacio

    public ModeloVentas() {
    }
    //contructor con campos necesarios

    public ModeloVentas(int idcodigo, String Fecha, int cantidad, float precio, float total) {
        this.idcodigo = idcodigo;
        this.Fecha = Fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }
    //getters y setters 

    public int getIdcodigo() {
        return idcodigo;
    }

    public void setIdcodigo(int idcodigo) {
        this.idcodigo = idcodigo;
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
    
    
    
}
