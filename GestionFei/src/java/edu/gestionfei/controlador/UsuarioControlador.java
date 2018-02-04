/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.controlador;


import edu.gestionfei.entidad.Usuario;
import edu.gestionfei.facade.UsuarioFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author dfgm
 */
@Named(value = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable {

    /**
     * Creates a new instance of UsuarioControlador
     */
    public UsuarioControlador() {
    }
    @EJB 
    UsuarioFacade usuariosFacade;
    
    Usuario usuario;

    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    Usuario usuarioSesion;
    List<Usuario> listaUsuario;

    public UsuarioFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuarioFacade usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        usuario=new Usuario();
        listaUsuario = usuariosFacade.findAll();
    }
    
    public String iniciarSesion(){
        usuarioSesion=new Usuario();
        String redireccion="";
        
        try{
            usuarioSesion=usuariosFacade.iniciarSesion(usuario);
            usuario=new Usuario();
            if(usuarioSesion!=null){
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLog", usuarioSesion);
                redireccion="/Views/PaginaInicioUsuario?faces-redirect=true";
                
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Usuario y/o clave incorrectas"));
                
            }
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",e.getMessage()));

        }
        return redireccion;        
    }
    
    public void mostrarSession(){
        
        Usuario usuarioSesionActiva=(Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLog");
    }
    
    public String cerrarSesion(){
        String redireccion="";
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return redireccion="../index.xhtml";
        
    }
}
