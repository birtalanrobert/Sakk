package inf.unideb.model;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * A játék menetét és a {@code Controller} osztályokat összekötő osztály.
 * 
 * @author Birtalan
 */
public class JatekKezelo {
    private static Jatekos jatekos1;
    private static Jatekos jatekos2;
    private static int lepesekSzama = 0;
    private static int koordI;
    private static int koordJ;
    private static Node node; 
    
    private static final Logger logger = LoggerFactory.getLogger(JatekKezelo.class);
    
    /**
     * Visszaadja a {@code jatekos1}-et.
     * 
     * @return az elsőnek belépett {@code Jatekos}.
     */
    public Jatekos getJatekos1() {
        return JatekKezelo.jatekos1;
    }
    
    /**
     * Visszaadja a {@code jatekos2}-et.
     * 
     * @return a másodiknak belépett {@code Jatekos}.
     */
    public Jatekos getJatekos2() {
        return JatekKezelo.jatekos2;
    }
    
    /**
     * Beállítja a {@code jatekos1} értékét a megkapott játékosra.
     * 
     * @param j egy játékos.
     */
    public void setJatekos1(Jatekos j) {
        JatekKezelo.jatekos1 = j;
    }
    
    /**
     * Beállítja a {@code jatekos2} értékét a megkapott játékosra.
     * 
     * @param j egy játékos.
     */
    public void setJatekos2(Jatekos j) {
        JatekKezelo.jatekos2 = j;
    }
    
    /**
     * Visszaadja a {@code lepesekSzama} értékét.
     * 
     * @return a lépések száma. 
     */
    public int getLepesekSzama() {
        return JatekKezelo.lepesekSzama;
    }
    
    /**
     * Növeli 1-el a {@code lepesekSzama} értékét.
     */
    public void lepesekSzamaNoveles() {
        JatekKezelo.lepesekSzama++;
    }
    
    /**
     * Visszaadja a {@code koordI} értékét. 
     * 
     * @return egy koordináta, az a sor ahonnan lépni akar a játékos.
     */
    public int getKoordI() {
        return JatekKezelo.koordI;
    }
    
    /**
     * Beállítja a {@code koordI} értékét.
     * 
     * @param i a beállítani kívánt koordináta.
     */
    public void setKoordI(int i) {
        JatekKezelo.koordI = i;
    }
    
    /**
     * Visszaadja a {@code koordJ} értékét. 
     * 
     * @return egy koordináta, az az oszlop ahonnan lépni akar a játékos.
     */
    public int getKoordJ() {
        return JatekKezelo.koordJ;
    }
    
    /**
     * Beállítja a {@code koordJ} értékét.
     * 
     * @param j a beállítani kívánt koordináta.
     */
    public void setKoordJ(int j) {
        JatekKezelo.koordJ = j;
    }
    
    /**
     * Visszaadja a {@code node} értékét.
     * 
     * @return egy {@code Node}, az a csomópont, ahonnan ellépett a játékos.
     */
    public Node getNode() {
        return JatekKezelo.node;
    }
    
    /**
     * Beállítja a {@code node} értékét.
     * 
     * @param n egy {@code Node}.
     */
    public void setNode(Node n) {
        JatekKezelo.node = n;
    }
    
    /**
     * Inicializálja a {@code Tabla} osztály {@code tabla} változójának az elemeit.
     * Létrehozza a megfelelő pozíciókra a megfelelő {@code Babu}-kat.
     * 
     */
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
    
    /**
     * Beállítja a megadott {@code ImageView} {@code Image}-t a WP vagy BP képre,
     * a megadott {@code szin}-től függően.
     * 
     * @param iv egy {@code ImageView} amit beállít.
     * @param szin egy szín.
     * @return egy {@code ImageView}, aminek az {@code Image} be van állítva a 
     * megfelelő képre.
     */
    public ImageView setParaszt(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WP.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BP.png"));
        iv.setImage(img);
        return iv;
    }
    
    /**
     * Beállítja a megadott {@code ImageView} {@code Image}-t a WB vagy BB képre,
     * a megadott {@code szin}-től függően.
     * 
     * @param iv egy {@code ImageView} amit beállít.
     * @param szin egy szín.
     * @return egy {@code ImageView}, aminek az {@code Image} be van állítva a 
     * megfelelő képre.
     */
    public ImageView setBastya(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WB.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BB.png"));
        iv.setImage(img);
        return iv;
    }
    
    /**
     * Beállítja a megadott {@code ImageView} {@code Image}-t a WL vagy BL képre,
     * a megadott {@code szin}-től függően.
     * 
     * @param iv egy {@code ImageView} amit beállít.
     * @param szin egy szín.
     * @return egy {@code ImageView}, aminek az {@code Image} be van állítva a 
     * megfelelő képre.
     */
    public ImageView setLo(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WL.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BL.png"));
        iv.setImage(img);
        return iv;
    }
    
    /**
     * Beállítja a megadott {@code ImageView} {@code Image}-t a WF vagy BF képre,
     * a megadott {@code szin}-től függően.
     * 
     * @param iv egy {@code ImageView} amit beállít.
     * @param szin egy szín.
     * @return egy {@code ImageView}, aminek az {@code Image} be van állítva a 
     * megfelelő képre.
     */
    public ImageView setFuto(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WF.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BF.png"));
        iv.setImage(img);
        return iv;
    }
    
