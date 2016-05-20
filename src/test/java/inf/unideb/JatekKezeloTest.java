/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import inf.unideb.model.Bastya;
import inf.unideb.model.Felhasznalo;
import inf.unideb.model.JatekKezelo;
import inf.unideb.model.Jatekos;
import inf.unideb.model.Kiraly;
import inf.unideb.model.Mezo;
import inf.unideb.model.RegisztracioKezeles;
import inf.unideb.model.Tabla;
import inf.unideb.model.XMLFeldolgozoFelhaszanlo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 *
 * @author Birtalan
 */
public class JatekKezeloTest {
    @Test
    public void tablaInicializalasEllenorzes() {
        JatekKezelo kezelo = new JatekKezelo();
        Tabla t = new Tabla();
        Jatekos j1 = new Jatekos("admin", 0, "B", false);
        Jatekos j2 = new Jatekos("u", 0, "W", false);
        kezelo.setJatekos1(j1);
        kezelo.setJatekos2(j2);
        kezelo.tablaInicializalas();
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 1 || i == 6)
                    assertTrue("Paraszt létrehozva", t.getMezo(i, j).getBabu().getTipus().equals("P"));
                else if(i == 0 || i == 7) {
                    if(j == 0 || j== 7)
                        assertTrue("Bástya létrehozva", t.getMezo(i, j).getBabu().getTipus().equals("B"));
                    if(j == 1 || j == 6)
                        assertTrue("Ló létrehozva", t.getMezo(i, j).getBabu().getTipus().equals("L"));
                    if(j == 2 || j == 5)
                        assertTrue("Futó létrehozva", t.getMezo(i, j).getBabu().getTipus().equals("F"));
                    if(j == 3)
                        assertTrue("Királynő létrehozva", t.getMezo(i, j).getBabu().getTipus().equals("Q"));
                    if(j == 4)
                        assertTrue("Király létrehozva", t.getMezo(i, j).getBabu().getTipus().equals("K"));
                }
                else
                    assertTrue("Üres mező" + i + " " + j, t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
                
        
    }
    
    @Test
    public void joBabuVoltValasztvaEllenorzes() {
        JatekKezelo kezelo = new JatekKezelo();
        Tabla t = new Tabla();
        Bastya bW = new Bastya("W");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 0, new Mezo(bW));
        assertTrue("Jó bábú volt választva", kezelo.joBabuVoltValasztva(0, 0));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void vegeVanEllenorzes() {
        JatekKezelo kezelo = new JatekKezelo();
        Tabla t = new Tabla();
        Kiraly k = new Kiraly("B");
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 4, new Mezo(k));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 0 && j == 4)
                    assertTrue("Kiály van ahova lépünk", kezelo.vegeVan(0, 4));
                else
                    assertFalse("Üres vagy más bábú", kezelo.vegeVan(i, j));
            }
    }
    
    @Test
    public void kiNyertEllenorzes() {
        JatekKezelo kezelo = new JatekKezelo();
        Jatekos j1 = new Jatekos("admin", 0, "W", false);
        Jatekos j2 = new Jatekos("u", 0, "B", false);
        
        Tabla t = new Tabla();
        Kiraly kB = new Kiraly("B");
        
        kezelo.setJatekos1(j1);
        kezelo.setJatekos2(j2);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 4, new Mezo(kB));
        
        kezelo.kiNyert(0, 4);
        
        assertTrue("Fehér játékos nyert", kezelo.getJatekos1().getNyert());
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void felhasznaloFrissitesEllenorzes() throws TransformerException {
        JatekKezelo jKezelo = new JatekKezelo();
        RegisztracioKezeles rkezelo = new RegisztracioKezeles();
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        Felhasznalo felhasznalo = new Felhasznalo("test", "test", 0);
        
        assertTrue("Felhasználó nem szerepel",rkezelo.regisztracioEllenorzes(felhasznalo));
        feldolgozo.addFelhasznalo(felhasznalo);
        
        List<Felhasznalo> felhasznalokListaja = new ArrayList<>();
        felhasznalokListaja = feldolgozo.getFelhasznalok();
        
        boolean szerepel = false;
        for(Felhasznalo f : felhasznalokListaja)
            if(f.getFelhasznalonev().equals(felhasznalo.getFelhasznalonev()))
                szerepel = true;
        assertTrue("Szerepel a test felhasználónév a létező felhasynálónevek között", szerepel);
        
        Jatekos j1 = new Jatekos("admin", 12, "W", false);
        Jatekos j2 = new Jatekos(felhasznalo.getFelhasznalonev(), 0, "B", true);
        jKezelo.setJatekos1(j1);
        jKezelo.setJatekos2(j2);
        
        jKezelo.pontokFrissitese();
        assertEquals("Test felhasznalo pontszama 5", 5, jKezelo.getJatekos2().getPont());
        
        try {
            feldolgozo.felhasznaloTorles(j2);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerConfigurationException ex) {
            Logger.getLogger(JatekKezeloTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        felhasznalokListaja = feldolgozo.getFelhasznalok();
        szerepel = false;
        for(Felhasznalo f : felhasznalokListaja)
            if(f.getFelhasznalonev().equals(felhasznalo.getFelhasznalonev()))
                szerepel = true;
        assertFalse("Nem szerepel a test felhasználónév a létező felhasználónevek között", szerepel);
        
        
    }
}
