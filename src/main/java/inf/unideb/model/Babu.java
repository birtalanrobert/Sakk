package inf.unideb.model;

/**
 * Egy bábút reprezentáló absztrakt osztály.
 * 
 * @author Birtalan
 */
public abstract class Babu {
    private final String szin;
    private String tipus;
    
    /**
     * Konstruktor egy {@code Babu} objektum létrehozására.
     * 
     * @param szin a bábú színe
     * @param tipus a bábú típusa
     */
    public  Babu(String szin, String tipus) {
        this.szin = szin;
        this.tipus = tipus;
    }
    
    /**
     * Visszaadja a bábú színét.
     * 
     * @return a bábú színe
     */
    public String getSzin() {
        return this.szin;
    }
    
    /**
     * Beállítja a bábú típusát.
     * 
     * @param t a bábú típusa
     */
    public void setTipus(String t) {
        this.tipus = t;
    }
    
    /**
     * Visszaadja a bábú típusát.
     * 
     * @return a bábú típusa
     */
    public String getTipus() {
        return this.tipus;
    }
    
    /**
     * Végrehajtja egy bábú lépését amennyiben jó lépés volt megadva.
     * 
     * @param i amelyik sorból lépünk a bábúval
     * @param j amelyik oszlopból lépünk a bábúval
     * @param x amelyik sorba lépünk a bábúval
     * @param y amelyik oszlopba lépünk a bábúval
     * @return a lépés helyessége, 0 ha nem lehet meglépni, 1 ha meg lehet lépni
     */
    public int lepes(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        if(lepesEllenorzese(i, j, x, y) == 1) {
            t.setMezo(x, y, t.getMezo(i, j));
            t.setMezo(i, j, new Mezo());
            return 1;
        }
        return 0;
    }
    
    /**
     * Ellenőrzi, hogy jó lépés volt megadva.
     * 
     * @param i amelyik sorból lépünk a bábúval
     * @param j amelyik oszlopból lépünk a bábúval
     * @param x amelyik sorba lépünk a bábúval
     * @param y amelyik oszlopba lépünk a bábúval
     * @return lépés jól volt e megadva
     */
    public abstract int lepesEllenorzese(int i, int j, int x, int y);
}
