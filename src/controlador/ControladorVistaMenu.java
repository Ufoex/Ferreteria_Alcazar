/*

 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import vista.*;

import javax.swing.*;

/**
 *
 * @author Equipo sin nombre ahahhaa
 */
public class ControladorVistaMenu {
    Menu Menu = new Menu();
    int x,y; //Para mover la ventana

    public ControladorVistaMenu() {

        agregarListener();
        Menu.setVisible(true);
    }

    private void agregarListener() {

        //Listeners del Botón Empleados
        Menu.empleados.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Menu.dispose();
                ControladorEmpleados empleados1 = new ControladorEmpleados();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Menu.empleados.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/empleadoSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Menu.empleados.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/empleado.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.empleados.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/empleadoEntered.png")));
                Menu.empleados.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.empleados.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/empleado.png")));
            }
        });

        //Listeners del Botón Proveedores
        Menu.proveedores.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Menu.dispose();
                ControladorProveedores proveedores1 = new ControladorProveedores();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Menu.proveedores.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/proveedorSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Menu.proveedores.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/proveedor.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.proveedores.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/proveedorEntered.png")));
                Menu.proveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.proveedores.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/proveedor.png")));
            }
        });

        //Listeners del Botón Productos
        Menu.productos.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Menu.setVisible(false);
                Menu.dispose();
                ControladorProductos productosVentana = new ControladorProductos();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Menu.productos.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/productosSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Menu.productos.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/productos.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.productos.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/productosEntered.png")));
                Menu.productos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.productos.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/productos.png")));
            }
        });

        //Listeners del Botón Ventas
        Menu.ventas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Menu.dispose();
                ControladorVentas ventas = new ControladorVentas();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Menu.ventas.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/ventasSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Menu.ventas.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/ventas.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.ventas.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/ventasEntered.png")));
                Menu.ventas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.ventas.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/ventas.png")));
            }
        });

        //Listeners del Botón Compras
        Menu.compras.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Menu.dispose();
                ControladorCompras compras1 = new ControladorCompras();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Menu.compras.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/comprasSelected.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Menu.compras.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/compras.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.compras.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/comprasEntered.png")));
                Menu.compras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.compras.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu/compras.png")));
            }
        });

        //Listener del boton salir (la X)
        Menu.salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Menu.salir, "En verdad quieres salir", "Salir", 0, 3);
                if (opcion == 0) {
                    Menu.dispose();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Menu.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalirSelect.png")));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Menu.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Menu.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //Sirve para mover la ventana (captura la posicion X y Y)
        Menu.imgFondo.addMouseListener(new MouseListener() {
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
        Menu.imgFondo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Menu.setLocation(Menu.getLocation().x+e.getX()-x, Menu.getLocation().y+e.getY()-y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

}
