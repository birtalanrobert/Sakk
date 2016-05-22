package inf.unideb.model;

/**
 * Egy királynő bábút tartalmazó osztály. A {@code Babu} osztály leszármazottja. 
 * Minden bábú típus egy külön osztállyal rendelkezik, amelynek a lépés
 * ellenőrző metódusai vannak felülírva.
 * 
 * @author Birtalan
 */
public class Kiralyno extends Babu {

    /**
     * Konstruktor egy {@code Kiralyno} objektum létrehozására.
     * Meghívja a {@code Babu} osztály konstruktorát beállítva
     * a típust "Q"-ra, azaz királynőre.
     * 
     * @param szin a királynő színe.
     */
    public Kiralyno(String szin) {
        super(szin,"Q");
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
        int iter1, iter2;
        
        if(t.getMezo(x, y).getBabu() == null ||
          !t.getMezo(x, y).getBabu().getSzin().equals(t.getMezo(i, j).getBabu().getSzin())) {
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
            if(i-j == x-y || i+j == x+y) {
                if(i < x) { //le
                    if(j < y) {  //jobbra
                        iter1 = i+1;
                        iter2 = j+1;
                        while(iter1 < x && iter2 < y) {
                            if(t.getMezo(iter1, iter2).getBabu() != null)
                                return 0;
                            iter1++;
                            iter2++;
                        }
                        return 1;
                    }
                    if(j > y) { //balra
                        iter1 = i+1;
                        iter2 = j-1;
                        while(iter1 < x && iter2 > y) {
                            if(t.getMezo(iter1, iter2).getBabu() != null)
                                return 0;
                            iter1++;
                            iter2--;
                        }
                        return 1;
                    }
                }
                if(i > x) { //fel
                    if(j < y) { //jobbra
                        iter1 = i-1;
                        iter2 = j+1;
                        while(iter1 > x && iter2 < y) {
                            if(t.getMezo(iter1, iter2).getBabu() != null)
                                return 0;
                            iter1--;
                            iter2++;
                        }
                        return 1;
                    }
                    if(j > y) { //bal
                        iter1 = i-1;
                        iter2 = j-1;
                        while(iter1 > x && iter2 > y) {
                            if(t.getMezo(iter1, iter2).getBabu() != null)
                                return 0;
                            iter1--;
                            iter2--;
                        }
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
