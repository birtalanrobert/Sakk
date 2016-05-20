/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Birtalan
 */
public class JatekKezelo {
    private static Jatekos jatekos1;
    private static Jatekos jatekos2;
    private static Jatekos nyeroJatekos;
    private static int lepesekSzama = 0;
    private static int koordI;
    private static int koordJ;
    private static Node node; 
    
    public Jatekos getJatekos1() {
        return JatekKezelo.jatekos1;
    }
    
    public Jatekos getJatekos2() {
        return JatekKezelo.jatekos2;
    }
    
    public void setJatekos1(Jatekos j) {
        JatekKezelo.jatekos1 = j;
    }
    
    /**
     *
     * @param j
     */
    public void setJatekos2(Jatekos j) {
        JatekKezelo.jatekos2 = j;
    }
    
    
    public int getLepesekSzama() {
        return JatekKezelo.lepesekSzama;
    }
    
    public void lepesekSzamaNoveles() {
        JatekKezelo.lepesekSzama++;
    }
    
    public int getKoordI() {
        return JatekKezelo.koordI;
    }
    
    public void setKoordI(int i) {
        JatekKezelo.koordI = i;
    }
    
    public int getKoordJ() {
        return JatekKezelo.koordJ;
    }
    
    public void setKoordJ(int j) {
        JatekKezelo.koordJ = j;
    }
    
    public Node getNode() {
        return JatekKezelo.node;
    }
    
    public void setNode(Node n) {
        JatekKezelo.node = n;
    }
    
    public void tablaInicializalas() {
        Tabla t = new Tabla();
        t.setMezo(0, 0, new Mezo(new Bastya(jatekos2.getSzin())));
        t.setMezo(0, 1, new Mezo(new Lo(jatekos2.getSzin())));
        t.setMezo(0, 2, new Mezo(new Futo(jatekos2.getSzin())));
        t.setMezo(0, 3, new Mezo(new Kiralyno(jatekos2.getSzin())));
        t.setMezo(0, 4, new Mezo(new Kiraly(jatekos2.getSzin())));
        t.setMezo(0, 5, new Mezo(new Futo(jatekos2.getSzin())));
        t.setMezo(0, 6, new Mezo(new Lo(jatekos2.getSzin())));
        t.setMezo(0, 7, new Mezo(new Bastya(jatekos2.getSzin())));
        
        t.setMezo(1, 0, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 1, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 2, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 3, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 4, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 5, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 6, new Mezo(new Paraszt(jatekos2.getSzin())));
        t.setMezo(1, 7, new Mezo(new Paraszt(jatekos2.getSzin())));
        
        t.setMezo(6, 0, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 1, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 2, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 3, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 4, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 5, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 6, new Mezo(new Paraszt(jatekos1.getSzin())));
        t.setMezo(6, 7, new Mezo(new Paraszt(jatekos1.getSzin())));
        
        t.setMezo(7, 0, new Mezo(new Bastya(jatekos1.getSzin())));
        t.setMezo(7, 1, new Mezo(new Lo(jatekos1.getSzin())));
        t.setMezo(7, 2, new Mezo(new Futo(jatekos1.getSzin())));
        t.setMezo(7, 3, new Mezo(new Kiralyno(jatekos1.getSzin())));
        t.setMezo(7, 4, new Mezo(new Kiraly(jatekos1.getSzin())));
        t.setMezo(7, 5, new Mezo(new Futo(jatekos1.getSzin())));
        t.setMezo(7, 6, new Mezo(new Lo(jatekos1.getSzin())));
        t.setMezo(7, 7, new Mezo(new Bastya(jatekos1.getSzin())));
        
        for(int i = 2; i < 6; i++)
            for(int j = 0; j < 8; j++)
                t.setMezo(i, j, new Mezo());
    }
    
    public ImageView setParaszt(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WP.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BP.png"));
        iv.setImage(img);
        return iv;
    }
    
    public ImageView setBastya(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WB.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BB.png"));
        iv.setImage(img);
        return iv;
    }
    
    public ImageView setLo(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WL.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BL.png"));
        iv.setImage(img);
        return iv;
    }
    
    public ImageView setFuto(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WF.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BF.png"));
        iv.setImage(img);
        return iv;
    }
    
    public ImageView setKiraly(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WK.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BK.png"));
        iv.setImage(img);
        return iv;
    }
    
    public ImageView setKiralyno(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WQ.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BQ.png"));
        iv.setImage(img);
        return iv;
    }
    
  
    public boolean joBabuVoltValasztva(int sor, int oszlop) {
        Tabla t = new Tabla();
        if(t.getMezo(sor, oszlop).getBabu() != null) {
            if(JatekKezelo.lepesekSzama % 2 == 0) { //jatekos1
                if(t.getMezo(sor, oszlop).getBabu().getSzin().equals("W"))
                    return true;
            }
            else { //jatekos2
                if(t.getMezo(sor, oszlop).getBabu().getSzin().equals("B"))
                    return true;
            }
        }
        return false;
    }
     
    public int lepesEllenorzese(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        
        return t.getMezo(i, j).getBabu().lepes(i, j, x, y);
    }
    
    public ImageView imgCsere(ImageView mire) {
        ImageView iv = new ImageView();
        iv.setImage(mire.getImage());
        return iv;
    }
    
    public ImageView setUres() {
        ImageView iv = new ImageView();
        return iv;
    }
    public boolean vegeVan(int x, int y) { 
        Tabla t = new Tabla();
        
        return t.getMezo(x, y).getBabu() != null && t.getMezo(x, y).getBabu().getTipus().equals("K");    
    } 
    
    public void kiNyert(int x, int y) {
        Tabla t = new Tabla();
        if(t.getMezo(x, y).getBabu() != null && t.getMezo(x, y).getBabu().getTipus().equals("K")) {
            if(t.getMezo(x, y).getBabu().getSzin().equals("W"))
                jatekos2.setNyert(true);
            else
                jatekos1.setNyert(true);
        }
    }
    
    public void pontokFrissitese() throws TransformerException {
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        int pontszam;
        if(jatekos1.getNyert()) {
            if(jatekos1.getPont() > jatekos2.getPont())
                pontszam = jatekos1.getPont() + 2;
            else
                pontszam = jatekos1.getPont() + 5;
            jatekos1.setPont(pontszam);
        }
        if(jatekos2.getNyert()) {
            if(jatekos2.getPont() > jatekos1.getPont())
                pontszam = jatekos2.getPont() + 2;
            else
                pontszam = jatekos2.getPont() + 5;
            jatekos2.setPont(pontszam);
        }
        
        try {
            if(jatekos1.getNyert())
                feldolgozo.felhasznaloFrisites(jatekos1);
            if(jatekos2.getNyert())
                feldolgozo.felhasznaloFrisites(jatekos2);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(JatekKezelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
