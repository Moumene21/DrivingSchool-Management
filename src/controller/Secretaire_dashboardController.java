package controller;


import java.sql.Statement;

import java.sql.*;
import model.Examen;
import model.Seance;

import model.database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Candidat;
import model.Paiement;
import model.Resultat;

   
public class Secretaire_dashboardController implements Initializable {
    
 
        
@FXML
private TableColumn<Paiement, Integer> paiement_col_tranche;

    @FXML
    private TableColumn<Paiement, String> paiement_col_date;

    @FXML
    private TableColumn<Paiement, Double> paiement_col_montant; 

    @FXML
    private TableColumn<Paiement, String> paiement_col_nom; 

    @FXML
    private TableColumn<Paiement, Double> paiement_col_rest; 
    

    @FXML
    private Button paiement_ajouter; 
    
    @FXML
    private Button paiement_modifier; // Bouton pour modifier un paiement

     @FXML
    private Button paiement_supprimer; 
     @FXML
    private ComboBox<String> paiement_saisie_candidat; // ComboBox pour sélectionner un candidat

    @FXML
    private DatePicker paiement_saisie_date;
    
    @FXML
    private TextField paiement_saisie_montant; // Champ de saisie pour le montant du paiement

    @FXML
    private TextField paiement_saisie_tranche; // Champ de saisie pour le montant restant (tranche)

   // Bouton pour supprimer un paiement

    @FXML
    private TableView<Paiement> paiement_table;
    
    
    
    
    


    
    
    
    
    
    
 






@FXML
private TableView<Examen> examens_table;

    @FXML
    private TableColumn<Examen, String>examens_col_dateexamens;

    @FXML
    private TableColumn<Examen, String>examens_col_heurexamens;

    @FXML
    private TableColumn<Examen, Integer>examens_col_id;

    @FXML
    private TableColumn<Examen, String>examens_col_typeexame;

    @FXML
    private Button examens_modifier;

    @FXML
    private TextField examens_saisie_date;

    @FXML
    private TextField examens_saisie_heurexam;

    @FXML
    private TextField examens_saisie_typeexamen;

    @FXML
    private Button examens_supprimer;

    @FXML
    private Button examens_ajouter;
    
    
    
    
    
    
    
    
    
    

    @FXML
    private Button seances_btn_ajouter;

    @FXML
    private Button seances_btn_modifier;

    @FXML
    private Button seances_btn_supprimer;

    @FXML
    private DatePicker seances_saisie_date1;

    @FXML
    private ComboBox<String> seances_saisie_candidat;

    @FXML
    private ComboBox<String> seances_saisie_moniteur;

    @FXML
    private ComboBox<String> seances_combobox_vehicule;

    @FXML
    private Spinner<String> seances_saisie_heur;

    @FXML
    private TableView<Seance> seances_table;

    @FXML
    private TableColumn<Seance, Integer> seances_col_id;

    @FXML
    private TableColumn<Seance, String> seances_col_candidat;

    @FXML
    private TableColumn<Seance, String> seances_col_moniteur;

    @FXML
    private TableColumn<Seance, String> seances_col_date;

    @FXML
    private TableColumn<Seance, String> seances_col_heur;

    @FXML
    private TableColumn<Seance, String> seances_col_vehicule;
    
    
        private ObservableList<Seance> seancesList = FXCollections.observableArrayList();

    
    
    
    
    
    
@FXML
private Button resultat_ajouter;
     
@FXML
private TableColumn<Resultat, Integer> resultat_col_id;

@FXML
private TableColumn<Resultat, String> resultat_col_cndidat;

@FXML
private TableColumn<Resultat, String> resultat_col_examen;

@FXML
private TableColumn<Resultat, String> resultat_col_resultat;  
   
@FXML
private ComboBox<String>resultat_saisie_candidat;

    @FXML
    private ComboBox<String>resultat_saisie_examen;

    @FXML
    private ComboBox<String>resultat_saisie_resultat;
    
    @FXML
    private Button resultat_modifier;

    @FXML
    private Button resultat_supprimer;

    @FXML
private TableView<Resultat> resultat_table;
    
    
    
    

@FXML
private TableView<Paiement> table_historique;

@FXML
private TableColumn<Paiement, String> historique_col_candidat;

@FXML
private TableColumn<Paiement, Double> historique_col_montant;

@FXML
private TableColumn<Paiement, Integer> historique_col_tranche;

@FXML
private TableColumn<Paiement, String> historique_col_date_paiement;

@FXML
private TableColumn<Paiement, Double> historique_col_reste;

    
    
    
    
    
    
    

     @FXML
             
     private ObservableList<Examen> examensList = FXCollections.observableArrayList();
     
   @FXML
 
        private ObservableList<Seance> seanceList = FXCollections.observableArrayList();

    @FXML
private ObservableList<Resultat> listeResultats = FXCollections.observableArrayList();




    
    @FXML
    private AnchorPane main_form;

    @FXML
    private Button examens_btn, logout, candidat_btn, seance_btn, Resultat_btn, Suivi_Paiements_btn11, Suivi_Paiements_btn111, close, minimize;

    @FXML
    private AnchorPane candidat_form, seance_form, examens_form, resultat_form, paiement_form, historique_form;

    @FXML
    private TableView<Candidat> candidat_table;

    @FXML
    private TableColumn<Candidat, Integer> candidat_col_id;

