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
public class Kiraly extends Babu {
    
    public Kiraly(String szin) {
        super(szin,"K");
    }
    
    @Override
    public int lepes(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        if(lepesEllenorzese(i, j, x, y) == 1) {
            t.setMezo(x, y, t.getMezo(i, j));
            t.setMezo(i, j, new Mezo());
            return 1;
        }
        if(lepesEllenorzese(i, j, x, y) == 2) {
            if(j-y == -2) {
                if(t.getMezo(i, j).getBabu().getSzin().equals("W")) {
                    t.setMezo(i, j+1, t.getMezo(7, 7));
                    t.setMezo(7, 7, new Mezo());
                }
                else {
                    t.setMezo(i, j+1, t.getMezo(0, 7));
                    t.setMezo(0, 7, new Mezo());
                }
            }
            if(j-y == 2) {
                if(t.getMezo(i, j).getBabu().getSzin().equals("W")) {
                    t.setMezo(i, j-1, t.getMezo(7, 0));
                    t.setMezo(0, 7, new Mezo());
                }
                else {
                    t.setMezo(i, j-1, t.getMezo(0, 0));
                    t.setMezo(0, 0, new Mezo());
                }
            }
            t.setMezo(x, y, t.getMezo(i, j));
            t.setMezo(i, j, new Mezo());
            return 2;
        }
        
        return 0;
    }
    
    @Override
    public int lepesEllenorzese(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        
        if(t.getMezo(x, y).getBabu() == null || 
          !t.getMezo(x, y).getBabu().getSzin().equals(t.getMezo(i, j).getBabu().getSzin())) {
            if(Math.abs(x-i) <= 1 && Math.abs(y-j) <= 1)
                return 1;
            else
                if(i == x && Math.abs(y-j) == 2) {
                    if(t.getMezo(i, j).getBabu().getSzin().equals("W")) {
                        if(i == 7 && j == 4) {
                            if(j < y && t.getMezo(7, 7).getBabu() != null &&
                              t.getMezo(7, 7).getBabu().getTipus().equals("B")) {
                                for(int iter = j+1; iter < 7; iter++)
                                    if(t.getMezo(i, iter).getBabu() != null)
                                        return 0;
                                return 2;
                            }
                            else
                                if(j > y && t.getMezo(7, 0).getBabu() != null &&
                                  t.getMezo(7, 0).getBabu().getTipus().equals("B")) {
                                    for(int iter = j-1; iter > 0; iter--)
                                        if(t.getMezo(i, iter).getBabu() != null)
                                            return 0;
                                    return 2;
                                }
                        }
                    }
                    else {
                        if(i == 0 && j == 4) {
                            if(j < y && t.getMezo(0, 7).getBabu() != null &&
                              t.getMezo(0, 7).getBabu().getTipus().equals("B")) {
                                    for(int iter = j+1; iter < 7; iter++)
                                        if(t.getMezo(i, iter).getBabu() != null)
                                            return 0;
                                    return 2;
                            }
                            else
                                if(j > y && t.getMezo(0, 0).getBabu() != null &&
                                   t.getMezo(0, 0).getBabu().getTipus().equals("B")) {
                                        for(int iter = j-1; iter > 0; iter--)
                                            if(t.getMezo(i, iter).getBabu() != null)
                                                return 0;
                                        return 2;
                                }
                        }
                    }
                }
        }
        return 0;
    }
    
}
