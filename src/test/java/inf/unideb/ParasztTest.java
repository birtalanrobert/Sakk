/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import inf.unideb.model.Mezo;
import inf.unideb.model.Paraszt;
import inf.unideb.model.Tabla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Birtalan
 */
public class ParasztTest {
    @Test
    public void ParasztLepesEllenorzes() {
        Tabla t = new Tabla();
        Paraszt pB = new Paraszt("B");
        Paraszt pW = new Paraszt("W");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(1, 1, new Mezo(pB));
        t.setMezo(2, 2, new Mezo(pW));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(j == 1 && (i == 2 || i == 3))
                    assertEquals("Helyes paraszt lépés", 1, t.getMezo(1, 1).getBabu().lepesEllenorzese(1, 1, i, j));
                else
                    if(i == 2 && j == 2)
                        assertEquals("Helyes ütő paraszt lépés", 1, t.getMezo(1, 1).getBabu().lepesEllenorzese(1, 1, i, j));
                    else
                        assertEquals("Helytelen paraszt lépés", 0, t.getMezo(1, 1).getBabu().lepesEllenorzese(1, 1, i, j));
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void ParasztSpecialisLepesEllenorzes() {
        Tabla t = new Tabla();
        Paraszt pB = new Paraszt("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(6, 1, new Mezo(pB));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 7 && j == 1)
                    assertEquals("Helyes speciális paraszt lépés", 3, t.getMezo(6, 1).getBabu().lepesEllenorzese(6, 1, i, j));
                else
                    assertEquals("Helytelen paraszt lépés", 0, t.getMezo(6, 1).getBabu().lepesEllenorzese(6, 1, i, j));
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void ParasztSimaLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Paraszt pB = new Paraszt("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(1, 1, new Mezo(pB));
        t.getMezo(1, 1).getBabu().lepes(1, 1, 2, 1);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 2 && j == 1)
                    assertTrue("Jó helyre lépett a paraszt", t.getMezo(i, j).getBabu().getTipus().equals("P"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void ParasztUtesEllenorzes() {
        Tabla t = new Tabla();
        Paraszt pB = new Paraszt("B");
        Paraszt pW = new Paraszt("W");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(1, 1, new Mezo(pB));
        t.setMezo(2, 2, new Mezo(pW));
        t.getMezo(1, 1).getBabu().lepes(1, 1, 2, 2);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 2 && j == 2)
                    assertTrue("Jó helyre lépett a paraszt", t.getMezo(i, j).getBabu().getTipus().equals("P"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void ParasztSpecialisLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Paraszt pB = new Paraszt("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(6, 1, new Mezo(pB));
        t.getMezo(6, 1).getBabu().lepes(6, 1, 7, 1);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 7 && j == 1)
                    assertTrue("Jó helyre lépett a paraszt", t.getMezo(i, j).getBabu().getTipus().equals("Q"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void ParasztKezdoLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Paraszt pB = new Paraszt("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(1, 1, new Mezo(pB));
        t.getMezo(1, 1).getBabu().lepes(1, 1, 3, 1);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 3 && j == 1)
                    assertTrue("Jó helyre lépett a paraszt", t.getMezo(i, j).getBabu().getTipus().equals("P"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
}
