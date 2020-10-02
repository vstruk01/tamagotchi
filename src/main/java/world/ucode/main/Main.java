package world.ucode.main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.HashMap;

public class Main extends Application {
    public static enum SceneType {
        MENU,
        GAME,
        LOAD,
        EXIT,
    };

    Stage primaryStage;
    public static HashMap<SceneType, Scene> scenes = new HashMap<SceneType, Scene>();
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        this.primaryStage = primaryStage;

        Parent pMenuGame = FXMLLoader.load(getClass().getResource("/menu.fxml"));
        Parent pNewGame = FXMLLoader.load(getClass().getResource("/game.fxml"));
        Parent pLoad = FXMLLoader.load(getClass().getResource("/load.fxml"));
        Parent pExit = FXMLLoader.load(getClass().getResource("/exit.fxml"));

        Scene sMenuGame = new Scene(pMenuGame);
        Scene sNewGame = new Scene(pNewGame);
        Scene sLoadGame = new Scene(pLoad);
        Scene sExit = new Scene(pExit);

        scenes.put(SceneType.MENU, sMenuGame);
        scenes.put(SceneType.GAME, sNewGame);
        scenes.put(SceneType.LOAD, sLoadGame);
        scenes.put(SceneType.EXIT, sExit);

        primaryStage.setTitle("Cute cat of space");
        primaryStage.setScene(scenes.get(SceneType.MENU));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}