/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb;

import inf.unideb.model.Futo;
import inf.unideb.model.Mezo;
import inf.unideb.model.Tabla;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Birtalan
 */
public class FutoTest {
    
    @Test
    public void FutoLepesEllenorzes() {
        Tabla t = new Tabla();
        Futo fB = new Futo("B");
        Futo fW = new Futo("W");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(3, 3, new Mezo(fB));
        t.setMezo(5, 5, new Mezo(fW));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if((i-j == 0 && i != 3 && i < 6) || (i+j == 6 && i != 3))    
                    assertEquals("Helyes futó lépés" + i + " - " + j, 1, t.getMezo(3, 3).getBabu().lepesEllenorzese(3, 3, i, j));
                else
                    assertEquals("Helytelen futó lépés" + i + " - " + j, 0, t.getMezo(3, 3).getBabu().lepesEllenorzese(3, 3, i, j));
            }
                
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
    @Test
    public void FutoLepesVegehajtasEllenorzes() {
        Tabla t = new Tabla();
        Futo fB = new Futo("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(3, 3, new Mezo(fB));
        t.getMezo(3, 3).getBabu().lepes(3, 3, 1, 5);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 1 && j == 5)
                    assertTrue("Jó helyre lépett a futó", t.getMezo(i, j).getBabu().getTipus().equals("F"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
}
