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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbl_Sedes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s")
    , @NamedQuery(name = "Sede.findByPkidSedes", query = "SELECT s FROM Sede s WHERE s.pkidSedes = :pkidSedes")
    , @NamedQuery(name = "Sede.findByCiudad", query = "SELECT s FROM Sede s WHERE s.ciudad = :ciudad")
    , @NamedQuery(name = "Sede.findByMunicipio", query = "SELECT s FROM Sede s WHERE s.municipio = :municipio")
    , @NamedQuery(name = "Sede.findByRegional", query = "SELECT s FROM Sede s WHERE s.regional = :regional")
    , @NamedQuery(name = "Sede.findByInstitucion", query = "SELECT s FROM Sede s WHERE s.institucion = :institucion")})
public class Sede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idSedes")
    private Integer pkidSedes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "regional")
    private String regional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "institucion")
    private String institucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidSedes")
    private List<Adolescente> adolescenteList;

    public Sede() {
    }

    public Sede(Integer pkidSedes) {
        this.pkidSedes = pkidSedes;
    }

    public Sede(Integer pkidSedes, String ciudad, String municipio, String regional, String institucion) {
        this.pkidSedes = pkidSedes;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.regional = regional;
        this.institucion = institucion;
    }

    public Integer getPkidSedes() {
        return pkidSedes;
    }

    public void setPkidSedes(Integer pkidSedes) {
        this.pkidSedes = pkidSedes;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    @XmlTransient
    public List<Adolescente> getAdolescenteList() {
        return adolescenteList;
    }

    public void setAdolescenteList(List<Adolescente> adolescenteList) {
        this.adolescenteList = adolescenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidSedes != null ? pkidSedes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.pkidSedes == null && other.pkidSedes != null) || (this.pkidSedes != null && !this.pkidSedes.equals(other.pkidSedes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Sede[ pkidSedes=" + pkidSedes + " ]";
    }
    
}
