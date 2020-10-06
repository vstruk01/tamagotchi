
package world.ucode.game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import world.ucode.main.Main;
import world.ucode.model.GameModel;
import world.ucode.view.View;

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
    public void initialize() {
        menu.setOnMouseClicked(e -> {
            save.setText("Save");
            Main.gameModel.StopTimeLine();
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
        exit.setOnMouseClicked(e -> {
            save.setText("Save");
            Main.gameModel.StopTimeLine();
            View.view(View.SceneType.EXIT, "Exit");
        });
        save.setOnMouseClicked(e -> {
            save.setText("Saved");
            System.out.println("Saved");
        });

        giveMedicine.setOnMouseClicked(e -> {
            System.out.println("give medicine");
        });
        feed.setOnMouseClicked(e -> {
            System.out.println("feed");
        });
        giveWater.setOnMouseClicked(e -> {
            System.out.println("give Water");
        });
        play.setOnMouseClicked(e -> {
            System.out.println("play");
        });
        cleanUp.setOnMouseClicked(e -> {
            System.out.println("clean Up");
        });
        health.getGraphicsContext2D().setFill(Color.YELLOW);
        hunger.getGraphicsContext2D().setFill(Color.YELLOW);
        thirst.getGraphicsContext2D().setFill(Color.YELLOW);
        happiness.getGraphicsContext2D().setFill(Color.YELLOW);
        cleanliness.getGraphicsContext2D().setFill(Color.YELLOW);
//
//        health.getGraphicsContext2D().fillArc(0, 0, 80, 80, 0, 360, ArcType.OPEN);
//        hunger.getGraphicsContext2D().fillArc(0, 0, 80, 80, 0, 360, ArcType.OPEN);
//        thirst.getGraphicsContext2D().fillArc(0, 0, 80, 80, 0, 360, ArcType.OPEN);
//        happiness.getGraphicsContext2D().fillArc(0, 0, 80, 80, 0, 360, ArcType.OPEN);
//        cleanliness.getGraphicsContext2D().fillArc(0, 0, 80, 80, 0, 360, ArcType.OPEN);

    }
}