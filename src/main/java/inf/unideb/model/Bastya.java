package inf.unideb.model;

/**
 * Egy bástya bábút tartalmazó osztály. A {@code Babu} osztály leszármazottja. 
 * Minden bábú típus egy külön osztállyal rendelkezik, amelynek a lépés
 * ellenőrző metódusai vannak felülírva.
 * 
 * @author Birtalan
 */
public class Bastya extends Babu{

    /**
     * Konstruktor egy {@code Bastya} objektum létrehozására.
     * Meghívja a {@code Babu} osztály konstruktorát beállítva
     * a típust "B"-re, azaz bástyára.
     * 
     * @param szin a bástya színe
     */
    public Bastya(String szin) {
        super(szin, "B");
    }
    
    /**
     * {@inheritDoc} Ellenőrzi, hogy jó lépés volt megadva. Jó lépés esetén 1
     * a visszatérési érték, rossz lépés esetén 0.
     * 
     * @param i amelyik sorból lépünk a bábúval
     * @param j amelyik oszlopból lépünk a bábúval
     * @param x amelyik sorba lépünk a bábúval
     * @param y amelyik oszlopba lépünk a bábúval
     * @return lépés jól volt e megadva
     */
    @Override
    public int lepesEllenorzese(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        if(t.getMezo(x, y).getBabu() == null || 
          !t.getMezo(x, y).getBabu().getSzin().equals(t.getMezo(i, j).getBabu().getSzin()))
            if(i == x) { //vizszintes
                if(j < y) { //jobb
                    for(int iter = j+1; iter < y; iter++)
                        if(t.getMezo(i, iter).getBabu() != null)
                            return 0;
                    return 1;
                }
                if(j > y) { //bal
                    for(int iter = j-1; iter > y; iter--)
                        if(t.getMezo(i, iter).getBabu() != null)
                            return 0;
                    return 1;
                }
            }
            else
                if(j == y) { //fuggoleges
                    if(i < x) { //le
                        for(int iter = i+1; iter < x; iter++)
                            if(t.getMezo(iter, j).getBabu() != null)
                                return 0;
                        return 1;
                    }
                    if(i > x) { //fel
                        for(int iter = i-1; iter > x; iter--)
                            if(t.getMezo(iter, j).getBabu() != null)
                                return 0;
                        return 1;
                    }
                }
        return 0;
    }
}
