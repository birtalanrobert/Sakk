package inf.unideb;

import inf.unideb.model.Bastya;
import inf.unideb.model.Mezo;
import inf.unideb.model.Tabla;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BastyaTest {    
    @Test
    public void BastyaLepesEllenorzes() {
        Tabla t = new Tabla();
        Bastya b = new Bastya("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 3, new Mezo(b));
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++) {
                if(i == 0 && j != 3) 
                    assertEquals("Helyes vízszintes lépés bástya", 1, b.lepesEllenorzese(0, 3, i, j));
                if(i != 0 && j == 3) 
                    assertEquals("Helyes függőleges lépés bástya", 1, b.lepesEllenorzese(0, 3, i, j));
                if(i != 0 && j != 3)
                    assertEquals("Helytelen lépés bástya", 0, b.lepesEllenorzese(0, 3, i, j));
            }
        t.setMezo(0, 3, new Mezo());
    }
    
    @Test
    public void BastyaLepesVegrehajtasEllenorzes() {
        Tabla t = new Tabla();
        Bastya b = new Bastya("B");
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
        t.setMezo(0, 0, new Mezo(b));
        t.setMezo(0, 6, new Mezo(new Bastya("W")));
        
        t.getMezo(0, 0).getBabu().lepes(0, 0, 0, 6);
        for(int i=0;i<8;i++) 
            for(int j=0;j<8;j++) {
                if(i == 0 && j == 6)
                    assertTrue("Jó helyre lépett a bástya", t.getMezo(i, j).getBabu() != null &&
                            t.getMezo(i, j).getBabu().getTipus().equals("B"));
                else
                    assertTrue("Üres mező", t.getMezo(i, j).getBabu() == null);
            }
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                t.setMezo(i, j, new Mezo());
    }
    
}
