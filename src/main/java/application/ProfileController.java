package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;

public class ProfileController {

    // --- Navigation Logic ---
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

    // --- Sidebar Buttons ---
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
    public void switchToTransfer(ActionEvent event) throws IOException {
        switchScene(event, "Transfer.fxml");
    }

    @FXML
    public void switchToProfile(ActionEvent event) throws IOException {
        // Already on Profile, so do nothing
        System.out.println("Already on Profile");
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        switchScene(event, "Login.fxml");
    }

    @FXML
    public void enableEditMode(ActionEvent event) {
        System.out.println("Edit profile was clicked!");
    }

    @FXML
    public void showChangePassword(ActionEvent event) {
        System.out.println("Edit password was clicked!");
    }

    // MAO NI BAG O DIRI NGA METHODS LEE
    @FXML
    public void handleEditProfile(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EditProfile.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Edit Profile");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleChangePassword(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("Change Password");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}