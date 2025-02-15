/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Reserva;
import java.util.Date;
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
public class ReservaFacade extends AbstractFacade<Reserva> implements ReservaFacadeLocal {
    @PersistenceContext(unitName = "AlquilerAplicacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Reserva> findByEjecutada(String nif){
        
        System.out.println("[ReservaFacade] (findByEjecutada) in: " +nif);
        
        Query query = em.createNamedQuery("Reserva.findByEjecutada");
        query.setParameter("ejecutada", 'F');
        query.setParameter("nif", nif);
        List<Reserva> usuarios = (List<Reserva>) query.getResultList();
        return usuarios;
    }
    
    @Override
    public List<Reserva> findByDateRange(Date inicio, Date fin){
        
        System.out.println("[ReservaFacade] (findByDateRange) in: " +inicio.toString() +" - " +fin.toString());
        
        Query query = em.createNamedQuery("Reserva.findByDateRange");
        query.setParameter("fechainicioalquiler", inicio);
        query.setParameter("fechafinalquiler", fin);
        List<Reserva> disponibles = (List<Reserva>) query.getResultList();
        
        System.out.println("[ReservaFacade] (findByDateRange) query results done");
        
        return disponibles;
    }
    
    public ReservaFacade() {
        super(Reserva.class);
    }
    
}
