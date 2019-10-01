/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaapplicationclient11;

import Despliegue.DeployBeanRemote;
import Dominio.Productos;
import javax.ejb.EJB;

/**
 *
 * @author Anta
 */
public class Main {
    
    @EJB
    private static DeployBeanRemote deployBean;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        deployBean.hello();
        //deployBean.create(111, "Cocaina", "Que te anima", 50f);
        Productos p = deployBean.retrieve(6);
        
        System.out.println(p.getProdDescription());
        
        p.setProdPrice(25f);
        deployBean.edit(p);
        
        deployBean.remove(p);
    }
    
}
