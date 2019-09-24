/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componente;

import javax.ejb.Singleton;

/**
 *
 * @author Anta
 */
@Singleton
public class SessionCounterBean implements SessionCounterBeanRemote {
    
    private int count;
    
    @Override
    public void updateCount() {
        count++;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
