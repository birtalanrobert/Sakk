/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.controller;


import inf.unideb.model.JatekKezelo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Birtalan
 */
public class JatekController implements Initializable{
    
    private static final Logger logger = LoggerFactory.getLogger(JatekController.class);
    
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Button feladas1;
    @FXML
    private Button feladas2;
    @FXML
    private GridPane gridPane;
    @FXML
    private ImageView iv00;
    @FXML
    private ImageView iv01;
    @FXML
    private ImageView iv02;
    @FXML
    private ImageView iv03;
    @FXML
    private ImageView iv04;
    @FXML
    private ImageView iv05;
    @FXML
    private ImageView iv06;
    @FXML
    private ImageView iv07;
    @FXML
    private ImageView iv10;
    @FXML
    private ImageView iv11;
    @FXML
    private ImageView iv12;
    @FXML
    private ImageView iv13;
    @FXML
    private ImageView iv14;
    @FXML
    private ImageView iv15;
    @FXML
    private ImageView iv16;
    @FXML
    private ImageView iv17;
    @FXML
    private ImageView iv20;
    @FXML
    private ImageView iv21;
    @FXML
    private ImageView iv22;
    @FXML
    private ImageView iv23;
    @FXML
    private ImageView iv24;
    @FXML
    private ImageView iv25;
    @FXML
    private ImageView iv26;
    @FXML
    private ImageView iv27;
    @FXML
    private ImageView iv30;
    @FXML
    private ImageView iv31;
    @FXML
    private ImageView iv32;
    @FXML
    private ImageView iv33;
    @FXML
    private ImageView iv34;
    @FXML
    private ImageView iv35;
    @FXML
    private ImageView iv36;
    @FXML
    private ImageView iv37;
    @FXML
    private ImageView iv40;
    @FXML
    private ImageView iv41;
    @FXML
    private ImageView iv42;
    @FXML
    private ImageView iv43;
    @FXML
    private ImageView iv44;
    @FXML
    private ImageView iv45;
    @FXML
    private ImageView iv46;
    @FXML
    private ImageView iv47;
    @FXML
    private ImageView iv50;
    @FXML
    private ImageView iv51;
    @FXML
    private ImageView iv52;
    @FXML
    private ImageView iv53;
    @FXML
    private ImageView iv54;
    @FXML
    private ImageView iv55;
    @FXML
    private ImageView iv56;
    @FXML
    private ImageView iv57;
    @FXML
    private ImageView iv60;
    @FXML
    private ImageView iv61;
    @FXML
    private ImageView iv62;
    @FXML
    private ImageView iv63;
    @FXML
    private ImageView iv64;
    @FXML
    private ImageView iv65;
    @FXML
    private ImageView iv66;
    @FXML
    private ImageView iv67;
    @FXML
    private ImageView iv70;
    @FXML
    private ImageView iv71;
    @FXML
    private ImageView iv72;
    @FXML
    private ImageView iv73;
    @FXML
    private ImageView iv74;
    @FXML
    private ImageView iv75;
    @FXML
    private ImageView iv76;
    @FXML
    private ImageView iv77;
    
    @FXML
    private void feladasGomb1(ActionEvent event) throws IOException, TransformerException {
        JatekKezelo j = new JatekKezelo();
        j.getJatekos2().setNyert(true);
        j.pontokFrissitese();
        
        logger.info("Első játékos feladta.");
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Vége a játéknak!");
        alert.setHeaderText(null);
        alert.setContentText("Nyert: " + j.getJatekos2().getFelhasznalonev());

        alert.showAndWait();
        
        
        Stage stage;
        Parent root;

        stage = (Stage) feladas1.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Toplista.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.show(); 
        
        logger.info("Irány a toplistához.");
    }
    
    @FXML
    private void feladasGomb2(ActionEvent event) throws IOException, TransformerException {
        JatekKezelo j = new JatekKezelo();
        j.getJatekos1().setNyert(true);
        j.pontokFrissitese();
        
        logger.info("Második játékos feladta.");
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Vége a játéknak!");
        alert.setHeaderText(null);
        alert.setContentText("Nyert: " + j.getJatekos1().getFelhasznalonev());

        alert.showAndWait();
        
        Stage stage;
        Parent root;

        stage = (Stage) feladas1.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Toplista.fxml"));
        root = loader.load();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.show();
        
        logger.info("Irány a toplistához.");
    }
    
    
    public void kivalasztottMezo(MouseEvent e) {
        JatekKezelo jatekKezelo = new JatekKezelo();
         for( Node node: gridPane.getChildren()) {
            if( node instanceof ImageView) {
                  if(node.getBoundsInParent().contains(e.getX(), e.getY())) {
                   if(jatekKezelo.joBabuVoltValasztva(GridPane.getRowIndex(node), GridPane.getColumnIndex(node))) {
                        jatekKezelo.setKoordI(GridPane.getRowIndex(node));
                        jatekKezelo.setKoordJ(GridPane.getColumnIndex(node));
                        jatekKezelo.setNode(node);
                        
                        logger.info("Megfelelő szinű bábut tartalmazó mező volt választva.");
                    }
                    else {
                        jatekKezelo.setKoordI(-1);
                        jatekKezelo.setKoordJ(-1);
                        
                        logger.info("Nem megfelelő szinű bábut tartalmazó mező volt választva.");
                    }
                }
            }
        }
    }
    
