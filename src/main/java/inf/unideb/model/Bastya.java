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
public class Bastya extends Babu{

    public Bastya(String szin) {
        super(szin, "B");
    }
    
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
