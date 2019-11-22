/*

 */
package modelo;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaVentas {
     DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaVentas() {
        ModeloTabla.addColumn("idventas");
        ModeloTabla.addColumn("fecha");
        ModeloTabla.addColumn("cantidad");
        ModeloTabla.addColumn("precio_publico");
        ModeloTabla.addColumn("total");
        ModeloTabla.addColumn("idproducto");
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
    
    
}
