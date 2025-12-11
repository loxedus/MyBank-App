package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DepositController {

    @FXML private VBox depositContainer;
    @FXML private Label titleLabel;
    @FXML private TextField amountField;
    @FXML private Button depositButton;
    @FXML private ComboBox<String> accountSelector;

    @FXML
    public void initialize() {
        // 1. Apply Styles
        depositContainer.getStyleClass().add("deposit-card");
        titleLabel.getStyleClass().add("brand-title");
        depositButton.getStyleClass().add("primary-button");
        amountField.getStyleClass().add("text-field");

        // 2. Setup Dropdown Options (UI Job)
        accountSelector.getItems().addAll("Savings Account", "Checking Account");
        accountSelector.getSelectionModel().selectFirst();
    }

    @FXML
    public void onDeposit() {
        // UI STEP 1: Get the text the user typed
        String amountText = amountField.getText();
        String selectedAccount = accountSelector.getValue();

        // UI STEP 2: Basic Validation (Did they leave it empty?)
        if (amountText.isEmpty()) {
            System.out.println("UI ERROR: Input is empty. Show red border or error message.");
            amountField.setStyle("-fx-border-color: red;"); // Visual feedback
            return;
        }

        // UI STEP 3: Reset styles if it was correct
        amountField.setStyle("");

        // UI STEP 4: Handshake with Backend
        // This is where your job ends and his begins.
        System.out.println("--- SENDING TO BACKEND ---");
        System.out.println("Account: " + selectedAccount);
        System.out.println("Amount:  " + amountText);

        // Optional: Close the window automatically after deposit
        Stage stage = (Stage) depositButton.getScene().getWindow();
        stage.close();
    }
}