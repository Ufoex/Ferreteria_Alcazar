/*
Imagen de arranque en movimiento
 */
package vista;

import controlador.ControladorVistaLogin;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Splash extends JFrame implements MouseListener, MouseMotionListener{
    ImageIcon ImGif = new ImageIcon(getClass().getResource("/imagenes/splash/Splash.gif"));
    JLabel LblImagen = new JLabel(ImGif);
    int x, y; //variables para detectar la ubicacion de la etiqueta
    public Splash(){
        configInicial();
        agregarEtiquetas();
        agregarOyentes();       
        this.setVisible(true);
        //Matar al dato
        matarSplash();
        
    }

    private void configInicial() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImGif.getIconWidth(), ImGif.getIconHeight());        
        this.setLocationRelativeTo(null);
        //Quitar el decorado del JFrame
        this.setUndecorated(true);
        //Dejar solo lo transparente
        this.setBackground(new Color(0, 0, 0, 0));

        //Hacer que no se quite la imagen mientras trabajo
        this.setAlwaysOnTop(true);
        
    }

    private void agregarEtiquetas() {
        this.add(LblImagen);

    }

    private void agregarOyentes() {
        //Crear oyentes del Mouse
        LblImagen.addMouseListener(this);
        //Crear oyente para el MouseMotion
        LblImagen.addMouseMotionListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == LblImagen) {
            x = e.getX();
            y = e.getY();           
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == LblImagen){
            LblImagen.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(e.getSource() == LblImagen){
            this.setLocation(this.getLocation().x+e.getX()-x, 
                             this.getLocation().y+e.getY()-y);        
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private void matarSplash() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();//Liberando memoria (cierra el Splash).
        ControladorVistaLogin controlador = new ControladorVistaLogin();
    }
    
}
