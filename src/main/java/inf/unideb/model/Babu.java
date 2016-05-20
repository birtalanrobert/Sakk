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
public abstract class Babu {
    private final String szin;
    private String tipus;
    
    public  Babu(String szin, String tipus) {
        this.szin = szin;
        this.tipus = tipus;
    }
    
    public String getSzin() {
        return this.szin;
    }
    
    public void setTipus(String t) {
        this.tipus = t;
    }
    
    public String getTipus() {
        return this.tipus;
    }
    
    public int lepes(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        if(lepesEllenorzese(i, j, x, y) == 1) {
            t.setMezo(x, y, t.getMezo(i, j));
            t.setMezo(i, j, new Mezo());
            return 1;
        }
        return 0;
    }
    
    public abstract int lepesEllenorzese(int i, int j, int x, int y);
}
