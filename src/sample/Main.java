package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    Game game = new Game();


    @Override
    public void start(Stage stage) throws Exception {
        game.gameStart(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
