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
@Table(name = "tbl_Seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findByPkidAdolescente", query = "SELECT s FROM Seguimiento s WHERE s.pkidAdolescente = :pkidAdolescente")
    , @NamedQuery(name = "Seguimiento.findByFechaSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.fechaSeguimiento = :fechaSeguimiento")
    , @NamedQuery(name = "Seguimiento.findByConceptoFinal", query = "SELECT s FROM Seguimiento s WHERE s.conceptoFinal = :conceptoFinal")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idAdolescente")
    private Integer pkidAdolescente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSeguimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "conceptoFinal")
    private String conceptoFinal;
    @JoinColumn(name = "pk_idAdolescente", referencedColumnName = "pk_idAdolescente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Adolescente adolescente;
    @JoinColumn(name = "fk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false)
    private Usuario fkidUsuario;

    public Seguimiento() {
    }

    public Seguimiento(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Seguimiento(Integer pkidAdolescente, Date fechaSeguimiento, String conceptoFinal) {
        this.pkidAdolescente = pkidAdolescente;
        this.fechaSeguimiento = fechaSeguimiento;
        this.conceptoFinal = conceptoFinal;
    }

    public Integer getPkidAdolescente() {
        return pkidAdolescente;
    }

    public void setPkidAdolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getConceptoFinal() {
        return conceptoFinal;
    }

    public void setConceptoFinal(String conceptoFinal) {
        this.conceptoFinal = conceptoFinal;
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
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.pkidAdolescente == null && other.pkidAdolescente != null) || (this.pkidAdolescente != null && !this.pkidAdolescente.equals(other.pkidAdolescente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Seguimiento[ pkidAdolescente=" + pkidAdolescente + " ]";
    }
    
}
