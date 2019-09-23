/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import componentes.CarroLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    @EJB
    private CarroLocal carro;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("[doPost]: " +request.getParameter("producto"));
        System.out.println("[doPost]: " +request.getParameter("cantidad"));
        
        String producto = (String) request.getParameter("producto");
        String cantidad = request.getParameter("cantidad");
        
        carro.añadir(producto, cantidad);
        
        response.sendRedirect("index.html");
    }
    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        ArrayList<String> pedidos = carro.getPedidos();
        
        PrintWriter out = response.getWriter();
        
        try {
            for(int i = 0; i < pedidos.size(); i++){
                System.out.println("[doGet"+pedidos.size()+"]: " +pedidos.toString());
                
                out.println("<div>");
                out.println("<p>" +pedidos.get(i) +"</h1>");
                out.println("</div>");
            } 
        } finally {
            out.close();
        }
    }
}
