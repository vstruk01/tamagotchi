package world.ucode.main;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.model.GameModel;
import world.ucode.view.View;


public class Main extends Application {
    public static GameModel gameModel = new GameModel();

    @Override
    public void start(Stage stage) throws Exception {
        View view = new View(stage);
        View.view(View.SceneType.MENU, "Cute cat of space");
    }

    public static void main(String[] args) {
        launch(args);
    }
}