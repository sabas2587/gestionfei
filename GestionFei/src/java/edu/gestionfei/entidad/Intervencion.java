/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_Intervencion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Intervencion.findAll", query = "SELECT i FROM Intervencion i")
    , @NamedQuery(name = "Intervencion.findByPkidAdolescente", query = "SELECT i FROM Intervencion i WHERE i.pkidAdolescente = :pkidAdolescente")
    , @NamedQuery(name = "Intervencion.findByFechaIntervension", query = "SELECT i FROM Intervencion i WHERE i.fechaIntervension = :fechaIntervension")
    , @NamedQuery(name = "Intervencion.findByDescripcionActividad", query = "SELECT i FROM Intervencion i WHERE i.descripcionActividad = :descripcionActividad")})
public class Intervencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idAdolescente")
    private Integer pkidAdolescente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIntervension")
    @Temporal(TemporalType.DATE)
    private Date fechaIntervension;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcionActividad")
    private String descripcionActividad;
    @JoinColumn(name = "pk_idAdolescente", referencedColumnName = "pk_idAdolescente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Adolescente adolescente;
    @JoinColumn(name = "fk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false)
    private Usuario fkidUsuario;

    public Intervencion() {
    }

    public Intervencion(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Intervencion(Integer pkidAdolescente, Date fechaIntervension, String descripcionActividad) {
        this.pkidAdolescente = pkidAdolescente;
        this.fechaIntervension = fechaIntervension;
        this.descripcionActividad = descripcionActividad;
    }

    public Integer getPkidAdolescente() {
        return pkidAdolescente;
    }

    public void setPkidAdolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Date getFechaIntervension() {
        return fechaIntervension;
    }

    public void setFechaIntervension(Date fechaIntervension) {
        this.fechaIntervension = fechaIntervension;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Adolescente getAdolescente() {
        return adolescente;
    }

    public void setAdolescente(Adolescente adolescente) {
        this.adolescente = adolescente;
    }

    public Usuario getFkidUsuario() {
        return fkidUsuario;
    }

    public void setFkidUsuario(Usuario fkidUsuario) {
        this.fkidUsuario = fkidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidAdolescente != null ? pkidAdolescente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Intervencion)) {
            return false;
        }
        Intervencion other = (Intervencion) object;
        if ((this.pkidAdolescente == null && other.pkidAdolescente != null) || (this.pkidAdolescente != null && !this.pkidAdolescente.equals(other.pkidAdolescente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Intervencion[ pkidAdolescente=" + pkidAdolescente + " ]";
    }
    
}
