/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import inf.unideb.model.Felhasznalo;
import inf.unideb.model.RegisztracioKezeles;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 *
 * @author Birtalan
 */
public class RegisztracioKezelesTest {
    @Test
    public void regisztracioEllenorzes() {
        RegisztracioKezeles kezelo = new RegisztracioKezeles();
        Felhasznalo f = new Felhasznalo("admin", "admin", 10);
        assertFalse("Regisztráció létező felhasználó", kezelo.regisztracioEllenorzes(f));
    }
}
