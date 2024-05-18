/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Conexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductoDAO {
    
   public ArrayList<Producto> buscar() {

        Conexiones conexion = new Conexiones();
        Connection cn = conexion.conectar();
        ArrayList<Producto> listaProductos = new ArrayList<>();

        Statement st = null;
        ResultSet rs = null;

        try {

            st = cn.createStatement();
            rs = st.executeQuery("select * from tienda");

            while (rs.next()) {
                Producto p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                listaProductos.add(p);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } finally {

            try {
                st.close();
                rs.close();
                conexion.desconectar(cn);
            } catch (SQLException ex) {

                System.out.println("Error al conectar");
            }

        }

        return listaProductos;
    }

    public void modificar(Producto p) {

        Conexiones conexion = new Conexiones();
        Connection cn = conexion.conectar();

        PreparedStatement ps = null;

        try {

            ps = cn.prepareStatement("UPDATE tienda set nombre = ?, fabricante = ?, precio? where nserie = ?");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getFabricante());
            ps.setInt(3, p.getPrecio());
            ps.setInt(4, p.getNserie());
            ps.executeUpdate();
            System.out.println("Modificado correctamente");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());

        } finally {

            try {
                ps.close();
                conexion.desconectar(cn);
            } catch (SQLException ex) {
                System.out.println("Error al cerrar servicios");
            }

        }

    }

    public void insertar(Producto p) {

        Conexiones conexion = new Conexiones();
        Connection cn = conexion.conectar();

        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement("insert into tienda values (?,?,?,?)");
            ps.setInt(1, p.getNserie());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getFabricante());
            ps.setInt(4, p.getPrecio());
            ps.executeUpdate();
            System.out.println("Inserción correcta");

        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println(ex.getMessage());

        } finally {

            try {
                ps.close();
                conexion.desconectar(cn);
            } catch (SQLException ex) {
                System.out.println("Error al cargar los servicios");
            }

        }

    }

    public void borrar(Producto p) {

        Conexiones conexion = new Conexiones();
        Connection cn = conexion.conectar();

        PreparedStatement ps = null;

        try {
            ps = cn.prepareStatement("delete from tienda where nserie =?");
            ps.setInt(1, p.getNserie());
            ps.executeUpdate();
            System.out.println("Usuario eliminado");

        } catch (SQLException ex) {

            ex.printStackTrace();
            System.out.println(ex.getMessage());

        } finally {
            try {
                ps.close();
                conexion.desconectar(cn);
            } catch (SQLException ex) {
                System.out.println("Error al cargar los servicios");
            }

        }

    }
    
    
}
