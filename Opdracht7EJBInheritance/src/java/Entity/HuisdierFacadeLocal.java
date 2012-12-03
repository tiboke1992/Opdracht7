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
public interface HuisdierFacadeLocal {

    Object create(Huisdier huisdier);

    Object edit(Huisdier huisdier);

    void remove(Huisdier huisdier);

    Huisdier find(Object id);

    List<Huisdier> findAll();

    List<Huisdier> findRange(int[] range);

    int count();
    
}
