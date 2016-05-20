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
public class Paraszt extends Babu {
   
    public Paraszt(String szin) {
        super(szin, "P");
    }

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
