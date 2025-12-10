package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    // --- 1. THE ACTION METHOD ---
    public void handleLogin(ActionEvent event) {
        // This is where the code crashes when trying to switch
        try {
            // Call the method that handles the scene swap
            switchToDashboard(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- 2. THE NAVIGATION METHOD ---
    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));

        // This line gets the existing window stage
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        // Create the new scene
        Scene scene = new Scene(root);

        // Crucial: Re-add the CSS style sheet to the new scene!
        scene.getStylesheets().add(Main.class.getResource("styles.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }
}