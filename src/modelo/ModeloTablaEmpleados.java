package modelo;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaEmpleados {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaEmpleados(){
        ModeloTabla.addColumn("IdEmpleados");
        ModeloTabla.addColumn("nombre");
        ModeloTabla.addColumn("apellidoPaterno");
        ModeloTabla.addColumn("apellidoMaterno");
        ModeloTabla.addColumn("rfc");
        ModeloTabla.addColumn("telefono");
        ModeloTabla.addColumn("sexo");
        ModeloTabla.addColumn("fechaIngreso");
        ModeloTabla.addColumn("turno");
        ModeloTabla.addColumn("colonia");
        ModeloTabla.addColumn("calle");
        ModeloTabla.addColumn("numero");
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}
