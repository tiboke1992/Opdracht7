/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author stinson
 */
@Stateless
public class PlacedOrderFacade extends AbstractFacade<PlacedOrder> implements PlacedOrderFacadeLocal {
    @PersistenceContext(unitName = "Opdracht7EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlacedOrderFacade() {
        super(PlacedOrder.class);
    }
    
}
