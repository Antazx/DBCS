/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Despliegue.CompUsuariosFacadeRemote;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anta
 */

@WebServlet(name="Controlador", urlPatterns={"/Controlador"})
public class Controlador extends HttpServlet{
    
    @EJB
    private CompUsuariosFacadeRemote compUsuariosFacade;
    
    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        
        String action = request.getParameter("action");
        switch (action){
            case "logIn":
                System.out.println("[Controlador]: " +request.getParameter("nombre"));
                System.out.println("[Controlador]: " +request.getParameter("clave"));
                System.out.println("[Controlador]: " +request.getParameter("tipoUsuario"));
                
                String nombre = request.getParameter("nombre");
                String clave = request.getParameter("clave");
                String tipoUsuario = request.getParameter("tipoUsuario");
                
                boolean accesoPermitido = compUsuariosFacade.controlAccesos(nombre, clave, tipoUsuario);
                System.out.println("[Controlador] controlAccesos: " +accesoPermitido);
                
                String nif = compUsuariosFacade.getNIF(nombre);
                System.out.println("[Controlador] getNIF: " +nif);
                
                char bloqueado = compUsuariosFacade.bloqueado(nif);
                System.out.println("[Controlador] bloqueado: " +bloqueado);
                
                String[] licencias = compUsuariosFacade.getLicencias(nif);
                for (String licencia : licencias) {
                    System.out.println("[Controlador] getLicencias: " + licencia);
                }
                
                break;
        }
    }
}
