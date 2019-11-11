package vista;

import javax.swing.*;
import java.awt.*;

public class Productos extends JFrame {
//    Objetos

    //Fondo
    public JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtProductos = new JLabel("Productos");


    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtIdProductos = new JLabel("ID Producto:");
    public JTextField idProductos = new JTextField();
    JLabel txtNombre = new JLabel("Nombre:");
    public JTextField nombre = new JTextField();
    JLabel txtMarca = new JLabel("Marca:");
    public JTextField marca = new JTextField();
    JLabel txtPrecioUnitario = new JLabel("Precio Unitario:");
    public JTextField precioUnitario = new JTextField();
    JLabel txtStock = new JLabel("Stock:");
    public JTextField stock = new JTextField();
    JLabel txtCategoria = new JLabel("Categoría:");
    public JTextField categoria = new JTextField();

    //Botones
    public JButton guardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
    public JButton limpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
    public JButton buscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
    public JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
    public JButton eliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
    public JButton actualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));

    // Para Mover la ventana
    int x,y;

    public Productos(){
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
        //Atributos de Texto Productos
        txtProductos.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtProductos.setBounds(35,30,160,36);       //Ubicacion y tamaño
        this.add(txtProductos);

        //Atributos ID Producto
        //Texto
        txtIdProductos.setFont(new Font("Tahoma",1,12));
        txtIdProductos.setBounds(35,110,80,20);
        this.add(txtIdProductos);
        //Barra
        idProductos.setBounds(120,110,120,20);
        this.add(idProductos);

        //Atributos Nombre
        //Texto
        txtNombre.setFont(new Font("Tahoma",1,12));
        txtNombre.setBounds(65,140,80,20);
        this.add(txtNombre);
        //Barra
        nombre.setBounds(120,140,120,20);
        this.add(nombre);

        //Atributos Marca
        //Texto
        txtMarca.setFont(new Font("Tahoma",1,12));
        txtMarca.setBounds(75,170,80,20);
        this.add(txtMarca);
        //Barra
        marca.setBounds(120,170,120,20);
        this.add(marca);

        //Atributos Precio Unitario
        //Texto
        txtPrecioUnitario.setFont(new Font("Tahoma",1,12));
        txtPrecioUnitario.setBounds(23,200,130,20);
        this.add(txtPrecioUnitario);
        //Barra
        precioUnitario.setBounds(120,200,120,20);
        this.add(precioUnitario);

        //Atributos Stock
        //Texto
        txtStock.setFont(new Font("Tahoma",1,12));
        txtStock.setBounds(74,230,80,20);
        this.add(txtStock);
        //Barra
        stock.setBounds(120,230,120,20);
        this.add(stock);

        //Atributos Categoria
        //Texto
        txtCategoria.setFont(new Font("Tahoma",1,12));
        txtCategoria.setBounds(52,260,80,20);
        this.add(txtCategoria);
        //Barra
        categoria.setBounds(120,260,120,20);
        this.add(categoria);
    }

    private void agregarBotones(){
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

        //Atributos Actualizar
        this.add(actualizar);
        actualizar.setVisible(true);
        actualizar.setBounds(510,350,130,50);
        this.actualizar.setOpaque(false);
        this.actualizar.setBorder(null);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorderPainted(false);
        actualizar.setFocusable(false);

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