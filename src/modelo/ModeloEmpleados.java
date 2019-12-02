package modelo;

public class ModeloEmpleados {
    private int IdEmpleado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rfc;
    private int telefono;
    private String sexo;
    private String fechaIngreso;
    private String turno;
    private String colonia;
    private String calle;
    private int numero;

    public ModeloEmpleados(){

    }

    public ModeloEmpleados(int idEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String rfc, int telefono, String sexo, String fechaIngreso, String turno, String colonia, String calle, int numero) {
        IdEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.rfc = rfc;
        this.telefono = telefono;
        this.sexo = sexo;
        this.fechaIngreso = fechaIngreso;
        this.turno = turno;
        this.colonia = colonia;
        this.calle = calle;
        this.numero = numero;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        IdEmpleado = idEmpleado;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
