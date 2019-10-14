/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Despliegue.CompResAlqFacadeRemote;
import Dominio.Reserva;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
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
        String fechaInicio = "";
        String fechaFin = "";
        String nif = "";
        String matricula = "";
                
        switch(action){
            
            case "addReserva":
                
                fechaInicio = request.getParameter("fechaInicio");
                fechaFin = request.getParameter("fechaFin");
                nif = request.getParameter("nif");
                matricula = request.getParameter("matricula");
                
                System.out.println("[Controlador] in: " +fechaInicio);
                System.out.println("[Controlador] in: " +fechaFin);
                System.out.println("[Controlador] in: " +nif);
                System.out.println("[Controlador] in: " +matricula);
                
                try {
                    Date inicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
                    Date fin =  new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);
                    
                    System.out.println("[Controlador] in: " +inicio.toString());
                    System.out.println("[Controlador] in: " +fin.toString());
                    
                    boolean resultReserva = compResAlqFacade.addReserva(inicio, fin, nif, matricula);
                    
                    System.out.println("[Controlador] (addReserva): " +resultReserva);
                    
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } 
                break;
            case "getReservasF":
                
                    nif = request.getParameter("nif");
                    
                    List<Reserva> reservas = compResAlqFacade.getReservasF(nif);
                    
                    if(reservas != null){
                        for(Reserva reserva: reservas){
                            System.out.println("[Controlador] (getReservasF): " +reserva.getIdreserva());
                        }
                    } else {
                         System.out.println("[Controlador] (getReservasF): no existen reservas para " +nif);
                    }
                    
                break;
                
            case "addAlquiler":
                    
                    String nEmpleado = request.getParameter("nEmpleado");
                    float km = Float.parseFloat(request.getParameter("km"));
                    int idReserva = Integer.parseInt(request.getParameter("idResrva"));
                    
                    boolean resultAlquiler = compResAlqFacade.addAlquiler(idReserva, km, nEmpleado);
                    System.out.println("[Controlador] (addAlquiler): " +resultAlquiler);
                    
                break;
                
            case "consultaReserva":
                    
                fechaInicio = request.getParameter("fechaInicio");
                fechaFin = request.getParameter("fechaFin");
                    
                try {
                    Date inicio = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
                    Date fin =  new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin);

                    String[] reservados = compResAlqFacade.getReservados(inicio, fin);
                    if(reservados != null){
                        for(String reserva: reservados){
                            System.out.println("[Controlador] (getReservados): " +reserva);
                        }
                    } else {
                        System.out.println("[Controlador] (getReservados): no hay reserva para esas fechas");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
                
            default:
                break;
        }
    }
}
