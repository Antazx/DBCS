/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliententerpriseapplication.pkg4;

import HolaMundo.HolaMundoRemote;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Anta
 */
public class ClientEnterpriseApplication4 {

    /**
     * @param args the command line arguments
     * @throws javax.naming.NamingException
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Properties prop = new Properties();
        prop.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
        prop.setProperty("org.omg.CORBA.ORBInitialPort","3700");
        Context context = new InitialContext(prop);
        
        //Same as: Context context = new InitialContext();
        
        HolaMundoRemote bean = (HolaMundoRemote) context.lookup("java:global/EnterpriseApplication-1/EnterpriseApplication-1-ejb/HolaMundo");
        bean.sayHi("Guillermo");
    }
}
