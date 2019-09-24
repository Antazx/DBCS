/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import componente.CarroBeanRemote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Pedido;

/**
 *
 * @author Anta
 */
@WebServlet(name="Controlador", urlPatterns={"/Controlador"})
public class Controlador extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processRequest(HttpServletRequest request, 
            HttpServletResponse response) throws NamingException, ServletException, IOException{
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action");
        String url =  "";
        
        switch(action){
            case "Pedir":
                if(session == null || session.getAttribute("Carro") == null){
                    session = request.getSession();
                    CarroBeanRemote carro = lookupCarro();
                    carro.createCarro();
                    System.out.println("<---------------------- Carro creado ------------------------>");
                    session.setAttribute("Carro", carro);
                }
                
                String producto = request.getParameter("producto");
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                Pedido pedido = new Pedido(producto, cantidad);
                CarroBeanRemote carro = (CarroBeanRemote) session.getAttribute("Carro");
                carro.añadirPedido(pedido);
                session.setAttribute("Carro", carro);
                
                url = "/index.html";
                
                break;
            case "Ver Carro":
                
                if(session == null){
                    System.out.println();
                }else{
                    CarroBeanRemote carro2 = (CarroBeanRemote) session.getAttribute("Carro");
                    session.setAttribute("Carro", null);
                    
                    ArrayList<Pedido> pedidos = carro2.getCarro();
                    request.setAttribute("Pedidos", pedidos);
                    
                    for (int i = 0; i < pedidos.size(); i++){
                        System.out.println(pedidos.get(i).getProducto());
                        System.out.println(pedidos.get(i).getCantidad());
                    }
                    
                    url = "/verCarro.jsp";
                }
                break;
        }
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    private CarroBeanRemote lookupCarro() throws NamingException{
        Context context = new InitialContext();
        
        CarroBeanRemote carro = (CarroBeanRemote) context.lookup("java:global/EnterpriseApplication-5/EnterpriseApplication-5-ejb/CarroBean");
        return carro;
    }
}
