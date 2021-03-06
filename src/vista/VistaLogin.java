/*

 */
package vista;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class VistaLogin extends JFrame {
    public ImageIcon EyeOff = new ImageIcon(getClass().getResource("/imagenes/eye.png"));
    public ImageIcon Eye = new ImageIcon(getClass().getResource("/imagenes/eyeoff.png"));

    //TextField (Barras)
    public JTextField TxtUsuario = new JTextField(" Usuario...");
    public JPasswordField TxtPassword = new JPasswordField(" Contraseña");

    //Objetos Texto
    public JLabel ImagenUsuario = new JLabel(new ImageIcon(getClass().getResource("/imagenes/userIcon.png")));
    JLabel LblUsuario = new JLabel(new ImageIcon(getClass().getResource("/imagenes/user.png")));
    JLabel LblPassword = new JLabel(new ImageIcon(getClass().getResource("/imagenes/password.png")));
    public JLabel LblEye = new JLabel(Eye);
    JLabel LblLogin = new JLabel("Login");

    //Botones
    public JButton BtnLogin = new JButton(new ImageIcon(getClass().getResource("/imagenes/login.png")));
    public JButton BtnCerrar = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));/////////////////////////////////////////////////



    public VistaLogin() {
        configIni();
        agregarComponentes();
    }

    public void configIni(){
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color (43, 112, 249, 255));
        this.setSize(500, 480);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/icono.jpg")));

    }

    private void agregarComponentes() {
        //Usuario
        //Barra
        this.TxtUsuario.setBounds(150, 200, 200, 30);
        this.TxtUsuario.setVisible(true);
        this.TxtUsuario.setBackground(new Color(35, 123, 249));
        this.TxtUsuario.setForeground(Color.black);
        this.TxtUsuario.setCaretColor(Color.black);
        this.add(TxtUsuario);
        //Texto
        this.LblUsuario.setBounds(127, 205, 24, 24);
        this.LblUsuario.setVisible(true);
        this.add(LblUsuario);

        //Password
        //Barra de Password
        this.TxtPassword.setBounds(150, 270, 200, 30);
        this.TxtPassword.setVisible(true);
        this.TxtPassword.setForeground(Color.black);
        this.TxtPassword.setCaretColor(Color.black);
        this.TxtPassword.setBackground(new Color(43, 112, 249));
        this.add(TxtPassword);
        //Texto
        this.LblPassword.setBounds(127, 272, 24, 24);
        this.LblPassword.setVisible(true);
        this.add(LblPassword);

        //Boton de Ojo mostrar
        this.LblEye.setBounds(355, 272, 24, 26);
        this.LblEye.setVisible(true);
        this.add(LblEye);

        //Boton de Login
        //Boton
        this.BtnLogin.setBounds(325, 310, 40, 40);
        this.BtnLogin.setVisible(true);
        this.BtnLogin.setOpaque(false);
        this.BtnLogin.setBorder(null);
        BtnLogin.setContentAreaFilled(false);
        BtnLogin.setBorderPainted(false);
        this.BtnLogin.setForeground(Color.BLACK);
        this.add(BtnLogin);
        //Texto
        LblLogin.setBounds(285, 310, 50, 24);
        this.LblLogin.setVisible(true);
        this.add(LblLogin);

        //Boton Salir
        BtnCerrar.setBounds(432, 10, 48, 48);
        this.BtnCerrar.setVisible(true);
        this.BtnCerrar.setOpaque(false);
        this.BtnCerrar.setBorder(null);
        BtnCerrar.setContentAreaFilled(false);
        BtnCerrar.setBorderPainted(false);
        BtnCerrar.setFocusable(false);
        this.add(BtnCerrar);

        //Imagen de Usuario en login
        this.ImagenUsuario.setBounds(175, 30, 150, 150);
        this.ImagenUsuario.setVisible(true);
        this.add(ImagenUsuario);
    }
}
