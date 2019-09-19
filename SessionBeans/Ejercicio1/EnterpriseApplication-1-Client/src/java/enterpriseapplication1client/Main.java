/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterpriseapplication1client;

import HolaMundo.HolaMundoRemote;
import javax.ejb.EJB;

/**
 *
 * @author Anta
 */
public class Main {
    
    @EJB
    private static HolaMundoRemote holaMundo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Result = " + holaMundo.getResource());
        // TODO code application logic here
    }
    
}
