package inf.unideb.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.IOException;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Az XML fájl feldolgozását reprezentáló osztály.
 * 
 * @author Birtalan
 */
public class XMLFeldolgozoFelhaszanlo {
    
    private static final Logger logger = LoggerFactory.getLogger(XMLFeldolgozoFelhaszanlo.class);
    
    /**
     * Az XML fájlban szereplő összes felhasználót kiolvassa egy {@code List<Felhasznalo>}
     * listába, majd rendezi őket csökkenő sorrendbe a ponsztámuk szerint.
     * 
     * @return egy {@code List<Felhasznalo>} listát térit vissza.     
     * 
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     * @throws DOMException kivételt dob, elvégezhetetlen DOM műveleti hiba esetén.
     * @throws NumberFormatException kivételt dob, Stringről intre való átalakítási hiba esetén.
     */
    public List<Felhasznalo> getFelhasznalok() throws ParserConfigurationException, SAXException, IOException {
            List<Felhasznalo> felhasznalok = new ArrayList<>();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Document doc = dBuilder.parse("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
            Document doc = dBuilder.parse("felhasznalok.xml");

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("felhasznalo");

            for (int i = 0; i < nList.getLength(); i++) {
                Element eElement = (Element) nList.item(i);

                felhasznalok.add(new Felhasznalo(
                        eElement.getElementsByTagName("felhasznalonev").item(0).getTextContent(),
                        eElement.getElementsByTagName("jelszo").item(0).getTextContent(),
                        Integer.parseInt(eElement.getElementsByTagName("pont").item(0).getTextContent())));
            }

            
            Collections.sort(felhasznalok, Felhasznalo.felhasznaloRendezo);
            
            return felhasznalok;
    }
    
    /**
     * A megkapott {@code Felhasznalo}-t hozzáadja az XML fájl felhasználóihoz.
     * 
     * @param felhasznalo a hozzáadni kívánt felhasználónév.
     * 
     * @throws TransformerException kivételt dob, transzformációs hiba esetén.
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     */
    public void addFelhasznalo(Felhasznalo felhasznalo) throws TransformerException, ParserConfigurationException, SAXException, IOException {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
        
            //Document doc = dBuilder.parse("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
            Document doc = dBuilder.parse("felhasznalok.xml");
            Element gyoker = doc.getDocumentElement();
            Element ujFelhasznalo = doc.createElement("felhasznalo");
            
            Element ujFelhasznalonev = doc.createElement("felhasznalonev");
            ujFelhasznalonev.setTextContent(felhasznalo.getFelhasznalonev());
            ujFelhasznalo.appendChild(ujFelhasznalonev);
            
            Element ujJelszo = doc.createElement("jelszo");
            ujJelszo.setTextContent(felhasznalo.getJelszo());
            ujFelhasznalo.appendChild(ujJelszo);
            
            Element ujPont = doc.createElement("pont");
            ujPont.setTextContent(Integer.toString(felhasznalo.getPont()));
            ujFelhasznalo.appendChild(ujPont);
            
            gyoker.appendChild(ujFelhasznalo);
            
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            //File f = new File("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
            File f = new File("felhasznalok.xml");
            StreamResult result = new StreamResult(f);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);
            
    }
    
    /**
     * A megkapott {@code Jatekos} felhasználónevét és pontszámát felhasználva,
     * kitörli az XML fájlból azt a felhasználót amelyiknek a felhasználóneve
     * megeggyezik a megadott játékos felhasználónevével. Majd hozzáadja a 
     * kitörölt felhasználót, úgy, hogy a pontszámát már frissítve tölti fel.
     * 
     * @param j a frissíteni kívánt játékos.
     * 
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     * @throws TransformerConfigurationException transzformáció konfigurácíós hiba esetén.
     * @throws TransformerException kivételt dob, transzformácíós hiba esetén.
     */
    public void felhasznaloFrisites(Jatekos j) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        Felhasznalo felhasznalo = feldolgozo.felhasznaloTorles(j);
                
        addFelhasznalo(new Felhasznalo(felhasznalo.getFelhasznalonev(), felhasznalo.getJelszo(), j.getPont()));
                
    }

    /**
     * A megkapott {@code Jatekos}-t felhasználva törli a felhasználók közül
     * azt, amelyiknek a felhasználóneve megeggyezik a játékos felhasználónevével.
     * 
     * @param j törölni kívánt játékos.
     * @return egy felhasználót, amelyiket kitöröltük a felhasználók közül.
     * 
     * @throws javax.xml.parsers.ParserConfigurationException kivételt dob,
     * konfigurációs hoba esetén.
     * @throws org.xml.sax.SAXException kivételt dob, XML feldolgozás esetén.
     * @throws java.io.IOException kivételt dob, input/output hiba esetén.
     * @throws TransformerConfigurationException transzformáció konfigurácíós hiba esetén.
     * @throws TransformerException kivételt dob, transzformácíós hiba esetén.
     */
    public Felhasznalo felhasznaloTorles(Jatekos j) throws ParserConfigurationException, 
            SAXException, IOException, TransformerConfigurationException, TransformerException {
        Felhasznalo jatekos = new Felhasznalo("", "", 0);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        //Document doc = dBuilder.parse("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
        Document doc = dBuilder.parse("felhasznalok.xml");
        
        NodeList nodes = doc.getElementsByTagName("felhasznalo");

        for (int i = 0; i < nodes.getLength(); i++) {
            Element felhasznalo = (Element)nodes.item(i);
            Element felhasznalonev = (Element)felhasznalo.getElementsByTagName("felhasznalonev").item(0);
            String felhasznalonevTartalom = felhasznalonev.getTextContent();
            Element jelszo = (Element)felhasznalo.getElementsByTagName("jelszo").item(0);
            String jelszoTartalom = jelszo.getTextContent();
            
            if (felhasznalonevTartalom.equals(j.getFelhasznalonev())) {
                felhasznalo.getParentNode().removeChild(felhasznalo);
                jatekos = new Felhasznalo(felhasznalonevTartalom, jelszoTartalom, 0);
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                //File f = new File("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
                File f = new File("felhasznalok.xml");
                StreamResult result = new StreamResult(f);

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.transform(source, result);
            }
        }
        return jatekos;
    }
}
