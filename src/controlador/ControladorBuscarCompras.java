/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import modelo.ConsultasCompras;
import modelo.ModeloCompras;
import modelo.ModeloTablaCompras;
import vista.TablaCompras;

/**
 *
 * @author denis
 */
public class ControladorBuscarCompras extends JFrame implements MouseListener, KeyListener{
    ModeloTablaCompras ModeloTabla = new   ModeloTablaCompras();
    TablaCompras TablaCompras = new TablaCompras(new Frame(), true);
    ConsultasCompras ConsultasCompras = new ConsultasCompras();
    ModeloCompras ModeloCompras; //para retornar a la ventana padre
    
    public ControladorBuscarCompras(ModeloCompras ModeloCompras){
        this.ModeloCompras = ModeloCompras;
        TablaCompras.setBackground(new Color(0,0,0,0));
        centrarVentana();
        oyentes();
        llenarTablaCompras();
        TablaCompras.setVisible(true);
    }
    private void centrarVentana() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) /2);
        x = x-190;
        y = y-180;
        TablaCompras.setLocation(x, y);
    }

    private void oyentes() {
        //para hacer que la ventana siempre salga a la mitad de la pantalla
        TablaCompras.BtnAceptar.addMouseListener(this);
        TablaCompras.TxtComprasBuscar.addMouseListener(this);
        TablaCompras.Tabla.addMouseListener(this);
        
        //oyentes del teclado
        TablaCompras.TxtComprasBuscar.addKeyListener(this);
    }

    private void llenarTablaCompras() {
        if (ConsultasCompras.buscar(ModeloTabla.getModeloTabla())== true) {
            TablaCompras.Tabla.setModel(ModeloTabla.getModeloTabla());
        }
    }
    private void llenarModeloConSeleccionFilaTabla() {
         int FilaSeleccionada = TablaCompras.Tabla.getSelectedRow();
        if (FilaSeleccionada != -1) { //si  (no) selecciono algo de la tabla
            //Tomar lo que hay en la fila seleccionada
            int idcompras = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 1).toString());
            float precio_unitario = Float.parseFloat(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 2).toString());
            float cantidad_producto = Float.parseFloat(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 3).toString());
            String fecha = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 4).toString();
            double total = Double.parseDouble(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 5).toString());

            //Lllenar el modelo con los datos de la fila
            ModeloCompras.setIdCompras(idcompras);
            ModeloCompras.setPrecioUnitario(precio_unitario);
            ModeloCompras.setCantidad(cantidad_producto);
            ModeloCompras.setFecha(fecha);
            ModeloCompras.setTotal(total);
            }
     }
//eventos del mouse 
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == TablaCompras.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            TablaCompras.dispose(); //cierra la ventana de busqueda
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    //eventos del teclado
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    
    
}
