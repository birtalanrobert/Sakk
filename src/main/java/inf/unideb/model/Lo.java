package inf.unideb.model;

/**
 * Egy ló bábút tartalmazó osztály. A {@code Babu} osztály leszármazottja. 
 * Minden bábú típus egy külön osztállyal rendelkezik, amelynek a lépés
 * ellenőrző metódusai vannak felülírva.
 * 
 * @author Birtalan
 */
public class Lo extends Babu {

    /**
     * Konstruktor egy {@code Lo} objektum létrehozására.
     * Meghívja a {@code Babu} osztály konstruktorát beállítva
     * a típust "L"-re, azaz lóra.
     * 
     * @param szin a ló színe.
     */
    public Lo(String szin) {
        super(szin,"L");
    }
    
    /**
     * Ellenőrzi, hogy jó lépés volt megadva. Jó lépés esetén 1
     * a visszatérési érték, rossz lépés esetén 0.
     * 
     * @param i amelyik sorból lépünk a bábúval.
     * @param j amelyik oszlopból lépünk a bábúval.
     * @param x amelyik sorba lépünk a bábúval.
     * @param y amelyik oszlopba lépünk a bábúval.
     * @return lépés jól volt e megadva.
     */
    @Override
    public int lepesEllenorzese(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        if( (i+1 == x && j+2 == y) || (i+1 == x && j-2 == y) || (i-1 == x && j+2 == y) ||
                        (i-1 == x && j-2 == y) || (i+2 == x && j+1 == y) || (i+2 == x && j-1 == y) || 
                        (i-2 == x && j+1 == y) || (i-2 == x && j-1 == y)) {
            if(t.getMezo(x, y).getBabu() == null)
                return 1;
            if(!t.getMezo(i, j).getBabu().getSzin().equals(t.getMezo(x, y).getBabu().getSzin()))     
                return 1;
        }
        return 0;
    }
    
}
