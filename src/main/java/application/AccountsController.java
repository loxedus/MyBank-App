package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label; // Import if using labels
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class AccountsController {

    // --- 1. DETAILS POPUP LOGIC (Existing) ---
    @FXML
    public void viewSavings(ActionEvent event) {
        openDetailsPopup("Savings Account", "1234 5678 9012", "$40,000.00", "Active", "Oct 24, 2023");
    }

    @FXML
    public void viewChecking(ActionEvent event) {
        openDetailsPopup("Checking Account", "9876 5432 1098", "$1,500.50", "Active", "Jan 12, 2024");
    }

    private void openDetailsPopup(String type, String number, String balance, String status, String date) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountDetails.fxml"));
            Parent root = loader.load();

            AccountDetailsController controller = loader.getController();
            controller.setAccountDetails(type, number, balance, status, date);

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            if (Main.class.getResource("styles.css") != null) {
                scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
            }
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- 2. SIDEBAR NAVIGATION (THE MISSING PART) ---
    // You need these because the sidebar is present on this screen too!

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
        switchScene(event, "Dashboard.fxml");
    }

    @FXML
    public void switchToAccounts(ActionEvent event) {
        // We are already on Accounts, so do nothing or print a message
        System.out.println("Already on Accounts page");
    }

    @FXML
    public void switchToTransactions(ActionEvent event) throws IOException {
        switchScene(event, "Transactions.fxml");
    }

    @FXML
    public void switchToTransfer(ActionEvent event) throws IOException {
        switchScene(event, "Transfer.fxml"); // Or whatever your file is named
    }

    @FXML
    public void switchToProfile(ActionEvent event) throws IOException {
        switchScene(event, "Profile.fxml");
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        switchScene(event, "Login.fxml");
    }

    // --- Helper Method ---
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        // Re-attach CSS
        if (Main.class.getResource("styles.css") != null) {
            scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
        }
        stage.setScene(scene);
        stage.show();
    }
}