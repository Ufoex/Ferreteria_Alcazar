package modelo;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaProveedores {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaProveedores() {
        ModeloTabla.addColumn("IdProveedor");
        ModeloTabla.addColumn("nombre");
        ModeloTabla.addColumn("apellidoPaterno");
        ModeloTabla.addColumn("apellidoMaterno");
        ModeloTabla.addColumn("rfc");
        ModeloTabla.addColumn("telefono");
        ModeloTabla.addColumn("mail");
        ModeloTabla.addColumn("estado");
        ModeloTabla.addColumn("ciudad");
        ModeloTabla.addColumn("codigoPostal");
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
