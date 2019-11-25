package vista;

import javax.swing.*;
import java.awt.*;

public class Ventas extends JFrame {
//  Objetos

    //Fondo
    public JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtVentas = new JLabel("Ventas");

    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtIdProducto = new JLabel("ID Producto:");
    public JTextField IdProducto = new JTextField();
    JLabel txtFecha = new JLabel("Fecha:");
    public JTextField fecha = new JTextField();
    JLabel txtCantidad = new JLabel("Cantidad:");
    public JTextField cantidad = new JTextField();
    JLabel txtPrecio = new JLabel("Precio:");
    public JTextField precio = new JTextField();
    JLabel txtTotal = new JLabel("Total:");
    public JTextField total = new JTextField();
    JLabel txtIdVentas = new JLabel ("ID Ventas:");
    public JTextField IdVentas = new JTextField();

    //Botones
    public JButton guardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
    public JButton limpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
    public JButton buscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
    public JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
    public JButton eliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
    public JButton actualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));


    public Ventas(){
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
        txtVentas.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtVentas.setBounds(35,30,110,36);       //Ubicacion y tamaño
        this.add(txtVentas);

        //Atributos ID Ventas
        //Texto
        txtIdVentas.setFont(new Font("Tahoma",1,12));
        txtIdVentas.setBounds(51,110,100,20);
        this.add(txtIdVentas);
        //Barra
        IdVentas.setBounds(120,110,120,20);
        this.add(IdVentas);

        //Atributos Fecha
        //Texto
        txtFecha.setFont(new Font("Tahoma",1,12));
        txtFecha.setBounds(74,140,80,20);
        this.add(txtFecha);
        //Barra
        fecha.setBounds(120,140,120,20);
        this.add(fecha);

        //Atributos Cantidad
        //Texto
        txtCantidad.setFont(new Font("Tahoma",1,12));
        txtCantidad.setBounds(54,170,80,20);
        this.add(txtCantidad);
        //Barra
        cantidad.setBounds(120,170,120,20);
        this.add(cantidad);

        //Atributos Precio
        //Texto
        txtPrecio.setFont(new Font("Tahoma",1,12));
        txtPrecio.setBounds(72,200,80,20);
        this.add(txtPrecio);
        //Barra
        precio.setBounds(120,200,120,20);
        this.add(precio);

        //Atributos Total
        //Texto
        txtTotal.setFont(new Font("Tahoma",1,12));
        txtTotal.setBounds(78,230,80,20);
        this.add(txtTotal);
        //Barra
        total.setBounds(120,230,120,20);
        this.add(total);
        //Atributos idproducto 
        //Texto
        txtIdProducto.setFont(new Font("Tahoma",1,12));
        txtIdProducto.setBounds(31,260,80,20);
        this.add(txtIdProducto);
        //Barra
        IdProducto.setBounds(120,260,120,20);
        this.add(IdProducto);
    }

    private void agregarBotones(){
        //Atributos Actualizar
        this.add(actualizar);
        actualizar.setVisible(true);
        actualizar.setBounds(510,350,130,50);
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

        //Atributos Buscar
        this.add(buscar);
        buscar.setVisible(true);
        buscar.setBounds(645,350,110,50);
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
