/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gestionfei.facade;

import edu.gestionfei.entidad.Escala;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class EscalaFacade extends AbstractFacade<Escala> {

    @PersistenceContext(unitName = "GestionFeiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EscalaFacade() {
        super(Escala.class);
    }
    
}
