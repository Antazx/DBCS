/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author Anta
 */
@Stateful
public class Carro implements CarroLocal {
    
    private ArrayList<String> pedidos = new ArrayList<>();
    
    @Override
    public void añadir(String producto, String cantidad) {
        
        this.pedidos.add(producto +": " +cantidad);
    }
    
    @Remove
    @Override
    public ArrayList<String> getPedidos(){
        return pedidos;
    }
}
