package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FirstStageController {

    Alerts alerts = new Alerts();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okeyButton;

    @FXML
    void okey(MouseEvent event) {
        try {

            Parent root1 = FXMLLoader.load(getClass().getResource("field.fxml"));
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
            stage1.setTitle("Game Клеточки");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) okeyButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void rules(MouseEvent event) {
       alerts.rules();
    }

    @FXML
    void initialize() {

    }
}
