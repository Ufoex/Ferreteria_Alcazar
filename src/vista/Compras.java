package vista;

import javafx.scene.control.ComboBox;
import modelo.ConsultasCompras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Compras extends JFrame {
//    Objetos

    //Fondo
    public JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtCompras = new JLabel("Compras");

    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtIdCompras = new JLabel("ID Compra:");
    public JTextField idCompras = new JTextField();
    JLabel txtPrecioUnitario = new JLabel("Precio Unitario:");
    public JTextField precioUnitario = new JTextField();
    JLabel txtCantidadProducto = new JLabel("Cantidad De Producto:");
    public JTextField cantidadProducto = new JTextField();
    JLabel txtFecha = new JLabel("Fecha:");
    public JTextField fecha = new JTextField();
    JLabel txtTotal = new JLabel("Total:");
    public JTextField total = new JTextField();

    //Botones
    public JButton guardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
    public JButton limpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
    public JButton buscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
    public JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
    public JButton eliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
    public JButton actualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
    //public JButton cancelar = new JButton(new ImageIcon(getClass().getResource("/imagenes/cancelar.png")));
    // Para Mover la ventana

    public JComboBox SelectProductos = new JComboBox();;
    public modelo.ConsultasCompras ConsultasCompras = new ConsultasCompras();


    public Compras(){
        configInicial();
        centrarVentana();
        agregarProductos();
        agregarBotones();

    }


    private void centrarVentana() {
        //Para hacer que la ventana siempre salga a la mitad de la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    private void configInicial() {
        this.setUndecorated(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Ferreteria Alcazar");
        //this.setSize(869,428);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo - copia.png")));
        imgFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo/fondo.jpg")));
        this.setContentPane(imgFondo);
        this.pack();

    }

    private void agregarProductos() {
        //Atributos de Texto Ventas
        txtCompras.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtCompras.setBounds(40,30,150,36);       //Ubicacion y tamaño
        this.add(txtCompras);

        //Atributos ID Compras
        //Texto
        txtIdCompras.setFont(new Font("Tahoma",1,12));
        txtIdCompras.setBounds(94,110,100,20);
        this.add(txtIdCompras);
        //Barra
        idCompras.setBounds(165,110,120,20);
        this.add(idCompras);

        //Atributos Precio Unitario
        //Texto
        txtPrecioUnitario.setFont(new Font("Tahoma",1,12));
        txtPrecioUnitario.setBounds(69,140,110,20);
        this.add(txtPrecioUnitario);
        //Barra
        precioUnitario.setBounds(165,140,120,20);
        this.add(precioUnitario);

        //Atributos Cantidad De Producto
        //Texto
        txtCantidadProducto.setFont(new Font("Tahoma",1,12));
        txtCantidadProducto.setBounds(23,170,150,20);
        this.add(txtCantidadProducto);
        //Barra
        cantidadProducto.setBounds(165,170,120,20);
        this.add(cantidadProducto);

        //Atributos Fecha
        //Texto
        txtFecha.setFont(new Font("Tahoma",1,12));
        txtFecha.setBounds(125,200,80,20);
        this.add(txtFecha);
        //Barra
        fecha.setBounds(165,200,120,20);
        this.add(fecha);

        //Atributos Total
        //Texto
        txtTotal.setFont(new Font("Tahoma",1,12));
        txtTotal.setBounds(129,230,80,20);
        this.add(txtTotal);
        //Barra
        total.setBounds(165,230,120,20);

        SelectProductos.setBounds(129, 260, 120,20);
        this.add(SelectProductos);
        ConsultasCompras.getPruducts().forEach(item -> SelectProductos.addItem(item));
        SelectProductos.setVisible(true);

        this.add(total);
    }

    private void agregarBotones(){
        //Atributos Actualizar
        this.add(actualizar);
        actualizar.setVisible(true);
        actualizar.setBounds(730,350,135,50);
        this.actualizar.setOpaque(false);
        this.actualizar.setBorder(null);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorderPainted(false);
        actualizar.setFocusable(false);

        //Atributos Guardar
        this.add(guardar);
        guardar.setVisible(true);
        guardar.setBounds(30,350,115,50);
        this.guardar.setOpaque(false);
        this.guardar.setBorder(null);
        guardar.setContentAreaFilled(false);
        guardar.setBorderPainted(false);
        guardar.setFocusable(false);

        //Atributos Limpiar
        this.add(limpiar);
        limpiar.setVisible(true);
        limpiar.setBounds(150,350,115,50);
        this.limpiar.setOpaque(false);
        this.limpiar.setBorder(null);
        limpiar.setContentAreaFilled(false);
        limpiar.setBorderPainted(false);
        limpiar.setFocusable(false);

        //Atributos Eliminar
        this.add(eliminar);
        eliminar.setVisible(true);
        eliminar.setBounds(270,350,115,50);
        this.eliminar.setOpaque(false);
        this.eliminar.setBorder(null);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorderPainted(false);
        eliminar.setFocusable(false);

        //Atributos Cancelar
     /*   this.add(cancelar);
        cancelar.setVisible(true);
        cancelar.setBounds(480,350,120,50);
        this.cancelar.setOpaque(false);
        this.cancelar.setBorder(null);
        cancelar.setContentAreaFilled(false);
        cancelar.setBorderPainted(false);
        cancelar.setFocusable(false);
     */
        //Atributos Buscar
        this.add(buscar);
        buscar.setVisible(true);
        buscar.setBounds(615,350,110,50);
        this.buscar.setOpaque(false);
        this.buscar.setBorder(null);
        buscar.setContentAreaFilled(false);
        buscar.setBorderPainted(false);
        buscar.setFocusable(false);


        //Atributos Salir
        this.add(salir);
        salir.setVisible(true);
        salir.setBounds(835,4,48,48);
        this.salir.setOpaque(false);
        this.salir.setBorder(null);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        salir.setFocusable(false);

    }


}
