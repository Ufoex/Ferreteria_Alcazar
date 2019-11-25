/*
 constructor getters y setters
 */
package modelo;

/**
 *
 * @author denis
 */
public class ModeloCompras {
   private int IdCompras;
   private float precioUnitario;
   private float cantidad;
   private String Fecha;
   private float total;
   //constructor vacio

    public ModeloCompras() {
    }
   //constructor con todos los campos

    public ModeloCompras(int IdCompras, float precioUnitario, float cantidad, String Fecha, float total) {
        this.IdCompras = IdCompras;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.Fecha = Fecha;
        this.total = total;
    }

    public int getIdCompras() {
        return IdCompras;
    }

    public void setIdCompras(int IdCompras) {
        this.IdCompras = IdCompras;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
