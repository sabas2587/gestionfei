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
@Table(name = "tbl_Lista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lista.findAll", query = "SELECT l FROM Lista l")
    , @NamedQuery(name = "Lista.findByPkidLista", query = "SELECT l FROM Lista l WHERE l.pkidLista = :pkidLista")
    , @NamedQuery(name = "Lista.findByTipoLista", query = "SELECT l FROM Lista l WHERE l.tipoLista = :tipoLista")})
public class Lista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idLista")
    private Integer pkidLista;
    @Size(max = 100)
    @Column(name = "tipoLista")
    private String tipoLista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidLista")
    private List<Actividades> actividadesList;

    public Lista() {
    }

    public Lista(Integer pkidLista) {
        this.pkidLista = pkidLista;
    }

    public Integer getPkidLista() {
        return pkidLista;
    }

    public void setPkidLista(Integer pkidLista) {
        this.pkidLista = pkidLista;
    }

    public String getTipoLista() {
        return tipoLista;
    }

    public void setTipoLista(String tipoLista) {
        this.tipoLista = tipoLista;
    }

    @XmlTransient
    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidLista != null ? pkidLista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lista)) {
            return false;
        }
        Lista other = (Lista) object;
        if ((this.pkidLista == null && other.pkidLista != null) || (this.pkidLista != null && !this.pkidLista.equals(other.pkidLista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Lista[ pkidLista=" + pkidLista + " ]";
    }
    
}
