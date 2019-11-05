package controlador;

import vista.Empleados;
import vista.Proveedores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControladorEmpleados {
    //Sirven para agregar  las vistas y los controladores por separado
    Empleados Empleados = new Empleados();

    //Sirve para poder mover la ventana
    int x,y;

    public ControladorEmpleados(){
        agregarListener();
        Empleados.setVisible(true);
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Empleados.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //llenarModeloConVista(); //Llena modelo o datos de vista
                //ConsultasProveedores.modificar(ModeloProveedores);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Empleados.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Empleados.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Empleados.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarEntered.png")));
                Empleados.actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Empleados.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }
        });

        //Listeners del Botón Guardar
        Empleados.guardar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Empleados.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarselect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Empleados.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Empleados.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarEntered.png")));
                Empleados.guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Empleados.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }
        });

        //Listeners del Botón Limpiar
        Empleados.limpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Empleados.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Empleados.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Empleados.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarEntered.png")));
                Empleados.limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Empleados.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }
        });

        //Listeners del Botón Eliminar
        Empleados.eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Empleados.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Empleados.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Empleados.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarEntered.png")));
                Empleados.eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Empleados.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }
        });

        //Listeners del Botón Buscar
        Empleados.buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Empleados.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Empleados.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Empleados.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarEntered.png")));
                Empleados.buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Empleados.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }
        });

        //Listeners del Botón Salir
        Empleados.salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Empleados.salir, "En verdad quieres salir", "Salir", 0, 3);
                if (opcion == 0) {
                    Empleados.dispose();
                    ControladorVistaMenu test2 = new ControladorVistaMenu();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Empleados.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalirSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Empleados.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Empleados.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
                Empleados.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Empleados.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }
        });

        //Sirven para poder mover la ventana con el Listener y el MotionListener
        Empleados.imgFondo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
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
        });

        //Los listener del Mouse para cuando deje precionado el Mouse
        Empleados.imgFondo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Empleados.setLocation(Empleados.getLocation().x+e.getX()-x, Empleados.getLocation().y+e.getY()-y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private void limpiarCampos() {
        Empleados.idEmpleado.setText("");
        Empleados.nombre.setText("");
        Empleados.apellidoPaterno.setText("");
        Empleados.apellidoMaterno.setText("");
        Empleados.rfc.setText("");
        Empleados.telefono.setText("");
        Empleados.sexo.setText("");
        Empleados.fechaIngreso.setText("");
        Empleados.turno.setText("");
        Empleados.colonia.setText("");
        Empleados.calle.setText("");
        Empleados.numero.setText("");

        //Deja el cursor en el campo de codigo
        Empleados.idEmpleado.requestFocus();

    }
}
