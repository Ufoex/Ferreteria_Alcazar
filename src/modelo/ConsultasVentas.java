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
import javax.swing.table.DefaultTableModel;

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
            String Sql = "insert into ventas (idventas, fecha, cantidad, precio_publico, total, idproducto) values (?,?,?,?,?,?)";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdVentas());
            PS.setString(2, Modelo.getFecha());
            PS.setInt(3, Modelo.getCantidad());
            PS.setFloat(4,Modelo.getPrecio());
            PS.setFloat(5,Modelo.getTotal());
            PS.setInt(6,Modelo.getIdProducto());
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
    public boolean eliminar(ModeloVentas Modelo){
         Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "delete from ventas where idventas = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1, Modelo.getIdVentas());
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
            String sql = "select * from ventas";
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
       /* Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "select * from ventas where idventas= ?";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdVentas());
            ResultSet Rs = PS.executeQuery();
            if (Rs.next()) { //si encontro datos entra
                Modelo.setFecha(Rs.getString("fecha"));
                Modelo.setCantidad(Rs.getInt("cantidad"));
                Modelo.setPrecio(Rs.getFloat("precio_publico"));
                Modelo.setTotal(Rs.getFloat("total"));
                Modelo.setIdProducto(Rs.getInt("idproducto"));
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
        
    }*/
    public boolean actualizar (ModeloVentas Modelo){ //(modificar)
   Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "UPDATE `ventas` SET `fecha` = ?, `cantidad` = ?, `precio_publico` = ?, `total` = ? WHERE `ventas`.`idventas` = ?;"; //una llave primaria no se puede actualizar
            PS = Con.prepareCall(Sql);
            PS.setString(1, Modelo.getFecha());
            PS.setInt(2,Modelo.getCantidad());
            PS.setFloat(3,Modelo.getPrecio());
            PS.setFloat(4,Modelo.getTotal() );
            PS.setInt(5,Modelo.getIdVentas());
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
