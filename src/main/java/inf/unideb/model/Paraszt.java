package inf.unideb.model;

/**
 * Egy paraszt bábút tartalmazó osztály. A {@code Babu} osztály leszármazottja. 
 * Minden bábú típus egy külön osztállyal rendelkezik, amelynek a lépés
 * ellenőrző metódusai vannak felülírva.
 * 
 * @author Birtalan
 */
public class Paraszt extends Babu {
   
    /**
     * Konstruktor egy {@code Paraszt} objektum létrehozására.
     * Meghívja a {@code Babu} osztály konstruktorát beállítva
     * a típust "P"-re, azaz parasztra.
     * 
     * @param szin a paraszt színe.
     * 
     */
    public Paraszt(String szin) {
        super(szin, "P");
    }

    /**
     * Végrehajtja egy paraszt lépését amennyiben jó lépés volt megadva.
     * A visszatérési érték 0, ha nem lehet meglépni a lépést, 
     * 1 ha meg lehet lépni lépést és sima lépésről van szó,
     * 2 ha speciális lépéról van szó, azaz, ha a paraszt elérte
     * a legutolsó sort, akkor átalakul {@code Kiralyno} típusú bábúra.
     * 
     * @param i amelyik sorból lépünk a bábúval.
     * @param j amelyik oszlopból lépünk a bábúval.
     * @param x amelyik sorba lépünk a bábúval.
     * @param y amelyik oszlopba lépünk a bábúval.
     * @return a lépés helyessége.
     */
    @Override
    public int lepes(int i, int j, int x, int y) {
         Tabla t = new Tabla();
        if(lepesEllenorzese(i, j, x, y) == 1) {
            t.setMezo(x, y, t.getMezo(i, j));
            t.setMezo(i, j, new Mezo());
            return 1;
        }
        if(lepesEllenorzese(i, j, x, y) == 3) {
            t.setMezo(x, y, new Mezo(new Kiralyno(t.getMezo(i, j).getBabu().getSzin())));
            t.setMezo(i, j, new Mezo());
            return 3;
        }
        return 0;
    }
    
    /**
     * Ellenőrzi, hogy jó lépés volt megadva. A visszatérési érték
     * 0, ha rossz lépés volt megadva, 1 ha jó lépés volt megadva és
     * egyszerű paraszt lépés, 2 ha jó lépés volt megadva és speciális lépés.
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
         
        if(t.getMezo(i, j).getBabu().getSzin().equals("W")) {
            if(i == 6 && j == y && x-i == -2)
                if(t.getMezo(x, y).getBabu() == null && t.getMezo(x+1, y).getBabu() == null)
                    return 1;
            if(j == y && x-i == -1)
                if(t.getMezo(x, y).getBabu() == null)
                    if(x == 0)
                        return 3;
                    else
                        return 1;
            if(x-i == -1 && Math.abs(y-j) == 1 && t.getMezo(x, y).getBabu() != null)
                if(t.getMezo(x, y).getBabu().getSzin().equals("B"))
                    if(x == 0)
                        return 3;
                    else
                        return 1;
        }
        else {
            if(i == 1 && j == y && x-i == 2)
                if(t.getMezo(x, y).getBabu() == null && t.getMezo(x-1, y).getBabu() == null)
                    return 1;
            if(j == y && x-i == 1)
                if(t.getMezo(x, y).getBabu() == null)
                    if(x == 7)
                        return 3;
                    else
                        return 1;
            if(x-i == 1 && Math.abs(y-j) == 1 && t.getMezo(x, y).getBabu() != null)
                if(t.getMezo(x, y).getBabu().getSzin().equals("W"))
                    if(x == 7)
                        return 3;
                    else
                    return 1;
        }
        return 0;
    }
}
