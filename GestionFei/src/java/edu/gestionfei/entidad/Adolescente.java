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
import javax.persistence.OneToOne;
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
@Table(name = "tbl_Adolescente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adolescente.findAll", query = "SELECT a FROM Adolescente a")
    , @NamedQuery(name = "Adolescente.findByPkidAdolescente", query = "SELECT a FROM Adolescente a WHERE a.pkidAdolescente = :pkidAdolescente")
    , @NamedQuery(name = "Adolescente.findByTipoDocumento", query = "SELECT a FROM Adolescente a WHERE a.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Adolescente.findByNumeroDocumento", query = "SELECT a FROM Adolescente a WHERE a.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Adolescente.findByNombre", query = "SELECT a FROM Adolescente a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Adolescente.findByApellidos", query = "SELECT a FROM Adolescente a WHERE a.apellidos = :apellidos")
    , @NamedQuery(name = "Adolescente.findByFechaNacimiento", query = "SELECT a FROM Adolescente a WHERE a.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Adolescente.findByLugarNacimiento", query = "SELECT a FROM Adolescente a WHERE a.lugarNacimiento = :lugarNacimiento")
    , @NamedQuery(name = "Adolescente.findByEdad", query = "SELECT a FROM Adolescente a WHERE a.edad = :edad")
    , @NamedQuery(name = "Adolescente.findByAcudiente", query = "SELECT a FROM Adolescente a WHERE a.acudiente = :acudiente")
    , @NamedQuery(name = "Adolescente.findByEscolaridad", query = "SELECT a FROM Adolescente a WHERE a.escolaridad = :escolaridad")})
public class Adolescente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_idAdolescente")
    private Integer pkidAdolescente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
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
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 100)
    @Column(name = "lugarNacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "acudiente")
    private String acudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "escolaridad")
    private String escolaridad;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adolescente")
    private InformeExtraordinario informeExtraordinario;
    @JoinColumn(name = "fk_idSedes", referencedColumnName = "pk_idSedes")
    @ManyToOne(optional = false)
    private Sede fkidSedes;
    @JoinColumn(name = "fk_ordenRemision", referencedColumnName = "pk_ordenRemision")
    @ManyToOne(optional = false)
    private Remision fkordenRemision;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adolescente")
    private Diagnostico diagnostico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkidAdolescente")
    private List<Valoracion> valoracionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adolescente")
    private Seguimiento seguimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adolescente")
    private Intervencion intervencion;

    public Adolescente() {
    }

    public Adolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public Adolescente(Integer pkidAdolescente, String tipoDocumento, long numeroDocumento, String nombre, String apellidos, Date fechaNacimiento, int edad, String acudiente, String escolaridad) {
        this.pkidAdolescente = pkidAdolescente;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.acudiente = acudiente;
        this.escolaridad = escolaridad;
    }

    public Integer getPkidAdolescente() {
        return pkidAdolescente;
    }

    public void setPkidAdolescente(Integer pkidAdolescente) {
        this.pkidAdolescente = pkidAdolescente;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public InformeExtraordinario getInformeExtraordinario() {
        return informeExtraordinario;
    }

    public void setInformeExtraordinario(InformeExtraordinario informeExtraordinario) {
        this.informeExtraordinario = informeExtraordinario;
    }

    public Sede getFkidSedes() {
        return fkidSedes;
    }

    public void setFkidSedes(Sede fkidSedes) {
        this.fkidSedes = fkidSedes;
    }

    public Remision getFkordenRemision() {
        return fkordenRemision;
    }

    public void setFkordenRemision(Remision fkordenRemision) {
        this.fkordenRemision = fkordenRemision;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    @XmlTransient
    public List<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setValoracionList(List<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public Intervencion getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(Intervencion intervencion) {
        this.intervencion = intervencion;
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
        if (!(object instanceof Adolescente)) {
            return false;
        }
        Adolescente other = (Adolescente) object;
        if ((this.pkidAdolescente == null && other.pkidAdolescente != null) || (this.pkidAdolescente != null && !this.pkidAdolescente.equals(other.pkidAdolescente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.gestionfei.entidad.Adolescente[ pkidAdolescente=" + pkidAdolescente + " ]";
    }
    
}
