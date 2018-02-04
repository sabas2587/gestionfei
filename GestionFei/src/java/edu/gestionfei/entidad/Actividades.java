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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_Actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a")
    , @NamedQuery(name = "Actividades.findByPkidActividades", query = "SELECT a FROM Actividades a WHERE a.pkidActividades = :pkidActividades")
    , @NamedQuery(name = "Actividades.findByNombreActividad", query = "SELECT a FROM Actividades a WHERE a.nombreActividad = :nombreActividad")
    , @NamedQuery(name = "Actividades.findByFechaInicial", query = "SELECT a FROM Actividades a WHERE a.fechaInicial = :fechaInicial")
    , @NamedQuery(name = "Actividades.findByDescripcionActividad", query = "SELECT a FROM Actividades a WHERE a.descripcionActividad = :descripcionActividad")
    , @NamedQuery(name = "Actividades.findByFechaFinal", query = "SELECT a FROM Actividades a WHERE a.fechaFinal = :fechaFinal")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idActividades")
    private Integer pkidActividades;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreActividad")
    private String nombreActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaInicial")
    @Temporal(TemporalType.DATE)
    private Date fechaInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "descripcionActividad")
    private String descripcionActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaFinal")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidActividades")
    private List<UsuariohasActividad> usuariohasActividadList;
    @JoinColumn(name = "fk_idLista", referencedColumnName = "pk_idLista")
    @ManyToOne(optional = false)
    private Lista fkidLista;

    public Actividades() {
    }

    public Actividades(Integer pkidActividades) {
        this.pkidActividades = pkidActividades;
    }

    public Actividades(Integer pkidActividades, String nombreActividad, Date fechaInicial, String descripcionActividad, Date fechaFinal) {
        this.pkidActividades = pkidActividades;
        this.nombreActividad = nombreActividad;
        this.fechaInicial = fechaInicial;
        this.descripcionActividad = descripcionActividad;
        this.fechaFinal = fechaFinal;
    }

    public Integer getPkidActividades() {
        return pkidActividades;
    }

    public void setPkidActividades(Integer pkidActividades) {
        this.pkidActividades = pkidActividades;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @XmlTransient
    public List<UsuariohasActividad> getUsuariohasActividadList() {
        return usuariohasActividadList;
    }

    public void setUsuariohasActividadList(List<UsuariohasActividad> usuariohasActividadList) {
        this.usuariohasActividadList = usuariohasActividadList;
    }

    public Lista getFkidLista() {
        return fkidLista;
    }

    public void setFkidLista(Lista fkidLista) {
        this.fkidLista = fkidLista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidActividades != null ? pkidActividades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.pkidActividades == null && other.pkidActividades != null) || (this.pkidActividades != null && !this.pkidActividades.equals(other.pkidActividades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Actividades[ pkidActividades=" + pkidActividades + " ]";
    }
    
}
