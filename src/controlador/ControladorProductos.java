/*

 */
package controlador;

import modelo.ModeloProductos;
import vista.Productos;
import javax.swing.*;

import modelo.ConsultasProductos;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author
 */
public class ControladorProductos {
    //Sirven para agregar las vistas y los controladores por separado
    Productos Productos = new Productos();//Cambiar a mayuscula
    ModeloProductos ModeloProductos = new ModeloProductos();
    ConsultasProductos ConsultasProductos = new ConsultasProductos();

    //Sirve para poder mover la ventana
    int x,y;

    public ControladorProductos() {
        agregarListener();
        Productos.setVisible(true);
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Productos.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                llenarModeloConVista(); //Llena modelo o datos de vista
                ConsultasProductos.modificar(ModeloProductos);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Productos.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Productos.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Productos.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarEntered.png")));
                Productos.actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Productos.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }
        });

        //Listeners del Botón Guardar
        Productos.guardar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Productos,"Los campos no deben estar vacios");

                }
                else{
                    llenarVistaConModelo();
                    if(ConsultasProductos.insertar(ModeloProductos)==true){
                        JOptionPane.showMessageDialog(Productos, "Datos insertados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Productos,"No se insertaron los datos");

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Productos.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarselect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Productos.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Productos.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarEntered.png")));
                Productos.guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Productos.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }
        });

        //Listeners del Botón Limpiar
        Productos.limpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Productos.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Productos.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Productos.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarEntered.png")));
                Productos.limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Productos.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }
        });

        //Listeners del Botón Eliminar
        Productos.eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Productos.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Productos.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Productos.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarEntered.png")));
                Productos.eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Productos.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }
        });

        //Listeners del Botón Buscar
        Productos.buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ConsultasProductos.buscar(ModeloProductos);
                llenarModeloConVista();//***************************************
                ModeloProductos.setIdProductos(Integer.parseInt(Productos.idProductos.getText()));
                ConsultasProductos.buscar(ModeloProductos);//******************************
                llenarVistaConModelo();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Productos.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Productos.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Productos.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarEntered.png")));
                Productos.buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Productos.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }
        });

        //Listeners del Botón Salir
        Productos.salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Productos.salir, "En verdad quieres salir", "Salir", 0, 3);
                if (opcion == 0) {
                    Productos.dispose();
                    ControladorVistaMenu test2 = new ControladorVistaMenu();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Productos.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalirSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Productos.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Productos.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
                Productos.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Productos.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }
        });

        //Sirven para poder mover la ventana con el Listener y el MotionListener
        Productos.imgFondo.addMouseListener(new MouseListener() {
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
        Productos.imgFondo.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Productos.setLocation(Productos.getLocation().x+e.getX()-x, Productos.getLocation().y+e.getY()-y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
    }

    private void limpiarCampos() {
        Productos.idProductos.setText("");
        Productos.nombre.setText("");
        Productos.marca.setText("");
        Productos.precioUnitario.setText("");
        Productos.stock.setText("");
        Productos.categoria.setText("");

        //Deja el cursor en el campo de codigo
        Productos.idProductos.requestFocus();
        
    }
    
    private void llenarModeloConVista(){
        ModeloProductos.setIdProductos(Integer.parseInt(Productos.idProductos.getText()));
        ModeloProductos.setNombre(Productos.nombre.getText());
        ModeloProductos.setMarca(Productos.marca.getText());
        if (Productos.precioUnitario.getText().isEmpty()) //***************
            ModeloProductos.setPrecioUnitario(0);
        else
            ModeloProductos.setPrecioUnitario(Float.parseFloat(Productos.precioUnitario.getText()));
        ModeloProductos.setStock(Integer.parseInt(Productos.stock.getText()));
        ModeloProductos.setCategoria(Productos.categoria.getText());
    }

    private void llenarVistaConModelo() {
        Productos.nombre.setText(ModeloProductos.getNombre());
        Productos.marca.setText(ModeloProductos.getMarca());
        Productos.precioUnitario.setText(ModeloProductos.getPrecioUnitario()+"");
        Productos.stock.setText(ModeloProductos.getStock()+"");
        Productos.categoria.setText(ModeloProductos.getCategoria());

    }

   

    private boolean validarCampos(){
        if (Productos.idProductos.getText().isEmpty() ||
                Productos.nombre.getText().isEmpty() ||
                Productos.marca.getText().isEmpty() ||
                Productos.precioUnitario.getText().isEmpty() ||
                Productos.stock.getText().isEmpty() ||
                Productos.categoria.getText().isEmpty()) {
            return false; // algunos campos estan vacios
        }
        else{
            return true; //todos los campos estan llenos
        }
    }




}
