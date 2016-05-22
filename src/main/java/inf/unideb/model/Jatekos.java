package inf.unideb.model;

/**
 * Egy játékost reprezentáló osztály.
 * 
 * @author Birtalan
 */
public class Jatekos {
    private final String felhasznalonev;
    private int pont;
    private final String szin;
    private boolean nyert;
    
    /**
     * Konstruktor egy {@code Jatekos} objektum létrehozására.
     * 
     * @param felhasznalonev egy felhasználónév.
     * @param pont egy pontszám.
     * @param szin egy szín.
     * @param nyert nyertes játékos e.
     */
    public Jatekos(String felhasznalonev, int pont, String szin, boolean nyert) {
        this.felhasznalonev = felhasznalonev;
        this.pont = pont;
        this.szin = szin;
        this.nyert = nyert;
    }
    
    /**
     * Visszaadja a játékos felhasználónevét.
     * 
     * @return egy felhasználónév.
     */
    public String getFelhasznalonev() {
        return this.felhasznalonev;
    }
    
    /**
     * Visszaadja a játékos pontszámát.
     * 
     * @return egy pontszám.
     */
    public int getPont() {
        return this.pont;
    }
    
    /**
     * Beállítja a játékos pontszámát.
     * 
     * @param p egy pontszám.
     */
    public void setPont(int p) {
        this.pont = p;
    }
    
    /**
     * Visszaadja egy játékos színét.
     * 
     * @return egy szín.
     */
    public String getSzin() {
        return this.szin;
    }
    
    /**
     * Visszaadja, hogy egy játékos nyert e.
     * 
     * @return a játékos nyert e.
     */
    public boolean getNyert() {
        return this.nyert;
    }
    
    /**
     * Beállítja, hogy egy játékos nyert e.
     * 
     * @param ny nyert e a játékos.
     */
    public void setNyert(boolean ny) {
        this.nyert = ny;
    }
}