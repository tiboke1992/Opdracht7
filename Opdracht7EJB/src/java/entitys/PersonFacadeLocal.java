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
public interface PersonFacadeLocal {

    Object create(Person person);

    Object  edit(Person person);

    void remove(Person person);

    Person find(Object id);

    List<Person> findAll();

    List<Person> findRange(int[] range);

    int count();
    
    String getNaamPersoonMetBestellingDieHetDuursteProductBevat();
    String getLijstPersonenDieEenItemHebbenDuurderDan(int getal);
    String getLijstPersonenDieEenItemHebbenDuurderDanEnOuderZijnDan(int getal, int leeftijd);
    
}
