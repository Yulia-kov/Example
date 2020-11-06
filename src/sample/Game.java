package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Game {
    public void gameStart(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("firstStage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Game Клеточки");
    }
}
