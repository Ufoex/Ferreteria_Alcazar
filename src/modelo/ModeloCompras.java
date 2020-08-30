/*
 constructor getters y setters
 */
package modelo;


public class ModeloCompras {
    private int IdCompras;
    private float precioUnitario;
    private int cantidad;
    private String Fecha;
    private float total;

    private int idproducto;
    private String productoNombre;
    //constructor vacio

    public ModeloCompras() {
    }
    //constructor con todos los campos

    public ModeloCompras(int IdCompras, float precioUnitario, int cantidad, String Fecha, float total, int idproducto, String productoNombre) {
        this.IdCompras = IdCompras;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.Fecha = Fecha;
        this.total = total;
        this.idproducto = idproducto;
        this.productoNombre = productoNombre;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

}
