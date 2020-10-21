package world.ucode.Controller.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import world.ucode.main.Main;
import world.ucode.View.View;

public class MenuController {
    @FXML
    public Label newGame;

    @FXML
    public Label loadGame;

    @FXML
    public Label leave;

    @FXML
    public Label settings;

    @FXML
    public void initialize() {
        newGame.setOnMouseClicked(e -> {
            View.view(View.SceneType.NEW_GAME, "New Game");
        });

        loadGame.setOnMouseClicked(e -> {
            View.view(View.SceneType.LOAD, "Load Game");
            Main.gameModel.loadLoad();
        });

        leave.setOnMouseClicked(e -> {
            View.view(View.SceneType.EXIT, "Exit");
        });

        settings.setOnMouseClicked(me -> {
            System.out.println("settings");
//            View.view(V);
        });

    }
}