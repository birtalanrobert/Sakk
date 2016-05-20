/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

import java.util.Comparator;

/**
 *
 * @author Birtalan
 */
public class Felhasznalo {
    
    private String felhasznalonev;
    private String jelszo;
    private int pont;
    
    public Felhasznalo(String felhasznalonev, String jelszo, int pont) {
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
        this.pont = pont;
    }
    
    public String getFelhasznalonev() {
        return this.felhasznalonev;
    }
    
    public String getJelszo() {
        return this.jelszo;
    }
    
    public int getPont() {
        return this.pont;
    }
    
    public void setPont(int p) {
        this.pont = p;
    }
    
    @Override
    public String toString() {
        return "Felhasznalonev: " + felhasznalonev + "pontszam: " + pont;
    }
  
     public static Comparator<Felhasznalo> felhasznaloRendezo = new Comparator<Felhasznalo>() {

        //@Override
	public int compare(Felhasznalo s1, Felhasznalo s2) {

	   int rollno1 = s1.getPont();
	   int rollno2 = s2.getPont();

	   return rollno2-rollno1;
   }};
}
