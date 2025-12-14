package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class EditProfileController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;

    @FXML
    public void handleSave(ActionEvent event) {
        // TODO: Save data to database
        System.out.println("Saved Profile: " + nameField.getText());
        JOptionPane.showMessageDialog(null, "Profile Updated Successfully!");
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