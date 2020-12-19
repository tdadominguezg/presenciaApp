/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdadominguezg;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deaqu
 */
@Entity
@Table(name = "RELACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacion.findAll", query = "SELECT r FROM Relacion r")
    , @NamedQuery(name = "Relacion.findById", query = "SELECT r FROM Relacion r WHERE r.id = :id")})
public class Relacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "PELICULA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Pelicula peliculaId;
    @JoinColumn(name = "PERSONA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Persona personaId;
    @JoinColumn(name = "SESION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Sesion sesionId;

    public Relacion() {
    }

    public Relacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pelicula getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Pelicula peliculaId) {
        this.peliculaId = peliculaId;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
    }

    public Sesion getSesionId() {
        return sesionId;
    }

    public void setSesionId(Sesion sesionId) {
        this.sesionId = sesionId;
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
        if (!(object instanceof Relacion)) {
            return false;
        }
        Relacion other = (Relacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdadominguezg.Relacion[ id=" + id + " ]";
    }
    
}
