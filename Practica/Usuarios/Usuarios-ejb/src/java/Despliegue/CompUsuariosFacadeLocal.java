/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface CompUsuariosFacadeLocal {
    
    public boolean controlAccesos(String nombre, String clave, String tipoUsuario);
    public String getNIF(String nombre);
    public char bloqueado(String NIF);
    public String[] getLicencias(String NIF);
}