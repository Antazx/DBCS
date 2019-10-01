/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class UserDAO {
    
    
    private String DB_type = "derby";
    private String DB_server;
    private String DB_name;
    private String DB_user;
    private String DB_passwd;
    private String DB_URL;

    // Inicializamos variables para darles valor por defecto: si la base de datos
    //no varía simplifica el acceso.
    // Los valores por defecto de acceso a la base de datos se pueden modificar
    //mediante el otro constructor.
    public UserDAO() {
        DB_server = "localhost:1527";
        DB_name = "MiTienda";
        DB_user = "carlos";
        DB_passwd = "mambo123";
        DB_URL ="jdbc:" + DB_type + "://" + DB_server + "/" + DB_name;
    }

    public UserDAO(String DBserver, String DBname, String DBuser, String DBpasswd) {
        DB_server = DBserver;
        DB_name = DBname;
        DB_user = DBuser;
        DB_passwd = DBpasswd;
        DB_URL = "jdbc:" + DB_type + "://" + DB_server + "/" + DB_name;
}

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL,DB_user,DB_passwd);
    }
    
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
   
    public UserDTO getUser(String login, Connection connection) throws SQLException, SQLTimeoutException {
        
        UserDTO user = null;
        
        String query = "select * from usuarios where user_name = '" + login + "'";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        if ( result.next()) {
            int us_id = result.getInt("USER_ID");
            String us_log = result.getString("USER_NAME");
            String us_passwd  = result.getString("USER_PASSWD");
            user = new UserDTO(us_id,us_log,us_passwd);
            }
        
        return user;
    }
    
}
