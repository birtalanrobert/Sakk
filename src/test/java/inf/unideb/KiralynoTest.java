/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import inf.unideb.model.Kiralyno;
import inf.unideb.model.Mezo;
import inf.unideb.model.Tabla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Birtalan
 */
public class KiralynoTest {
    @Test
    public void KiralynoLepesEllenorzes() {
        Tabla t = new Tabla();
        Kiralyno qB = new Kiralyno("B");
        Kiralyno qW = new Kiralyno("W");
        
        for(int i=0;i<8;i++)
           for(int j=0;j<8;j++)
               t.setMezo(i, j, new Mezo());
        t.setMezo(3, 3, new Mezo(qB));
        t.setMezo(1, 5, new Mezo(qW));
        
         for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if((i-j == 0 && i != 3) || (i+j == 6 && i != 3 && i>0 ))
                    assertEquals("Helyes átlós királynő lépés", 1, t.getMezo(3, 3).getBabu().lepesEllenorzese(3, 3, i, j));
                else if(i == 3 && j != 3)
                    assertEquals("Helyes vízszintes királynő lépés", 1, t.getMezo(3, 3).getBabu().lepesEllenorzese(3, 3, i, j));
                else if(i != 3 && j == 3)
                    assertEquals("Helyes függőleges királynő lépés", 1, t.getMezo(3, 3).getBabu().lepesEllenorzese(3, 3, i, j));
                else
                    assertEquals("Helytelen királynő lépés", 0, t.getMezo(3, 3).getBabu().lepesEllenorzese(3, 3, i, j));
            }
         
         for(int i=0;i<8;i++)
             for(int j=0;j<8;j++)
                 t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void KiralynoLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Kiralyno qB = new Kiralyno("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
               t.setMezo(i, j, new Mezo());
        t.setMezo(3, 3, new Mezo(qB));
        t.getMezo(3, 3).getBabu().lepes(3, 3, 6, 0);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 6 && j == 0)
                    assertTrue("Jó helyre lépett a királynő", t.getMezo(i, j).getBabu().getTipus().equals("Q"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
}
