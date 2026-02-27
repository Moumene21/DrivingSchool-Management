package controller;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Resultat;
import model.database;
public class Moniteur_dashboardController implements Initializable {
    @FXML
    private Button close;
    @FXML
    private Button logout;
    @FXML
    private AnchorPane main_form;
    @FXML
    private Button minimize;
    @FXML
    private TableColumn<Resultat, Integer> moniteur_col_id;
    @FXML
    private TableColumn<Resultat, String> moniteur_col_candidat1;
    @FXML
    private TableColumn<Resultat, String> moniteur_col_examen;
    @FXML
    private TableColumn<Resultat, String> moniteur_col_resultat;
    @FXML
    private TableView<Resultat> moniteur_table_resultat;
    @FXML
    private Button resultats_btn;
    @FXML
    private Button seances_btn;
    @FXML
    private AnchorPane moniteur_resultats_form;
    @FXML
    private AnchorPane moniteur_seances_form;
    private ObservableList<Resultat> listeResultatsMoniteur = FXCollections.observableArrayList();
    // Décalage pour le déplacement de la fenêtre
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private void switchForm(ActionEvent event) {
        if (event.getSource() == seances_btn) {
            moniteur_seances_form.setVisible(true);
            moniteur_resultats_form.setVisible(false);
        } else if (event.getSource() == resultats_btn) {
            moniteur_seances_form.setVisible(false);
            moniteur_resultats_form.setVisible(true);
        }
    }
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void minimize(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }
    private void setupMoniteurResultatTable() {
        // Configuration des colonnes avec les propriétés du modèle Resultat
        moniteur_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        moniteur_col_candidat1.setCellValueFactory(new PropertyValueFactory<>("nomCandidat"));
        moniteur_col_examen.setCellValueFactory(new PropertyValueFactory<>("nomExamen"));
        moniteur_col_resultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));
    }
    private void loadMoniteurResultats() {
        listeResultatsMoniteur.clear();
        String query = """
            SELECT r.id, c.nom AS nom_candidat, e.type_examen AS type_examen, r.resultat
            FROM resultats r
            JOIN candidat c ON r.candidat_id = c.id
            JOIN examens e ON r.examen_id = e.id
        """;
        try (Connection conn = database.connectDb();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                listeResultatsMoniteur.add(new Resultat(
                    rs.getInt("id"),
                    rs.getString("nom_candidat"),
                    rs.getString("type_examen"),
                    rs.getString("resultat")
                ));
            }
            // Lier les résultats chargés à la table
            moniteur_table_resultat.setItems(listeResultatsMoniteur);
            System.out.println("Résultats chargés : " + listeResultatsMoniteur.size());
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(AlertType.ERROR, "Erreur", "Erreur de chargement des résultats", e.getMessage());
        }
    }
    private void showAlert(AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
    private void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de vouloir vous déconnecter ?");
        Optional<ButtonType> option = alert.showAndWait();
        if (option.isPresent() && option.get().equals(ButtonType.OK)) {
            try {
                // Fermer la fenêtre actuelle
                Stage stage = (Stage) logout.getScene().getWindow();
                stage.close();
                // Charger l'écran de connexion
                Parent root = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
                Stage loginStage = new Stage();
                Scene scene = new Scene(root);
                // Gérer le déplacement de la fenêtre
                root.setOnMousePressed(e -> {
                    xOffset = e.getSceneX();
                    yOffset = e.getSceneY();
                });
                root.setOnMouseDragged(e -> {
                    loginStage.setX(e.getScreenX() - xOffset);
                    loginStage.setY(e.getScreenY() - yOffset);
                    loginStage.setOpacity(0.8);
                });
                root.setOnMouseReleased(e -> loginStage.setOpacity(1));
                loginStage.initStyle(StageStyle.TRANSPARENT);
                loginStage.setScene(scene);
                loginStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupMoniteurResultatTable(); // Configurer les colonnes
        loadMoniteurResultats();      // Charger les résultats
    }
}