    /**
     * Beállítja a megadott {@code ImageView} {@code Image}-t a WK vagy BK képre,
     * a megadott {@code szin}-től függően.
     * 
     * @param iv egy {@code ImageView} amit beállít.
     * @param szin egy szín.
     * @return egy {@code ImageView}, aminek az {@code Image} be van állítva a 
     * megfelelő képre.
     */
    public ImageView setKiraly(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WK.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BK.png"));
        iv.setImage(img);
        return iv;
    }
    
    /**
     * Beállítja a megadott {@code ImageView} {@code Image}-t a WQ vagy BQ képre,
     * a megadott {@code szin}-től függően.
     * 
     * @param iv egy {@code ImageView} amit beállít.
     * @param szin egy szín.
     * @return egy {@code ImageView}, aminek az {@code Image} be van állítva a 
     * megfelelő képre.
     */
    public ImageView setKiralyno(ImageView iv, String szin) {
        Image img;
        if(szin.equals("W"))
            img = new Image(ClassLoader.getSystemResourceAsStream("img/WQ.png"));
        else
            img = new Image(ClassLoader.getSystemResourceAsStream("img/BQ.png"));
        iv.setImage(img);
        return iv;
    }
    
    /**
     * Ellenőrzi, hogy a megadott sorban és oszlopban szereplő mező azé a játékosé,
     * aki következik.
     * 
     * @param sor egy sor index.
     * @param oszlop egy oszlop index.
     * @return Ha nem üres a megadott sorban és oszlopban levő mező, és olyan színű
     * bábú van a mezőn, amilyen színű játékos következik, akkor igazat térít vissza,
     * különben hamisat.
     */
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
     
    /**
     * Ellenőrzi, hogy a megadott lépést el lehet e végezni.
     * 
     * @param i amelyik sorból lépünk a bábúval.
     * @param j amelyik oszlopból lépünk a bábúval.
     * @param x amelyik sorba lépünk a bábúval.
     * @param y amelyik oszlopba lépünk a bábúval.
     * @return ha jó lépés van akkor igazat térít vissza, különben hamisat.
     */
    public int lepesEllenorzese(int i, int j, int x, int y) {
        Tabla t = new Tabla();
        
        return t.getMezo(i, j).getBabu().lepes(i, j, x, y);
    }
    
    /**
     * A megkapott {@code ImageView} {@code Image}-t állítja be és téríti vissza.
     * 
     * @param mire egy {@code ImageView} amire szeretnénk cserélni a régi imageview-t.
     * @return egy {@code ImageView} aminek az {@code Image} a megkapott {@code mire}
     * {@code Image}-t tartalmazza.
     */
    public ImageView imgCsere(ImageView mire) {
        ImageView iv = new ImageView();
        iv.setImage(mire.getImage());
        return iv;
    }
    
    /**
     * Üres {@code ImageView} készít.
     * 
     * @return egy üres {@code ImageView} add vissza.
     */
    public ImageView setUres() {
        ImageView iv = new ImageView();
        return iv;
    }

    /**
     * Ellenőrzi, hogy vége van e a játéknak. Ha {@code Kiraly} bábú szerepel
     * azon a pozíción, ahova lépni fog egy játékos, akkor a játéknak vége.
     * 
     * @param x az a sor ahova a játékos lépni akar.
     * @param y az az oszlop ahova a játékos lépni akar.
     * @return ha egy király van ahova lépni akar a játékos, akkor igazat térit vissza,
     * különben hamisat.
     */
    public boolean vegeVan(int x, int y) { 
        Tabla t = new Tabla();
        
        return t.getMezo(x, y).getBabu() != null && t.getMezo(x, y).getBabu().getTipus().equals("K");    
    } 
    
    /**
     * Beállítja a {@code jatekos1} vagy a {@code jatekos2} {@code nyert} változóját
     * igazra, amennyiben azon a pozíción ahova lépni akar egy játékos, ott {@code Kiraly}
     * bábú van.
     * 
     * @param x az a sor ahova a játékos lépni akar.
     * @param y az az oszlop ahova a játékos lépni akar.
     */
    public void kiNyert(int x, int y) {
        Tabla t = new Tabla();
        if(t.getMezo(x, y).getBabu() != null && t.getMezo(x, y).getBabu().getTipus().equals("K")) {
            if(t.getMezo(x, y).getBabu().getSzin().equals("W"))
                jatekos2.setNyert(true);
            else
                jatekos1.setNyert(true);
        }
    }
    
    /**
     * Kiszámolja a nyert játékos pontszámát, majd frissíti. A nyerő játékos pontszáma
     * vagy 2-vel nő, ez akkor történik meg, ha az ellenfél pontszáma kisebb volt mint a
     * nyerő játékos pontszáma, vagy 5-tel nő. ez akkor történik meg, ha az ellenfél 
     * pontszáma nagyobb vagy egyenlő a nyerő játékos pontszámánál.
     * 
     * @throws TransformerException kivételt dob, transzformációs hiba esetén.
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     */
    public void pontokFrissitese() throws TransformerException, ParserConfigurationException, SAXException, IOException {
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
        
        logger.info("Nyerő játékos pontszáma frissítve.");
        
            if(jatekos1.getNyert())
                feldolgozo.felhasznaloFrisites(jatekos1);
            if(jatekos2.getNyert())
                feldolgozo.felhasznaloFrisites(jatekos2);
        
    }
}
