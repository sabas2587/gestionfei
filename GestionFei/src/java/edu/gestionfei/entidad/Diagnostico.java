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
@Table(name = "tbl_Diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d")
    , @NamedQuery(name = "Diagnostico.findByPkidAdolescente", query = "SELECT d FROM Diagnostico d WHERE d.pkidAdolescente = :pkidAdolescente")
    , @NamedQuery(name = "Diagnostico.findByFechaDiagnostico", query = "SELECT d FROM Diagnostico d WHERE d.fechaDiagnostico = :fechaDiagnostico")
    , @NamedQuery(name = "Diagnostico.findByObjetivos", query = "SELECT d FROM Diagnostico d WHERE d.objetivos = :objetivos")
    , @NamedQuery(name = "Diagnostico.findByAutonomia", query = "SELECT d FROM Diagnostico d WHERE d.autonomia = :autonomia")
    , @NamedQuery(name = "Diagnostico.findByFortalecimiento", query = "SELECT d FROM Diagnostico d WHERE d.fortalecimiento = :fortalecimiento")
    , @NamedQuery(name = "Diagnostico.findByTrascendencia", query = "SELECT d FROM Diagnostico d WHERE d.trascendencia = :trascendencia")
    , @NamedQuery(name = "Diagnostico.findByCapacidadRestaurativa", query = "SELECT d FROM Diagnostico d WHERE d.capacidadRestaurativa = :capacidadRestaurativa")
    , @NamedQuery(name = "Diagnostico.findByConceptoIntegral", query = "SELECT d FROM Diagnostico d WHERE d.conceptoIntegral = :conceptoIntegral")
    , @NamedQuery(name = "Diagnostico.findByRecomendacion", query = "SELECT d FROM Diagnostico d WHERE d.recomendacion = :recomendacion")})
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idAdolescente")
    private Integer pkidAdolescente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaDiagnostico")
    @Temporal(TemporalType.DATE)
    private Date fechaDiagnostico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "objetivos")
    private String objetivos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "autonomia")
    private String autonomia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fortalecimiento")
    private String fortalecimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "trascendencia")
    private String trascendencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "capacidadRestaurativa")
    private String capacidadRestaurativa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "conceptoIntegral")
    private String conceptoIntegral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "recomendacion")
    private String recomendacion;
    @JoinColumn(name = "pk_idAdolescente", referencedColumnName = "pk_idAdolescente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Adolescente adolescente;
    @JoinColumn(name = "fk_idUsuario", referencedColumnName = "pk_idUsuario")
    @ManyToOne(optional = false)
    private Usuario fkidUsuario;

    public Diagnostico() {
    }

    public Diagnostico(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Diagnostico(Integer pkidAdolescente, Date fechaDiagnostico, String objetivos, String autonomia, String fortalecimiento, String trascendencia, String capacidadRestaurativa, String conceptoIntegral, String recomendacion) {
        this.pkidAdolescente = pkidAdolescente;
        this.fechaDiagnostico = fechaDiagnostico;
        this.objetivos = objetivos;
        this.autonomia = autonomia;
        this.fortalecimiento = fortalecimiento;
        this.trascendencia = trascendencia;
        this.capacidadRestaurativa = capacidadRestaurativa;
        this.conceptoIntegral = conceptoIntegral;
        this.recomendacion = recomendacion;
    }

    public Integer getPkidAdolescente() {
        return pkidAdolescente;
    }

    public void setPkidAdolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(String autonomia) {
        this.autonomia = autonomia;
    }

    public String getFortalecimiento() {
        return fortalecimiento;
    }

    public void setFortalecimiento(String fortalecimiento) {
        this.fortalecimiento = fortalecimiento;
    }

    public String getTrascendencia() {
        return trascendencia;
    }

    public void setTrascendencia(String trascendencia) {
        this.trascendencia = trascendencia;
    }

    public String getCapacidadRestaurativa() {
        return capacidadRestaurativa;
    }

    public void setCapacidadRestaurativa(String capacidadRestaurativa) {
        this.capacidadRestaurativa = capacidadRestaurativa;
    }

    public String getConceptoIntegral() {
        return conceptoIntegral;
    }

    public void setConceptoIntegral(String conceptoIntegral) {
        this.conceptoIntegral = conceptoIntegral;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
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
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.pkidAdolescente == null && other.pkidAdolescente != null) || (this.pkidAdolescente != null && !this.pkidAdolescente.equals(other.pkidAdolescente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Diagnostico[ pkidAdolescente=" + pkidAdolescente + " ]";
    }
    
}
