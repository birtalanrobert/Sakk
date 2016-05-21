/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.controller;

import inf.unideb.model.Felhasznalo;
import inf.unideb.model.RegisztracioKezeles;
import inf.unideb.model.XMLFeldolgozoFelhaszanlo;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Birtalan
 */
public class RegisztracioController {
    private static final Logger logger = LoggerFactory.getLogger(RegisztracioController.class);

    @FXML
    private TextField textField1;
    @FXML
    private PasswordField textField2;
    @FXML
    private PasswordField textField3;
    @FXML
    private Button vissza;
    @FXML
    private Button regisztracio;
    @FXML
    private Label label;
    
    @FXML
    private void visszaGomb(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) vissza.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Bejelentkezes.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.show(); 
        
        logger.info("Vissza a bejelentkezéshez.");
    }
    
    @FXML
    private void regisztracioGomb(ActionEvent event) throws IOException, TransformerException {
        String felhasznalonev = textField1.getText();
        String jelszo1 = textField2.getText();
        String jelszo2 = textField3.getText();
        RegisztracioKezeles regKezeles = new RegisztracioKezeles();
        XMLFeldolgozoFelhaszanlo feldolgozo = new XMLFeldolgozoFelhaszanlo();
        
        
        if(jelszo1.equals(jelszo2)) {
            if(regKezeles.uresMezo(felhasznalonev) && regKezeles.uresMezo(jelszo1)) {
                Felhasznalo felhasznalo = new Felhasznalo(felhasznalonev, jelszo1, 0);
                if(regKezeles.regisztracioEllenorzes(felhasznalo)) {
                    feldolgozo.addFelhasznalo(felhasznalo);
                    logger.info("Új felhasználó hozzáadva az adatbázishoz.");
                    
                    Stage stage;
                    Parent root;

                    stage = (Stage) regisztracio.getScene().getWindow();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Bejelentkezes.fxml"));
                    root = loader.load();

                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("/styles/Styles.css");
                    stage.setScene(scene);
                    stage.show(); 
                    
                    logger.info("Tovább a bejelentkezéshez.");
                }
                else {
                    label.setText("Felhasználónév már szerepel!");
                    logger.info("A felhasználónév már szerepel az adatbázisban.");
                }
            }
            else {
                label.setText("Üresen maradt a felhasználónév vagy a jelszó!");
                logger.info("Üresen maradt a felhasználónév vagy a jelszó mező.");
            }
        }
        else {
            label.setText("Nem egyezzik meg a két jelszó!");
            logger.info("Nem egyezzik a két jelszó mező.");
        }
    }
}
