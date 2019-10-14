/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Vehiculo;
import Persistencia.VehiculoFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class CompFlotaFacade implements CompFlotaFacadeLocal {
    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    
    @EJB
    private CompResAlqFacadeRemote compResAlqFacade;
    
    @Override
    public List<Vehiculo> getVehiculos(String[] Licencias, Date FechaInicial, Date fechaFinal) {
        
        String[] reservados = compResAlqFacade.getReservados(FechaInicial, fechaFinal);
        if(reservados == null)
            return null;
        
        
        return null;
    }

    @Override
    public Boolean addVehiculo(String idModelo, String matricula, String color, float Km, char averiado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delVehiculo(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
