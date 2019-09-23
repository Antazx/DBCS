/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import javax.ejb.Stateless;

/**
 *
 * @author Anta
 */
@Stateless
public class ConversorBean implements ConversorBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public double convertirKM(String kilometros) {
         if(kilometros.equals(""))
            return 0;
        
        int number = Integer.parseInt(kilometros);
        double millas = number * 0.621371;
        return millas;
    }

    @Override
    public double convertirMI(String millas) {
         if(millas.equals(""))
            return 0;
        
        int number = Integer.parseInt(millas);
        double kilometros = number / 0.621371;
        return kilometros;
    }
}
