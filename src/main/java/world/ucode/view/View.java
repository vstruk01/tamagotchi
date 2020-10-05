package world.ucode.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class View {
    public static enum SceneType {
        MENU,
        NEW_GAME,
        GAME,
        LOAD,
        EXIT,
    };

    public static HashMap<SceneType, Scene> scenes = new HashMap<SceneType, Scene>();
    public static Stage stage;
    public static SceneType lastScene;
    public static String lastTitle;
    public static SceneType currScene;
    public static String currTitle;

    public View(Stage stage) throws IOException {
        this.stage = stage;

        this.stage.setResizable(false);
        if (scenes.isEmpty()) {
            Parent pMenuGame = FXMLLoader.load(getClass().getResource("/menu.fxml"));
            Parent pGame = FXMLLoader.load(getClass().getResource("/game.fxml"));
            Parent pLoad = FXMLLoader.load(getClass().getResource("/load.fxml"));
            Parent pExit = FXMLLoader.load(getClass().getResource("/exit.fxml"));
            Parent pNewGame = FXMLLoader.load(getClass().getResource("/new_game.fxml"));


            Scene sMenuGame = new Scene(pMenuGame);
            Scene sGame = new Scene(pGame);
            Scene sLoadGame = new Scene(pLoad);
            Scene sExit = new Scene(pExit);
            Scene sNewGame = new Scene(pNewGame);

            scenes.put(SceneType.MENU, sMenuGame);
            scenes.put(SceneType.GAME, sGame);
            scenes.put(SceneType.LOAD, sLoadGame);
            scenes.put(SceneType.EXIT, sExit);
            scenes.put(SceneType.NEW_GAME, sNewGame);
        }
    }

    public static void view(SceneType type, String title) {
        lastScene = currScene;
        lastTitle = currTitle;
        currScene = type;
        currTitle = title;
        stage.setTitle(title);
        stage.setScene(scenes.get(type));
        stage.centerOnScreen();
        stage.show();
    }
}