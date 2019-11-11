package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame {
//    Objetos

    //Fondo
    public JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtMenu = new JLabel("Menú");

    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtEmpleados = new JLabel("Empleados");
    JLabel txtProveedores = new JLabel("Proveedores");
    JLabel txtVentas = new JLabel("Ventas");
    JLabel txtCompras = new JLabel("Compras");
    JLabel txtProductos = new JLabel("Productos");


    //Botones
    public JButton empleados = new JButton(new ImageIcon(getClass().getResource("/imagenes/menu/empleado.png")));
    public JButton proveedores = new JButton(new ImageIcon(getClass().getResource("/imagenes/menu/proveedor.png")));
    public JButton ventas = new JButton(new ImageIcon(getClass().getResource("/imagenes/menu/ventas.png")));
    public JButton compras = new JButton(new ImageIcon(getClass().getResource("/imagenes/menu/compras.png")));
    public JButton productos = new JButton(new ImageIcon(getClass().getResource("/imagenes/menu/productos.png")));
    public JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));


    public Menu(){
        configInicial();
        centrarVentana();
        agregarTextos();
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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Ferreteria Alcazar");
        //this.setSize(869,428);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo - copia.png")));
        imgFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo/fondoMenu.jpg")));
        this.setContentPane(imgFondo);
        this.pack();

    }

    private void agregarTextos() {
        //Atributos de Texto Menu
        txtMenu.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtMenu.setBounds(390,10,90,36);       //Ubicacion y tamaño
        this.add(txtMenu);

        //Atributos Empleados
        //Texto
        txtEmpleados.setFont(new Font("Tahoma",1,16));
        txtEmpleados.setBounds(72,210,100,20);
        this.add(txtEmpleados);

        //Atributos Proveedores
        //Texto
        txtProveedores.setFont(new Font("Tahoma",1,16));
        txtProveedores.setBounds(232,210,120,20);
        this.add(txtProveedores);

        //Atributos Productos
        //Texto
        txtProductos.setFont(new Font("Tahoma",1,16));
        txtProductos.setBounds(392,210,120,20);
        this.add(txtProductos);

        //Atributos Ventas
        //Texto
        txtVentas.setFont(new Font("Tahoma",1,16));
        txtVentas.setBounds(57,440,120,15);
        this.add(txtVentas);


        //Atributos Compras
        //Texto
        txtCompras.setFont(new Font("Tahoma",1,16));
        txtCompras.setBounds(217,440,120,15);
        this.add(txtCompras);


    }

    private void agregarBotones(){

        //Atributos Empleados
        this.add(empleados);
        empleados.setVisible(true);
        empleados.setBounds(30,50,175,161);
        this.empleados.setOpaque(false);
        this.empleados.setBorder(null);
        empleados.setContentAreaFilled(false);
        empleados.setBorderPainted(false);
        empleados.setFocusable(false);

        //Atributos Proveedores
        this.add(proveedores);
        proveedores.setVisible(true);
        proveedores.setBounds(190,50,175,161);
        this.proveedores.setOpaque(false);
        this.proveedores.setBorder(null);
        proveedores.setContentAreaFilled(false);
        proveedores.setBorderPainted(false);
        proveedores.setFocusable(false);

        //Atributos Productos
        this.add(productos);
        productos.setVisible(true);
        productos.setBounds(350,50,175,161);
        this.productos.setOpaque(false);
        this.productos.setBorder(null);
        productos.setContentAreaFilled(false);
        productos.setBorderPainted(false);
        productos.setFocusable(false);

        //Atributos Ventas
        this.add(ventas);
        ventas.setVisible(true);
        ventas.setBounds(10,270,175,161);
        this.ventas.setOpaque(false);
        this.ventas.setBorder(null);
        ventas.setContentAreaFilled(false);
        ventas.setBorderPainted(false);
        ventas.setFocusable(false);


        //Atributos Compras
        this.add(compras);
        compras.setVisible(true);
        compras.setBounds(170,270,175,161);
        this.compras.setOpaque(false);
        this.compras.setBorder(null);
        compras.setContentAreaFilled(false);
        compras.setBorderPainted(false);
        compras.setFocusable(false);

        //Atributos Salir
        this.add(salir);
        salir.setVisible(true);
        salir.setBounds(834,5,48,48);
        this.salir.setOpaque(false);
        this.salir.setBorder(null);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        salir.setFocusable(false);

    }

}
