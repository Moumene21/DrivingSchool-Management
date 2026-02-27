package controller;

import model.database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button loginButton;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Ajouter un gestionnaire d'événements pour le bouton de connexion
        loginButton.setOnAction(event -> {
            try {
                handleLoginButton();
            } catch (IOException e) {
                showErrorAlert("An error occurred: " + e.getMessage());
            }
        });
    }

    public void handleLoginButton() throws IOException {
        if (usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
            showErrorAlert("Please fill all blank fields.");
            return;
        }

        String sql = "SELECT * FROM utilisateurs WHERE nom_utilisateur = ? AND mot_de_passe = ?";
        try {
            connect = database.connectDb();
            if (connect == null) {
                showErrorAlert("Database connection failed.");
                return;
            }

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, usernameField.getText());
            prepare.setString(2, passwordField.getText());

            result = prepare.executeQuery();

            if (result.next()) {
                String role = result.getString("role");
                String username = usernameField.getText();
                showInfoAlert("Successfully logged in as " + role + ": " + username);
                loginButton.getScene().getWindow().hide();
                loadDashboard(role);
            } else {
                showErrorAlert("Invalid username or password.");
            }
        } catch (SQLException e) {
            showErrorAlert("Database error. SQLState: " + e.getSQLState() + "\nMessage: " + e.getMessage());
        } finally {
            closeResources();
        }
    }

    private void loadDashboard(String role) throws IOException {
    String fxmlPath;

    switch (role.toLowerCase()) {
        case "admin":
            fxmlPath = "/view/admin_dashboard.fxml";
            break;
        case "moniteur":
            fxmlPath = "/view/moniteur_dashboard.fxml";
            break;
        case "secretaire":
            fxmlPath = "/view/secretaire_dashboard.fxml";
            break;
        default:
            showErrorAlert("Unknown role: Access denied.");
            return;
    }

    // Utilisation de FXMLLoader avec un contrôle explicite
    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
    Parent root = loader.load(); // Charge le fichier FXML
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
}


    private void closeResources() {
        try {
            if (result != null) result.close();
            if (prepare != null) prepare.close();
            if (connect != null) connect.close();
        } catch (SQLException e) {
            System.err.println("Failed to close resources: " + e.getMessage());
        }
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInfoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
