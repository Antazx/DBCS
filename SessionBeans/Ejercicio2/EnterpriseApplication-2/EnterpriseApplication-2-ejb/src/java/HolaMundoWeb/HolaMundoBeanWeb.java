/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolaMundoWeb;

import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class HolaMundoBeanWeb implements HolaMundoBeanWebLocal {

    @Override
    public String diHola(String name) {
       return "Hola " +name;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
