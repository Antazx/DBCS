/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolaMundo;

import javax.ejb.Remote;

/**
 *
 * @author Anta
 */
@Remote
public interface HolaMundoRemote {
    public String getResource();
    public void sayHi(String name);
}
