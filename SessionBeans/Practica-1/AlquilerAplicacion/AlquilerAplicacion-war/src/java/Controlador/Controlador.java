/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Despliegue.CompResAlqFacadeRemote;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private CompResAlqFacadeRemote compResAlqFacade;
    
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
        
        switch(action){
            
            case "addReserva":
                
                String fechaInicio = request.getParameter("fechaInicio");
                String fechaFin = request.getParameter("fechaFin");
                String nif = request.getParameter("nif");
                String matricula = request.getParameter("matricula");
                
                System.out.println("[Controlador] in: " +fechaInicio);
                System.out.println("[Controlador] in: " +fechaFin);
                System.out.println("[Controlador] in: " +nif);
                System.out.println("[Controlador] in: " +matricula);
                
                try {
                    Date inicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
                    Date fin =  new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
                    
                    System.out.println("[Controlador] in: " +inicio.toString());
                    System.out.println("[Controlador] in: " +fin.toString());
                    
                    boolean result = compResAlqFacade.addReserva(inicio, fin, nif, matricula);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } 
                break;
                
            default:
                break;
        }
    }
}
