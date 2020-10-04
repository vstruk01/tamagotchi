package world.ucode.main;

import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.pets.Pet;
import world.ucode.view.View;


public class Main extends Application {
    public static Pet pet;

    @Override
    public void start(Stage stage) throws Exception {
        View view = new View(stage);
        View.view(View.SceneType.MENU, "Cute cat of space");
//        primaryStage.setResizable(false);

//        Parent pMenuGame = FXMLLoader.load(getClass().getResource("/menu.fxml"));
//        Parent pGame = FXMLLoader.load(getClass().getResource("/game.fxml"));
//        Parent pLoad = FXMLLoader.load(getClass().getResource("/load.fxml"));
//        Parent pExit = FXMLLoader.load(getClass().getResource("/exit.fxml"));
//        Parent pNewGame = FXMLLoader.load(getClass().getResource("/new_game.fxml"));
//
//
//        Scene sMenuGame = new Scene(pMenuGame);
//        Scene sGame = new Scene(pGame);
//        Scene sLoadGame = new Scene(pLoad);
//        Scene sExit = new Scene(pExit);
//        Scene sNewGame = new Scene(pNewGame);
//
//        scenes.put(SceneType.MENU, sMenuGame);
//        scenes.put(SceneType.GAME, sGame);
//        scenes.put(SceneType.LOAD, sLoadGame);
//        scenes.put(SceneType.EXIT, sExit);
//        scenes.put(SceneType.NEW_GAME, sNewGame);
//
//        primaryStage.setTitle("Cute cat of space");
//        primaryStage.setScene(scenes.get(SceneType.MENU));
//        primaryStage.centerOnScreen();
//        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}