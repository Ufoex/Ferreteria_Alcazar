package controlador;

import modelo.ConsultasEmpleados;
import modelo.ModeloEmpleados;
import vista.Empleados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorEmpleados implements KeyListener {
    //Sirven para agregar  las vistas y los controladores por separado
    Empleados Empleados = new Empleados();
    ModeloEmpleados ModeloEmpleados = new ModeloEmpleados();
    ConsultasEmpleados ConsultasEmpleados = new ConsultasEmpleados();


    public ControladorEmpleados(){
        agregarListener();
        Empleados.setVisible(true);
        oyentes();
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Empleados.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Empleados,"Los campos no deben estar vacios");

                }
                else{
                    llenarModeloConVista(); //Llena modelo o datos de vista
                    if(ConsultasEmpleados.actualizar(ModeloEmpleados)==true){
                        JOptionPane.showMessageDialog(Empleados, "Datos actualizados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Empleados,"No se actualizaron los datos");

                    }
                }
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
                if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Empleados,"Los campos no deben estar vacios");

                }
                else{
                    llenarModeloConVista();
                    if(ConsultasEmpleados.insertar(ModeloEmpleados)==true){
                        JOptionPane.showMessageDialog(Empleados, "Datos insertados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Empleados,"No se insertaron los datos");

                    }
                }
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
                if(Empleados.IdEmpleado.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Empleados,"El codigo no debe estar vacio");

                }
                else{
                    llenarModeloConVista();
                    if(ConsultasEmpleados.eliminar(ModeloEmpleados)==true){
                        JOptionPane.showMessageDialog(Empleados, "Datos eliminados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Empleados,"No se eliminaron los datos");

                    }
                }
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
                ControladorBuscarEmpleados VentanaBuscar = new ControladorBuscarEmpleados(ModeloEmpleados);
                //llenar la vista con el modelo
                llenarVistaConModelo();
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


    }

    private void limpiarCampos() {
        Empleados.IdEmpleado.setText("");
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
        Empleados.IdEmpleado.requestFocus();

    }

    private boolean validarCampos() {
        if (Empleados.IdEmpleado.getText().isEmpty()||
                Empleados.nombre.getText().isEmpty() ||
                Empleados.apellidoPaterno.getText().isEmpty() ||
                Empleados.apellidoMaterno.getText().isEmpty() ||
                Empleados.rfc.getText().isEmpty() ||
                Empleados.telefono.getText().isEmpty() ||
                Empleados.sexo.getText().isEmpty()||
                Empleados.fechaIngreso.getText().isEmpty() ||
                Empleados.turno.getText().isEmpty() ||
                Empleados.colonia.getText().isEmpty() ||
                Empleados.calle.getText().isEmpty() ||
                Empleados.numero.getText().isEmpty())
        {
            return false; // algunos campos estan vacios
        }
        else{
            return true; //todos los campos estan llenos
        }
    }

    private void llenarModeloConVista() {
        ModeloEmpleados.setIdEmpleado(Integer.parseInt(Empleados.IdEmpleado.getText()));
        ModeloEmpleados.setNombre(Empleados.nombre.getText());
        ModeloEmpleados.setApellidoPaterno(Empleados.apellidoPaterno.getText());
        ModeloEmpleados.setApellidoMaterno(Empleados.apellidoMaterno.getText());
        ModeloEmpleados.setRfc(Empleados.rfc.getText());
        ModeloEmpleados.setTelefono(Integer.parseInt(Empleados.telefono.getText()));
        ModeloEmpleados.setSexo(Empleados.sexo.getText());
        ModeloEmpleados.setFechaIngreso(Empleados.fechaIngreso.getText());
        ModeloEmpleados.setTurno(Empleados.turno.getText());
        ModeloEmpleados.setColonia(Empleados.colonia.getText());
        ModeloEmpleados.setCalle(Empleados.calle.getText());
        ModeloEmpleados.setNumero(Integer.parseInt(Empleados.numero.getText()));

    }

    private void llenarVistaConModelo() {
        Empleados.IdEmpleado.setText(ModeloEmpleados.getIdEmpleado() +"");
        Empleados.nombre.setText(ModeloEmpleados.getNombre());
        Empleados.apellidoPaterno.setText(ModeloEmpleados.getApellidoPaterno());
        Empleados.apellidoMaterno.setText(ModeloEmpleados.getApellidoMaterno());
        Empleados.rfc.setText(ModeloEmpleados.getRfc());
        Empleados.telefono.setText(ModeloEmpleados.getTelefono()+"");
        Empleados.sexo.setText(ModeloEmpleados.getSexo());
        Empleados.fechaIngreso.setText(ModeloEmpleados.getFechaIngreso());
        Empleados.turno.setText(ModeloEmpleados.getTurno());
        Empleados.colonia.setText(ModeloEmpleados.getColonia());
        Empleados.calle.setText(ModeloEmpleados.getCalle());
        Empleados.numero.setText(ModeloEmpleados.getNumero()+"");

    }
    private void oyentes(){
        Empleados.IdEmpleado.addKeyListener(this);
        Empleados.nombre.addKeyListener(this);
        Empleados.apellidoPaterno.addKeyListener(this);
        Empleados.apellidoMaterno.addKeyListener(this);
        Empleados.rfc.addKeyListener(this);
        Empleados.telefono.addKeyListener(this);
        Empleados.sexo.addKeyListener(this);
        Empleados.fechaIngreso.addKeyListener(this);
        Empleados.turno.addKeyListener(this);
        Empleados.colonia.addKeyListener(this);
        Empleados.calle.addKeyListener(this);
        Empleados.numero.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()==Empleados.IdEmpleado){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.nombre.requestFocus();
            }
        }else if(e.getSource()==Empleados.nombre){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.apellidoPaterno.requestFocus();
            }
        }else if(e.getSource()==Empleados.apellidoPaterno){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.apellidoMaterno.requestFocus();
            }
        }else if(e.getSource()==Empleados.apellidoMaterno){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.rfc.requestFocus();
            }
        }else if(e.getSource()==Empleados.rfc){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.telefono.requestFocus();
            }
        }else if (e.getSource()==Empleados.telefono){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.sexo.requestFocus();
            }
        }else if (e.getSource()==Empleados.sexo){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.fechaIngreso.requestFocus();
            }
        }else if (e.getSource()==Empleados.fechaIngreso){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.turno.requestFocus();
            }
        }else if (e.getSource()==Empleados.turno){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.colonia.requestFocus();
            }
        }else if (e.getSource()==Empleados.colonia){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.calle.requestFocus();
            }
        }else if (e.getSource()==Empleados.calle){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.numero.requestFocus();
            }
        }else if (e.getSource()==Empleados.numero){
            if(e.getKeyChar()==e.VK_ENTER){
                Empleados.guardar.requestFocus();
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
