/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_Valoracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoracion.findAll", query = "SELECT v FROM Valoracion v")
    , @NamedQuery(name = "Valoracion.findByPkidValoracion", query = "SELECT v FROM Valoracion v WHERE v.pkidValoracion = :pkidValoracion")
    , @NamedQuery(name = "Valoracion.findByFechaValoracion", query = "SELECT v FROM Valoracion v WHERE v.fechaValoracion = :fechaValoracion")})
public class Valoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idValoracion")
    private Integer pkidValoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaValoracion")
    @Temporal(TemporalType.DATE)
    private Date fechaValoracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidValoracion")
    private List<PreguntasEncuesta> preguntasEncuestaList;
    @JoinColumn(name = "fk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false)
    private Usuario fkidUsuario;
    @JoinColumn(name = "fk_idAdolescente", referencedColumnName = "pk_idAdolescente")
    @ManyToOne(optional = false)
    private Adolescente fkidAdolescente;

    public Valoracion() {
    }

    public Valoracion(Integer pkidValoracion) {
        this.pkidValoracion = pkidValoracion;
    }

    public Valoracion(Integer pkidValoracion, Date fechaValoracion) {
        this.pkidValoracion = pkidValoracion;
        this.fechaValoracion = fechaValoracion;
    }

    public Integer getPkidValoracion() {
        return pkidValoracion;
    }

    public void setPkidValoracion(Integer pkidValoracion) {
        this.pkidValoracion = pkidValoracion;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    @XmlTransient
    public List<PreguntasEncuesta> getPreguntasEncuestaList() {
        return preguntasEncuestaList;
    }

    public void setPreguntasEncuestaList(List<PreguntasEncuesta> preguntasEncuestaList) {
        this.preguntasEncuestaList = preguntasEncuestaList;
    }

    public Usuario getFkidUsuario() {
        return fkidUsuario;
    }

    public void setFkidUsuario(Usuario fkidUsuario) {
        this.fkidUsuario = fkidUsuario;
    }

    public Adolescente getFkidAdolescente() {
        return fkidAdolescente;
    }

    public void setFkidAdolescente(Adolescente fkidAdolescente) {
        this.fkidAdolescente = fkidAdolescente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidValoracion != null ? pkidValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoracion)) {
            return false;
        }
        Valoracion other = (Valoracion) object;
        if ((this.pkidValoracion == null && other.pkidValoracion != null) || (this.pkidValoracion != null && !this.pkidValoracion.equals(other.pkidValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Valoracion[ pkidValoracion=" + pkidValoracion + " ]";
    }
    
}
