package Dominio;

import Dominio.Tipocarnet;
import Dominio.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-09T19:14:09")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Character> bloqueado;
    public static volatile SingularAttribute<Cliente, String> nif;
    public static volatile SingularAttribute<Cliente, Usuario> usuario;
    public static volatile ListAttribute<Cliente, Tipocarnet> tipocarnetList;

}