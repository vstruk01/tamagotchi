package world.ucode.Controller.load;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import org.w3c.dom.css.CSS2Properties;
import world.ucode.View.View;
import world.ucode.main.Main;

public class Load {
    @FXML
    public ScrollPane pane;

    @FXML
    public ScrollPane mainPane;


    @FXML
    public AnchorPane anchor;

    @FXML
    public Label play;

    @FXML
    public Label back;

    @FXML
    public void initialize() {
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        mainPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        mainPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        back.setOnMouseClicked(e -> {
            pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            Main.gameModel.delLoadLabel();
            View.view(View.lastScene, "Cute cat of space");
        });

        play.setOnMouseClicked(e -> {
            pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            View.view(View.SceneType.GAME, "game");
            Main.gameModel.delLoadLabel();
            Main.gameModel.startGame();
        });
    }
}