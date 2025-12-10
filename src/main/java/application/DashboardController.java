package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML; // This import is crucial!
import java.io.IOException;

public class DashboardController {

    // --- Core Navigation Method ---
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        // Load CSS if it exists, prevent crash if missing
        if (Main.class.getResource("styles.css") != null) {
            scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        }
        stage.setScene(scene);
        stage.show();
    }

    // --- SIDEBAR BUTTON ACTIONS ---

    @FXML
    public void switchToDashboard(ActionEvent event) {
        // We are already on the dashboard, so we just print a message
        System.out.println("Already on Dashboard");
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

    // --- DASHBOARD QUICK ACTIONS ---
    // These match the buttons in the middle of your Dashboard

    @FXML
    public void handleQuickDeposit(ActionEvent event) {
        System.out.println("Deposit Clicked");
    }

    @FXML
    public void handleQuickWithdraw(ActionEvent event) {
        System.out.println("Withdraw Clicked");
    }
}