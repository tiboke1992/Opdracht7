/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stinson
 */
@Remote
public interface PlacedOrderFacadeLocal {

     Object  create(PlacedOrder placedOrder);

     Object  edit(PlacedOrder placedOrder);

    void remove(PlacedOrder placedOrder);

    PlacedOrder find(Object id);

    List<PlacedOrder> findAll();

    List<PlacedOrder> findRange(int[] range);

    int count();
    
}
