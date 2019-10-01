/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;

/**
 *
 * @author Carlos
 */
public class UserDTO implements Serializable {
    
    public int id;
    public String login;
    public String passwd;

   
    public UserDTO(int Id, String userId, String Passwd) {
        this.id = Id;
        this.login = userId;
        this.passwd = Passwd;
    }
    
    
}
