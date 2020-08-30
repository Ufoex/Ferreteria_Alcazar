/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;


public class ModeloTablaProductos {
    DefaultTableModel ModeloTabla = new DefaultTableModel();
    
    public ModeloTablaProductos() {
        ModeloTabla.addColumn("idproducto");
        ModeloTabla.addColumn("nombre");
        ModeloTabla.addColumn("marca");
        ModeloTabla.addColumn("preciounitario");
        ModeloTabla.addColumn("stock");
        ModeloTabla.addColumn("categoria");
        
        
        
    }

    public DefaultTableModel getModeloTabla() {
        return ModeloTabla;
    }

    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
    
}
