package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection connectDb() {
        try {
            String url = "jdbc:mysql://localhost:3306/autoecole"; // Remplacez par le nom de votre base de données
            String user = "root"; // Nom d'utilisateur MySQL
            String password; // Mot de passe MySQL
            password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
            return null;
        }
    }
}
