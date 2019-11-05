package controlador;

import vista.Compras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControladorCompras {
    //Sirven para agregar  las vistas y los controladores por separado
    Compras Compras = new Compras();

    //Sirve para poder mover la ventana
    int x,y;

    public ControladorCompras(){
        agregarListener();
        Compras.setVisible(true);
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Compras.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //llenarModeloConVista(); //Llena modelo o datos de vista
                //ConsultasProveedores.modificar(ModeloProveedores);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarEntered.png")));
                Compras.actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }
        });

        //Listeners del Botón Guardar
        Compras.guardar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarselect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarEntered.png")));
                Compras.guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }
        });

        //Listeners del Botón Limpiar
        Compras.limpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarEntered.png")));
                Compras.limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }
        });

        //Listeners del Botón Eliminar
        Compras.eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarEntered.png")));
                Compras.eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }
        });

        //Listeners del Boton Cancelar
        Compras.cancelar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.cancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/cancelarSelect.png.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.cancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/cancelar.png.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.cancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/cancelarEntered.png")));
                Compras.cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.cancelar.setIcon(new ImageIcon(getClass().getResource("/imagenes/cancelar.png")));
            }
        });

        //Listeners del Botón Buscar
        Compras.buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarEntered.png")));
                Compras.buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }
        });

        //Listeners del Botón Salir
        Compras.salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Compras.salir, "En verdad quieres salir", "Salir", 0, 3);
                if (opcion == 0) {
                    Compras.dispose();
                    ControladorVistaMenu test2 = new ControladorVistaMenu();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Compras.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalirSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Compras.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Compras.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
                Compras.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Compras.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }
        });

        //Sirven para poder mover la ventana con el Listener y el MotionListener
        Compras.imgFondo.addMouseListener(new MouseListener() {
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
        Compras.imgFondo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Compras.setLocation(Compras.getLocation().x+e.getX()-x, Compras.getLocation().y+e.getY()-y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private void limpiarCampos() {
        Compras.idCompras.setText("");
        Compras.precioUnitario.setText("");
        Compras.cantidadProducto.setText("");
        Compras.fecha.setText("");
        Compras.total.setText("");


        //Deja el cursor en el campo de codigo
        Compras.idCompras.requestFocus();

    }
}
