/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import org.junit.Test;
import inf.unideb.model.BejelentkezesKezeles;
import inf.unideb.model.Tabla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Birtalan
 */
public class BejelentkezesKezelesTest {
    
    @Test
    public void felhasznaloEgyezesEllenorzes() {
        BejelentkezesKezeles kezelo = new BejelentkezesKezeles();
        assertTrue("Felhasználóegyezés", kezelo.felhasznaloEgyezes("admin", "admin"));
    }
    
    @Test
    public void uresMezoEllenorzes() {
        BejelentkezesKezeles kezelo = new BejelentkezesKezeles();
        assertFalse("Üres sztring", kezelo.uresMezo(""));
    }
}
