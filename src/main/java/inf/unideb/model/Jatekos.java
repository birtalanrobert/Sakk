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
public class Jatekos {
    private final String felhasznalonev;
    private int pont;
    private final String szin;
    private boolean nyert;
    
    public Jatekos(String felhasznalonev, int pont, String szin, boolean nyert) {
        this.felhasznalonev = felhasznalonev;
        this.pont = pont;
        this.szin = szin;
        this.nyert = nyert;
    }
    
    public String getFelhasznalonev() {
        return this.felhasznalonev;
    }
    
    public int getPont() {
        return this.pont;
    }
    
    public void setPont(int p) {
        this.pont = p;
    }
    
    public String getSzin() {
        return this.szin;
    }
    
    public boolean getNyert() {
        return this.nyert;
    }
    
    public void setNyert(boolean ny) {
        this.nyert = ny;
    }
    
}
