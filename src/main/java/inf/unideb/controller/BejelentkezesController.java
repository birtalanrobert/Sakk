/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.controller;

import inf.unideb.model.BejelentkezesKezeles;
import inf.unideb.model.JatekKezelo;
import inf.unideb.model.Jatekos;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Birtalan
 */
public class BejelentkezesController {
    
    private static final Logger logger = LoggerFactory.getLogger(BejelentkezesController.class);
    
    @FXML
    private TextField textField1;
    @FXML
    private PasswordField textField2;
    @FXML
    private Button belepes;
    @FXML
    private Button regisztracio;
    @FXML
    private Label label;
    
    @FXML
    private void belepesGomb(ActionEvent event) throws IOException {
        String felhasznalonev = textField1.getText();
        String jelszo = textField2.getText();
        boolean ok = false;
        JatekKezelo belepoJatekos = new JatekKezelo();
        
        BejelentkezesKezeles bejelentkezes = new BejelentkezesKezeles();
        if(bejelentkezes.uresMezo(felhasznalonev) && bejelentkezes.uresMezo(jelszo))
            if(bejelentkezes.felhasznaloEgyezes(felhasznalonev, jelszo)) {
                if(belepoJatekos.getJatekos1() == null || 
                        (belepoJatekos.getJatekos1() != null && belepoJatekos.getJatekos2() == null &&
                        !belepoJatekos.getJatekos1().getFelhasznalonev().equals(felhasznalonev))) {
                    ok = true;
                    String szin;
                    if(bejelentkezes.belepettJatekosok() == 0)
                        szin = "W";
                    else 
                        szin = "B";

                    Jatekos j = new Jatekos(felhasznalonev, bejelentkezes.getPontszam(), szin, false);
                    if(belepoJatekos.getJatekos1() == null) {
                        belepoJatekos.setJatekos1(j);
                        logger.info("Első játékos sikeres belépése.");
                    }
                    else {
                        belepoJatekos.setJatekos2(j); 
                        logger.info("Második játékos sikeres belépése.");
                    }
                    bejelentkezes.belepettJatekosokNovelese();
                }
                else {
                    label.setText("Ez a felhasználónév már belépett!");
                    logger.info("A megadott felhasználónév már bejelentkezett.");
                }
            }
            else {
                label.setText("Nem jó felhasználónév vagy jelszó!");
                logger.info("Nem jó felhasználónév vagy jelszó.");
            }
        if(ok) {
            if(bejelentkezes.belepettJatekosok() == 2) {
                Stage stage;
                Parent root;

                stage = (Stage) belepes.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Tabla.fxml"));
                root = loader.load();

                Scene scene = new Scene(root);
                scene.getStylesheets().add("/styles/Styles.css");
                stage.setScene(scene);
                stage.show();
                
                logger.info("Mindkét játékos bejelentkezett. Indul a játék.");
            }
            else {
                Stage stage;
                Parent root;

                stage = (Stage) belepes.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Bejelentkezes.fxml"));
                root = loader.load();

                Scene scene = new Scene(root);
                scene.getStylesheets().add("/styles/Styles.css");
                stage.setScene(scene);
                stage.show();
                
            }
        }
    }
    
    @FXML
    private void regisztracioGomb(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        
        stage = (Stage) regisztracio.getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Regisztracio.fxml"));
        root = loader.load();
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.show();
        
        logger.info("Regisztráció ablak megnyítása.");
    }
}

