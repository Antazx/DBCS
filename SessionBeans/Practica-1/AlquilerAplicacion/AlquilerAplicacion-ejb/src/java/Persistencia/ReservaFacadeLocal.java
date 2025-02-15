/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Dominio.Reserva;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface ReservaFacadeLocal {

    void create(Reserva reserva);

    void edit(Reserva reserva);

    void remove(Reserva reserva);

    Reserva find(Object id);

    List<Reserva> findAll();

    List<Reserva> findRange(int[] range);
    
    List<Reserva> findByEjecutada(String nif);
    
    List<Reserva> findByDateRange(Date inicio, Date fin);

    int count();
    
}
