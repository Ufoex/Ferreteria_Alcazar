package controlador;

import vista.Compras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import modelo.ConsultasCompras;
import modelo.ModeloCompras;

public class ControladorCompras implements KeyListener{
    //Sirven para agregar  las vistas y los controladores por separado
    Compras Compras = new Compras();
    ModeloCompras ModeloCompras = new ModeloCompras();
    ConsultasCompras ConsultasCompras = new ConsultasCompras();

    public ControladorCompras(){
        agregarListener();
        Compras.setVisible(true);
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Compras.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Compras,"Los campos no deben estar vacios");

                }
                else{
                    llenarModeloConVista(); //Llena modelo o datos de vista
                    if(ConsultasCompras.actualizar(ModeloCompras)==true){
                        JOptionPane.showMessageDialog(Compras, "Datos actualizados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Compras,"No se actualizaron los datos");

                    }
                }
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
                if (validarCampos() == false) {
                    JOptionPane.showMessageDialog(Compras,"Los campos no deben estar vacios");
                }else{
                    llenarModeloConVista();
                    if (ConsultasCompras.insertar(ModeloCompras) == true) {
                      JOptionPane.showMessageDialog(Compras,"Datos insertados correctamente");
                      limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Compras,"No se insertaron datos");
                    }
                }

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
                if (Compras.idCompras.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(Compras,"El código no debe de estar vacío");
                }else{
                    llenarModeloConVista();
                    if (ConsultasCompras.eliminar(ModeloCompras) == true) {
                        JOptionPane.showMessageDialog(Compras,"Datos eliminados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Compras,"No se eliminaron los datos");
                    }
                }
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

        
         //Listeners del Botón Buscar
        Compras.buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ControladorBuscarCompras VentBuscar = new ControladorBuscarCompras(ModeloCompras);
                //llenar la vista con el modelo
                llenarVistaConModelo();
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
     private boolean validarCampos(){
         if (Compras.idCompras.getText().isEmpty()||
                 Compras.precioUnitario.getText().isEmpty()||
                 Compras.cantidadProducto.getText().isEmpty()||
                 Compras.fecha.getText().isEmpty()) {
             return false;// algun os campos estan vacios
         }else{
             return true;// todos los campos estan llenos
         }
     }
     private void llenarModeloConVista(){
         ModeloCompras.setIdCompras(Integer.parseInt(Compras.idCompras.getText()));
         ModeloCompras.setPrecioUnitario(Float.parseFloat(Compras.precioUnitario.getText()));
         ModeloCompras.setCantidad(Float.parseFloat(Compras.cantidadProducto.getText()));
         ModeloCompras.setFecha(Compras.fecha.getText());
         ModeloCompras.setTotal(Double.parseDouble(Compras.total.getText()));
     }
     
     private void llenarVistaConModelo(){
         Compras.idCompras.setText(ModeloCompras.getIdCompras()+"");
         Compras.precioUnitario.setText(ModeloCompras.getPrecioUnitario()+"");
         Compras.cantidadProducto.setText(ModeloCompras.getCantidad()+"");
         Compras.fecha.setText(ModeloCompras.getFecha()+"");
         Compras.total.setText(ModeloCompras.getTotal()+"");
     }
        //Funciones del teclado: al dar enter pasar al siguiente campo
    @Override
    public void keyTyped(KeyEvent e) { if(e.getSource()==Compras.idCompras){
            if(e.getKeyChar()==e.VK_ENTER){ 
                Compras.precioUnitario.requestFocus();
                } 
            }else if(e.getSource()==Compras.precioUnitario){
            if(e.getKeyChar()==e.VK_ENTER){ 
             Compras.cantidadProducto.requestFocus();
                }
            }else if(e.getSource()==Compras.cantidadProducto){
            if(e.getKeyChar()==e.VK_ENTER){ 
             Compras.fecha.requestFocus();
                }
            }else if(e.getSource()==Compras.fecha){
            if(e.getKeyChar()==e.VK_ENTER){ 
             Compras.total.requestFocus(); 
                }
            }else if(e.getSource()==Compras.total){
            if(e.getKeyChar()==e.VK_ENTER){ 
             Compras.idCompras.requestFocus(); 
                }
            }else if (e.getSource()==Compras.idCompras){
            if(e.getKeyChar()==e.VK_ENTER){  /////////7**************
            }
        }   
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
     
  
}
