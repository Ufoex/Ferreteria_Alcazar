package controlador;

import vista.Proveedores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControladorProveedores {
    //Sirven para agregar  las vistas y los controladores por separado
    Proveedores Proveedores = new Proveedores();

    //Sirve para poder mover la ventana
    int x,y;

    public ControladorProveedores(){
        agregarListener();
        Proveedores.setVisible(true);
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Proveedores.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //llenarModeloConVista(); //Llena modelo o datos de vista
                //ConsultasProveedores.modificar(ModeloProveedores);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Proveedores.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Proveedores.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Proveedores.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarEntered.png")));
                Proveedores.actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Proveedores.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }
        });

        //Listeners del Botón Guardar
        Proveedores.guardar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Proveedores.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarselect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Proveedores.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Proveedores.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarEntered.png")));
                Proveedores.guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Proveedores.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }
        });

        //Listeners del Botón Limpiar
        Proveedores.limpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Proveedores.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Proveedores.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Proveedores.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarEntered.png")));
                Proveedores.limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Proveedores.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }
        });

        //Listeners del Botón Eliminar
        Proveedores.eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Proveedores.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Proveedores.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Proveedores.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarEntered.png")));
                Proveedores.eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Proveedores.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }
        });

        //Listeners del Botón Buscar
        Proveedores.buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Proveedores.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Proveedores.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Proveedores.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarEntered.png")));
                Proveedores.buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Proveedores.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }
        });

        //Listeners del Botón Salir
        Proveedores.salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Proveedores.salir, "En verdad quieres salir", "Salir", 0, 3);
                if (opcion == 0) {
                    Proveedores.dispose();
                    ControladorVistaMenu test2 = new ControladorVistaMenu();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Proveedores.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalirSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Proveedores.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Proveedores.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
                Proveedores.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Proveedores.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }
        });

        //Sirven para poder mover la ventana con el Listener y el MotionListener
        Proveedores.imgFondo.addMouseListener(new MouseListener() {
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
        Proveedores.imgFondo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Proveedores.setLocation(Proveedores.getLocation().x+e.getX()-x, Proveedores.getLocation().y+e.getY()-y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private void limpiarCampos() {
        Proveedores.IdProveedor.setText("");
        Proveedores.nombre.setText("");
        Proveedores.apellidoPaterno.setText("");
        Proveedores.apellidoMaterno.setText("");
        Proveedores.rfc.setText("");
        Proveedores.telefono.setText("");
        Proveedores.mail.setText("");
        Proveedores.estado.setText("");
        Proveedores.ciudad.setText("");
        Proveedores.codigoPostal.setText("");
        Proveedores.colonia.setText("");
        Proveedores.calle.setText("");
        Proveedores.numero.setText("");

        //Deja el cursor en el campo de codigo
        Proveedores.IdProveedor.requestFocus();

    }
}
