package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AccountDetailsController {

    // --- UI Labels (Link these in Scene Builder) ---
    @FXML
    private Label typeLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private Label balanceLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label dateLabel;

    // --- 1. METHOD TO RECEIVE DATA ---
    // You call this method right after loading the popup to fill in the info
    public void setAccountDetails(String type, String number, String balance, String status, String date) {
        typeLabel.setText(type);
        numberLabel.setText(number);
        balanceLabel.setText(balance);
        statusLabel.setText(status);
        dateLabel.setText(date);

        // Auto-change color based on status
        if (status.equalsIgnoreCase("Active")) {
            statusLabel.getStyleClass().add("status-active");
        } else {
            statusLabel.getStyleClass().add("status-inactive");
        }
    }

    // --- 2. CLOSE BUTTON ACTION ---
    @FXML
    public void handleClose(ActionEvent event) {
        // Get the current window (stage) and close it
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}