    @FXML
    private TableColumn<Candidat, String> candidat_col_nom, candidat_col_prenom, candidat_col_date_naissance, candidat_col_numero;

    @FXML
    private TextField candidat_saisie_nom, candidat_saisie_prenom, candidat_saisie_date_naissance, candidat_saisie_numero;
    @FXML
    private ObservableList<Candidat> candidatList = FXCollections.observableArrayList();
    @FXML
  


    private Map<Button, AnchorPane> formMap;
    @FXML
    private double x, y;
    private double tranche;
    @FXML

   @Override
public void initialize(URL location, ResourceBundle resources) {
    // Initialisation de la Map pour les boutons et les formulaires
    formMap = Map.of(
        candidat_btn, candidat_form,
        seance_btn, seance_form,
        examens_btn, examens_form,
        Resultat_btn, resultat_form,
        Suivi_Paiements_btn11, paiement_form,
        Suivi_Paiements_btn111, historique_form
    );

    // Configuration des tables
    loadCandidatsIntooComboBox();
  loadSeancesFromDatabase();
  
    loadMoniteursIntoComboBox();
    
   
    setupHeureSpinner();
    setupSeanceTable();

    
    setupExamensTable();
    setupCandidatTable();
   setupResultatTable();
   setupPaiementTable();
  loadVehicules() ;
      // Chargement des données dans les tables
    
    resultat_table.setItems(listeResultats);
    
    loadVehicules() ;
    loadCandidats();
    loadExamens();
   
    
    loadComboBoxes();
    loadResultats();
    loadPaiementsFromDatabase();
    loadCandidatsIntoComboBox();
    loadPaiementssFromDatabase();
    setupTableHistorique();
}

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.close();
    }

    @FXML
    void minimize(ActionEvent event) {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void switchForm(ActionEvent event) {
        formMap.values().forEach(form -> form.setVisible(false));
        formMap.get(event.getSource()).setVisible(true);
    }

    private void setupTableHistorique() {
    // Initialiser les colonnes de la TableView
    historique_col_candidat.setCellValueFactory(new PropertyValueFactory<>("nom"));
    historique_col_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
    historique_col_tranche.setCellValueFactory(new PropertyValueFactory<>("tranche"));
    historique_col_date_paiement.setCellValueFactory(new PropertyValueFactory<>("date"));
    historique_col_reste.setCellValueFactory(new PropertyValueFactory<>("reste"));

    // Charger les données depuis la base de données
    loadPaiementsFromDatabase();
}
    
   private void loadPaiementssFromDatabase() {
    ObservableList<Paiement> paiements = FXCollections.observableArrayList();

    String query = "SELECT p.id, c.nom AS candidat, p.date_paiement, p.montant, p.reste, p.tranche " +
                   "FROM paiements p " +
                   "JOIN candidat c ON p.id_candidat = c.id";

    try {
        Connection conn = database.connectDb(); // Connexion à la base de données
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String candidat = resultSet.getString("candidat");
            String date = resultSet.getString("date_paiement");
            double montant = resultSet.getDouble("montant");
            double reste = resultSet.getDouble("reste");
            int tranche = resultSet.getInt("tranche");

            // Créer un objet Paiement pour chaque ligne de la base
            Paiement paiement = new Paiement(id, candidat, date, montant, reste, tranche);
            paiements.add(paiement);
        }

        resultSet.close();
        statement.close();
        conn.close();

        // Charger les données dans la TableView
        table_historique.setItems(paiements);

    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors du chargement des paiements depuis la base de données.");
    }
}

    
    
    
    
    
    
    

    
 private void setupPaiementTable() {
    paiement_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    paiement_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    paiement_col_montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
    paiement_col_rest.setCellValueFactory(new PropertyValueFactory<>("rest"));
    paiement_col_tranche.setCellValueFactory(new PropertyValueFactory<>("tranche")); // Liaison avec la propriété tranche

    paiement_col_montant.setCellFactory(column -> new TableCell<Paiement, Double>() {
        @Override
        protected void updateItem(Double montant, boolean empty) {
            super.updateItem(montant, empty);
            if (empty || montant == null) {
                setText(null);
            } else {
                setText(String.format("%.2f DA", montant));
            }
        }
    });

    paiement_col_rest.setCellFactory(column -> new TableCell<Paiement, Double>() {
        @Override
        protected void updateItem(Double rest, boolean empty) {
            super.updateItem(rest, empty);
            if (empty || rest == null) {
                setText(null);
            } else {
                setText(String.format("%.2f DA", rest));
            }
        }
    });
}

    
private void loadPaiementsFromDatabase() {
    ObservableList<Paiement> paiements = FXCollections.observableArrayList();

    String query = "SELECT p.id, c.nom AS candidat, p.date_paiement, p.montant, p.reste, p.tranche " +
                   "FROM paiements p " +
                   "JOIN candidat c ON p.id_candidat = c.id";

    try {
        Connection conn = database.connectDb();
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String candidat = resultSet.getString("candidat");
            String date = resultSet.getString("date_paiement");
            double montant = resultSet.getDouble("montant");
            double reste = resultSet.getDouble("reste");
            int tranche = resultSet.getInt("tranche"); // Récupérer la valeur de tranche

            Paiement paiement = new Paiement(id, candidat, date, montant, reste, tranche);
            paiements.add(paiement);
        }

        resultSet.close();
        statement.close();
        conn.close();

        paiement_table.setItems(paiements);

    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors du chargement des paiements depuis la base de données.");
    }
}

