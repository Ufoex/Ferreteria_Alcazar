package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Base extends JFrame {
//    Objetos

    //Fondo
    JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtVentas = new JLabel("Base");

    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtEmpleadoID = new JLabel("base:");
    JTextField empleadoID = new JTextField();
    JLabel txtProducto = new JLabel("base:");
    JTextField producto = new JTextField();
    JLabel txtFecha = new JLabel("base:");
    JTextField fecha = new JTextField();
    JLabel txtCantidad = new JLabel("base:");
    JTextField cantidad = new JTextField();
    JLabel txtPrecio = new JLabel("base:");
    JTextField precio = new JTextField();
    JLabel txtTotal = new JLabel("Total:");
    JTextField total = new JTextField();

    //Botones
    JButton guardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
    JButton limpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
    JButton buscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
    JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/salir.png")));
    JButton eliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
    JButton actualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));


    //jTable
    JTable tabla = new JTable();
    JScrollPane scroll = new JScrollPane();


    public Base(){
        configInicial();
        centrarVentana();
        agregarProductos();
        agregarBotones();
        agregarTabla();
        agregarListener();
    }


    private void centrarVentana() {
        //Para hacer que la ventana siempre salga a la mitad de la pantalla
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    private void configInicial() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Ferreteria Alcazar");
        //this.setSize(869,428);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo - copia.png")));
        imgFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo/fondo.png")));
        this.setContentPane(imgFondo);
        this.pack();

    }

    private void agregarProductos() {
        //Atributos de Texto Ventas
        txtVentas.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtVentas.setBounds(35,30,110,36);       //Ubicacion y tamaño
        this.add(txtVentas);

        //Atributos EmpleadoID
        //Texto
        txtEmpleadoID.setFont(new Font("Tahoma",1,12));
        txtEmpleadoID.setBounds(35,110,80,20);
        this.add(txtEmpleadoID);
        //Barra
        empleadoID.setBounds(120,110,120,20);
        this.add(empleadoID);

        //Atributos Producto
        //Texto
        txtProducto.setFont(new Font("Tahoma",1,12));
        txtProducto.setBounds(51,140,80,20);
        this.add(txtProducto);
        //Barra
        producto.setBounds(120,140,120,20);
        this.add(producto);

        //Atributos Fecha
        //Texto
        txtFecha.setFont(new Font("Tahoma",1,12));
        txtFecha.setBounds(74,170,80,20);
        this.add(txtFecha);
        //Barra
        fecha.setBounds(120,170,120,20);
        this.add(fecha);

        //Atributos Cantidad
        //Texto
        txtCantidad.setFont(new Font("Tahoma",1,12));
        txtCantidad.setBounds(54,200,80,20);
        this.add(txtCantidad);
        //Barra
        cantidad.setBounds(120,200,120,20);
        this.add(cantidad);

        //Atributos Precio
        //Texto
        txtPrecio.setFont(new Font("Tahoma",1,12));
        txtPrecio.setBounds(72,230,80,20);
        this.add(txtPrecio);
        //Barra
        precio.setBounds(120,230,120,20);
        this.add(precio);

        //Atributos Precio
        //Texto
        txtTotal.setFont(new Font("Tahoma",1,12));
        txtTotal.setBounds(78,260,80,20);
        this.add(txtTotal);
        //Barra
        total.setBounds(120,260,120,20);
        this.add(total);
    }

    private void agregarBotones(){
        //Atributos Actualizar
        this.add(actualizar);
        actualizar.setVisible(true);
        actualizar.setBounds(720,10,135,50);
        this.actualizar.setOpaque(false);
        this.actualizar.setBorder(null);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorderPainted(false);

        //Atributos Guardar
        this.add(guardar);
        guardar.setVisible(true);
        guardar.setBounds(30,350,115,50);
        this.guardar.setOpaque(false);
        this.guardar.setBorder(null);
        guardar.setContentAreaFilled(false);
        guardar.setBorderPainted(false);

        //Atributos Limpiar
        this.add(limpiar);
        limpiar.setVisible(true);
        limpiar.setBounds(150,350,115,50);
        this.limpiar.setOpaque(false);
        this.limpiar.setBorder(null);
        limpiar.setContentAreaFilled(false);
        limpiar.setBorderPainted(false);

        //Atributos Eliminar
        this.add(eliminar);
        eliminar.setVisible(true);
        eliminar.setBounds(270,350,115,50);
        this.eliminar.setOpaque(false);
        this.eliminar.setBorder(null);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorderPainted(false);

        //Atributos Buscar
        this.add(buscar);
        buscar.setVisible(true);
        buscar.setBounds(645,350,110,50);
        this.buscar.setOpaque(false);
        this.buscar.setBorder(null);
        buscar.setContentAreaFilled(false);
        buscar.setBorderPainted(false);


        //Atributos Buscar
        this.add(salir);
        salir.setVisible(true);
        salir.setBounds(760,350,90,50);
        this.salir.setOpaque(false);
        this.salir.setBorder(null);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);

    }

    private void agregarListener() {
        //Listeners del Botón Actualizar
        actualizar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                actualizar.setIcon(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));
            }
        });

        //Listeners del Botón Guardar
        guardar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarselect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                guardar.setIcon(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
            }
        });

        //Listeners del Botón Limpiar
        limpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                limpiar.setIcon(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
            }
        });

        //Listeners del Botón Eliminar
        eliminar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
            }
        });

        //Listeners del Botón Buscar
        buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscarEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buscar.setIcon(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
            }
        });

        //Listeners del Botón Salir
        salir.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/salirSelect.png")));
            }


            @Override
            public void mouseReleased(MouseEvent e) {
                salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/salir.png")));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/salirEntered.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                salir.setIcon(new ImageIcon(getClass().getResource("/imagenes/salir.png")));
            }
        });
    }

    //Por mientras no sirve :(
    private void agregarTabla(){


    }

}
