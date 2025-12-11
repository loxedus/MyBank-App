package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable; // NEW: Needed for loading data
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox; // NEW: Needed for the dropdown
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.net.URL; // NEW
import java.util.ResourceBundle; // NEW

// 1. UPDATE CLASS LINE: Add "implements Initializable"
public class WithdrawController implements Initializable {

    // 2. ADD THIS VARIABLE (Make sure fx:id in Scene Builder matches "accountSelector")
    @FXML
    private ComboBox<String> accountSelector;

    @FXML
    private TextField withdrawField;

    @FXML
    private Button withdrawBtn;

    // 3. ADD THIS METHOD: This runs automatically when the popup opens
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // This puts the items into the dropdown
        if (accountSelector != null) {
            accountSelector.getItems().addAll("Savings Account", "Checking Account");
            accountSelector.getSelectionModel().selectFirst(); // Selects "Savings" by default
        }
    }

    // This runs when you click the Withdraw button
    @FXML
    public void handleWithdraw() {
        String amountText = withdrawField.getText();

        // Optional: Get which account was chosen
        String selectedAccount = "";
        if (accountSelector != null) {
            selectedAccount = accountSelector.getValue();
        }

        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an amount.");
            return;
        }

        // TODO: Add logic here to subtract money from the Balance
        System.out.println("Withdrawing: " + amountText + " from " + selectedAccount);

        JOptionPane.showMessageDialog(null, "Withdraw Successful!");
    }
}