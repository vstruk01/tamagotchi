package world.ucode.Controller.exit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import world.ucode.View.View;
import world.ucode.main.Main;

public class Exit {
    @FXML
    Label leave;
    @FXML
    Label stay;

    @FXML
    public void initialize() {
        leave.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            Main.gameModel.leave();
        });
        stay.setOnMouseClicked(e -> {
            Main.gameModel.clickSound();
            if (View.lastScene == View.SceneType.GAME_CAT || View.lastScene == View.SceneType.GAME_DOG) {
                Main.gameModel.startGame();
            } else {
                View.view(View.lastScene, View.lastTitle);
            }
        });
    }
}
