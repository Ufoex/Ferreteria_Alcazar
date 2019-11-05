package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Empleados extends JFrame {
//    Objetos


    //Fondo
    public JLabel imgFondo = new JLabel();
    //Texto Ventana
    JLabel txtEmpleados = new JLabel("Empleados");

    //Texto y TextField de los datos a capturar (le puse como nombre productos)
    JLabel txtNombre = new JLabel("Nombre:");
    public JTextField nombre = new JTextField();
    JLabel txtApellidoPaterno = new JLabel("Apellido paterno:");
    public JTextField apellidoPaterno = new JTextField();
    JLabel txtApellidoMaterno = new JLabel("Apellido materno:");//******************
    public JTextField apellidoMaterno = new JTextField();//********************************
    JLabel txtTelefono = new JLabel("Teléfono:");
    public JTextField telefono = new JTextField();
    JLabel txtSexo = new JLabel("Sexo (F/M):");
    public JTextField sexo = new JTextField();
    JLabel txtColonia = new JLabel("Colonia:");
    public JTextField colonia = new JTextField();
    JLabel txtCalle = new JLabel("Calle:");
    public JTextField calle = new JTextField();
    JLabel txtNumero = new JLabel("Número:");
    public JTextField numero = new JTextField();
    JLabel txtFechaIngreso = new JLabel("Fecha ingreso:");
    public JTextField fechaIngreso = new JTextField();
    JLabel txtRfc = new JLabel("RFC:");
    public JTextField rfc = new JTextField();
    JLabel txtTurno = new JLabel("Turno (M/V):");
    public JTextField turno = new JTextField();
    JLabel txtidEmpleado = new JLabel("ID Empleado:");
    public JTextField idEmpleado = new JTextField();

    //Botones
    public JButton guardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/guardar.png")));
    public JButton limpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/limpiar.png")));
    public JButton buscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/buscar.png")));
    public JButton salir = new JButton(new ImageIcon(getClass().getResource("/imagenes/clickSalir.png")));
    public JButton eliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/eliminar.png")));
    public JButton actualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/actualizar.png")));


    public Empleados(){
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
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo - copia.png")));
        imgFondo.setIcon(new ImageIcon(getClass().getResource("/imagenes/fondo/fondoEmpleados.png")));
        this.setContentPane(imgFondo);
        this.pack();

    }

    private void agregarProductos() {
        //Atributos de Texto Ventas
        txtEmpleados.setFont(new Font("Tahoma",0,36)); //Formato de la letra
        txtEmpleados.setBounds(35,30,180,36);       //Ubicacion y tamaño
        this.add(txtEmpleados);

        //Atributos ID Cargo
        //Texto
        txtidEmpleado.setFont(new Font("Tahoma",1,12));
        txtidEmpleado.setBounds(80,75,100,20);//*******************************
        this.add(txtidEmpleado);
        //Barra
        idEmpleado.setBounds(165,75,120,20); //120, 75, 120, 20
        this.add(idEmpleado);

        //Atributos Nombre
        //Texto
        txtNombre.setFont(new Font("Tahoma",1,12));
        txtNombre.setBounds(110,110,100,20); //65,105,80,20
        this.add(txtNombre);
        //Barra
        nombre.setBounds(165,110,120,20); //120,105,120,20
        this.add(nombre);

        //Atributos Apellido paterno
        //Texto
        txtApellidoPaterno.setFont(new Font("Tahoma",1,12));
        txtApellidoPaterno.setBounds(55,135,150,20);//63,135,80,20
        this.add(txtApellidoPaterno);
        //Barra
        apellidoPaterno.setBounds(165,135,120,20); //120,135,120,20 //Tamaño de la caja de texto
        this.add(apellidoPaterno);
        
        //Atributos Apellido Materno********************************************************
        //Texto
        txtApellidoMaterno.setFont(new Font("Tahoma",1,12));
        txtApellidoMaterno.setBounds(55,165,150,20);
        this.add(txtApellidoMaterno);
        //Barra
        apellidoMaterno.setBounds(165,165,120,20);
        this.add(apellidoMaterno);
        
        //Atributos Telefono
        //Texto
        txtTelefono.setFont(new Font("Tahoma",1,12));
        txtTelefono.setBounds(105,195,100,20);
        this.add(txtTelefono);
        //Barra
        telefono.setBounds(165,195,120,20);
        this.add(telefono);

        //Atributos Sexo
        //Texto
        txtSexo.setFont(new Font("Tahoma",1,12));
        txtSexo.setBounds(90,225,80,20);
        this.add(txtSexo);
        //Barra
        sexo.setBounds(165,225,120,20);
        this.add(sexo);

        //Atributos Fecha de Ingreso
        //Texto
        txtFechaIngreso.setFont(new Font("Tahoma",1,12));
        txtFechaIngreso.setBounds(75,255,120,20);
        this.add(txtFechaIngreso);
        //Barra
        fechaIngreso.setBounds(165,255,120,20);
        this.add(fechaIngreso);

        //Atributos Fecha de RFC
        //Texto
        txtRfc.setFont(new Font("Tahoma",1,12));
        txtRfc.setBounds(135,285,120,20);
        this.add(txtRfc);
        //Barra
        rfc.setBounds(165,285,120,20);
        this.add(rfc);

        //Atributos Fecha de Turno
        //Texto
        txtTurno.setFont(new Font("Tahoma",1,12));
        txtTurno.setBounds(80,315,120,20);
        this.add(txtTurno);
        //Barra
        turno.setBounds(165,315,120,20);
        this.add(turno);
        
        //Atributos Colonia
        //Texto
        txtColonia.setFont(new Font("Tahoma",1,12));
        txtColonia.setBounds(115,345,80,20);
        this.add(txtColonia);
        //Barra
        colonia.setBounds(165,345,120,20);
        this.add(colonia);
        
        //Atributos Calle
        //Texto
        txtCalle.setFont(new Font("Tahoma",1,12));
        txtCalle.setBounds(130,375,80,20);
        this.add(txtCalle);
        //Barra
        calle.setBounds(165,375,120,20);
        this.add(calle);
        
        //Atributos Numero
        //Texto
        txtNumero.setFont(new Font("Tahoma",1,12));
        txtNumero.setBounds(110,405,80,20);
        this.add(txtNumero);
        //Barra
        numero.setBounds(165,405,120,20);
        this.add(numero);
    }

    private void agregarBotones(){
        //Atributos Actualizar
        this.add(actualizar);
        actualizar.setVisible(true);
        actualizar.setBounds(600,450,135,50);
        this.actualizar.setOpaque(false);
        this.actualizar.setBorder(null);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorderPainted(false);
        actualizar.setFocusable(false);

        //Atributos Guardar
        this.add(guardar);
        guardar.setVisible(true);
        guardar.setBounds(30,450,115,50);
        this.guardar.setOpaque(false);
        this.guardar.setBorder(null);
        guardar.setContentAreaFilled(false);
        guardar.setBorderPainted(false);
        guardar.setFocusable(false);

        //Atributos Limpiar
        this.add(limpiar);
        limpiar.setVisible(true);
        limpiar.setBounds(150,450,115,50);
        this.limpiar.setOpaque(false);
        this.limpiar.setBorder(null);
        limpiar.setContentAreaFilled(false);
        limpiar.setBorderPainted(false);
        limpiar.setFocusable(false);

        //Actributos Eliminar
        this.add(eliminar);
        eliminar.setVisible(true);
        eliminar.setBounds(270,450,115,50);
        this.eliminar.setOpaque(false);
        this.eliminar.setBorder(null);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorderPainted(false);
        eliminar.setFocusable(false);

        //Atributos Buscar
        this.add(buscar);
        buscar.setVisible(true);
        buscar.setBounds(745,450,110,50);
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
