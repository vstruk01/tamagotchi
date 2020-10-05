package world.ucode.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import world.ucode.view.View;

public class MenuController {
    @FXML
    private Label newGame;

    @FXML
    private Label loadGame;

    @FXML
    private Label leave;

    @FXML
    public void initialize() {
        newGame.setOnMouseClicked(e -> {
            View.view(View.SceneType.NEW_GAME, "New Game");
        });

        loadGame.setOnMouseClicked(e -> {
            View.view(View.SceneType.LOAD, "Load Game");
        });

        leave.setOnMouseClicked(e -> {
            View.view(View.SceneType.EXIT, "Exit");
        });

    }
}