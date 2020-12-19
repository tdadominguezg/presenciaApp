/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdadominguezg;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author deaqu
 */
@Entity
@Table(name = "SESION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s")
    , @NamedQuery(name = "Sesion.findById", query = "SELECT s FROM Sesion s WHERE s.id = :id")
    , @NamedQuery(name = "Sesion.findByCodigo", query = "SELECT s FROM Sesion s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Sesion.findByDiaHora", query = "SELECT s FROM Sesion s WHERE s.diaHora = :diaHora")})
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "DIA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaHora;
    @JoinColumn(name = "PELICULA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pelicula pelicula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sesionId")
    private Collection<Relacion> relacionCollection;

    public Sesion() {
    }

    public Sesion(Integer id) {
        this.id = id;
    }

    public Sesion(Integer id, String codigo, Date diaHora) {
        this.id = id;
        this.codigo = codigo;
        this.diaHora = diaHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(Date diaHora) {
        this.diaHora = diaHora;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @XmlTransient
    public Collection<Relacion> getRelacionCollection() {
        return relacionCollection;
    }

    public void setRelacionCollection(Collection<Relacion> relacionCollection) {
        this.relacionCollection = relacionCollection;
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
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdadominguezg.Sesion[ id=" + id + " ]";
    }
    
}
