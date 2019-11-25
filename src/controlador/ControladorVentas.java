package controlador;

import vista.Ventas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasVentas;
import modelo.ModeloVentas;

public class ControladorVentas implements KeyListener{
    //Sirven para agregar  las vistas y los controladores por separado
    Ventas Ventas = new Ventas();
    ModeloVentas ModeloVentas = new ModeloVentas();
    ConsultasVentas ConsultasVentas = new ConsultasVentas();

    public ControladorVentas(){
        agregarListener();
        Ventas.setVisible(true);
         //oyentes para el teclado
        Ventas.IdVentas.addKeyListener(this);
        Ventas.fecha.addKeyListener(this);
        Ventas.cantidad.addKeyListener(this);
        Ventas.precio.addKeyListener(this);
        Ventas.total.addKeyListener(this);
        Ventas.IdProducto.addKeyListener(this);

    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Ventas.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Ventas,"Los campos no deben estar vacios");

                   }
                else{
                    llenarModeloConVista(); //Llena modelo o datos de vista
                    if(ConsultasVentas.actualizar(ModeloVentas)==true){
                        JOptionPane.showMessageDialog(Ventas, "Datos actualizados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Ventas,"No se actualizaron los datos");

                    }
                 } 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Ventas.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Ventas.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Ventas.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarEntered.png")));
                Ventas.actualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                Ventas.actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

          
        });

        //Listeners del Botón Guardar
        Ventas.guardar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Ventas,"Los campos no deben estar vacios");

                }
                else{
                    llenarModeloConVista();
                    if(ConsultasVentas.insertar(ModeloVentas)==true){
                        JOptionPane.showMessageDialog(Ventas, "Datos insertados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Ventas,"No se insertaron los datos");

                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Ventas.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarselect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Ventas.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Ventas.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarEntered.png")));
                Ventas.guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Ventas.guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }
        });

        //Listeners del Botón Limpiar
        Ventas.limpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                limpiarCampos();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Ventas.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Ventas.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Ventas.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarEntered.png")));
                Ventas.limpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Ventas.limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }
        });

        //Listeners del Botón Eliminar
        Ventas.eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Ventas.IdVentas.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Ventas,"El codigo no debe estar vacio");

                }
                else{
                    llenarModeloConVista();
                    if(ConsultasVentas.eliminar(ModeloVentas)==true){
                        JOptionPane.showMessageDialog(Ventas, "Datos eliminados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Ventas,"No se eliminaron los datos");

                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Ventas.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Ventas.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Ventas.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarEntered.png")));
                Ventas.eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Ventas.eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }
        });

        //Listeners del Botón Buscar
        Ventas.buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
              
                ControladorBuscarVentas VentanaBuscar = new ControladorBuscarVentas(ModeloVentas);
                //llenar la vista con el modelo
                llenarVistaConModelo();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Ventas.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Ventas.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Ventas.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarEntered.png")));
                Ventas.buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Ventas.buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            
        });

        //Listeners del Botón Salir
        Ventas.salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int opcion = JOptionPane.showConfirmDialog(Ventas.salir, "En verdad quieres salir", "Salir", 0, 3);
                if (opcion == 0) {
                    Ventas.dispose();
                    ControladorVistaMenu test2 = new ControladorVistaMenu();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Ventas.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalirSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                Ventas.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Ventas.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
                Ventas.salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Ventas.salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
            }
        });

      
    }
        
    private void limpiarCampos() {
        Ventas.IdVentas.setText("");
        Ventas.fecha.setText("");
        Ventas.cantidad.setText("");
        Ventas.precio.setText("");
        Ventas.total.setText("");
        Ventas.IdProducto.setText("");

        //Deja el cursor en el primer campo
        Ventas.IdVentas.requestFocus();
    }
    private boolean validarCampos() {
        if (Ventas.IdVentas.getText().isEmpty()||
            Ventas.fecha.getText().isEmpty() ||
            Ventas.cantidad.getText().isEmpty() ||
            Ventas.precio.getText().isEmpty() ||
            Ventas.total.getText().isEmpty() ||
            Ventas.IdProducto.getText().isEmpty())
        {
            return false; // algunos campos estan vacios
        }
        else{
            return true; //todos los campos estan llenos
        }
    }

    private void llenarModeloConVista() {
        ModeloVentas.setIdVentas(Integer.parseInt(Ventas.IdVentas.getText()));
        ModeloVentas.setFecha(Ventas.fecha.getText());
        ModeloVentas.setCantidad(Integer.parseInt(Ventas.cantidad.getText()));
        ModeloVentas.setPrecio(Float.parseFloat(Ventas.precio.getText()));
        ModeloVentas.setTotal(Float.parseFloat(Ventas.total.getText()));
        ModeloVentas.setIdProducto(Integer.parseInt(Ventas.IdProducto.getText()));
    }
    private void llenarVistaConModelo() {
        Ventas.IdVentas.setText(ModeloVentas.getIdVentas()+"");
        Ventas.fecha.setText(ModeloVentas.getFecha()+"");
        Ventas.cantidad.setText(ModeloVentas.getCantidad()+"");
        Ventas.precio.setText(ModeloVentas.getPrecio()+"");
        Ventas.total.setText(ModeloVentas.getTotal()+"");
        Ventas.IdProducto.setText(ModeloVentas.getIdProducto()+"");
    }
  //Funciones del teclado: al dar enter pasar al siguiente campo
    @Override
    public void keyTyped(KeyEvent ke) {
             if(ke.getSource()==Ventas.IdVentas){
            if(ke.getKeyChar()==ke.VK_ENTER){ 
                Ventas.fecha.requestFocus();
                } 
            }else if(ke.getSource()==Ventas.fecha){
            if(ke.getKeyChar()==ke.VK_ENTER){ 
             Ventas.cantidad.requestFocus();
                }
            }else if(ke.getSource()==Ventas.cantidad){
            if(ke.getKeyChar()==ke.VK_ENTER){ 
             Ventas.precio.requestFocus();
                }
            }else if(ke.getSource()==Ventas.precio){
            if(ke.getKeyChar()==ke.VK_ENTER){ 
             Ventas.total.requestFocus(); 
                }
            }
            else if(ke.getSource()==Ventas.total){
            if(ke.getKeyChar()==ke.VK_ENTER){ 
             Ventas.IdProducto.requestFocus(); 
                }
            }else if (ke.getSource()==Ventas.IdVentas){
            if(ke.getKeyChar()==ke.VK_ENTER){  /////////7**************
            }
        }   
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
