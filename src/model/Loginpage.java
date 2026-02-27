package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Loginpage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Chargement du fichier FXML
        Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
        
        // Création de la scène
        Scene scene = new Scene(root);
        
        // Application de la feuille de style CSS
        scene.getStylesheets().add(getClass().getResource("/view/login.css").toExternalForm());
        
        // Configuration de la fenêtre
        stage.setTitle("Page de Connexion");
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args); // Lance l'application JavaFX
    }
}
