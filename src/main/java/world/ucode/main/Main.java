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
        NEW_GAME_CHOICE,
        NEW_GAME_PARAM,
        GAME,
        LOAD,
        EXIT,
    };


    Stage primaryStage;
    public static HashMap<SceneType, Scene> scenes = new HashMap<SceneType, Scene>();
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        stage = primaryStage;
        this.primaryStage = primaryStage;

        Parent pMenuGame = FXMLLoader.load(getClass().getResource("/menu.fxml"));
        Parent pGame = FXMLLoader.load(getClass().getResource("/game.fxml"));
        Parent pLoad = FXMLLoader.load(getClass().getResource("/load.fxml"));
        Parent pExit = FXMLLoader.load(getClass().getResource("/exit.fxml"));
        Parent pNewGameChoice = FXMLLoader.load(getClass().getResource("/new_game_choice.fxml"));
        Parent pNewGameParam = FXMLLoader.load(getClass().getResource("/new_game_param.fxml"));


        Scene sMenuGame = new Scene(pMenuGame);
        Scene sGame = new Scene(pGame);
        Scene sLoadGame = new Scene(pLoad);
        Scene sExit = new Scene(pExit);
        Scene sNewGameChoice = new Scene(pNewGameChoice);
        Scene sNewGameParam = new Scene(pNewGameParam);

        scenes.put(SceneType.MENU, sMenuGame);
        scenes.put(SceneType.GAME, sGame);
        scenes.put(SceneType.LOAD, sLoadGame);
        scenes.put(SceneType.EXIT, sExit);
        scenes.put(SceneType.NEW_GAME_CHOICE, sNewGameChoice);
        scenes.put(SceneType.NEW_GAME_PARAM, sNewGameParam);

        primaryStage.setTitle("Cute cat of space");
        primaryStage.setScene(scenes.get(SceneType.MENU));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}