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
import javax.swing.table.DefaultTableModel;
import modelo.ConsultasProductos;
import modelo.ModeloProductos;
import modelo.ModeloTablaProductos;
import vista.TablaProducto;

/**
 *
 * @author miria
 */
public class ControladorBuscarProducto extends JFrame implements MouseListener, KeyListener {
    ModeloTablaProductos ModeloTabla = new ModeloTablaProductos();
    TablaProducto TablaProducto = new TablaProducto(new Frame(), true);
    ConsultasProductos Consultas = new ConsultasProductos();
    ModeloProductos ModeloProductos; //Para retornarlo a la ventana padre
    
    
    public ControladorBuscarProducto(ModeloProductos ModeloProductos) {
        this.ModeloProductos = ModeloProductos;
        TablaProducto.setBackground(new Color(0,0,0,0));
        centrarVentana();
        oyentes();
        llenarTablaProductos();
        TablaProducto.setVisible(true); //AQUI VA!
    }

    private void oyentes() {
        //Oyentes del Mouse
        TablaProducto.BtnAceptar.addMouseListener(this);
        TablaProducto.TxtProductoBuscar.addMouseListener(this);
        TablaProducto.Tabla.addMouseListener(this);
        
        //Oyentes del teclado
        TablaProducto.TxtProductoBuscar.addKeyListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == TablaProducto.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            TablaProducto.dispose(); //cierra la ventana de busqueda
            
            
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

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void llenarTablaProductos() {
        if (Consultas.buscarTodosLosProductos(ModeloTabla.getModeloTabla()) == true) 
            TablaProducto.Tabla.setModel(ModeloTabla.getModeloTabla()); //Lo que setea con la busqueda        
    }

    private void llenarModeloConSeleccionFilaTabla() {
        int FilaSeleccionada = TablaProducto.Tabla.getSelectedRow();
        if (FilaSeleccionada != -1) { //si  (no) selecciono algo de la tabla
            //Tomar lo que hay en la fila seleccionada
            int idproducto = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 0).toString());
            String nombre = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 1).toString();
            String marca = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 2).toString();            
            float preciounitario = Float.parseFloat(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 3).toString());
            int stock = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 4).toString());
            String categoria = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 5).toString();
            
            
            
            //Lllenar el modelo con los datos de la fila
            ModeloProductos.setIdProductos(idproducto);
            ModeloProductos.setNombre(nombre);
            ModeloProductos.setMarca(marca);
            ModeloProductos.setPrecioUnitario(preciounitario);
            ModeloProductos.setStock(stock);
            ModeloProductos.setCategoria(categoria);
            
        }
    }
    
    private void centrarVentana() {
        //Para hacer que la ventana siempre salga a la mitad de la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2+50);
        int y = (int) ((dimension.getHeight() - this.getHeight()) /2+50);
        this.setLocation(x, y);
    }
        
}