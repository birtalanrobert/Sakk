package inf.unideb.controller;

import inf.unideb.model.Felhasznalo;
import inf.unideb.model.TopLista;
import inf.unideb.model.XMLFeldolgozoFelhaszanlo;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class ToplistaController implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(ToplistaController.class);
    
    @FXML
    private TableView tableView;
    @FXML
    private Button kilepes;
    
    @FXML
    public void  kilepesKezeles() {
        logger.info("Kilépés az alkalmazásból.");
        Platform.exit();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
            int hely = 1;
            for(Felhasznalo f : feldolgozo.getFelhasznalok()) {
                tableView.getItems().add(new TopLista(hely,f.getFelhasznalonev(),f.getPont()));
                hely++;
            }
            logger.info("Toplista kilistázása.");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            java.util.logging.Logger.getLogger(ToplistaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
