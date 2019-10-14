/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Alquiler;
import Dominio.Reserva;
import Persistencia.AlquilerFacadeLocal;
import Persistencia.ReservaFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class CompResAlqFacade implements CompResAlqFacadeRemote {
    
    @EJB
    private ReservaFacadeLocal reservaFacade;
    
    @EJB
    private AlquilerFacadeLocal alquilerFacade;
    
    @Override
    public boolean addReserva(Date fechaInicio, Date fechaFin, String NIF, String matricula) {
        
        Reserva reserva = new Reserva();
        int id = reservaFacade.count() + 1;
        reserva.setIdreserva(id);
        reserva.setFechainicioalquiler(fechaInicio);
        reserva.setFechafinalquiler(fechaFin);
        reserva.setFechareserva(new Date());
        reserva.setNif(NIF);
        reserva.setMatricula(matricula);
        reserva.setEjecutada('F');
        reservaFacade.create(reserva);
        
        return (reservaFacade.find(id) != null);
    }

    @Override
    public List<Reserva> getReservasF(String nif) {
        
        List<Reserva> reservas = reservaFacade.findByEjecutada(nif);
        
        if(reservas == null)
            return null;
        
        return reservas;
    }

    @Override
    public boolean addAlquiler(int idReserva, float Km, String idEmpleado) {
        
        Reserva reserva = reservaFacade.find(idReserva);
        if(reserva == null)
            return false;
        
        Date fechaIni = reserva.getFechainicioalquiler();
        Date fechaFin = reserva.getFechafinalquiler();
        String nif = reserva.getNif();
        String matricula = reserva.getMatricula();
        
        reserva.setEjecutada('T');
        reservaFacade.edit(reserva);
      
        Alquiler alquiler = new Alquiler();
        int id = alquilerFacade.count()+1;
        alquiler.setIdalquiler(id);
        alquiler.setKilometrajesalida(Km);
        alquiler.setRealizadopor(idEmpleado);
        alquiler.setCliente(nif);
        alquiler.setFechainicio(fechaIni);
        alquiler.setFechafin(fechaFin);
        alquiler.setMatricula(matricula);
        
        alquilerFacade.create(alquiler);
        
        return (alquilerFacade.find(id) != null);
    }

    @Override
    public String[] getReservados(Date fechaInicial, Date fechaFinal) {
        
        List<Reserva> reservados = reservaFacade.findByDateRange(fechaInicial, fechaFinal);
        
        if(reservados == null)
            return null;
        
        String[] matriculas = new String[reservados.size()];
        
        for (int i = 0; i < reservados.size(); i++){
            matriculas[i] = reservados.get(i).getMatricula();
        }
        
        return matriculas;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
