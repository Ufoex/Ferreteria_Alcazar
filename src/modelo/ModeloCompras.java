/*
 constructor getters y setters
 */
package modelo;

/**
 *
 * @author denis
 */
public class ModeloCompras {
   public int IdCompras;
   public float precioUnitario;
   public float cantidad;
   public String Fecha;
   public double total;
   //constructor vacio

    public ModeloCompras() {
    }
   //constructor con todos los campos

    public ModeloCompras(int IdCompras, float precioUnitario, float cantidad, String Fecha, double total) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
