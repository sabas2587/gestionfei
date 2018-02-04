/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.entidad;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_PreguntasEncuesta_has_CriterioEncuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntasEncuestahasCriterioEncuesta.findAll", query = "SELECT p FROM PreguntasEncuestahasCriterioEncuesta p")
    , @NamedQuery(name = "PreguntasEncuestahasCriterioEncuesta.findByPkidPreguntasEncuesta", query = "SELECT p FROM PreguntasEncuestahasCriterioEncuesta p WHERE p.pkidPreguntasEncuesta = :pkidPreguntasEncuesta")})
public class PreguntasEncuestahasCriterioEncuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idPreguntasEncuesta")
    private Integer pkidPreguntasEncuesta;
    @JoinColumn(name = "pk_idPreguntasEncuesta", referencedColumnName = "pk_idPreguntasEncuesta", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PreguntasEncuesta preguntasEncuesta;
    @JoinColumn(name = "fk_idCriterioEncuesta", referencedColumnName = "pk_idCriterioEncuesta")
    @ManyToOne(optional = false)
    private CriterioEncuesta fkidCriterioEncuesta;

    public PreguntasEncuestahasCriterioEncuesta() {
    }

    public PreguntasEncuestahasCriterioEncuesta(Integer pkidPreguntasEncuesta) {
        this.pkidPreguntasEncuesta = pkidPreguntasEncuesta;
    }

    public Integer getPkidPreguntasEncuesta() {
        return pkidPreguntasEncuesta;
    }

    public void setPkidPreguntasEncuesta(Integer pkidPreguntasEncuesta) {
        this.pkidPreguntasEncuesta = pkidPreguntasEncuesta;
    }

    public PreguntasEncuesta getPreguntasEncuesta() {
        return preguntasEncuesta;
    }

    public void setPreguntasEncuesta(PreguntasEncuesta preguntasEncuesta) {
        this.preguntasEncuesta = preguntasEncuesta;
    }

    public CriterioEncuesta getFkidCriterioEncuesta() {
        return fkidCriterioEncuesta;
    }

    public void setFkidCriterioEncuesta(CriterioEncuesta fkidCriterioEncuesta) {
        this.fkidCriterioEncuesta = fkidCriterioEncuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidPreguntasEncuesta != null ? pkidPreguntasEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PreguntasEncuestahasCriterioEncuesta)) {
            return false;
        }
        PreguntasEncuestahasCriterioEncuesta other = (PreguntasEncuestahasCriterioEncuesta) object;
        if ((this.pkidPreguntasEncuesta == null && other.pkidPreguntasEncuesta != null) || (this.pkidPreguntasEncuesta != null && !this.pkidPreguntasEncuesta.equals(other.pkidPreguntasEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.PreguntasEncuestahasCriterioEncuesta[ pkidPreguntasEncuesta=" + pkidPreguntasEncuesta + " ]";
    }
    
}
