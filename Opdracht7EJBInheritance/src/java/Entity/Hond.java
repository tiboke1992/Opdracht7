/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 *
 * @author stinson
 */
@Entity
@Inheritance
public class Hond extends Huisdier {
   private int aantalHoofden;

    public int getAantalHoofden() {
        return aantalHoofden;
    }

    public void setAantalHoofden(int aantalHoofden) {
        this.aantalHoofden = aantalHoofden;
    }
   
}
