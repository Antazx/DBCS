/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

//import DAO.InvoiceDAO;
//import DAO.InvoiceDTO;
import DAO.ProductDAO;
import DAO.ProductDTO;
import MyExceptions.MiTiendaException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Carlos
 */
public class Facade {

    public ArrayList<ProductDTO> getCatalogo() throws SQLException, MiTiendaException {
        ProductDAO prodDAO = new ProductDAO();
        ArrayList<ProductDTO> catalogo = prodDAO.getCatalogo();
        if (catalogo == null) {
            throw new MiTiendaException("No se ha podido acceder al catalogo");
        }
        return catalogo;
    }

    /* PARTE A COMPLETAR POR EL ALUMNO 
     
    public InvoiceDTO getDatosFactura(String us_DB_id) throws SQLException, MiTiendaException {
      
    }
    */
    

}
