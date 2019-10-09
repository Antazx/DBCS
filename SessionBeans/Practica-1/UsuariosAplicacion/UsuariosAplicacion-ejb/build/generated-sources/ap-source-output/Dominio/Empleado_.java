package Dominio;

import Dominio.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T19:14:09")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Character> tipoempleado;
    public static volatile SingularAttribute<Empleado, Usuario> nif;
    public static volatile SingularAttribute<Empleado, Date> fechacontratacion;
    public static volatile SingularAttribute<Empleado, String> numeroempleado;

}