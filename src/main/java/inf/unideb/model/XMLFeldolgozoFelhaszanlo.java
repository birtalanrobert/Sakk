/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Birtalan
 */
public class XMLFeldolgozoFelhaszanlo {
    
    
    public XMLFeldolgozoFelhaszanlo() {
    }
    
    private static final Logger logger = LoggerFactory.getLogger(XMLFeldolgozoFelhaszanlo.class);
    
    public List<Felhasznalo> getFelhasznalok() {
        try {
            List<Felhasznalo> felhasznalok = new ArrayList<>();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           // Document doc = dBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/felhasznalok.xml"));
            Document doc = dBuilder.parse("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat

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
        catch(ParserConfigurationException | SAXException | IOException | DOMException | NumberFormatException e) {
            logger.warn("Nincs egy felhasználó sem az adatbázisban.");
            return new ArrayList<Felhasznalo>();
            
        }
    }
    
    public void addFelhasznalo(Felhasznalo felhasznalo) throws TransformerException {
         try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
        
            Document doc = dBuilder.parse("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
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
            File f = new File("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
            StreamResult result = new StreamResult(f);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            logger.warn("Kivétel keletkezett a felhasználó hozzáadásakor.");
        }
    }
    
    public void felhasznaloFrisites(Jatekos j) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        Felhasznalo felhasznalo = feldolgozo.felhasznaloTorles(j);
                
                try {
                    addFelhasznalo(new Felhasznalo(felhasznalo.getFelhasznalonev(), felhasznalo.getJelszo(), j.getPont()));
                } catch (TransformerException ex) {
                    logger.warn("Kivétel keletkezett a felhasználó hozzáadásakor.");
                }
                
    }

    public Felhasznalo felhasznaloTorles(Jatekos j) throws ParserConfigurationException, 
            SAXException, IOException, TransformerConfigurationException, TransformerException {
        Felhasznalo jatekos = new Felhasznalo("", "", 0);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
        
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
                File f = new File("src/main/resources/xml/felhasznalok.xml");//kiszedni az utvonalat
                StreamResult result = new StreamResult(f);

                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformer.transform(source, result);
            }
        }
        return jatekos;
    }
}
