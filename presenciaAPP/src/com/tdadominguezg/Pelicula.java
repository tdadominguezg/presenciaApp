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
@Table(name = "PELICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findById", query = "SELECT p FROM Pelicula p WHERE p.id = :id")
    , @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Pelicula.findByFechaStart", query = "SELECT p FROM Pelicula p WHERE p.fechaStart = :fechaStart")
    , @NamedQuery(name = "Pelicula.findByFechaEnd", query = "SELECT p FROM Pelicula p WHERE p.fechaEnd = :fechaEnd")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "FECHA_START")
    @Temporal(TemporalType.DATE)
    private Date fechaStart;
    @Basic(optional = false)
    @Column(name = "FECHA_END")
    @Temporal(TemporalType.DATE)
    private Date fechaEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private Collection<Sesion> sesionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculaId")
    private Collection<Relacion> relacionCollection;

    public Pelicula() {
    }

    public Pelicula(Integer id) {
        this.id = id;
    }

    public Pelicula(Integer id, String titulo, Date fechaStart, Date fechaEnd) {
        this.id = id;
        this.titulo = titulo;
        this.fechaStart = fechaStart;
        this.fechaEnd = fechaEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaStart() {
        return fechaStart;
    }

    public void setFechaStart(Date fechaStart) {
        this.fechaStart = fechaStart;
    }

    public Date getFechaEnd() {
        return fechaEnd;
    }

    public void setFechaEnd(Date fechaEnd) {
        this.fechaEnd = fechaEnd;
    }

    @XmlTransient
    public Collection<Sesion> getSesionCollection() {
        return sesionCollection;
    }

    public void setSesionCollection(Collection<Sesion> sesionCollection) {
        this.sesionCollection = sesionCollection;
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
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdadominguezg.Pelicula[ id=" + id + " ]";
    }
    
}
