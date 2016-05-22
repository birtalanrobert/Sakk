package inf.unideb.model;

/**
 * A sakktábla egy mezőjét tartalmazó osztály. Amely egy {@code Babu} 
 * elemet tartalmaz, amennyiben az adott mezőn kell, hogy legyen bábú.
 * Amennyiben nincs bűbú az adott mezőn, ezt úgy jelöli, hogy null értékű
 * lesz a {@code babu} változó.
 * 
 * @author Birtalan
 */
public class Mezo {
    
    private Babu babu;
    
    /**
     * Konstruktor egy {@code Mezo} objektum létrehozására. Beállítja üresre
     * a mező bábúját.
     */
    public Mezo() {
        this.babu = null;
    }
    
    /**
     * Konstruktor egy {@code Mezo} objektum létrehozására. Beállítja a megfelelő
     * bábúra az objektum {@code babu} változóját.
     * 
     * @param babu a beállítani kivánt {@code Babu}.
     */
    public Mezo(Babu babu) {
        this.babu = babu;
    }
    
    /**
     * Beállítja a mező bábúját.
     * 
     * @param b a beállítani kivánt {@code Babu}.
     */
    public void setBabu(Babu b) {
        this.babu = b;
    }

    /**
     * Visszaadja a mezőn szereplő bábút.
     * @return a mező bábúja.
     */
    public Babu getBabu() {
        return this.babu;
    }
    
    /**
     * Beállítja a mezőt üresre.
     */
    public void setBabuUres () {
        this.babu = null;
    }
    
}
