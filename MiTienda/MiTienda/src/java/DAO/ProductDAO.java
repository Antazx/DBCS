/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Carlos
 */
public class ProductDAO {
    
    private String DB_type = "derby";
    private String DB_server = "localhost:1527";
    private String DB_name = "MiTienda";
    private String DB_user = "carlos";
    private String DB_passwd = "mambo123";
    private String DB_URL ="jdbc:" + DB_type + "://" + DB_server + "/" + DB_name;
    
    public ArrayList <ProductDTO> getCatalogo()  throws SQLException{
        ArrayList <ProductDTO> catalogo = null;
        
        Connection conexion = DriverManager.getConnection(DB_URL,DB_user,DB_passwd);
        String query = "select * from productos";
        Statement statement = conexion.createStatement();
        ResultSet resultado = statement.executeQuery(query);
        if (resultado.next()) {
            catalogo = new ArrayList<ProductDTO>();
            do {
                ProductDTO item = new ProductDTO();
                item.setId(resultado.getInt("PROD_ID"));
                item.setProd_desc(resultado.getString("PROD_DESCRIPTION"));
                item.setPrice(resultado.getFloat("PROD_PRICE"));
                item.setItem_id(resultado.getString("ITEM_ID"));
                catalogo.add(item);
            } while (resultado.next());
        }

        conexion.close();
        return catalogo;
    }
    
}
