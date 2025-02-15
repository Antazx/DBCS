/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anta
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva"),
    @NamedQuery(name = "Reserva.findByFechareserva", query = "SELECT r FROM Reserva r WHERE r.fechareserva = :fechareserva"),
    @NamedQuery(name = "Reserva.findByFechainicioalquiler", query = "SELECT r FROM Reserva r WHERE r.fechainicioalquiler = :fechainicioalquiler"),
    @NamedQuery(name = "Reserva.findByFechafinalquiler", query = "SELECT r FROM Reserva r WHERE r.fechafinalquiler = :fechafinalquiler"),
    @NamedQuery(name = "Reserva.findByEjecutada", query = "SELECT r FROM Reserva r WHERE r.ejecutada = :ejecutada"),
    @NamedQuery(name = "Reserva.findByNif", query = "SELECT r FROM Reserva r WHERE r.nif = :nif"),
    @NamedQuery(name = "Reserva.findByMatricula", query = "SELECT r FROM Reserva r WHERE r.matricula = :matricula")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDRESERVA")
    private Integer idreserva;
    @Column(name = "FECHARESERVA")
    @Temporal(TemporalType.DATE)
    private Date fechareserva;
    @Column(name = "FECHAINICIOALQUILER")
    @Temporal(TemporalType.DATE)
    private Date fechainicioalquiler;
    @Column(name = "FECHAFINALQUILER")
    @Temporal(TemporalType.DATE)
    private Date fechafinalquiler;
    @Column(name = "EJECUTADA")
    private Character ejecutada;
    @Column(name = "NIF")
    private String nif;
    @Column(name = "MATRICULA")
    private String matricula;

    public Reserva() {
    }

    public Reserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Integer getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Integer idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Date getFechainicioalquiler() {
        return fechainicioalquiler;
    }

    public void setFechainicioalquiler(Date fechainicioalquiler) {
        this.fechainicioalquiler = fechainicioalquiler;
    }

    public Date getFechafinalquiler() {
        return fechafinalquiler;
    }

    public void setFechafinalquiler(Date fechafinalquiler) {
        this.fechafinalquiler = fechafinalquiler;
    }

    public Character getEjecutada() {
        return ejecutada;
    }

    public void setEjecutada(Character ejecutada) {
        this.ejecutada = ejecutada;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
