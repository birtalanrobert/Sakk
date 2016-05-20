/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Birtalan
 */
public class TopLista {
    private SimpleIntegerProperty helyezes, pont;
    private SimpleStringProperty felhasznalonev;
    
    public TopLista(int helyezes, String felhasznalonev, int pont) {
        this.helyezes = new SimpleIntegerProperty(helyezes);
        this.felhasznalonev = new SimpleStringProperty(felhasznalonev);
        this.pont = new SimpleIntegerProperty(pont);
    }
    
    public SimpleIntegerProperty helyezesProperty() {
        return helyezes;
    }
    
    public SimpleStringProperty felhasznalonevProperty() {
        return felhasznalonev;
    }
    
    public SimpleIntegerProperty pontProperty() {
        return pont;
    }
}
