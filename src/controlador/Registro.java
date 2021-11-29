/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Detalle;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Venta;

/**
 *
 * @author leoaranda
 * @version 28-11-2021
 */
public class Registro {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r; //Respuesta

    //iniciar sesion
    public LoginC log(String nombre, String pass) {
        LoginC l = new LoginC();
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND pass = ?";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next())
            {
                l.setId(rs.getInt("idusuarios"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        return l;
    }

    //Registrar clientes
    public boolean registrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes(run, nombre, telefono, direccion) VALUES(?, ?, ?, ?)";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getRun());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally
        {
            try
            {
                con.close();
            } catch (SQLException e)
            {
                System.out.println(e.toString());

            }
        }
    }

    //Listar Cliente
    public List listarCliente() {
        List<Cliente> listaCliente = new ArrayList();
        String sql = "SELECT * FROM clientes";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                Cliente cl = new Cliente();
                cl.setIdcliente(rs.getInt("idcliente"));
                cl.setRun(rs.getString("run"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                listaCliente.add(cl);
            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        return listaCliente;
    }

    //Eliminar clientes
    public boolean eliminarClientes(int idcliente) {
        String sql = "DELETE FROM clientes WHERE idcliente = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idcliente);
            ps.execute();
            return true;
        } catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        } finally
        {
            try
            {
                con.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.toString());
            }
        }
    }
    
    //Modificar cliente
    public boolean ModificarCliente(Cliente cl) {
        String sql = "UPDATE clientes SET run = ?, nombre = ?, telefono = ?, direccion = ? WHERE idcliente = ?";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getRun());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setInt(5, cl.getIdcliente());
            ps.execute();
            return true;
        } catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        } finally
        {
            try
            {
                con.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    //Registrar proveedor
    public boolean registrarPoveedor(Proveedor pr){
        String sql = "INSERT INTO proveedores (run, nombre, telefono, direccion) VALUES(?,?,?,?)";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getRun());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }finally {
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
    }

    //Listar proveedor
    public List listarProveedor(){
        List<Proveedor> listaProveedor = new ArrayList();
        String sql = "SELECT * FROM proveedores";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Proveedor pr = new Proveedor();
                pr.setIdproveedor(rs.getInt("idproveedor"));
                pr.setRun(rs.getString("run"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getInt("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                listaProveedor.add(pr);
            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
        return listaProveedor;
    }
    
    //Eliminar proveedor
    public boolean eliminarProveedor(int idproveedor){
        String sql = "DELETE FROM proveedores WHERE idproveedor = ?";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idproveedor);
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        } finally {
            try{
                con.close();
            }catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    //Modificar proveedor
    public boolean modificarProveedor(Proveedor pr){
        String sql = "UPDATE proveedores SET run = ?, nombre = ?, telefono = ?, direccion = ? WHERE idproveedor = ?";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getRun());
            ps.setString(2, pr.getNombre());
            ps.setInt(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setInt(5, pr.getIdproveedor());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        } finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    //Registrar productos
    public boolean registrarProductos(Producto pro){
        String sql = "INSERT INTO productos (codigo, nombre, descripcion, proveedor, stock, precio) VALUES (? , ?, ?, ?, ?, ?)";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setString(4, pro.getProveedor());
            ps.setInt(5, pro.getStock());
            ps.setDouble(6, pro.getPrecio());
            ps.execute();
            return true;
            
        } catch(SQLException e){
            
            System.out.println(e.toString());
            return false;
        }
    }
    
    //Consultar Proveedor
    public void consultarProveedor(JComboBox proveedor){
        String sql = "SELECT nombre FROM proveedores";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                proveedor.addItem(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    //Listar Productos
    public List listarProducto() {
        List<Producto> listaProducto = new ArrayList();
        String sql = "SELECT * FROM productos";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                Producto  pro= new Producto();
                pro.setIdproductos(rs.getInt("idproducto"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setDescripcion(rs.getString("descripcion"));
                pro.setProveedor(rs.getString("proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
                listaProducto.add(pro);
            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        return listaProducto;
    }
    
    //Eliminar producto
    public boolean eliminarProducto(int idproductos){
        String sql = "DELETE FROM productos WHERE idproducto = ?";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idproductos);
            ps.execute();
            return true;
            
        } catch(SQLException e){
            System.out.println(e.toString());
            return false;
        } finally {
            try{
                con.close();
            }catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }

    //Modificar Producto
    public boolean modificarProducto(Producto pro) {
        String sql = "UPDATE productos SET codigo = ?, nombre = ?, descripcion = ?, proveedor = ?, stock = ?, precio = ? WHERE idproducto = ?";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setString(4, pro.getProveedor());
            ps.setInt(5, pro.getStock());
            ps.setDouble(6, pro.getPrecio());
            ps.setInt(7, pro.getIdproductos());
            ps.execute();
            return true;
        } catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        } finally
        {
            try
            {
                con.close();
            } catch (SQLException e){
                System.out.println(e.toString());
            }
        }
    }

    //Buscar producto
    public Producto buscarProducto(String cod){
        Producto producto = new Producto();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()){
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return producto;
    }
    
    
    //Buscar Cliente
        public Cliente BuscarCliente(String run){
        Cliente cl = new Cliente();
        String sql = "SELECT * FROM clientes where run = ?";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, run);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setDireccion(rs.getString("direccion"));
            }
        }catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }

    //Registrar venta
    public int RegistrarVenta(Venta v){
        String sql = "INSERT INTO ventas (cliente, vendedor, total) VALUES (?,?,?)";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        } finally {
            try{
                con.close();
            }catch(SQLException e){
            }
        }
        return r;
    }

    //Registrar detalle
    public int registrarDetalle(Detalle Dv){
        String sql = "INSERT INTO detalles (cod_pro, cantidad, precio, id_venta) VALUES (?, ?, ?, ?)";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Dv.getCod_pro());
            ps.setInt(2, Dv.getCantidad());
            ps.setDouble(3, Dv.getPrecio());
            ps.setInt(4, Dv.getIddetalle());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        } finally {
            try{
                con.close();
            }catch(SQLException e){
            }
        }
        return r;
    }
    
    //Consultar ID máximo de la venta
    public int idVenta(){
        int id = 0;
        String sql = "SELECT MAX(idventas) FROM ventas";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.execute();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    //Actualizar stock
    public boolean actualizarStock(int cant, String cod){
        String sql = "UPDATE productos SET stock = ? WHERE codigo = ?";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setString(2, cod);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    //Listar Ventas
    public List listarVenta() {
        List<Venta> listaVenta = new ArrayList();
        String sql = "SELECT * FROM ventas";
        try
        {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next())
            {
                Venta  vent = new Venta();
                vent.setIdventas(rs.getInt("idventas"));
                vent.setCliente(rs.getString("cliente"));
                vent.setVendedor(rs.getString("vendedor"));
                vent.setTotal(rs.getDouble("total"));
                listaVenta.add(vent);
            }
        } catch (SQLException e)
        {
            System.out.println(e.toString());
        }
        return listaVenta;
    }
    
    //Registrar usuarios
    public boolean registrarUsuario(LoginC reg){
        String sql = "INSERT INTO usuarios (nombre, correo, pass) VALUES(?, ?, ?)";
        try{
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
}     

//    public boolean registrarProducto(Productos sis) {
//        String sql = "INSERT INTO productos (nombre, cantidad, tipo_producto) VALUES (?,?,?)";
//        try {
//            pres.setString(1, sis.getNombre());
//            pres.setInt(2, sis.getCantidad());
//            pres.setString(3, sis.getTipo_producto());
//            pres.execute();
//            return true;
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//            return false;
//        }
//    }
    //Ejemplo de listar con arrayList
//        public List ListarProductos() {
//        List<Producto> Listapro = new ArrayList();
//        String sql = "SELECT * FROM productos";
//        try {
//            con = cn.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Producto pro = new Producto();
//                pro.setId(rs.getInt("id"));
//                pro.setCodigo(rs.getString("codigo"));
//                pro.setNombre(rs.getString("nombre"));
//                pro.setProveedor(rs.getString("proveedor"));
//                pro.setStock(rs.getInt("stock"));
//                pro.setPrecio(rs.getDouble("precio"));
//                Listapro.add(pro);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.toString());
//        }
//        return Listapro;
//    }
