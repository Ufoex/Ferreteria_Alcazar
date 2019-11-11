/*
consultas que seran ejecutadas por controlador Ventas
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Partida Castañeda
 */
public class ConsultasVentas extends Conexion{
    //insertar datos a Ventas
    public boolean insertar(ModeloVentas Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "insert into ventas (codigo, fecha, cantidad, precio, total) values (?,?,?,?,?)";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdcodigo());
            PS.setString(2, Modelo.getFecha());
            PS.setInt(3, Modelo.getCantidad());
            PS.setFloat(4,Modelo.getPrecio());
            PS.setFloat(5,Modelo.getTotal());
            PS.executeUpdate();
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
    public boolean eliminar(ModeloVentas Modelo){
         Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "delete from ventas where codigo = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1, Modelo.getIdcodigo());
            Ps.executeUpdate();
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
    public boolean buscar (ModeloVentas Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "select * from ventas where codigo = ?";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdcodigo());
            ResultSet Rs = PS.executeQuery();
            if (Rs.next()) { //si encontro datos entra
                Modelo.setFecha(Rs.getString("fecha"));
                Modelo.setCantidad(Rs.getInt("cantidad"));
                Modelo.setPrecio(Rs.getFloat("precio"));
                Modelo.setTotal(Rs.getFloat("total"));
                return true;
            }else{//no encontro datos
            return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return false;
        }finally{
            try {
                
                Con.close();
                System.out.println("Cerrando Conexión... ");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public boolean actualizar (ModeloVentas Modelo){
   Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "update ventas set fecha = ?, cantidad set = ?, precio set=?, total set=?  where codigo = ? "; //una llave primaria no se puede actualizar
            PS = Con.prepareCall(Sql);
            PS.setString(1, Modelo.getFecha());
            PS.setInt(2,Modelo.getCantidad());
            PS.setFloat(3,Modelo.getPrecio());
            PS.setFloat(4,Modelo.getTotal() );
            PS.executeUpdate();
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
