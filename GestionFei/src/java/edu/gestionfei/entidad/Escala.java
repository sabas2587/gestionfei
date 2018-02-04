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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_Escala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escala.findAll", query = "SELECT e FROM Escala e")
    , @NamedQuery(name = "Escala.findByPkidEscala", query = "SELECT e FROM Escala e WHERE e.pkidEscala = :pkidEscala")
    , @NamedQuery(name = "Escala.findByNombreEscala", query = "SELECT e FROM Escala e WHERE e.nombreEscala = :nombreEscala")})
public class Escala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idEscala")
    private Integer pkidEscala;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreEscala")
    private String nombreEscala;
    @JoinColumn(name = "fk_idCriterioEncuesta", referencedColumnName = "pk_idCriterioEncuesta")
    @ManyToOne(optional = false)
    private CriterioEncuesta fkidCriterioEncuesta;

    public Escala() {
    }

    public Escala(Integer pkidEscala) {
        this.pkidEscala = pkidEscala;
    }

    public Escala(Integer pkidEscala, String nombreEscala) {
        this.pkidEscala = pkidEscala;
        this.nombreEscala = nombreEscala;
    }

    public Integer getPkidEscala() {
        return pkidEscala;
    }

    public void setPkidEscala(Integer pkidEscala) {
        this.pkidEscala = pkidEscala;
    }

    public String getNombreEscala() {
        return nombreEscala;
    }

    public void setNombreEscala(String nombreEscala) {
        this.nombreEscala = nombreEscala;
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
        hash += (pkidEscala != null ? pkidEscala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escala)) {
            return false;
        }
        Escala other = (Escala) object;
        if ((this.pkidEscala == null && other.pkidEscala != null) || (this.pkidEscala != null && !this.pkidEscala.equals(other.pkidEscala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Escala[ pkidEscala=" + pkidEscala + " ]";
    }
    
}
