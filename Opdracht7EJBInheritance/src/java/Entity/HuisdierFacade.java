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
public class HuisdierFacade extends AbstractFacade<Huisdier> implements HuisdierFacadeLocal {
    @PersistenceContext(unitName = "Opdracht7EJBInheritancePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HuisdierFacade() {
        super(Huisdier.class);
    }
    
}
