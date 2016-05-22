/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import org.junit.Test;
import inf.unideb.model.BejelentkezesKezeles;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.xml.sax.SAXException;

/**
 *
 * @author Birtalan
 */
public class BejelentkezesKezelesTest {
    
    @Test
    public void felhasznaloEgyezesEllenorzes() throws ParserConfigurationException, SAXException, IOException {
        BejelentkezesKezeles kezelo = new BejelentkezesKezeles();
        assertTrue("Felhasználóegyezés", kezelo.felhasznaloEgyezes("admin", "admin"));
    }
    
    @Test
    public void uresMezoEllenorzes() {
        BejelentkezesKezeles kezelo = new BejelentkezesKezeles();
        assertFalse("Üres sztring", kezelo.uresMezo(""));
    }
}
