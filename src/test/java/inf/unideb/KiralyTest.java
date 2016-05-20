/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import inf.unideb.model.Bastya;
import inf.unideb.model.Kiraly;
import inf.unideb.model.Mezo;
import inf.unideb.model.Tabla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Birtalan
 */
public class KiralyTest {
    @Test
    public void KiralyLepesEllenorzes() {
        Tabla t = new Tabla();
        Kiraly kB = new Kiraly("B");
        Bastya bB = new Bastya("B");
        Bastya bW = new Bastya("W");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 4, new Mezo(kB));
        t.setMezo(0, 1, new Mezo(bW));
        t.setMezo(0, 7, new Mezo(bB));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if((i != 0 || j != 4) && i < 2 && j > 2 && j < 6)
                    assertEquals("Helyes sima király lépés" + i + " - " + j, 1, t.getMezo(0, 4).getBabu().lepesEllenorzese(0, 4, i, j));
                else if(i == 0 && j == 6)
                    assertEquals("Helyes rosáló király lépés", 2, t.getMezo(0, 4).getBabu().lepesEllenorzese(0, 4, i, j));
                else
                    assertEquals("Helytelen király lépés", 0, t.getMezo(0, 4).getBabu().lepesEllenorzese(0, 4, i, j));
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void KiralySimaLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Kiraly kB = new Kiraly("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 4, new Mezo(kB));
        t.getMezo(0, 4).getBabu().lepes(0, 4, 1, 5);
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 1 && j == 5)
                    assertTrue("Jó helyre lépett a király",t.getMezo(i, j).getBabu().getTipus().equals("K"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void KiralySpecialisLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Kiraly kB = new Kiraly("B");
        Bastya bB = new Bastya("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        
        t.setMezo(0, 4, new Mezo(kB));
        t.setMezo(0, 0, new Mezo(bB));
        t.getMezo(0, 4).getBabu().lepes(0, 4, 0, 2);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 0 && j == 2)
                    assertTrue("Jó helyre lépett a király", t.getMezo(i, j).getBabu().getTipus().equals("K"));
                else if(i == 0 && j == 3)
                    assertTrue("Jó helyre lépett a bástya", t.getMezo(i, j).getBabu().getTipus().equals("B"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
}
