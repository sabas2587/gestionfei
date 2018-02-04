/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.facade;

import edu.gestionfei.entidad.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "GestionFeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    public Usuario iniciarSesion(Usuario objUsuario){
        
        Usuario usuario=null;
        Query consulta=em.createQuery("select u from Usuario u where u.username=:username and u.contraseña=:clave");
        consulta.setParameter("username", objUsuario.getUsername());
        consulta.setParameter("clave", objUsuario.getContraseña());
        
        List<Usuario> listaUsuario=consulta.getResultList();
        if(!listaUsuario.isEmpty()){
           usuario=listaUsuario.get(0);
        }
        return usuario;
        
    }
}
