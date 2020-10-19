package world.ucode.Model.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
import world.ucode.Controller.load.Load;
import world.ucode.Model.db.sqlite;
import world.ucode.Controller.game.Game;
import world.ucode.Model.pets.Cat;
import world.ucode.Model.pets.Dog;
import world.ucode.Model.pets.Pet;
import world.ucode.Model.types.Types;
import world.ucode.View.View;
import world.ucode.Model.pets.DefaultPet;

import java.sql.SQLException;
import java.util.ArrayList;

public class GameModel {
    public Pet pet;
    public sqlite sql;
    private Timeline timeLineReduce;
    public Game game;
    public ArrayList<Pet> pets;
    Label[] labels;

    public GameModel() {
        pet = new DefaultPet(Types.GameType.DEFAULT.getValue(), "def");
        game = View.loaders.get(View.SceneType.GAME).getController();
        game.playPage.setVisible(true);
        game.deadPage.setVisible(false);
        try {
            sql = new sqlite();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Pet CreatePet(int petType, int gameType, String petName) {
        return switch (petType) {
            case 1 -> new Dog(gameType, petName);
            case 2 -> new Cat(gameType, petName);
            default -> new DefaultPet(gameType, petName);
        };
    }

    public void loadLoad() {
        pets = sql.getAllPet();
        labels = new Label[pets.size()];

        Load load = View.loaders.get(View.SceneType.LOAD).getController();

        for (int i = 1; i <= pets.size(); i++) {
            Pet petTmp = pets.get(i - 1);
            labels[i - 1] = new Label(petTmp.getName() + "\ttype: " + petTmp.getType() + "\tHP " + petTmp.getHealth() + "\t");
            labels[i - 1].setMinWidth(600);
            labels[i - 1].setMinHeight(100);
            labels[i - 1].setAlignment(Pos.CENTER);
            labels[i - 1].setId(Integer.toString(i));
            labels[i - 1].setOnMouseClicked(me -> {
                 Label curr = (Label)me.getSource();
                 this.pet = pets.get(Integer.parseInt(curr.getId()) - 1);
            });
            AnchorPane.setTopAnchor(labels[i - 1], (double)i * 100);
            load.anchor.setMinHeight((i + 1) * 100);
            load.anchor.getChildren().add(labels[i - 1]);
        }
    }

    public boolean CreateNewPet(int gameType, int petType, String petName) {
        if (sql.isExistsPet(petName))
            return false;
        this.pet = this.CreatePet(petType, gameType, petName);
        sql.addPet(pet);
        return true;
    }

    public void delLoadLabel() {
        Load load = View.loaders.get(View.SceneType.LOAD).getController();
        for (Label label : labels) {
            load.anchor.getChildren().remove(label);
        }
    }

    public void startGame() {
        View.view(View.SceneType.GAME, "Game");
        game = View.loaders.get(View.SceneType.GAME).getController();
        game.playPage.setVisible(true);
        game.deadPage.setVisible(false);
        game.nameScreen.setText(this.pet.getName());
        timeLineReduce = getTimeLineReduce();
        timeLineReduce.play();
    }

    public Timeline getTimeLineReduce() {
        Timeline timeLine = new Timeline(
                new KeyFrame(
                    Duration.millis(200),
                    event -> {
                        reduce();
                    }
                ));
        timeLine.setCycleCount(Timeline.INDEFINITE);
        return timeLine;
    };

    public void StopTimeLine() {
        timeLineReduce.stop();
    }

    public void savePet() {
        sql.savePet(pet);
    }

    public void reduce() {
        pet.setHealth(pet.getHealth() - 1);
        pet.setCleanliness(pet.getCleanliness() - 1);
        pet.setHappiness(pet.getHappiness() - 1);
        pet.setHunger(pet.getHunger() - 1);
        pet.setThirst(pet.getThirst() - 1);
        if (!checkLive()) {
            deadPet();
        }
        drawPoint(pet.getCleanliness(), game.cleanliness);
        drawPoint(pet.getHunger(), game.hunger);
        drawPoint(pet.getHappiness(), game.happiness);
        drawPoint(pet.getThirst(), game.thirst);
        drawPoint(pet.getHealth(), game.health);
    }

    public void drawPoint(double unit, Canvas obj) {
        obj.getGraphicsContext2D().clearRect(0, 0, obj.getWidth(), obj.getHeight());
        obj.getGraphicsContext2D().fillArc(0, 0, obj.getWidth(), obj.getHeight(), 180 - ((unit * pet.getUnitToDegree() - 180) / 2), unit * pet.getUnitToDegree(), ArcType.OPEN);
    }

    public void deadPet() {
        StopTimeLine();
        game.playPage.setVisible(false);
        game.deadPage.setVisible(true);
        sql.deletePet(pet);
    }

    public boolean checkLive() {
        return !(pet.cleanliness < 0) || !(pet.health < 0) || !(pet.hunger < 0) || !(pet.thirst < 0) || !(pet.happiness < 0);
    }
}