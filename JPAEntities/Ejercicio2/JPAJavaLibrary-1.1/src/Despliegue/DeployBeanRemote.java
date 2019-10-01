/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Productos;
import javax.ejb.Remote;

/**
 *
 * @author Anta
 */
@Remote
public interface DeployBeanRemote {
    
    public void hello();
    
    public void create(int id, String name, String description, float price);

    public Productos retrieve(int id);

    public void remove(Productos id);

    public void edit(Productos id);
}
