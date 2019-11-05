/*

 */
package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author miria
 */
public class VistaLogin extends JFrame {
    public ImageIcon Eye = new ImageIcon(getClass().getResource("/imagenes/eye.png"));
    public ImageIcon EyeOff = new ImageIcon(getClass().getResource("/imagenes/eyeoff.png"));
    ImageIcon User = new ImageIcon(getClass().getResource("/imagenes/user.png"));
    ImageIcon Password = new ImageIcon(getClass().getResource("/imagenes/password.png"));
    
    public JTextField TxtUsuario = new JTextField();
    public JPasswordField TxtPassword = new JPasswordField();
    
    JLabel LblUsuario = new JLabel(User);
    JLabel LblPassword = new JLabel(Password);
    public JLabel LblEye = new JLabel(Eye);
    public JButton  BtnLogin = new JButton("Login");
    public JButton BtnCerrar = new JButton("Salir");/////////////////////////////////////////////////
    JLabel LblRecuerdame = new JLabel ("Remember me ");
    public JCheckBox CbRecuerdame = new JCheckBox();
    
    
    public VistaLogin() {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Login");       
        this.getContentPane().setBackground(new Color (220, 220, 220));
        this.setSize(500, 400);
        this.agregarComponentes();            
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    private void agregarComponentes() {
        this.LblUsuario.setBounds(10, 20, 100, 100);
        this.TxtUsuario.setBounds(110, 45, 300, 40);
        this.TxtPassword.setBounds(110, 125, 235, 40);
        this.LblPassword.setBounds(10, 100, 100, 100);
        this.LblEye.setBounds(330, 100, 100, 100);
        this.BtnLogin.setBounds(175, 230, 140, 40);
        this.BtnLogin.setBackground(new Color (100, 181, 246));
        this.BtnLogin.setForeground(Color.BLACK);
        this.LblRecuerdame.setBounds(110, 170, 150, 50);
        this.CbRecuerdame.setBounds(200, 185, 20, 20);
        this.BtnCerrar.setBounds(175, 280, 140, 40);//////////////////////////////////////////////
        this.BtnCerrar.setBackground(new Color (100, 181, 246));/////////////////////////////////
        this.BtnCerrar.setForeground(Color.BLACK);///////////////////////////////////////////////
        
        this.add(TxtUsuario);
        this.add(TxtPassword);
        this.add(LblUsuario);
        this.add(LblPassword);
        this.add(BtnLogin);
        this.add(LblRecuerdame);
        this.add(CbRecuerdame);
        this.add(LblEye);
        this.add(BtnCerrar);//////////////////////////////////////////////////////////////////////
    }
}