private void loadCandidatsIntoComboBox() {
    ObservableList<String> candidats = FXCollections.observableArrayList();
    String query = "SELECT nom FROM candidat";

    try {
        Connection conn = database.connectDb();
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            candidats.add(resultSet.getString("nom")); // Ajouter chaque candidat à la liste
        }

        resultSet.close();
        statement.close();
        conn.close();

        // Ajouter les candidats au ComboBox
        paiement_saisie_candidat.setItems(candidats);

    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors du chargement des candidats.");
    }
}

@FXML

private void ajouterPaiement(ActionEvent event) {
    String candidat = paiement_saisie_candidat.getValue(); // Nom du candidat sélectionné
    LocalDate date = paiement_saisie_date.getValue(); // Date sélectionnée
    String montantStr = paiement_saisie_montant.getText(); // Montant saisi

    if (candidat == null || date == null || montantStr.isEmpty()) {
        showError("Veuillez remplir tous les champs.");
        return;
    }

    try {
        // Convertir les champs en valeurs numériques
        double montant = Double.parseDouble(montantStr);
        double totalPermis = 25000.0;

        // Connexion à la base de données
        Connection conn = database.connectDb();

        // Récupérer le montant total payé par le candidat
        String getMontantTotalQuery = "SELECT SUM(montant) as total_paye, MAX(tranche) as last_tranche FROM paiements " +
                                      "WHERE id_candidat = (SELECT id FROM candidat WHERE nom = ?)";
        PreparedStatement getMontantTotalStmt = conn.prepareStatement(getMontantTotalQuery);
        getMontantTotalStmt.setString(1, candidat);
        ResultSet rs = getMontantTotalStmt.executeQuery();

        double totalPaye = 0.0;
        int lastTranche = 0; // Par défaut, si aucune tranche n'a été payée
        if (rs.next()) {
            totalPaye = rs.getDouble("total_paye");
            lastTranche = rs.getInt("last_tranche");
        }
        rs.close();
        getMontantTotalStmt.close();

        // Vérifier si le candidat a déjà payé la totalité
        if (totalPaye >= totalPermis) {
            showError("Ce candidat a déjà payé la totalité du permis.");
            conn.close();
            return;
        }

        // Calcul du montant restant et attribution de la nouvelle tranche
        double reste = totalPermis - (totalPaye + montant);
        if (reste < 0) {
            showError("Le paiement dépasse le montant total du permis.");
            conn.close();
            return;
        }

        int nouvelleTranche = lastTranche + 1; // Incrémenter la dernière tranche

        // Insérer le nouveau paiement
        String insertPaiementQuery = "INSERT INTO paiements (id_candidat, date_paiement, montant, reste, tranche) VALUES " +
                                     "((SELECT id FROM candidat WHERE nom = ?), ?, ?, ?, ?)";
        PreparedStatement insertPaiementStmt = conn.prepareStatement(insertPaiementQuery);
        insertPaiementStmt.setString(1, candidat);
        insertPaiementStmt.setString(2, date.toString());
        insertPaiementStmt.setDouble(3, montant);
        insertPaiementStmt.setDouble(4, reste);
        insertPaiementStmt.setInt(5, nouvelleTranche);

        // Exécuter l'insertion
        insertPaiementStmt.executeUpdate();
        insertPaiementStmt.close();
        conn.close();

        // Mettre à jour l'interface utilisateur
        loadPaiementsFromDatabase(); // Rafraîchir la TableView
        showSuccess("Paiement ajouté avec succès !");
    } catch (NumberFormatException e) {
        showError("Le montant doit être un nombre valide.");
    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors de l'ajout du paiement.");
    }
}



