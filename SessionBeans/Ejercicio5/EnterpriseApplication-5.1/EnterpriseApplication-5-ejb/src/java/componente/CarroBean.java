/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import java.util.ArrayList;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import modelo.Pedido;

/**
 *
 * @author Anta
 */
@Stateful
public class CarroBean implements CarroBeanRemote {
    
    private ArrayList<Pedido> pedidos;
    
    @Override
    public void createCarro() {
        this.pedidos = new ArrayList<>();
    }

    @Override
    public void añadirPedido(Pedido e) {
       pedidos.add(e);
    }
    
    @Remove
    @Override
    public ArrayList<Pedido> getCarro() {
        return (ArrayList<Pedido>) pedidos.clone();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
