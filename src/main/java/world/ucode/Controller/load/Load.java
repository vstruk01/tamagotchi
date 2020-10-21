package world.ucode.Controller.load;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
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
            Main.gameModel.clickSound();
            pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            Main.gameModel.delLoadLabel();
            View.view(View.lastScene, "Cute cat of space");
        });

        play.setOnMouseClicked(e -> {
            if (Main.gameModel.checkChoice()) {
                Main.gameModel.clickSound();
                pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                Main.gameModel.delLoadLabel();
                Main.gameModel.startGame();
            }
        });
    }
}