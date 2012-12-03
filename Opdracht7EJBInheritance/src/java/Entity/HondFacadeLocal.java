/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author stinson
 */
@Remote
public interface HondFacadeLocal {

    Object create(Hond hond);

    Object edit(Hond hond);

    void remove(Hond hond);

    Hond find(Object id);

    List<Hond> findAll();

    List<Hond> findRange(int[] range);

    int count();
    
}
