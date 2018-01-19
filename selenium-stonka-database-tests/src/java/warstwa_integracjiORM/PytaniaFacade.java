/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_integracjiORM;

import entities.Pytania;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luke
 */
@Stateless
public class PytaniaFacade extends AbstractFacade<Pytania> {

    @PersistenceContext(unitName = "selenium-stonka-database-testsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PytaniaFacade() {
        super(Pytania.class);
    }
    
}
