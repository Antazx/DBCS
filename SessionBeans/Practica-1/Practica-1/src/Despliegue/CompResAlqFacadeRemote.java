/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Reserva;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anta
 */
@Remote
public interface CompResAlqFacadeRemote {
    
    public boolean addReserva(Date fechaInicio, Date fechaFin, String NIF, String matricula);
    public List<Reserva> getReservasF (String NIF);
    public boolean addAlquiler (int idReserva, float Km, String idEmpleado);
    public String[] getReservados(Date fechaInicial, Date fechaFinal);
}
