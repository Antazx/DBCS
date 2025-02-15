/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Alquiler;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface AlquilerFacadeLocal {

    void create(Alquiler alquiler);

    void edit(Alquiler alquiler);

    void remove(Alquiler alquiler);

    Alquiler find(Object id);

    List<Alquiler> findAll();

    List<Alquiler> findRange(int[] range);

    int count();
    
}
