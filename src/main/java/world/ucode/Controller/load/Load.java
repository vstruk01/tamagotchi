package world.ucode.Controller.load;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.css.CSS2Properties;
import world.ucode.View.View;
import world.ucode.main.Main;

public class Load {
    @FXML
    public AnchorPane anchor;

    @FXML
    public Button play;

    @FXML
    public Button back;

    @FXML
    public void initialize() {
        back.setOnMouseClicked(e -> {
            View.view(View.lastScene, "Cute cat of space");
        });
        play.setOnMouseClicked(e -> {
            View.view(View.SceneType.GAME, "game");
            Main.gameModel.delLoadLabel();
            Main.gameModel.startGame();
        });
    }
}