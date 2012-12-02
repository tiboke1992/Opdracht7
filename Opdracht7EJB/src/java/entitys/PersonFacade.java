/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import com.sun.org.apache.bcel.internal.generic.Select;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author stinson
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> implements PersonFacadeLocal {
    @PersistenceContext(unitName = "Opdracht7EJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    @Override
    public String getNaamPersoonMetBestellingDieHetDuursteProductBevat() {
       String str = "";
       //Query q = em.createQuery("SELECT p FROM Person p, PlacedOrder e WHERE p = e.owner");
       Query q = em.createQuery("SELECT DISTINCT o.owner FROM PlacedOrder o JOIN o.producten e WHERE e.id = (SELECT s.id From Product s where s.prijs = (SELECT MAX(p.prijs) FROM Product p))");
       Person o = (Person) q.getSingleResult();
       if(o == null){
           str = "Niemand heeft het duurste";
                   return str;
       }
       return "" + o.getName();
    }

    @Override
    public String getLijstPersonenDieEenItemHebbenDuurderDan(int getal) {
        String str = "";
        Query q = em.createQuery("SELECT DISTINCT o.owner FROM PlacedOrder o Join o.producten e WHERE e.id IN(SELECT p.id FROM Product as p WHERE p.prijs > :getal)");
        q.setParameter("getal", getal);
        List<Person> result = q.getResultList();
        if(result == null || result.isEmpty()){
            return "Er is niemand die een item heeft gekocht dat zo duur is!";
        }
        for(Person pp : result){
            str += pp.getName() + " \n";
        }
        return str;
    }

    @Override
    public String getLijstPersonenDieEenItemHebbenDuurderDanEnOuderZijnDan(int getal, int leeftijd) {
         String str = "";
        Query q = em.createQuery("SELECT DISTINCT o.owner FROM PlacedOrder o Join o.producten e WHERE e.id IN(SELECT p.id FROM Product as p WHERE p.prijs > :getal) AND o.owner.leeftijd > :age");
        q.setParameter("getal", getal);
        q.setParameter("age", leeftijd);
        List<Person> result = q.getResultList();
        if(result == null || result.isEmpty()){
            return "Er is niemand die een item heeft gekocht dat zo duur is!";
        }
        for(Person pp : result){
            str += pp.getName() + " " + pp.getLeeftijd() +"\n";
        }
        return str;
    }
    
}
