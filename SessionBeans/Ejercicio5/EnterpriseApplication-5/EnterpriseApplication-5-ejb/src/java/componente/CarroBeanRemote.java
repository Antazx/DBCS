/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import java.util.ArrayList;
import javax.ejb.Remote;
import modelo.Pedido;

/**
 *
 * @author Anta
 */
@Remote
public interface CarroBeanRemote {
    
    public void createCarro();
    public void añadirPedido(Pedido e);
    public ArrayList<Pedido> getCarro();
}
