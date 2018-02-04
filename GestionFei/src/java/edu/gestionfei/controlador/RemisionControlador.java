/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.controlador;


import edu.gestionfei.entidad.Remision;
import edu.gestionfei.facade.RemisionFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author dfgm
 */
@Named(value = "remisionControlador")
@SessionScoped
public class RemisionControlador implements Serializable {

    @EJB   
   
    private RemisionFacade remisionEjb;
    private Remision remision;
    private List<Remision> remisionList=new ArrayList<Remision>();
    
    @PostConstruct
    public void init(){
        remision=new Remision();
    }

    public Remision getRemision() {
        return remision;
    }
    
    public void setRemision(Remision remision) {
        this.remision = remision;
    }

    

    public List<Remision> getRemisionList() {
        return remisionList;
    }

    public void setRemisionList(List<Remision> remisionList) {
        this.remisionList = remisionList;
    }
    public RemisionControlador() {
        this.remision = new Remision();
    }
    
    public void registrarRemision(){
        
        try {

            remisionEjb.create(remision);
            
            
        } catch (Exception e) {
            System.out.println("Error en el registro de la remision");

        }
    }
}
