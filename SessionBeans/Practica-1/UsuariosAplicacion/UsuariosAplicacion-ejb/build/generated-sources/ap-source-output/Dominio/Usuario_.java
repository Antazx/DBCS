package Dominio;

import Dominio.Cliente;
import Dominio.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T19:14:09")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Cliente> cliente;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile ListAttribute<Usuario, Empleado> empleadoList;
    public static volatile SingularAttribute<Usuario, String> nif;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> direccionelectronica;

}