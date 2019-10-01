/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package despliegue;

import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class DeployBean implements DeployBeanRemote {

    @Override
    public void hello() {
        System.out.println("[Deploy Bean] start");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
