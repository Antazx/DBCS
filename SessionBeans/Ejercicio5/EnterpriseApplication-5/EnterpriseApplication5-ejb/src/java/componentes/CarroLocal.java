/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface CarroLocal {
    
    public void añadir(String producto, String cantidad);
    public ArrayList<String> getPedidos();
}
