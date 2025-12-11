package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class SignUpController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink loginLink;

    // 1. Action for the "Sign Up" Button
    @FXML
    public void handleSignUp(ActionEvent event) {
        // Get the data
        String fullName = fullNameField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Basic Check
        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }

        // TODO: Save this data to your database or user list
        System.out.println("New User Registered: " + username);

        JOptionPane.showMessageDialog(null, "Account Created Successfully!");

        // Optional: Automatically go to Login screen after signup
        handleLoginLink(event);
    }

    // 2. Action for the "Already have an account?" Link
    @FXML
    public void handleLoginLink(ActionEvent event) {
        try {
            // Load Login.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            // Get current stage (window) and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading Login screen.");
        }
    }
}