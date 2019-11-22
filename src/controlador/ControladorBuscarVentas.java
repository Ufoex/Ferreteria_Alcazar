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
import modelo.ConsultasVentas;
import modelo.ModeloTablaVentas;
import modelo.ModeloVentas;
import vista.TablaVentas;


public class ControladorBuscarVentas extends JFrame implements MouseListener, KeyListener {
    ModeloTablaVentas ModeloTabla = new ModeloTablaVentas();
    TablaVentas TablaVentas = new TablaVentas(new Frame(), true);
    ConsultasVentas ConsultasVentas = new ConsultasVentas();
    ModeloVentas ModeloVentas; //Para retornarlo a la ventana padre
    
    public ControladorBuscarVentas(ModeloVentas ModeloVentas) {
        this.ModeloVentas = ModeloVentas;
        TablaVentas.setBackground(new Color(0,0,0,0));
        centrarVentana();
        oyentes();
        llenarTablaVentas();
        TablaVentas.setVisible(true); 
    }
    private void centrarVentana() {
         //Para hacer que la ventana siempre salga a la mitad de la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) /2);
        x = x-190;
        y = y-180;
        TablaVentas.setLocation(x, y);
        
    }
    
    private void oyentes() {
        //Oyentes del Mouse
        TablaVentas.BtnAceptar.addMouseListener(this);
        TablaVentas.TxtVentasBuscar.addMouseListener(this);
        TablaVentas.Tabla.addMouseListener(this);
        
        //Oyentes del teclado
        TablaVentas.TxtVentasBuscar.addKeyListener(this);
        
    }

    private void llenarTablaVentas() {
        if (ConsultasVentas.buscar(ModeloTabla.getModeloTabla())== true)
            TablaVentas.Tabla.setModel(ModeloTabla.getModeloTabla()); //Lo que setea con la busqueda   
        
    }
     private void llenarModeloConSeleccionFilaTabla() {
         int FilaSeleccionada = TablaVentas.Tabla.getSelectedRow();
        if (FilaSeleccionada != -1) { //si  (no) selecciono algo de la tabla
            //Tomar lo que hay en la fila seleccionada
            int idventas = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 0).toString());
            String fecha = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 1).toString();
            int cantidad = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 2).toString());
            float precio_publico = Float.parseFloat(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 3).toString());
             float total = Float.parseFloat(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 4).toString());
            int idproducto = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 5).toString());
             
            //Lllenar el modelo con los datos de la fila
            ModeloVentas.setIdVentas(idventas);
            ModeloVentas.setFecha(fecha);
            ModeloVentas.setCantidad(cantidad);
            ModeloVentas.setPrecio(precio_publico);
            ModeloVentas.setTotal(total);
            ModeloVentas.setIdProducto(idproducto);
            }
     }


    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == TablaVentas.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            TablaVentas.dispose(); //cierra la ventana de busqueda
            
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

   
}
