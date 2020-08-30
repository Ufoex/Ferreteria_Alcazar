/*

 */
package controlador;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaLogin;


public class ControladorVistaLogin implements MouseListener {
     // crear el Objeto modelo y el objeto vista

    VistaLogin VistaLogin = new VistaLogin();
    ModeloUsuario ModeloUsuario = new ModeloUsuario();
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();
    //Bandera para saber si escribio mal un usuario o no ha puesto usuario
    int bandera=0;

    public ControladorVistaLogin() {
        VistaLogin.setVisible(true);
        VistaLogin.BtnLogin.requestFocus(); // Sirve para que se auto seleccione un boton o textfield (solo se selecciona pero no presiona)
        VistaLogin.TxtUsuario.setFocusTraversalKeysEnabled(false); //Sirve para que se desabiliten las funciones preterminadas de TAB, SHIFT, etc y puedan funcionar en el KeyListener
        oyentes();
        VistaLogin.TxtPassword.setEchoChar((char)0);
        //Sirve Para que el boton login sea el default
        JRootPane rootPane = SwingUtilities.getRootPane(VistaLogin.BtnLogin);
        rootPane.setDefaultButton(VistaLogin.BtnLogin);

    }

    private void oyentes() {

        VistaLogin.BtnLogin.addMouseListener(this);
        VistaLogin.LblEye.addMouseListener(this);
        VistaLogin.TxtPassword.addMouseListener(this);
        VistaLogin.TxtUsuario.addMouseListener(this);
        VistaLogin.BtnCerrar.addMouseListener(this);

        VistaLogin.TxtUsuario.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()== KeyEvent.VK_TAB || e.getKeyChar()==e.VK_ENTER) {
                    VistaLogin.TxtPassword.setText("");
                    VistaLogin.TxtPassword.setEchoChar('*');
                    VistaLogin.TxtPassword.requestFocus();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        //Sirve para que al precionar Enter se le de click al boton
        VistaLogin.TxtPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()== KeyEvent.VK_ENTER){
                    ClickBotonUsuario();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        VistaLogin.BtnLogin.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()== KeyEvent.VK_ENTER){
                    ClickBotonUsuario();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }


    @Override
    public void mouseClicked(MouseEvent me) {

         if (me.getSource() == VistaLogin.BtnLogin){
             ClickBotonUsuario();
         }
         if (me.getSource() == VistaLogin.TxtUsuario){
             if (" Usuario...".equals(VistaLogin.TxtUsuario.getText())){
                 VistaLogin.TxtUsuario.setText("");
             }
         }else if (me.getSource() == VistaLogin.TxtPassword){
             if (" Contraseña".equals(VistaLogin.TxtPassword.getText())){
                 VistaLogin.TxtPassword.setText("");
                 VistaLogin.TxtPassword.setEchoChar('*');
             }
         }

        if (me.getSource() == VistaLogin.LblEye) {
            VistaLogin.LblEye.setIcon(VistaLogin.EyeOff);
            VistaLogin.TxtPassword.setEchoChar('*');
        }

        if(me.getSource()==VistaLogin.BtnCerrar){
            int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir del sistema?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc == JOptionPane.YES_OPTION) {
                System.exit(0);



            }
        }
    }



    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() == VistaLogin.LblEye) {
            VistaLogin.LblEye.setIcon(VistaLogin.Eye);
            VistaLogin.TxtPassword.setEchoChar((char)0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void LlenarDatosDeModelo() throws NoSuchAlgorithmException {
        
        // llenal el modelo con los datos del formulario 
        
        ModeloUsuario.setUsuario(VistaLogin.TxtUsuario.getText());
        
        String Pas = new String(VistaLogin.TxtPassword.getPassword());
        
        //solo para ver cual es el usuario incriptado
        System.out.println(encriptarPassword(Pas));
        
        ModeloUsuario.setPassword(encriptarPassword(Pas));
        
    }
    
    private boolean validarCampos(){
        if (VistaLogin.TxtUsuario.getText().isEmpty() || VistaLogin.TxtPassword.getPassword().length == 0) {
            return false;   
        }else{
            return true;
        }      
    }
    
    //METODO PARA ENCRIPTAR PASSWORD (MD5)
    //Recibe un password sin encriptar y retorna y password incriptado
    private String encriptarPassword(String SinEncriptar) throws NoSuchAlgorithmException{
        MessageDigest Md = MessageDigest.getInstance("MD5");
        Md.update(SinEncriptar.getBytes(),0,SinEncriptar.length());
        return new BigInteger(1,Md.digest()).toString(16);

    }

    private void ClickBotonUsuario(){
        bandera=0;
        if (validarCampos() ==  false) {
            JOptionPane.showMessageDialog(null, "Se deben llenar los campos", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{try {
            //los campos vacios
            LlenarDatosDeModelo();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControladorVistaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

            if (VistaLogin.TxtUsuario.getText().equals(" Usuario...") || VistaLogin.TxtPassword.getText().equals(" Contraseña")) {
                bandera=1;
            }

            if (bandera==1) {
                JOptionPane.showMessageDialog(null, "Escriba un Usuario y su Contraseña" );
            }else {
                if (ConsultasUsuario.buscar(ModeloUsuario) == false) {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
                } else {
                    JOptionPane.showMessageDialog(null, "Bienvenid@ al Sistema " + ModeloUsuario.getNombre(), ModeloUsuario.getUsuario(), 1);
                    ControladorVistaMenu ControladorPantallaPrincipal = new ControladorVistaMenu();
                    this.VistaLogin.dispose();

                }
            }
        }
    }


}



