/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

import javax.ejb.Local;

/**
 *
 * @author Anta
 */
@Local
public interface ConversorBeanLocal {
    public double convertir(String kilometros);
}
