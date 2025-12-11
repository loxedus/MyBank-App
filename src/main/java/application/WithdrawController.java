package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class WithdrawController {

    @FXML
    private TextField withdrawField;

    @FXML
    private Button withdrawBtn;

    // This runs when you click the Withdraw button
    @FXML
    public void handleWithdraw() {
        String amountText = withdrawField.getText();

        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an amount.");
            return;
        }

        // TODO: Add logic here to subtract money from the Balance
        System.out.println("Withdrawing: " + amountText);

        JOptionPane.showMessageDialog(null, "Withdraw Successful!");
    }
}