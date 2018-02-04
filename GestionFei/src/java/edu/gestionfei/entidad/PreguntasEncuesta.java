/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.entidad;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_PreguntasEncuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PreguntasEncuesta.findAll", query = "SELECT p FROM PreguntasEncuesta p")
    , @NamedQuery(name = "PreguntasEncuesta.findByPkidPreguntasEncuesta", query = "SELECT p FROM PreguntasEncuesta p WHERE p.pkidPreguntasEncuesta = :pkidPreguntasEncuesta")
    , @NamedQuery(name = "PreguntasEncuesta.findByNombresPreguntas", query = "SELECT p FROM PreguntasEncuesta p WHERE p.nombresPreguntas = :nombresPreguntas")})
public class PreguntasEncuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idPreguntasEncuesta")
    private Integer pkidPreguntasEncuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombresPreguntas")
    private String nombresPreguntas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "preguntasEncuesta")
    private PreguntasEncuestahasCriterioEncuesta preguntasEncuestahasCriterioEncuesta;
    @JoinColumn(name = "fk_idValoracion", referencedColumnName = "pk_idValoracion")
    @ManyToOne(optional = false)
    private Valoracion fkidValoracion;

    public PreguntasEncuesta() {
    }

    public PreguntasEncuesta(Integer pkidPreguntasEncuesta) {
        this.pkidPreguntasEncuesta = pkidPreguntasEncuesta;
    }

    public PreguntasEncuesta(Integer pkidPreguntasEncuesta, String nombresPreguntas) {
        this.pkidPreguntasEncuesta = pkidPreguntasEncuesta;
        this.nombresPreguntas = nombresPreguntas;
    }

    public Integer getPkidPreguntasEncuesta() {
        return pkidPreguntasEncuesta;
    }

    public void setPkidPreguntasEncuesta(Integer pkidPreguntasEncuesta) {
        this.pkidPreguntasEncuesta = pkidPreguntasEncuesta;
    }

    public String getNombresPreguntas() {
        return nombresPreguntas;
    }

    public void setNombresPreguntas(String nombresPreguntas) {
        this.nombresPreguntas = nombresPreguntas;
    }

    public PreguntasEncuestahasCriterioEncuesta getPreguntasEncuestahasCriterioEncuesta() {
        return preguntasEncuestahasCriterioEncuesta;
    }

    public void setPreguntasEncuestahasCriterioEncuesta(PreguntasEncuestahasCriterioEncuesta preguntasEncuestahasCriterioEncuesta) {
        this.preguntasEncuestahasCriterioEncuesta = preguntasEncuestahasCriterioEncuesta;
    }

    public Valoracion getFkidValoracion() {
        return fkidValoracion;
    }

    public void setFkidValoracion(Valoracion fkidValoracion) {
        this.fkidValoracion = fkidValoracion;
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
        if (!(object instanceof PreguntasEncuesta)) {
            return false;
        }
        PreguntasEncuesta other = (PreguntasEncuesta) object;
        if ((this.pkidPreguntasEncuesta == null && other.pkidPreguntasEncuesta != null) || (this.pkidPreguntasEncuesta != null && !this.pkidPreguntasEncuesta.equals(other.pkidPreguntasEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.PreguntasEncuesta[ pkidPreguntasEncuesta=" + pkidPreguntasEncuesta + " ]";
    }
    
}
