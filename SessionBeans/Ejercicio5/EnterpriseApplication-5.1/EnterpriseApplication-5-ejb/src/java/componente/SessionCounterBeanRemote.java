/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import javax.ejb.Remote;

/**
 *
 * @author Anta
 */
@Remote
public interface SessionCounterBeanRemote {
    public void updateCount();
    public int getCount();
    public void setCount(int count);
}