@FXML
private void modifierPaiement(ActionEvent event) {
    Paiement paiement = paiement_table.getSelectionModel().getSelectedItem();

    if (paiement == null) {
        showError("Veuillez sélectionner un paiement à modifier.");
        return;
    }

    String montantStr = paiement_saisie_montant.getText();
    if (montantStr.isEmpty()) {
        showError("Veuillez saisir un montant.");
        return;
    }

    double montant = Double.parseDouble(montantStr);
    double totalPermis = 25000.0;
    double rest = totalPermis - montant;

    try {
        Connection conn = database.connectDb();
        String query = "UPDATE paiements SET montant = ?, reste = ? WHERE id = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setDouble(1, montant);
        statement.setDouble(2, rest);
        statement.setInt(3, paiement.getId());

        statement.executeUpdate();
        statement.close();
        conn.close();

        loadPaiementsFromDatabase(); // Rafraîchir la TableView
        showSuccess("Paiement modifié avec succès !");
    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors de la modification du paiement.");
    }
}
@FXML
private void supprimerPaiement(ActionEvent event) {
    Paiement paiement = paiement_table.getSelectionModel().getSelectedItem();

    if (paiement == null) {
        showError("Veuillez sélectionner un paiement à supprimer.");
        return;
    }

    try {
        Connection conn = database.connectDb();
        String query = "DELETE FROM paiements WHERE id = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, paiement.getId());

        statement.executeUpdate();
        statement.close();
        conn.close();

        loadPaiementsFromDatabase(); // Rafraîchir la TableView
        showSuccess("Paiement supprimé avec succès !");
    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors de la suppression du paiement.");
    }
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
private void setupExamensTable() {
    System.out.println("Configuration des colonnes...");
    
    if (examens_col_id == null) System.out.println("Colonne ID est null");
    if (examens_col_typeexame == null) System.out.println("Colonne type est null");
    if (examens_col_dateexamens == null) System.out.println("Colonne date est null");
    if (examens_col_heurexamens == null) System.out.println("Colonne heure est null");
    
    examens_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    examens_col_typeexame.setCellValueFactory(new PropertyValueFactory<>("typeExamen"));
    examens_col_dateexamens.setCellValueFactory(new PropertyValueFactory<>("dateExamen"));
    examens_col_heurexamens.setCellValueFactory(new PropertyValueFactory<>("heure"));
    
    System.out.println("Configuration des colonnes terminée");
}
     
      @FXML
       private void loadExamens() {
    examensList = FXCollections.observableArrayList();
    
    String query = "SELECT * FROM examens";
    try {
        Connection conn = database.connectDb();
        if (conn == null) {
            System.out.println("La connexion est nulle!");
            return;
        }
        
        System.out.println("Connexion réussie à la base de données");
        
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        int count = 0;
        while (rs.next()) {
            count++;
            System.out.println("Lecture ligne " + count + ": " +
                             "ID=" + rs.getInt("id") + 
                             ", Type=" + rs.getString("type_examen"));
                             
            Examen examen = new Examen(
                rs.getInt("id"),
                rs.getString("type_examen"),
                rs.getString("date_examen"),
                rs.getString("heure")
            );
            examensList.add(examen);
        }
        
        System.out.println("Nombre total d'examens lus: " + count);
        
        if (examens_table == null) {
            System.out.println("Le TableView est null!");
            return;
        }
        
        examens_table.setItems(examensList);
        
    } catch (SQLException e) {
        System.out.println("Erreur SQL: " + e.getMessage());
        e.printStackTrace();
    }
}


@FXML
private void ajouterExamen(ActionEvent event) {
    String typeExamen = examens_saisie_typeexamen.getText();
    String dateExamen = examens_saisie_date.getText();
    String heureExamen = examens_saisie_heurexam.getText();

    if (typeExamen.isEmpty() || dateExamen.isEmpty() || heureExamen.isEmpty()) {
        showAlert(Alert.AlertType.WARNING, "Champs Vides", "Veuillez remplir tous les champs pour ajouter un examen.", null);
        return;
    }

    String insertSQL = "INSERT INTO examens (type_examen, date_examen, heure) VALUES (?, ?, ?)";

    try (Connection conn = database.connectDb();
         PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {

        insertStmt.setString(1, typeExamen);
        insertStmt.setString(2, dateExamen);
        insertStmt.setString(3, heureExamen);
        insertStmt.executeUpdate();

        showAlert(Alert.AlertType.INFORMATION, "Succès", "Examen ajouté avec succès !", null);
        loadExamens();
        clearExamFields();

    } catch (SQLException e) {
        showAlert(Alert.AlertType.ERROR, "Erreur d'Ajout", "Impossible d'ajouter l'examen", e.getMessage());
    }
}

@FXML
private void modifierExamen(ActionEvent event) {
    Examen selectedExamen = (Examen) examens_table.getSelectionModel().getSelectedItem();
    if (selectedExamen == null) {
        showAlert(Alert.AlertType.WARNING, "Aucune Sélection", "Veuillez sélectionner un examen à modifier.", null);
        return;
    }

    String updateSQL = "UPDATE examens SET type_examen = ?, date_examen = ?, heure = ? WHERE id = ?";

    try (Connection conn = database.connectDb();
         PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

        updateStmt.setString(1, examens_saisie_typeexamen.getText());
        updateStmt.setString(2, examens_saisie_date.getText());
        updateStmt.setString(3, examens_saisie_heurexam.getText());
        updateStmt.setInt(4, selectedExamen.getId());
        updateStmt.executeUpdate();

        showAlert(Alert.AlertType.INFORMATION, "Succès", "Examen modifié avec succès !", null);
        loadExamens();
        clearExamFields();

    } catch (SQLException e) {
        showAlert(Alert.AlertType.ERROR, "Erreur de Modification", "Impossible de modifier l'examen", e.getMessage());
    }
}

@FXML
private void supprimerExamen(ActionEvent event) {
    Examen selectedExamen = (Examen) examens_table.getSelectionModel().getSelectedItem();
    if (selectedExamen == null) {
        showAlert(Alert.AlertType.WARNING, "Aucune Sélection", "Veuillez sélectionner un examen à supprimer.", null);
        return;
    }

    String deleteSQL = "DELETE FROM examens WHERE id = ?";

    try (Connection conn = database.connectDb();
         PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

        deleteStmt.setInt(1, selectedExamen.getId());
        deleteStmt.executeUpdate();

        showAlert(Alert.AlertType.INFORMATION, "Succès", "Examen supprimé avec succès !", null);
        loadExamens();
        clearExamFields();

    } catch (SQLException e) {
        showAlert(Alert.AlertType.ERROR, "Erreur de Suppression", "Impossible de supprimer l'examen", e.getMessage());
    }
}

private void clearExamFields() {
    examens_saisie_typeexamen.clear();
    examens_saisie_date.clear();
    examens_saisie_heurexam.clear();
}


  













    private void loadCandidats() {
        candidatList.clear();
        String query = "SELECT * FROM candidat";

        try (Connection conn = database.connectDb();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Candidat candidat = new Candidat(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("date_naissance"),
                        resultSet.getString("telephone")
                );
                candidatList.add(candidat);
            }
            candidat_table.setItems(candidatList);

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de Chargement", "Impossible de charger les données des candidats", e.getMessage());
        }
    }

    private void setupCandidatTable() {
        candidat_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        candidat_col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        candidat_col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        candidat_col_date_naissance.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        candidat_col_numero.setCellValueFactory(new PropertyValueFactory<>("telephone"));
    }
    


    @FXML
    
private void ajouterCandidat(ActionEvent event) {
    String nom = candidat_saisie_nom.getText();
    String prenom = candidat_saisie_prenom.getText();
    String dateNaissance = candidat_saisie_date_naissance.getText();
    String numero = candidat_saisie_numero.getText();

    // Validation des champs
    if (nom.isEmpty() || prenom.isEmpty() || dateNaissance.isEmpty() || numero.isEmpty()) {
        showAlert(Alert.AlertType.WARNING, "Champs Vides", "Veuillez remplir tous les champs pour ajouter un candidat.", null);
        return;
    }

    // Validation du numéro de téléphone
    if (!numero.matches("\\d{10}")) {
        showAlert(Alert.AlertType.WARNING, "Format Invalide", "Le numéro de téléphone doit contenir 10 chiffres.", null);
        return;
    }

    String insertSQL = "INSERT INTO candidat (nom, prenom, date_naissance, telephone) VALUES (?, ?, ?, ?)";

    try (Connection conn = database.connectDb();
         PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {

        insertStmt.setString(1, nom);
        insertStmt.setString(2, prenom);
        insertStmt.setString(3, dateNaissance);
        insertStmt.setString(4, numero);
        insertStmt.executeUpdate();

        showAlert(Alert.AlertType.INFORMATION, "Succès", "Candidat ajouté avec succès !", null);
        loadCandidats();
        clearFields();

    } catch (SQLException e) {
        showAlert(Alert.AlertType.ERROR, "Erreur d'Ajout", "Impossible d'ajouter le candidat", e.getMessage());
    }
}

    
    @FXML
    private void modifierCandidat(ActionEvent event) {
        Candidat selectedCandidat = candidat_table.getSelectionModel().getSelectedItem();
        if (selectedCandidat == null) {
            showAlert(Alert.AlertType.WARNING, "Aucune Sélection", "Veuillez sélectionner un candidat à modifier.", null);
            return;
        }

        String updateSQL = "UPDATE candidat SET nom = ?, prenom = ?, telephone = ?, date_naissance = ? WHERE id = ?";

        try (Connection conn = database.connectDb();
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            updateStmt.setString(1, candidat_saisie_nom.getText());
            updateStmt.setString(2, candidat_saisie_prenom.getText());
            updateStmt.setString(3, candidat_saisie_numero.getText());
            updateStmt.setString(4, candidat_saisie_date_naissance.getText());
            updateStmt.setInt(5, selectedCandidat.getId());
            updateStmt.executeUpdate();

            showAlert(Alert.AlertType.INFORMATION, "Succès", "Candidat modifié avec succès !", null);
            loadCandidats();
            clearFields();

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de Modification", "Impossible de modifier le candidat", e.getMessage());
        }
    }

    @FXML
    private void supprimerCandidat(ActionEvent event) {
        Candidat selectedCandidat = candidat_table.getSelectionModel().getSelectedItem();
        if (selectedCandidat == null) {
            showAlert(Alert.AlertType.WARNING, "Aucune Sélection", "Veuillez sélectionner un candidat à supprimer.", null);
            return;
        }

        String deleteSQL = "DELETE FROM candidat WHERE id = ?";

        try (Connection conn = database.connectDb();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

            deleteStmt.setInt(1, selectedCandidat.getId());
            deleteStmt.executeUpdate();

            showAlert(Alert.AlertType.INFORMATION, "Succès", "Candidat supprimé avec succès !", null);
            loadCandidats();
            clearFields();

        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Erreur de Suppression", "Impossible de supprimer le candidat", e.getMessage());
        }
    }

    private void clearFields() {
        candidat_saisie_nom.clear();
        candidat_saisie_prenom.clear();
        candidat_saisie_date_naissance.clear();
        candidat_saisie_numero.clear();
    }



    
    
    
   
    











     

    
@FXML
private void loadVehicules() {
    seances_combobox_vehicule.getItems().clear();
    String query = "SELECT id, marque FROM vehicules";
    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            seances_combobox_vehicule.getItems().add(rs.getString("marque"));
        }
    } catch (SQLException e) {
        showAlert(AlertType.ERROR, "Erreur", "Erreur de chargement des véhicules", e.getMessage());
    }
}
@FXML
private void setupSeanceTable() {
   seances_col_vehicule.setCellValueFactory(new PropertyValueFactory<>("vehicule"));
seances_col_candidat.setCellValueFactory(new PropertyValueFactory<>("candidat"));
seances_col_moniteur.setCellValueFactory(new PropertyValueFactory<>("moniteur"));
seances_col_heur.setCellValueFactory(new PropertyValueFactory<>("heure"));
seances_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
}

  
@FXML
private void loadMoniteursIntoComboBox() {
    ObservableList<String> moniteurs = FXCollections.observableArrayList();
    String query = "SELECT nom FROM utilisateurs WHERE role = 'moniteur'";

    try (Connection conn = database.connectDb();
         PreparedStatement statement = conn.prepareStatement(query);
         ResultSet rs = statement.executeQuery()) {

        while (rs.next()) {
            moniteurs.add(rs.getString("nom"));
        }

        seances_saisie_moniteur.setItems(moniteurs);

    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors du chargement des moniteurs.");
    }
}


