package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable; // NEW: Needed for loading data
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox; // NEW: Needed for the dropdown
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

// Updated class line to include "implements Initializable"
public class TransferController implements Initializable {

    // --- NEW: Dropdown Variable ---
    @FXML
    private ComboBox<String> accountSelector;

    // --- NEW: Initialize Method (Runs automatically when screen loads) ---
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (accountSelector != null) {
            // Add the items to the dropdown
            accountSelector.getItems().addAll("Savings Account", "Checking Account");
            // Select the first one by default
            accountSelector.getSelectionModel().selectFirst();
        }
    }

    // --- YOUR EXISTING NAVIGATION CODE BELOW ---

    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        if (Main.class.getResource("styles.css") != null) {
            scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
        switchScene(event, "Dashboard.fxml");
    }

    @FXML
    public void switchToAccounts(ActionEvent event) throws IOException {
        switchScene(event, "Accounts.fxml");
    }

    @FXML
    public void switchToTransactions(ActionEvent event) throws IOException {
        switchScene(event, "Transactions.fxml");
    }

    @FXML
    public void switchToTransfer(ActionEvent event) {
        System.out.println("Already on Transfer");
    }

    @FXML
    public void switchToProfile(ActionEvent event) throws IOException {
        switchScene(event, "Profile.fxml");
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        switchScene(event, "Login.fxml");
    }

    @FXML
    public void handleTransfer(ActionEvent event) {
        System.out.println("Transfer funds was clicked!");
    }
}