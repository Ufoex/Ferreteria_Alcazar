package controlador;

import modelo.ConsultasProveedores;
import modelo.ModeloProveedores;
import vista.Proveedores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorProveedores implements KeyListener {
    //Sirven para agregar  las vistas y los controladores por separado
    Proveedores Proveedores = new Proveedores();
    ModeloProveedores ModeloProveedores = new ModeloProveedores();
    ConsultasProveedores ConsultasProveedores = new ConsultasProveedores();


    public ControladorProveedores(){
        agregarListener();
        Proveedores.setVisible(true);
        oyentes();
    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        Proveedores.actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Proveedores,"Los campos no deben estar vacios");

                }
                else{
                    llenarModeloConVista(); //Llena modelo o datos de vista
                    if(ConsultasProveedores.actualizar(ModeloProveedores)==true){
                        JOptionPane.showMessageDialog(Proveedores, "Datos actualizados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Proveedores,"No se actualizaron los datos");

                    }
                }
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
                if(validarCampos()==false){
                    JOptionPane.showMessageDialog(Proveedores,"Los campos no deben estar vacios");

                }
                else{
                    llenarModeloConVista();
                    if(ConsultasProveedores.insertar(ModeloProveedores)==true){
                        JOptionPane.showMessageDialog(Proveedores, "Datos insertados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Proveedores,"No se insertaron los datos");

                    }
                }
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
                if(Proveedores.IdProveedor.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Proveedores,"El codigo no debe estar vacio");

                }
                else{
                    llenarModeloConVista();
                    if(ConsultasProveedores.eliminar(ModeloProveedores)==true){
                        JOptionPane.showMessageDialog(Proveedores, "Datos eliminados correctamente. ");
                        limpiarCampos();
                    }else{
                        JOptionPane.showMessageDialog(Proveedores,"No se eliminaron los datos");

                    }
                }
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
                ControladorBuscarProveedores VentanaBuscar = new ControladorBuscarProveedores(ModeloProveedores);
                //llenar la vista con el modelo
                llenarVistaConModelo();
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

    private boolean validarCampos() {
        if (Proveedores.IdProveedor.getText().isEmpty()||
                Proveedores.nombre.getText().isEmpty() ||
                Proveedores.apellidoPaterno.getText().isEmpty() ||
                Proveedores.apellidoMaterno.getText().isEmpty() ||
                Proveedores.rfc.getText().isEmpty() ||
                Proveedores.telefono.getText().isEmpty() ||
                Proveedores.mail.getText().isEmpty()||
                Proveedores.estado.getText().isEmpty() ||
                Proveedores.ciudad.getText().isEmpty() ||
                Proveedores.codigoPostal.getText().isEmpty() ||
                Proveedores.colonia.getText().isEmpty() ||
                Proveedores.calle.getText().isEmpty() ||
                Proveedores.numero.getText().isEmpty())
        {
            return false; // algunos campos estan vacios
        }
        else{
            return true; //todos los campos estan llenos
        }
    }

    private void llenarModeloConVista() {
        ModeloProveedores.setIdProveedor(Integer.parseInt(Proveedores.IdProveedor.getText()));
        ModeloProveedores.setNombre(Proveedores.nombre.getText());
        ModeloProveedores.setApellidoPaterno(Proveedores.apellidoPaterno.getText());
        ModeloProveedores.setApellidoMaterno(Proveedores.apellidoMaterno.getText());
        ModeloProveedores.setRfc(Proveedores.rfc.getText());
        ModeloProveedores.setTelefono(Proveedores.telefono.getText());
        ModeloProveedores.setMail(Proveedores.mail.getText());
        ModeloProveedores.setEstado(Proveedores.estado.getText());
        ModeloProveedores.setCiudad(Proveedores.ciudad.getText());
        ModeloProveedores.setCodigoPostal(Integer.parseInt(Proveedores.codigoPostal.getText()));
        ModeloProveedores.setColonia(Proveedores.colonia.getText());
        ModeloProveedores.setCalle(Proveedores.calle.getText());
        ModeloProveedores.setNumero(Integer.parseInt(Proveedores.numero.getText()));

    }

    private void llenarVistaConModelo() {
        Proveedores.IdProveedor.setText(ModeloProveedores.getIdProveedor() +"");
        Proveedores.nombre.setText(ModeloProveedores.getNombre());
        Proveedores.apellidoPaterno.setText(ModeloProveedores.getApellidoPaterno());
        Proveedores.apellidoMaterno.setText(ModeloProveedores.getApellidoMaterno());
        Proveedores.rfc.setText(ModeloProveedores.getRfc());
        Proveedores.telefono.setText(ModeloProveedores.getTelefono()+"");
        Proveedores.mail.setText(ModeloProveedores.getMail());
        Proveedores.estado.setText(ModeloProveedores.getEstado());
        Proveedores.ciudad.setText(ModeloProveedores.getCiudad());
        Proveedores.codigoPostal.setText(ModeloProveedores.getCodigoPostal()+"");
        Proveedores.colonia.setText(ModeloProveedores.getColonia());
        Proveedores.calle.setText(ModeloProveedores.getCalle());
        Proveedores.numero.setText(ModeloProveedores.getNumero()+"");

    }

    private void oyentes(){
        Proveedores.IdProveedor.addKeyListener(this);
        Proveedores.nombre.addKeyListener(this);
        Proveedores.apellidoPaterno.addKeyListener(this);
        Proveedores.apellidoMaterno.addKeyListener(this);
        Proveedores.rfc.addKeyListener(this);
        Proveedores.telefono.addKeyListener(this);
        Proveedores.mail.addKeyListener(this);
        Proveedores.estado.addKeyListener(this);
        Proveedores.ciudad.addKeyListener(this);
        Proveedores.codigoPostal.addKeyListener(this);
        Proveedores.colonia.addKeyListener(this);
        Proveedores.calle.addKeyListener(this);
        Proveedores.numero.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource()==Proveedores.IdProveedor){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.nombre.requestFocus();
            }
        }else if(e.getSource()==Proveedores.nombre){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.apellidoPaterno.requestFocus();
            }
        }else if(e.getSource()==Proveedores.apellidoPaterno){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.apellidoMaterno.requestFocus();
            }
        }else if(e.getSource()==Proveedores.apellidoMaterno){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.rfc.requestFocus();
            }
        }else if(e.getSource()==Proveedores.rfc){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.telefono.requestFocus();
            }
        }else if (e.getSource()==Proveedores.telefono){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.mail.requestFocus();
            }
        }else if (e.getSource()==Proveedores.mail){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.estado.requestFocus();
            }
        }else if (e.getSource()==Proveedores.estado){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.ciudad.requestFocus();
            }
        }else if (e.getSource()==Proveedores.ciudad){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.codigoPostal.requestFocus();
            }
        }else if (e.getSource()==Proveedores.codigoPostal){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.colonia.requestFocus();
            }
        }else if (e.getSource()==Proveedores.colonia){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.calle.requestFocus();
            }
        }else if (e.getSource()==Proveedores.calle){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.numero.requestFocus();
            }
        }else if (e.getSource()==Proveedores.numero){
            if(e.getKeyChar()==e.VK_ENTER){
                Proveedores.guardar.requestFocus();
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
