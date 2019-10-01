/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Despliegue;

import DAO.UserDAO;
import DAO.UserDTO;
import MyExceptions.AccessDBException;
import MyExceptions.OpenDBException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

/**
 *
 * @author Carlos
 */
public class LoginFacade {

    public boolean isUser(String us_id) throws OpenDBException, AccessDBException {

        Connection connection;
        boolean result = false;
        UserDAO userDAO = new UserDAO();

        try {
            connection = userDAO.getConnection();
        } catch (SQLException e) {
            throw new OpenDBException("Error al abrir la base de datos: " + e);
        }

        try {
            UserDTO userDTO = userDAO.getUser(us_id, connection);
            if (userDTO != null) { //si vale null es que no se ha encontrado el usuario
                result = true;
            }
        } catch (SQLTimeoutException e) {
            throw new AccessDBException("Timeout exception: " + e);
        } catch (SQLException e) {
            throw new AccessDBException("Error al acceder a la base de datos: " + e);
        }

        return result;
    }

    public boolean isUser(String us_id, String DBserver, String DBname,
            String DBuser, String DBpasswd) throws OpenDBException, AccessDBException {

        Connection connection;
        boolean result = false;
        UserDAO userDAO = new UserDAO(DBserver, DBname, DBuser, DBpasswd);

        try {
            connection = userDAO.getConnection();
        } catch (SQLException e) {
            throw new OpenDBException("Error al abrir la base de datos: " + e);
        }

        try {
            UserDTO userDTO = userDAO.getUser(us_id, connection);
            if (userDTO != null) { //si vale null es que no se ha encontrado el usuario
                result = true;
            }
        } catch (SQLTimeoutException e) {
            throw new AccessDBException("Timeout exception: " + e);
        } catch (SQLException e) {
            throw new AccessDBException("Error al acceder a la base de datos: " + e);
        }

        return result;
    }

    public boolean isPasswdOK(String us_id, String us_passwd) throws OpenDBException, AccessDBException {

        Connection connection;
        boolean result = false;
        UserDAO userDAO = new UserDAO();

        try {
            connection = userDAO.getConnection();
        } catch (SQLException e) {
            throw new OpenDBException("Error al abrir la base de datos: " + e);
        }

        try {
            UserDTO userDTO = userDAO.getUser(us_id, connection);
            result = userDTO.passwd.equals(us_passwd);
        } catch (SQLTimeoutException e) {
            throw new AccessDBException("Timeout exception: " + e);
        } catch (SQLException e) {
            throw new AccessDBException("Error al acceder a la base de datos: " + e);
        }

        return result;
    }

    public boolean isPasswdOK(String us_id, String us_passwd, String DBserver, String DBname,
            String DBuser, String DBpasswd) throws OpenDBException, AccessDBException {

        Connection connection;
        boolean result = false;
        UserDAO userDAO = new UserDAO(DBserver, DBname, DBuser, DBpasswd);

        try {
            connection = userDAO.getConnection();
        } catch (SQLException e) {
            throw new OpenDBException("Error al abrir la base de datos: " + e);
        }

        try {
            UserDTO userDTO = userDAO.getUser(us_id, connection);
            result = userDTO.passwd.equals(us_passwd);
        } catch (SQLTimeoutException e) {
            throw new AccessDBException("Timeout exception: " + e);
        } catch (SQLException e) {
            throw new AccessDBException("Error al acceder a la base de datos: " + e);
        }

        return result;
    }
    
    public int getUsDBId (String us_id) throws OpenDBException, AccessDBException {

        Connection connection;
        UserDAO userDAO = new UserDAO();
        int DBId = -1; // valor de error

        try {
            connection = userDAO.getConnection();
        } catch (SQLException e) {
            throw new OpenDBException("Error al abrir la base de datos: " + e);
        }

        try {
            UserDTO userDTO = userDAO.getUser(us_id, connection);
            DBId = userDTO.id;
        } catch (SQLTimeoutException e) {
            throw new AccessDBException("Timeout exception: " + e);
        } catch (SQLException e) {
            throw new AccessDBException("Error al acceder a la base de datos: " + e);
        }

        return DBId;
    }

    public int getUsDBId(String us_id, String DBserver, String DBname,
            String DBuser, String DBpasswd) throws OpenDBException, AccessDBException {

        Connection connection;
        UserDAO userDAO = new UserDAO(DBserver, DBname, DBuser, DBpasswd);
        int DBId = -1; // valor de error

        try {
            connection = userDAO.getConnection();
        } catch (SQLException e) {
            throw new OpenDBException("Error al abrir la base de datos: " + e);
        }

        try {
            UserDTO userDTO = userDAO.getUser(us_id, connection);
            DBId = userDTO.id;
        } catch (SQLTimeoutException e) {
            throw new AccessDBException("Timeout exception: " + e);
        } catch (SQLException e) {
            throw new AccessDBException("Error al acceder a la base de datos: " + e);
        }

        return DBId;
    }
}
