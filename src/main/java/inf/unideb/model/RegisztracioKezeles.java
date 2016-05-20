/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

/**
 *
 * @author Birtalan
 */
public class RegisztracioKezeles {
    
    public boolean regisztracioEllenorzes(Felhasznalo f) {
        BejelentkezesKezeles bejelentkezes = new BejelentkezesKezeles();
        return !bejelentkezes.felhasznaloEgyezes(f.getFelhasznalonev(), f.getJelszo());
    }
    
     public boolean uresMezo(String mezo) {
        return !mezo.equals("");
    }
}
