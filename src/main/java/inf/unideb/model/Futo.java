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
public class Futo extends Babu {

    public Futo(String szin) {
        super(szin,"F");
    }
    

    @Override
    public int lepesEllenorzese(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        int iter1, iter2;
        
        if(t.getMezo(x, y).getBabu() == null || 
          !t.getMezo(x, y).getBabu().getSzin().equals(t.getMezo(i, j).getBabu().getSzin()))
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
        return 0;
    }
    
}
