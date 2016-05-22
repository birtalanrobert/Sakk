package inf.unideb.model;

/**
 * A táblát tartalmazó objektum.
 * 
 * @author Birtalan
 */
public class Tabla {
    
   private static Mezo tabla[][] = new Mezo[8][8];

    /**
     * Beállítja a megfelelő pozícióban szereplő mező értékét.
     * 
     * @param sor a beállítani kívánt mező sora.
     * @param oszlop a beállítani kívánt mező oszlopa.
     * @param m a beállítni kívánt {@code Mezo}.
     */
    public void setMezo(int sor, int oszlop, Mezo m) {
       Tabla.tabla[sor][oszlop] = m;
   }
   
    /**
     * Visszaadja a tábla megfelelő pozíciójában szereplő mezőt.
     * 
     * @param sor a lekérdezni kívánt mező sora.
     * @param oszlop a lekérdezni kívánt mező oszlopa.
     * @return {@code Mezo} a tábla megfelelő pozíciójában szereplő mező.
     */
    public Mezo getMezo(int sor, int oszlop) {
       return Tabla.tabla[sor][oszlop];
   }
}
