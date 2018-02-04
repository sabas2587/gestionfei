/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.entidad;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_CriterioEncuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriterioEncuesta.findAll", query = "SELECT c FROM CriterioEncuesta c")
    , @NamedQuery(name = "CriterioEncuesta.findByPkidCriterioEncuesta", query = "SELECT c FROM CriterioEncuesta c WHERE c.pkidCriterioEncuesta = :pkidCriterioEncuesta")
    , @NamedQuery(name = "CriterioEncuesta.findByNombreCriterio", query = "SELECT c FROM CriterioEncuesta c WHERE c.nombreCriterio = :nombreCriterio")})
public class CriterioEncuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idCriterioEncuesta")
    private Integer pkidCriterioEncuesta;
    @Size(max = 100)
    @Column(name = "nombreCriterio")
    private String nombreCriterio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidCriterioEncuesta")
    private List<PreguntasEncuestahasCriterioEncuesta> preguntasEncuestahasCriterioEncuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidCriterioEncuesta")
    private List<Escala> escalaList;

    public CriterioEncuesta() {
    }

    public CriterioEncuesta(Integer pkidCriterioEncuesta) {
        this.pkidCriterioEncuesta = pkidCriterioEncuesta;
    }

    public Integer getPkidCriterioEncuesta() {
        return pkidCriterioEncuesta;
    }

    public void setPkidCriterioEncuesta(Integer pkidCriterioEncuesta) {
        this.pkidCriterioEncuesta = pkidCriterioEncuesta;
    }

    public String getNombreCriterio() {
        return nombreCriterio;
    }

    public void setNombreCriterio(String nombreCriterio) {
        this.nombreCriterio = nombreCriterio;
    }

    @XmlTransient
    public List<PreguntasEncuestahasCriterioEncuesta> getPreguntasEncuestahasCriterioEncuestaList() {
        return preguntasEncuestahasCriterioEncuestaList;
    }

    public void setPreguntasEncuestahasCriterioEncuestaList(List<PreguntasEncuestahasCriterioEncuesta> preguntasEncuestahasCriterioEncuestaList) {
        this.preguntasEncuestahasCriterioEncuestaList = preguntasEncuestahasCriterioEncuestaList;
    }

    @XmlTransient
    public List<Escala> getEscalaList() {
        return escalaList;
    }

    public void setEscalaList(List<Escala> escalaList) {
        this.escalaList = escalaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidCriterioEncuesta != null ? pkidCriterioEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriterioEncuesta)) {
            return false;
        }
        CriterioEncuesta other = (CriterioEncuesta) object;
        if ((this.pkidCriterioEncuesta == null && other.pkidCriterioEncuesta != null) || (this.pkidCriterioEncuesta != null && !this.pkidCriterioEncuesta.equals(other.pkidCriterioEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.CriterioEncuesta[ pkidCriterioEncuesta=" + pkidCriterioEncuesta + " ]";
    }
    
}
