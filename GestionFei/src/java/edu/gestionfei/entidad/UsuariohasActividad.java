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
@Table(name = "tbl_Usuario_has_Actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuariohasActividad.findAll", query = "SELECT u FROM UsuariohasActividad u")
    , @NamedQuery(name = "UsuariohasActividad.findByPkidUsuario", query = "SELECT u FROM UsuariohasActividad u WHERE u.pkidUsuario = :pkidUsuario")})
public class UsuariohasActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idUsuario")
    private Integer pkidUsuario;
    @JoinColumn(name = "pk_idUsuario", referencedColumnName = "pk_idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "fk_idActividades", referencedColumnName = "pk_idActividades")
    @ManyToOne(optional = false)
    private Actividades fkidActividades;

    public UsuariohasActividad() {
    }

    public UsuariohasActividad(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public Integer getPkidUsuario() {
        return pkidUsuario;
    }

    public void setPkidUsuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Actividades getFkidActividades() {
        return fkidActividades;
    }

    public void setFkidActividades(Actividades fkidActividades) {
        this.fkidActividades = fkidActividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkidUsuario != null ? pkidUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariohasActividad)) {
            return false;
        }
        UsuariohasActividad other = (UsuariohasActividad) object;
        if ((this.pkidUsuario == null && other.pkidUsuario != null) || (this.pkidUsuario != null && !this.pkidUsuario.equals(other.pkidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.UsuariohasActividad[ pkidUsuario=" + pkidUsuario + " ]";
    }
    
}