@FXML
private void loadCandidatsIntooComboBox() {
    ObservableList<String> candidats = FXCollections.observableArrayList();
    String query = "SELECT nom FROM candidat";

    try (Connection conn = database.connectDb();
         PreparedStatement statement = conn.prepareStatement(query);
         ResultSet rs = statement.executeQuery()) {

        while (rs.next()) {
            candidats.add(rs.getString("nom"));
        }

        seances_saisie_candidat.setItems(candidats);

    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors du chargement des candidats.");
    }
}

  

    // Méthode utilitaire pour afficher les erreurs
    private void showAlert(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

private void setupHeureSpinner() {
    SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory<String>() {
        private int currentHour = 0;
        private int currentMinute = 0;

        @Override
        public void decrement(int steps) {
            currentMinute -= steps * 15; // Décrément par intervalles de 15 minutes
            if (currentMinute < 0) {
                currentMinute += 60;
                currentHour = (currentHour - 1 + 24) % 24; // Ajuste l'heure
            }
            updateValue();
        }

        @Override
        public void increment(int steps) {
            currentMinute += steps * 15; // Incrément par intervalles de 15 minutes
            if (currentMinute >= 60) {
                currentMinute -= 60;
                currentHour = (currentHour + 1) % 24; // Ajuste l'heure
            }
            updateValue();
        }

        public void updateValue() {
            setValue(String.format("%02d:%02d", currentHour, currentMinute));
        }
    };

    valueFactory.setValue("00:00"); // Valeur par défaut
    seances_saisie_heur.setValueFactory(valueFactory);
}

@FXML
private void loadSeancesFromDatabase() {
    seanceList.clear(); // On vide la liste avant d'ajouter les nouvelles données

    String query = "SELECT s.id, " +
                   "COALESCE(c.nom, 'Non attribué') AS candidat, " +
                   "COALESCE(u.nom, 'Non attribué') AS moniteur, " +
                   "s.date, " +
                   "s.heur, " +
                   "COALESCE(v.marque, 'Non attribué') AS vehicule " +
                   "FROM seancesformation s " +
                   "LEFT JOIN candidat c ON s.id_candidat = c.id " +
                   "LEFT JOIN utilisateurs u ON s.moniteur_id = u.id " +
                   "LEFT JOIN vehicules v ON s.id_vehicule = v.id";

    try (Connection conn = database.connectDb();
         PreparedStatement statement = conn.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String candidat = resultSet.getString("candidat");
            String moniteur = resultSet.getString("moniteur");
            String date = resultSet.getString("date");
            String heure = resultSet.getString("heur");
            String vehicule = resultSet.getString("vehicule");

            seanceList.add(new Seance(id, candidat, moniteur, date, heure, vehicule));
        }

        System.out.println("Données chargées avec succès : " + seanceList);
        seances_table.setItems(seanceList);

    } catch (SQLException e) {
        e.printStackTrace();
        showError("Erreur lors du chargement des données.");
    }
}
@FXML
private void ajouterSeance() {
    String vehicule = seances_combobox_vehicule.getValue();
    String candidat = seances_saisie_candidat.getValue();
    String moniteur = seances_saisie_moniteur.getValue();
    String heure = seances_saisie_heur.getValue();
    String date = seances_saisie_date1.getValue().toString();

    if (vehicule == null || candidat == null || moniteur == null || heure == null || date == null) {
        showAlert(AlertType.WARNING, "Champs manquants", "Veuillez remplir tous les champs.", null);
        return;
    }

    String query = "INSERT INTO seancesformation (id_vehicule, id_candidat, moniteur_id, heur, date) " +
                   "VALUES ((SELECT id FROM vehicules WHERE marque = ?), " +
                   "(SELECT id FROM candidat WHERE nom = ?), " +
                   "(SELECT id FROM utilisateurs WHERE nom = ? AND role = 'moniteur'), ?, ?)";

    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, vehicule);
        stmt.setString(2, candidat);
        stmt.setString(3, moniteur);
        stmt.setString(4, heure);
        stmt.setString(5, date);

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            showAlert(AlertType.INFORMATION, "Succès", "La séance a été ajoutée avec succès.", null);
            loadSeancesFromDatabase();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Impossible d'ajouter la séance.", e.getMessage());
    }
}
@FXML
private void modifierSeance() {
    Seance seanceSelectionnee = seances_table.getSelectionModel().getSelectedItem();

    if (seanceSelectionnee == null) {
        showAlert(AlertType.WARNING, "Sélection requise", "Veuillez sélectionner une séance à modifier.", null);
        return;
    }

    String vehicule = seances_combobox_vehicule.getValue();
    String candidat = seances_saisie_candidat.getValue();
    String moniteur = seances_saisie_moniteur.getValue();
    String heure = seances_saisie_heur.getValue();
    String date = seances_saisie_date1.getValue().toString();

    if (vehicule == null || candidat == null || moniteur == null || heure == null || date == null) {
        showAlert(AlertType.WARNING, "Champs manquants", "Veuillez remplir tous les champs.", null);
        return;
    }

    String query = "UPDATE seancesformation " +
                   "SET id_vehicule = (SELECT id FROM vehicules WHERE marque = ?), " +
                   "id_candidat = (SELECT id FROM candidat WHERE nom = ?), " +
                   "moniteur_id = (SELECT id FROM utilisateurs WHERE nom = ? AND role = 'moniteur'), " +
                   "heur = ?, date = ? WHERE id = ?";

    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, vehicule);
        stmt.setString(2, candidat);
        stmt.setString(3, moniteur);
        stmt.setString(4, heure);
        stmt.setString(5, date);
        stmt.setInt(6, seanceSelectionnee.getId());

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            showAlert(AlertType.INFORMATION, "Succès", "La séance a été modifiée avec succès.", null);
            loadSeancesFromDatabase();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Impossible de modifier la séance.", e.getMessage());
    }
}

