/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import vista.Productos;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ConsultasCompras extends Conexion {
    //todas las consultas deben ser de tipo boolean para saber si estan bien o no, con el true o false

    //INSERTAR SQL INYECCION
    public boolean insertar(ModeloCompras Modelo) {
        Connection Con = getConexion();
        try {
            PreparedStatement PS;

            String nombre = Modelo.getProductoNombre();
            System.out.println(nombre);
            String sqlIdProduct = "SELECT idproducto FROM producto where nombre = ?";
            PS = Con.prepareCall(sqlIdProduct);
            PS.setString(1, nombre);
            PS.execute();
            ResultSet result = PS.executeQuery();
            while (result.next()) {
                Modelo.setIdproducto(Integer.parseInt(result.getString("idproducto")));
            }

            String Sql = "insert into compras (idcompra, precio_unitario, cantidad_producto, fecha, total, idproducto) values (?,?,?,?,?,?)";
            System.out.println(Sql);

            PS = Con.prepareCall(Sql);
            PS.setInt(1, Modelo.getIdCompras());
            PS.setFloat(2, Modelo.getPrecioUnitario());
            PS.setInt(3, Modelo.getCantidad());
            PS.setString(4, Modelo.getFecha());
            PS.setFloat(5, Modelo.getTotal());
            PS.setInt(6, Modelo.getIdproducto());
            PS.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return false;
        } finally {
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasCompras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean eliminar(ModeloCompras Modelo) {
        Connection Con = getConexion();
        try {
            PreparedStatement Ps;
            String Sql = "delete from compras where idcompra = ?";
            Ps = Con.prepareCall(Sql);
            Ps.setInt(1, Modelo.getIdCompras());
            Ps.execute();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:  " + e);
            return false;
        } finally {
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean buscar(DefaultTableModel Modelo) { //buscar en nueva tabla

        Connection Con = getConexion();

        try {
            PreparedStatement Ps;//Prepara la sentencia
            String sql = "select * from compras";
            Ps = Con.prepareCall(sql);
            Ps.execute();
            ResultSet Rs = Ps.executeQuery(); ///Se tiene que guardar en una variable de resultset
            int numeroDeCampos = Rs.getMetaData().getColumnCount(); //para conocer el numero de registros que va tener la tabla

            while (Rs.next()) { //Mientras haya resultados encontrados
                Object Fila[] = new Object[numeroDeCampos];
                for (int i = 0; i < Fila.length; i++) {
                    Fila[i] = Rs.getObject(i + 1);
                }
                Modelo.addRow(Fila);
            }

            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return false;
        } finally {
            try {
                Con.close();
                System.out.println("Cerrando conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean actualizar(ModeloCompras Modelo) { //(modificar)
        Connection Con = getConexion();
        try {
            PreparedStatement PS;
            String Sql = "UPDATE `compras` SET  `precio_unitario` = ?, `cantidad_producto` = ?, `fecha` = ?, `total` = ? WHERE `compras`.`idcompra` = ?"; //una llave primaria no se puede actualizar
            PS = Con.prepareCall(Sql);
            PS.setInt(1,Modelo.getIdproducto());
            PS.setFloat(2, Modelo.getPrecioUnitario());
            PS.setInt(3, Modelo.getCantidad());
            PS.setString(4, Modelo.getFecha());
            PS.setFloat(5, Modelo.getTotal());
            //PS.setInt(6,Modelo.getIdCompras());
            PS.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return false;
        } finally {
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasCompras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<String> getPruducts() {
        Connection Con = getConexion();
        List<String> products = new ArrayList();
        try {
            Statement statement = Con.createStatement();
            String sql = "select idproducto, nombre from producto";
            ResultSet results = statement.executeQuery(sql);

            while (results.next()) {
                products.add(results.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally {
            try {
                Con.close();
                System.out.println("Cerrando Conexión...");
            } catch (SQLException ex) {
                Logger.getLogger(ConsultasCompras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return products;
    }


}
