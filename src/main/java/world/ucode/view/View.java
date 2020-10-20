package world.ucode.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class View {
    public static enum SceneType {
        MENU,
        NEW_GAME,
        GAME_CAT,
        GAME_DOG,
        LOAD,
        EXIT,
    };

    public static HashMap<SceneType, Scene> scenes = new HashMap<SceneType, Scene>();
    public static HashMap<SceneType, FXMLLoader> loaders = new HashMap<SceneType, FXMLLoader>();
    public static Stage stage;
    public static SceneType lastScene;
    public static String lastTitle;
    public static SceneType currScene;
    public static String currTitle;

    public View(Stage stage) throws IOException {
        View.stage = stage;

        View.stage.setResizable(false);
        if (scenes.isEmpty()) {
            this.addScene(SceneType.MENU, "/menu.fxml");
            this.addScene(SceneType.GAME_CAT, "/game.fxml");
            this.addScene(SceneType.LOAD, "/load.fxml");
            this.addScene(SceneType.EXIT, "/exit.fxml");
            this.addScene(SceneType.NEW_GAME, "/new_game.fxml");
            this.addScene(SceneType.GAME_DOG, "/dogGame.fxml");
        }
    }

    private void addScene(SceneType type, String url) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource(url));

            loaders.put(type, loader);
            scenes.put(type, new Scene(loader.load()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
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