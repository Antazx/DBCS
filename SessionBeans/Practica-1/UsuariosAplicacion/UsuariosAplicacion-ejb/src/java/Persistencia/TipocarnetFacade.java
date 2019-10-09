/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Tipocarnet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anta
 */
@Stateless
public class TipocarnetFacade extends AbstractFacade<Tipocarnet> implements TipocarnetFacadeLocal {
    @PersistenceContext(unitName = "UsuariosAplicacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipocarnetFacade() {
        super(Tipocarnet.class);
    }
    
}
