/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conversor.ConversorBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet (name="Controlador", urlPatterns={"/Controlador"})
public class Controlador extends HttpServlet{
    
    @EJB
    private ConversorBeanLocal conversor;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet: " +request.getParameter("name"));
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        try {
            out.println("<div>");
            out.println("<h1> Millas: " +conversor.convertir(request.getParameter("kilometros")) +"</h1>");
            out.println("</div>");
        } finally {
            out.close();
        }
   }
}
