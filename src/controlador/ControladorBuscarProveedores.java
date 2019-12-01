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

import modelo.*;
import vista.TablaProveedores;


public class ControladorBuscarProveedores extends JFrame implements MouseListener, KeyListener {
    ModeloTablaProveedores ModeloTabla = new ModeloTablaProveedores();
    TablaProveedores TablaProveedores = new TablaProveedores(new Frame(), true);
    ConsultasProveedores ConsultasProveedores = new ConsultasProveedores();
    ModeloProveedores ModeloProveedores; //Para retornarlo a la ventana padre


    public ControladorBuscarProveedores(ModeloProveedores ModeloProveedores) {
        this.ModeloProveedores = ModeloProveedores;
        TablaProveedores.setBackground(new Color(0,0,0,0));
        centrarVentana();
        oyentes();
        llenarTablaProveedores();
        TablaProveedores.setVisible(true); //AQUI VA!
    }

    private void oyentes() {
        //Oyentes del Mouse
        TablaProveedores.BtnAceptar.addMouseListener(this);
        TablaProveedores.TxtProveedorBuscar.addMouseListener(this);
        TablaProveedores.jTable.addMouseListener(this);

        //Oyentes del teclado
        TablaProveedores.TxtProveedorBuscar.addKeyListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == TablaProveedores.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            TablaProveedores.dispose(); //cierra la ventana de busqueda


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

    private void llenarTablaProveedores() {
        if (ConsultasProveedores.buscar(ModeloTabla.getModeloTabla()) == true)
            TablaProveedores.jTable.setModel(ModeloTabla.getModeloTabla()); //Lo que setea con la busqueda
    }

    private void llenarModeloConSeleccionFilaTabla() {
        int FilaSeleccionada = TablaProveedores.jTable.getSelectedRow();
        if (FilaSeleccionada != -1) { //si  (no) selecciono algo de la tabla
            //Tomar lo que hay en la fila seleccionada
            int idproveedor = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 0).toString());
            String nombre = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 1).toString();
            String apellidoPaterno = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 2).toString();
            String apellidoMaterno = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 3).toString();
            String rfc = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 4).toString();
            int telefono = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 5).toString());
            String mail = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 6).toString();
            String estado = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 7).toString();
            String ciudad = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 8).toString();
            int codigoPostal = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 9).toString());
            String colonia = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 10).toString();
            String calle = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 11).toString();
            int numero = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 12).toString());

            //Lllenar el modelo con los datos de la fila
            ModeloProveedores.setIdProveedor(idproveedor);
            ModeloProveedores.setNombre(nombre);
            ModeloProveedores.setApellidoPaterno(apellidoPaterno);
            ModeloProveedores.setApellidoMaterno(apellidoMaterno);
            ModeloProveedores.setRfc(rfc);
            ModeloProveedores.setTelefono(telefono);
            ModeloProveedores.setMail(mail);
            ModeloProveedores.setEstado(estado);
            ModeloProveedores.setCiudad(ciudad);
            ModeloProveedores.setCodigoPostal(codigoPostal);
            ModeloProveedores.setColonia(colonia);
            ModeloProveedores.setCalle(calle);
            ModeloProveedores.setNumero(numero);
        }
    }

    private void centrarVentana() {
        //Para hacer que la ventana siempre salga a la mitad de la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) /2);
        x = x-190;
        y = y-180;
        TablaProveedores.setLocation(x, y);
    }

}