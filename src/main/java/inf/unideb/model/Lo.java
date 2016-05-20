/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

/**
 *
 * @author Birtalan
 */
public class Lo extends Babu {

    public Lo(String szin) {
        super(szin,"L");
    }
    
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
