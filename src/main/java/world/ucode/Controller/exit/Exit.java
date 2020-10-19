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
            System.exit(0);
        });
        stay.setOnMouseClicked(e -> {
            if (View.lastScene == View.SceneType.GAME) {
                Main.gameModel.startGame();
            } else {
                View.view(View.lastScene, View.lastTitle);
            }
        });
    }
}