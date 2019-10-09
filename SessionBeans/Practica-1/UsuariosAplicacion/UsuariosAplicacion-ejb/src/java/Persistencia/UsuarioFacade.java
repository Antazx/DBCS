/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Anta
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "UsuariosAplicacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
     public List<Usuario> findByName(String nombre){
         
         System.out.println("[UsuarioFacade] in: " +nombre);
        Query query = em.createNamedQuery("Usuario.findByNombre");
        query.setParameter("nombre", nombre);
        List<Usuario> usuarios = (List<Usuario>) query.getResultList();
        return usuarios;
    }
    
    public UsuarioFacade() {
        super(Usuario.class);
    }
    
}
