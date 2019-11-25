
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


public class ConsultasProveedores extends Conexion{
    //insertar datos a Ventas
    public boolean insertar(ModeloProveedores Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "insert into proveedores (idproveedor, nombre, apellido_paterno, apellido_materno, rfc, telefono, mail, estado, ciudad, cp, colonia, calle, numero) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdProveedor());
            PS.setString(2, Modelo.getNombre());
            PS.setString(3, Modelo.getApellidoPaterno());
            PS.setString(4,Modelo.getApellidoMaterno());
            PS.setInt(5,Modelo.getRfc());
            PS.setInt(6,Modelo.getTelefono());
            PS.setString(7, Modelo.getMail());
            PS.setString(8, Modelo.getEstado());
            PS.setString(9, Modelo.getCiudad());
            PS.setInt(10,Modelo.getCodigoPostal());
            PS.setString(11,Modelo.getColonia());
            PS.setString(12,Modelo.getCalle());
            PS.setInt(13,Modelo.getNumero());
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
                Logger.getLogger(ConsultasVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean eliminar(ModeloProveedores Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "delete from proveedores where idproveedor = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1, Modelo.getIdProveedor());
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
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public boolean buscar (DefaultTableModel Modelo){ //buscar en nueva tabla

        Connection Con = getConexion();

        try {
            PreparedStatement Ps;//Prepara la sentencia
            String sql = "select * from proveedores";
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
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }

    public boolean actualizar (ModeloProveedores Modelo){ //(modificar)
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "update proveedores set nombre = ?, set apellido_paterno = ?,  set apellido_materno = ?, set rfc = ?, set telefono = ?, set mail = ?, set estado = ?, set ciudad = ?, set cp = ?, set colonia = ?, set calle = ?, set numero = ?, where idproveedor = ? "; //una llave primaria no se puede actualizar
            PS = Con.prepareCall(Sql);
            PS.setString(1, Modelo.getNombre());
            PS.setString(2,Modelo.getApellidoPaterno());
            PS.setString(3,Modelo.getApellidoMaterno());
            PS.setInt(4,Modelo.getRfc() );
            PS.setInt(5,Modelo.getTelefono());
            PS.setString(6, Modelo.getMail());
            PS.setString(7,Modelo.getEstado());
            PS.setString(8,Modelo.getCiudad());
            PS.setInt(9,Modelo.getCodigoPostal() );
            PS.setString(10,Modelo.getColonia());
            PS.setString(11, Modelo.getCalle());
            PS.setInt(12, Modelo.getNumero());
            PS.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return false;
        }finally{
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



}
