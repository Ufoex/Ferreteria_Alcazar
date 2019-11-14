/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 *
 * @author miria
 */
public class TablaProducto extends Dialog{
    //Imagen de fondo
    public JLabel imgFondo = new JLabel();
    
    JLabel LblProductoBuscar = new JLabel("Producto a buscar");
    public JTextField TxtProductoBuscar = new JTextField();
    public JButton BtnAceptar = new JButton("Aceptar");
    public JTable Tabla =  new JTable();
    public JScrollPane ScrollTabla = new JScrollPane(Tabla);

    public TablaProducto(Frame owner, boolean modal) {
        super(owner, modal);
        configIni();
        agregarCamposTexto();
        agregarEtiquetas();       
        agregarBotones();
        agregarTabla();
        
        //this.setVisible(true); //ya no va
    }

    private void configIni() {
        this.setSize(630, 330);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setUndecorated(true);
    }

    private void agregarCamposTexto() {
        TxtProductoBuscar.setBounds(130,25,150,30);
        this.add(TxtProductoBuscar);
        
    }

    private void agregarEtiquetas() {
        LblProductoBuscar.setBounds(10,15,150,40);
        this.add(LblProductoBuscar);
    }

    private void agregarBotones() {
        BtnAceptar.setBounds(250, 260, 130, 40);
        this.add(BtnAceptar);
        this.BtnAceptar.setBackground(new Color (251, 222, 101));
    }

    private void agregarTabla() {
        ScrollTabla.setBounds(30, 70, 570, 180); //20, 70, 370, 130
        this.add(ScrollTabla);
    }
    
    

   
    
}
    

