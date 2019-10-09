/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import Dominio.Cliente;
import Dominio.Empleado;
import Dominio.Tipocarnet;
import Dominio.Usuario;
import Persistencia.ClienteFacadeLocal;
import Persistencia.EmpleadoFacadeLocal;
import Persistencia.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class CompUsuariosFacade implements CompUsuariosFacadeRemote {
    
    @EJB
    private ClienteFacadeLocal clienteFacade;
    
    @EJB
    private EmpleadoFacadeLocal empleadoFacade;
 
    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    
    
    @Override
    public boolean controlAccesos(String nombre, String clave, String tipoUsuario) {
        
        System.out.println("[CompUsuariosFacade (controlAccesos)] in: " +nombre +", " +clave +", " +tipoUsuario);
        
        List<Usuario> usuarios = usuarioFacade.findByName(nombre);
        System.out.println("[CompUsuariosFacade (controlAccesos)] usuarios.size: " +usuarios.size());
       
        System.out.println("[CompUsuariosFacade (controlAccesos)] nombre: " +usuarios.get(0).getNombre());
        System.out.println("[CompUsuariosFacade (controlAccesos)] clave: " +usuarios.get(0).getPassword());
        System.out.println("[CompUsuariosFacade (controlAccesos)] NIF: " +usuarios.get(0).getNif());
             
        if(usuarios.size() != 1)
            return false;
        
        /* CUIDADO CON ESTO PREGUNTAR QUE SI HAY QUE VALIDAR QUE SE DEVUELVE SOLO UN USUARIO (PROBLEMA CON FINDBYNAME NO ES PK)*/
        Usuario usuario = usuarios.get(0);
        System.out.println("[CompUsuariosFacade (controlAccesos)] out: " +usuario.getNif());
        
        String claveUsuario = usuario.getPassword();
        
        if(!claveUsuario.equals(clave))
            return false;
        
        String nifUsuario = usuario.getNif();
        
        switch (tipoUsuario) {
            
            case "cliente":
                Cliente cliente = clienteFacade.find(nifUsuario);
                return (cliente != null);
   
            case "empleado":
                Empleado empleado = empleadoFacade.find(nifUsuario);
                return (empleado != null);
                
            default:
                return false;
        }
    }

    @Override
    public String getNIF(String nombre) {
        System.out.println("[CompUsuariosFacade (getNIF)] in: " +nombre);
        
        List<Usuario> usuarios = usuarioFacade.findByName(nombre); 
        if(usuarios.size() != 1)
            return null;
        
        Usuario usuario = usuarios.get(0);
        return usuario.getNif();
    }

    @Override
    public char bloqueado(String NIF) {
        
        System.out.println("[CompUsuariosFacade (getNIF)] in: " +NIF);
        
        Cliente cliente = clienteFacade.find(NIF);
        
        if(cliente == null) 
            return 'E';
        
        return cliente.getBloqueado();
    }

    @Override
    public String[] getLicencias(String NIF) {
        
        System.out.println("[CompUsuariosFacade (getLicencias)] in: " +NIF);
        Cliente cliente = clienteFacade.find(NIF);
        
        if(cliente == null) 
            return null;
        
        List<Tipocarnet> licencias = cliente.getTipocarnetList();
        String[] returnLicencias = new String[licencias.size()];
        
        for (int i = 0; i < licencias.size(); i++){
            returnLicencias[i] = licencias.get(i).getTipo();
        }
        
        return returnLicencias;
    }
    /*      CREAR GETCLIENTE GET USUARIO GET EMPLEADO?*/
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
