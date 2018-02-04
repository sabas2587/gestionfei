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
import javax.persistence.OneToOne;
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
@Table(name = "tbl_Usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByPkidUsuario", query = "SELECT u FROM Usuario u WHERE u.pkidUsuario = :pkidUsuario")
    , @NamedQuery(name = "Usuario.findByNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos")
    , @NamedQuery(name = "Usuario.findByCargo", query = "SELECT u FROM Usuario u WHERE u.cargo = :cargo")
    , @NamedQuery(name = "Usuario.findByMail", query = "SELECT u FROM Usuario u WHERE u.mail = :mail")
    , @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idUsuario")
    private Integer pkidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroDocumento")
    private long numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidUsuario")
    private List<InformeExtraordinario> informeExtraordinarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private UsuariohasActividad usuariohasActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidUsuario")
    private List<Diagnostico> diagnosticoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private RolhasUsuario rolhasUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidUsuario")
    private List<Valoracion> valoracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidUsuario")
    private List<Seguimiento> seguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidUsuario")
    private List<Intervencion> intervencionList;

    public Usuario() {
    }

    public Usuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public Usuario(Integer pkidUsuario, long numeroDocumento, String nombre, String apellidos, String cargo, String mail, String estado, String username, String contraseña) {
        this.pkidUsuario = pkidUsuario;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.mail = mail;
        this.estado = estado;
        this.username = username;
        this.contraseña = contraseña;
    }

    public Integer getPkidUsuario() {
        return pkidUsuario;
    }

    public void setPkidUsuario(Integer pkidUsuario) {
        this.pkidUsuario = pkidUsuario;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @XmlTransient
    public List<InformeExtraordinario> getInformeExtraordinarioList() {
        return informeExtraordinarioList;
    }

    public void setInformeExtraordinarioList(List<InformeExtraordinario> informeExtraordinarioList) {
        this.informeExtraordinarioList = informeExtraordinarioList;
    }

    public UsuariohasActividad getUsuariohasActividad() {
        return usuariohasActividad;
    }

    public void setUsuariohasActividad(UsuariohasActividad usuariohasActividad) {
        this.usuariohasActividad = usuariohasActividad;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    public RolhasUsuario getRolhasUsuario() {
        return rolhasUsuario;
    }

    public void setRolhasUsuario(RolhasUsuario rolhasUsuario) {
        this.rolhasUsuario = rolhasUsuario;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<Intervencion> getIntervencionList() {
        return intervencionList;
    }

    public void setIntervencionList(List<Intervencion> intervencionList) {
        this.intervencionList = intervencionList;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.pkidUsuario == null && other.pkidUsuario != null) || (this.pkidUsuario != null && !this.pkidUsuario.equals(other.pkidUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Usuario[ pkidUsuario=" + pkidUsuario + " ]";
    }
    
}
