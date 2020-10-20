
package world.ucode.Controller.game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import world.ucode.main.Main;
import world.ucode.Model.model.GameModel;
import world.ucode.View.View;

public class Game {
    @FXML
    public Label giveMedicine;
    @FXML
    public Label feed;
    @FXML
    public Label giveWater;
    @FXML
    public Label play;
    @FXML
    public Label cleanUp;

    @FXML
    public Label exit;
    @FXML
    public Label save;
    @FXML
    public Label menu;

    @FXML
    public Canvas health;
    @FXML
    public Canvas hunger;
    @FXML
    public Canvas thirst;
    @FXML
    public Canvas happiness;
    @FXML
    public Canvas cleanliness;

    @FXML
    public Label nameScreen;
    @FXML
    public Label deadMenu;

    @FXML
    public AnchorPane playPage;
    @FXML
    public AnchorPane deadPage;

    @FXML
    public void initialize() {
        menu.setOnMouseClicked(e -> {
            Main.gameModel.toDifferentScene();
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
        exit.setOnMouseClicked(e -> {
            Main.gameModel.toDifferentScene();
            View.view(View.SceneType.EXIT, "Exit");
        });
        save.setOnMouseClicked(e -> {
            Main.gameModel.savePet();
        });

        giveMedicine.setOnMouseClicked(e -> {
            Main.gameModel.actions(GameModel.actionsEvent.MEDICINE);
        });
        feed.setOnMouseClicked(e -> {
            Main.gameModel.actions(GameModel.actionsEvent.FEED);
        });
        giveWater.setOnMouseClicked(e -> {
            Main.gameModel.actions(GameModel.actionsEvent.WATER);
        });
        play.setOnMouseClicked(e -> {
            Main.gameModel.actions(GameModel.actionsEvent.PLAY);
        });
        cleanUp.setOnMouseClicked(e -> {
            Main.gameModel.actions(GameModel.actionsEvent.CLEAN);
        });

        deadMenu.setOnMouseClicked(e -> {
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
        health.getGraphicsContext2D().setFill(Color.YELLOW);
        hunger.getGraphicsContext2D().setFill(Color.YELLOW);
        thirst.getGraphicsContext2D().setFill(Color.YELLOW);
        happiness.getGraphicsContext2D().setFill(Color.YELLOW);
        cleanliness.getGraphicsContext2D().setFill(Color.YELLOW);
    }
}