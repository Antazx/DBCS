/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolaMundo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class HolaMundo implements HolaMundoRemote {
    
    @PostConstruct
    public void start(){
        System.out.println("[EJB] Incializar recursos");
    }
    
    public void diHola(String name){
        System.out.println("<----- Hola: " +name +" ----->");
    }
    
    @PreDestroy
    public void end(){
        System.out.println("[EJB] Cerrar recursos");
    }
}
