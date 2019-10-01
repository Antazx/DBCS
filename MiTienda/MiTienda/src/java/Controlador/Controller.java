package Controlador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import MyExceptions.AccessDBException;
import Despliegue.LoginFacade;
import MyExceptions.OpenDBException;
import Despliegue.Facade;
//import DAO.InvoiceDTO;
import DAO.ProductDAO;
import DAO.ProductDTO;
import DAO.UserDAO;
import DAO.UserDTO;
import MyExceptions.MiTiendaException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "MiTienda_Controlador", urlPatterns = {"/controlador"})
public class Controller extends HttpServlet {

    private String fecha_arranque;
    private int num_accesos;
    private String url;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int num_accesos_local;
            HttpSession sesion = request.getSession();
            if (sesion.getAttribute("usuario") == null) { // comienzo sesion
                String user = request.getParameter("usuario");
                String passwd = request.getParameter("clave");

                // Control de acceso del usuario
                LoginFacade acceso = new LoginFacade();
                if (!acceso.isUser(user)) {
                    throw new MiTiendaException("Usuario No Registrado");
                }
                if (!acceso.isPasswdOK(user, passwd)) {
                    throw new MiTiendaException("Clave incorrecta");
                }
                int user_DB_id_temp = acceso.getUsDBId(user);
                if (acceso.getUsDBId(user) == -1) {
                    throw new MiTiendaException("No se ha podido obtener el identificador "
                            + "del usuario");
                } 
                String user_DB_id = Integer.toString(user_DB_id_temp);

                // Leemos catalogo y lo guardamos en sesion
                // Como no va a cambiar durante la sesión y tiene que estar 
                //disponible durante toda ella lo guardamos ahí. Así solo accedemos
                //a la base de datos una vez por sesión
                //ProductoDAO prodDAO = new ProductDAO();
                Facade fachada = new Facade();
                ArrayList<ProductDTO> catalogo = fachada.getCatalogo();
                sesion.setAttribute("catalogo", catalogo);
                
                Cookie cookie = new Cookie("MiTienda_user", user);
                response.addCookie(cookie);
                sesion.setAttribute("usuario", user);
                sesion.setAttribute("us_id", user_DB_id);
                synchronized (this) {
                    num_accesos_local = ++num_accesos;
                }
                sesion.setAttribute("accesos", num_accesos);
                this.url = "/Catalog.jsp";
                sesion.setAttribute("siguienteURL", url);
                //RequestDispatcher respuesta = getServletContext().getRequestDispatcher(url);
                //respuesta.forward(request, response);
            } else {  //sesion ya abierta
                String accion = request.getParameter("accion");
                if (accion == null) { // No se viene de formulario
                    this.url = (String) sesion.getAttribute("siguienteURL");
                    //RequestDispatcher respuesta = getServletContext().getRequestDispatcher(url);
                    //respuesta.forward(request, response);
                } else { // Caso navegacion normal
                    switch (accion) {
                        case "Agregar a Carro": //Se añade y muestra el carro
                            HashMap<String, String> carro;
                            if (sesion.getAttribute("carro") == null) { // es la primera compra
                                carro = new HashMap<String, String>();
                                int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                                float precio = Float.parseFloat(request.getParameter("Precio"));
                                float importe = cantidad * precio;
                                carro.put((String) request.getParameter("Producto"),
                                        Float.toString(importe));
                                sesion.setAttribute("carro", carro);
                                //Creamos cookie con ultima producto
                                Cookie cookie = new Cookie("ultimo_prod",
                                        (String) request.getParameter("Producto"));
                                response.addCookie(cookie);
                            } else { //Hay compra anterior
                                carro = (HashMap<String,String>) sesion.getAttribute("carro");
                                int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
                                float precio = Float.parseFloat(request.getParameter("Precio"));
                                float importe = cantidad * precio;
                                carro.put((String) request.getParameter("Producto"),
                                        Float.toString(importe));
                                sesion.setAttribute("carro", carro);
                                //Creamos cookie con ultima producto
                                Cookie cookie = new Cookie("ultimo_prod",
                                        (String) request.getParameter("Producto"));
                                response.addCookie(cookie);
                            }
                            this.url = "/Cart.jsp";
                            sesion.setAttribute("siguienteURL", this.url);
                            break;
                        case "Ver Catalogo":
                            this.url = "/Catalog.jsp";
                            sesion.setAttribute("siguienteURL", this.url);
                            break;
                        case "Finalizar Compra": //PARTE A COMPLETAR POR EL ALUMNO
                            // Leemos datos de la factura y lo guardamos en request
                            //para darle sólo validez durante la petición
                            
                            this.url = "/Invoice.jsp";
                            sesion.setAttribute("siguienteURL", this.url);
                            break;
                        case "Comprar":
                            //Aquí se salvaría el carro usando el método de Facade
                            this.url = "/EndPurchase.jsp";
                            sesion.setAttribute("siguienteURL", this.url);
                            break;
                    }
                }
            }
        } catch (AccessDBException e) {
            request.setAttribute("tipo", e);
            this.url = "/error.jsp?error=StdException";
        } catch (OpenDBException e) {
            request.setAttribute("tipo", e);
            this.url = "/error.jsp?error=StdException";
        } catch (MiTiendaException e) {
            request.setAttribute("tipo", e);
            this.url = "/error.jsp?error=MiException";
        } catch (SQLException e) {
            request.setAttribute("tipo", e);
            this.url = "/error.jsp?error=StdException";
        } catch (Exception e) {
            request.setAttribute("tipo", e);
            this.url = "/error.jsp?error=StdException";
        } finally {
            RequestDispatcher respuesta = getServletContext().getRequestDispatcher(this.url);
            respuesta.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