@FXML
private void supprimerSeance() {
    Seance seanceSelectionnee = seances_table.getSelectionModel().getSelectedItem();

    if (seanceSelectionnee == null) {
        showAlert(AlertType.WARNING, "Sélection requise", "Veuillez sélectionner une séance à supprimer.", null);
        return;
    }

    String query = "DELETE FROM seancesformation WHERE id = ?";

    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, seanceSelectionnee.getId());

        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            showAlert(AlertType.INFORMATION, "Succès", "La séance a été supprimée avec succès.", null);
            loadSeancesFromDatabase();
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Impossible de supprimer la séance.", e.getMessage());
    }
}











@FXML


private void setupResultatTable() {
    // Associer les colonnes aux propriétés de la classe Resultat
    resultat_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    resultat_col_cndidat.setCellValueFactory(new PropertyValueFactory<>("nomCandidat"));
    resultat_col_examen.setCellValueFactory(new PropertyValueFactory<>("nomExamen"));
    resultat_col_resultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));
}

private void loadResultats() {
    listeResultats.clear();
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
            listeResultats.add(new Resultat(
                rs.getInt("id"),
                rs.getString("nom_candidat"),
                rs.getString("type_examen"),
                rs.getString("resultat")
            ));
        }

        System.out.println("Résultats chargés : " + listeResultats.size());
    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur de chargement des résultats", e.getMessage());
    }
}


