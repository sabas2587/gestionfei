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
@Table(name = "tbl_Rol_has_Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolhasUsuario.findAll", query = "SELECT r FROM RolhasUsuario r")
    , @NamedQuery(name = "RolhasUsuario.findByPkidUsuario", query = "SELECT r FROM RolhasUsuario r WHERE r.pkidUsuario = :pkidUsuario")})
public class RolhasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "pk_idUsuario")
    private Integer pkidUsuario;
    @JoinColumn(name = "pk_idUsuario", referencedColumnName = "pk_idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "fk_idRol", referencedColumnName = "pk_idRol")
    @ManyToOne(optional = false)
    private Rol fkidRol;

    public RolhasUsuario() {
    }

    public RolhasUsuario(Integer pkidUsuario) {
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

    public Rol getFkidRol() {
        return fkidRol;
    }

    public void setFkidRol(Rol fkidRol) {
        this.fkidRol = fkidRol;
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
        if (!(object instanceof RolhasUsuario)) {
            return false;
        }
        RolhasUsuario other = (RolhasUsuario) object;
        if ((this.pkidUsuario == null && other.pkidUsuario != null) || (this.pkidUsuario != null && !this.pkidUsuario.equals(other.pkidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.RolhasUsuario[ pkidUsuario=" + pkidUsuario + " ]";
    }
    
}
