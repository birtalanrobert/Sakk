/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;


import inf.unideb.model.Lo;
import inf.unideb.model.Mezo;
import inf.unideb.model.Tabla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Birtalan
 */
public class LoTest {
    @Test
    public void LoLepesEllenorzes() {
        Tabla t = new Tabla();
        Lo l = new Lo("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(3, 3, new Mezo(l));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if((i == 4 && j == 5) || (i == 4 && j == 1) || (i == 2 && j == 5) ||
                        (i == 2 && j == 1) || (i == 5 && j == 4) || (i == 5 && j == 2) ||
                        (i == 1 && j == 4) || (i == 1 && j == 2))
                    assertEquals("Helyes ló lépés", 1, l.lepesEllenorzese(3, 3, i, j));
                else 
                    assertEquals("Helytelen ló lépés", 0, l.lepesEllenorzese(3, 3, i, j));
            }
    }
    
    @Test
    public void LoLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Lo l = new Lo("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(3, 3, new Mezo(l));
        
        t.getMezo(3, 3).getBabu().lepes(3, 3, 4, 5);
        for(int i=0;i<8;i++) 
            for(int j=0;j<8;j++) {
                if(i == 4 && j == 5)
                    assertTrue("Jó helyre lépett a ló", t.getMezo(i, j).getBabu() != null &&
                            t.getMezo(i, j).getBabu().getTipus().equals("L"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
}
