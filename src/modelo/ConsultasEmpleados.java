
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultasEmpleados extends Conexion{
    //insertar datos a Ventas
    public boolean insertar(ModeloEmpleados Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "insert into empleado (idempleado, nombre, apellido_paterno, apellido_materno, telefono, sexo, fecha_ingreso, rfc, turno, colonia, calle, numero) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdEmpleado());
            PS.setString(2, Modelo.getNombre());
            PS.setString(3, Modelo.getApellidoPaterno());
            PS.setString(4,Modelo.getApellidoMaterno());
            PS.setInt(5,Modelo.getTelefono());
            PS.setString(6, Modelo.getSexo());
            PS.setString(7, Modelo.getFechaIngreso());
            PS.setString(8,Modelo.getRfc());

            PS.setString(9, Modelo.getTurno());
            PS.setString(10,Modelo.getColonia());
            PS.setString(11,Modelo.getCalle());
            PS.setInt(12,Modelo.getNumero());
            PS.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e);
            return false;
        }finally{
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean eliminar(ModeloEmpleados Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "delete from empleado where idempleado = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1, Modelo.getIdEmpleado());
            Ps.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error:  "+ e);
            return false;
        }finally{
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public boolean buscar (DefaultTableModel Modelo){ //buscar en nueva tabla

        Connection Con = getConexion();

        try {
            PreparedStatement Ps;//Prepara la sentencia
            String sql = "select * from empleado";
            Ps =Con.prepareCall(sql);
            Ps.execute();
            ResultSet Rs = Ps.executeQuery(); ///Se tiene que guardar en una variable de resultset
            int numeroDeCampos = Rs.getMetaData().getColumnCount(); //para conocer el numero de registros que va tener la tabla

            while(Rs.next()){ //Mientras haya resultados encontrados
                Object Fila[] = new Object[numeroDeCampos];
                for (int i = 0; i < Fila.length; i++) {
                    Fila[i] = Rs.getObject(i+1);
                }
                Modelo.addRow(Fila);
            }

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " +e);
            return false;
        }finally{
            try {
                Con.close();
                System.out.println("Cerrando conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    public boolean actualizar (ModeloEmpleados Modelo){ //(modificar)
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "UPDATE `empleado` SET `nombre` = ?, `apellido_paterno` = ?, `apellido_materno` = ?, `telefono` = ?, `sexo` = ?, `fecha_ingreso` = ?, `rfc` = ?, `turno` = ?, `colonia` = ?, `calle` = ?, `numero` = ? WHERE `empleado`.`idempleado` = ?;"; //una llave primaria no se puede actualizar
            PS = Con.prepareCall(Sql);
            PS.setString(1, Modelo.getNombre());
            PS.setString(2,Modelo.getApellidoPaterno());
            PS.setString(3,Modelo.getApellidoMaterno());
            PS.setInt(4,Modelo.getTelefono());
            PS.setString(5, Modelo.getSexo());
            PS.setString(6,Modelo.getFechaIngreso());
            PS.setString(7,Modelo.getRfc() );

            PS.setString(8,Modelo.getTurno());
            PS.setString(9,Modelo.getColonia());
            PS.setString(10, Modelo.getCalle());
            PS.setInt(11, Modelo.getNumero());
            PS.setInt(12, Modelo.getIdEmpleado());
            PS.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            System.out.println(e);
            return false;
        }finally{
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
