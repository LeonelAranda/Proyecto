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
public class Venta {
    private int idventas;
    private String cliente;
    private String vendedor;
    private double total;

    public Venta() {
    }

    public Venta(int idventas, String cliente, String vendedor, double total) {
        this.idventas = idventas;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.total = total;
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
