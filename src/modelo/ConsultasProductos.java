/*
Consultas que seran ejecutadas por el controlador productos.
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
 * @author miria
 */
public class ConsultasProductos extends Conexion{
    //todas las consultas deben ser de tipo boolean para saber si estan bien o no, con el true o false
    
    //INSERTAR SQL INYECCION
    public boolean insertar(ModeloProductos Modelo){
        System.out.println("Categoria: "+Modelo.getCategoria());
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            
            String Sql = "insert into producto(idproducto, nombre, marca, precio_unitario) values (?,?,?,?)";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdProductos());
            PS.setString(2, Modelo.getNombre());
            PS.setString(3, Modelo.getMarca());
            PS.setFloat(4, Modelo.getPrecioUnitario());

            PS.execute();
            
            String SQl = "insert into inventario(idproducto, stock, categoria) values (?,?,?)";
            PS = Con.prepareCall(SQl);
            PS.setInt(1,Modelo.getIdProductos());
            PS.setInt(2,Modelo.getStock());
            PS.setString(3, Modelo.getCategoria());

            PS.execute();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR: " +e);
            return false;
        }finally{
            try {
                Con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean modificar(ModeloProductos Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "update producto set nombre = ?, marca = ?, precio_unitario = ? where idproducto = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setString(1,Modelo.getNombre());
            Ps.setString(2, Modelo.getMarca());
            Ps.setFloat(3,Modelo.getPrecioUnitario());
            Ps.setInt(4,Modelo.getIdProductos());
            Ps.execute();
            
            String SQL = "update inventario set stock = ?, categoria = ? where idproducto = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getStock());
            Ps.setString(2, Modelo.getCategoria());
            Ps.setInt(3, Modelo.getIdProductos());
            
            Ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return false;
        }finally{
            try {
                Con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean buscar(ModeloProductos Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "select * from producto as p inner join inventario as i on p.idproducto=i.idproducto where p.idproducto = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1,Modelo.getIdProductos());
            ResultSet Rs = Ps.executeQuery();
            if(Rs.next()){ //Si encontro datos
                Modelo.setNombre(Rs.getString("nombre"));
                Modelo.setMarca(Rs.getString("marca"));
                Modelo.setPrecioUnitario(Rs.getFloat("precio_unitario"));
                Modelo.setStock(Rs.getInt("stock"));
                Modelo.setCategoria(Rs.getString("categoria"));
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return false;
        }finally{
            try {
                Con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean eliminar(ModeloProductos Modelo){
        Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            
            String SQL = "delete from inventario where idproducto = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setInt(1, Modelo.getIdProductos());           
            Ps.execute();
            
            String Sql = "delete from producto where idproducto = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1,Modelo.getIdProductos());
            Ps.execute();
            
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return false;
        }finally{
            try {
                Con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
