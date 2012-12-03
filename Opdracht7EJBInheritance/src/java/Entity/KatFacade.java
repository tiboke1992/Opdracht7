/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stinson
 */
@Stateless
public class KatFacade extends AbstractFacade<Kat> implements KatFacadeLocal {
    @PersistenceContext(unitName = "Opdracht7EJBInheritancePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KatFacade() {
        super(Kat.class);
    }
    
}
