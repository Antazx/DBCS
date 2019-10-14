/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Licenciaspormodelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface LicenciaspormodeloFacadeLocal {

    void create(Licenciaspormodelo licenciaspormodelo);

    void edit(Licenciaspormodelo licenciaspormodelo);

    void remove(Licenciaspormodelo licenciaspormodelo);

    Licenciaspormodelo find(Object id);

    List<Licenciaspormodelo> findAll();

    List<Licenciaspormodelo> findRange(int[] range);

    int count();
    
}
