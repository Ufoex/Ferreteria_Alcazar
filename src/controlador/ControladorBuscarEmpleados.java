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
import vista.TablaEmpleados;


public class ControladorBuscarEmpleados extends JFrame implements MouseListener, KeyListener {
    ModeloTablaEmpleados ModeloTabla = new ModeloTablaEmpleados();
    TablaEmpleados TablaEmpleados = new TablaEmpleados(new Frame(), true);
    ConsultasEmpleados ConsultasEmpleados = new ConsultasEmpleados();
    ModeloEmpleados ModeloEmpleados; //Para retornarlo a la ventana padre


    public ControladorBuscarEmpleados(ModeloEmpleados ModeloEmpleados) {
        this.ModeloEmpleados = ModeloEmpleados;
        TablaEmpleados.setBackground(new Color(0,0,0,0));
        centrarVentana();
        oyentes();
        llenarTablaEmpleados();
        TablaEmpleados.setVisible(true); //AQUI VA!
    }

    private void oyentes() {
        //Oyentes del Mouse
        TablaEmpleados.BtnAceptar.addMouseListener(this);
        TablaEmpleados.TxtEmpleadosBuscar.addMouseListener(this);
        TablaEmpleados.jTable.addMouseListener(this);

        //Oyentes del teclado
        TablaEmpleados.TxtEmpleadosBuscar.addKeyListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == TablaEmpleados.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            TablaEmpleados.dispose(); //cierra la ventana de busqueda


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

    private void llenarTablaEmpleados() {
        if (ConsultasEmpleados.buscar(ModeloTabla.getModeloTabla()) == true)
            TablaEmpleados.jTable.setModel(ModeloTabla.getModeloTabla());
    }

    private void llenarModeloConSeleccionFilaTabla() {
        int FilaSeleccionada = TablaEmpleados.jTable.getSelectedRow();
        if (FilaSeleccionada != -1) { //si  (no) selecciono algo de la tabla
            //Tomar lo que hay en la fila seleccionada
            int idEmpleados = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 0).toString());
            String nombre = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 1).toString();
            String apellidoPaterno = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 2).toString();
            String apellidoMaterno = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 3).toString();
            String rfc = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 4).toString();
            int telefono = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 5).toString());
            String sexo = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 6).toString();
            String fechaIngreso = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 7).toString();
            String turno = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 8).toString();
            String colonia = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 9).toString();
            String calle = ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 10).toString();
            int numero = Integer.parseInt(ModeloTabla.getModeloTabla().getValueAt(FilaSeleccionada, 11).toString());

            //Lllenar el modelo con los datos de la fila
            ModeloEmpleados.setIdEmpleado(idEmpleados);
            ModeloEmpleados.setNombre(nombre);
            ModeloEmpleados.setApellidoPaterno(apellidoPaterno);
            ModeloEmpleados.setApellidoMaterno(apellidoMaterno);
            ModeloEmpleados.setRfc(rfc);
            ModeloEmpleados.setTelefono(telefono);
            ModeloEmpleados.setSexo(sexo);
            ModeloEmpleados.setFechaIngreso(fechaIngreso);
            ModeloEmpleados.setTurno(turno);
            ModeloEmpleados.setColonia(colonia);
            ModeloEmpleados.setCalle(calle);
            ModeloEmpleados.setNumero(numero);
        }
    }

    private void centrarVentana() {
        //Para hacer que la ventana siempre salga a la mitad de la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) /2);
        x = x-170;
        y = y-180;
        TablaEmpleados.setLocation(x, y);
    }

}