    public void elengedettMezo(MouseEvent e) throws IOException, TransformerException {
        JatekKezelo jatekKezelo = new JatekKezelo();
        boolean vegeVan;
        for( Node node: gridPane.getChildren()) {
            if( node instanceof ImageView) {
                  if(node.getBoundsInParent().contains(e.getX(), e.getY())) {
                    if(jatekKezelo.getKoordI() != -1 && jatekKezelo.getKoordJ() != -1) {
                        vegeVan = jatekKezelo.vegeVan(GridPane.getRowIndex(node),GridPane.getColumnIndex(node));
                        if(vegeVan) {
                            jatekKezelo.kiNyert(GridPane.getRowIndex(node), GridPane.getColumnIndex(node));
                            logger.info("Játéknak vége, nyerő játékos beállítva.");
                        }
                        int lepes = jatekKezelo.lepesEllenorzese(
                                     jatekKezelo.getKoordI(), jatekKezelo.getKoordJ(), 
                                     GridPane.getRowIndex(node), GridPane.getColumnIndex(node));  
                        
                        if(lepes == 1) {    
                               ((ImageView)node).setImage(((ImageView)jatekKezelo.getNode()).getImage());
                               ((ImageView)jatekKezelo.getNode()).setImage(jatekKezelo.setUres().getImage());
                               jatekKezelo.lepesekSzamaNoveles();
                               
                               logger.info("Helyes sima lépés meglépve.");
                        }
                        if(lepes == 2) {
                            ((ImageView)node).setImage(((ImageView)jatekKezelo.getNode()).getImage());
                            ((ImageView)jatekKezelo.getNode()).setImage(jatekKezelo.setUres().getImage());
                            if(jatekKezelo.getKoordJ() - GridPane.getColumnIndex(node) == 2) {//bal
                                if(jatekKezelo.getLepesekSzama() % 2 == 0) { //feher
                                    iv73.setImage(jatekKezelo.imgCsere(iv70).getImage());
                                    iv70.setImage(jatekKezelo.setUres().getImage());
                                }
                                else { //fekete
                                    iv03.setImage(jatekKezelo.imgCsere(iv00).getImage());
                                    iv00.setImage(jatekKezelo.setUres().getImage());
                                }
                            }
                            if(jatekKezelo.getKoordJ() - GridPane.getColumnIndex(node) == -2) {//jobb
                                if(jatekKezelo.getLepesekSzama() % 2 == 0) { //feher
                                    iv75.setImage(jatekKezelo.imgCsere(iv77).getImage());
                                    iv77.setImage(jatekKezelo.setUres().getImage());
                                }
                                else { //fekete
                                    iv05.setImage(jatekKezelo.imgCsere(iv07).getImage());
                                    iv07.setImage(jatekKezelo.setUres().getImage());
                                }
                            }
                            jatekKezelo.lepesekSzamaNoveles();
                            logger.info("Helyes rosáló lépés meglépve.");
                        }
                        if(lepes == 3) {
                            if(jatekKezelo.getLepesekSzama() % 2 == 0)
                                ((ImageView)node).setImage(jatekKezelo.setKiralyno(new ImageView(), "W").getImage());
                            else
                                ((ImageView)node).setImage(jatekKezelo.setKiralyno(new ImageView(), "B").getImage());
                            ((ImageView)jatekKezelo.getNode()).setImage(jatekKezelo.setUres().getImage());
                            jatekKezelo.lepesekSzamaNoveles();
                            logger.info("Helyes paraszt speciális lépés meglépve.");
                        }
                        if(lepes != 0 && vegeVan) {
                            
                            jatekKezelo.pontokFrissitese();
                            
                            logger.info("Vége a játéknak, nyerő játékos pontszáma frissítve.");
                            
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Vége a játéknak!");
                            alert.setHeaderText(null);
                            if(jatekKezelo.getJatekos1().getNyert())
                                alert.setContentText("Nyert: " + jatekKezelo.getJatekos1().getFelhasznalonev());
                            if(jatekKezelo.getJatekos2().getNyert())
                                alert.setContentText("Nyert: " + jatekKezelo.getJatekos2().getFelhasznalonev());

                            alert.showAndWait();

                            
                            Stage stage;
                            Parent root;

                            stage = (Stage) feladas1.getScene().getWindow();

                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Toplista.fxml"));
                            root = loader.load();

                            Scene scene = new Scene(root);
                            scene.getStylesheets().add("/styles/Styles.css");
                            stage.setScene(scene);
                            stage.show(); 
                            
                            logger.info("Ugrás a toplistára.");
                        }
                        
                        if(jatekKezelo.getLepesekSzama() % 2 == 0) {
                            label3.setText("Fehér játékos következik!");
                            logger.info("Fehér játékos következik.");
                        }
                        else {
                            label3.setText("Fekete játékos következik!");
                            logger.info("Fekete játékos következik.");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JatekKezelo jatekosok = new JatekKezelo();
        label1.setText(jatekosok.getJatekos1().getFelhasznalonev() 
                + " - pont: " + jatekosok.getJatekos1().getPont());
        label2.setText(jatekosok.getJatekos2().getFelhasznalonev() 
                + " - pont: " + jatekosok.getJatekos2().getPont());
        label3.setText("Fehér játékos következik!");
        
        jatekosok.tablaInicializalas();
        logger.info("Tábla inicializálása.");
        
        iv00 = jatekosok.setBastya(iv00,jatekosok.getJatekos2().getSzin());
        iv01 = jatekosok.setLo(iv01,jatekosok.getJatekos2().getSzin());
        iv02 = jatekosok.setFuto(iv02,jatekosok.getJatekos2().getSzin());
        iv03 = jatekosok.setKiralyno(iv03,jatekosok.getJatekos2().getSzin());
        iv04 = jatekosok.setKiraly(iv04,jatekosok.getJatekos2().getSzin());
        iv05 = jatekosok.setFuto(iv05,jatekosok.getJatekos2().getSzin());
        iv06 = jatekosok.setLo(iv06,jatekosok.getJatekos2().getSzin());
        iv07 = jatekosok.setBastya(iv07,jatekosok.getJatekos2().getSzin());
        iv10 = jatekosok.setParaszt(iv10,jatekosok.getJatekos2().getSzin());
        iv11 = jatekosok.setParaszt(iv11,jatekosok.getJatekos2().getSzin());
        iv12 = jatekosok.setParaszt(iv12,jatekosok.getJatekos2().getSzin());
        iv13 = jatekosok.setParaszt(iv13,jatekosok.getJatekos2().getSzin());
        iv14 = jatekosok.setParaszt(iv14,jatekosok.getJatekos2().getSzin());
        iv15 = jatekosok.setParaszt(iv15,jatekosok.getJatekos2().getSzin());
        iv16 = jatekosok.setParaszt(iv16,jatekosok.getJatekos2().getSzin());
        iv17 = jatekosok.setParaszt(iv17,jatekosok.getJatekos2().getSzin());
        
        iv60 = jatekosok.setParaszt(iv60,jatekosok.getJatekos1().getSzin());
        iv61 = jatekosok.setParaszt(iv61,jatekosok.getJatekos1().getSzin());
        iv62 = jatekosok.setParaszt(iv62,jatekosok.getJatekos1().getSzin());
        iv63 = jatekosok.setParaszt(iv63,jatekosok.getJatekos1().getSzin());
        iv64 = jatekosok.setParaszt(iv64,jatekosok.getJatekos1().getSzin());
        iv65 = jatekosok.setParaszt(iv65,jatekosok.getJatekos1().getSzin());
        iv66 = jatekosok.setParaszt(iv66,jatekosok.getJatekos1().getSzin());
        iv67 = jatekosok.setParaszt(iv67,jatekosok.getJatekos1().getSzin());
        iv70 = jatekosok.setBastya(iv70,jatekosok.getJatekos1().getSzin());
        iv71 = jatekosok.setLo(iv71,jatekosok.getJatekos1().getSzin());
        iv72 = jatekosok.setFuto(iv72,jatekosok.getJatekos1().getSzin());
        iv73 = jatekosok.setKiralyno(iv73,jatekosok.getJatekos1().getSzin());
        iv74 = jatekosok.setKiraly(iv74,jatekosok.getJatekos1().getSzin());
        iv75 = jatekosok.setFuto(iv75,jatekosok.getJatekos1().getSzin());
        iv76 = jatekosok.setLo(iv76,jatekosok.getJatekos1().getSzin());
        iv77 = jatekosok.setBastya(iv77,jatekosok.getJatekos1().getSzin());
        
        logger.info("Megfelelő képek beállítása a megfelelő ImageViewhoz.");
    }    
}
