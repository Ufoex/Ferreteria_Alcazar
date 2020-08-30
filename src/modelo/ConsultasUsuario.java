/*
Aqui se encuantran todas las posibles consultas
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

public class ConsultasUsuario extends Conexion{
    public boolean buscar(ModeloUsuario Modelo){
        //Consultar (ExecuteQuery);
        //actualizar (ExecuteUpdate);
        //eliminar (ExecuteUpdate);
        //insertar (ExecuteUpdate);
        Connection Con = getConexion(); // se conecta a nuestra BD
        try {
            PreparedStatement Ps; //Cachar parametros Ps = Sentencia
            String Sql = "Select * from empleado where usuario = ? and password = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setString(1, Modelo.getUsuario());
            Ps.setString(2, Modelo.getPassword());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) { //Encontro algo
                Modelo.setNombre(Rs.getString("nombre"));
                Modelo.setUsuario(Rs.getString("usuario"));
                return true;               
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " +e); //cachar y mostrar el error
            return false;
        }finally{
            try {
                Con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error: " +ex);
                
            }
        }

    } 
    
    public boolean insertar(ModeloUsuario Modelo){
        return true;
    }
    
    public boolean eliminar(ModeloUsuario Modelo){
        return true;
    }
    
    public boolean actualizar(ModeloUsuario Modelo){
        return true;
    }
    
    
    
}
