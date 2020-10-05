
package world.ucode.game;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import world.ucode.view.View;

public class Game {
    @FXML
    Label giveMedicine;
    @FXML
    Label feed;
    @FXML
    Label giveWater;
    @FXML
    Label play;
    @FXML
    Label cleanUp;

    @FXML
    Label exit;
    @FXML
    Label save;
    @FXML
    Label menu;

    @FXML
    Canvas health;
    @FXML
    Canvas hunger;
    @FXML
    Canvas thirst;
    @FXML
    Canvas happiness;
    @FXML
    Canvas cleanliness;

    @FXML
    public void initialize() {
        menu.setOnMouseClicked(e -> {
            save.setText("Save");
            View.view(View.SceneType.MENU, "Cute cat of space");
        });
        exit.setOnMouseClicked(e -> {
            save.setText("Save");
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

        health.getGraphicsContext2D().fillArc(0, 0, 80, 80, 210, 120, ArcType.OPEN);
        hunger.getGraphicsContext2D().fillArc(0, 0, 80, 80, 150, 240, ArcType.OPEN);
        thirst.getGraphicsContext2D().fillArc(0, 0, 80, 80, 170, 200, ArcType.OPEN);
        happiness.getGraphicsContext2D().fillArc(0, 0, 80, 80, 170, 200, ArcType.OPEN);
        cleanliness.getGraphicsContext2D().fillArc(0, 0, 80, 80, 160, 220, ArcType.OPEN);

    }
}