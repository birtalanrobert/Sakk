/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * A {@code ToplistaController} osztályban szereplő {@code TableView}
 * egy sorát reprezentáló osztály.
 * 
 * @author Birtalan
 */
public class TopLista {
    private SimpleIntegerProperty helyezes, pont;
    private SimpleStringProperty felhasznalonev;
    
    /**
     * Konstruktor egy {@code TopLista} objektum létrehozására.
     * 
     * @param helyezes egy index.
     * @param felhasznalonev egy felhasználónév.
     * @param pont egy pontszám.
     */
    public TopLista(int helyezes, String felhasznalonev, int pont) {
        this.helyezes = new SimpleIntegerProperty(helyezes);
        this.felhasznalonev = new SimpleStringProperty(felhasznalonev);
        this.pont = new SimpleIntegerProperty(pont);
    }
    
    /**
     * Visszaadja a {@code TableView} egy helyezését.
     * 
     * @return egy helyezés.
     */
    public SimpleIntegerProperty helyezesProperty() {
        return helyezes;
    }
    
    /**
     * Visszaadja a {@code TableView} egy felhasználónevét.
     * 
     * @return egy felhasználónév.
     */
    public SimpleStringProperty felhasznalonevProperty() {
        return felhasznalonev;
    }
    
    /**
     * Visszaadja a {@code TableView} egy pontszámát.
     * 
     * @return egy pontszám.
     */
    public SimpleIntegerProperty pontProperty() {
        return pont;
    }
}