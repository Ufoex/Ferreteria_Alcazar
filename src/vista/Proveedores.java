package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Proveedores extends JFrame {
//    Objetos

    //Fondo
    public JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtProveedores = new JLabel("Proveedores");

    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtIdProveedor = new JLabel("ID Proveedor:");
    public JTextField IdProveedor = new JTextField();
    JLabel txtNombre = new JLabel("Nombre:");
    public JTextField nombre = new JTextField();
    JLabel txtApellidoPaterno = new JLabel("Apellido Paterno:");
    public JTextField apellidoPaterno = new JTextField();
    JLabel txtApellidoMaterno = new JLabel("Apellido Materno:");
    public JTextField apellidoMaterno = new JTextField();
    JLabel txtRfc = new JLabel("RFC:");
    public JTextField rfc = new JTextField();
    JLabel txtTelefono = new JLabel("Teléfono:");
    public JTextField telefono = new JTextField();
    JLabel txtMail = new JLabel("Mail:");
    public JTextField mail = new JTextField();
    JLabel txtEstado = new JLabel("Estado:");
    public JTextField estado = new JTextField();
    JLabel txtCiudad = new JLabel("Ciudad:");
    public JTextField ciudad = new JTextField();
    JLabel txtCodigoPostal = new JLabel("Código Postal:");
    public JTextField codigoPostal = new JTextField();
    JLabel txtColonia = new JLabel("Colonia:");
    public JTextField colonia = new JTextField();
    JLabel txtCalle = new JLabel("Calle:");
    public JTextField calle = new JTextField();
    JLabel txtNumero = new JLabel("Nùmero:");
    public JTextField numero = new JTextField();

    //Botones
    public JButton guardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
    public JButton limpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
    public JButton buscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
    public JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
    public JButton eliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
    public JButton actualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));


    //Tabla
    JTable tabla = new JTable();
    JScrollPane scroll = new JScrollPane();


    public Proveedores(){
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
        imgFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo/fondoProveedores.png")));
        this.setContentPane(imgFondo);
        this.pack();

    }

    private void agregarProductos() {
        //Atributos de Texto Proveedores
        txtProveedores.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtProveedores.setBounds(55,30,200,36);       //Ubicacion y tamaño
        this.add(txtProveedores);

        //Atributos ID Proveedores
        //Texto
        txtIdProveedor.setFont(new Font("Tahoma",1,12));
        txtIdProveedor.setBounds(51,110,120,20);
        this.add(txtIdProveedor);
        //Barra
        IdProveedor.setBounds(140,110,120,20);
        this.add(IdProveedor);

        //Atributos Nombre
        //Texto
        txtNombre.setFont(new Font("Tahoma",1,12));
        txtNombre.setBounds(85,140,80,20);
        this.add(txtNombre);
        //Barra
        nombre.setBounds(140,140,120,20);
        this.add(nombre);

        //Atributos Apellido Paterno
        //Texto
        txtApellidoPaterno.setFont(new Font("Tahoma",1,12));
        txtApellidoPaterno.setBounds(31,170,1200,20);
        this.add(txtApellidoPaterno);
        //Barra
        apellidoPaterno.setBounds(140,170,120,20);
        this.add(apellidoPaterno);

        //Atributos Apellido Materno
        //Texto
        txtApellidoMaterno.setFont(new Font("Tahoma",1,12));
        txtApellidoMaterno.setBounds(29,200,120,20);
        this.add(txtApellidoMaterno);
        //Barra
        apellidoMaterno.setBounds(140,200,120,20);
        this.add(apellidoMaterno);

        //Atributos RFC
        //Texto
        txtRfc.setFont(new Font("Tahoma",1,12));
        txtRfc.setBounds(109,230,80,20);
        this.add(txtRfc);
        //Barra
        rfc.setBounds(140,230,120,20);
        this.add(rfc);

        //Atributos Telefono
        //Texto
        txtTelefono.setFont(new Font("Tahoma",1,12));
        txtTelefono.setBounds(79,260,80,20);
        this.add(txtTelefono);
        //Barra
        telefono.setBounds(140,260,120,20);
        this.add(telefono);

        //Atributos mail
        //Texto
        txtMail.setFont(new Font("Tahoma",1,12));
        txtMail.setBounds(108,290,80,20);
        this.add(txtMail);
        //Barra
        mail.setBounds(140,290,120,20);
        this.add(mail);

        //Atributos Estado
        //Texto
        txtEstado.setFont(new Font("Tahoma",1,12));
        txtEstado.setBounds(90,320,80,20);
        this.add(txtEstado);
        //Barra
        estado.setBounds(140,320,120,20);
        this.add(estado);

        //Atributos Ciudad
        //Texto
        txtCiudad.setFont(new Font("Tahoma",1,12));
        txtCiudad.setBounds(90,350,80,20);
        this.add(txtCiudad);
        //Barra
        ciudad.setBounds(140,350,120,20);
        this.add(ciudad);

        //Atributos Codigo Postal
        //Texto
        txtCodigoPostal.setFont(new Font("Tahoma",1,12));
        txtCodigoPostal.setBounds(48,380,120,20);
        this.add(txtCodigoPostal);
        //Barra
        codigoPostal.setBounds(140,380,120,20);
        this.add(codigoPostal);

        //Atributos Colonia
        //Texto
        txtColonia.setFont(new Font("Tahoma",1,12));
        txtColonia.setBounds(87,410,80,20);
        this.add(txtColonia);
        //Barra
        colonia.setBounds(140,410,120,20);
        this.add(colonia);

        //Atributos Calle
        //Texto
        txtCalle.setFont(new Font("Tahoma",1,12));
        txtCalle.setBounds(107,440,80,20);
        this.add(txtCalle);
        //Barra
        calle.setBounds(140,440,120,20);
        this.add(calle);

        //Atributos Numero
        //Texto
        txtNumero.setFont(new Font("Tahoma",1,12));
        txtNumero.setBounds(85,470,80,20);
        this.add(txtNumero);
        //Barra
        numero.setBounds(140,470,120,20);
        this.add(numero);
    }

    private void agregarBotones(){
        //Atributos Actualizar
        this.add(actualizar);
        actualizar.setVisible(true);
        actualizar.setBounds(600,510,135,50);
        this.actualizar.setOpaque(false);
        this.actualizar.setBorder(null);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorderPainted(false);
        actualizar.setFocusable(false);

        //Atributos Guardar
        this.add(guardar);
        guardar.setVisible(true);
        guardar.setBounds(30,510,115,50);
        this.guardar.setOpaque(false);
        this.guardar.setBorder(null);
        guardar.setContentAreaFilled(false);
        guardar.setBorderPainted(false);
        guardar.setFocusable(false);

        //Atributos Limpiar
        this.add(limpiar);
        limpiar.setVisible(true);
        limpiar.setBounds(150,510,115,50);
        this.limpiar.setOpaque(false);
        this.limpiar.setBorder(null);
        limpiar.setContentAreaFilled(false);
        limpiar.setBorderPainted(false);
        limpiar.setFocusable(false);

        //Actributos Eliminar
        this.add(eliminar);
        eliminar.setVisible(true);
        eliminar.setBounds(270,510,115,50);
        this.eliminar.setOpaque(false);
        this.eliminar.setBorder(null);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorderPainted(false);
        eliminar.setFocusable(false);

        //Atributos Buscar
        this.add(buscar);
        buscar.setVisible(true);
        buscar.setBounds(745,510,110,50);
        this.buscar.setOpaque(false);
        this.buscar.setBorder(null);
        buscar.setContentAreaFilled(false);
        buscar.setBorderPainted(false);
        buscar.setFocusable(false);


        //Atributos Salir
        this.add(salir);
        salir.setVisible(true);
        salir.setBounds(835,6,48,48);
        this.salir.setOpaque(false);
        this.salir.setBorder(null);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        salir.setFocusable(false);

    }
}
