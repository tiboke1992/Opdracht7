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
public interface KatFacadeLocal {

    Object create(Kat kat);

    Object edit(Kat kat);

    void remove(Kat kat);

    Kat find(Object id);

    List<Kat> findAll();

    List<Kat> findRange(int[] range);

    int count();
    
}
