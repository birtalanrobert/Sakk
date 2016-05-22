package inf.unideb.model;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Egy {@code Felhasznalo} regisztrálását reprezentáló osztály.
 * 
 * @author Birtalan
 */
public class RegisztracioKezeles {
    
    /**
     * A megkapott felhasználót ellenőrzi, hogy szerepel e az adatbázisban.
     * 
     * @param f az ellenőrizni kívánt {@code Felhasznalo}.
     * @return Ha nem szerepel a felhasználók között, akkor igazat térit vissza, 
     * különben hamisat.
     * 
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     */
    public boolean regisztracioEllenorzes(Felhasznalo f) throws ParserConfigurationException, SAXException, IOException {
        BejelentkezesKezeles bejelentkezes = new BejelentkezesKezeles();
        return !bejelentkezes.felhasznaloEgyezes(f.getFelhasznalonev(), f.getJelszo());
    }
    
    /**
     * Ellenőrzi, hogy a megkapott szöveg üres e.
     * 
     * @param mezo ellenőrizni kívánt szöveg.
     * @return Amennyiben üres, hamisat térít vissza, különben igazat.
     */
    public boolean uresMezo(String mezo) {
        return !mezo.equals("");
    }
}
