/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anta
 */
@Entity
@Table(name = "LICENCIASPORMODELO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licenciaspormodelo.findAll", query = "SELECT l FROM Licenciaspormodelo l"),
    @NamedQuery(name = "Licenciaspormodelo.findById", query = "SELECT l FROM Licenciaspormodelo l WHERE l.id = :id"),
    @NamedQuery(name = "Licenciaspormodelo.findByTipo", query = "SELECT l FROM Licenciaspormodelo l WHERE l.tipo = :tipo")})
public class Licenciaspormodelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TIPO")
    private String tipo;
    @JoinColumn(name = "IDMODELO", referencedColumnName = "IDMODELO")
    @ManyToOne(optional = false)
    private Modelo idmodelo;

    public Licenciaspormodelo() {
    }

    public Licenciaspormodelo(Integer id) {
        this.id = id;
    }

    public Licenciaspormodelo(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Modelo getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Modelo idmodelo) {
        this.idmodelo = idmodelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licenciaspormodelo)) {
            return false;
        }
        Licenciaspormodelo other = (Licenciaspormodelo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Licenciaspormodelo[ id=" + id + " ]";
    }
    
}
