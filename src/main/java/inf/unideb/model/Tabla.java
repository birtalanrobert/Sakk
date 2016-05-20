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
public class Tabla {
    
   private static Mezo tabla[][] = new Mezo[8][8];

   public void setMezo(int sor, int oszlop, Mezo m) {
       Tabla.tabla[sor][oszlop] = m;
   }
   
   public Mezo getMezo(int sor, int oszlop) {
       return Tabla.tabla[sor][oszlop];
   }
   
   
    
}
