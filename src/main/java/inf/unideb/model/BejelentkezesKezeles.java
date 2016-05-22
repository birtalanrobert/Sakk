package inf.unideb.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * A bejelentkezést kezelő osztály.
 * 
 * @author Birtalan
 */
public class BejelentkezesKezeles {
    
    private List<Felhasznalo> felhasznalok = new ArrayList<>();
    private static int jatekos=0;
    private static int pontszam=0;
    
    /**
     * Visszaadja a {@code pontszam} változó értékét.
     * 
     * @return egy pontszámot.
     */
    public int getPontszam() {
        return BejelentkezesKezeles.pontszam;
    }
    
    
    /**
     * Ellenőrzi, hogy a megadott felhasználónév és jelszó szerepel e az
     * adatbázisban. Kiolvassa egy {@code List<Felhasznalo>} listába az összes
     * felhasználót. Ha szerepel a megadott felhasználónév és jelszó a listában,
     * akkor a felhasználó pontszámát lementi a {@code pontszam} változóba.
     * 
     * @param felhasznalo egy felhasználónév.
     * @param jelszo egy jelszó.
     * @return Ha szerepel a felhasználónév és jelszó az adatbázisban, akkor
     * igazat térít vissza, különben hamisat.
     * 
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     */
    public boolean felhasznaloEgyezes(String felhasznalo, String jelszo) throws ParserConfigurationException, SAXException, IOException {
       
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        felhasznalok = feldolgozo.getFelhasznalok();
        for(int i=0;i<felhasznalok.size();i++) {
            String f = felhasznalok.get(i).getFelhasznalonev();
            String j = felhasznalok.get(i).getJelszo();
            if(f.equals(felhasznalo) && j.equals(jelszo)) {
                BejelentkezesKezeles.pontszam = felhasznalok.get(i).getPont();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Ellenőrzi, hogy a megadott szöveg üres e.
     * 
     * @param mezo az ellenőrizni kívánt szöveg.
     * @return Ha üres a megadott szöveg akkor hamisat térít vissza, különben igazat.
     */
    public boolean uresMezo(String mezo) {
        return !mezo.equals("");
    }
    
    /**
     * Visszaadja a bejelentkezett játékosok számát.
     * 
     * @return a bejelentkezett játékosok száma.
     */
    public int belepettJatekosok() {
        return BejelentkezesKezeles.jatekos;
    }
    
    /**
     * Növeli a belépett játékosok számát.
     */
    public void belepettJatekosokNovelese() {
        BejelentkezesKezeles.jatekos++;
    }
}
