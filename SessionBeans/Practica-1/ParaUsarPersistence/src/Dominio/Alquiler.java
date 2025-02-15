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
@Table(name = "ALQUILER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a"),
    @NamedQuery(name = "Alquiler.findByIdalquiler", query = "SELECT a FROM Alquiler a WHERE a.idalquiler = :idalquiler"),
    @NamedQuery(name = "Alquiler.findByFechainicio", query = "SELECT a FROM Alquiler a WHERE a.fechainicio = :fechainicio"),
    @NamedQuery(name = "Alquiler.findByFechafin", query = "SELECT a FROM Alquiler a WHERE a.fechafin = :fechafin"),
    @NamedQuery(name = "Alquiler.findByKilometrajesalida", query = "SELECT a FROM Alquiler a WHERE a.kilometrajesalida = :kilometrajesalida"),
    @NamedQuery(name = "Alquiler.findByCliente", query = "SELECT a FROM Alquiler a WHERE a.cliente = :cliente"),
    @NamedQuery(name = "Alquiler.findByRealizadopor", query = "SELECT a FROM Alquiler a WHERE a.realizadopor = :realizadopor"),
    @NamedQuery(name = "Alquiler.findByMatricula", query = "SELECT a FROM Alquiler a WHERE a.matricula = :matricula")})
public class Alquiler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDALQUILER")
    private Integer idalquiler;
    @Basic(optional = false)
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "FECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date fechafin;
    @Basic(optional = false)
    @Column(name = "KILOMETRAJESALIDA")
    private float kilometrajesalida;
    @Basic(optional = false)
    @Column(name = "CLIENTE")
    private String cliente;
    @Basic(optional = false)
    @Column(name = "REALIZADOPOR")
    private String realizadopor;
    @Basic(optional = false)
    @Column(name = "MATRICULA")
    private String matricula;

    public Alquiler() {
    }

    public Alquiler(Integer idalquiler) {
        this.idalquiler = idalquiler;
    }

    public Alquiler(Integer idalquiler, Date fechainicio, Date fechafin, float kilometrajesalida, String cliente, String realizadopor, String matricula) {
        this.idalquiler = idalquiler;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.kilometrajesalida = kilometrajesalida;
        this.cliente = cliente;
        this.realizadopor = realizadopor;
        this.matricula = matricula;
    }

    public Integer getIdalquiler() {
        return idalquiler;
    }

    public void setIdalquiler(Integer idalquiler) {
        this.idalquiler = idalquiler;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public float getKilometrajesalida() {
        return kilometrajesalida;
    }

    public void setKilometrajesalida(float kilometrajesalida) {
        this.kilometrajesalida = kilometrajesalida;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRealizadopor() {
        return realizadopor;
    }

    public void setRealizadopor(String realizadopor) {
        this.realizadopor = realizadopor;
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
        hash += (idalquiler != null ? idalquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alquiler)) {
            return false;
        }
        Alquiler other = (Alquiler) object;
        if ((this.idalquiler == null && other.idalquiler != null) || (this.idalquiler != null && !this.idalquiler.equals(other.idalquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Alquiler[ idalquiler=" + idalquiler + " ]";
    }
    
}
