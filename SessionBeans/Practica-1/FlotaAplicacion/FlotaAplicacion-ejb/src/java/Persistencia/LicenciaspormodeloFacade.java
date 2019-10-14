/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Licenciaspormodelo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anta
 */
@Stateless
public class LicenciaspormodeloFacade extends AbstractFacade<Licenciaspormodelo> implements LicenciaspormodeloFacadeLocal {
    @PersistenceContext(unitName = "FlotaAplicacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LicenciaspormodeloFacade() {
        super(Licenciaspormodelo.class);
    }
    
}
