/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Vehiculo;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface CompFlotaFacadeLocal {
    
    public List<Vehiculo> getVehiculos (String[] Licencias, Date FechaInicial, Date fechaFinal);
    public Boolean addVehiculo (String idModelo, String matricula, String color, float Km, char averiado);
    public Boolean delVehiculo (String matricula);
}
