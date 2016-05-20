/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Birtalan
 */
public class BejelentkezesKezeles {
    
    private List<Felhasznalo> felhasznalok = new ArrayList<>();
    private static int jatekos=0;
    private static int pontszam=0;
    
    
    public int getPontszam() {
        return BejelentkezesKezeles.pontszam;
    }
    
    
    /**
     *
     * @param felhasznalo
     * @param jelszo
     * @return
     */
    public boolean felhasznaloEgyezes(String felhasznalo, String jelszo) {
       
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        felhasznalok = feldolgozo.getFelhasznalok();
        for(int i=0;i<felhasznalok.size();i++) {
            String f = felhasznalok.get(i).getFelhasznalonev();
            String j = felhasznalok.get(i).getJelszo();
            if(f.equals(felhasznalo) && j.equals(jelszo)) {
                //BejelentkezesKezeles.jatekos++;
                BejelentkezesKezeles.pontszam = felhasznalok.get(i).getPont();
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param mezo
     * @return
     */
    public boolean uresMezo(String mezo) {
        return !mezo.equals("");
    }
    
    /**
     *
     * @return
     */
    public int belepettJatekosok() {
        return BejelentkezesKezeles.jatekos;
    }
    
    public void belepettJatekosokNovelese() {
        BejelentkezesKezeles.jatekos++;
    }
}
