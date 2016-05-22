package inf.unideb.model;

import java.util.Comparator;

/**
 * Egy felhasználót reprezentáló osztály.
 * 
 * @author Birtalan
 */
public class Felhasznalo {
    
    private String felhasznalonev;
    private String jelszo;
    private int pont;
    
    /**
     * Konstruktor egy {@code Felhasznalo} objektum létrehozására.
     * 
     * @param felhasznalonev egy felhasználónév.
     * @param jelszo egy jelszó.
     * @param pont egy pontszám.
     */
    public Felhasznalo(String felhasznalonev, String jelszo, int pont) {
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
        this.pont = pont;
    }
    
    /**
     * Visszaadja egy felhasználó felhasználónevét.
     * 
     * @return egy felhasználónév.
     */
    public String getFelhasznalonev() {
        return this.felhasznalonev;
    }
    
    /**
     * Visszaadja egy felhasználó jelszavát.
     * 
     * @return egy jelszó.
     */
    public String getJelszo() {
        return this.jelszo;
    }
    
    /**
     * Visszaadja egy felhasználó pontszámát.
     * 
     * @return egy pontszám.
     */
    public int getPont() {
        return this.pont;
    }
    
    /**
     * Beállítja egy felhasználó pontszámát.
     * 
     * @param p egy pontszám.
     */
    public void setPont(int p) {
        this.pont = p;
    }
  
    /**
     * Egy {@code Comparator<Felhasznalo>} változó, amelynek segítségével a felhasználókat
     * majd csökkenő sorrendbe lehet rendezni.
     */
    public static Comparator<Felhasznalo> felhasznaloRendezo = new Comparator<Felhasznalo>() {

	public int compare(Felhasznalo s1, Felhasznalo s2) {

	   int rollno1 = s1.getPont();
	   int rollno2 = s2.getPont();

	   return rollno2-rollno1;
   }};
}
