/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht7inheritance;

import Entity.Hond;
import Entity.HondFacade;
import Entity.HondFacadeLocal;
import Entity.HuisdierFacade;
import Entity.HuisdierFacadeLocal;
import Entity.Kat;
import Entity.KatFacade;
import Entity.KatFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author stinson
 */
public class Opdracht7Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Context c = new InitialContext();
            HuisdierFacadeLocal huisdierdb = (HuisdierFacadeLocal)c.lookup("java:global/Opdracht7EJBInheritance/HuisdierFacade");
            KatFacadeLocal katDB = (KatFacadeLocal)c.lookup("java:global/Opdracht7EJBInheritance/KatFacade!Entity.KatFacadeLocal");
            HondFacadeLocal hondDB = (HondFacadeLocal)c.lookup("java:global/Opdracht7EJBInheritance/HondFacade");
            Hond h = new Hond();
            h.setNaam("ivanka");
            h.setLeeftijd("10");
            h.setGewicht(60);
            h.setAantalHoofden(1);
            h = (Hond)hondDB.create(h);
            Kat k = new Kat();
            k.setNaam("PJ");
            k.setGewicht(10);
            k.setLeeftijd("5");
            k.setAantalMuizenGevangen(20);
            k = (Kat)katDB.create(k);
        } catch (NamingException ex) {
            Logger.getLogger(Opdracht7Inheritance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
