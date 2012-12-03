/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author stinson
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Kat extends Huisdier {
    private int aantalMuizenGevangen;

    public int getAantalMuizenGevangen() {
        return aantalMuizenGevangen;
    }

    public void setAantalMuizenGevangen(int aantalMuizenGevangen) {
        this.aantalMuizenGevangen = aantalMuizenGevangen;
    }
    
    
}
