package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane; // Needed for the popups
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransferController implements Initializable {

    // --- UI Elements (Make sure these fx:id match your Scene Builder) ---
    @FXML
    private ComboBox<String> accountSelector;

    @FXML
    private TextField recipientField;

    @FXML
    private TextField amountField;

    @FXML
    private TextArea notesArea;

    @FXML
    private Button transferBtn; // Optional, if you want to disable it later

    // --- Initialize Method ---
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (accountSelector != null) {
            accountSelector.getItems().addAll("Savings Account", "Checking Account");
            accountSelector.getSelectionModel().selectFirst();
        }
    }

    // --- TRANSFER LOGIC ---
    @FXML
    public void handleTransfer(ActionEvent event) {
        // 1. Get the data from the screen
        String recipient = recipientField.getText();
        String amountText = amountField.getText();
        String accountType = accountSelector.getValue();

        // 2. Check for empty fields
        if (recipient.isEmpty() || amountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a recipient and amount.");
            return;
        }

        // 3. Check if the amount is a valid number
        try {
            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                JOptionPane.showMessageDialog(null, "Amount must be positive.");
                return;
            }

            // 4. Success! (Here is where you would subtract money from DB later)
            System.out.println("Transferring $" + amount + " to " + recipient + " from " + accountType);
            JOptionPane.showMessageDialog(null, "Transfer Successful!");

            // 5. Clear the fields
            recipientField.setText("");
            amountField.setText("");
            notesArea.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number for the amount.");
        }
    }

    // --- NAVIGATION METHODS ---

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
}