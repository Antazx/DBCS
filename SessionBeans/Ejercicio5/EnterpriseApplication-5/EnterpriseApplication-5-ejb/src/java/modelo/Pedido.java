/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Anta
 */
public class Pedido {
    
    private String producto;
    private int cantidad;
    
    public Pedido(String producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public String getProducto(){
        return this.producto;
    }
}
