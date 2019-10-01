/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Productos;
import Persistencia.ProductosFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class DeployBean implements DeployBeanRemote {
    
    @EJB
    private ProductosFacadeLocal productosFacade;
    
    @Override
    public void hello() {
        System.out.println("[Deploy Bean] start");
    }
    
    @Override
    public void create(int id, String name, String description, float price) {
        Productos producto = new Productos();
        producto.setProdId(id);
        producto.setItemId(name);
        producto.setProdDescription(description);
        producto.setProdPrice(price);
        
        productosFacade.create(producto);
    }
    
    @Override
    public Productos retrieve(int id) {
        return productosFacade.find(id);
    }
    
    @Override
    public void remove(Productos id){
        productosFacade.remove(id);
    }
    
    @Override
    public void edit(Productos id){
        productosFacade.edit(id);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
