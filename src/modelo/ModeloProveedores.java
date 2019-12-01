package modelo;

public class ModeloProveedores {
    private int IdProveedor;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rfc;
    private int telefono;
    private String mail;
    private String estado;
    private String ciudad;
    private int codigoPostal;
    private String colonia;
    private String calle;
    private int numero;

    public ModeloProveedores(){

    }

    public ModeloProveedores(int idProveedor, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, int telefono, String mail, String estado, String ciudad, int codigoPostal, String colonia, String calle, int numero) {
        IdProveedor = idProveedor;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.mail = mail;
        this.estado = estado;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        IdProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
