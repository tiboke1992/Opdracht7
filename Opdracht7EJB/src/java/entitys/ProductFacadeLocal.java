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
public interface ProductFacadeLocal {

     Object  create(Product product);

     Object  edit(Product product);

    void remove(Product product);

    Product find(Object id);

    List<Product> findAll();

    List<Product> findRange(int[] range);

    int count();
    
}