private void loadComboBoxes() {
    String queryCandidats = "SELECT id, nom FROM candidat";
    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(queryCandidats);
         ResultSet rs = stmt.executeQuery()) {

        ObservableList<String> candidats = FXCollections.observableArrayList();
        while (rs.next()) {
            candidats.add(rs.getInt("id") + " - " + rs.getString("nom"));
        }
        resultat_saisie_candidat.setItems(candidats);

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur de chargement des candidats", e.getMessage());
    }

    String queryExamens = "SELECT id, type_examen FROM examens";
    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(queryExamens);
         ResultSet rs = stmt.executeQuery()) {

        ObservableList<String> examens = FXCollections.observableArrayList();
        while (rs.next()) {
            examens.add(rs.getInt("id") + " - " + rs.getString("type_examen"));
        }
        resultat_saisie_examen.setItems(examens);

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur de chargement des examens", e.getMessage());
    }

    ObservableList<String> resultats = FXCollections.observableArrayList("Réussi", "Échoué");
    resultat_saisie_resultat.setItems(resultats);
}

@FXML
private void ajouterResultat() {
    String candidatSelection = resultat_saisie_candidat.getValue();
    String examenSelection = resultat_saisie_examen.getValue();
    String resultat = resultat_saisie_resultat.getValue();

    // Vérification des champs obligatoires
    if (candidatSelection == null || examenSelection == null || resultat == null) {
        showAlert(AlertType.WARNING, "Attention", "Veuillez remplir tous les champs.");
        return;
    }

    // Extraire les IDs des valeurs sélectionnées
    int candidatId = Integer.parseInt(candidatSelection.split(" - ")[0]); // ID du candidat
    int examenId = Integer.parseInt(examenSelection.split(" - ")[0]);     // ID de l'examen

    // Vérification : un candidat ne doit pas réussir deux fois ou plus un même examen
    String checkQuery = """
        SELECT COUNT(*) AS count
        FROM resultats
        WHERE candidat_id = ? AND examen_id = ? AND resultat = 'Réussi'
    """;

    try (Connection conn = database.connectDb();
         PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

        checkStmt.setInt(1, candidatId);
        checkStmt.setInt(2, examenId);

        try (ResultSet rs = checkStmt.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt("count");
                System.out.println("Nombre de réussites trouvées : " + count);

                if (count > 0) {
                    // Si le candidat a déjà réussi cet examen
                    showAlert(AlertType.WARNING, "Attention", 
                              "Ce candidat a déjà réussi cet examen. Vous ne pouvez pas ajouter un nouveau résultat.");
                    return;
                }
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la vérification du résultat.", e.getMessage());
        return;
    }

    // Insérer le nouveau résultat si aucune réussite précédente n'est trouvée
    String queryInsert = "INSERT INTO resultats (candidat_id, examen_id, resultat) VALUES (?, ?, ?)";

    try (Connection conn = database.connectDb();
         PreparedStatement insertStmt = conn.prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS)) {

        insertStmt.setInt(1, candidatId);
        insertStmt.setInt(2, examenId);
        insertStmt.setString(3, resultat);

        int rowsAffected = insertStmt.executeUpdate();

        if (rowsAffected > 0) {
            // Récupérer l'ID du résultat nouvellement inséré
            int newResultatId = -1;
            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newResultatId = generatedKeys.getInt(1);
                }
            }

            // Ajouter directement le nouveau résultat à la liste observable
            listeResultats.add(new Resultat(
                newResultatId,                          // ID généré
                candidatSelection.split(" - ")[1],      // Nom du candidat
                examenSelection.split(" - ")[1],        // Type de l'examen
                resultat                                // Résultat
            ));

            // Afficher un message de succès
            showAlert(AlertType.INFORMATION, "Succès", "Résultat ajouté avec succès.");

            // Forcer le rafraîchissement de la table
            resultat_table.refresh();

            // Réinitialiser les champs du formulaire
            resultat_saisie_candidat.setValue(null);
            resultat_saisie_examen.setValue(null);
            resultat_saisie_resultat.setValue(null);
        } else {
            showAlert(AlertType.ERROR, "Erreur", "Le résultat n'a pas pu être ajouté.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur lors de l'ajout du résultat.", e.getMessage());
    }
}


