package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;

public class AccountsController {

    // --- Helper Method for Switching Scenes ---
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        // Load CSS
        if (Main.class.getResource("styles.css") != null) {
            scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        }
        stage.setScene(scene);
        stage.show();
    }

    // --- Sidebar Button Actions ---

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
        switchScene(event, "Dashboard.fxml");
    }

    @FXML
    public void switchToAccounts(ActionEvent event) {
        System.out.println("Already on Accounts");
    }

    @FXML
    public void switchToTransactions(ActionEvent event) throws IOException {
        switchScene(event, "Transactions.fxml");
    }

    @FXML
    public void switchToTransfer(ActionEvent event) throws IOException {
        switchScene(event, "Transfer.fxml");
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
    public void viewSavings(ActionEvent event) {
        System.out.println("View Savings clicked!");
    }

    @FXML
    public void viewChecking(ActionEvent event) {
        System.out.println("View Checking clicked!");
    }
}