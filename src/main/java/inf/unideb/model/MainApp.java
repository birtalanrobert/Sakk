package inf.unideb.model;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Sakk applikáció main() metódusát tartalmazó osztály.
 * @author Birtalan
 */
public class MainApp extends Application {

    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
    
    /**
    *Az applikáció {@code start()} metódusa.
    *
    * @param stage Stage objektum.
    * @throws java.lang.Exception kivételt dob, betöltési hiba esetén.
    */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Bejelentkezes.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        
        logger.info("A program elindult.");
    }

     /**
    *Az applikáció {@code main()} metódusa.
    *
    *@param args parancssori argumentumok.
    */
    public static void main(String[] args) {
        launch(args);
    }
}
