package inf.unideb.controller;

import inf.unideb.model.Felhasznalo;
import inf.unideb.model.TopLista;
import inf.unideb.model.XMLFeldolgozoFelhaszanlo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        int hely = 1;
        for(Felhasznalo f : feldolgozo.getFelhasznalok()) {
            tableView.getItems().add(new TopLista(hely,f.getFelhasznalonev(),f.getPont()));
            hely++;
        }
        logger.info("Toplista kilistázása.");
    }    
    
}
