/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaapplicationclient1;

import despliegue.DeployBeanRemote;
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
    }
    
}
