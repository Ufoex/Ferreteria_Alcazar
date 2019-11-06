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
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "insert into producto, inventario (idproductos, nombre, marca, precio unitario, stock, categoria) values (?,?,?,?,?,?)";
            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdProductos());
            PS.setString(2, Modelo.getNombre());
            PS.setString(3, Modelo.getMarca());
            PS.setFloat(4, Modelo.getPrecioUnitario());
            PS.setInt(5,Modelo.getStock());
            PS.setString(6, Modelo.getCategoria());
            //Ejecutar la consulta
            PS.executeUpdate();
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
            String Sql = "update productos set nombre = ?, marca = ?, preciounitario = ?, stock = ?, categoria = ?, where codigo = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setString(1,Modelo.getNombre());
            Ps.setString(2, Modelo.getMarca());
            Ps.setFloat(3,Modelo.getPrecioUnitario());
            Ps.setInt(4,Modelo.getStock());
            Ps.setString(5, Modelo.getCategoria());
            Ps.setInt(6,Modelo.getIdProductos());
            Ps.executeQuery();
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
            String Sql = "select * from productos where idoproductos = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1,Modelo.getIdProductos());
            ResultSet Rs = Ps.executeQuery();
            if(Rs.next()){ //Si encontro datos
                Modelo.setNombre(Rs.getString("Nombre"));
                Modelo.setMarca(Rs.getString("Marca"));
                Modelo.setPrecioUnitario(Rs.getFloat("PrecioUnitario"));
                Modelo.setStock(Rs.getInt("Stock"));
                Modelo.setCategoria(Rs.getString("Categoria"));
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
}
