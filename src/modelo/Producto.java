/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lucia
 */
public class Producto {
    private int idproductos;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String proveedor;
    private int stock;
    private double precio;

    public Producto() {
    }

    public Producto(int idproductos, String codigo, String nombre, String descripcion, String proveedor, int stock, double precio) {
        this.idproductos = idproductos;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
    }

    public int getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    
    
}
