package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ChangePasswordController {

    @FXML private PasswordField currentPassField;
    @FXML private PasswordField newPassField;
    @FXML private PasswordField confirmPassField;

    @FXML
    public void handleUpdate(ActionEvent event) {
        String newPass = newPassField.getText();
        String confirmPass = confirmPassField.getText();

        if (!newPass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null, "New passwords do not match!");
            return;
        }

        System.out.println("Password changed successfully.");
        JOptionPane.showMessageDialog(null, "Password Changed!");
        closeWindow(event);
    }

    @FXML
    public void handleCancel(ActionEvent event) {
        closeWindow(event);
    }

    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}