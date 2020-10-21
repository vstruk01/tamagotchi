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
            Main.gameModel.clickSound();
            View.view(View.SceneType.NEW_GAME, "New Game");
        });

        loadGame.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            View.view(View.SceneType.LOAD, "Load Game");
            Main.gameModel.loadLoad();
        });

        leave.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            Main.gameModel.exitGame();
            View.view(View.SceneType.EXIT, "Exit");
        });

        settings.setOnMouseClicked(me -> {
            Main.gameModel.clickSound();
            View.view(View.SceneType.SETTINGS, "settings");
        });

    }
}