@FXML
private void modifierResultat() {
    // Vérifier si un résultat est sélectionné
    Resultat selectedResultat = resultat_table.getSelectionModel().getSelectedItem();
    if (selectedResultat == null) {
        showAlert(AlertType.WARNING, "Attention", "Veuillez sélectionner un résultat à modifier.");
        return;
    }

    // Récupérer les valeurs saisies dans les champs
    String candidat = resultat_saisie_candidat.getValue();
    String examen = resultat_saisie_examen.getValue();
    String resultat = resultat_saisie_resultat.getValue();

    // Vérifier si tous les champs sont remplis
    if (candidat == null || examen == null || resultat == null) {
        showAlert(AlertType.WARNING, "Attention", "Veuillez remplir tous les champs.");
        return;
    }

    // Préparer la requête SQL de mise à jour
    String query = """
        UPDATE resultats
        SET candidat_id = ?, examen_id = ?, resultat = ?
        WHERE id = ?
    """;

    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Paramétrer la requête
        stmt.setInt(1, Integer.parseInt(candidat.split(" - ")[0])); // ID du candidat
        stmt.setInt(2, Integer.parseInt(examen.split(" - ")[0]));   // ID de l'examen
        stmt.setString(3, resultat);                               // Résultat
        stmt.setInt(4, selectedResultat.getId());                  // ID du résultat à modifier

        // Exécuter la requête
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            // Mettre à jour la liste observable
            selectedResultat.setNomCandidat(candidat.split(" - ")[1]);
            selectedResultat.setNomExamen(examen.split(" - ")[1]);
            selectedResultat.setResultat(resultat);

            // Rafraîchir la table
            resultat_table.refresh();

            showAlert(AlertType.INFORMATION, "Succès", "Résultat modifié avec succès.");
        } else {
            showAlert(AlertType.ERROR, "Erreur", "Le résultat n'a pas pu être modifié.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la modification du résultat", e.getMessage());
    }
}


@FXML
private void supprimerResultat() {
    // Vérifier si un résultat est sélectionné
    Resultat selectedResultat = resultat_table.getSelectionModel().getSelectedItem();
    if (selectedResultat == null) {
        showAlert(AlertType.WARNING, "Attention", "Veuillez sélectionner un résultat à supprimer.");
        return;
    }

    // Confirmer l'action de suppression
    Alert confirmationAlert = new Alert(AlertType.CONFIRMATION);
    confirmationAlert.setTitle("Confirmation");
    confirmationAlert.setHeaderText("Confirmer la suppression");
    confirmationAlert.setContentText("Voulez-vous vraiment supprimer ce résultat ?");
    if (confirmationAlert.showAndWait().orElse(ButtonType.CANCEL) != ButtonType.OK) {
        return;
    }

    // Préparer la requête SQL de suppression
    String query = "DELETE FROM resultats WHERE id = ?";

    try (Connection conn = database.connectDb();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, selectedResultat.getId()); // Utiliser l'ID du résultat sélectionné
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            // Supprimer le résultat de la liste observable
            listeResultats.remove(selectedResultat);
            showAlert(AlertType.INFORMATION, "Succès", "Résultat supprimé avec succès.");
        } else {
            showAlert(AlertType.ERROR, "Erreur", "Le résultat n'a pas pu être supprimé.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        showAlert(AlertType.ERROR, "Erreur", "Erreur lors de la suppression du résultat", e.getMessage());
    }
}





























  public void logout() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Message");
    alert.setHeaderText(null);
    alert.setContentText("Êtes-vous sûr de vouloir vous déconnecter ?");
    Optional<ButtonType> option = alert.showAndWait();

    if (option.isPresent() && option.get() == ButtonType.OK) {
        try {
            // Fermer la fenêtre actuelle
            if (logout != null && logout.getScene() != null) {
                logout.getScene().getWindow().hide();
            }

            // Charger la fenêtre de connexion
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLDocument.fxml"));
            Parent root = loader.load();

            // Configurer la scène et le stage
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Erreur", "Impossible de charger la fenêtre de connexion.", e.getMessage());
        }
    }
}

    private boolean isValidTimeFormat(String heure) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void showAlert(AlertType alertType, String succès, String résultat_ajouté_avec_succès) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void showError(String erreur_lors_du_chargement_des_paiements_d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void showSuccess(String paiement_ajouté_avec_succès_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getCandidatNom(String idCandidat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getMoniteurNom(String moniteurId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getVehiculeMarque(String idVehicule) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void afficherErreur(String erreur_lors_du_chargement_des_données) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Connection connectToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void afficherInfo(String séance_ajoutée_avec_succès_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    



