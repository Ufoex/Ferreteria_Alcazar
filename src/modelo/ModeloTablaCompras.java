/*
 Modelo de la tablita
 */
package modelo;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaCompras {
    DefaultTableModel ModeloTabla = new DefaultTableModel();

    public ModeloTablaCompras() {
        ModeloTabla.addColumn("idcompras");
        ModeloTabla.addColumn("precio_unitario");
        ModeloTabla.addColumn("cantidad_precio");
        ModeloTabla.addColumn("fecha");
        ModeloTabla.addColumn("total");
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
    
    
}
