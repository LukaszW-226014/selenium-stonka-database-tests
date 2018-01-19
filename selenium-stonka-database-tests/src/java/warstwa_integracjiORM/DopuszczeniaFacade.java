/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_integracjiORM;

import entities.Dopuszczenia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luke
 */
@Stateless
public class DopuszczeniaFacade extends AbstractFacade<Dopuszczenia> {

    @PersistenceContext(unitName = "selenium-stonka-database-testsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DopuszczeniaFacade() {
        super(Dopuszczenia.class);
    }
    
}
