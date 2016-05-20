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
public class Mezo {
    
    private Babu babu;
    
    public Mezo() {
        this.babu = null;
    }
    
    public Mezo(Babu babu) {
        this.babu = babu;
    }
    
    public void setBabu(Babu b) {
        this.babu = b;
    }
    public Babu getBabu() {
        return this.babu;
    }
    
    public void setBabuUres () {
        this.babu = null;
    }
    
}
